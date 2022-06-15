package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// 이 어노테이션은 꼭 넣어야 한다.
@Entity(name="Member")
/*
    @Table(name="USER") ==> 만약 DB의 table명이 USER이고 내가 만든 엔티티 이름이 Member일 때 이렇게 해주면 자동 맵핑
 */
public class Member {

    // 이 id도 꼭 넣어줘야 한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
        @Column(name="username") ==> 위의 @Table과 마찬가지임
     */
    private String id;
    @Column(name = "name", nullable = false)
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    private LocalDate testLocalDate;
    private LocalDateTime getTestLocalDateTime;



    // 인텔리제이는 이렇게 생성자를 만들 때 꼭 default 생성자를 만들어줘야 한다.
    public Member(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
