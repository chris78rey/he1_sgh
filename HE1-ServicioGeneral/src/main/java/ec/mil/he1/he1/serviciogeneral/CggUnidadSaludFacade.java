/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.serviciogeneral;

import ec.mil.he1.he1.modelo.general.CggUnidadSalud;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class CggUnidadSaludFacade extends AbstractFacade<CggUnidadSalud> implements ec.mil.he1.he1.remotoGeneral.CggUnidadSaludFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CggUnidadSaludFacade() {
        super(CggUnidadSalud.class);
    }
    
}
