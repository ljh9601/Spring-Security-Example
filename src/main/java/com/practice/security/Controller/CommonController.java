/**
 * 
 */
package com.practice.security.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Janghaeng
 * @Controller 에서는 일반 String 을 return 하기 위해서(ajax 에 대한 응답)는 반드시 @ResponseBody 를 적어 주어야 한다
 * @Controller와 RestController의 차이 : String return과 Contents Return의 차이!
 */

@RestController
public class CommonController {
    @RequestMapping("/")
    public String root_test() throws Exception{
        return "Hello Root(/)";
    }
 
    @RequestMapping("/demo")
    public String demo_test() throws Exception{
        return "Hello demo(/demo)";
    }
}
