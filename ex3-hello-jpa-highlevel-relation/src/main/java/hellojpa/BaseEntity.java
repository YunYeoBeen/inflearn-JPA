package hellojpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name="NAME")
    private String name;
    @Column(name="ID")
    private String id;

    //Getter, Setter
}
