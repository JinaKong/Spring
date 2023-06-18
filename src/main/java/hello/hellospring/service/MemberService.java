package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;    //리포지토리
    
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;   //리포지토리를 외부에서 생성
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {

        //같은 이름의 중복 회원은 불가
        validateDuplicateMember(member);    //중복 회원 검증
        memberRepository.save(member);      //저장
        return member.getId();
    }

    //중복회원 검증 함수
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())   //Optional 값임
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 이름으로 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
