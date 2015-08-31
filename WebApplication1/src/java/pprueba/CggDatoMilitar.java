/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "CGG_DATO_MILITAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggDatoMilitar.findAll", query = "SELECT c FROM CggDatoMilitar c"),
    @NamedQuery(name = "CggDatoMilitar.findByDmiId", query = "SELECT c FROM CggDatoMilitar c WHERE c.dmiId = :dmiId"),
    @NamedQuery(name = "CggDatoMilitar.findByPerId", query = "SELECT c FROM CggDatoMilitar c WHERE c.perId = :perId"),
    @NamedQuery(name = "CggDatoMilitar.findByDmiEstado", query = "SELECT c FROM CggDatoMilitar c WHERE c.dmiEstado = :dmiEstado")})
public class CggDatoMilitar implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DMI_ID")
    private BigDecimal dmiId;
    @Column(name = "PER_ID")
    private BigInteger perId;
    @Column(name = "DMI_ESTADO")
    private Character dmiEstado;
    @JoinColumn(name = "GRA_ID", referencedColumnName = "GRA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggGradoMilitar cggGradoMilitar;
    @JoinColumn(name = "UNI_ID", referencedColumnName = "UNI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggUnidad cggUnidad;

    public CggDatoMilitar() {
    }

    public CggDatoMilitar(BigDecimal dmiId) {
        this.dmiId = dmiId;
    }

    public BigDecimal getDmiId() {
        return dmiId;
    }

    public void setDmiId(BigDecimal dmiId) {
        this.dmiId = dmiId;
    }

    public BigInteger getPerId() {
        return perId;
    }

    public void setPerId(BigInteger perId) {
        this.perId = perId;
    }

    public Character getDmiEstado() {
        return dmiEstado;
    }

    public void setDmiEstado(Character dmiEstado) {
        this.dmiEstado = dmiEstado;
    }

    public CggGradoMilitar getCggGradoMilitar() {
        return cggGradoMilitar;
    }

    public void setCggGradoMilitar(CggGradoMilitar cggGradoMilitar) {
        this.cggGradoMilitar = cggGradoMilitar;
    }

    public CggUnidad getCggUnidad() {
        return cggUnidad;
    }

    public void setCggUnidad(CggUnidad cggUnidad) {
        this.cggUnidad = cggUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dmiId != null ? dmiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggDatoMilitar)) {
            return false;
        }
        CggDatoMilitar other = (CggDatoMilitar) object;
        if ((this.dmiId == null && other.dmiId != null) || (this.dmiId != null && !this.dmiId.equals(other.dmiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.CggDatoMilitar[ dmiId=" + dmiId + " ]";
    }
    
}
