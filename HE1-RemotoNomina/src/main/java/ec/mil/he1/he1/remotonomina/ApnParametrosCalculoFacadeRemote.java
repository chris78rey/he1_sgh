/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnParametrosCalculo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnParametrosCalculoFacadeRemote {

    void create(ApnParametrosCalculo apnParametrosCalculo);

    void edit(ApnParametrosCalculo apnParametrosCalculo);

    void remove(ApnParametrosCalculo apnParametrosCalculo);

    ApnParametrosCalculo find(Object id);

    List<ApnParametrosCalculo> findAll();

    List<ApnParametrosCalculo> findRange(int[] range);

    int count();
    
}
