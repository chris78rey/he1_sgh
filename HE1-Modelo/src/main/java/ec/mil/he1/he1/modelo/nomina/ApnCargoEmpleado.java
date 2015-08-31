/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "APN_CARGO_EMPLEADO")
@NamedQueries({
    @NamedQuery(name = "ApnCargoEmpleado.findAll", query = "SELECT a FROM ApnCargoEmpleado a")})
public class ApnCargoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CEM_ID")
    private BigDecimal cemId;
    @Column(name = "CEM_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cemDesde;
    @Column(name = "CEM_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cemHasta;
    @Column(name = "CEM_OBSERVACION")
    private String cemObservacion;
    @Column(name = "CEM_ESTADO")
    private String cemEstado;
    @JoinColumn(name = "ODE_ID", referencedColumnName = "ODE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnOrganicoDet apnOrganicoDet;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnCargoEmpleado() {
    }

    public ApnCargoEmpleado(BigDecimal cemId) {
        this.cemId = cemId;
    }

    public BigDecimal getCemId() {
        return cemId;
    }

    public void setCemId(BigDecimal cemId) {
        this.cemId = cemId;
    }

    public Date getCemDesde() {
        return cemDesde;
    }

    public void setCemDesde(Date cemDesde) {
        this.cemDesde = cemDesde;
    }

    public Date getCemHasta() {
        return cemHasta;
    }

    public void setCemHasta(Date cemHasta) {
        this.cemHasta = cemHasta;
    }

    public String getCemObservacion() {
        return cemObservacion;
    }

    public void setCemObservacion(String cemObservacion) {
        this.cemObservacion = cemObservacion;
    }

    public String getCemEstado() {
        return cemEstado;
    }

    public void setCemEstado(String cemEstado) {
        this.cemEstado = cemEstado;
    }

    public ApnOrganicoDet getApnOrganicoDet() {
        return apnOrganicoDet;
    }

    public void setApnOrganicoDet(ApnOrganicoDet apnOrganicoDet) {
        this.apnOrganicoDet = apnOrganicoDet;
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
        hash += (cemId != null ? cemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnCargoEmpleado)) {
            return false;
        }
        ApnCargoEmpleado other = (ApnCargoEmpleado) object;
        if ((this.cemId == null && other.cemId != null) || (this.cemId != null && !this.cemId.equals(other.cemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnCargoEmpleado[ cemId=" + cemId + " ]";
    }
    
}
