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
@Table(name = "APN_ING_EGR_CAB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnIngEgrCab.findAll", query = "SELECT a FROM ApnIngEgrCab a"),
    @NamedQuery(name = "ApnIngEgrCab.findByIecId", query = "SELECT a FROM ApnIngEgrCab a WHERE a.iecId = :iecId"),
    @NamedQuery(name = "ApnIngEgrCab.findByIecDescripcion", query = "SELECT a FROM ApnIngEgrCab a WHERE a.iecDescripcion = :iecDescripcion"),
    @NamedQuery(name = "ApnIngEgrCab.findByIecObservacion", query = "SELECT a FROM ApnIngEgrCab a WHERE a.iecObservacion = :iecObservacion"),
    @NamedQuery(name = "ApnIngEgrCab.findByIecEstado", query = "SELECT a FROM ApnIngEgrCab a WHERE a.iecEstado = :iecEstado")})
public class ApnIngEgrCab implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IEC_ID")
    private BigDecimal iecId;
    @Size(max = 50)
    @Column(name = "IEC_DESCRIPCION")
    private String iecDescripcion;
    @Size(max = 100)
    @Column(name = "IEC_OBSERVACION")
    private String iecObservacion;
    @Column(name = "IEC_ESTADO")
    private Character iecEstado;
    @OneToMany(mappedBy = "apnIngEgrCab", fetch = FetchType.LAZY)
    private List<ApnIngEgrDet> apnIngEgrDetList;

    public ApnIngEgrCab() {
    }

    public ApnIngEgrCab(BigDecimal iecId) {
        this.iecId = iecId;
    }

    public BigDecimal getIecId() {
        return iecId;
    }

    public void setIecId(BigDecimal iecId) {
        this.iecId = iecId;
    }

    public String getIecDescripcion() {
        return iecDescripcion;
    }

    public void setIecDescripcion(String iecDescripcion) {
        this.iecDescripcion = iecDescripcion;
    }

    public String getIecObservacion() {
        return iecObservacion;
    }

    public void setIecObservacion(String iecObservacion) {
        this.iecObservacion = iecObservacion;
    }

    public Character getIecEstado() {
        return iecEstado;
    }

    public void setIecEstado(Character iecEstado) {
        this.iecEstado = iecEstado;
    }

    @XmlTransient
    public List<ApnIngEgrDet> getApnIngEgrDetList() {
        return apnIngEgrDetList;
    }

    public void setApnIngEgrDetList(List<ApnIngEgrDet> apnIngEgrDetList) {
        this.apnIngEgrDetList = apnIngEgrDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iecId != null ? iecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnIngEgrCab)) {
            return false;
        }
        ApnIngEgrCab other = (ApnIngEgrCab) object;
        if ((this.iecId == null && other.iecId != null) || (this.iecId != null && !this.iecId.equals(other.iecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnIngEgrCab[ iecId=" + iecId + " ]";
    }
    
}
