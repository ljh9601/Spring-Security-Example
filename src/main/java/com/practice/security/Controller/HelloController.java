package com.practice.security.Controller;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.security.Service.TestService;
import com.practice.security.Dto.DataDto;
import com.practice.security.Dto.ParamDto;
import com.practice.security.Dto.TestDto;
import com.practice.security.Response.JSONResponse;

import java.util.*;

@RestController
@RequestMapping(value="test")
public class HelloController {
    @Autowired
    TestService testService;
 
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        return "index";
    }
 
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public @ResponseBody List<TestDto> query() throws Exception{
        return testService.getAll();
    }
    
    @RequestMapping(value = "/args", method = RequestMethod.GET)
    public DataDto getArgs(
            @RequestParam(value = "msg")String msg,
            @RequestParam(value = "msg2")String msg2) {
        DataDto dataDto = new DataDto(0, msg);
        dataDto.setMsg(dataDto.getMsg() + ", " + msg2);

        return dataDto;
    }

    @RequestMapping(value = "/argsDefault", method = RequestMethod.GET)
    public DataDto getArgsDefault(
            @RequestParam(value = "msg")String msg,
            @RequestParam(value = "msg2", required = false, defaultValue = "msg2Default")String msg2) {
    	DataDto dataDto = new DataDto(0, msg);
        dataDto.setMsg(dataDto.getMsg() + ", " + msg2);

        return dataDto;
    }

    @RequestMapping(value = "/argsDefault", method = RequestMethod.POST)
    public DataDto post(@RequestBody ParamDto param) {
        String msg = "Data1 : " + param.getData1() + ", Data2 : " + param.getData2();
        DataDto dataDto = new DataDto(0, msg);
        return dataDto;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public DataDto put(@RequestParam(value = "param1")String param1) {
    	DataDto dataDto = new DataDto(0, "Put Request : " + param1);
        return dataDto;
    }

    @RequestMapping(value = "/jsonresponse", method = RequestMethod.PUT)
    public JSONResponse<DataDto> getJsonResponse(
            @RequestParam(value = "msg")String msg) {
        DataDto dataDto = new DataDto(0, msg);

        JSONResponse<DataDto> response = new JSONResponse<DataDto>();
        response.setCode(0);
        response.setMsg("성공");
        response.setData(dataDto);

        return response;
    }
}
