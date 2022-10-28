package org.example.article.exceptions;

import com.rcore.domain.commons.exception.NotFoundDomainException;
import org.example.Domain;

public class ArticleNotFoundException extends NotFoundDomainException {

    public ArticleNotFoundException() {
        super(
                Domain.ARTICLE,
                ArticleErrorReason.NOT_FOUND,
                "Article not found"
                );
    }
}
