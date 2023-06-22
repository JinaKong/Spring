package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Member {

    /**
     * 요구 데이터
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        //회원 id를 pk로 설정

    private String name;    //회원 이름

    /**
     * getter and setter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
