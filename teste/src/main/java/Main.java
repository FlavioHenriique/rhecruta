import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        EntityManager em  = Persistence
                .createEntityManagerFactory("Rhecruta")
                .createEntityManager();

        Candidato c = new Candidato("2010","flavio");
        c.add(new Vaga("python",10));
        c.add(new Vaga("java",12));

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
