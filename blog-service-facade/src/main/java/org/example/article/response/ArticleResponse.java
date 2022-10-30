package org.example.article.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.article.commons.response.AllArticleFieldsResponse;

@Schema(name = "Article")
@Getter
@Setter
@SuperBuilder
public class ArticleResponse extends AllArticleFieldsResponse {


}
