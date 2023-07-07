package com.demo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
@SpringBootApplication
@Slf4j
public class App implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("aman");
    }
}
