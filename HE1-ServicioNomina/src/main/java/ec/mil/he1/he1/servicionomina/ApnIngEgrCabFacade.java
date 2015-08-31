/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnIngEgrCab;
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
public class ApnIngEgrCabFacade extends AbstractFacade<ApnIngEgrCab> implements ec.mil.he1.he1.remotonomina.ApnIngEgrCabFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnIngEgrCabFacade() {
        super(ApnIngEgrCab.class);
    }

    @Override
    public List<ApnIngEgrCab> listByEntidadConvenio() {
        Query query = em.createQuery("Select object(i) from ApnIngEgrCab i where i.iecEstado = 'A' order by i.iecDescripcion");
        return query.getResultList();
    }

    @Override
    public List<ApnIngEgrCab> listByEntidadConvenioXNombre(String descripcion) {
        Query query = em.createQuery("Select object(i) from ApnIngEgrCab i where UPPER(i.iecDescripcion) like UPPER(CONCAT('%',:descripcion,'%') order by i.iecDescripcion ");
        query.setParameter("descripcion", descripcion);
        return query.getResultList();
    }
}
