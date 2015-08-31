/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnTipoProceso;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnTipoProcesoFacadeRemote {

    void create(ApnTipoProceso apnTipoProceso);

    void edit(ApnTipoProceso apnTipoProceso);

    void remove(ApnTipoProceso apnTipoProceso);

    ApnTipoProceso find(Object id);

    List<ApnTipoProceso> findAll();

    List<ApnTipoProceso> findRange(int[] range);

    int count();

    public List<ApnTipoProceso> listByRegimenLaboralXCodigo(Integer codigo);

    public List<ApnTipoProceso> listByTipoProceso();
    
}
