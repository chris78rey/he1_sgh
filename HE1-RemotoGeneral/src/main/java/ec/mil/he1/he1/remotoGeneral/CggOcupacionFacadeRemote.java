/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggOcupacion;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggOcupacionFacadeRemote {

    void create(CggOcupacion cggOcupacion);

    void edit(CggOcupacion cggOcupacion);

    void remove(CggOcupacion cggOcupacion);

    CggOcupacion find(Object id);

    List<CggOcupacion> findAll();

    List<CggOcupacion> findRange(int[] range);

    int count();
    
}
