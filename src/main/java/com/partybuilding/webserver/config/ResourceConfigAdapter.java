package com.partybuilding.webserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 包嵩
 * @DateTime: 2021/5/11 15:09
 * @Description: 一入代码深似海，风云人物我辈出。
 */
@Component
@Configuration
public class ResourceConfigAdapter implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\";
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/images/**").
                    addResourceLocations("file:" + path);
        }

    }
}
