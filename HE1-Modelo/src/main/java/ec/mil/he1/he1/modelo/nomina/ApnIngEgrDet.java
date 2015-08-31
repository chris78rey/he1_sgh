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
@Table(name = "APN_ING_EGR_DET")
@NamedQueries({
    @NamedQuery(name = "ApnIngEgrDet.findAll", query = "SELECT a FROM ApnIngEgrDet a")})
public class ApnIngEgrDet implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IED_ID")
    private BigDecimal iedId;
    @Column(name = "IED_DESCRIPCION")
    private String iedDescripcion;
    @Column(name = "IED_CTA_CONTABLE")
    private String iedCtaContable;
    @Column(name = "IED_CTA_PRESUPUESTO")
    private String iedCtaPresupuesto;
    @Column(name = "IED_ESTADO")
    private String iedEstado;
    @JoinColumn(name = "IEC_ID", referencedColumnName = "IEC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnIngEgrCab apnIngEgrCab;
    @OneToMany(mappedBy = "apnIngEgrDet", fetch = FetchType.LAZY)
    private List<ApnRol> apnRolList;
    @OneToMany(mappedBy = "apnIngEgrDet", fetch = FetchType.LAZY)
    private List<ApnHistoricoRol> apnHistoricoRolList;

    public ApnIngEgrDet() {
    }

    public ApnIngEgrDet(BigDecimal iedId) {
        this.iedId = iedId;
    }

    public BigDecimal getIedId() {
        return iedId;
    }

    public void setIedId(BigDecimal iedId) {
        this.iedId = iedId;
    }

    public String getIedDescripcion() {
        return iedDescripcion;
    }

    public void setIedDescripcion(String iedDescripcion) {
        this.iedDescripcion = iedDescripcion;
    }

    public String getIedCtaContable() {
        return iedCtaContable;
    }

    public void setIedCtaContable(String iedCtaContable) {
        this.iedCtaContable = iedCtaContable;
    }

    public String getIedCtaPresupuesto() {
        return iedCtaPresupuesto;
    }

    public void setIedCtaPresupuesto(String iedCtaPresupuesto) {
        this.iedCtaPresupuesto = iedCtaPresupuesto;
    }

    public String getIedEstado() {
        return iedEstado;
    }

    public void setIedEstado(String iedEstado) {
        this.iedEstado = iedEstado;
    }

    public ApnIngEgrCab getApnIngEgrCab() {
        return apnIngEgrCab;
    }

    public void setApnIngEgrCab(ApnIngEgrCab apnIngEgrCab) {
        this.apnIngEgrCab = apnIngEgrCab;
    }

    public List<ApnRol> getApnRolList() {
        return apnRolList;
    }

    public void setApnRolList(List<ApnRol> apnRolList) {
        this.apnRolList = apnRolList;
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
        hash += (iedId != null ? iedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnIngEgrDet)) {
            return false;
        }
        ApnIngEgrDet other = (ApnIngEgrDet) object;
        if ((this.iedId == null && other.iedId != null) || (this.iedId != null && !this.iedId.equals(other.iedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnIngEgrDet[ iedId=" + iedId + " ]";
    }
    
}
