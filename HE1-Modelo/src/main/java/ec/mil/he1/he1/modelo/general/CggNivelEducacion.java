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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "CGG_NIVEL_EDUCACION")
@NamedQueries({
    @NamedQuery(name = "CggNivelEducacion.findAll", query = "SELECT c FROM CggNivelEducacion c")})
public class CggNivelEducacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NED_ID")
    private BigDecimal nedId;
    @Column(name = "NED_DESCRIPCION")
    private String nedDescripcion;
    @Column(name = "NED_ESTADO")
    private Character nedEstado;
    @OneToMany(mappedBy = "cggNivelEducacion", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList;

    public CggNivelEducacion() {
    }

    public CggNivelEducacion(BigDecimal nedId) {
        this.nedId = nedId;
    }

    public BigDecimal getNedId() {
        return nedId;
    }

    public void setNedId(BigDecimal nedId) {
        this.nedId = nedId;
    }

    public String getNedDescripcion() {
        return nedDescripcion;
    }

    public void setNedDescripcion(String nedDescripcion) {
        this.nedDescripcion = nedDescripcion;
    }

    public Character getNedEstado() {
        return nedEstado;
    }

    public void setNedEstado(Character nedEstado) {
        this.nedEstado = nedEstado;
    }

    public List<CggPersona> getCggPersonaList() {
        return cggPersonaList;
    }

    public void setCggPersonaList(List<CggPersona> cggPersonaList) {
        this.cggPersonaList = cggPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nedId != null ? nedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggNivelEducacion)) {
            return false;
        }
        CggNivelEducacion other = (CggNivelEducacion) object;
        if ((this.nedId == null && other.nedId != null) || (this.nedId != null && !this.nedId.equals(other.nedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggNivelEducacion[ nedId=" + nedId + " ]";
    }
    
}
