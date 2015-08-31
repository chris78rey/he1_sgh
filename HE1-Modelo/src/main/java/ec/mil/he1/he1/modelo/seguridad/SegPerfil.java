/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.seguridad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "SEG_PERFIL")
@NamedQueries({
    @NamedQuery(name = "SegPerfil.findAll", query = "SELECT s FROM SegPerfil s")})
public class SegPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PER_ID")
    private BigDecimal perId;
    @Basic(optional = false)
    @Column(name = "PER_DESCRIPCION")
    private String perDescripcion;
    @Column(name = "PER_ESTADO")
    private Character perEstado;
    @JoinColumn(name = "GRU_ID", referencedColumnName = "GRU_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SegGrupoSistema segGrupoSistema;
    @OneToMany(mappedBy = "segPerfil", fetch = FetchType.LAZY)
    private List<SegOpcionPerfil> segOpcionPerfilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segPerfil", fetch = FetchType.LAZY)
    private List<SegPerfilUsuario> segPerfilUsuarioList;

    public SegPerfil() {
    }

    public SegPerfil(BigDecimal perId) {
        this.perId = perId;
    }

    public SegPerfil(BigDecimal perId, String perDescripcion) {
        this.perId = perId;
        this.perDescripcion = perDescripcion;
    }

    public BigDecimal getPerId() {
        return perId;
    }

    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
    }

    public Character getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(Character perEstado) {
        this.perEstado = perEstado;
    }

    public SegGrupoSistema getSegGrupoSistema() {
        return segGrupoSistema;
    }

    public void setSegGrupoSistema(SegGrupoSistema segGrupoSistema) {
        this.segGrupoSistema = segGrupoSistema;
    }

    public List<SegOpcionPerfil> getSegOpcionPerfilList() {
        return segOpcionPerfilList;
    }

    public void setSegOpcionPerfilList(List<SegOpcionPerfil> segOpcionPerfilList) {
        this.segOpcionPerfilList = segOpcionPerfilList;
    }

    public List<SegPerfilUsuario> getSegPerfilUsuarioList() {
        return segPerfilUsuarioList;
    }

    public void setSegPerfilUsuarioList(List<SegPerfilUsuario> segPerfilUsuarioList) {
        this.segPerfilUsuarioList = segPerfilUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPerfil)) {
            return false;
        }
        SegPerfil other = (SegPerfil) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.seguridad.SegPerfil[ perId=" + perId + " ]";
    }
    
}
