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
@Table(name = "CGG_TIPO_DISCAPACIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggTipoDiscapacidad.findAll", query = "SELECT c FROM CggTipoDiscapacidad c"),
    @NamedQuery(name = "CggTipoDiscapacidad.findByTipId", query = "SELECT c FROM CggTipoDiscapacidad c WHERE c.tipId = :tipId"),
    @NamedQuery(name = "CggTipoDiscapacidad.findByTipDescripcion", query = "SELECT c FROM CggTipoDiscapacidad c WHERE c.tipDescripcion = :tipDescripcion"),
    @NamedQuery(name = "CggTipoDiscapacidad.findByTipEstado", query = "SELECT c FROM CggTipoDiscapacidad c WHERE c.tipEstado = :tipEstado")})
public class CggTipoDiscapacidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIP_ID")
    private BigDecimal tipId;
    @Size(max = 50)
    @Column(name = "TIP_DESCRIPCION")
    private String tipDescripcion;
    @Size(max = 1)
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

    @XmlTransient
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
        return "pprueba.CggTipoDiscapacidad[ tipId=" + tipId + " ]";
    }
    
}
