/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnNivelServPub;
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
public class ApnNivelServPubFacade extends AbstractFacade<ApnNivelServPub> implements ec.mil.he1.he1.remotonomina.ApnNivelServPubFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnNivelServPubFacade() {
        super(ApnNivelServPub.class);
    }
    
    @Override
    public List<ApnNivelServPub> listByNivelSP() {
        Query query = em.createQuery("Select object(i) from ApnNivelServPub i where i.nivEstado = 'A' order by i.nivNivel ");
        return query.getResultList();
    }

    @Override
    public List<ApnNivelServPub> listByNivelXCodigo(Integer codigo) {
        Query query = em.createQuery("Select object(i) from ApnNivelServPub i where i.nivId = :codigo ");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }
    
}
