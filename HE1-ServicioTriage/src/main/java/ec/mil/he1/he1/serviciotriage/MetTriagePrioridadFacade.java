/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.serviciotriage;

import ec.mil.he1.he1.modelo.triage.MetTriagePrioridad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class MetTriagePrioridadFacade extends AbstractFacade<MetTriagePrioridad> implements ec.mil.he1.he1.remototriage.MetTriagePrioridadFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MetTriagePrioridadFacade() {
        super(MetTriagePrioridad.class);
    }
    
}
