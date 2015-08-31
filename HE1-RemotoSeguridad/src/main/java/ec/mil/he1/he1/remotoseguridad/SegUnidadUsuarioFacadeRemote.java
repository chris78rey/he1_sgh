/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegUnidadUsuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jaime_padilla
 */
@Remote
public interface SegUnidadUsuarioFacadeRemote {

    void create(SegUnidadUsuario segUnidadUsuario);

    void edit(SegUnidadUsuario segUnidadUsuario);

    void remove(SegUnidadUsuario segUnidadUsuario);

    SegUnidadUsuario find(Object id);

    List<SegUnidadUsuario> findAll();

    List<SegUnidadUsuario> findRange(int[] range);

    int count();

    public List<SegUnidadUsuario> listUnidadXUsuario(Integer codigo);

}
