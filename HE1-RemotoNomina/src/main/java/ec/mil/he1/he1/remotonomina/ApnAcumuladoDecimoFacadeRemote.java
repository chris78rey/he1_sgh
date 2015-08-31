/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnAcumuladoDecimo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnAcumuladoDecimoFacadeRemote {

    void create(ApnAcumuladoDecimo apnAcumuladoDecimo);

    void edit(ApnAcumuladoDecimo apnAcumuladoDecimo);

    void remove(ApnAcumuladoDecimo apnAcumuladoDecimo);

    ApnAcumuladoDecimo find(Object id);

    List<ApnAcumuladoDecimo> findAll();

    List<ApnAcumuladoDecimo> findRange(int[] range);

    int count();
    
}
