package org.example.article.config;

import com.rcore.domain.commons.usecase.UseCaseExecutor;
import com.rcore.domain.commons.usecase.impl.ValidatingUseCaseExecutor;
import org.example.article.port.ArticleIdGenerator;
import org.example.article.port.ArticleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validator;

@Configuration
public class AppConfig {

    @Bean
    public UseCaseExecutor useCaseExecutor(Validator validator) {
        return new ValidatingUseCaseExecutor(validator);
    }

    @Bean
    public ArticleConfig articleConfig(ArticleRepository articleRepository,
                                       ArticleIdGenerator<?> articleIdGenerator){
        return new ArticleConfig(articleRepository, articleIdGenerator);
    }
}
