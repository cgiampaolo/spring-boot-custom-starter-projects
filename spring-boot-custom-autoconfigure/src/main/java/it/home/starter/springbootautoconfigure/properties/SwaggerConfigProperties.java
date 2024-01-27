package it.home.starter.springbootautoconfigure.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties("springfox.custom")
public class SwaggerConfigProperties {
    private List<String> httpSchemas = List.of("http");

    private String apiUrl = "localhost:8080";
    private String contactEmail = "c.giampaolo30@gmail.com";
    private String contactName = "Claudio Giampaolo";
    private String contactUrl = "linkedin";
    private String description = "Rest AutoConfiguration Description";
    private String license = "Apache 2.0";
    private String licenseUrl = "licence url";
    private String title = "Rest AutoConfiguration";
    private String version = "0.0.1-SNAPSHOT";


}
