package it.home.starter.customstarter.autoconfigure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import it.home.starter.customstarter.properties.OpenApiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OpenApiProperties.class)
@OpenAPIDefinition(servers = {@Server(url = "${custom.openapi.server:http://localhost:8080}")}, info = @Info(title = "${custom.openapi.title:}", version = "1.0", description = "${custom.openapi.description:}"))
//@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(authorizationCode = @OAuthFlow(authorizationUrl = "${custom.openapi.authorization-url}", tokenUrl = "${custom.openapi.token-url}", scopes = {@OAuthScope(name = "openid"), @OAuthScope(name = "roles")})))
public class OpenApiAutoConfiguration {
}

