/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegOpcionMenu;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jaime_padilla
 */
@javax.ejb.Remote
public interface SegOpcionMenuFacadeRemote {

    void create(SegOpcionMenu segOpcionMenu);

    void edit(SegOpcionMenu segOpcionMenu);

    void remove(SegOpcionMenu segOpcionMenu);

    SegOpcionMenu find(Object id);

    List<SegOpcionMenu> findAll();

    List<SegOpcionMenu> findRange(int[] range);
    
    List<SegOpcionMenu> listaOpciones(BigDecimal sisId);

    public List<SegOpcionMenu> listPadre();

    public List<SegOpcionMenu> listHijos(BigDecimal opc);


    
    List<SegOpcionMenu> listaOpcionesPapa(BigDecimal codigoPapa, BigDecimal sisId);
    int count();

    public List<SegOpcionMenu> listaOpcionesNivel1(BigDecimal codigoPapa);


    public List<SegOpcionMenu> listaOpcionHijo(Integer sistema, Integer opcion);

    public List<SegOpcionMenu> listaOpcionPadre(Integer sistema);
}
