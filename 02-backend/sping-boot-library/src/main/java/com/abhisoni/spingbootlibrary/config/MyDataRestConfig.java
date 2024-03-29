package com.abhisoni.spingbootlibrary.config;

import com.abhisoni.spingbootlibrary.entity.Book;
import com.abhisoni.spingbootlibrary.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigin = "http://localhost:3000";



    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){

        HttpMethod[] unsupportedmethods = {
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.PUT,
                HttpMethod.DELETE,
        };

        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Review.class);

        disableHttpMethods(Book.class, config, unsupportedmethods);
        disableHttpMethods(Review.class, config, unsupportedmethods);

        /* Configure CORS mapping */

        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigin);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedmethods) {

        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedmethods)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedmethods));

    }

}
