package com.xiaohu.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * 在Spring Security4时，配置Spring Mvc时，需要继承WebMvcConfigurerAdapter类，
 * 但是在Spring Security5时，该类就已经过时啦，可以使用@Bean方式添加相应的参数，
 * 也可以直接实现WebMvcConfigurer接口来配置springmvc。
 *
 * @author hu
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.xiaohu.demo" })
public class WebConfig  {

   //使用@Bean方式的时候，不用继承WebMvcConfigurerAdapter

   @Bean
   public ViewResolver viewResolver(){
      InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
      viewResolver.setViewClass(JstlView.class);
      viewResolver.setPrefix("/WEB-INF/jsp/");
      viewResolver.setSuffix(".jsp");
      return viewResolver;
   }

//   @Bean
//   public void configureViewResolvers(ViewResolverRegistry registry) {
//      InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
//      viewResolver.setViewClass(JstlView.class);
//      viewResolver.setPrefix("/WEB-INF/views/");
//      viewResolver.setSuffix(".jsp");
//      registry.viewResolver(viewResolver);
//   }
//
//   @Bean
//   public void addResourceHandlers(ResourceHandlerRegistry registry) {
//      registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//   }
}