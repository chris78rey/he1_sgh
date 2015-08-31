/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.AppEmpleado;
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
public class AppEmpleadoFacade extends AbstractFacade<AppEmpleado> implements ec.mil.he1.he1.remotonomina.AppEmpleadoFacadeRemote {
    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppEmpleadoFacade() {
        super(AppEmpleado.class);
    }
    
   @Override
    public List<AppEmpleado> listByEmpleadoXCodigo(Integer codigo) {
        Query query = em.createQuery("Select object(i) from AppEmpleado i where i.empId = :codigo");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }

    @Override
    public List<AppEmpleado> listByEmpleadoXApellido(String apellido) {
        Query query = em.createQuery("Select object(i) from AppEmpleado i where UPPER(i.cggPersona.perApellido) like UPPER(CONCAT('%',:apellido,'%'))  order by i.cggPersona.perApellido ");
        query.setParameter("apellido", apellido);
        return query.getResultList();
    }
}
