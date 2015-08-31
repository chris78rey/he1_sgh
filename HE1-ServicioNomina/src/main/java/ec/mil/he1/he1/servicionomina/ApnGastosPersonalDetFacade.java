/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnGastosPersonalDet;
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
public class ApnGastosPersonalDetFacade extends AbstractFacade<ApnGastosPersonalDet> implements ec.mil.he1.he1.remotonomina.ApnGastosPersonalDetFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnGastosPersonalDetFacade() {
        super(ApnGastosPersonalDet.class);
    }

    @Override
    public List<ApnGastosPersonalDet> listByGastoPersonalDetalleXPersonaXCodigo(Integer codigo) {
        Query query = em.createQuery("Select object(i) from ApnGastosPersonalDet i where i.gpdId = :codigo order by i.apnSriTipoDescuento.stdDescripcion ");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }

    @Override
    public List<ApnGastosPersonalDet> listByGastoPersonalDetalleXAnio(Integer anio) {
        Query query = em.createQuery("Select object(i) from ApnGastosPersonalDet i where i.apnGastosPersonalCab.gpcAnio = :anio order by i.apnSriTipoDescuento.stdDescripcion ");
        query.setParameter("anio", anio);
        return query.getResultList();
    }

}
