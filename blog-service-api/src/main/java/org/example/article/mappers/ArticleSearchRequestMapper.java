package org.example.article.mappers;

import org.example.article.port.filters.ArticleFilters;
import org.example.article.request.SearchArticleCollectionRequest;

public class ArticleSearchRequestMapper {

    public static ArticleFilters toFilters(SearchArticleCollectionRequest request) {
        return ArticleFilters.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .limit(request.getLimit())
                .offset(request.getOffset())
                .query(request.getQuery())
                .sortDirection(request.getSortDirection())
                .sortName(request.getSortName())
                .build();
    }
}
