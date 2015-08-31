/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegPerfilUsuario;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jaime_padilla
 */
@javax.ejb.Remote
public interface SegPerfilUsuarioFacadeRemote {

    void create(SegPerfilUsuario segPerfilUsuario);

    void edit(SegPerfilUsuario segPerfilUsuario);

    void remove(SegPerfilUsuario segPerfilUsuario);

    SegPerfilUsuario find(Object id);

    List<SegPerfilUsuario> findAll();

    List<SegPerfilUsuario> findRange(int[] range);

    int count();

     public List<SegPerfilUsuario> listPerfilXUsuario(BigDecimal idUsuario);
    
}
