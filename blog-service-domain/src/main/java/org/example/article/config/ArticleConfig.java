package org.example.article.config;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.example.article.port.ArticleIdGenerator;
import org.example.article.port.ArticleRepository;
import org.example.article.usecases.*;

@Getter
@Accessors(fluent = true)
public class ArticleConfig {

    private final CreateArticleUseCase createArticleUseCase;

    private final DeleteArticleUseCase deleteArticleUseCase;

    private final FindArticleByFiltersUseCase findArticleByFiltersUseCase;

    private final FindArticleByIdUseCase findArticleByIdUseCase;

    private final UpdateArticleUseCase updateArticleUseCase;

    public ArticleConfig(ArticleRepository repository, ArticleIdGenerator<?> idGenerator) {
        this.createArticleUseCase = new CreateArticleUseCase(repository, idGenerator);
        this.deleteArticleUseCase = new DeleteArticleUseCase(repository);
        this.findArticleByIdUseCase = new FindArticleByIdUseCase(repository);
        this.findArticleByFiltersUseCase = new FindArticleByFiltersUseCase(repository);
        this.updateArticleUseCase = new UpdateArticleUseCase(repository);
    }
}
