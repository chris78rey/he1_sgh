/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.webseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema;
import ec.mil.he1.he1.remotoseguridad.SegGrupoSistemaFacadeRemote;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author maria_rodriguez
 */
@Named
@ViewScoped
@PermitAll

public class MttoSeguridadesController implements Serializable {
    private Object LOG;

    /**
     * @author maria_rodriguez
     */
    public MttoSeguridadesController() {
    }
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    ////actualizado ok
   
    private String descripcionGrupo = "";
    private String newDescrip = "";
    private Boolean controlBuscar = true;
    private Boolean validaVacios = true;
   

    private SegGrupoSistema editSegGrupoSistema;
    private SegGrupoSistema selectSegGrupoSistema;

 
    private List<SegGrupoSistema> grupoList;
    private List<SegGrupoSistema> grupoSistemaList;

    @EJB
    private SegGrupoSistemaFacadeRemote segGrupoSistemaFacade;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    @PostConstruct
    public void init() {

        grupoList = segGrupoSistemaFacade.listByGrupoPadre();
        SegGrupoSistema obj = new SegGrupoSistema();

    }

    //<editor-fold defaultstate="collapsed" desc="Funciones Tab1 Grupo/Sistema">

    public boolean validarVacios() {
        System.out.println("entra a validar");
         System.out.println("descripcion es "+descripcionGrupo);

        validaVacios = false;
       
        descripcionGrupo = descripcionGrupo.trim();
        if (descripcionGrupo.isEmpty()) {
            validaVacios = true;
        }

        return validaVacios;
    }

    public String buscarGrupo() {

        grupoList = segGrupoSistemaFacade.listByGrupoXNombre(descripcionGrupo);

        if (grupoList.size() > 0) {

            // controlBuscar = true;
        } else {

            org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('No existe Grupo de Sistema relacionado a esta descripción');");
        }

        validaVacios = true;
        descripcionGrupo = "";

        return "";

    }

    public void cancelar() {

    }

   
     public void guardar() {
         System.out.println("entra a guardar");
         System.out.println("la descripcion es "+ descripcionGrupo);
         
         
      SegGrupoSistema obj = new SegGrupoSistema();
      
        obj.setGruDescripcion(descripcionGrupo);
                
           segGrupoSistemaFacade.create(obj);
            
          
    }
     
//      public void guardarP() {
//       
//        if (esNuevo) {
//            this.servicioItem.crearItem(item);
//        } else {
//            this.servicioItem.actualizarItem("rlopez", item);
//        }
//        this.modoEdicion = false;
//        this.esNuevo = false;
//        this.buscarItem();
//    }


    public void onRowToggleGrupo(ToggleEvent event) {
        System.out.println("entra al toggle");

        SegGrupoSistema gpo = new SegGrupoSistema();
        gpo = (SegGrupoSistema) event.getData();
        System.out.println("el gpo es " + gpo);
        if (gpo != null) {
            grupoSistemaList = segGrupoSistemaFacade.listByGrupoHijo(gpo.getGruId());

            if (grupoSistemaList.isEmpty()) {

                org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('No existe registro de sistemas para el Grupo seleccionado.');");

            }

        }

    }

//    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public List<SegGrupoSistema> getGruposistemaList() {

        return grupoList;

    }

    public void setGruposistemaList(List<SegGrupoSistema> gruposistemaList) {
        this.grupoList = gruposistemaList;
    }

    public Boolean getControlBuscar() {
        return controlBuscar;
    }

    public void setControlBuscar(Boolean controlBuscar) {
        this.controlBuscar = controlBuscar;
    }

    public Boolean getValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(Boolean validaVacios) {
        this.validaVacios = validaVacios;
    }

    public SegGrupoSistema getEditSegGrupoSistema() {
        return editSegGrupoSistema;
    }

    public void setEditSegGrupoSistema(SegGrupoSistema editSegGrupoSistema) {
        this.editSegGrupoSistema = editSegGrupoSistema;
    }

    public SegGrupoSistema getSelectSegGrupoSistema() {
        return selectSegGrupoSistema;
    }

    public void setSelectSegGrupoSistema(SegGrupoSistema selectSegGrupoSistema) {
        this.selectSegGrupoSistema = selectSegGrupoSistema;
    }

    public List<SegGrupoSistema> getGrupoSistemaList() {
        return grupoSistemaList;
    }

    public void setGrupoSistemaList(List<SegGrupoSistema> grupoSistemaList) {
        this.grupoSistemaList = grupoSistemaList;
    }

    public List<SegGrupoSistema> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<SegGrupoSistema> grupoList) {
        this.grupoList = grupoList;
    }

    public String getNewDescrip() {
        return newDescrip;
    }

    public void setNewDescrip(String newDescrip) {
        this.newDescrip = newDescrip;
    }

    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }

     //</editor-fold>

   //ACTUALIZADOok
}
