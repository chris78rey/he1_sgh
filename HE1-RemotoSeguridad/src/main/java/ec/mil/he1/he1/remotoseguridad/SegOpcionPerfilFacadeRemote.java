/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegOpcionPerfil;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jaime_padilla
 */
@javax.ejb.Remote
public interface SegOpcionPerfilFacadeRemote {

    void create(SegOpcionPerfil segOpcionPerfil);

    void edit(SegOpcionPerfil segOpcionPerfil);

    void remove(SegOpcionPerfil segOpcionPerfil);

    SegOpcionPerfil find(Object id);

    List<SegOpcionPerfil> findAll();

    List<SegOpcionPerfil> findRange(int[] range);

    int count();

    public List<SegOpcionPerfil> listaOpcionPerfil(BigDecimal opcion);
    
}
