package com.everis.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = { "com.everis.example.service" })
public class ServiceConfig implements WebMvcConfigurer {

}
