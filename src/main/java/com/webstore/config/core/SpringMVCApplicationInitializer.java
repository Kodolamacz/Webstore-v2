//package com.webstore.config.core;
//
//import com.webstore.config.ApplicationConfig;
//import com.webstore.config.PersistanceConfig;
//import com.webstore.config.WebSecurityConfig;
//import com.webstore.config.WebServletConfig;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
///**
// * Created by Blazej on 19.03.2018.
// */
//public class SpringMVCApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[] {PersistanceConfig.class , WebSecurityConfig.class };
//    }
//
//    // Load spring web configuration
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[] { ApplicationConfig.class };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
//}
//
//
