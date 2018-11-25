package com.springbootjsf.springbootjsf;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {
	
	@Override
    public void addViewControllers( ViewControllerRegistry registry ) { // Welcome File belirliyor
        registry.addViewController( "/" ).setViewName( "forward:/login.xhtml" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    }

}
