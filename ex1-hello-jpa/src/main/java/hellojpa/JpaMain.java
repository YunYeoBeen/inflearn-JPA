package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    // psvm을 쓰면 자동으로 main 메서드 만들어준다.
    public static void main(String[] args) {
        // 우리가 처음에 pesistence.xml(persistence-unit)에서 이름 설정한 값을 넣어준다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 이렇게 EntityManagerFactory를 만드는 순간 데이터 베이스와 연결이 된다.
        // em은 어떤 한 고객이 어떠한 행위를 할 때마다(장바구니를 담을 때, 어떤 클릭을 할 때) 이 EntityMangerFactory를 만들어줘야 한다.
        // 따라서 em은 사용하고 바로 버려야 하기 때문에 쓰레드 간에 공유를 하면 안된다.
        EntityManager em = emf.createEntityManager();
        // 여기에 이제 code를 작성
        // 무조건 transaction 안에서 데이터를 넣어줘야 한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 사실 정석은 try-catch-finally(em은 항상 꺼줘야 하기 때문에 finally에)
        // 근데 spring-boot로 가면 이런 거 안해줘도 된다. 다 자동으로 해준다.
        try {
            /*
            멤버 테이블에 데이터 삽입
            Member member = new Member();
            // 그냥 이렇게 작성만 하면 member가 저장이 된다.
            member.setId(2L);
            member.setName("HelloA");
            em.persist(member) --> member를 저장한다.
            */

            /*
            원하는 데이터를 찾고 싶을 때 --> 여기서 이제 findMember로 데이터를 변경할 수 있다.
            Member findMember = em.find(Member.class, 1L);
            soutv --> syso과 같다.
             */

            // 회원 삭제
            /*
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);
             */

            // 회원 수정
            /*
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("윤여빈");
            */

            // JPQL
            /*
             JPQL에서는 테이블을 대상으로 쿼리문을 작성하지 않는다? 객체지향 쿼리이다.
             setFirstResult(1)와 setMaxResults(10)는 1번째부터 10번째까지 가져와 라는 뜻이다.
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for (Member member: result){
                System.out.println("member = " + member.getName());
            }
             */

            // 그렇다면 또 jpa.persist(findMember)를 해줘서 저장을 해줘야 할까?
            // 대답은 No. 자바 컬렉션처럼 다루기 때문에 set만 해주면 자동으로 바뀐다. 왜냐면 transaction이 진행되는 동안
            // 변화된 부분을 자동으로 JPA가 찾아주고 UPDATE Query문을 날려준다.

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("============================");

            Member findMember = em.find(Member.class, 150L);
            findMember.setName("ZZZZZ");
            // em.persist(member); --> 안해주는 것이 좋다.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}
