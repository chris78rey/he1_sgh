/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnEstadoEmpleado;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnEstadoEmpleadoFacadeRemote {

    void create(ApnEstadoEmpleado apnEstadoEmpleado);

    void edit(ApnEstadoEmpleado apnEstadoEmpleado);

    void remove(ApnEstadoEmpleado apnEstadoEmpleado);

    ApnEstadoEmpleado find(Object id);

    List<ApnEstadoEmpleado> findAll();

    List<ApnEstadoEmpleado> findRange(int[] range);

    int count();
    
}
