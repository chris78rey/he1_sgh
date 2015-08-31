/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggNivelEducacion;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggNivelEducacionFacadeRemote {

    void create(CggNivelEducacion cggNivelEducacion);

    void edit(CggNivelEducacion cggNivelEducacion);

    void remove(CggNivelEducacion cggNivelEducacion);

    CggNivelEducacion find(Object id);

    List<CggNivelEducacion> findAll();

    List<CggNivelEducacion> findRange(int[] range);

    int count();
    
}
