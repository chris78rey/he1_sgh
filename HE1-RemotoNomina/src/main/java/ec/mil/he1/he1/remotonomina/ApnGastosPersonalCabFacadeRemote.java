/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnGastosPersonalCab;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnGastosPersonalCabFacadeRemote {

    void create(ApnGastosPersonalCab apnGastosPersonalCab);

    void edit(ApnGastosPersonalCab apnGastosPersonalCab);

    void remove(ApnGastosPersonalCab apnGastosPersonalCab);

    ApnGastosPersonalCab find(Object id);

    List<ApnGastosPersonalCab> findAll();

    List<ApnGastosPersonalCab> findRange(int[] range);

    int count();

    public List<ApnGastosPersonalCab> listByGastosPersonales();

    public List<ApnGastosPersonalCab> listByGastosPersonalesXPersona(String apellido);

    public List<ApnGastosPersonalCab> listByGastosPersonalesXAnio(Integer codigo);

}
