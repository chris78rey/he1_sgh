/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggTipoDiscapacidad;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggTipoDiscapacidadFacadeRemote {

    void create(CggTipoDiscapacidad cggTipoDiscapacidad);

    void edit(CggTipoDiscapacidad cggTipoDiscapacidad);

    void remove(CggTipoDiscapacidad cggTipoDiscapacidad);

    CggTipoDiscapacidad find(Object id);

    List<CggTipoDiscapacidad> findAll();

    List<CggTipoDiscapacidad> findRange(int[] range);

    int count();
    
}
