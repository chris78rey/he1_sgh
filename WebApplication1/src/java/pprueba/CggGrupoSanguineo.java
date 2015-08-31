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
@Table(name = "CGG_GRUPO_SANGUINEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggGrupoSanguineo.findAll", query = "SELECT c FROM CggGrupoSanguineo c"),
    @NamedQuery(name = "CggGrupoSanguineo.findByGrsId", query = "SELECT c FROM CggGrupoSanguineo c WHERE c.grsId = :grsId"),
    @NamedQuery(name = "CggGrupoSanguineo.findByGrsDescripcion", query = "SELECT c FROM CggGrupoSanguineo c WHERE c.grsDescripcion = :grsDescripcion"),
    @NamedQuery(name = "CggGrupoSanguineo.findByGrsSiglas", query = "SELECT c FROM CggGrupoSanguineo c WHERE c.grsSiglas = :grsSiglas"),
    @NamedQuery(name = "CggGrupoSanguineo.findByGrsEstado", query = "SELECT c FROM CggGrupoSanguineo c WHERE c.grsEstado = :grsEstado")})
public class CggGrupoSanguineo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRS_ID")
    private BigDecimal grsId;
    @Size(max = 20)
    @Column(name = "GRS_DESCRIPCION")
    private String grsDescripcion;
    @Size(max = 20)
    @Column(name = "GRS_SIGLAS")
    private String grsSiglas;
    @Column(name = "GRS_ESTADO")
    private Character grsEstado;
    @OneToMany(mappedBy = "cggGrupoSanguineo", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList;

    public CggGrupoSanguineo() {
    }

    public CggGrupoSanguineo(BigDecimal grsId) {
        this.grsId = grsId;
    }

    public BigDecimal getGrsId() {
        return grsId;
    }

    public void setGrsId(BigDecimal grsId) {
        this.grsId = grsId;
    }

    public String getGrsDescripcion() {
        return grsDescripcion;
    }

    public void setGrsDescripcion(String grsDescripcion) {
        this.grsDescripcion = grsDescripcion;
    }

    public String getGrsSiglas() {
        return grsSiglas;
    }

    public void setGrsSiglas(String grsSiglas) {
        this.grsSiglas = grsSiglas;
    }

    public Character getGrsEstado() {
        return grsEstado;
    }

    public void setGrsEstado(Character grsEstado) {
        this.grsEstado = grsEstado;
    }

    @XmlTransient
    public List<CggPersona> getCggPersonaList() {
        return cggPersonaList;
    }

    public void setCggPersonaList(List<CggPersona> cggPersonaList) {
        this.cggPersonaList = cggPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grsId != null ? grsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggGrupoSanguineo)) {
            return false;
        }
        CggGrupoSanguineo other = (CggGrupoSanguineo) object;
        if ((this.grsId == null && other.grsId != null) || (this.grsId != null && !this.grsId.equals(other.grsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.CggGrupoSanguineo[ grsId=" + grsId + " ]";
    }
    
}
