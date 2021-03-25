package com.mok.samples.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.event.EventListener;

@RefreshScope
@SpringBootApplication
public class SampleConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleConfigClientApplication.class, args);
    }

    @EventListener({EnvironmentChangeEvent.class})
    public void onRefresh() {
        System.out.println("environment Changed..");
    }

}
