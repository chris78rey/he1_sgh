/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnSriTipoDescuento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class ApnSriTipoDescuentoFacade extends AbstractFacade<ApnSriTipoDescuento> implements ec.mil.he1.he1.remotonomina.ApnSriTipoDescuentoFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnSriTipoDescuentoFacade() {
        super(ApnSriTipoDescuento.class);
    }
    
}
