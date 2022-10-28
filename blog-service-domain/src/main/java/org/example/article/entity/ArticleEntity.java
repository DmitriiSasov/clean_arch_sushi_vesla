package org.example.article.entity;

import com.rcore.domain.commons.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Data
public class ArticleEntity extends BaseEntity<String> {

    private String title;

    private String description;

    public ArticleEntity(String id) {
        this.id = id;
    }
}
