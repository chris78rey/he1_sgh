/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnSriTipoDescuento;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnSriTipoDescuentoFacadeRemote {

    void create(ApnSriTipoDescuento apnSriTipoDescuento);

    void edit(ApnSriTipoDescuento apnSriTipoDescuento);

    void remove(ApnSriTipoDescuento apnSriTipoDescuento);

    ApnSriTipoDescuento find(Object id);

    List<ApnSriTipoDescuento> findAll();

    List<ApnSriTipoDescuento> findRange(int[] range);

    int count();
    
}
