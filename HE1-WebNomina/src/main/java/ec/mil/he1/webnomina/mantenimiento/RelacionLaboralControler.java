/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.webnomina.mantenimiento;

import ec.mil.he1.he1.modelo.nomina.ApnRelacionLaboral;
import ec.mil.he1.he1.remotonomina.ApnRelacionLaboralFacadeRemote;
import ec.mil.he1.webnomina.enumeracion.EstadoEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.faces.model.SelectItem;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author galo_jaramillo
 */
@Named
@ViewScoped
@PermitAll
public class RelacionLaboralControler implements Serializable {

    private static final Logger LOG = Logger.getLogger(RelacionLaboralControler.class.getName());

    @EJB
    private ApnRelacionLaboralFacadeRemote apnRelacionLaboralFacade;
    private ApnRelacionLaboral editRelacionLaboral;
    private ApnRelacionLaboral selectRelacionLaboral;

    private List<ApnRelacionLaboral> listByRelacionLaboral;
    private List<ApnRelacionLaboral> grupoXDescripcion;
    private ApnRelacionLaboral relacionLaboral;

    private String descpRLL = "";
    private String estadoRelacion = "A";
    private String descripcionRelacion = "";
    private Boolean controlBuscar = true;
    private Boolean validaVacios = true;
    private boolean esNuevo;
    private boolean modoEdicion;
    private List<SelectItem> estadoItems;

    /**
     * Creates a new instance of RelacionLaboralControler
     */
    @PostConstruct
    public void init() {
        grupoXDescripcion = apnRelacionLaboralFacade.listByRelacionLaboral();
        this.modoEdicion = false;
    }

    public void nuevo() {
        //this.editRelacionLaboral = new ApnRelacionLaboral();
        this.modoEdicion = true;
        this.esNuevo = true;

    }

    public boolean validarVacios() {
        System.out.println("entra a validar");
        validaVacios = false;
        descripcionRelacion = descripcionRelacion.trim();
        if (descripcionRelacion.isEmpty()) {
            validaVacios = true;
        }
        return validaVacios;
    }

    public void guardar() {
        LOG.info("Guardar informacion");
        System.out.println("entra a guardar");
        this.apnRelacionLaboralFacade.create(editRelacionLaboral);

        this.modoEdicion = false;
        this.esNuevo = false;

    }

    public void guardarP() {
        System.out.println("entra a guardar");
        System.out.println("descri es " + descpRLL);
        System.out.println("estad es " + estadoRelacion);
        editRelacionLaboral = new ApnRelacionLaboral();
        editRelacionLaboral.setRllDescripcion(descpRLL);
        editRelacionLaboral.setRllEstado(estadoRelacion);
        apnRelacionLaboralFacade.create(editRelacionLaboral);
    }

    public void eliminar() {
        this.apnRelacionLaboralFacade.remove(relacionLaboral);
    }

    public void actualizar() {
        this.apnRelacionLaboralFacade.edit(relacionLaboral);
    }

    public String buscarGrupo() {
        grupoXDescripcion = apnRelacionLaboralFacade.listByRelacionLaboralXDescripcion(descripcionRelacion);
        if (grupoXDescripcion.size() > 0) {

            // controlBuscar = true;
        } else {

            org.primefaces.context.RequestContext.getCurrentInstance().execute("alert('No existe Relacion Laboral relacionado a esa informaciÃ³n');");
        }
        validaVacios = true;
        descripcionRelacion = "";
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

    public List<ApnRelacionLaboral> getListByRelacionLaboral() {
        listByRelacionLaboral = apnRelacionLaboralFacade.listByRelacionLaboral();
        return listByRelacionLaboral;
    }

    public void setListByRelacionLaboral(List<ApnRelacionLaboral> listByRelacionLaboral) {
        this.listByRelacionLaboral = listByRelacionLaboral;
    }

    public List<ApnRelacionLaboral> getGrupoXDescripcion() {
        return grupoXDescripcion;
    }

    public void setGrupoXDescripcion(List<ApnRelacionLaboral> grupoXDescripcion) {
        this.grupoXDescripcion = grupoXDescripcion;
    }

    public String getDescripcionRelacion() {
        return descripcionRelacion;
    }

    public void setDescripcionRelacion(String descripcionRelacion) {
        this.descripcionRelacion = descripcionRelacion;
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

    public ApnRelacionLaboral getRelacionLaboral() {
        return relacionLaboral;
    }

    public void setRelacionLaboral(ApnRelacionLaboral relacionLaboral) {
        this.relacionLaboral = relacionLaboral;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public ApnRelacionLaboral getEditRelacionLaboral() {
        return editRelacionLaboral;
    }

    public void setEditRelacionLaboral(ApnRelacionLaboral editRelacionLaboral) {
        this.editRelacionLaboral = editRelacionLaboral;
    }

    public ApnRelacionLaboral getSelectRelacionLaboral() {
        return selectRelacionLaboral;
    }

    public void setSelectRelacionLaboral(ApnRelacionLaboral selectRelacionLaboral) {
        this.selectRelacionLaboral = selectRelacionLaboral;
    }

    public String getDescpRLL() {
        return descpRLL;
    }

    public void setDescpRLL(String descpRLL) {
        this.descpRLL = descpRLL;
    }

}
