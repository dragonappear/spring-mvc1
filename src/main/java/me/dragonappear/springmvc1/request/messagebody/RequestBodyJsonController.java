package me.dragonappear.springmvc1.request.messagebody;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping("/request-body")
public class RequestBodyJsonController {
    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/json/v1")
    public String v1(HttpServletRequest request,
                     HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();

        String messageBody
                = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        JsonDto jsonDto
                = mapper.readValue(messageBody, JsonDto.class);

        log.info("username:{},age:{}",jsonDto.getUsername(),jsonDto.getAge());
        return "ok";
    }

    @RequestMapping("/json/v2")
    public String v2(@RequestBody String messageBody) throws IOException {

        JsonDto jsonDto
                = mapper.readValue(messageBody, JsonDto.class);

        log.info("username:{},age:{}",jsonDto.getUsername(),jsonDto.getAge());
        return "ok";
    }

    /**
     * MappingJackson2HttpMessageConverter를 사용하여 dto로 바로 받아오기
     */
    @RequestMapping("/json/v3")
    public String v3(@RequestBody JsonDto jsonDto) throws IOException {

        log.info("username:{},age:{}",jsonDto.getUsername(),jsonDto.getAge());
        return "ok";
    }

    @RequestMapping("/json/v4")
    public String v4(HttpEntity<JsonDto> httpEntity) throws IOException {
        JsonDto jsonDto = httpEntity.getBody();

        log.info("username:{},age:{}",jsonDto.getUsername(),jsonDto.getAge());
        return "ok";
    }

    @RequestMapping("/json/v5")
    public JsonDto v5(@RequestBody JsonDto jsonDto) throws IOException {
        log.info("username:{},age:{}",jsonDto.getUsername(),jsonDto.getAge());
        return jsonDto;
    }

}
