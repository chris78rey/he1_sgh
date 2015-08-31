/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.AppEmpleado;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface AppEmpleadoFacadeRemote {

    void create(AppEmpleado appEmpleado);

    void edit(AppEmpleado appEmpleado);

    void remove(AppEmpleado appEmpleado);

    AppEmpleado find(Object id);

    List<AppEmpleado> findAll();

    List<AppEmpleado> findRange(int[] range);

    int count();

    public List<AppEmpleado> listByEmpleadoXCodigo(Integer codigo);

    public List<AppEmpleado> listByEmpleadoXApellido(String apellido);

}
