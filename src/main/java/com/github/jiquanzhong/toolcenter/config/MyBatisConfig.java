package com.github.jiquanzhong.toolcenter.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.github.jiquanzhong.toolcenter.interceptor.MyMetaObjectHandler;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
@MapperScan(basePackages = "com.github.jiquanzhong.toolcenter.repository")
public class MyBatisConfig {

    // AOP: 自动填充数据库创建人、创建时间、更新人、更新时间
    private final MyMetaObjectHandler myMetaObjectHandler;

    /**
     * 全局配置，配置自动填充处理器
     * @return GlobalConfig 全局配置
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(myMetaObjectHandler);
        return globalConfig;
    }

}
