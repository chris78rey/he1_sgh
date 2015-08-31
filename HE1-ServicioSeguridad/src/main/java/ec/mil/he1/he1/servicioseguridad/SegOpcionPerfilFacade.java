/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicioseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegOpcionPerfil;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jaime_padilla
 */
@Stateless
public class SegOpcionPerfilFacade extends AbstractFacade<SegOpcionPerfil> implements ec.mil.he1.he1.remotoseguridad.SegOpcionPerfilFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegOpcionPerfilFacade() {
        super(SegOpcionPerfil.class);
    }

    @Override
    public List<SegOpcionPerfil> listaOpcionPerfil(BigDecimal opcion) {
        Query query = em.createQuery("Select object(i) from SegOpcionPerfil i where i.segPerfil.perId = :opcion");
        query.setParameter("opcion", opcion);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

}
