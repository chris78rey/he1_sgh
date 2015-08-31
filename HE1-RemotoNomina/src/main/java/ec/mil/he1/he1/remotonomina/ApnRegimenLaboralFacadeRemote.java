/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnRegimenLaboral;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnRegimenLaboralFacadeRemote {

    void create(ApnRegimenLaboral apnRegimenLaboral);

    void edit(ApnRegimenLaboral apnRegimenLaboral);

    void remove(ApnRegimenLaboral apnRegimenLaboral);

    ApnRegimenLaboral find(Object id);

    List<ApnRegimenLaboral> findAll();

    List<ApnRegimenLaboral> findRange(int[] range);

    int count();

    public List<ApnRegimenLaboral> listByRegimenLaboralXCodigo(Integer codigo);

    public List<ApnRegimenLaboral> listByRegimenLaboral();
    
}
