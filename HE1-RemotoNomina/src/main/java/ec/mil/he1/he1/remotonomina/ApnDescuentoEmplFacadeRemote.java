/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnDescuentoEmpl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnDescuentoEmplFacadeRemote {

    void create(ApnDescuentoEmpl apnDescuentoEmpl);

    void edit(ApnDescuentoEmpl apnDescuentoEmpl);

    void remove(ApnDescuentoEmpl apnDescuentoEmpl);

    ApnDescuentoEmpl find(Object id);

    List<ApnDescuentoEmpl> findAll();

    List<ApnDescuentoEmpl> findRange(int[] range);

    int count();
    
}
