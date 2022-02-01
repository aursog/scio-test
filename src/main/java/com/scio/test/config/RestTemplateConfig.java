package com.scio.test.config;

import com.scio.test.restclient.CMSDataRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@EnableAutoConfiguration
public class RestTemplateConfig extends SpringConfig {

    @Value("${cmsurl}")
    private String url;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build();
    }

    @Bean
    public CMSDataRestClient cmsDataRestClient() {
        return new CMSDataRestClient(restTemplate(), url);
    }

}
