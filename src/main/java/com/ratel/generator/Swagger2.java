package com.ratel.generator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @业务描述：
 * @package_name： com.ratel.generator
 * @project_name： mybatis-plus-generator
 * @author： ratelfu@qq.com
 * @create_time： 2019-05-14 17:01
 * @copyright (c) ratelfu 版权所有
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ratel.generator.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多相关文章请关注：https://blog.csdn.net/weter_drop/")
                .termsOfServiceUrl("https://blog.csdn.net/weter_drop/")
                .contact("ratelfu")
                .version("1.0")
                .build();
    }

}