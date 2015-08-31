/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggGrupoCultural;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggGrupoCulturalFacadeRemote {

    void create(CggGrupoCultural cggGrupoCultural);

    void edit(CggGrupoCultural cggGrupoCultural);

    void remove(CggGrupoCultural cggGrupoCultural);

    CggGrupoCultural find(Object id);

    List<CggGrupoCultural> findAll();

    List<CggGrupoCultural> findRange(int[] range);

    int count();
    
}
