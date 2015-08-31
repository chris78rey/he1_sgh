/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnCargoEmpleado;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnCargoEmpleadoFacadeRemote {

    void create(ApnCargoEmpleado apnCargoEmpleado);

    void edit(ApnCargoEmpleado apnCargoEmpleado);

    void remove(ApnCargoEmpleado apnCargoEmpleado);

    ApnCargoEmpleado find(Object id);

    List<ApnCargoEmpleado> findAll();

    List<ApnCargoEmpleado> findRange(int[] range);

    int count();
    
}
