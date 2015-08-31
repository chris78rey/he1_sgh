/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnTipoEmpleado;
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
public class ApnTipoEmpleadoFacade extends AbstractFacade<ApnTipoEmpleado> implements ec.mil.he1.he1.remotonomina.ApnTipoEmpleadoFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnTipoEmpleadoFacade() {
        super(ApnTipoEmpleado.class);
    }

    @Override
    public List<ApnTipoEmpleado> listByTipoEmpleado() {
        Query query = em.createQuery("Select object(i) from ApnTipoEmpleado i where i.temEstado = 'A' order by i.temDescripcion ");
        return query.getResultList();
    }

    @Override
    public List<ApnTipoEmpleado> listByTipoEmpleadoXCodigo(Integer codigo) {
        Query query = em.createQuery("Select object(i) from ApnTipoEmpleado i where i.temId = :codigo ");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }
}
