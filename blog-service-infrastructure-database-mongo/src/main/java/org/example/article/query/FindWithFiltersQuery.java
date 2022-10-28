package org.example.article.query;

import com.rcore.database.mongo.commons.query.AbstractExampleQuery;
import org.example.article.port.filters.ArticleFilters;
import org.springframework.data.mongodb.core.query.Criteria;

public class FindWithFiltersQuery extends AbstractExampleQuery {

    private final ArticleFilters articleFilters;

    public FindWithFiltersQuery(ArticleFilters filters) {
        super(filters);
        articleFilters = filters;
    }

    @Override
    public Criteria getCriteria() {
        return Criteria.where("description").regex(".*" + articleFilters.getDescription() + ".*");
    }
}
