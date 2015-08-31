/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.serviciogeneral;

import ec.mil.he1.he1.modelo.general.CggTipoDiscapacidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class CggTipoDiscapacidadFacade extends AbstractFacade<CggTipoDiscapacidad> implements ec.mil.he1.he1.remotoGeneral.CggTipoDiscapacidadFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CggTipoDiscapacidadFacade() {
        super(CggTipoDiscapacidad.class);
    }
    
}
