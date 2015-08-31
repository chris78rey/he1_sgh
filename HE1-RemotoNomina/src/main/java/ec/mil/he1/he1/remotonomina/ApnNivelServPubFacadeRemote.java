/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnNivelServPub;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnNivelServPubFacadeRemote {

    void create(ApnNivelServPub apnNivelServPub);

    void edit(ApnNivelServPub apnNivelServPub);

    void remove(ApnNivelServPub apnNivelServPub);

    ApnNivelServPub find(Object id);

    List<ApnNivelServPub> findAll();

    List<ApnNivelServPub> findRange(int[] range);

    int count();

    public List<ApnNivelServPub> listByNivelSP();

    public List<ApnNivelServPub> listByNivelXCodigo(Integer codigo);
    
}
