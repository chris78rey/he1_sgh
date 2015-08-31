/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnResumen;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnResumenFacadeRemote {

    void create(ApnResumen apnResumen);

    void edit(ApnResumen apnResumen);

    void remove(ApnResumen apnResumen);

    ApnResumen find(Object id);

    List<ApnResumen> findAll();

    List<ApnResumen> findRange(int[] range);

    int count();
    
}
