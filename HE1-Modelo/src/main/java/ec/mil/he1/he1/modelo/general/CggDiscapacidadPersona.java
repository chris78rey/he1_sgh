/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "CGG_DISCAPACIDAD_PERSONA")
@NamedQueries({
    @NamedQuery(name = "CggDiscapacidadPersona.findAll", query = "SELECT c FROM CggDiscapacidadPersona c")})
public class CggDiscapacidadPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "DIS_ID")
    private BigDecimal disId;
    @Column(name = "DIS_PORCENTAJE")
    private BigInteger disPorcentaje;
    @Column(name = "DIS_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date disFecha;
    @Column(name = "PER_ID")
    private BigInteger perId;
    @Column(name = "DIS_ESTADO")
    private Character disEstado;
    @JoinColumn(name = "TIP_ID", referencedColumnName = "TIP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggTipoDiscapacidad cggTipoDiscapacidad;

    public CggDiscapacidadPersona() {
    }

    public CggDiscapacidadPersona(BigDecimal disId) {
        this.disId = disId;
    }

    public BigDecimal getDisId() {
        return disId;
    }

    public void setDisId(BigDecimal disId) {
        this.disId = disId;
    }

    public BigInteger getDisPorcentaje() {
        return disPorcentaje;
    }

    public void setDisPorcentaje(BigInteger disPorcentaje) {
        this.disPorcentaje = disPorcentaje;
    }

    public Date getDisFecha() {
        return disFecha;
    }

    public void setDisFecha(Date disFecha) {
        this.disFecha = disFecha;
    }

    public BigInteger getPerId() {
        return perId;
    }

    public void setPerId(BigInteger perId) {
        this.perId = perId;
    }

    public Character getDisEstado() {
        return disEstado;
    }

    public void setDisEstado(Character disEstado) {
        this.disEstado = disEstado;
    }

    public CggTipoDiscapacidad getCggTipoDiscapacidad() {
        return cggTipoDiscapacidad;
    }

    public void setCggTipoDiscapacidad(CggTipoDiscapacidad cggTipoDiscapacidad) {
        this.cggTipoDiscapacidad = cggTipoDiscapacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disId != null ? disId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggDiscapacidadPersona)) {
            return false;
        }
        CggDiscapacidadPersona other = (CggDiscapacidadPersona) object;
        if ((this.disId == null && other.disId != null) || (this.disId != null && !this.disId.equals(other.disId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggDiscapacidadPersona[ disId=" + disId + " ]";
    }
    
}
