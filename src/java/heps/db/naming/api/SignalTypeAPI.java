/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.api;

import heps.db.naming.entity.SignalType;
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
public class SignalTypeAPI {

    @PersistenceUnit
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("accNamingPU");
    static EntityManager em = emf.createEntityManager();

    @PersistenceContext

    public SignalType findBySignalType(String signal_type) {
        Query q;
        q = em.createNamedQuery("SignalType.findBySignalType").setParameter("signalType", signal_type);
        List<SignalType> dtList = q.getResultList();
        if (dtList.isEmpty()) {
            return null;
        } else {
            return dtList.get(0);
        }
    }

    public void setSignalTypeAPI(String signal_type, String des) {
        if (this.findBySignalType(signal_type) == null) {
            SignalType st = new SignalType();
            st.setSignalType(signal_type);
            st.setDescription(des);
            em.getTransaction().begin();
            em.persist(st);
            em.getTransaction().commit();
        }else{
             System.out.println("The Signal Type "+signal_type+" is already existing in the database");
        }
        /* try {
           
            em.getTransaction().begin();
            em.persist(st);
            em.getTransaction().commit();
        } catch (Exception e) {         
           Logger.getLogger(getClass().getName()).log(Level.SEVERE,this.toString()+" "+ "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }*/

    }

}
