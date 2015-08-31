/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggUnidad;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggUnidadFacadeRemote {

    void create(CggUnidad cggUnidad);

    void edit(CggUnidad cggUnidad);

    void remove(CggUnidad cggUnidad);

    CggUnidad find(Object id);

    List<CggUnidad> findAll();

    List<CggUnidad> findRange(int[] range);

    int count();
    
}
