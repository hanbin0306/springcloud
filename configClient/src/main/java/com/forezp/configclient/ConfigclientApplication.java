package com.forezp.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope //开启更新功能
public class ConfigclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigclientApplication.class, args);
    }


    /**
     * @Author hb
     * @Description //让客户端检索配置中心的文件时一直寻找，而不是第一个文件检索完没找到就报错
     * @Date 17:53 2019/3/19
     * @Param []
     * @return org.springframework.context.support.PropertySourcesPlaceholderConfigurer
     **/
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }


}
