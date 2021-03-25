package com.mok.samples.configclient;


import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@ConfigurationPropertiesScan
@Configuration
public class PropertyConfiguration {

}
