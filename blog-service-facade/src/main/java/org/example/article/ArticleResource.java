package org.example.article;

import com.rcore.rest.api.commons.response.OkApiResponse;
import com.rcore.rest.api.commons.response.SearchApiResponse;
import com.rcore.rest.api.commons.response.SuccessApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.article.request.ArticleCreateRequest;
import org.example.article.request.ArticleUpdateRequest;
import org.example.article.request.SearchArticleCollectionRequest;
import org.example.article.response.ArticleResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Article API", description = "Article")
public interface ArticleResource {

    @Operation(summary = "Создание Article")
    @PostMapping(value = Routes.CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
    OkApiResponse articleCreate(@RequestBody ArticleCreateRequest request);

    @Operation(summary = "Обновление уже существующей Article")
    @PutMapping(value = Routes.UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
    OkApiResponse articleUpdate(@RequestBody ArticleUpdateRequest request);

    @Operation(summary = "Поиск Article по id")
    @GetMapping(value = Routes.SINGLETON, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<ArticleResponse> getArticleSingleton(@PathVariable("id") String id);

    @Operation(summary = "Поиск Articles по описанию (description и title)")
    @GetMapping(value = Routes.COLLECTION, produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessApiResponse<SearchApiResponse<ArticleResponse>> getArticleCollection(SearchArticleCollectionRequest request);

    @Operation(summary = "Удаление Article по id")
    @DeleteMapping(value = Routes.SINGLETON, produces = MediaType.APPLICATION_JSON_VALUE)
    OkApiResponse deleteArticle(@PathVariable String id);

}
