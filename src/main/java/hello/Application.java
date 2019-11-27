package hello;

import hello.repositories.ApplicationRepository;
import hello.repository.TaxTradeRepositoryCustom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, ApplicationRepository applicationRepository, TaxTradeRepositoryCustom taxTradeRepositoryCustom) {
        return args -> {
            //System.out.println("Let's inspect the beans provided by Spring Boot:");
            //Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
            //System.out.println("Applications:");
            //applicationRepository.findAll().forEach(System.out::println);
            System.out.println(taxTradeRepositoryCustom.resetMatchedQtyAfterTradeDateTime());
        };
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    not found UPPER CASE strategy
//    @Bean
//    public Jackson2ObjectMapperBuilder jacksonBuilder() {
//        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
//        b.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//        return b;
//    }

}
