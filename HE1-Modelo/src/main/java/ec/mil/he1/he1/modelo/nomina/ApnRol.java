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
@Table(name = "APN_ROL")
@NamedQueries({
    @NamedQuery(name = "ApnRol.findAll", query = "SELECT a FROM ApnRol a")})
public class ApnRol implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ROL_ID")
    private BigDecimal rolId;
    @Column(name = "ROL_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolFecha;
    @Column(name = "ROL_VALOR")
    private BigDecimal rolValor;
    @Column(name = "ROL_MES")
    private BigInteger rolMes;
    @Column(name = "ROL_ANIO")
    private BigInteger rolAnio;
    @JoinColumn(name = "IED_ID", referencedColumnName = "IED_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnIngEgrDet apnIngEgrDet;
    @JoinColumn(name = "TPR_ID", referencedColumnName = "TPR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnTipoProceso apnTipoProceso;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnRol() {
    }

    public ApnRol(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public BigDecimal getRolId() {
        return rolId;
    }

    public void setRolId(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public Date getRolFecha() {
        return rolFecha;
    }

    public void setRolFecha(Date rolFecha) {
        this.rolFecha = rolFecha;
    }

    public BigDecimal getRolValor() {
        return rolValor;
    }

    public void setRolValor(BigDecimal rolValor) {
        this.rolValor = rolValor;
    }

    public BigInteger getRolMes() {
        return rolMes;
    }

    public void setRolMes(BigInteger rolMes) {
        this.rolMes = rolMes;
    }

    public BigInteger getRolAnio() {
        return rolAnio;
    }

    public void setRolAnio(BigInteger rolAnio) {
        this.rolAnio = rolAnio;
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
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnRol)) {
            return false;
        }
        ApnRol other = (ApnRol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnRol[ rolId=" + rolId + " ]";
    }
    
}
