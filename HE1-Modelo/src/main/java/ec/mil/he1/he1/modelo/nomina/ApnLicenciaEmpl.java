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
@Table(name = "APN_LICENCIA_EMPL")
@NamedQueries({
    @NamedQuery(name = "ApnLicenciaEmpl.findAll", query = "SELECT a FROM ApnLicenciaEmpl a")})
public class ApnLicenciaEmpl implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "LEM_ID")
    private BigDecimal lemId;
    @Column(name = "LEM_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lemDesde;
    @Column(name = "LEM_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lemHasta;
    @Column(name = "LEM_ESTADO")
    private Character lemEstado;
    @Column(name = "LEM_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lemFechaCreacion;
    @JoinColumn(name = "MLI_ID", referencedColumnName = "MLI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnMotivoLicencia apnMotivoLicencia;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnLicenciaEmpl() {
    }

    public ApnLicenciaEmpl(BigDecimal lemId) {
        this.lemId = lemId;
    }

    public BigDecimal getLemId() {
        return lemId;
    }

    public void setLemId(BigDecimal lemId) {
        this.lemId = lemId;
    }

    public Date getLemDesde() {
        return lemDesde;
    }

    public void setLemDesde(Date lemDesde) {
        this.lemDesde = lemDesde;
    }

    public Date getLemHasta() {
        return lemHasta;
    }

    public void setLemHasta(Date lemHasta) {
        this.lemHasta = lemHasta;
    }

    public Character getLemEstado() {
        return lemEstado;
    }

    public void setLemEstado(Character lemEstado) {
        this.lemEstado = lemEstado;
    }

    public Date getLemFechaCreacion() {
        return lemFechaCreacion;
    }

    public void setLemFechaCreacion(Date lemFechaCreacion) {
        this.lemFechaCreacion = lemFechaCreacion;
    }

    public ApnMotivoLicencia getApnMotivoLicencia() {
        return apnMotivoLicencia;
    }

    public void setApnMotivoLicencia(ApnMotivoLicencia apnMotivoLicencia) {
        this.apnMotivoLicencia = apnMotivoLicencia;
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
        hash += (lemId != null ? lemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnLicenciaEmpl)) {
            return false;
        }
        ApnLicenciaEmpl other = (ApnLicenciaEmpl) object;
        if ((this.lemId == null && other.lemId != null) || (this.lemId != null && !this.lemId.equals(other.lemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnLicenciaEmpl[ lemId=" + lemId + " ]";
    }
    
}
