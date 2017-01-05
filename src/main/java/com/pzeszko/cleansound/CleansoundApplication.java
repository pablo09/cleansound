package com.pzeszko.cleansound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Pawel on 2017-01-02.
 */

@EntityScan(basePackageClasses = {
        CleansoundApplication.class
})
@SpringBootApplication
@ComponentScan("com.pzeszko.cleansound")
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
public class CleansoundApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleansoundApplication.class, args);
    }
}
