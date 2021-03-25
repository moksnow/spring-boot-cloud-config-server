package com.mok.samples.configclient;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
@RequestMapping(path = "/api")
public class SampleApi {

    private final ConfigClientAppConfiguration properties;

    public SampleApi(ConfigClientAppConfiguration properties) {
        this.properties = properties;
    }

    @GetMapping
    public String getConf() {
        return properties.getVersion();
    }
}

