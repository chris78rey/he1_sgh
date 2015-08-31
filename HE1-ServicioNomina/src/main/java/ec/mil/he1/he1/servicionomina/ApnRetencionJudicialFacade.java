/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnRetencionJudicial;
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
public class ApnRetencionJudicialFacade extends AbstractFacade<ApnRetencionJudicial> implements ec.mil.he1.he1.remotonomina.ApnRetencionJudicialFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnRetencionJudicialFacade() {
        super(ApnRetencionJudicial.class);
    }
     @Override
    public List<ApnRetencionJudicial> listByEmpleadoRetencionXCodigo(Integer codigo) {
        Query query = em.createQuery("Select object(i) from ApnRetencionJudicial i where i.appEmpleado.empId = :codigo");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }

    @Override
    public List<ApnRetencionJudicial> listByEmpleadoRetencionXApellido(String apellido) {
        Query query = em.createQuery("Select object(i) from ApnRetencionJudicial i where UPPER(i.appEmpleado.cggPersona.perApellido) like UPPER(CONCAT('%',:apellido,'%'))  order by i.cggPersona.perApellido ");
        query.setParameter("apellido", apellido);
        return query.getResultList();
    }
}
