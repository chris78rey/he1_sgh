/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggParentesco;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggParentescoFacadeRemote {

    void create(CggParentesco cggParentesco);

    void edit(CggParentesco cggParentesco);

    void remove(CggParentesco cggParentesco);

    CggParentesco find(Object id);

    List<CggParentesco> findAll();

    List<CggParentesco> findRange(int[] range);

    int count();
    
}
