import Type.Address;
import Type.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
            member.setHomeaddress(new Address("city1","street","1219-1"));
            member.getFavroiteFoods().add("chicken");
            member.getFavroiteFoods().add("food");
            member.getFavroiteFoods().add("pizza");

            member.getAddressHistory().add(new Address("oldCity2","street1","1219-1"));
            member.getAddressHistory().add(new Address("oldCity1","street1","1219-1"));

            em.persist(member);
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address = " + address);
                
            }

            tx.commit();

        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }
}
