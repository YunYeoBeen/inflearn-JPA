
import JPQL.Address;
import JPQL.Member;
import JPQL.MemberDTO;
import JPQL.Team;

import javax.persistence.*;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

//           Member query = em.createQuery("select m from Member m where m.username= :username", Member.class)
//                    .setParameter("username","member1")
//                    .getSingleResult();
//            System.out.println("query.getUsername() = " + query.getUsername());
            List<MemberDTO> result = em.createQuery("select new JPQL.MemberDTO(m.username,m,age) ", MemberDTO.class).getResultList();
            MemberDTO memberDTO = result.get(0);
            System.out.println("memberDTO = " + memberDTO.getUsername());
            System.out.println("memberDTO = " + memberDTO.getAge());
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }
}
