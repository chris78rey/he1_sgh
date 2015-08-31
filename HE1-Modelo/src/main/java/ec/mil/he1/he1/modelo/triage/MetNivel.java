/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "MET_NIVEL")
@NamedQueries({
    @NamedQuery(name = "MetNivel.findAll", query = "SELECT m FROM MetNivel m")})
public class MetNivel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NIV_ID")
    private BigDecimal nivId;
    @Column(name = "NIV_DESCRIPCION")
    private String nivDescripcion;
    @Column(name = "NIV_CLASIFICACION")
    private Character nivClasificacion;
    @Column(name = "NIV_PRIORIDAD")
    private Character nivPrioridad;
    @Column(name = "NIV_TIEMPO_MIN")
    private BigInteger nivTiempoMin;
    @Column(name = "NIV_UNIDAD_TIEMPO_MIN")
    private Character nivUnidadTiempoMin;
    @Column(name = "NIV_TIEMPO_MAX")
    private BigInteger nivTiempoMax;
    @Column(name = "NIV_UNIDAD_TIEMPO_MAX")
    private Character nivUnidadTiempoMax;
    @Column(name = "NIV_TIEMPO_ATENCION")
    private String nivTiempoAtencion;
    @Column(name = "NIV_COLOR")
    private String nivColor;
    @Column(name = "NIV_ESTADO")
    private Character nivEstado;
    @OneToMany(mappedBy = "metNivel", fetch = FetchType.LAZY)
    private List<MetNivelUbicacion> metNivelUbicacionList;

    public MetNivel() {
    }

    public MetNivel(BigDecimal nivId) {
        this.nivId = nivId;
    }

    public BigDecimal getNivId() {
        return nivId;
    }

    public void setNivId(BigDecimal nivId) {
        this.nivId = nivId;
    }

    public String getNivDescripcion() {
        return nivDescripcion;
    }

    public void setNivDescripcion(String nivDescripcion) {
        this.nivDescripcion = nivDescripcion;
    }

    public Character getNivClasificacion() {
        return nivClasificacion;
    }

    public void setNivClasificacion(Character nivClasificacion) {
        this.nivClasificacion = nivClasificacion;
    }

    public Character getNivPrioridad() {
        return nivPrioridad;
    }

    public void setNivPrioridad(Character nivPrioridad) {
        this.nivPrioridad = nivPrioridad;
    }

    public BigInteger getNivTiempoMin() {
        return nivTiempoMin;
    }

    public void setNivTiempoMin(BigInteger nivTiempoMin) {
        this.nivTiempoMin = nivTiempoMin;
    }

    public Character getNivUnidadTiempoMin() {
        return nivUnidadTiempoMin;
    }

    public void setNivUnidadTiempoMin(Character nivUnidadTiempoMin) {
        this.nivUnidadTiempoMin = nivUnidadTiempoMin;
    }

    public BigInteger getNivTiempoMax() {
        return nivTiempoMax;
    }

    public void setNivTiempoMax(BigInteger nivTiempoMax) {
        this.nivTiempoMax = nivTiempoMax;
    }

    public Character getNivUnidadTiempoMax() {
        return nivUnidadTiempoMax;
    }

    public void setNivUnidadTiempoMax(Character nivUnidadTiempoMax) {
        this.nivUnidadTiempoMax = nivUnidadTiempoMax;
    }

    public String getNivTiempoAtencion() {
        return nivTiempoAtencion;
    }

    public void setNivTiempoAtencion(String nivTiempoAtencion) {
        this.nivTiempoAtencion = nivTiempoAtencion;
    }

    public String getNivColor() {
        return nivColor;
    }

    public void setNivColor(String nivColor) {
        this.nivColor = nivColor;
    }

    public Character getNivEstado() {
        return nivEstado;
    }

    public void setNivEstado(Character nivEstado) {
        this.nivEstado = nivEstado;
    }

    public List<MetNivelUbicacion> getMetNivelUbicacionList() {
        return metNivelUbicacionList;
    }

    public void setMetNivelUbicacionList(List<MetNivelUbicacion> metNivelUbicacionList) {
        this.metNivelUbicacionList = metNivelUbicacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivId != null ? nivId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetNivel)) {
            return false;
        }
        MetNivel other = (MetNivel) object;
        if ((this.nivId == null && other.nivId != null) || (this.nivId != null && !this.nivId.equals(other.nivId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetNivel[ nivId=" + nivId + " ]";
    }
    
}
