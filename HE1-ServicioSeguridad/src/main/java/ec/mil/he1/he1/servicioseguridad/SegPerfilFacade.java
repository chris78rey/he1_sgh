/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicioseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegPerfil;
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
public class SegPerfilFacade extends AbstractFacade<SegPerfil> implements ec.mil.he1.he1.remotoseguridad.SegPerfilFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegPerfilFacade() {
        super(SegPerfil.class);
    }
    
    public List<SegPerfil> listaPerfilPorGrupo(Integer grupo){
        Query query = em.createQuery("Select object(i) from SegPerfil i where i.perEstado = 'A' and i.segGrupoSistema.gruId = :grupo order by i.perDescripcion");
        query.setParameter("grupo", grupo);
        return query.getResultList();
    }
}
