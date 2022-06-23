package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            Order order = new Order();
            // 이렇게 원하는 order를 장바구니처럼 쭈욱쭈욱 넣을 수 있는 것이다.
//            order.addOrderItem(new OrderItem());

            // 사실 단방향으로만 해도 충분하다. 다만 양방향으로 하는 이유는
            // 역방향으로도 조회가 가능하기 때문에 편의성이이 좋다.

            Book book = new Book();
            book.setName("JPA");
            book.setPrice(1200);
            book.setAuthor("김영한");
            em.persist(book);
            tx.commit();

       } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}

