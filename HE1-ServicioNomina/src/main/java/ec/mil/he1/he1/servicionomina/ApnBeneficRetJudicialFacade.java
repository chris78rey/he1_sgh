/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnBeneficRetJudicial;
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
public class ApnBeneficRetJudicialFacade extends AbstractFacade<ApnBeneficRetJudicial> implements ec.mil.he1.he1.remotonomina.ApnBeneficRetJudicialFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnBeneficRetJudicialFacade() {
        super(ApnBeneficRetJudicial.class);
    }
    
    @Override
   public List<ApnBeneficRetJudicial> listByBeneficiarios() {
        Query query = em.createQuery("Select object(i) from ApnBeneficRetJudicial i  order by i.brjApellido ");
        return query.getResultList();
    }
    
    @Override
    public List<ApnBeneficRetJudicial> listByBeneficiariosXApellido(String apellido) {
        Query query = em.createQuery("Select object(i) from ApnBeneficRetJudicial i where UPPER(i.brjApellido) like UPPER(CONCAT('%',:apellido,'%') order by i.brjApellido ");
         query.setParameter("apellido", apellido);
        return query.getResultList();
    }
      
}
