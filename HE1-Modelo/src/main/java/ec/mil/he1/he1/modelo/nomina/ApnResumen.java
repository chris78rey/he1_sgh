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
@Table(name = "APN_RESUMEN")
@NamedQueries({
    @NamedQuery(name = "ApnResumen.findAll", query = "SELECT a FROM ApnResumen a")})
public class ApnResumen implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RES_ID")
    private BigDecimal resId;
    @Column(name = "RES_INGRESO")
    private BigDecimal resIngreso;
    @Column(name = "RES_APORTE_IND_IESS")
    private BigDecimal resAporteIndIess;
    @Column(name = "RES_APORTE_PAT_IESS")
    private BigDecimal resAportePatIess;
    @Column(name = "RES_IECE_IESS")
    private BigDecimal resIeceIess;
    @Column(name = "RES_DESC_VARIOS")
    private BigDecimal resDescVarios;
    @Column(name = "RES_DESC_LEY")
    private BigDecimal resDescLey;
    @Column(name = "RES_IMPUESTO_RENTA")
    private BigDecimal resImpuestoRenta;
    @Column(name = "RES_LIQUIDO")
    private BigDecimal resLiquido;
    @Column(name = "RES_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resFecha;
    @Column(name = "RES_MES")
    private BigInteger resMes;
    @Column(name = "RES_ANIO")
    private BigInteger resAnio;
    @Column(name = "PRO_PROCESO")
    private BigInteger proProceso;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnResumen() {
    }

    public ApnResumen(BigDecimal resId) {
        this.resId = resId;
    }

    public BigDecimal getResId() {
        return resId;
    }

    public void setResId(BigDecimal resId) {
        this.resId = resId;
    }

    public BigDecimal getResIngreso() {
        return resIngreso;
    }

    public void setResIngreso(BigDecimal resIngreso) {
        this.resIngreso = resIngreso;
    }

    public BigDecimal getResAporteIndIess() {
        return resAporteIndIess;
    }

    public void setResAporteIndIess(BigDecimal resAporteIndIess) {
        this.resAporteIndIess = resAporteIndIess;
    }

    public BigDecimal getResAportePatIess() {
        return resAportePatIess;
    }

    public void setResAportePatIess(BigDecimal resAportePatIess) {
        this.resAportePatIess = resAportePatIess;
    }

    public BigDecimal getResIeceIess() {
        return resIeceIess;
    }

    public void setResIeceIess(BigDecimal resIeceIess) {
        this.resIeceIess = resIeceIess;
    }

    public BigDecimal getResDescVarios() {
        return resDescVarios;
    }

    public void setResDescVarios(BigDecimal resDescVarios) {
        this.resDescVarios = resDescVarios;
    }

    public BigDecimal getResDescLey() {
        return resDescLey;
    }

    public void setResDescLey(BigDecimal resDescLey) {
        this.resDescLey = resDescLey;
    }

    public BigDecimal getResImpuestoRenta() {
        return resImpuestoRenta;
    }

    public void setResImpuestoRenta(BigDecimal resImpuestoRenta) {
        this.resImpuestoRenta = resImpuestoRenta;
    }

    public BigDecimal getResLiquido() {
        return resLiquido;
    }

    public void setResLiquido(BigDecimal resLiquido) {
        this.resLiquido = resLiquido;
    }

    public Date getResFecha() {
        return resFecha;
    }

    public void setResFecha(Date resFecha) {
        this.resFecha = resFecha;
    }

    public BigInteger getResMes() {
        return resMes;
    }

    public void setResMes(BigInteger resMes) {
        this.resMes = resMes;
    }

    public BigInteger getResAnio() {
        return resAnio;
    }

    public void setResAnio(BigInteger resAnio) {
        this.resAnio = resAnio;
    }

    public BigInteger getProProceso() {
        return proProceso;
    }

    public void setProProceso(BigInteger proProceso) {
        this.proProceso = proProceso;
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
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnResumen)) {
            return false;
        }
        ApnResumen other = (ApnResumen) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnResumen[ resId=" + resId + " ]";
    }
    
}
