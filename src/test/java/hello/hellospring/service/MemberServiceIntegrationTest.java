package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    /**
    @BeforeEach
    public void beforeEach(){
        //테스트 실행 전마다 리포지토리를 생성해서 MemberService에 넣어준다
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
     **/

    /**
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
     **/

    @Test
    void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("홍길동");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());

    }

    @Test
    void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("홍길동");

        Member member2 = new Member();
        member2.setName("홍길동");

        //when
        memberService.join(member1);

        //중복 회원이 join하려 하면 IllegalStateException이 터져야 한다
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }

}