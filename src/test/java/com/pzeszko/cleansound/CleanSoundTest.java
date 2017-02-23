package com.pzeszko.cleansound;

import com.pzeszko.cleansound.config.SecurityConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by Pawel on 2017-02-16.
*/
@EntityScan(basePackageClasses = {
        CleansoundApplication.class,
})
@SpringBootApplication
@Import({SecurityConfiguration.class})
@ComponentScan("com.pzeszko.cleansound")
public class CleanSoundTest {
}
