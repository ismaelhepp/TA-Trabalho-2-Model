package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permission;
import br.edu.ifsul.modelo.SystemUser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirSystemUserPermission {
    
    public TestePersistirSystemUserPermission() {
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
        SystemUser obj = em.find(SystemUser.class, "ismael");
        obj.getPermissions().add(em.find(Permission.class, "ADMINISTRADOR"));
        obj.getPermissions().add(em.find(Permission.class, "USUARIO"));
        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
    
}
