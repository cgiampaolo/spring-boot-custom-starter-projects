package it.home.starter.springbootautoconfigure.autoconfigure;

import it.home.starter.springbootautoconfigure.properties.SwaggerConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;

@Slf4j
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerConfigProperties.class)
public class SwaggerConfigAutoConfiguration {

    private final SwaggerConfigProperties swaggerConfigProperties;

    public SwaggerConfigAutoConfiguration(SwaggerConfigProperties swaggerConfigProperties) {
        this.swaggerConfigProperties = swaggerConfigProperties;
    }

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                //.securitySchemes(Arrays.asList(securityScheme()))
                //.securityContexts(Arrays.asList(securityContext()))
                .apiInfo(getApiInfo()).host(swaggerConfigProperties.getApiUrl()).protocols(new HashSet<>(swaggerConfigProperties.getHttpSchemas()));
    }

    public ApiInfo getApiInfo() {
        return new ApiInfo(
                swaggerConfigProperties.getTitle(),
                swaggerConfigProperties.getDescription(),
                swaggerConfigProperties.getVersion(),
                "",
                new Contact(swaggerConfigProperties.getContactName(), swaggerConfigProperties.getContactUrl(), swaggerConfigProperties.getContactEmail()),
                swaggerConfigProperties.getLicense(), swaggerConfigProperties.getLicenseUrl(), Collections.emptyList());
    }

}
