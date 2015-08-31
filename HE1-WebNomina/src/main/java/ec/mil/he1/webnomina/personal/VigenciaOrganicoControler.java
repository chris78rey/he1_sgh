/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.webnomina.personal;

import ec.mil.he1.he1.modelo.nomina.ApnOrganicoCab;
import ec.mil.he1.he1.remotonomina.ApnOrganicoCabFacadeRemote;
import ec.mil.he1.webnomina.enumeracion.EstadoEnum;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author galo_jaramillo
 */
@Named(value = "vigenciaOrganico")
@ViewScoped
@PermitAll
public class VigenciaOrganicoControler implements Serializable {

    @EJB
    private ApnOrganicoCabFacadeRemote apnOrganicoCabFacade;

    private List<ApnOrganicoCab> listByOrganicoUnidad;
    private List<ApnOrganicoCab> listByOrganicoUnidadNombre;
    private List<ApnOrganicoCab> grupoOrganicoNombre;
    private ApnOrganicoCab editOrganicoCab;
    private List<SelectItem> estadoItems;

    private Date date3;
    private Boolean validaVacios = true;
    private String descripcionOrganico = "";
    private Date desde;
    private Date hasta;
    private String EstadoOrg = "";
    private char estadoOrganico = 'A';
    private Integer UniSalud;
    
    private boolean modoEdicion;
    private boolean esNuevo;

    @PostConstruct
    public void init() {
        grupoOrganicoNombre = apnOrganicoCabFacade.listByOrganicoUnidad(239);
        this.modoEdicion = true;
    }

    public void nuevoorganico() {
        System.out.println("controlaaa");
        // editOrganicoCab = new ApnOrganicoCab();
        this.modoEdicion = true;
        this.esNuevo = true;
    }

    public void guardarOrganico() {
  
            System.out.println("orgag" + descripcionOrganico);
            UniSalud = 239;
            editOrganicoCab = new ApnOrganicoCab();
            editOrganicoCab.setOcaDescripcion(descripcionOrganico);
            editOrganicoCab.setOcaDesde(desde);
            editOrganicoCab.setOcaHasta(hasta);
            editOrganicoCab.setOcaEstado(estadoOrganico);
            // editOrganicoCab.setCggUnidadSalud(UniSalud) ;
            this.apnOrganicoCabFacade.create(editOrganicoCab);
    
        this.modoEdicion = true;
        this.esNuevo = true;
        this.buscarOrganico();
    }

    public void eliminar() {
        this.apnOrganicoCabFacade.remove(editOrganicoCab);
        this.buscarOrganico();
    }

    public void actualizar() {
        this.apnOrganicoCabFacade.edit(editOrganicoCab);
    }

    public void cancelarOrganico() {
        editOrganicoCab = new ApnOrganicoCab();
        this.modoEdicion = true;
        this.esNuevo = true;
    }

    public boolean validarVacios() {
        System.out.println("entra a validar");
        validaVacios = false;
        descripcionOrganico = descripcionOrganico.trim();
        if (descripcionOrganico.isEmpty()) {
            validaVacios = true;
        }
        return validaVacios;
    }

    public String buscarOrganico() {
        System.out.println("dddd  " + descripcionOrganico);
        grupoOrganicoNombre = apnOrganicoCabFacade.listByOrganicoUnidadNombre(239, descripcionOrganico);
        if (grupoOrganicoNombre.size() > 0) {

            // controlBuscar = true;
        } else {

            org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('No existe Relacion Laboral relacionado a esa informaciÃ³n');");
        }

        descripcionOrganico = "";
        return "";
    }

    public List<SelectItem> getEstadoItems() {

        if (estadoItems == null) {
            estadoItems = new ArrayList<SelectItem>();
            EstadoEnum valor[] = EstadoEnum.values();
            for (EstadoEnum estadoEnum : valor) {
                estadoItems.add(new SelectItem(estadoEnum.toString(),
                        estadoEnum.getEstado()));
            }
        }

        return estadoItems;
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public void setListByOrganicoUnidad(List<ApnOrganicoCab> listByOrganicoUnidad) {
        this.listByOrganicoUnidad = listByOrganicoUnidad;
    }

    public ApnOrganicoCab getEditOrganicoCab() {
        return editOrganicoCab;
    }

    public void setEditOrganicoCab(ApnOrganicoCab editOrganicoCab) {
        this.editOrganicoCab = editOrganicoCab;
    }

    public List<ApnOrganicoCab> getGrupoOrganicoNombre() {
        return grupoOrganicoNombre;
    }

    public void setGrupoOrganicoNombre(List<ApnOrganicoCab> grupoOrganicoNombre) {
        this.grupoOrganicoNombre = grupoOrganicoNombre;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public String getDescripcionOrganico() {
        return descripcionOrganico;
    }

    public void setDescripcionOrganico(String descripcionOrganico) {
        this.descripcionOrganico = descripcionOrganico;
    }

    public char getEstadoOrganico() {
        return estadoOrganico;
    }

    public void setEstadoOrganico(char estadoOrganico) {
        this.estadoOrganico = estadoOrganico;
    }

    public Boolean getValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(Boolean validaVacios) {
        this.validaVacios = validaVacios;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getEstadoOrg() {
        return EstadoOrg;
    }

    public void setEstadoOrg(String EstadoOrg) {
        this.EstadoOrg = EstadoOrg;
    }

    public Integer getUniSalud() {
        return UniSalud;
    }

    public void setUniSalud(Integer UniSalud) {
        this.UniSalud = UniSalud;
    }

}
