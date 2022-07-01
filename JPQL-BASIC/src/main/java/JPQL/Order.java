package JPQL;

import javax.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private int  orderAmount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Order order;


    public Order() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
