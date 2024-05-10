package com.so.soconfig.client.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.so.soconfig.client.config.SoConfigRegistrar;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Import({SoConfigRegistrar.class})
public @interface EnableSoConfig {
}
