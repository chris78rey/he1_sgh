/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicioseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegUnidadUsuario;
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
public class SegUnidadUsuarioFacade extends AbstractFacade<SegUnidadUsuario> implements ec.mil.he1.he1.remotoseguridad.SegUnidadUsuarioFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUnidadUsuarioFacade() {
        super(SegUnidadUsuario.class);
    }
    
    @Override
    public List<SegUnidadUsuario> listUnidadXUsuario(Integer codigo){
        Query query = em.createQuery("Select object(i) from SegUnidadUsuario i where i.segUsuario.usuId = :codigo ");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }
}
