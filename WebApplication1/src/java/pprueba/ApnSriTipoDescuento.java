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
@Table(name = "APN_SRI_TIPO_DESCUENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnSriTipoDescuento.findAll", query = "SELECT a FROM ApnSriTipoDescuento a"),
    @NamedQuery(name = "ApnSriTipoDescuento.findByStdId", query = "SELECT a FROM ApnSriTipoDescuento a WHERE a.stdId = :stdId"),
    @NamedQuery(name = "ApnSriTipoDescuento.findByStdDescripcion", query = "SELECT a FROM ApnSriTipoDescuento a WHERE a.stdDescripcion = :stdDescripcion"),
    @NamedQuery(name = "ApnSriTipoDescuento.findByStdEstado", query = "SELECT a FROM ApnSriTipoDescuento a WHERE a.stdEstado = :stdEstado")})
public class ApnSriTipoDescuento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STD_ID")
    private BigDecimal stdId;
    @Size(max = 50)
    @Column(name = "STD_DESCRIPCION")
    private String stdDescripcion;
    @Column(name = "STD_ESTADO")
    private Character stdEstado;
    @OneToMany(mappedBy = "apnSriTipoDescuento", fetch = FetchType.LAZY)
    private List<ApnGastosPersonalDet> apnGastosPersonalDetList;

    public ApnSriTipoDescuento() {
    }

    public ApnSriTipoDescuento(BigDecimal stdId) {
        this.stdId = stdId;
    }

    public BigDecimal getStdId() {
        return stdId;
    }

    public void setStdId(BigDecimal stdId) {
        this.stdId = stdId;
    }

    public String getStdDescripcion() {
        return stdDescripcion;
    }

    public void setStdDescripcion(String stdDescripcion) {
        this.stdDescripcion = stdDescripcion;
    }

    public Character getStdEstado() {
        return stdEstado;
    }

    public void setStdEstado(Character stdEstado) {
        this.stdEstado = stdEstado;
    }

    @XmlTransient
    public List<ApnGastosPersonalDet> getApnGastosPersonalDetList() {
        return apnGastosPersonalDetList;
    }

    public void setApnGastosPersonalDetList(List<ApnGastosPersonalDet> apnGastosPersonalDetList) {
        this.apnGastosPersonalDetList = apnGastosPersonalDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdId != null ? stdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnSriTipoDescuento)) {
            return false;
        }
        ApnSriTipoDescuento other = (ApnSriTipoDescuento) object;
        if ((this.stdId == null && other.stdId != null) || (this.stdId != null && !this.stdId.equals(other.stdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnSriTipoDescuento[ stdId=" + stdId + " ]";
    }
    
}
