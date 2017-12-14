package com.nalbam.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name:nalbam}")
    private String name;

    @Value("${spring.profiles.active:default}")
    private String profile;

    @Bean
    public Docket api() {
        final String title;
        if ("prod".equals(this.profile)) {
            title = this.name;
        } else {
            title = this.name + "-" + this.profile;
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nalbam"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(Pageable.class)
                .apiInfo(new ApiInfo(title, "", "", "", ApiInfo.DEFAULT_CONTACT, "", "", new ArrayList<>()));
    }

}
