/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_GASTOS_PERSONAL_CAB")
@NamedQueries({
    @NamedQuery(name = "ApnGastosPersonalCab.findAll", query = "SELECT a FROM ApnGastosPersonalCab a")})
public class ApnGastosPersonalCab implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GPC_ID")
    private BigDecimal gpcId;
    @Column(name = "GPC_ANIO")
    private Integer gpcAnio;
    @Column(name = "GPC_VALOR")
    private BigDecimal gpcValor;
    @Column(name = "GPC_ESTADO")
    private Character gpcEstado;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;
    @OneToMany(mappedBy = "apnGastosPersonalCab", fetch = FetchType.LAZY)
    private List<ApnGastosPersonalDet> apnGastosPersonalDetList;

    public ApnGastosPersonalCab() {
    }

    public ApnGastosPersonalCab(BigDecimal gpcId) {
        this.gpcId = gpcId;
    }

    public BigDecimal getGpcId() {
        return gpcId;
    }

    public void setGpcId(BigDecimal gpcId) {
        this.gpcId = gpcId;
    }

    public Integer getGpcAnio() {
        return gpcAnio;
    }

    public void setGpcAnio(Integer gpcAnio) {
        this.gpcAnio = gpcAnio;
    }

    public BigDecimal getGpcValor() {
        return gpcValor;
    }

    public void setGpcValor(BigDecimal gpcValor) {
        this.gpcValor = gpcValor;
    }

    public Character getGpcEstado() {
        return gpcEstado;
    }

    public void setGpcEstado(Character gpcEstado) {
        this.gpcEstado = gpcEstado;
    }

    public AppEmpleado getAppEmpleado() {
        return appEmpleado;
    }

    public void setAppEmpleado(AppEmpleado appEmpleado) {
        this.appEmpleado = appEmpleado;
    }

    public List<ApnGastosPersonalDet> getApnGastosPersonalDetList() {
        return apnGastosPersonalDetList;
    }

    public void setApnGastosPersonalDetList(List<ApnGastosPersonalDet> apnGastosPersonalDetList) {
        this.apnGastosPersonalDetList = apnGastosPersonalDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gpcId != null ? gpcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnGastosPersonalCab)) {
            return false;
        }
        ApnGastosPersonalCab other = (ApnGastosPersonalCab) object;
        if ((this.gpcId == null && other.gpcId != null) || (this.gpcId != null && !this.gpcId.equals(other.gpcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnGastosPersonalCab[ gpcId=" + gpcId + " ]";
    }
    
}
