/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggDatoContacto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggDatoContactoFacadeRemote {

    void create(CggDatoContacto cggDatoContacto);

    void edit(CggDatoContacto cggDatoContacto);

    void remove(CggDatoContacto cggDatoContacto);

    CggDatoContacto find(Object id);

    List<CggDatoContacto> findAll();

    List<CggDatoContacto> findRange(int[] range);

    int count();
    
}
