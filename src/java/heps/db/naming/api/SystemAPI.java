/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.api;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author huihui
 */
public class SystemAPI {

    @PersistenceUnit
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("accNamingPU");
    static EntityManager em = emf.createEntityManager();

    @PersistenceContext

    public heps.db.naming.entity.System findBySystemName(String systemName) {
        Query q;
        q = em.createNamedQuery("System.findBySystemName").setParameter("systemName", systemName);
        List<heps.db.naming.entity.System> dtList = q.getResultList();
        if (dtList.isEmpty()) {
            return null;
        } else {
            return dtList.get(0);
        }
    }

    public void setSystemAPI(String system_name, String des) {
        if (this.findBySystemName(system_name) == null) {
            heps.db.naming.entity.System s = new heps.db.naming.entity.System();
            s.setSystemName(system_name);
            s.setDescription(des);
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } else {
            System.out.println("The System " + system_name + " is already existing in the database");
        }
        /*try {          
            em.getTransaction().begin();
            em.persist(s);        
            em.getTransaction().commit();
        } catch (Exception e) {         
           Logger.getLogger(getClass().getName()).log(Level.SEVERE,this.toString()+" "+ "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }  */
    }

}
