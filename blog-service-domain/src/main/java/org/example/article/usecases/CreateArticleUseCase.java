package org.example.article.usecases;

import com.rcore.domain.commons.usecase.AbstractCreateUseCase;
import com.rcore.domain.commons.usecase.UseCase;
import com.rcore.domain.commons.usecase.model.SingletonEntityOutputValues;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.article.entity.ArticleEntity;
import org.example.article.port.ArticleIdGenerator;
import org.example.article.port.ArticleRepository;

import java.time.Instant;

public class CreateArticleUseCase extends AbstractCreateUseCase<ArticleEntity, ArticleIdGenerator<?>, ArticleRepository, CreateArticleUseCase.InputValues> {

    public CreateArticleUseCase(ArticleRepository repository, ArticleIdGenerator<?> idGenerator) {
        super(repository, idGenerator);
    }

    @Override
    public SingletonEntityOutputValues<ArticleEntity> execute(InputValues inputValues) {
        ArticleEntity article = new ArticleEntity(idGenerator.generate());
        article.setTitle(inputValues.getTitle());
        article.setDescription(inputValues.getDescription());

        article = repository.save(article);

        return SingletonEntityOutputValues.of(article);
    }

    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor(staticName = "empty")
    @Builder
    @Data
    public static class InputValues implements UseCase.InputValues {
        protected String title;
        protected String description;
    }
}
