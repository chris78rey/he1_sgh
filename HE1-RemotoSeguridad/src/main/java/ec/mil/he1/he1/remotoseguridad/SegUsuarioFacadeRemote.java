/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegUsuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jaime_padilla
 */
@Remote
public interface SegUsuarioFacadeRemote {

    void create(SegUsuario segUsuario);

    void edit(SegUsuario segUsuario);

    void remove(SegUsuario segUsuario);

    SegUsuario find(Object id);

    List<SegUsuario> findAll();

    List<SegUsuario> findRange(int[] range);

    int count();

    public String login(String usuario, String clave);

    public List<SegUsuario> findUsuarioXNombre(String nombre);

    public SegUsuario findUsuarioUnico(String nombre);

}
