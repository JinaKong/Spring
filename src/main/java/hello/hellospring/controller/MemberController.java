package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링 Bean으로 자동 등록
public class MemberController {

    private final MemberService memberService;

    @Autowired  //Autowired 어노테이션
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}
