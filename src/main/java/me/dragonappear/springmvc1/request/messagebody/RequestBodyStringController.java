package me.dragonappear.springmvc1.request.messagebody;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping("/request-body")
public class RequestBodyStringController {

    @PostMapping("/string/v1")
    public String stringV1(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream();

        String messageBody
                = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody:{}",messageBody);
        return "ok";
    }

    @PostMapping("/string/v2")
    public void stringV2(InputStream inputStream, Writer writer) throws IOException {

        String messageBody
                = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody:{}",messageBody);
        writer.write("ok");
    }

    @PostMapping("/string/v3")
    public HttpEntity<String> stringV3(HttpEntity<String> httpEntity) throws IOException {

        String messageBody = httpEntity.getBody();

        log.info("messageBody:{}", messageBody);

        return new HttpEntity<>("ok");
    }

    @PostMapping("/string/v4")
    public String stringV4(@RequestBody String messageBody) throws IOException {

        log.info("messageBody:{}", messageBody);

        return "ok";
    }
}