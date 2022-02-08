package me.dragonappear.springmvc1.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log-test")
public class LogController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping
    public String log() {
        String name = "spring";
        log.trace("trace:{}",name);
        log.debug("debug:{}",name);
        log.info("info:{}",name);
        log.warn("warn:{}",name);
        log.error("error:{}",name);
        log.info("info:"+name); // X
        return "ok";
    }

}
