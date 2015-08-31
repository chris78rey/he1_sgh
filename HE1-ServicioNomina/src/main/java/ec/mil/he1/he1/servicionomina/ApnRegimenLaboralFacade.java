/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnRegimenLaboral;
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
public class ApnRegimenLaboralFacade extends AbstractFacade<ApnRegimenLaboral> implements ec.mil.he1.he1.remotonomina.ApnRegimenLaboralFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnRegimenLaboralFacade() {
        super(ApnRegimenLaboral.class);
    }
    
    @Override
    public List<ApnRegimenLaboral> listByRegimenLaboral() {
        Query query = em.createQuery("Select object(i) from ApnRegimenLaboral i where i.rlaEstado = 'A' order by i.rlaDescripcion ");
        return query.getResultList();
    }

    @Override
    public List<ApnRegimenLaboral> listByRegimenLaboralXCodigo(Integer codigo) {
        Query query = em.createQuery("Select object(i) from ApnRegimenLaboral i where i.rlaId = :codigo ");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }
}
