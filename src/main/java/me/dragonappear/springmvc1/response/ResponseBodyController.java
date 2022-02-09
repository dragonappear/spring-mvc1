package me.dragonappear.springmvc1.response;

import me.dragonappear.springmvc1.request.messagebody.JsonDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/response-body")
public class ResponseBodyController {

    @GetMapping("/string/v1")
    public void stringV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("hi");
    }

    @GetMapping("/string/v2")
    public ResponseEntity stringV2() throws IOException {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/string/v3")
    public String stringV3() throws IOException {
        return "okk";
    }


    @GetMapping("/json/v1")
    public HttpEntity jsonV1() throws IOException {
        JsonDto dto = new JsonDto("username", "10");
        return new HttpEntity(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/json/v2")
    public JsonDto jsonV2() throws IOException {
        JsonDto dto = new JsonDto("username", "10");
        return dto;
    }
}
