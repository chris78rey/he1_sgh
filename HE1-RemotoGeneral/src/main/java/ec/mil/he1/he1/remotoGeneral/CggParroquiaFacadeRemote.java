/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggParroquia;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggParroquiaFacadeRemote {

    void create(CggParroquia cggParroquia);

    void edit(CggParroquia cggParroquia);

    void remove(CggParroquia cggParroquia);

    CggParroquia find(Object id);

    List<CggParroquia> findAll();

    List<CggParroquia> findRange(int[] range);

    int count();
    
}
