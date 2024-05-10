package com.so.soconfig.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.so.soconfig.client.annotation.EnableSoConfig;
import com.so.soconfig.demo.config.SoDemoConfig;

@SpringBootApplication
@EnableConfigurationProperties({SoDemoConfig.class})
@RestController
@EnableSoConfig
public class SoconfigDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SoconfigDemoApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SoconfigDemoApplication.class, args);
        System.out.println(" &&&& ====> " + applicationContext.getBean(ConfigurationPropertiesRebinder.class));
    }

    @Autowired
    Environment env;

    @Autowired
    SoDemoConfig soDemoConfig;

    @Value("${so.a}")
    private String a;

    @Value("${so.b}")
    private String b;


    @Bean
    ApplicationRunner  applicationRunner() {
        System.out.println(Arrays.toString(env.getActiveProfiles()));
        return args -> {
            System.out.println("hello world");
            System.out.println(a);
            System.out.println(soDemoConfig.getA());
        };
    }

}
