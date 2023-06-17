package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //스프링부트에서는 컨트롤러에 이 표시를 달아주어야 한다.
public class HelloController {

    @GetMapping("hello")    //웹에서 '/hello'일 때 아래 메소드를 호출한다.
    public String hello(Model model){
        model.addAttribute( "data","hello!!");
        return "hello";
    }
}
