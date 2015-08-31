/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnRelacionLaboral;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnRelacionLaboralFacadeRemote {

    void create(ApnRelacionLaboral apnRelacionLaboral);

    void edit(ApnRelacionLaboral apnRelacionLaboral);

    void remove(ApnRelacionLaboral apnRelacionLaboral);

    ApnRelacionLaboral find(Object id);

    List<ApnRelacionLaboral> findAll();

    List<ApnRelacionLaboral> findRange(int[] range);

    int count();

    public List<ApnRelacionLaboral> listByRelacionLaboral();

    public List<ApnRelacionLaboral> listByRelacionLaboralXCodigo(BigDecimal codigo);

    public List<ApnRelacionLaboral> listByRelacionLaboralXDescripcion(String descripcion);
    
}
