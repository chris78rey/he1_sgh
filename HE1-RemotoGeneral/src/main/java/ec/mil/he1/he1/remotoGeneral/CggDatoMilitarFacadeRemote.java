/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggDatoMilitar;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggDatoMilitarFacadeRemote {

    void create(CggDatoMilitar cggDatoMilitar);

    void edit(CggDatoMilitar cggDatoMilitar);

    void remove(CggDatoMilitar cggDatoMilitar);

    CggDatoMilitar find(Object id);

    List<CggDatoMilitar> findAll();

    List<CggDatoMilitar> findRange(int[] range);

    int count();
    
}
