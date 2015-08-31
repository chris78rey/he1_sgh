/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggCanton;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggCantonFacadeRemote {

    void create(CggCanton cggCanton);

    void edit(CggCanton cggCanton);

    void remove(CggCanton cggCanton);

    CggCanton find(Object id);

    List<CggCanton> findAll();

    List<CggCanton> findRange(int[] range);

    int count();
    
}
