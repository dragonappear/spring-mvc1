package me.dragonappear.springmvc1.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @GetMapping("/response/view/v1")
    public ModelAndView v1() {
        ModelAndView mv = new ModelAndView("response/hello");

        mv.addObject("data", "hi");

        return mv;
    }


    @GetMapping("/response/view/v2")
    public String v2(Model model) {
        model.addAttribute("data", "hello");

        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void v3(Model model) {
        model.addAttribute("data", "hello");
    }
}
