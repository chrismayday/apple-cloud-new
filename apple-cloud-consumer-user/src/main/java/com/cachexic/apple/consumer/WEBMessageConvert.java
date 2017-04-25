package com.cachexic.apple.consumer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.TEXT_HTML;

/**
 * @author tangmin
 * @version V1.0
 * @Title: WEBMessageConvert.java
 * @Package com.cachexic.apple.common.config
 * @Description: 
 * @date 2017-04-23 12:05:19
 */
@Configuration
public class WEBMessageConvert {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }


    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        List<MediaType> supportedMediaTypes = Lists.newArrayList();
        supportedMediaTypes.add(APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(TEXT_HTML);
        converter.setSupportedMediaTypes(supportedMediaTypes);
        return converter;
    }

}
