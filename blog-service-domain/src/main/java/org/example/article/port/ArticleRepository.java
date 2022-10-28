package org.example.article.port;

import com.rcore.domain.commons.port.CRUDRepository;
import org.example.article.entity.ArticleEntity;
import org.example.article.port.filters.ArticleFilters;

public interface ArticleRepository extends CRUDRepository<String, ArticleEntity, ArticleFilters> {
}
