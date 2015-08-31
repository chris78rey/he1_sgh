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
@Table(name = "CGG_PARROQUIA")
@NamedQueries({
    @NamedQuery(name = "CggParroquia.findAll", query = "SELECT c FROM CggParroquia c")})
public class CggParroquia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRQ_ID")
    private BigDecimal prqId;
    @Column(name = "PRQ_DESCRIPCION")
    private String prqDescripcion;
    @Column(name = "PRQ_ESTADO")
    private Character prqEstado;
    @JoinColumn(name = "CAN_ID", referencedColumnName = "CAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggCanton cggCanton;
    @OneToMany(mappedBy = "cggParroquia", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList;
    @OneToMany(mappedBy = "cggParroquia1", fetch = FetchType.LAZY)
    private List<CggPersona> cggPersonaList1;
    @OneToMany(mappedBy = "cggParroquia", fetch = FetchType.LAZY)
    private List<CggUnidadSalud> cggUnidadSaludList;

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

    public CggCanton getCggCanton() {
        return cggCanton;
    }

    public void setCggCanton(CggCanton cggCanton) {
        this.cggCanton = cggCanton;
    }

    public List<CggPersona> getCggPersonaList() {
        return cggPersonaList;
    }

    public void setCggPersonaList(List<CggPersona> cggPersonaList) {
        this.cggPersonaList = cggPersonaList;
    }

    public List<CggPersona> getCggPersonaList1() {
        return cggPersonaList1;
    }

    public void setCggPersonaList1(List<CggPersona> cggPersonaList1) {
        this.cggPersonaList1 = cggPersonaList1;
    }

    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
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
        return "ec.mil.he1.he1.modelo.general.CggParroquia[ prqId=" + prqId + " ]";
    }
    
}
