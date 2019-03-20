package com.forezp.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName SchedualServiceHiHystric
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/18 19:14
 * @Version 1.0
 **/
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
