package com.forezp.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author hanbin
 * @Date 2019/3/18 12:58
 * @Version 1.0
 **/
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT1/hi?name="+name,String.class);
    }
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
