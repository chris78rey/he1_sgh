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
@Table(name = "CGG_CANTON")
@NamedQueries({
    @NamedQuery(name = "CggCanton.findAll", query = "SELECT c FROM CggCanton c")})
public class CggCanton implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CAN_ID")
    private BigDecimal canId;
    @Column(name = "CAN_DESCRIPCION")
    private String canDescripcion;
    @Column(name = "CAN_ESTADO")
    private Character canEstado;
    @OneToMany(mappedBy = "cggCanton", fetch = FetchType.LAZY)
    private List<CggParroquia> cggParroquiaList;
    @OneToMany(mappedBy = "cggCanton", fetch = FetchType.LAZY)
    private List<CggUnidadSalud> cggUnidadSaludList;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggProvincia cggProvincia;

    public CggCanton() {
    }

    public CggCanton(BigDecimal canId) {
        this.canId = canId;
    }

    public BigDecimal getCanId() {
        return canId;
    }

    public void setCanId(BigDecimal canId) {
        this.canId = canId;
    }

    public String getCanDescripcion() {
        return canDescripcion;
    }

    public void setCanDescripcion(String canDescripcion) {
        this.canDescripcion = canDescripcion;
    }

    public Character getCanEstado() {
        return canEstado;
    }

    public void setCanEstado(Character canEstado) {
        this.canEstado = canEstado;
    }

    public List<CggParroquia> getCggParroquiaList() {
        return cggParroquiaList;
    }

    public void setCggParroquiaList(List<CggParroquia> cggParroquiaList) {
        this.cggParroquiaList = cggParroquiaList;
    }

    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
    }

    public CggProvincia getCggProvincia() {
        return cggProvincia;
    }

    public void setCggProvincia(CggProvincia cggProvincia) {
        this.cggProvincia = cggProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canId != null ? canId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggCanton)) {
            return false;
        }
        CggCanton other = (CggCanton) object;
        if ((this.canId == null && other.canId != null) || (this.canId != null && !this.canId.equals(other.canId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggCanton[ canId=" + canId + " ]";
    }
    
}
