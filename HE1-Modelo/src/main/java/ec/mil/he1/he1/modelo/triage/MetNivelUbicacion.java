/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_NIVEL_UBICACION")
@NamedQueries({
    @NamedQuery(name = "MetNivelUbicacion.findAll", query = "SELECT m FROM MetNivelUbicacion m")})
public class MetNivelUbicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NIU_ID")
    private BigDecimal niuId;
    @JoinColumn(name = "NIV_ID", referencedColumnName = "NIV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetNivel metNivel;
    @JoinColumn(name = "UBI_ID", referencedColumnName = "UBI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetUbicacionAtencion metUbicacionAtencion;

    public MetNivelUbicacion() {
    }

    public MetNivelUbicacion(BigDecimal niuId) {
        this.niuId = niuId;
    }

    public BigDecimal getNiuId() {
        return niuId;
    }

    public void setNiuId(BigDecimal niuId) {
        this.niuId = niuId;
    }

    public MetNivel getMetNivel() {
        return metNivel;
    }

    public void setMetNivel(MetNivel metNivel) {
        this.metNivel = metNivel;
    }

    public MetUbicacionAtencion getMetUbicacionAtencion() {
        return metUbicacionAtencion;
    }

    public void setMetUbicacionAtencion(MetUbicacionAtencion metUbicacionAtencion) {
        this.metUbicacionAtencion = metUbicacionAtencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (niuId != null ? niuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetNivelUbicacion)) {
            return false;
        }
        MetNivelUbicacion other = (MetNivelUbicacion) object;
        if ((this.niuId == null && other.niuId != null) || (this.niuId != null && !this.niuId.equals(other.niuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetNivelUbicacion[ niuId=" + niuId + " ]";
    }
    
}
