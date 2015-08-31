/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnDependencia;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnDependenciaFacadeRemote {

    void create(ApnDependencia apnDependencia);

    void edit(ApnDependencia apnDependencia);

    void remove(ApnDependencia apnDependencia);

    ApnDependencia find(Object id);

    List<ApnDependencia> findAll();

    List<ApnDependencia> findRange(int[] range);

    int count();
    
}
