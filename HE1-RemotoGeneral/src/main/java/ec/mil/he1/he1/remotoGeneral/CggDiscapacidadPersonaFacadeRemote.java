/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggDiscapacidadPersona;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggDiscapacidadPersonaFacadeRemote {

    void create(CggDiscapacidadPersona cggDiscapacidadPersona);

    void edit(CggDiscapacidadPersona cggDiscapacidadPersona);

    void remove(CggDiscapacidadPersona cggDiscapacidadPersona);

    CggDiscapacidadPersona find(Object id);

    List<CggDiscapacidadPersona> findAll();

    List<CggDiscapacidadPersona> findRange(int[] range);

    int count();
    
}
