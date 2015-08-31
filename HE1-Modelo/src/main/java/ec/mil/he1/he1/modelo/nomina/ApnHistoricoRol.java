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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "APN_HISTORICO_ROL")
@NamedQueries({
    @NamedQuery(name = "ApnHistoricoRol.findAll", query = "SELECT a FROM ApnHistoricoRol a")})
public class ApnHistoricoRol implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "HRO_ID")
    private BigDecimal hroId;
    @Column(name = "HRO_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hroFecha;
    @Column(name = "HRO_VALOR")
    private BigDecimal hroValor;
    @Column(name = "HRO_ANIO")
    private BigInteger hroAnio;
    @Column(name = "HRO_MES")
    private BigInteger hroMes;
    @Column(name = "HRO_ESTADO")
    private Character hroEstado;
    @JoinColumn(name = "IED_ID", referencedColumnName = "IED_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnIngEgrDet apnIngEgrDet;
    @JoinColumn(name = "TPR_ID", referencedColumnName = "TPR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnTipoProceso apnTipoProceso;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnHistoricoRol() {
    }

    public ApnHistoricoRol(BigDecimal hroId) {
        this.hroId = hroId;
    }

    public BigDecimal getHroId() {
        return hroId;
    }

    public void setHroId(BigDecimal hroId) {
        this.hroId = hroId;
    }

    public Date getHroFecha() {
        return hroFecha;
    }

    public void setHroFecha(Date hroFecha) {
        this.hroFecha = hroFecha;
    }

    public BigDecimal getHroValor() {
        return hroValor;
    }

    public void setHroValor(BigDecimal hroValor) {
        this.hroValor = hroValor;
    }

    public BigInteger getHroAnio() {
        return hroAnio;
    }

    public void setHroAnio(BigInteger hroAnio) {
        this.hroAnio = hroAnio;
    }

    public BigInteger getHroMes() {
        return hroMes;
    }

    public void setHroMes(BigInteger hroMes) {
        this.hroMes = hroMes;
    }

    public Character getHroEstado() {
        return hroEstado;
    }

    public void setHroEstado(Character hroEstado) {
        this.hroEstado = hroEstado;
    }

    public ApnIngEgrDet getApnIngEgrDet() {
        return apnIngEgrDet;
    }

    public void setApnIngEgrDet(ApnIngEgrDet apnIngEgrDet) {
        this.apnIngEgrDet = apnIngEgrDet;
    }

    public ApnTipoProceso getApnTipoProceso() {
        return apnTipoProceso;
    }

    public void setApnTipoProceso(ApnTipoProceso apnTipoProceso) {
        this.apnTipoProceso = apnTipoProceso;
    }

    public AppEmpleado getAppEmpleado() {
        return appEmpleado;
    }

    public void setAppEmpleado(AppEmpleado appEmpleado) {
        this.appEmpleado = appEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hroId != null ? hroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnHistoricoRol)) {
            return false;
        }
        ApnHistoricoRol other = (ApnHistoricoRol) object;
        if ((this.hroId == null && other.hroId != null) || (this.hroId != null && !this.hroId.equals(other.hroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnHistoricoRol[ hroId=" + hroId + " ]";
    }
    
}
