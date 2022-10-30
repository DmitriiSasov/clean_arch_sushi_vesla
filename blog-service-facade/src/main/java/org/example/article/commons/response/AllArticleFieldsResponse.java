package org.example.article.commons.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
public class AllArticleFieldsResponse {

    private String id;

    private String title;

    private String description;

    private Instant createAt;

    private Instant updateAt;

}
