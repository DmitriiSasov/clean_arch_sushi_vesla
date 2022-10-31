package org.example.article.query;

import com.rcore.database.mongo.commons.query.AbstractExampleQuery;
import org.example.article.port.filters.ArticleFilters;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Optional;

public class FindWithFiltersQuery extends AbstractExampleQuery {

    private final ArticleFilters articleFilters;

    public FindWithFiltersQuery(ArticleFilters filters) {
        super(filters);
        articleFilters = filters;
    }

    @Override
    public Criteria getCriteria() {
        Criteria c = null;
        if (articleFilters.getDescription() != null && !articleFilters.getDescription().isBlank()) {
            c = Criteria.where("description").regex(".*" + articleFilters.getDescription() + ".*");
        }
        if (articleFilters.getTitle() != null && !articleFilters.getTitle().isBlank()) {
            Criteria tmp = Criteria.where("title").regex(".*" + articleFilters.getTitle() + ".*");
            if (c == null) {
                c = tmp;
            } else {
                c = c.andOperator(tmp);
            }

        }
        return c;

    }
}
