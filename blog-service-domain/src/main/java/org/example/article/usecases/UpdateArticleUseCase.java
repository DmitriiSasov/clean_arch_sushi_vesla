package org.example.article.usecases;

import com.rcore.domain.commons.usecase.AbstractUpdateUseCase;
import com.rcore.domain.commons.usecase.UseCase;
import com.rcore.domain.commons.usecase.model.SingletonEntityOutputValues;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.article.entity.ArticleEntity;
import org.example.article.exceptions.ArticleNotFoundException;
import org.example.article.port.ArticleRepository;

import java.time.Instant;

public class UpdateArticleUseCase extends AbstractUpdateUseCase<ArticleEntity, ArticleRepository, UpdateArticleUseCase.InputValues> {


    public UpdateArticleUseCase(ArticleRepository repository) {
        super(repository);
    }

    @Override
    public SingletonEntityOutputValues<ArticleEntity> execute(InputValues inputValues) {
        ArticleEntity entity = repository.findById(inputValues.getId()).orElseThrow(ArticleNotFoundException::new);
        entity.setDescription(inputValues.getDescription());
        entity.setTitle(inputValues.getTitle());
        entity.setUpdatedAt(Instant.now());

        entity = repository.save(entity);

        return SingletonEntityOutputValues.of(entity);
    }

    @NoArgsConstructor
    @Data
    public static class InputValues implements UseCase.InputValues {
        protected String id;

        protected String title;

        protected String description;
    }
}
