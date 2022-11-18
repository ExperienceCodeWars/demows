package com.example.demows.config;

import com.example.demows.HelloServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


@Configuration
public class WsConfig {
    @Autowired
    private Bus bus;

    @Bean
    public Endpoint helloEndpoint() {
        EndpointImpl endpointImpl = new EndpointImpl(bus, new HelloServiceImpl());
        endpointImpl.publish("/ServiceHello");

        return endpointImpl;
    }

}
