/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_SRI_DISCAPACIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnSriDiscapacidad.findAll", query = "SELECT a FROM ApnSriDiscapacidad a"),
    @NamedQuery(name = "ApnSriDiscapacidad.findBySdiId", query = "SELECT a FROM ApnSriDiscapacidad a WHERE a.sdiId = :sdiId"),
    @NamedQuery(name = "ApnSriDiscapacidad.findBySdiValorDesde", query = "SELECT a FROM ApnSriDiscapacidad a WHERE a.sdiValorDesde = :sdiValorDesde"),
    @NamedQuery(name = "ApnSriDiscapacidad.findBySdiValorHasta", query = "SELECT a FROM ApnSriDiscapacidad a WHERE a.sdiValorHasta = :sdiValorHasta"),
    @NamedQuery(name = "ApnSriDiscapacidad.findBySdiPorcDescuento", query = "SELECT a FROM ApnSriDiscapacidad a WHERE a.sdiPorcDescuento = :sdiPorcDescuento"),
    @NamedQuery(name = "ApnSriDiscapacidad.findBySdiDesde", query = "SELECT a FROM ApnSriDiscapacidad a WHERE a.sdiDesde = :sdiDesde"),
    @NamedQuery(name = "ApnSriDiscapacidad.findBySdiEstado", query = "SELECT a FROM ApnSriDiscapacidad a WHERE a.sdiEstado = :sdiEstado"),
    @NamedQuery(name = "ApnSriDiscapacidad.findBySdiHasta", query = "SELECT a FROM ApnSriDiscapacidad a WHERE a.sdiHasta = :sdiHasta")})
public class ApnSriDiscapacidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SDI_ID")
    private BigDecimal sdiId;
    @Column(name = "SDI_VALOR_DESDE")
    private Long sdiValorDesde;
    @Column(name = "SDI_VALOR_HASTA")
    private Long sdiValorHasta;
    @Column(name = "SDI_PORC_DESCUENTO")
    private Long sdiPorcDescuento;
    @Column(name = "SDI_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sdiDesde;
    @Column(name = "SDI_ESTADO")
    private Character sdiEstado;
    @Column(name = "SDI_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sdiHasta;

    public ApnSriDiscapacidad() {
    }

    public ApnSriDiscapacidad(BigDecimal sdiId) {
        this.sdiId = sdiId;
    }

    public BigDecimal getSdiId() {
        return sdiId;
    }

    public void setSdiId(BigDecimal sdiId) {
        this.sdiId = sdiId;
    }

    public Long getSdiValorDesde() {
        return sdiValorDesde;
    }

    public void setSdiValorDesde(Long sdiValorDesde) {
        this.sdiValorDesde = sdiValorDesde;
    }

    public Long getSdiValorHasta() {
        return sdiValorHasta;
    }

    public void setSdiValorHasta(Long sdiValorHasta) {
        this.sdiValorHasta = sdiValorHasta;
    }

    public Long getSdiPorcDescuento() {
        return sdiPorcDescuento;
    }

    public void setSdiPorcDescuento(Long sdiPorcDescuento) {
        this.sdiPorcDescuento = sdiPorcDescuento;
    }

    public Date getSdiDesde() {
        return sdiDesde;
    }

    public void setSdiDesde(Date sdiDesde) {
        this.sdiDesde = sdiDesde;
    }

    public Character getSdiEstado() {
        return sdiEstado;
    }

    public void setSdiEstado(Character sdiEstado) {
        this.sdiEstado = sdiEstado;
    }

    public Date getSdiHasta() {
        return sdiHasta;
    }

    public void setSdiHasta(Date sdiHasta) {
        this.sdiHasta = sdiHasta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sdiId != null ? sdiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnSriDiscapacidad)) {
            return false;
        }
        ApnSriDiscapacidad other = (ApnSriDiscapacidad) object;
        if ((this.sdiId == null && other.sdiId != null) || (this.sdiId != null && !this.sdiId.equals(other.sdiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnSriDiscapacidad[ sdiId=" + sdiId + " ]";
    }
    
}
