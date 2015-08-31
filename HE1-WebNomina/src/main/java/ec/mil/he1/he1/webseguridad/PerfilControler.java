/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.webseguridad;


import ec.mil.he1.he1.modelo.seguridad.SegPerfil;
import ec.mil.he1.he1.remotoseguridad.SegPerfilFacadeRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author GRJM-1
 */
@Named(value = "perfilControler")
@ViewScoped
public class PerfilControler implements Serializable{
    @EJB
    private SegPerfilFacadeRemote segPerfilFacade;
    private List<SegPerfil> findAll;

    public PerfilControler(SegPerfilFacadeRemote segPerfilFacade) {
        this.segPerfilFacade = segPerfilFacade;
    }

    /**
     * Creates a new instance of PerfilControler
     */
    public PerfilControler() {
    }

    /**
     * @return the findAll
     */
    public List<SegPerfil> getFindAll() {
        findAll = segPerfilFacade.findAll();
        return findAll;
    }
    
}
