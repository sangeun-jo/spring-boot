package info.thecodinglive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


//요청에 따라 응답해주는 녀석
@Controller
public class IndexController {
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("title", "Jpub Spring WEB");
        mv.addObject("today", new Date().toString());
        System.out.println("index 컨트롤러");
        return mv;
    }
}
