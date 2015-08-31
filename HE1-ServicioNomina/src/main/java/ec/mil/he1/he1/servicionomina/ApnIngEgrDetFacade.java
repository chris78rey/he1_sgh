/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnIngEgrDet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class ApnIngEgrDetFacade extends AbstractFacade<ApnIngEgrDet> implements ec.mil.he1.he1.remotonomina.ApnIngEgrDetFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnIngEgrDetFacade() {
        super(ApnIngEgrDet.class);
    }
    
    @Override
     public List<ApnIngEgrDet> listByIngresosEgresos() {
        Query query = em.createQuery("Select object(i) from ApnIngEgrDet i  order by i.iedDescripcion ");
        return query.getResultList();
    }
    
    @Override
    public List<ApnIngEgrDet> listByIngresosEgresosXDescripcion(String descripcion) {
        Query query = em.createQuery("Select object(i) from ApnIngEgrDet i where UPPER(i.iedDescripcion) like UPPER(CONCAT('%',:descripcion,'%') order by i.iedDescripcion ");
         query.setParameter("descripcion", descripcion);
        return query.getResultList();
    }
    
    @Override
    public List<ApnIngEgrDet> listByIngresosEgresosXPapa(Integer codigo) {
        Query query = em.createQuery("Select object(i) from ApnIngEgrDet i where i.apnIngEgrCab.iecId = :codigo order by i.iedDescripcion");
         query.setParameter("codigo", codigo);
        return query.getResultList();
    }
}
