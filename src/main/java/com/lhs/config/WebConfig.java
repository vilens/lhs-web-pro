package com.lhs.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Leonid on 2018/7/3.
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HttpMessageConverter<?> fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON_UTF8}));
        converter.getFastJsonConfig().setSerializerFeatures(new SerializerFeature[]{SerializerFeature.QuoteFieldNames, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.DisableCircularReferenceDetect});
        return converter;
    }

    /**
     * 安全认证interceptor
     * @return
     */
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(this.fastJsonHttpMessageConverter());
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor());
    }
}
