package org.example.article.port.filters;


import com.rcore.domain.commons.port.dto.SearchFilters;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ArticleFilters extends SearchFilters{

    private String description;

    private String title;
}
