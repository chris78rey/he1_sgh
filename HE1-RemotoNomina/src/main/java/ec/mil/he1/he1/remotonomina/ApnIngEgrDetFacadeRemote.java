/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnIngEgrDet;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnIngEgrDetFacadeRemote {

    void create(ApnIngEgrDet apnIngEgrDet);

    void edit(ApnIngEgrDet apnIngEgrDet);

    void remove(ApnIngEgrDet apnIngEgrDet);

    ApnIngEgrDet find(Object id);

    List<ApnIngEgrDet> findAll();

    List<ApnIngEgrDet> findRange(int[] range);

    int count();

    public List<ApnIngEgrDet> listByIngresosEgresosXDescripcion(String descripcion);

    public List<ApnIngEgrDet> listByIngresosEgresos();

    public List<ApnIngEgrDet> listByIngresosEgresosXPapa(Integer codigo);
    
}
