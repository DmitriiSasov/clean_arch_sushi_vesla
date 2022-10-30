package org.example.article.request;

import com.rcore.rest.api.commons.request.SearchApiRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "Получение всех Articles, которые содержат в своем описании description")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchArticleCollectionRequest extends SearchApiRequest {

    private String description;

    private String title;
}
