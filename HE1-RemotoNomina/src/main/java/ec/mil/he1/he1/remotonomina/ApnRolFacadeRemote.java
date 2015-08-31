/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnRol;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnRolFacadeRemote {

    void create(ApnRol apnRol);

    void edit(ApnRol apnRol);

    void remove(ApnRol apnRol);

    ApnRol find(Object id);

    List<ApnRol> findAll();

    List<ApnRol> findRange(int[] range);

    int count();
    
}
