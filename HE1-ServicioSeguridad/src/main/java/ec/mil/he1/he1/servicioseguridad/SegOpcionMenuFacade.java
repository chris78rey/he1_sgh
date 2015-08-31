/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicioseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegOpcionMenu;
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
public class SegOpcionMenuFacade extends AbstractFacade<SegOpcionMenu> implements ec.mil.he1.he1.remotoseguridad.SegOpcionMenuFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegOpcionMenuFacade() {
        super(SegOpcionMenu.class);
    }

    @Override
    public List<SegOpcionMenu> listaOpciones(BigDecimal sisId) {

        System.out.println("entra a listaOpciones");
        Query q = em.createQuery("SELECT object(s) FROM SegOpcionMenu s where s.segGrupoSistema.gruId = :sisId and s.opcUltimoNivel= 'N' and s.opcEstado= 'A' order by s.opcOrdenPresentacion asc");
//        Query q = em.createQuery("SELECT s FROM SegOpcionMenu s");

        q.setParameter("sisId", sisId);

        List resultList = q.getResultList();

        System.out.println("resultList = " + resultList.size());
        return resultList;
    }

    @Override
    public List<SegOpcionMenu> listaOpcionesPapa(BigDecimal codigoPapa, BigDecimal sisId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
//    public List<SegOpcionMenu> listaOpcionesNivel1(BigDecimal codigoPapa) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public List<SegOpcionMenu> listaOpcionesNivel1(BigDecimal codigoPapa) {
        ////  recupera las opciones que estan en el nivel 1, no es necesario enviar el sistema ya que el papa es ede un sistema especifico 
        Query q = em.createQuery("SELECT s FROM SegOpcionMenu s WHERE s.opcIdFk=:codigoPapa and s.opcEstado= 'A' order by s.opcOrdenPresentacion asc");
        q.setHint("eclipselink.refresh", true);

        q.setParameter("codigoPapa", codigoPapa);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();

    }

    @Override
    public List<SegOpcionMenu> listaOpcionPadre(Integer sistema) {
        Query query = em.createQuery("Select object(i) from SegOpcionMenu i where i.opcEstado = 'A' AND i.segSistema.sisId = :sistema and i.opcNivel = 0 order by i.opcOrdenPresentacion");
        query.setParameter("sistema", sistema);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

    @Override
    public List<SegOpcionMenu> listaOpcionHijo(Integer sistema, Integer opcion) {
        Query query = em.createQuery("Select object(i) from SegOpcionMenu i where i.opcEstado = 'A' AND i.segSistema.sisId = ?1 and i.opcNivel <> 0 and i.segOpcionMenu.opcId = ?2 order by i.opcOrdenPresentacion");
        //     query.setParameter("sistema", sistema, "opcion", opcion);
        query.setParameter(1, sistema);
        query.setParameter(2, opcion);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

    @Override
    public List<SegOpcionMenu> listPadre() {
        Query q = em.createQuery("SELECT object(o) FROM SegOpcionMenu o WHERE o.segOpcionMenu is NULL ORDER BY o.segSistema.sisId").setHint("eclipselink.refresh", true);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }

    @Override
    public List<SegOpcionMenu> listHijos(BigDecimal opc) {
        Query q = em.createQuery("SELECT object(o) FROM SegOpcionMenu o WHERE o.segOpcionMenu.opcId = :opc ORDER BY o.segSistema.sisId").setParameter("opc", opc).setHint("eclipselink.refresh", true);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }

}
