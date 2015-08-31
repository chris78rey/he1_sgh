/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggReligion;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggReligionFacadeRemote {

    void create(CggReligion cggReligion);

    void edit(CggReligion cggReligion);

    void remove(CggReligion cggReligion);

    CggReligion find(Object id);

    List<CggReligion> findAll();

    List<CggReligion> findRange(int[] range);

    int count();
    
}
