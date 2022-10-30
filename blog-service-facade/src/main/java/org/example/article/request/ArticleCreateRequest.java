package org.example.article.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.article.commons.request.BusinessLogicArticleFieldsRequest;

@Schema(name = "Создание Article")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateRequest extends BusinessLogicArticleFieldsRequest {
}
