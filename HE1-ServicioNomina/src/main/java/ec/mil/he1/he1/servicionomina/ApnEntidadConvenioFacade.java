/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnEntidadConvenio;
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
public class ApnEntidadConvenioFacade extends AbstractFacade<ApnEntidadConvenio> implements ec.mil.he1.he1.remotonomina.ApnEntidadConvenioFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnEntidadConvenioFacade() {
        super(ApnEntidadConvenio.class);
    }

    @Override
    public List<ApnEntidadConvenio> listByEntidadConvenio() {
        Query query = em.createQuery("Select object(i) from ApnEntidadConvenio i  order by i.ecoDescripcion");
        return query.getResultList();
    }

    @Override
    public List<ApnEntidadConvenio> listByEntidadConvenioXNombre(String nombre) {
        Query query = em.createQuery("Select object(i) from ApnEntidadConvenio i where UPPER(i.ecoDescripcion) like UPPER(CONCAT('%',:nombre,'%') order by i.ecoDescripcion ");
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

}
