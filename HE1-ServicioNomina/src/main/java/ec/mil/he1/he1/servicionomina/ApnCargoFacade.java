/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicionomina;

import ec.mil.he1.he1.modelo.nomina.ApnCargo;
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
public class ApnCargoFacade extends AbstractFacade<ApnCargo> implements ec.mil.he1.he1.remotonomina.ApnCargoFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApnCargoFacade() {
        super(ApnCargo.class);
    }

    @Override
    public List<ApnCargo> listByCargos() {
        Query query = em.createQuery("Select object(i) from ApnCargo i where i.carEstado = 'A' order by i.carDescripcion ");
        return query.getResultList();
    }

    @Override
    public List<ApnCargo> listByCargosXDescripcion(String nombre) {
        Query query = em.createQuery("Select object(i) from ApnCargo i where i.carEstado = 'A' and UPPER(i.carDescripcion) like UPPER(CONCAT('%',:nombre,'%')) order by i.carDescripcion");
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

}
