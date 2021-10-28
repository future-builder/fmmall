package cdu.mayong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);//指定文档风格

        ApiInfo apiInfo = new ApiInfoBuilder()
                        .title("《锋迷商城》后端接口说明")
                        .description("this article is description of the api of fmmall")
                        .version("V 1.0")
                        .contact(new Contact("MaYong", "www.mayong.cdu", "97792921@qq.com"))
                        .build();

        docket.apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cdu.mayong.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
