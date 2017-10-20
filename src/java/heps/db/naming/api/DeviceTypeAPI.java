/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.api;

import heps.db.naming.entity.DeviceType;
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
public class DeviceTypeAPI {

    @PersistenceUnit
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("accNamingPU");
    static EntityManager em = emf.createEntityManager();

    @PersistenceContext

    public DeviceType findByDeviceType(String device_type) {
        Query q;
        q = em.createNamedQuery("DeviceType.findByDeviceType").setParameter("deviceType", device_type);
        List<DeviceType> dtList = q.getResultList();
        if (dtList.isEmpty()) {
            return null;
        } else {
            return dtList.get(0);
        }
    }

    public void setDeviceTypeAPI(String device_type, String des) {
        if (this.findByDeviceType(device_type) == null) {
            DeviceType dt = new DeviceType();
            dt.setDeviceType(device_type);
            dt.setDescription(des);
            em.getTransaction().begin();
            em.persist(dt);
            em.getTransaction().commit();
        }else{
            System.out.println("The Device Type "+device_type+" is already existing in the database");
        }
        /* try {
            em.getTransaction().begin();
            em.persist(dt);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,this.toString()+" "+ "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }*/

    }

}
