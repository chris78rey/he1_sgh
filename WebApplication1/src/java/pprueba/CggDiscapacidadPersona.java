/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "CGG_DISCAPACIDAD_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggDiscapacidadPersona.findAll", query = "SELECT c FROM CggDiscapacidadPersona c"),
    @NamedQuery(name = "CggDiscapacidadPersona.findByDisId", query = "SELECT c FROM CggDiscapacidadPersona c WHERE c.disId = :disId"),
    @NamedQuery(name = "CggDiscapacidadPersona.findByDisPorcentaje", query = "SELECT c FROM CggDiscapacidadPersona c WHERE c.disPorcentaje = :disPorcentaje"),
    @NamedQuery(name = "CggDiscapacidadPersona.findByDisFecha", query = "SELECT c FROM CggDiscapacidadPersona c WHERE c.disFecha = :disFecha"),
    @NamedQuery(name = "CggDiscapacidadPersona.findByPerId", query = "SELECT c FROM CggDiscapacidadPersona c WHERE c.perId = :perId"),
    @NamedQuery(name = "CggDiscapacidadPersona.findByDisEstado", query = "SELECT c FROM CggDiscapacidadPersona c WHERE c.disEstado = :disEstado")})
public class CggDiscapacidadPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
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
        return "pprueba.CggDiscapacidadPersona[ disId=" + disId + " ]";
    }
    
}
