package com.example.skel.configs;

import com.example.skel.properties.nested.Cors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static java.util.Arrays.asList;

@Slf4j
@RequiredArgsConstructor//(onConstructor = @_(@Autowired))
@EnableWebMvc
public class ApplicationMVC implements WebMvcConfigurer {
        public final ApplicationProperties applicationProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        Cors cors = applicationProperties.getAppConfigs().getCors();
        if (cors.getEnable()){
            log.info("SPRING: CORS mapping enabled");
            log.info("CORS pathPattern: {}", cors.getPathPattern());
            log.info("CORS allowedOrigins {}", asList(cors.getAllowedOrigins()));
            log.info("CORS alloweMethods {}", asList(cors.getAllowedMethods()));
            log.info("CORS allowedHeaders {}", asList(cors.getAllowedHeaders()));
            log.info("CORS exposerHeaders {}", asList(cors.getExposedHeaders()));
            log.info("CORS allowedCredentials{}", asList(cors.getAllowCredentials()));

            registry.addMapping(cors.getPathPattern()).allowedOrigins(cors.getAllowedOrigins())
                    .allowedMethods(cors.getAllowedMethods())
                    .allowedHeaders(cors.getAllowedHeaders())
                    .exposedHeaders(cors.getExposedHeaders())
                    .allowCredentials(cors.getAllowCredentials());
        }
        else {
            log.info("SPRING: CORS mapping disabled");
        }
    }
}
