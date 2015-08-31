/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

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
@Table(name = "CGG_GRADO_MILITAR")
@NamedQueries({
    @NamedQuery(name = "CggGradoMilitar.findAll", query = "SELECT c FROM CggGradoMilitar c")})
public class CggGradoMilitar implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GRA_ID")
    private BigDecimal graId;
    @Column(name = "GRA_DESCRIPCION")
    private String graDescripcion;
    @Column(name = "GRA_SIGLAS")
    private String graSiglas;
    @Column(name = "GRA_NUMERO")
    private Long graNumero;
    @JoinColumn(name = "FUE_ID", referencedColumnName = "FUE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggFuerza cggFuerza;
    @OneToMany(mappedBy = "cggGradoMilitar", fetch = FetchType.LAZY)
    private List<CggDatoMilitar> cggDatoMilitarList;

    public CggGradoMilitar() {
    }

    public CggGradoMilitar(BigDecimal graId) {
        this.graId = graId;
    }

    public BigDecimal getGraId() {
        return graId;
    }

    public void setGraId(BigDecimal graId) {
        this.graId = graId;
    }

    public String getGraDescripcion() {
        return graDescripcion;
    }

    public void setGraDescripcion(String graDescripcion) {
        this.graDescripcion = graDescripcion;
    }

    public String getGraSiglas() {
        return graSiglas;
    }

    public void setGraSiglas(String graSiglas) {
        this.graSiglas = graSiglas;
    }

    public Long getGraNumero() {
        return graNumero;
    }

    public void setGraNumero(Long graNumero) {
        this.graNumero = graNumero;
    }

    public CggFuerza getCggFuerza() {
        return cggFuerza;
    }

    public void setCggFuerza(CggFuerza cggFuerza) {
        this.cggFuerza = cggFuerza;
    }

    public List<CggDatoMilitar> getCggDatoMilitarList() {
        return cggDatoMilitarList;
    }

    public void setCggDatoMilitarList(List<CggDatoMilitar> cggDatoMilitarList) {
        this.cggDatoMilitarList = cggDatoMilitarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (graId != null ? graId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggGradoMilitar)) {
            return false;
        }
        CggGradoMilitar other = (CggGradoMilitar) object;
        if ((this.graId == null && other.graId != null) || (this.graId != null && !this.graId.equals(other.graId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggGradoMilitar[ graId=" + graId + " ]";
    }
    
}
