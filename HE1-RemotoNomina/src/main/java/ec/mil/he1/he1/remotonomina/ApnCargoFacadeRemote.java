/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnCargo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnCargoFacadeRemote {

    void create(ApnCargo apnCargo);

    void edit(ApnCargo apnCargo);

    void remove(ApnCargo apnCargo);

    ApnCargo find(Object id);

    List<ApnCargo> findAll();

    List<ApnCargo> findRange(int[] range);

    int count();

    public List<ApnCargo> listByCargos();

    public List<ApnCargo> listByCargosXDescripcion(String nombre);
    
}
