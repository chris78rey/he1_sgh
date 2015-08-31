/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnLicenciaEmpl;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnLicenciaEmplFacadeRemote {

    void create(ApnLicenciaEmpl apnLicenciaEmpl);

    void edit(ApnLicenciaEmpl apnLicenciaEmpl);

    void remove(ApnLicenciaEmpl apnLicenciaEmpl);

    ApnLicenciaEmpl find(Object id);

    List<ApnLicenciaEmpl> findAll();

    List<ApnLicenciaEmpl> findRange(int[] range);

    int count();
    
}
