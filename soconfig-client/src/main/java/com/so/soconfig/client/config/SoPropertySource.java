package com.so.soconfig.client.config;

import org.springframework.core.env.EnumerablePropertySource;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
public class SoPropertySource extends EnumerablePropertySource<SoConfigService> {

    public SoPropertySource(String name, SoConfigService source) {
        super(name, source);
    }

    @Override
    public String[] getPropertyNames() {
        return source.getPropertyNames();
    }

    @Override
    public Object getProperty(String name) {
        return source.getProperty(name);
    }
}
