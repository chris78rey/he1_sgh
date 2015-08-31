/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.servicioseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegUsuario;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author jaime_padilla
 */
@Stateless
@PermitAll
public class SegUsuarioFacade extends AbstractFacade<SegUsuario> implements ec.mil.he1.he1.remotoseguridad.SegUsuarioFacadeRemote {

    @PersistenceContext(unitName = "HE1-PUSeguridad")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUsuarioFacade() {
        super(SegUsuario.class);
    }

    @Override
    public String login(String usuario, String clave) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("PACK_SEGURIDADES.LOGIN_USUARIO");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_USUARIO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_CLAVE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_SALIDA", String.class, ParameterMode.OUT);
        storedProcedure.setParameter("P_USUARIO", usuario);
        storedProcedure.setParameter("P_CLAVE", clave);
        // execute SP
        storedProcedure.execute();
        // get result
        String p_estado = (String) storedProcedure.getOutputParameterValue("P_SALIDA");

        return p_estado;
    }

    @Override
    public List<SegUsuario> findUsuarioXNombre(String nombre) {
        Query query = em.createQuery("Select object(i) from SegUsuario i where UPPER(i.usuNombre) = UPPER(:nombre)");
        query.setParameter("nombre", nombre);
        query.setHint("eclipselink.refresh", true);
        return query.getResultList();
    }

    @Override
    public SegUsuario findUsuarioUnico(String nombre) {
        Query query = em.createQuery("Select object(i) from SegUsuario i where i.usuNombre = :nombre");
        query.setParameter("nombre", nombre);
        query.setHint("eclipselink.refresh", true);
        
        return (SegUsuario) query.getSingleResult();
    }
}
