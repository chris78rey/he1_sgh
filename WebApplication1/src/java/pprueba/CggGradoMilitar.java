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
@Table(name = "CGG_GRADO_MILITAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggGradoMilitar.findAll", query = "SELECT c FROM CggGradoMilitar c"),
    @NamedQuery(name = "CggGradoMilitar.findByGraId", query = "SELECT c FROM CggGradoMilitar c WHERE c.graId = :graId"),
    @NamedQuery(name = "CggGradoMilitar.findByGraDescripcion", query = "SELECT c FROM CggGradoMilitar c WHERE c.graDescripcion = :graDescripcion"),
    @NamedQuery(name = "CggGradoMilitar.findByGraSiglas", query = "SELECT c FROM CggGradoMilitar c WHERE c.graSiglas = :graSiglas"),
    @NamedQuery(name = "CggGradoMilitar.findByGraNumero", query = "SELECT c FROM CggGradoMilitar c WHERE c.graNumero = :graNumero")})
public class CggGradoMilitar implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRA_ID")
    private BigDecimal graId;
    @Size(max = 20)
    @Column(name = "GRA_DESCRIPCION")
    private String graDescripcion;
    @Size(max = 10)
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

    @XmlTransient
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
        return "pprueba.CggGradoMilitar[ graId=" + graId + " ]";
    }
    
}
