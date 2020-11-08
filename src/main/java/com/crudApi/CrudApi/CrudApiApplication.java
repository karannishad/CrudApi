package com.crudApi.CrudApi;

<<<<<<< HEAD
import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
=======
import io.micrometer.core.instrument.config.MeterFilter;
>>>>>>> d8d23ff...  clean up and prometheus custom configs
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
<<<<<<< HEAD
public class CrudApiApplication {

	public static void main(String[] args) throws InterruptedException{

		SpringApplication.run(CrudApiApplication.class, args);
	}
=======
@EnableSwagger2

public class CrudApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(CrudApiApplication.class, args);

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).tags(new Tag("t2", "t1"), new Tag("t2", "t2"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crudApi.CrudApi.controller"))
                .build().host("hh");

    }
    @Bean
    public MeterFilter excludeTomcatFilter() {
        return MeterFilter.denyNameStartsWith("tomcat");
    }
>>>>>>> d8d23ff...  clean up and prometheus custom configs

}
