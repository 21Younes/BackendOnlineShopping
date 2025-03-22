package com.example.onlineshopping;

import com.example.onlineshopping.Model.Category;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Online Shopping API", version = "v1", description = "API for online shopping system"))
@RestController
public class OnlineshoppingApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnlineshoppingApplication.class, args);

    }


}
