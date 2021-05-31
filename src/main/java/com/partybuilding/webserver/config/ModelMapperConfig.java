package com.partybuilding.webserver.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * java 智能对象映射
 */

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        /**
         * 完全匹配，不完全不配不建议使用
         */
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        /**
         * 匹配策略定义为严格
         */
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
