package com.so.soconfig.client.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import lombok.Data;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
@Data
public class SoPropertySourcesProcessor implements BeanFactoryPostProcessor, ApplicationContextAware, EnvironmentAware,
        PriorityOrdered {

    public static final String CUSTOM_PROPERTY_SOURCES = "SoPropertySources";
    public static final String CUSTOM_OUTER_PROPERTY_SOURCE = "SoPropertySource";

    Environment environment;
    ApplicationContext applicationContext;


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        ConfigurableEnvironment env = (ConfigurableEnvironment) environment;
        if (env.getPropertySources().contains(CUSTOM_OUTER_PROPERTY_SOURCE)) {
            return;
        }
        //mock config
        Map<String, String> configMeta = new HashMap<>();

        SoConfigService configService = new SoConfigServiceImpl(applicationContext, configMeta);

        SoPropertySource soPropertySource  = new SoPropertySource(CUSTOM_OUTER_PROPERTY_SOURCE, configService);
        CompositePropertySource composite = new CompositePropertySource(CUSTOM_OUTER_PROPERTY_SOURCE);
        composite.addPropertySource(soPropertySource);
        env.getPropertySources().addFirst(composite);
    }


    @Override
    public int getOrder() {
        return PriorityOrdered.HIGHEST_PRECEDENCE;
    }
}
