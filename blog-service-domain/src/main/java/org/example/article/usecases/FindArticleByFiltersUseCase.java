package org.example.article.usecases;

import com.rcore.domain.commons.usecase.AbstractFindWithFiltersUseCase;
import com.rcore.domain.commons.usecase.model.FiltersInputValues;
import com.rcore.domain.commons.usecase.model.SearchResultEntityOutputValues;
import org.example.article.entity.ArticleEntity;
import org.example.article.port.ArticleRepository;
import org.example.article.port.filters.ArticleFilters;

public class FindArticleByFiltersUseCase extends AbstractFindWithFiltersUseCase<ArticleEntity, ArticleFilters, ArticleRepository> {
    public FindArticleByFiltersUseCase(ArticleRepository repository) {
        super(repository);
    }

    @Override
    public SearchResultEntityOutputValues<ArticleEntity> execute(FiltersInputValues<ArticleFilters> inputValues) {
        return super.execute(inputValues);
    }
}
