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
import javax.persistence.CascadeType;
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
@Table(name = "SEG_GRUPO_SISTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegGrupoSistema.findAll", query = "SELECT s FROM SegGrupoSistema s"),
    @NamedQuery(name = "SegGrupoSistema.findByGruId", query = "SELECT s FROM SegGrupoSistema s WHERE s.gruId = :gruId"),
    @NamedQuery(name = "SegGrupoSistema.findByGruDescripcion", query = "SELECT s FROM SegGrupoSistema s WHERE s.gruDescripcion = :gruDescripcion"),
    @NamedQuery(name = "SegGrupoSistema.findByGruEstado", query = "SELECT s FROM SegGrupoSistema s WHERE s.gruEstado = :gruEstado")})
public class SegGrupoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRU_ID")
    private BigDecimal gruId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GRU_DESCRIPCION")
    private String gruDescripcion;
    @Column(name = "GRU_ESTADO")
    private Character gruEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segGrupoSistema", fetch = FetchType.LAZY)
    private List<SegPerfil> segPerfilList;
    @OneToMany(mappedBy = "segGrupoSistema", fetch = FetchType.LAZY)
    private List<SegSistema> segSistemaList;

    public SegGrupoSistema() {
    }

    public SegGrupoSistema(BigDecimal gruId) {
        this.gruId = gruId;
    }

    public SegGrupoSistema(BigDecimal gruId, String gruDescripcion) {
        this.gruId = gruId;
        this.gruDescripcion = gruDescripcion;
    }

    public BigDecimal getGruId() {
        return gruId;
    }

    public void setGruId(BigDecimal gruId) {
        this.gruId = gruId;
    }

    public String getGruDescripcion() {
        return gruDescripcion;
    }

    public void setGruDescripcion(String gruDescripcion) {
        this.gruDescripcion = gruDescripcion;
    }

    public Character getGruEstado() {
        return gruEstado;
    }

    public void setGruEstado(Character gruEstado) {
        this.gruEstado = gruEstado;
    }

    @XmlTransient
    public List<SegPerfil> getSegPerfilList() {
        return segPerfilList;
    }

    public void setSegPerfilList(List<SegPerfil> segPerfilList) {
        this.segPerfilList = segPerfilList;
    }

    @XmlTransient
    public List<SegSistema> getSegSistemaList() {
        return segSistemaList;
    }

    public void setSegSistemaList(List<SegSistema> segSistemaList) {
        this.segSistemaList = segSistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruId != null ? gruId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegGrupoSistema)) {
            return false;
        }
        SegGrupoSistema other = (SegGrupoSistema) object;
        if ((this.gruId == null && other.gruId != null) || (this.gruId != null && !this.gruId.equals(other.gruId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.SegGrupoSistema[ gruId=" + gruId + " ]";
    }
    
}
