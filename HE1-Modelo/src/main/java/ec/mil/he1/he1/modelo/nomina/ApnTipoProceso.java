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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_TIPO_PROCESO")
@NamedQueries({
    @NamedQuery(name = "ApnTipoProceso.findAll", query = "SELECT a FROM ApnTipoProceso a")})
public class ApnTipoProceso implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TPR_ID")
    private BigDecimal tprId;
    @Column(name = "TPR_DESCRIPCION")
    private String tprDescripcion;
    @Column(name = "TPR_ESTADO")
    private Character tprEstado;
    @OneToMany(mappedBy = "apnTipoProceso", fetch = FetchType.LAZY)
    private List<ApnRol> apnRolList;
    @OneToMany(mappedBy = "apnTipoProceso", fetch = FetchType.LAZY)
    private List<ApnHistoricoDescuento> apnHistoricoDescuentoList;
    @OneToMany(mappedBy = "apnTipoProceso", fetch = FetchType.LAZY)
    private List<ApnHistoricoRol> apnHistoricoRolList;

    public ApnTipoProceso() {
    }

    public ApnTipoProceso(BigDecimal tprId) {
        this.tprId = tprId;
    }

    public BigDecimal getTprId() {
        return tprId;
    }

    public void setTprId(BigDecimal tprId) {
        this.tprId = tprId;
    }

    public String getTprDescripcion() {
        return tprDescripcion;
    }

    public void setTprDescripcion(String tprDescripcion) {
        this.tprDescripcion = tprDescripcion;
    }

    public Character getTprEstado() {
        return tprEstado;
    }

    public void setTprEstado(Character tprEstado) {
        this.tprEstado = tprEstado;
    }

    public List<ApnRol> getApnRolList() {
        return apnRolList;
    }

    public void setApnRolList(List<ApnRol> apnRolList) {
        this.apnRolList = apnRolList;
    }

    public List<ApnHistoricoDescuento> getApnHistoricoDescuentoList() {
        return apnHistoricoDescuentoList;
    }

    public void setApnHistoricoDescuentoList(List<ApnHistoricoDescuento> apnHistoricoDescuentoList) {
        this.apnHistoricoDescuentoList = apnHistoricoDescuentoList;
    }

    public List<ApnHistoricoRol> getApnHistoricoRolList() {
        return apnHistoricoRolList;
    }

    public void setApnHistoricoRolList(List<ApnHistoricoRol> apnHistoricoRolList) {
        this.apnHistoricoRolList = apnHistoricoRolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tprId != null ? tprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnTipoProceso)) {
            return false;
        }
        ApnTipoProceso other = (ApnTipoProceso) object;
        if ((this.tprId == null && other.tprId != null) || (this.tprId != null && !this.tprId.equals(other.tprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnTipoProceso[ tprId=" + tprId + " ]";
    }
    
}
