/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_ING_EGR_DET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnIngEgrDet.findAll", query = "SELECT a FROM ApnIngEgrDet a"),
    @NamedQuery(name = "ApnIngEgrDet.findByIedId", query = "SELECT a FROM ApnIngEgrDet a WHERE a.iedId = :iedId"),
    @NamedQuery(name = "ApnIngEgrDet.findByIedDescripcion", query = "SELECT a FROM ApnIngEgrDet a WHERE a.iedDescripcion = :iedDescripcion"),
    @NamedQuery(name = "ApnIngEgrDet.findByIedCtaContable", query = "SELECT a FROM ApnIngEgrDet a WHERE a.iedCtaContable = :iedCtaContable"),
    @NamedQuery(name = "ApnIngEgrDet.findByIedCtaPresupuesto", query = "SELECT a FROM ApnIngEgrDet a WHERE a.iedCtaPresupuesto = :iedCtaPresupuesto"),
    @NamedQuery(name = "ApnIngEgrDet.findByIedEstado", query = "SELECT a FROM ApnIngEgrDet a WHERE a.iedEstado = :iedEstado")})
public class ApnIngEgrDet implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IED_ID")
    private BigDecimal iedId;
    @Size(max = 50)
    @Column(name = "IED_DESCRIPCION")
    private String iedDescripcion;
    @Size(max = 20)
    @Column(name = "IED_CTA_CONTABLE")
    private String iedCtaContable;
    @Size(max = 20)
    @Column(name = "IED_CTA_PRESUPUESTO")
    private String iedCtaPresupuesto;
    @Size(max = 1)
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

    @XmlTransient
    public List<ApnRol> getApnRolList() {
        return apnRolList;
    }

    public void setApnRolList(List<ApnRol> apnRolList) {
        this.apnRolList = apnRolList;
    }

    @XmlTransient
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
        return "pprueba.ApnIngEgrDet[ iedId=" + iedId + " ]";
    }
    
}
