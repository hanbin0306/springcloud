package com.forezp.serviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ServiceconfigApplication {
    //启动完了以后访问http://localhost:6001/config-client/dev
    //端口后面是跟的文件名称 去掉了dev
    public static void main(String[] args) {
        SpringApplication.run(ServiceconfigApplication.class, args);
    }

}
