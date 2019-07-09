package com.xiaohu.demo.common.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 这个类类似于web.xml的功能，需要继承AbstractAnnotationConfigDispatcherServletInitializer，
 * 它是所有WebApplicationInitializer实现的基类。
 * 在Servlet3.0的时候,使用对WebApplicationInitializer实现的方式来配置ServletContext
 *
 * @author hu
 */
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { WebSecurityConfig.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
}