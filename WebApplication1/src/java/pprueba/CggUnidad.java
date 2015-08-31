/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "CGG_UNIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggUnidad.findAll", query = "SELECT c FROM CggUnidad c"),
    @NamedQuery(name = "CggUnidad.findByUniId", query = "SELECT c FROM CggUnidad c WHERE c.uniId = :uniId"),
    @NamedQuery(name = "CggUnidad.findByUniCodigo", query = "SELECT c FROM CggUnidad c WHERE c.uniCodigo = :uniCodigo"),
    @NamedQuery(name = "CggUnidad.findByUniDescripcion", query = "SELECT c FROM CggUnidad c WHERE c.uniDescripcion = :uniDescripcion"),
    @NamedQuery(name = "CggUnidad.findByUniEstado", query = "SELECT c FROM CggUnidad c WHERE c.uniEstado = :uniEstado")})
public class CggUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNI_ID")
    private BigDecimal uniId;
    @Size(max = 20)
    @Column(name = "UNI_CODIGO")
    private String uniCodigo;
    @Size(max = 100)
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

    @XmlTransient
    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
    }

    @XmlTransient
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
        return "pprueba.CggUnidad[ uniId=" + uniId + " ]";
    }
    
}
