import jakarta.persistence.EntityManager;


public class JPAMainDemo {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        try{
            UserClassHibernate user = new UserClassHibernate( "Kaal");
            //session.beginTransaction(); instead using below:
            em.getTransaction().begin();
            //session.persist(user); // save(user) instead use below:
            em.persist(user);
            //session.getTransaction().commit(); instead we use below:

            em.getTransaction().commit();

            System.out.println("User saved:"+ user.getId());
        }catch(Exception e){
                e.printStackTrace();
        }finally {
            em.close();
            JPAUtil.close();
        }

    }


}
