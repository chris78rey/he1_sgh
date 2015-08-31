/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnOrganicoDet;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnOrganicoDetFacadeRemote {

    void create(ApnOrganicoDet apnOrganicoDet);

    void edit(ApnOrganicoDet apnOrganicoDet);

    void remove(ApnOrganicoDet apnOrganicoDet);

    ApnOrganicoDet find(Object id);

    List<ApnOrganicoDet> findAll();

    List<ApnOrganicoDet> findRange(int[] range);

    int count();
    
}
