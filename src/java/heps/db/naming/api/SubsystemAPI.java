/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.api;

import heps.db.naming.entity.Subsystem;
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
public class SubsystemAPI {

    @PersistenceUnit
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("accNamingPU");
    static EntityManager em = emf.createEntityManager();

    @PersistenceContext

    public Subsystem findBySubsystemName(String subsystem_name) {
        Query q;
        q = em.createNamedQuery("Subsystem.findBySubsystemName").setParameter("subsystemName", subsystem_name);
        List<Subsystem> dtList = q.getResultList();
        if (dtList.isEmpty()) {
            return null;
        } else {
            return dtList.get(0);
        }
    }

    public void setSubsystemAPI(String subsystem_name, String des) {
        if (this.findBySubsystemName(subsystem_name) == null) {
            Subsystem ss = new Subsystem();
            ss.setSubsystemName(subsystem_name);
            ss.setDescription(des);
            em.getTransaction().begin();
            em.persist(ss);
            em.getTransaction().commit();
        } else {
            System.out.println("The Subsystem " + subsystem_name + " is already existing in the database");
        }
        /*   try {          
            em.getTransaction().begin();
            em.persist(ss);
            em.getTransaction().commit();
        } catch (Exception e) {         
           Logger.getLogger(getClass().getName()).log(Level.SEVERE,this.toString()+" "+ "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        } */
    }
}
