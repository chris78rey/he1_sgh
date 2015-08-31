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
@Table(name = "CGG_TIPO_DISCAPACIDAD")
@NamedQueries({
    @NamedQuery(name = "CggTipoDiscapacidad.findAll", query = "SELECT c FROM CggTipoDiscapacidad c")})
public class CggTipoDiscapacidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TIP_ID")
    private BigDecimal tipId;
    @Column(name = "TIP_DESCRIPCION")
    private String tipDescripcion;
    @Column(name = "TIP_ESTADO")
    private String tipEstado;
    @OneToMany(mappedBy = "cggTipoDiscapacidad", fetch = FetchType.LAZY)
    private List<CggDiscapacidadPersona> cggDiscapacidadPersonaList;

    public CggTipoDiscapacidad() {
    }

    public CggTipoDiscapacidad(BigDecimal tipId) {
        this.tipId = tipId;
    }

    public BigDecimal getTipId() {
        return tipId;
    }

    public void setTipId(BigDecimal tipId) {
        this.tipId = tipId;
    }

    public String getTipDescripcion() {
        return tipDescripcion;
    }

    public void setTipDescripcion(String tipDescripcion) {
        this.tipDescripcion = tipDescripcion;
    }

    public String getTipEstado() {
        return tipEstado;
    }

    public void setTipEstado(String tipEstado) {
        this.tipEstado = tipEstado;
    }

    public List<CggDiscapacidadPersona> getCggDiscapacidadPersonaList() {
        return cggDiscapacidadPersonaList;
    }

    public void setCggDiscapacidadPersonaList(List<CggDiscapacidadPersona> cggDiscapacidadPersonaList) {
        this.cggDiscapacidadPersonaList = cggDiscapacidadPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggTipoDiscapacidad)) {
            return false;
        }
        CggTipoDiscapacidad other = (CggTipoDiscapacidad) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggTipoDiscapacidad[ tipId=" + tipId + " ]";
    }
    
}
