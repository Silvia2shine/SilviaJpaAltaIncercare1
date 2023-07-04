import jakarta.persistence.*;

import java.util.List;

public class JpaMelodyRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
    EntityManager entityManager = emFactory.createEntityManager();

    public List<Melody> getAllMelody() {

        TypedQuery<Melody> typedQuery = entityManager.createQuery("select s from Melody s", Melody.class);
        List<Melody> melodyList = typedQuery.getResultList();
        entityManager.close();
        emFactory.close();
        return melodyList;

//
//        List<Melody> melodyList = typedQuery.getResultList();
//        return melodyList;

//        Query that does not check for type (UNSAFE)
//        Query query = entityManager.createQuery("select s from Student s");
    }

    /**
     * get all students in one line with unsafe casting, avoid!!
     */
    public List<Melody> getAllMelodyOneLine() {
        return entityManager.createQuery("from Melody").getResultList();
    }

    public void addMelody(Melody melody) {
        entityManager.getTransaction().begin();
        entityManager.persist(melody);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

//TODO  add method here to add a Student to the database

//TODO  add method here to find a Student in the database by name

//TODO  add method here to find a Student in the database by id

//TODO modify the JSP file to use the new methods instead of the JDBC one

}
