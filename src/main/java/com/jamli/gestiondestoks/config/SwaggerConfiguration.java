package com.jamli.gestiondestoks.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.jamli.gestiondestoks.utils.Constants.APP_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

//    public Docket api(){
//       return new Docket(DocumentationType.SWAGGER_2)
//               .apiInfo(
//                       new ApiInfoBuilder()
//                               .description("Gestion de Stock Api Documentation")
//                               .title("Gestion de stock REST API")
//                               .build()
//                               )
//               .groupName("REST API v1")
//               .select()
//               .apis(RequestHandlerSelectors.basePackage("com.jamli.gestiondestoks"))
//               .paths(PathSelectors.ant(APP_ROOT +  "/**"))
//               .build();
//    }

}
