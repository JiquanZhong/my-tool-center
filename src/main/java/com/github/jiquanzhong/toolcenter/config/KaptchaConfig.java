package com.github.jiquanzhong.toolcenter.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Value("${kaptcha.border.enable}")
    private Boolean border;

    @Value("${kaptcha.border.color}")
    private String borderColor;

    @Value("${kaptcha.textproducer.font.color}")
    private String fontColor;

    @Value("${kaptcha.textproducer.font.size}")
    private String fontSize;

    @Value("${kaptcha.textproducer.font.names}")
    private String fontNames;

    @Value("${kaptcha.textproducer.char.length}")
    private String charLength;

    @Value("${kaptcha.textproducer.image.height}")
    private String imageHeight;

    @Value("${kaptcha.textproducer.image.width}")
    private String imageWidth;

    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        if(border) {
            properties.put("kaptcha.border", "yes");
            properties.put("kaptcha.border.color", borderColor);
        }
        properties.put("kaptcha.textproducer.font.color", fontColor);
        properties.put("kaptcha.textproducer.font.size", fontSize);
        properties.put("kaptcha.textproducer.font.names", fontNames);
        properties.put("kaptcha.textproducer.char.length", charLength);
        properties.put("kaptcha.textproducer.image.height", imageHeight);
        properties.put("kaptcha.textproducer.image.width", imageWidth);

        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
