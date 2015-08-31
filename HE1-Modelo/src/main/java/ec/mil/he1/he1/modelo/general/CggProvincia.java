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
@Table(name = "CGG_PROVINCIA")
@NamedQueries({
    @NamedQuery(name = "CggProvincia.findAll", query = "SELECT c FROM CggProvincia c")})
public class CggProvincia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRO_ID")
    private BigDecimal proId;
    @Column(name = "PRO_DESCRIPCION")
    private String proDescripcion;
    @Column(name = "PRO_ESTADO")
    private Character proEstado;
    @OneToMany(mappedBy = "cggProvincia", fetch = FetchType.LAZY)
    private List<CggUnidadSalud> cggUnidadSaludList;
    @OneToMany(mappedBy = "cggProvincia", fetch = FetchType.LAZY)
    private List<CggCanton> cggCantonList;

    public CggProvincia() {
    }

    public CggProvincia(BigDecimal proId) {
        this.proId = proId;
    }

    public BigDecimal getProId() {
        return proId;
    }

    public void setProId(BigDecimal proId) {
        this.proId = proId;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public Character getProEstado() {
        return proEstado;
    }

    public void setProEstado(Character proEstado) {
        this.proEstado = proEstado;
    }

    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
    }

    public List<CggCanton> getCggCantonList() {
        return cggCantonList;
    }

    public void setCggCantonList(List<CggCanton> cggCantonList) {
        this.cggCantonList = cggCantonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggProvincia)) {
            return false;
        }
        CggProvincia other = (CggProvincia) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggProvincia[ proId=" + proId + " ]";
    }
    
}
