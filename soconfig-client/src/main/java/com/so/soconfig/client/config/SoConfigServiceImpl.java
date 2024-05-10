package com.so.soconfig.client.config;

import java.util.Map;

import org.springframework.context.ApplicationContext;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
public class SoConfigServiceImpl implements SoConfigService {

    Map<String, String> config;
    ApplicationContext applicationContext;

    public SoConfigServiceImpl(ApplicationContext applicationContext, Map<String, String> config) {
        this.applicationContext = applicationContext;
        this.config = config;
    }
    @Override
    public String[] getPropertyNames() {
        return this.config.keySet().toArray(new String[0]);
    }

    @Override
    public String getProperty(String name) {
        return this.config.get(name);
    }
}
