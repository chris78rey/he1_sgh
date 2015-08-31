/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.remotonomina.ApnDescuentoEmplFacadeRemote;
import ec.mil.he1.he1.modelo.nomina.ApnDescuentoEmpl;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class ApnDescuentoEmplFacade extends AbstractFacade<ApnDescuentoEmpl> implements ApnDescuentoEmplFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnDescuentoEmplFacade() {
        super(ApnDescuentoEmpl.class);
    }
    
}
