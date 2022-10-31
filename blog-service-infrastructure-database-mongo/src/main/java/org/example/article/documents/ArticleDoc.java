package org.example.article.documents;

import com.rcore.database.mongo.commons.document.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleDoc extends BaseDocument {

    protected String title;

    protected String description;

}
