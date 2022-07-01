package Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
    @Embedded
    private Period workPeriod;

    @Embedded
    private Address Homeaddress;
    @ElementCollection
    @CollectionTable(name="FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name="FOOD_NAME")
    private Set<String> favroiteFoods = new HashSet<>();
    @ElementCollection
    @CollectionTable(name="ADDRESS",joinColumns = @JoinColumn(name="MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeaddress() {
        return Homeaddress;
    }

    public void setHomeaddress(Address Homeaddress) {
        this.Homeaddress = Homeaddress;
    }

    public Set<String> getFavroiteFoods() {
        return favroiteFoods;
    }

    public void setFavroiteFoods(Set<String> favroiteFoods) {
        this.favroiteFoods = favroiteFoods;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }

    //    private String city;
//    private String street;
//    private String zipcode;

}
