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
@Table(name = "CGG_OCUPACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggOcupacion.findAll", query = "SELECT c FROM CggOcupacion c"),
    @NamedQuery(name = "CggOcupacion.findByOcuId", query = "SELECT c FROM CggOcupacion c WHERE c.ocuId = :ocuId"),
    @NamedQuery(name = "CggOcupacion.findByOcuDescripcion", query = "SELECT c FROM CggOcupacion c WHERE c.ocuDescripcion = :ocuDescripcion"),
    @NamedQuery(name = "CggOcupacion.findByOcuEstado", query = "SELECT c FROM CggOcupacion c WHERE c.ocuEstado = :ocuEstado")})
public class CggOcupacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OCU_ID")
    private BigDecimal ocuId;
    @Size(max = 100)
    @Column(name = "OCU_DESCRIPCION")
    private String ocuDescripcion;
    @Column(name = "OCU_ESTADO")
    private Character ocuEstado;
    @OneToMany(mappedBy = "cggOcupacion", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList;

    public CggOcupacion() {
    }

    public CggOcupacion(BigDecimal ocuId) {
        this.ocuId = ocuId;
    }

    public BigDecimal getOcuId() {
        return ocuId;
    }

    public void setOcuId(BigDecimal ocuId) {
        this.ocuId = ocuId;
    }

    public String getOcuDescripcion() {
        return ocuDescripcion;
    }

    public void setOcuDescripcion(String ocuDescripcion) {
        this.ocuDescripcion = ocuDescripcion;
    }

    public Character getOcuEstado() {
        return ocuEstado;
    }

    public void setOcuEstado(Character ocuEstado) {
        this.ocuEstado = ocuEstado;
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
        hash += (ocuId != null ? ocuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggOcupacion)) {
            return false;
        }
        CggOcupacion other = (CggOcupacion) object;
        if ((this.ocuId == null && other.ocuId != null) || (this.ocuId != null && !this.ocuId.equals(other.ocuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.CggOcupacion[ ocuId=" + ocuId + " ]";
    }
    
}
