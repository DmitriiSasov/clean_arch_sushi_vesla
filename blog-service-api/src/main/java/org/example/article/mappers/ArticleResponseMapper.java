package org.example.article.mappers;

import org.example.article.entity.ArticleEntity;
import org.example.article.response.ArticleResponse;

public class ArticleResponseMapper {

    public static ArticleResponse map(ArticleEntity entity) {
        return ArticleResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .createAt(entity.getCreatedAt())
                .updateAt(entity.getUpdatedAt())
                .build();
    }
}
