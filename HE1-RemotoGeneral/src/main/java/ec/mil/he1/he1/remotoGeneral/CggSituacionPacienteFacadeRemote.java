/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.remotoGeneral;

import ec.mil.he1.he1.modelo.general.CggSituacionPaciente;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author galo_jaramillo
 */
@Remote
public interface CggSituacionPacienteFacadeRemote {

    void create(CggSituacionPaciente cggSituacionPaciente);

    void edit(CggSituacionPaciente cggSituacionPaciente);

    void remove(CggSituacionPaciente cggSituacionPaciente);

    CggSituacionPaciente find(Object id);

    List<CggSituacionPaciente> findAll();

    List<CggSituacionPaciente> findRange(int[] range);

    int count();
    
}
