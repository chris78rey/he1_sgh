/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_UBICACION_ATENCION")
@NamedQueries({
    @NamedQuery(name = "MetUbicacionAtencion.findAll", query = "SELECT m FROM MetUbicacionAtencion m")})
public class MetUbicacionAtencion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "UBI_ID")
    private BigDecimal ubiId;
    @Column(name = "UBI_DESCRIPCION")
    private String ubiDescripcion;
    @Column(name = "UBI_SIGLAS")
    private String ubiSiglas;
    @Column(name = "UBI_ESTADO")
    private Character ubiEstado;
    @OneToMany(mappedBy = "metUbicacionAtencion", fetch = FetchType.LAZY)
    private List<MetNivelUbicacion> metNivelUbicacionList;
    @OneToMany(mappedBy = "metUbicacionAtencion", fetch = FetchType.LAZY)
    private List<MetTurno> metTurnoList;
    @OneToMany(mappedBy = "metUbicacionAtencion", fetch = FetchType.LAZY)
    private List<MetTurnoEmpleado> metTurnoEmpleadoList;

    public MetUbicacionAtencion() {
    }

    public MetUbicacionAtencion(BigDecimal ubiId) {
        this.ubiId = ubiId;
    }

    public BigDecimal getUbiId() {
        return ubiId;
    }

    public void setUbiId(BigDecimal ubiId) {
        this.ubiId = ubiId;
    }

    public String getUbiDescripcion() {
        return ubiDescripcion;
    }

    public void setUbiDescripcion(String ubiDescripcion) {
        this.ubiDescripcion = ubiDescripcion;
    }

    public String getUbiSiglas() {
        return ubiSiglas;
    }

    public void setUbiSiglas(String ubiSiglas) {
        this.ubiSiglas = ubiSiglas;
    }

    public Character getUbiEstado() {
        return ubiEstado;
    }

    public void setUbiEstado(Character ubiEstado) {
        this.ubiEstado = ubiEstado;
    }

    public List<MetNivelUbicacion> getMetNivelUbicacionList() {
        return metNivelUbicacionList;
    }

    public void setMetNivelUbicacionList(List<MetNivelUbicacion> metNivelUbicacionList) {
        this.metNivelUbicacionList = metNivelUbicacionList;
    }

    public List<MetTurno> getMetTurnoList() {
        return metTurnoList;
    }

    public void setMetTurnoList(List<MetTurno> metTurnoList) {
        this.metTurnoList = metTurnoList;
    }

    public List<MetTurnoEmpleado> getMetTurnoEmpleadoList() {
        return metTurnoEmpleadoList;
    }

    public void setMetTurnoEmpleadoList(List<MetTurnoEmpleado> metTurnoEmpleadoList) {
        this.metTurnoEmpleadoList = metTurnoEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubiId != null ? ubiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetUbicacionAtencion)) {
            return false;
        }
        MetUbicacionAtencion other = (MetUbicacionAtencion) object;
        if ((this.ubiId == null && other.ubiId != null) || (this.ubiId != null && !this.ubiId.equals(other.ubiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetUbicacionAtencion[ ubiId=" + ubiId + " ]";
    }
    
}
