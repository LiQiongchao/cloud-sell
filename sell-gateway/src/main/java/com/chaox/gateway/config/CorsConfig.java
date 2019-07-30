package com.chaox.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * C - Cross  O - Origin  R - Resource  S - Sharing
 * @Author: LiQiongchao
 * @Date: 2019/7/27 12:20
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter crosFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许携带Cookie
        corsConfiguration.setAllowCredentials(true);
        /**
         * 允许哪些域名跨域
         * 如：http://www.abc.com
         */
        corsConfiguration.addAllowedOrigin("*");
        /**
         * 允许跨域的请求方法 "POST", "GET"
         * 允许所有是*
         */
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        /**
         * 允许验证后多久不再验证。
         */
        corsConfiguration.setMaxAge(3000L);
        // 拦截所有路径
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

}
