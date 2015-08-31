/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.serviciotriage;

import ec.mil.he1.he1.modelo.triage.MetMotivoConsulta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class MetMotivoConsultaFacade extends AbstractFacade<MetMotivoConsulta> implements ec.mil.he1.he1.remototriage.MetMotivoConsultaFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MetMotivoConsultaFacade() {
        super(MetMotivoConsulta.class);
    }
    
}
