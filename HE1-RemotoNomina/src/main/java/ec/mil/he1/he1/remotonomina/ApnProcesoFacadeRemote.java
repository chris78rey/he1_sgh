/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnProceso;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnProcesoFacadeRemote {

    void create(ApnProceso apnProceso);

    void edit(ApnProceso apnProceso);

    void remove(ApnProceso apnProceso);

    ApnProceso find(Object id);

    List<ApnProceso> findAll();

    List<ApnProceso> findRange(int[] range);

    int count();
    
}
