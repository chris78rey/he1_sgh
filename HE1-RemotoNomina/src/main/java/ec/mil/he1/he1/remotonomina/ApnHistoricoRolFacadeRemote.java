/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnHistoricoRol;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnHistoricoRolFacadeRemote {

    void create(ApnHistoricoRol apnHistoricoRol);

    void edit(ApnHistoricoRol apnHistoricoRol);

    void remove(ApnHistoricoRol apnHistoricoRol);

    ApnHistoricoRol find(Object id);

    List<ApnHistoricoRol> findAll();

    List<ApnHistoricoRol> findRange(int[] range);

    int count();
    
}
