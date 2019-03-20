package com.forezp.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/19 18:03
 * @Version 1.0
 **/
@RestController
public class ConfigController {

    @Value("${cloud-config.app.swagger:111}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
