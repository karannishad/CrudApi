package com.crudApi.CrudApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CrudApiApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(CrudApiApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).tags(new Tag("t2", "t1"), new Tag("t2", "t2"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crudApi.CrudApi.controller"))
                .build().host("hh");

    }



}
