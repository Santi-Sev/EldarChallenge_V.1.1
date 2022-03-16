package com.Eldar.EldarChallenge.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean //es muy importante esta etiqueta para que Spring pueda LEVANTAR este codigo
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Credit Card Processor API",
                "This API provides all methods required to process Credit Card Operations",
                "1.0",
                "TERMS OF SERVICE URL",
                new springfox.documentation.service.Contact("SantiSev","https://www.linkedin.com/in/santiago-sevitz/","santisevitz@hotmail.com"),
                "LICENSE","LICENSE URL", Collections.emptyList());
    }
}
