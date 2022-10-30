package org.example.article.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.article.commons.request.AllArticleFieldsRequest;

@Schema(name = "Обновление Article")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateRequest extends AllArticleFieldsRequest {

}
