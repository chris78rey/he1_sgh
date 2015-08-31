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
@Table(name = "APN_ESTADO_EMPLEADO")
@NamedQueries({
    @NamedQuery(name = "ApnEstadoEmpleado.findAll", query = "SELECT a FROM ApnEstadoEmpleado a")})
public class ApnEstadoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EEM_ID")
    private BigDecimal eemId;
    @Column(name = "EEM_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eemFecha;
    @Column(name = "EEM_TIPO")
    private Character eemTipo;
    @Column(name = "EEM_DOCUMENTO")
    private String eemDocumento;
    @Column(name = "EEM_ESTADO")
    private Character eemEstado;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnEstadoEmpleado() {
    }

    public ApnEstadoEmpleado(BigDecimal eemId) {
        this.eemId = eemId;
    }

    public BigDecimal getEemId() {
        return eemId;
    }

    public void setEemId(BigDecimal eemId) {
        this.eemId = eemId;
    }

    public Date getEemFecha() {
        return eemFecha;
    }

    public void setEemFecha(Date eemFecha) {
        this.eemFecha = eemFecha;
    }

    public Character getEemTipo() {
        return eemTipo;
    }

    public void setEemTipo(Character eemTipo) {
        this.eemTipo = eemTipo;
    }

    public String getEemDocumento() {
        return eemDocumento;
    }

    public void setEemDocumento(String eemDocumento) {
        this.eemDocumento = eemDocumento;
    }

    public Character getEemEstado() {
        return eemEstado;
    }

    public void setEemEstado(Character eemEstado) {
        this.eemEstado = eemEstado;
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
        hash += (eemId != null ? eemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnEstadoEmpleado)) {
            return false;
        }
        ApnEstadoEmpleado other = (ApnEstadoEmpleado) object;
        if ((this.eemId == null && other.eemId != null) || (this.eemId != null && !this.eemId.equals(other.eemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnEstadoEmpleado[ eemId=" + eemId + " ]";
    }
    
}
