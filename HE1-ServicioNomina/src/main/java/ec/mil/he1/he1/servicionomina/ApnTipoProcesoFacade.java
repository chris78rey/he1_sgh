/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnTipoProceso;
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
public class ApnTipoProcesoFacade extends AbstractFacade<ApnTipoProceso> implements ec.mil.he1.he1.remotonomina.ApnTipoProcesoFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnTipoProcesoFacade() {
        super(ApnTipoProceso.class);
    }

    @Override
    public List<ApnTipoProceso> listByTipoProceso() {
        Query query = em.createQuery("Select object(i) from ApnTipoProceso i where i.tprEstado = 'A' order by i.tprDescripcion ");
        return query.getResultList();
    }

    @Override
    public List<ApnTipoProceso> listByRegimenLaboralXCodigo(Integer codigo) {
        Query query = em.createQuery("Select object(i) from ApnTipoProceso i where i.tprId = :codigo ");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }

}
