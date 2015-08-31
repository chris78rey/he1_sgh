/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegPerfil;
import java.util.List;

/**
 *
 * @author jaime_padilla
 */
@javax.ejb.Remote
public interface SegPerfilFacadeRemote {

    void create(SegPerfil segPerfil);

    void edit(SegPerfil segPerfil);

    void remove(SegPerfil segPerfil);

    SegPerfil find(Object id);

    List<SegPerfil> findAll();

    List<SegPerfil> findRange(int[] range);

    int count();

    public List<SegPerfil> listaPerfilPorGrupo(Integer grupo);

}
