/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggProvincia;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggProvinciaFacadeRemote {

    void create(CggProvincia cggProvincia);

    void edit(CggProvincia cggProvincia);

    void remove(CggProvincia cggProvincia);

    CggProvincia find(Object id);

    List<CggProvincia> findAll();

    List<CggProvincia> findRange(int[] range);

    int count();
    
}
