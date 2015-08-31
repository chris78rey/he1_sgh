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
@Table(name = "APN_DEPENDENCIA")
@NamedQueries({
    @NamedQuery(name = "ApnDependencia.findAll", query = "SELECT a FROM ApnDependencia a")})
public class ApnDependencia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "DEP_ID")
    private BigDecimal depId;
    @Column(name = "DEP_DESCRIPCION")
    private String depDescripcion;
    @Column(name = "DEP_CTA_CONTABLE")
    private String depCtaContable;
    @Column(name = "DEP_ESTADO")
    private String depEstado;
    @Column(name = "DEP_ULTIMO_NIVEL")
    private Character depUltimoNivel;
    @OneToMany(mappedBy = "apnDependencia", fetch = FetchType.LAZY)
    private List<ApnDependencia> apnDependenciaList;
    @JoinColumn(name = "DEP_ID_FK", referencedColumnName = "DEP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnDependencia apnDependencia;
    @OneToMany(mappedBy = "apnDependencia", fetch = FetchType.LAZY)
    private List<ApnOrganicoDet> apnOrganicoDetList;

    public ApnDependencia() {
    }

    public ApnDependencia(BigDecimal depId) {
        this.depId = depId;
    }

    public BigDecimal getDepId() {
        return depId;
    }

    public void setDepId(BigDecimal depId) {
        this.depId = depId;
    }

    public String getDepDescripcion() {
        return depDescripcion;
    }

    public void setDepDescripcion(String depDescripcion) {
        this.depDescripcion = depDescripcion;
    }

    public String getDepCtaContable() {
        return depCtaContable;
    }

    public void setDepCtaContable(String depCtaContable) {
        this.depCtaContable = depCtaContable;
    }

    public String getDepEstado() {
        return depEstado;
    }

    public void setDepEstado(String depEstado) {
        this.depEstado = depEstado;
    }

    public Character getDepUltimoNivel() {
        return depUltimoNivel;
    }

    public void setDepUltimoNivel(Character depUltimoNivel) {
        this.depUltimoNivel = depUltimoNivel;
    }

    public List<ApnDependencia> getApnDependenciaList() {
        return apnDependenciaList;
    }

    public void setApnDependenciaList(List<ApnDependencia> apnDependenciaList) {
        this.apnDependenciaList = apnDependenciaList;
    }

    public ApnDependencia getApnDependencia() {
        return apnDependencia;
    }

    public void setApnDependencia(ApnDependencia apnDependencia) {
        this.apnDependencia = apnDependencia;
    }

    public List<ApnOrganicoDet> getApnOrganicoDetList() {
        return apnOrganicoDetList;
    }

    public void setApnOrganicoDetList(List<ApnOrganicoDet> apnOrganicoDetList) {
        this.apnOrganicoDetList = apnOrganicoDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnDependencia)) {
            return false;
        }
        ApnDependencia other = (ApnDependencia) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnDependencia[ depId=" + depId + " ]";
    }
    
}
