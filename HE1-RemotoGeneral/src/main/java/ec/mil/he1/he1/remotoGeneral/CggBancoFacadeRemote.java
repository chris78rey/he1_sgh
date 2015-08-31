/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggBanco;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggBancoFacadeRemote {

    void create(ec.mil.he1.he1.modelo.general.CggBanco cggBanco);

    void edit(ec.mil.he1.he1.modelo.general.CggBanco cggBanco);

    void remove(ec.mil.he1.he1.modelo.general.CggBanco cggBanco);

    ec.mil.he1.he1.modelo.general.CggBanco find(Object id);

    List<CggBanco> findAll();

    List<CggBanco> findRange(int[] range);

    int count();
    
}
