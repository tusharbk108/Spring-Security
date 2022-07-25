package com.example.springSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

    @RequestMapping("/404")
    public ModelAndView error404(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
