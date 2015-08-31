/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicioseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegPerfilUsuario;
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
public class SegPerfilUsuarioFacade extends AbstractFacade<SegPerfilUsuario> implements ec.mil.he1.he1.remotoseguridad.SegPerfilUsuarioFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegPerfilUsuarioFacade() {
        super(SegPerfilUsuario.class);
    }
    
    @Override
     public List<SegPerfilUsuario> listPerfilXUsuario(BigDecimal idUsuario){
        Query query = em.createQuery("Select object(i) from SegPerfilUsuario i where i.segUsuario.usuId = :idUsuario");
        query.setParameter("idUsuario", idUsuario);
        return query.getResultList();
    }
}
