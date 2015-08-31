/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicioseguridad;

import ec.mil.he1.he1.remotoseguridad.SegGrupoSistemaFacadeRemote;
import ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema;
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
public class SegGrupoSistemaFacade extends AbstractFacade<SegGrupoSistema> implements SegGrupoSistemaFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegGrupoSistemaFacade() {
        super(SegGrupoSistema.class);
    }

//    @Override
//    public List<SegGrupoSistema> listaGrupoSistema() {
//        Query query = em.createQuery("Select object(i) from SegGrupoSistema i where i.gruEstado = 'A' order by i.gruDescripcion ");
//        return query.getResultList();
//    }
//    
//    @Override
//     public List<SegGrupoSistema> obtenerGrupoPorNombre(String nombre) {
//        Query query = em.createQuery("Select object(i) from SegGrupoSistema i where i.gruEstado = 'A' and UPPER(i.gruDescripcion) like UPPER(CONCAT('%',:nombre,'%')) order by i.gruDescripcion");
//        query.setParameter("nombre", nombre);
//        return query.getResultList();
//    }
//  
    @Override
    public List<SegGrupoSistema> listByGrupoSistema() {
        Query query = em.createQuery("Select object(i) from SegGrupoSistema i where i.gruEstado = 'A' order by i.gruDescripcion ");
           query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

    @Override
    public List<SegGrupoSistema> listByGrupoXNombre(String nombre) {
        Query query = em.createQuery("Select object(i) from SegGrupoSistema i where i.gruUltimoNivel = 'N' and i.segGrupoSistema.gruId = NULL and UPPER(i.gruDescripcion) like UPPER(CONCAT('%',:nombre,'%')) order by i.gruDescripcion");
        query.setParameter("nombre", nombre);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

    @Override
    public List<SegGrupoSistema> listByGrupoPadre() {
        Query query = em.createQuery("Select object(i) from SegGrupoSistema i where i.gruUltimoNivel = 'N' and i.segGrupoSistema.gruId = NULL ");
        // query.setParameter("nombre", nombre);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

    @Override
    public List<SegGrupoSistema> listByGrupoHijo(BigDecimal idGrupo) {
        Query query = em.createQuery("Select object(i) from SegGrupoSistema i where i.segGrupoSistema.gruId = :idGrupo");
        query.setParameter("idGrupo", idGrupo);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

}
