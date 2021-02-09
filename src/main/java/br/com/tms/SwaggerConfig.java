package br.com.tms;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;


@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.data}")
    private String appLastDate;

    @Value("${info.app.version}")
    private String appCurrentVersion;

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error"))).build().apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                // .securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
                .genericModelSubstitutes(Optional.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appName)
                .description(itensApp())
                .termsOfServiceUrl("")
                .licenseUrl("none")
                .version(appLastDate.concat(" - ").concat(appCurrentVersion))
                .build();
    }

    private String itensApp() {
        StringBuilder sb = new StringBuilder();
        sb.append(appDescription).append("<br/>");
        sb.append("<h3>Terminais</h3>");
        sb.append(" <i>Itens disponíveis</i><br/> ");
        sb.append(" - Cadastrar/Editar/Listar<br/>");
        return sb.toString();
    }
}
