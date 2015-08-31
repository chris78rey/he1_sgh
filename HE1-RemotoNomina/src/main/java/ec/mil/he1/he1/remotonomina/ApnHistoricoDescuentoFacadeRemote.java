/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnHistoricoDescuento;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnHistoricoDescuentoFacadeRemote {

    void create(ApnHistoricoDescuento apnHistoricoDescuento);

    void edit(ApnHistoricoDescuento apnHistoricoDescuento);

    void remove(ApnHistoricoDescuento apnHistoricoDescuento);

    ApnHistoricoDescuento find(Object id);

    List<ApnHistoricoDescuento> findAll();

    List<ApnHistoricoDescuento> findRange(int[] range);

    int count();


}
