package br.com.lucasdanfer.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class AppConfig {
    
    public static void main(String[] args){
        SpringApplication.run(AppConfig.class, args);
    }
    
}
