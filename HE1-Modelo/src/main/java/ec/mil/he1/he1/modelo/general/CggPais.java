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
@Table(name = "CGG_PAIS")
@NamedQueries({
    @NamedQuery(name = "CggPais.findAll", query = "SELECT c FROM CggPais c")})
public class CggPais implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PAI_ID")
    private BigDecimal paiId;
    @Column(name = "PAI_DESCRIPCION")
    private String paiDescripcion;
    @Column(name = "PAI_CODINTERNACIONAL")
    private String paiCodinternacional;
    @Column(name = "PAI_NACIONALIDAD")
    private String paiNacionalidad;
    @Column(name = "PAI_ESTADO")
    private Character paiEstado;
    @OneToMany(mappedBy = "cggPais", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList;

    public CggPais() {
    }

    public CggPais(BigDecimal paiId) {
        this.paiId = paiId;
    }

    public BigDecimal getPaiId() {
        return paiId;
    }

    public void setPaiId(BigDecimal paiId) {
        this.paiId = paiId;
    }

    public String getPaiDescripcion() {
        return paiDescripcion;
    }

    public void setPaiDescripcion(String paiDescripcion) {
        this.paiDescripcion = paiDescripcion;
    }

    public String getPaiCodinternacional() {
        return paiCodinternacional;
    }

    public void setPaiCodinternacional(String paiCodinternacional) {
        this.paiCodinternacional = paiCodinternacional;
    }

    public String getPaiNacionalidad() {
        return paiNacionalidad;
    }

    public void setPaiNacionalidad(String paiNacionalidad) {
        this.paiNacionalidad = paiNacionalidad;
    }

    public Character getPaiEstado() {
        return paiEstado;
    }

    public void setPaiEstado(Character paiEstado) {
        this.paiEstado = paiEstado;
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
        hash += (paiId != null ? paiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggPais)) {
            return false;
        }
        CggPais other = (CggPais) object;
        if ((this.paiId == null && other.paiId != null) || (this.paiId != null && !this.paiId.equals(other.paiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggPais[ paiId=" + paiId + " ]";
    }
    
}
