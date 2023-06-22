package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /**
     * For jdbc
    private final DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }**/


    /**
     * For JPA
    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }
     */

    /**
     * For 스프링 데이터 JPA
     */
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
//        return new MemberService(memberRepository()); // For JPA
        return new MemberService(memberRepository);
    }

    /**
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcTemplateMemberRepository(dataSource);    // Jdbc template 사용
//        return new JpaMemberRepository(em);     //JPA 사용
    }
    */

}
