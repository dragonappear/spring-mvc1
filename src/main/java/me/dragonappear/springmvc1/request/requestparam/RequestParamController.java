package me.dragonappear.springmvc1.request.requestparam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/request-param")
public class RequestParamController {

    // v1: request에서 직접 조회
    @RequestMapping("/v1")
    public void v1(HttpServletRequest request,
                   HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        log.info("username:{},age:{}", username, age);
        response.getWriter().write("ok");
    }

    // v2: @RequestParam(name=) 사용
    @RequestMapping("/v2")
    public String v2(@RequestParam(name = "username") String name,@RequestParam(name ="age") String number) throws IOException {
        log.info("username:{},age:{}", name, number);
        return "ok";
    }

    // @RequestParam(name="")에서 name 생략
    // Http 파라미터 이름이 argument 이름과 같으면 name 생략 가능
    @RequestMapping("/v3")
    public String v3(@RequestParam String username, @RequestParam String age) throws IOException {
        log.info("username:{},age:{}", username, age);
        return "ok";
    }

    // @RequestParam 생략
    // String,int,Integer 등의 단순 타입이면 @RequestParam도 생략 가능
    // @RequestParam을 생략하면 스프링 MVC는 내부에서 required=false를 적용하낟.
    @RequestMapping("/v4")
    public String v4(String username, String age) throws IOException {
        log.info("username:{},age:{}", username, age);
        return "ok";
    }


    @RequestMapping("/default")
    public String defaultValue(@RequestParam(required = true,defaultValue = "hello") String username, @RequestParam(required = false,defaultValue = "good") String age) throws IOException {
        log.info("username:{},age:{}", username, age);
        return "ok";
    }

    @RequestMapping("/map")
    public String map(@RequestParam MultiValueMap<String,String> map) {
        log.info("username:{},age:{}", map.getFirst("username"), map.getFirst("age"));
        return "ok";
    }

}
