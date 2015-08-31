/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggPais;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggPaisFacadeRemote {

    void create(CggPais cggPais);

    void edit(CggPais cggPais);

    void remove(CggPais cggPais);

    CggPais find(Object id);

    List<CggPais> findAll();

    List<CggPais> findRange(int[] range);

    int count();
    
}
