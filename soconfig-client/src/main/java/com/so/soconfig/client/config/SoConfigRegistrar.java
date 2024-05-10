package com.so.soconfig.client.config;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
public class SoConfigRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registerClass(registry, SoPropertySourcesProcessor.class);
    }

    private void registerClass(BeanDefinitionRegistry registry, Class<?> clazz) {
        System.out.println(clazz.getName());
        Optional<String> first = Arrays.stream(registry.getBeanDefinitionNames())
                .filter(x -> clazz.getName().equals(x)).findFirst();

        if (first.isPresent()) {
            System.out.println("SoPropertySourcesProcessor already registered");
            return;
        }

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(clazz).getBeanDefinition();
        registry.registerBeanDefinition(clazz.getName(), beanDefinition);
    }
}
