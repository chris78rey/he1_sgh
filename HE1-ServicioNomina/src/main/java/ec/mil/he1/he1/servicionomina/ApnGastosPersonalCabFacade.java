/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnGastosPersonalCab;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author galo_jaramillo
 */
@Stateless
public class ApnGastosPersonalCabFacade extends AbstractFacade<ApnGastosPersonalCab> implements ec.mil.he1.he1.remotonomina.ApnGastosPersonalCabFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnGastosPersonalCabFacade() {
        super(ApnGastosPersonalCab.class);
    }
    
    @Override
    public List<ApnGastosPersonalCab> listByGastosPersonales() {
        Query query = em.createQuery("Select object(i) from ApnGastosPersonalCab i  order by i.gpcAnio ");
        return query.getResultList();
    }
    
    @Override
    public List<ApnGastosPersonalCab> listByGastosPersonalesXPersona(String apellido) {
        Query query = em.createQuery("Select object(i) from ApnGastosPersonalCab i where UPPER(i.appEmpleado.cggPersona.perApellido) like UPPER(CONCAT('%',:apellido','%')) order by i.appEmpleado.cggPersona.perApellido ");
         query.setParameter("apellido", apellido);
        return query.getResultList();
    }

    @Override
   public List<ApnGastosPersonalCab> listByGastosPersonalesXAnio(Integer anio) {
        Query query = em.createQuery("Select object(i) from ApnGastosPersonalCab i where i.gpcAnio = :anio order by i.appEmpleado.cggPersona.perApellido ");
         query.setParameter("anio", anio);
        return query.getResultList();
    } 
}
