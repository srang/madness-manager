package org.srang.madness.manager;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@Log
public class ManagerApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo() {
                return (args) -> {
                    String cryptedPassword = new BCryptPasswordEncoder().encode("password");
                    log.warning(cryptedPassword);
                };
            }
}
