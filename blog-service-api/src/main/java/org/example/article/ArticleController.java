package org.example.article;

import com.rcore.domain.commons.usecase.UseCaseExecutor;
import com.rcore.domain.commons.usecase.model.FiltersInputValues;
import com.rcore.domain.commons.usecase.model.IdInputValues;
import com.rcore.rest.api.commons.response.OkApiResponse;
import com.rcore.rest.api.commons.response.SearchApiResponse;
import com.rcore.rest.api.commons.response.SuccessApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.article.config.ArticleConfig;
import org.example.article.exceptions.ArticleNotFoundException;
import org.example.article.mappers.ArticleResponseMapper;
import org.example.article.mappers.ArticleSearchRequestMapper;
import org.example.article.request.ArticleCreateRequest;
import org.example.article.request.ArticleUpdateRequest;
import org.example.article.request.SearchArticleCollectionRequest;
import org.example.article.response.ArticleResponse;
import org.example.article.usecases.CreateArticleUseCase;
import org.example.article.usecases.UpdateArticleUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ArticleController implements ArticleResource{

    private final UseCaseExecutor useCaseExecutor;

    private final ArticleConfig articleConfig;


    @Override
    public OkApiResponse articleCreate(ArticleCreateRequest request) {
        return useCaseExecutor.execute(articleConfig.createArticleUseCase(),
                CreateArticleUseCase.InputValues.of(request.getTitle(), request.getDescription()),
                (output) -> new OkApiResponse());
    }

    @Override
    public OkApiResponse articleUpdate(ArticleUpdateRequest request) {
        return useCaseExecutor.execute(articleConfig.updateArticleUseCase(),
                UpdateArticleUseCase.InputValues.of(request.getId(), request.getTitle(), request.getDescription()),
                (output) -> new OkApiResponse());
    }

    @Override
    public SuccessApiResponse<ArticleResponse> getArticleSingleton(String id) {
        return useCaseExecutor.execute(articleConfig.findArticleByIdUseCase(),
                IdInputValues.of(id),
                o -> o.getEntity().map(entity -> SuccessApiResponse.of(ArticleResponseMapper.map(entity)))
                        .orElseThrow(ArticleNotFoundException::new));
    }

    @Override
    public SuccessApiResponse<SearchApiResponse<ArticleResponse>> getArticleCollection(SearchArticleCollectionRequest request) {
        return useCaseExecutor.execute(
                articleConfig.findArticleByFiltersUseCase(),
                FiltersInputValues.of(ArticleSearchRequestMapper.toFilters(request)),
                o -> SuccessApiResponse.of(
                        SearchApiResponse.withItemsAndCount(o.getResult().getItems()
                            .stream()
                            .map(ArticleResponseMapper::map)
                            .collect(Collectors.toList()),
                        o.getResult().getCount())
                )
        );
    }

    @Override
    public OkApiResponse deleteArticle(String id) {
        return useCaseExecutor.execute(
                articleConfig.deleteArticleUseCase(),
                IdInputValues.of(id),
                o -> new OkApiResponse()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String commonExceptionHandle(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return e.getMessage();
    }
}
