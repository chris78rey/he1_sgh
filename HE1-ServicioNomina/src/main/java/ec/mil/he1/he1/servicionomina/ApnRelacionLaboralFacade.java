/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnRelacionLaboral;
import java.math.BigDecimal;
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
public class ApnRelacionLaboralFacade extends AbstractFacade<ApnRelacionLaboral> implements ec.mil.he1.he1.remotonomina.ApnRelacionLaboralFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnRelacionLaboralFacade() {
        super(ApnRelacionLaboral.class);
    }

    @Override
    public List<ApnRelacionLaboral> listByRelacionLaboral() {
        Query query = em.createQuery("Select object(i) from ApnRelacionLaboral i where i.rllEstado = 'A' order by i.rllId ");
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

   
    @Override
    public List<ApnRelacionLaboral> listByRelacionLaboralXCodigo(BigDecimal codigo) {
        Query query = em.createQuery("Select object(i) from ApnRelacionLaboral i where i.rllId = :codigo ");
        query.setParameter("codigo", codigo);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

    @Override
    public List<ApnRelacionLaboral> listByRelacionLaboralXDescripcion(String descripcion) {
        Query query = em.createQuery("Select object(i) from ApnRelacionLaboral i where UPPER(i.rllDescripcion) like UPPER(CONCAT('%',:descripcion,'%')) order by i.rllDescripcion ");
        query.setParameter("descripcion", descripcion);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }
    
}
