package com.mycompany.spring3.config;

import com.mycompany.spring3.service.client.StudentClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class StudentClientConfig {

    @Bean
    public WebClient studentServiceWebclient() {

        return WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    @Bean
    public StudentClientService getStudentClientService() {

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(studentServiceWebclient()))
                .build();
        return  httpServiceProxyFactory.createClient(StudentClientService.class);
    }

}
