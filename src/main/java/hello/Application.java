package hello;

import java.util.Arrays;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import hello.repositories.ApplicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, ApplicationRepository applicationRepository) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
            System.out.println("Applications:");
            applicationRepository.findAll().forEach(System.out::println);
        };
    }

//    not found UPPER CASE strategy
//    @Bean
//    public Jackson2ObjectMapperBuilder jacksonBuilder() {
//        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
//        b.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//        return b;
//    }

}
