/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnIngEgrCab;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnIngEgrCabFacadeRemote {

    void create(ApnIngEgrCab apnIngEgrCab);

    void edit(ApnIngEgrCab apnIngEgrCab);

    void remove(ApnIngEgrCab apnIngEgrCab);

    ApnIngEgrCab find(Object id);

    List<ApnIngEgrCab> findAll();

    List<ApnIngEgrCab> findRange(int[] range);

    int count();

    public List<ApnIngEgrCab> listByEntidadConvenio();

    public List<ApnIngEgrCab> listByEntidadConvenioXNombre(String nombre);
    
}
