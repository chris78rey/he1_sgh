/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_PROCESO")
@NamedQueries({
    @NamedQuery(name = "ApnProceso.findAll", query = "SELECT a FROM ApnProceso a")})
public class ApnProceso implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRC_ID")
    private BigDecimal prcId;
    @Column(name = "PRC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prcFecha;
    @Column(name = "PRC_MES")
    private Long prcMes;
    @Column(name = "PRC_ANIO")
    private BigInteger prcAnio;
    @Column(name = "PRC_ESTADO")
    private String prcEstado;

    public ApnProceso() {
    }

    public ApnProceso(BigDecimal prcId) {
        this.prcId = prcId;
    }

    public BigDecimal getPrcId() {
        return prcId;
    }

    public void setPrcId(BigDecimal prcId) {
        this.prcId = prcId;
    }

    public Date getPrcFecha() {
        return prcFecha;
    }

    public void setPrcFecha(Date prcFecha) {
        this.prcFecha = prcFecha;
    }

    public Long getPrcMes() {
        return prcMes;
    }

    public void setPrcMes(Long prcMes) {
        this.prcMes = prcMes;
    }

    public BigInteger getPrcAnio() {
        return prcAnio;
    }

    public void setPrcAnio(BigInteger prcAnio) {
        this.prcAnio = prcAnio;
    }

    public String getPrcEstado() {
        return prcEstado;
    }

    public void setPrcEstado(String prcEstado) {
        this.prcEstado = prcEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prcId != null ? prcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnProceso)) {
            return false;
        }
        ApnProceso other = (ApnProceso) object;
        if ((this.prcId == null && other.prcId != null) || (this.prcId != null && !this.prcId.equals(other.prcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnProceso[ prcId=" + prcId + " ]";
    }
    
}
