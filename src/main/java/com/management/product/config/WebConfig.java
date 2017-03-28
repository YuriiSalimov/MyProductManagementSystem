package com.management.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Class Spring MVC configuration. Spring Indicates where the views components,
 * and how to display them. Class is the source of bean definitions.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {
                "com.management.product.controller",
                "com.management.product.config"
        }
)
@PropertySource("classpath:content.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Content Type encoding.
     */
    @Value("${view.type}")
    private String contentType;

    /**
     * View name prefix.
     */
    @Value("${view.name-prefix}")
    private String viewPrefix;

    /**
     * View name suffix.
     */
    @Value("${view.name-suffix}")
    private String viewSuffix;

    /**
     * It is exposed context beans as attributes.
     */
    @Value("${view.expose_beans_as_attributes}")
    private boolean exposeContextBeansAsAttributes;

    /**
     * The url of resources.
     */
    @Value("${resources.handler}")
    private String resourcesHandler;

    /**
     * The location of resources.
     */
    @Value("${resources.location}")
    private String resourcesLocation;

    /**
     * Indicates to Spring where are the views components,
     * and how to display them.
     *
     * @return The object of the InternalResourceViewResolver class.
     */
    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType(this.contentType);
        viewResolver.setPrefix(this.viewPrefix);
        viewResolver.setSuffix(this.viewSuffix);
        viewResolver.setExposeContextBeansAsAttributes(this.exposeContextBeansAsAttributes);
        return viewResolver;
    }

    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     *
     * @param resource The object of the ResourceHandlerRegistry class.
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry resource) {
        resource.addResourceHandler(this.resourcesHandler)
                .addResourceLocations(this.resourcesLocation);
    }
}
