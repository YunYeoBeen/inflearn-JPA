package jpa;

import jpa.practice.Member;
import jpa.practice.Team;

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
           Team team = em.find(Team.class, "SSAFY");
           List<Member> members = team.getMembers();
           for (Member member:members){
               System.out.println("member.getName() = " + member.getName());
           }
    

            tx.commit();
        }catch(Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
