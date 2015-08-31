/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggCtroCoordSalud;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggCtroCoordSaludFacadeRemote {

    void create(CggCtroCoordSalud cggCtroCoordSalud);

    void edit(CggCtroCoordSalud cggCtroCoordSalud);

    void remove(CggCtroCoordSalud cggCtroCoordSalud);

    CggCtroCoordSalud find(Object id);

    List<CggCtroCoordSalud> findAll();

    List<CggCtroCoordSalud> findRange(int[] range);

    int count();
    
}
