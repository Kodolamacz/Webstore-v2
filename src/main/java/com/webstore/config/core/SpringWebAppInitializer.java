package com.webstore.config.core;

import com.webstore.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Blazej on 11.03.2018.
 */
public class SpringWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

    public SpringWebAppInitializer(){
        super(WebSecurityConfig.class);
    }
}
