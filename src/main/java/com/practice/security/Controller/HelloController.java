package com.practice.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.security.Service.TestService;
import com.practice.security.Dto.TestDto;
import java.util.*;

@Controller
public class HelloController {
    @Autowired
    TestService testService;
 
    @RequestMapping("/")
    public String index() {
 
        return "index";
    }
 
    @RequestMapping("/query")
    public @ResponseBody
    List<TestDto> query() throws Exception{
        return testService.getAll();
    }
}
