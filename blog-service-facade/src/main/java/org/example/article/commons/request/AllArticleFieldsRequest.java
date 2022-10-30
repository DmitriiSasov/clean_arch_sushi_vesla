package org.example.article.commons.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllArticleFieldsRequest extends BusinessLogicArticleFieldsRequest{

    private String id;
}
