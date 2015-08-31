/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "APN_RETENCION_JUDICIAL")
@NamedQueries({
    @NamedQuery(name = "ApnRetencionJudicial.findAll", query = "SELECT a FROM ApnRetencionJudicial a")})
public class ApnRetencionJudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RJU_ID")
    private BigDecimal rjuId;
    @Column(name = "RJU_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rjuDesde;
    @Column(name = "RJU_VALOR")
    private BigDecimal rjuValor;
    @Column(name = "RJU_ACUMULADO")
    private BigDecimal rjuAcumulado;
    @Column(name = "RJU_MONTO")
    private BigDecimal rjuMonto;
    @Column(name = "RJU_NUM_CUOTAS")
    private Long rjuNumCuotas;
    @Column(name = "RJU_DOCUMENTO")
    private String rjuDocumento;
    @Column(name = "RJU_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rjuHasta;
    @Column(name = "RJU_ESTADO")
    private String rjuEstado;
    @Column(name = "RJU_TIPO_ROL")
    private Long rjuTipoRol;
    @Column(name = "RJU_TIPO")
    private Character rjuTipo;
    @Column(name = "RJU_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rjuFechaCreacion;
    @JoinColumn(name = "BRJ_ID", referencedColumnName = "BRJ_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnBeneficRetJudicial apnBeneficRetJudicial;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnRetencionJudicial() {
    }

    public ApnRetencionJudicial(BigDecimal rjuId) {
        this.rjuId = rjuId;
    }

    public BigDecimal getRjuId() {
        return rjuId;
    }

    public void setRjuId(BigDecimal rjuId) {
        this.rjuId = rjuId;
    }

    public Date getRjuDesde() {
        return rjuDesde;
    }

    public void setRjuDesde(Date rjuDesde) {
        this.rjuDesde = rjuDesde;
    }

    public BigDecimal getRjuValor() {
        return rjuValor;
    }

    public void setRjuValor(BigDecimal rjuValor) {
        this.rjuValor = rjuValor;
    }

    public BigDecimal getRjuAcumulado() {
        return rjuAcumulado;
    }

    public void setRjuAcumulado(BigDecimal rjuAcumulado) {
        this.rjuAcumulado = rjuAcumulado;
    }

    public BigDecimal getRjuMonto() {
        return rjuMonto;
    }

    public void setRjuMonto(BigDecimal rjuMonto) {
        this.rjuMonto = rjuMonto;
    }

    public Long getRjuNumCuotas() {
        return rjuNumCuotas;
    }

    public void setRjuNumCuotas(Long rjuNumCuotas) {
        this.rjuNumCuotas = rjuNumCuotas;
    }

    public String getRjuDocumento() {
        return rjuDocumento;
    }

    public void setRjuDocumento(String rjuDocumento) {
        this.rjuDocumento = rjuDocumento;
    }

    public Date getRjuHasta() {
        return rjuHasta;
    }

    public void setRjuHasta(Date rjuHasta) {
        this.rjuHasta = rjuHasta;
    }

    public String getRjuEstado() {
        return rjuEstado;
    }

    public void setRjuEstado(String rjuEstado) {
        this.rjuEstado = rjuEstado;
    }

    public Long getRjuTipoRol() {
        return rjuTipoRol;
    }

    public void setRjuTipoRol(Long rjuTipoRol) {
        this.rjuTipoRol = rjuTipoRol;
    }

    public Character getRjuTipo() {
        return rjuTipo;
    }

    public void setRjuTipo(Character rjuTipo) {
        this.rjuTipo = rjuTipo;
    }

    public Date getRjuFechaCreacion() {
        return rjuFechaCreacion;
    }

    public void setRjuFechaCreacion(Date rjuFechaCreacion) {
        this.rjuFechaCreacion = rjuFechaCreacion;
    }

    public ApnBeneficRetJudicial getApnBeneficRetJudicial() {
        return apnBeneficRetJudicial;
    }

    public void setApnBeneficRetJudicial(ApnBeneficRetJudicial apnBeneficRetJudicial) {
        this.apnBeneficRetJudicial = apnBeneficRetJudicial;
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
        hash += (rjuId != null ? rjuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnRetencionJudicial)) {
            return false;
        }
        ApnRetencionJudicial other = (ApnRetencionJudicial) object;
        if ((this.rjuId == null && other.rjuId != null) || (this.rjuId != null && !this.rjuId.equals(other.rjuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnRetencionJudicial[ rjuId=" + rjuId + " ]";
    }
    
}
