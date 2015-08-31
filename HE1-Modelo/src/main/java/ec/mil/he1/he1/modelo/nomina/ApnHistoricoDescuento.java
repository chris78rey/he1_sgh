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
@Table(name = "APN_HISTORICO_DESCUENTO")
@NamedQueries({
    @NamedQuery(name = "ApnHistoricoDescuento.findAll", query = "SELECT a FROM ApnHistoricoDescuento a")})
public class ApnHistoricoDescuento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "HDE_ID")
    private BigDecimal hdeId;
    @Column(name = "HDE_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hdeDesde;
    @Column(name = "HDE_VALOR")
    private BigDecimal hdeValor;
    @Column(name = "HDE_DOCUMENTO")
    private String hdeDocumento;
    @Column(name = "HDE_ESTADO")
    private Character hdeEstado;
    @Column(name = "HDE_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hdeHasta;
    @Column(name = "HDE_MES")
    private BigInteger hdeMes;
    @Column(name = "HDE_ANIO")
    private BigInteger hdeAnio;
    @JoinColumn(name = "ECO_ID", referencedColumnName = "ECO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnEntidadConvenio apnEntidadConvenio;
    @JoinColumn(name = "TDE_ID", referencedColumnName = "TDE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnTipoDescuento apnTipoDescuento;
    @JoinColumn(name = "TPR_ID", referencedColumnName = "TPR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnTipoProceso apnTipoProceso;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnHistoricoDescuento() {
    }

    public ApnHistoricoDescuento(BigDecimal hdeId) {
        this.hdeId = hdeId;
    }

    public BigDecimal getHdeId() {
        return hdeId;
    }

    public void setHdeId(BigDecimal hdeId) {
        this.hdeId = hdeId;
    }

    public Date getHdeDesde() {
        return hdeDesde;
    }

    public void setHdeDesde(Date hdeDesde) {
        this.hdeDesde = hdeDesde;
    }

    public BigDecimal getHdeValor() {
        return hdeValor;
    }

    public void setHdeValor(BigDecimal hdeValor) {
        this.hdeValor = hdeValor;
    }

    public String getHdeDocumento() {
        return hdeDocumento;
    }

    public void setHdeDocumento(String hdeDocumento) {
        this.hdeDocumento = hdeDocumento;
    }

    public Character getHdeEstado() {
        return hdeEstado;
    }

    public void setHdeEstado(Character hdeEstado) {
        this.hdeEstado = hdeEstado;
    }

    public Date getHdeHasta() {
        return hdeHasta;
    }

    public void setHdeHasta(Date hdeHasta) {
        this.hdeHasta = hdeHasta;
    }

    public BigInteger getHdeMes() {
        return hdeMes;
    }

    public void setHdeMes(BigInteger hdeMes) {
        this.hdeMes = hdeMes;
    }

    public BigInteger getHdeAnio() {
        return hdeAnio;
    }

    public void setHdeAnio(BigInteger hdeAnio) {
        this.hdeAnio = hdeAnio;
    }

    public ApnEntidadConvenio getApnEntidadConvenio() {
        return apnEntidadConvenio;
    }

    public void setApnEntidadConvenio(ApnEntidadConvenio apnEntidadConvenio) {
        this.apnEntidadConvenio = apnEntidadConvenio;
    }

    public ApnTipoDescuento getApnTipoDescuento() {
        return apnTipoDescuento;
    }

    public void setApnTipoDescuento(ApnTipoDescuento apnTipoDescuento) {
        this.apnTipoDescuento = apnTipoDescuento;
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
        hash += (hdeId != null ? hdeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnHistoricoDescuento)) {
            return false;
        }
        ApnHistoricoDescuento other = (ApnHistoricoDescuento) object;
        if ((this.hdeId == null && other.hdeId != null) || (this.hdeId != null && !this.hdeId.equals(other.hdeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnHistoricoDescuento[ hdeId=" + hdeId + " ]";
    }
    
}
