/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnMotivoLicencia;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnMotivoLicenciaFacadeRemote {

    void create(ApnMotivoLicencia apnMotivoLicencia);

    void edit(ApnMotivoLicencia apnMotivoLicencia);

    void remove(ApnMotivoLicencia apnMotivoLicencia);

    ApnMotivoLicencia find(Object id);

    List<ApnMotivoLicencia> findAll();

    List<ApnMotivoLicencia> findRange(int[] range);

    int count();
    
}
