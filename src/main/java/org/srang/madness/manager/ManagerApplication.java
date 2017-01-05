package org.srang.madness.manager;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@Log
public class ManagerApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
//    @Bean
//    public CommandLineRunner demo(BracketService service) {
//                return (args) -> {
//                    log.warning(service.generateMatchups().toString());
//                };
//            }
}
