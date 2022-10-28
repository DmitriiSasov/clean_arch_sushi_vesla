package org.example.article.usecases;

import com.rcore.domain.commons.usecase.AbstractFindByIdUseCase;
import org.example.article.entity.ArticleEntity;
import org.example.article.port.ArticleRepository;

public class FindArticleByIdUseCase extends AbstractFindByIdUseCase<String, ArticleEntity, ArticleRepository> {
    public FindArticleByIdUseCase(ArticleRepository repository) {
        super(repository);
    }
}
