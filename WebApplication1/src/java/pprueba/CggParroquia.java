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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CGG_PARROQUIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggParroquia.findAll", query = "SELECT c FROM CggParroquia c"),
    @NamedQuery(name = "CggParroquia.findByPrqId", query = "SELECT c FROM CggParroquia c WHERE c.prqId = :prqId"),
    @NamedQuery(name = "CggParroquia.findByPrqDescripcion", query = "SELECT c FROM CggParroquia c WHERE c.prqDescripcion = :prqDescripcion"),
    @NamedQuery(name = "CggParroquia.findByPrqEstado", query = "SELECT c FROM CggParroquia c WHERE c.prqEstado = :prqEstado")})
public class CggParroquia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRQ_ID")
    private BigDecimal prqId;
    @Size(max = 250)
    @Column(name = "PRQ_DESCRIPCION")
    private String prqDescripcion;
    @Column(name = "PRQ_ESTADO")
    private Character prqEstado;
    @OneToMany(mappedBy = "cggParroquia", fetch = FetchType.LAZY)
    private List<CggUnidadSalud> cggUnidadSaludList;
    @JoinColumn(name = "CAN_ID", referencedColumnName = "CAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggCanton cggCanton;
    @OneToMany(mappedBy = "cggParroquia", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList;
    @OneToMany(mappedBy = "cggParroquia1", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList1;

    public CggParroquia() {
    }

    public CggParroquia(BigDecimal prqId) {
        this.prqId = prqId;
    }

    public BigDecimal getPrqId() {
        return prqId;
    }

    public void setPrqId(BigDecimal prqId) {
        this.prqId = prqId;
    }

    public String getPrqDescripcion() {
        return prqDescripcion;
    }

    public void setPrqDescripcion(String prqDescripcion) {
        this.prqDescripcion = prqDescripcion;
    }

    public Character getPrqEstado() {
        return prqEstado;
    }

    public void setPrqEstado(Character prqEstado) {
        this.prqEstado = prqEstado;
    }

    @XmlTransient
    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
    }

    public CggCanton getCggCanton() {
        return cggCanton;
    }

    public void setCggCanton(CggCanton cggCanton) {
        this.cggCanton = cggCanton;
    }

    @XmlTransient
    public List<CggPersona> getCggPersonaList() {
        return cggPersonaList;
    }

    public void setCggPersonaList(List<CggPersona> cggPersonaList) {
        this.cggPersonaList = cggPersonaList;
    }

    @XmlTransient
    public List<CggPersona> getCggPersonaList1() {
        return cggPersonaList1;
    }

    public void setCggPersonaList1(List<CggPersona> cggPersonaList1) {
        this.cggPersonaList1 = cggPersonaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prqId != null ? prqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggParroquia)) {
            return false;
        }
        CggParroquia other = (CggParroquia) object;
        if ((this.prqId == null && other.prqId != null) || (this.prqId != null && !this.prqId.equals(other.prqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.CggParroquia[ prqId=" + prqId + " ]";
    }
    
}
