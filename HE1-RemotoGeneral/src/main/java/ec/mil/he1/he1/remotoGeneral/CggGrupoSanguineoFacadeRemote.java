/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggGrupoSanguineo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggGrupoSanguineoFacadeRemote {

    void create(CggGrupoSanguineo cggGrupoSanguineo);

    void edit(CggGrupoSanguineo cggGrupoSanguineo);

    void remove(CggGrupoSanguineo cggGrupoSanguineo);

    CggGrupoSanguineo find(Object id);

    List<CggGrupoSanguineo> findAll();

    List<CggGrupoSanguineo> findRange(int[] range);

    int count();
    
}
