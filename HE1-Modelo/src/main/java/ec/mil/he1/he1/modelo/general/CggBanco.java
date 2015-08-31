/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

import ec.mil.he1.he1.modelo.nomina.ApnBeneficRetJudicial;
import ec.mil.he1.he1.modelo.nomina.AppEmpleado;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "CGG_BANCO")
@NamedQueries({
    @NamedQuery(name = "CggBanco.findAll", query = "SELECT c FROM CggBanco c")})
public class CggBanco implements Serializable {
    @OneToMany(mappedBy = "cggBanco", fetch = FetchType.LAZY)
    private List<ApnBeneficRetJudicial> apnBeneficRetJudicialList;
    @OneToMany(mappedBy = "cggBanco", fetch = FetchType.LAZY)
    private List<AppEmpleado> appEmpleadoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "BAN_ID")
    private BigDecimal banId;
    @Column(name = "BAN_DESCRIPCION")
    private String banDescripcion;
    @Column(name = "BAN_SPI")
    private String banSpi;
    @Column(name = "BAN_ESTADO")
    private Character banEstado;

    public CggBanco() {
    }

    public CggBanco(BigDecimal banId) {
        this.banId = banId;
    }

    public BigDecimal getBanId() {
        return banId;
    }

    public void setBanId(BigDecimal banId) {
        this.banId = banId;
    }

    public String getBanDescripcion() {
        return banDescripcion;
    }

    public void setBanDescripcion(String banDescripcion) {
        this.banDescripcion = banDescripcion;
    }

    public String getBanSpi() {
        return banSpi;
    }

    public void setBanSpi(String banSpi) {
        this.banSpi = banSpi;
    }

    public Character getBanEstado() {
        return banEstado;
    }

    public void setBanEstado(Character banEstado) {
        this.banEstado = banEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banId != null ? banId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggBanco)) {
            return false;
        }
        CggBanco other = (CggBanco) object;
        if ((this.banId == null && other.banId != null) || (this.banId != null && !this.banId.equals(other.banId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggBanco[ banId=" + banId + " ]";
    }

    public List<ApnBeneficRetJudicial> getApnBeneficRetJudicialList() {
        return apnBeneficRetJudicialList;
    }

    public void setApnBeneficRetJudicialList(List<ApnBeneficRetJudicial> apnBeneficRetJudicialList) {
        this.apnBeneficRetJudicialList = apnBeneficRetJudicialList;
    }

    public List<AppEmpleado> getAppEmpleadoList() {
        return appEmpleadoList;
    }

    public void setAppEmpleadoList(List<AppEmpleado> appEmpleadoList) {
        this.appEmpleadoList = appEmpleadoList;
    }
    
}
