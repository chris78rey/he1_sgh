/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggFuerza;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggFuerzaFacadeRemote {

    void create(CggFuerza cggFuerza);

    void edit(CggFuerza cggFuerza);

    void remove(CggFuerza cggFuerza);

    CggFuerza find(Object id);

    List<CggFuerza> findAll();

    List<CggFuerza> findRange(int[] range);

    int count();
    
}
