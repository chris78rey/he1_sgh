/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnTipoEmpleado;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnTipoEmpleadoFacadeRemote {

    void create(ApnTipoEmpleado apnTipoEmpleado);

    void edit(ApnTipoEmpleado apnTipoEmpleado);

    void remove(ApnTipoEmpleado apnTipoEmpleado);

    ApnTipoEmpleado find(Object id);

    List<ApnTipoEmpleado> findAll();

    List<ApnTipoEmpleado> findRange(int[] range);

    int count();

    public List<ApnTipoEmpleado> listByTipoEmpleadoXCodigo(Integer codigo);

    public List<ApnTipoEmpleado> listByTipoEmpleado();
    
}
