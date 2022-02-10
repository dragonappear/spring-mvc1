package me.dragonappear.springmvc1.request.requestparam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/model-attribute")
public class ModelAttributeController {

    // 스프링에서 자동으로 객체를 생성해서 프로퍼티에 값을 넣어준다.
    // 그리고 model.addAttribute("modelAttributeDto",dto)를 실행해준다.
    @RequestMapping("/v1")
    public String v1(@ModelAttribute ModelAttributeDto dto) {
        log.info("username:{},age:{}", dto.getUsername(),dto.getAge());
        return "ok";
    }

    // 스프링에서 자동으로 객체를 생성해서 프로퍼티에 값을 넣어준다.
    // @ModelAttribute를 생략해도 model.addAttribute("modelAttributeDto",dto)를 실행해준다.
    @RequestMapping("/v2")
    public String v2(ModelAttributeDto dto) {
        log.info("username:{},age:{}", dto.getUsername(),dto.getAge());
        return "ok";
    }


    // 스프링은 해당 생략 시 다음과 같은 규칙을 적용
    // 1. String,int,Integer 같은 타입 > @RequestParam
    // 2. 나머지 = @ModelAttribute (Argument Resolver로 지정해둔 타입은 제외)

}
