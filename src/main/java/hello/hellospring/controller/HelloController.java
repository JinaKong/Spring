package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //스프링부트에서는 컨트롤러에 이 표시를 달아주어야 한다.
public class HelloController {

    @GetMapping("hello")    //웹에서 '/hello'일 때 아래 메소드를 호출한다.
    public String hello(Model model){
        model.addAttribute( "data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
