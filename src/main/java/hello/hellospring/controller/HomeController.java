package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //홈화면이므로 "/"
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
