package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.SystemUser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirSystemUser {
    
    public TestePersistirSystemUser() {
    }
    
    EntityManagerFactory emf;
    EntityManager em;
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("Trabalho-ModeloPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste() {
        SystemUser obj = new SystemUser();
        obj.setEmail("teste@teste.com");
        obj.setName("Ismael Felipe Hepp");
        obj.setLogin("ismael");
        obj.setPassword("123456");
        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
    
}
