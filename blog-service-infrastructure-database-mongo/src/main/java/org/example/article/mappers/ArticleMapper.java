package org.example.article.mappers;

import com.rcore.commons.mapper.ExampleDataMapper;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.example.article.documents.ArticleDoc;
import org.example.article.entity.ArticleEntity;
import org.example.article.port.ArticleIdGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArticleMapper implements ExampleDataMapper<ArticleEntity, ArticleDoc> {

    private final ArticleIdGenerator<ObjectId> idGenerator;

    @Override
    public ArticleDoc map(ArticleEntity articleEntity) {
        return ArticleDoc
                .builder()
                .id(idGenerator.parse(articleEntity.getId()))
                .title(articleEntity.getTitle())
                .description(articleEntity.getDescription())
                .createdAt(articleEntity.getCreatedAt())
                .updatedAt(articleEntity.getUpdatedAt())
                .build();
    }

    @Override
    public ArticleEntity inverseMap(ArticleDoc articleDoc) {
        return ArticleEntity
                .builder()
                .id(articleDoc.getId().toString())
                .title(articleDoc.getTitle())
                .description(articleDoc.getDescription())
                .updatedAt(articleDoc.getUpdatedAt())
                .createdAt(articleDoc.getCreatedAt())
                .build();
    }
}
