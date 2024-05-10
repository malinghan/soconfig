package com.so.soconfig.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
@Data
@ConfigurationProperties(prefix = "so")
public class SoDemoConfig {
    String a;
    String b;
}
