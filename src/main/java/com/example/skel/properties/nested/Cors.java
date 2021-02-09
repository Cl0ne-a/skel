package com.example.skel.properties.nested;

import lombok.Data;

@Data
public class Cors {
    private Boolean enable;
    private String pathPattern;
    private String[] allowedOrigins;
    private String[] allowedMethods;
    private String[] allowedHeaders;
    private String[] exposedHeaders;
    private Boolean allowCredentials;
}
