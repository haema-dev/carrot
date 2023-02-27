package auction.carrot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;


@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    /*private ServletContext context;

    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("auction.carrot.auction.adapter.in"))
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }*/

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("Carrot Auction API")
                .description("Carrot Auction API Docs").build();
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.ignoredParameterTypes(Context.class, Pageable.class, RepositoryCommand.class)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("auction.carrot"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }
}
