package com.pzeszko.cleansound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Pawel on 2017-01-02.
 */

@SpringBootApplication
@ComponentScan("com.pzeszko.cleansound")
public class CleansoundApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleansoundApplication.class, args);
    }
}
