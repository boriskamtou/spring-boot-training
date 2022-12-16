package com.optimagrowth.license.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "example")
@Getter @Setter
public class ServiceConfig {
    private String property;
}
