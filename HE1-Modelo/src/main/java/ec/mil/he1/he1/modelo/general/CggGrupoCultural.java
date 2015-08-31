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
@Table(name = "CGG_GRUPO_CULTURAL")
@NamedQueries({
    @NamedQuery(name = "CggGrupoCultural.findAll", query = "SELECT c FROM CggGrupoCultural c")})
public class CggGrupoCultural implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GRU_ID")
    private BigDecimal gruId;
    @Column(name = "GRU_DESCRIPCION")
    private String gruDescripcion;
    @Column(name = "GRU_SIGLAS")
    private String gruSiglas;
    @Column(name = "GRU_ESTADO")
    private Character gruEstado;
    @OneToMany(mappedBy = "cggGrupoCultural", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList;

    public CggGrupoCultural() {
    }

    public CggGrupoCultural(BigDecimal gruId) {
        this.gruId = gruId;
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

    public String getGruSiglas() {
        return gruSiglas;
    }

    public void setGruSiglas(String gruSiglas) {
        this.gruSiglas = gruSiglas;
    }

    public Character getGruEstado() {
        return gruEstado;
    }

    public void setGruEstado(Character gruEstado) {
        this.gruEstado = gruEstado;
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
        hash += (gruId != null ? gruId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggGrupoCultural)) {
            return false;
        }
        CggGrupoCultural other = (CggGrupoCultural) object;
        if ((this.gruId == null && other.gruId != null) || (this.gruId != null && !this.gruId.equals(other.gruId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggGrupoCultural[ gruId=" + gruId + " ]";
    }
    
}
