/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.serviciotriage;

import ec.mil.he1.he1.modelo.triage.MetUbicacionAtencion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class MetUbicacionAtencionFacade extends AbstractFacade<MetUbicacionAtencion> implements ec.mil.he1.he1.remototriage.MetUbicacionAtencionFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MetUbicacionAtencionFacade() {
        super(MetUbicacionAtencion.class);
    }
    
}
