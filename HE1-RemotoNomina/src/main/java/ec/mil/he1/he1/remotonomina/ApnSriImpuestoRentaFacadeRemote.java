/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnSriImpuestoRenta;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnSriImpuestoRentaFacadeRemote {

    void create(ApnSriImpuestoRenta apnSriImpuestoRenta);

    void edit(ApnSriImpuestoRenta apnSriImpuestoRenta);

    void remove(ApnSriImpuestoRenta apnSriImpuestoRenta);

    ApnSriImpuestoRenta find(Object id);

    List<ApnSriImpuestoRenta> findAll();

    List<ApnSriImpuestoRenta> findRange(int[] range);

    int count();
    
}
