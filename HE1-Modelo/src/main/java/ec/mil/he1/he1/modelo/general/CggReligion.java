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
@Table(name = "CGG_RELIGION")
@NamedQueries({
    @NamedQuery(name = "CggReligion.findAll", query = "SELECT c FROM CggReligion c")})
public class CggReligion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "REL_ID")
    private BigDecimal relId;
    @Column(name = "REL_DESCRIPCION")
    private String relDescripcion;
    @Column(name = "REL_ESTADO")
    private Character relEstado;
    @OneToMany(mappedBy = "cggReligion", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList;

    public CggReligion() {
    }

    public CggReligion(BigDecimal relId) {
        this.relId = relId;
    }

    public BigDecimal getRelId() {
        return relId;
    }

    public void setRelId(BigDecimal relId) {
        this.relId = relId;
    }

    public String getRelDescripcion() {
        return relDescripcion;
    }

    public void setRelDescripcion(String relDescripcion) {
        this.relDescripcion = relDescripcion;
    }

    public Character getRelEstado() {
        return relEstado;
    }

    public void setRelEstado(Character relEstado) {
        this.relEstado = relEstado;
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
        hash += (relId != null ? relId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggReligion)) {
            return false;
        }
        CggReligion other = (CggReligion) object;
        if ((this.relId == null && other.relId != null) || (this.relId != null && !this.relId.equals(other.relId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggReligion[ relId=" + relId + " ]";
    }
    
}
