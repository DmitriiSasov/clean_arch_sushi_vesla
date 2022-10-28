package org.example.article.usecases;

import com.rcore.domain.commons.usecase.AbstractDeleteUseCase;
import org.example.article.port.ArticleRepository;

public class DeleteArticleUseCase extends AbstractDeleteUseCase<String, ArticleRepository> {
    public DeleteArticleUseCase(ArticleRepository repository) {
        super(repository);
    }
}
