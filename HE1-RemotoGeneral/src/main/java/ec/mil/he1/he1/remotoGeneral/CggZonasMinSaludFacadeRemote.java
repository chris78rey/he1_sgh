/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggZonasMinSalud;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggZonasMinSaludFacadeRemote {

    void create(CggZonasMinSalud cggZonasMinSalud);

    void edit(CggZonasMinSalud cggZonasMinSalud);

    void remove(CggZonasMinSalud cggZonasMinSalud);

    CggZonasMinSalud find(Object id);

    List<CggZonasMinSalud> findAll();

    List<CggZonasMinSalud> findRange(int[] range);

    int count();
    
}
