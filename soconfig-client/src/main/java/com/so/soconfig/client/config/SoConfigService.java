package com.so.soconfig.client.config;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
public interface SoConfigService {

    String[] getPropertyNames();

    String getProperty(String name);
}
