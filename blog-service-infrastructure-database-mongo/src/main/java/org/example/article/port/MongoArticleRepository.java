package org.example.article.port;

import com.rcore.database.mongo.commons.port.impl.AbstractMongoRepository;
import com.rcore.database.mongo.commons.query.AbstractExampleQuery;
import org.example.article.documents.ArticleDoc;
import org.example.article.entity.ArticleEntity;
import org.example.article.mappers.ArticleMapper;
import org.example.article.port.filters.ArticleFilters;
import org.example.article.query.FindWithFiltersQuery;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoArticleRepository extends AbstractMongoRepository<String, ArticleEntity, ArticleDoc, ArticleFilters> implements ArticleRepository{


    public MongoArticleRepository(ArticleMapper mapper, MongoTemplate mongoTemplate) {
        super(ArticleDoc.class, mapper, mongoTemplate);
    }

    @Override
    protected AbstractExampleQuery getSearchQuery(ArticleFilters articleFilters) {
        return new FindWithFiltersQuery(articleFilters);
    }
}
