/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotonomina;

import ec.mil.he1.he1.modelo.nomina.ApnRetencionJudicial;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface ApnRetencionJudicialFacadeRemote {

    void create(ApnRetencionJudicial apnRetencionJudicial);

    void edit(ApnRetencionJudicial apnRetencionJudicial);

    void remove(ApnRetencionJudicial apnRetencionJudicial);

    ApnRetencionJudicial find(Object id);

    List<ApnRetencionJudicial> findAll();

    List<ApnRetencionJudicial> findRange(int[] range);

    int count();

    public List<ApnRetencionJudicial> listByEmpleadoRetencionXApellido(String apellido);

    public List<ApnRetencionJudicial> listByEmpleadoRetencionXCodigo(Integer codigo);
    
}
