/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jaime_padilla
 */
@javax.ejb.Remote
public interface SegGrupoSistemaFacadeRemote {

    void create(ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema segGrupoSistema);

    void edit(ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema segGrupoSistema);

    void remove(ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema segGrupoSistema);

    ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema find(Object id);

    List<SegGrupoSistema> findAll();

    List<SegGrupoSistema> findRange(int[] range);

    int count();

    public List<SegGrupoSistema> listByGrupoXNombre(String nombre);

    public List<SegGrupoSistema> listByGrupoSistema();

    public List<SegGrupoSistema> listByGrupoHijo(BigDecimal idGrupo);

    public List<SegGrupoSistema> listByGrupoPadre();

}
