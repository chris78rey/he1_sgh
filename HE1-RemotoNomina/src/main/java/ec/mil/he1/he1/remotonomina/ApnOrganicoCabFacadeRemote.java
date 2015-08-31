/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnOrganicoCab;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnOrganicoCabFacadeRemote {

    void create(ApnOrganicoCab apnOrganicoCab);

    void edit(ApnOrganicoCab apnOrganicoCab);

    void remove(ApnOrganicoCab apnOrganicoCab);

    ApnOrganicoCab find(Object id);

    List<ApnOrganicoCab> findAll();

    List<ApnOrganicoCab> findRange(int[] range);

    int count();
    
}
