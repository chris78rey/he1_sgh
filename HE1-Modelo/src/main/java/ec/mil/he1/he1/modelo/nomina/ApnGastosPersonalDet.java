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
@Table(name = "APN_GASTOS_PERSONAL_DET")
@NamedQueries({
    @NamedQuery(name = "ApnGastosPersonalDet.findAll", query = "SELECT a FROM ApnGastosPersonalDet a")})
public class ApnGastosPersonalDet implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GPD_ID")
    private BigDecimal gpdId;
    @Column(name = "GPD_VALOR")
    private BigDecimal gpdValor;
    @Column(name = "GPD_ESTADO")
    private Character gpdEstado;
    @Column(name = "GPD_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gpdFecha;
    @JoinColumn(name = "GPC_ID", referencedColumnName = "GPC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnGastosPersonalCab apnGastosPersonalCab;
    @JoinColumn(name = "STD_ID", referencedColumnName = "STD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnSriTipoDescuento apnSriTipoDescuento;

    public ApnGastosPersonalDet() {
    }

    public ApnGastosPersonalDet(BigDecimal gpdId) {
        this.gpdId = gpdId;
    }

    public BigDecimal getGpdId() {
        return gpdId;
    }

    public void setGpdId(BigDecimal gpdId) {
        this.gpdId = gpdId;
    }

    public BigDecimal getGpdValor() {
        return gpdValor;
    }

    public void setGpdValor(BigDecimal gpdValor) {
        this.gpdValor = gpdValor;
    }

    public Character getGpdEstado() {
        return gpdEstado;
    }

    public void setGpdEstado(Character gpdEstado) {
        this.gpdEstado = gpdEstado;
    }

    public Date getGpdFecha() {
        return gpdFecha;
    }

    public void setGpdFecha(Date gpdFecha) {
        this.gpdFecha = gpdFecha;
    }

    public ApnGastosPersonalCab getApnGastosPersonalCab() {
        return apnGastosPersonalCab;
    }

    public void setApnGastosPersonalCab(ApnGastosPersonalCab apnGastosPersonalCab) {
        this.apnGastosPersonalCab = apnGastosPersonalCab;
    }

    public ApnSriTipoDescuento getApnSriTipoDescuento() {
        return apnSriTipoDescuento;
    }

    public void setApnSriTipoDescuento(ApnSriTipoDescuento apnSriTipoDescuento) {
        this.apnSriTipoDescuento = apnSriTipoDescuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gpdId != null ? gpdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnGastosPersonalDet)) {
            return false;
        }
        ApnGastosPersonalDet other = (ApnGastosPersonalDet) object;
        if ((this.gpdId == null && other.gpdId != null) || (this.gpdId != null && !this.gpdId.equals(other.gpdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnGastosPersonalDet[ gpdId=" + gpdId + " ]";
    }
    
}
