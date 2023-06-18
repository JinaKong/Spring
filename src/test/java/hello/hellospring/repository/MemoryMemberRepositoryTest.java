package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    //save 기능 테스트
    @Test
    public void save(){
        Member member = new Member();
        member.setName("name1");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        
        //Assertions 기능 사용 -> member와 result가 같다면 초록 체크가 나타남
        //위에서 static으로 Assertions import 함
        assertThat(member).isEqualTo(member);
    }

    //findByName 기능 테스트
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("name1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("name2");
        repository.save(member2);

        //findByName()
        Member result = repository.findByName("name1").get();

        assertThat(result).isEqualTo(member1);
    }

    //findAll 기능 테스트
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("name1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("name2");
        repository.save(member2);

        //findAll()
        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
