package me.dragonappear.springmvc1.request.requestparam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mapping")
public class PathVariableController {

    @GetMapping("/{id}")
    public String mappingPath(@PathVariable(name = "id") String i) {
        log.info("id:{}",i);
        return "ok";
    }

    @GetMapping("/users/{id}/orders/{orderId}")
    public String multiplePath(@PathVariable String id, @PathVariable String orderId) {
        log.info("id:{}",id);
        log.info("orderId:{}",orderId);
        return "ok";
    }

    @GetMapping(value = "/etc"
            ,headers = "Authorization"
            ,consumes = "application/json"
            ,produces = "application/json"
            ,params = "mode")
    public String etc() {
        return "ok";
    }
}
