package it.home.starter.customstarter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "custom.openapi")
@Getter
@Setter
public class OpenApiProperties {

    /**
     * OpenAPI server
     * */
    private String server;

    /**
     * OpenAPI title
     * */
    private String title;

    /**
     * OpenAPI description
     * */
    private String description;

    /**
     * OpenAPI security authorization URL
     * */
    private String authorizationUrl;

    /**
     * OpenAPI security token URL
     * */
    private String tokenUrl;


}
