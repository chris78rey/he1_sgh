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
@Table(name = "APN_TIPO_DESCUENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnTipoDescuento.findAll", query = "SELECT a FROM ApnTipoDescuento a"),
    @NamedQuery(name = "ApnTipoDescuento.findByTdeId", query = "SELECT a FROM ApnTipoDescuento a WHERE a.tdeId = :tdeId"),
    @NamedQuery(name = "ApnTipoDescuento.findByTdeDescripcion", query = "SELECT a FROM ApnTipoDescuento a WHERE a.tdeDescripcion = :tdeDescripcion"),
    @NamedQuery(name = "ApnTipoDescuento.findByTdeEstado", query = "SELECT a FROM ApnTipoDescuento a WHERE a.tdeEstado = :tdeEstado")})
public class ApnTipoDescuento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TDE_ID")
    private BigDecimal tdeId;
    @Size(max = 50)
    @Column(name = "TDE_DESCRIPCION")
    private String tdeDescripcion;
    @Column(name = "TDE_ESTADO")
    private Character tdeEstado;
    @OneToMany(mappedBy = "apnTipoDescuento", fetch = FetchType.LAZY)
    private List<ApnDescuentoEmpl> apnDescuentoEmplList;
    @OneToMany(mappedBy = "apnTipoDescuento", fetch = FetchType.LAZY)
    private List<ApnHistoricoDescuento> apnHistoricoDescuentoList;

    public ApnTipoDescuento() {
    }

    public ApnTipoDescuento(BigDecimal tdeId) {
        this.tdeId = tdeId;
    }

    public BigDecimal getTdeId() {
        return tdeId;
    }

    public void setTdeId(BigDecimal tdeId) {
        this.tdeId = tdeId;
    }

    public String getTdeDescripcion() {
        return tdeDescripcion;
    }

    public void setTdeDescripcion(String tdeDescripcion) {
        this.tdeDescripcion = tdeDescripcion;
    }

    public Character getTdeEstado() {
        return tdeEstado;
    }

    public void setTdeEstado(Character tdeEstado) {
        this.tdeEstado = tdeEstado;
    }

    @XmlTransient
    public List<ApnDescuentoEmpl> getApnDescuentoEmplList() {
        return apnDescuentoEmplList;
    }

    public void setApnDescuentoEmplList(List<ApnDescuentoEmpl> apnDescuentoEmplList) {
        this.apnDescuentoEmplList = apnDescuentoEmplList;
    }

    @XmlTransient
    public List<ApnHistoricoDescuento> getApnHistoricoDescuentoList() {
        return apnHistoricoDescuentoList;
    }

    public void setApnHistoricoDescuentoList(List<ApnHistoricoDescuento> apnHistoricoDescuentoList) {
        this.apnHistoricoDescuentoList = apnHistoricoDescuentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdeId != null ? tdeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnTipoDescuento)) {
            return false;
        }
        ApnTipoDescuento other = (ApnTipoDescuento) object;
        if ((this.tdeId == null && other.tdeId != null) || (this.tdeId != null && !this.tdeId.equals(other.tdeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnTipoDescuento[ tdeId=" + tdeId + " ]";
    }
    
}
