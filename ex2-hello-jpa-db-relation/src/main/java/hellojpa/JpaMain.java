package hellojpa;

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
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUserName("member1");
            member.changeTeam(team);
            em.persist(member);


            // 사실 persist를 하면 1차캐쉬에 저장이 되니깐
            // find를 해줘도 1차캐시에서 그대로 가져오니 SQL문을 콘솔창에서 볼 수가 없는데 만약 보고싶다면?
            em.flush();
            em.clear();


            // flush로 DB에 보낸다음 1차 캐시를 clear해주면 된다.
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam.getName() = " + findTeam.getName());
//            List<Member> members = findMember.getTeam().getMembers();
            //만약 TeamA를 다른 팀으로 바꿔주고 싶다면?
            // 100번째 팀으로 바꿔주고 싶다면?
            // Team newTeam = em.fin(Team.class, 100L);
            // findTeam.setTeam(newTeam);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}
