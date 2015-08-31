/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_ORGANICO_DET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnOrganicoDet.findAll", query = "SELECT a FROM ApnOrganicoDet a"),
    @NamedQuery(name = "ApnOrganicoDet.findByOdeId", query = "SELECT a FROM ApnOrganicoDet a WHERE a.odeId = :odeId"),
    @NamedQuery(name = "ApnOrganicoDet.findByOdeOrganico", query = "SELECT a FROM ApnOrganicoDet a WHERE a.odeOrganico = :odeOrganico"),
    @NamedQuery(name = "ApnOrganicoDet.findByOdeEstado", query = "SELECT a FROM ApnOrganicoDet a WHERE a.odeEstado = :odeEstado")})
public class ApnOrganicoDet implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ODE_ID")
    private BigDecimal odeId;
    @Column(name = "ODE_ORGANICO")
    private BigInteger odeOrganico;
    @Column(name = "ODE_ESTADO")
    private Character odeEstado;
    @OneToMany(mappedBy = "apnOrganicoDet", fetch = FetchType.LAZY)
    private List<ApnCargoEmpleado> apnCargoEmpleadoList;
    @JoinColumn(name = "CAR_ID", referencedColumnName = "CAR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnCargo apnCargo;
    @JoinColumn(name = "DEP_ID", referencedColumnName = "DEP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnDependencia apnDependencia;
    @JoinColumn(name = "OCA_ID", referencedColumnName = "OCA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnOrganicoCab apnOrganicoCab;

    public ApnOrganicoDet() {
    }

    public ApnOrganicoDet(BigDecimal odeId) {
        this.odeId = odeId;
    }

    public BigDecimal getOdeId() {
        return odeId;
    }

    public void setOdeId(BigDecimal odeId) {
        this.odeId = odeId;
    }

    public BigInteger getOdeOrganico() {
        return odeOrganico;
    }

    public void setOdeOrganico(BigInteger odeOrganico) {
        this.odeOrganico = odeOrganico;
    }

    public Character getOdeEstado() {
        return odeEstado;
    }

    public void setOdeEstado(Character odeEstado) {
        this.odeEstado = odeEstado;
    }

    @XmlTransient
    public List<ApnCargoEmpleado> getApnCargoEmpleadoList() {
        return apnCargoEmpleadoList;
    }

    public void setApnCargoEmpleadoList(List<ApnCargoEmpleado> apnCargoEmpleadoList) {
        this.apnCargoEmpleadoList = apnCargoEmpleadoList;
    }

    public ApnCargo getApnCargo() {
        return apnCargo;
    }

    public void setApnCargo(ApnCargo apnCargo) {
        this.apnCargo = apnCargo;
    }

    public ApnDependencia getApnDependencia() {
        return apnDependencia;
    }

    public void setApnDependencia(ApnDependencia apnDependencia) {
        this.apnDependencia = apnDependencia;
    }

    public ApnOrganicoCab getApnOrganicoCab() {
        return apnOrganicoCab;
    }

    public void setApnOrganicoCab(ApnOrganicoCab apnOrganicoCab) {
        this.apnOrganicoCab = apnOrganicoCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odeId != null ? odeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnOrganicoDet)) {
            return false;
        }
        ApnOrganicoDet other = (ApnOrganicoDet) object;
        if ((this.odeId == null && other.odeId != null) || (this.odeId != null && !this.odeId.equals(other.odeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnOrganicoDet[ odeId=" + odeId + " ]";
    }
    
}
