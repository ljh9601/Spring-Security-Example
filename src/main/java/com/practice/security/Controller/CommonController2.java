package com.practice.security.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController2 {
    @RequestMapping("/2")
    public String root_test() throws Exception{
        return "Hello Root(/)";
    }
 
    @RequestMapping("/demo2")
    public @ResponseBody String demo_test() throws Exception{
        return "Hello demo(/demo)";
    }

}
