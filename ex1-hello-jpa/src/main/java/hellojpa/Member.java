package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

// 이 어노테이션은 꼭 넣어야 한다.
@Entity
/*
    @Table(name="USER") ==> 만약 DB의 table명이 USER이고 내가 만든 엔티티 이름이 Member일 때 이렇게 해주면 자동 맵핑
 */
public class Member {

    // 이 id도 꼭 넣어줘야 한다.
    @Id
    /*
        @Column(name="username") ==> 위의 @Table과 마찬가지임
     */
    private Long id;
    private String name;

    // 인텔리제이는 이렇게 생성자를 만들 때 꼭 default 생성자를 만들어줘야 한다.
    public Member(){}
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
