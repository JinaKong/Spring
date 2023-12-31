package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //스프링 Bean으로 자동 등록
public class MemberController {

    private final MemberService memberService;

    @Autowired  //Autowired 어노테이션
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    /**
     * 회원가입
     */
    //Get
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    //Post
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";    //홈 화면으로 돌려보냄
    }

    /**
     * 회원목록 조회
     */
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members= memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
