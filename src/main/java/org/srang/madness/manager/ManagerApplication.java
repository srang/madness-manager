package org.srang.madness.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class ManagerApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}
