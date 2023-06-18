package hello.hellospring.domain;

public class Member {

    //요구 데이터
    private Long id;        //회원 id
    private String name;    //회원 이름

    //getter and setter
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
