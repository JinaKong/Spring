package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //스프링부트에서는 컨트롤러에 이 표시를 달아주어야 한다.
public class HelloController {

    //기본 /hello 페이지
    @GetMapping("hello")    //웹에서 '/hello'일 때 아래 메소드를 호출한다.
    public String hello(Model model){
        model.addAttribute( "data","hello!!");
        return "hello";
    }

    //MVC 방식을 활용한 /hello-mvc?name="blahblah" 페이지
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API 방식을 활용한 /hello-api 페이지
    @GetMapping("hello-api")
    @ResponseBody //API 방식에서는 반드시 넣어주어야 한다!
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello{
        private String name;

        //getter
        public String getName(){
            return name;
        }

        //setter
        public void setName(String name){
            this.name = name;
        }
    }
}
