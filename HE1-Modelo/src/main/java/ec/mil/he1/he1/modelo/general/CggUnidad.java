/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

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
@Table(name = "CGG_UNIDAD")
@NamedQueries({
    @NamedQuery(name = "CggUnidad.findAll", query = "SELECT c FROM CggUnidad c")})
public class CggUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "UNI_ID")
    private BigDecimal uniId;
    @Column(name = "UNI_CODIGO")
    private String uniCodigo;
    @Column(name = "UNI_DESCRIPCION")
    private String uniDescripcion;
    @Column(name = "UNI_ESTADO")
    private Character uniEstado;
    @OneToMany(mappedBy = "cggUnidad", fetch = FetchType.LAZY)
    private List<CggUnidadSalud> cggUnidadSaludList;
    @OneToMany(mappedBy = "cggUnidad", fetch = FetchType.LAZY)
    private List<CggDatoMilitar> cggDatoMilitarList;

    public CggUnidad() {
    }

    public CggUnidad(BigDecimal uniId) {
        this.uniId = uniId;
    }

    public BigDecimal getUniId() {
        return uniId;
    }

    public void setUniId(BigDecimal uniId) {
        this.uniId = uniId;
    }

    public String getUniCodigo() {
        return uniCodigo;
    }

    public void setUniCodigo(String uniCodigo) {
        this.uniCodigo = uniCodigo;
    }

    public String getUniDescripcion() {
        return uniDescripcion;
    }

    public void setUniDescripcion(String uniDescripcion) {
        this.uniDescripcion = uniDescripcion;
    }

    public Character getUniEstado() {
        return uniEstado;
    }

    public void setUniEstado(Character uniEstado) {
        this.uniEstado = uniEstado;
    }

    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
    }

    public List<CggDatoMilitar> getCggDatoMilitarList() {
        return cggDatoMilitarList;
    }

    public void setCggDatoMilitarList(List<CggDatoMilitar> cggDatoMilitarList) {
        this.cggDatoMilitarList = cggDatoMilitarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniId != null ? uniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggUnidad)) {
            return false;
        }
        CggUnidad other = (CggUnidad) object;
        if ((this.uniId == null && other.uniId != null) || (this.uniId != null && !this.uniId.equals(other.uniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggUnidad[ uniId=" + uniId + " ]";
    }
    
}
