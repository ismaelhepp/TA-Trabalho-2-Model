package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permission;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirPermission {
    
    public TestePersistirPermission() {
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
        Permission obj = new Permission();
        obj.setName("ADMINISTRADOR");
        obj.setDescription("Administradores do sistema");
        
        Permission obj2 = new Permission();
        obj2.setName("USUARIO");
        obj2.setDescription("Usuários do sistema");
        
        em.getTransaction().begin();
        em.persist(obj);
        em.persist(obj2);
        em.getTransaction().commit();
    }
    
}
