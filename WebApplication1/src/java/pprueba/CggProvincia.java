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
@Table(name = "CGG_PROVINCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggProvincia.findAll", query = "SELECT c FROM CggProvincia c"),
    @NamedQuery(name = "CggProvincia.findByProId", query = "SELECT c FROM CggProvincia c WHERE c.proId = :proId"),
    @NamedQuery(name = "CggProvincia.findByProDescripcion", query = "SELECT c FROM CggProvincia c WHERE c.proDescripcion = :proDescripcion"),
    @NamedQuery(name = "CggProvincia.findByProEstado", query = "SELECT c FROM CggProvincia c WHERE c.proEstado = :proEstado")})
public class CggProvincia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ID")
    private BigDecimal proId;
    @Size(max = 30)
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

    @XmlTransient
    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
    }

    @XmlTransient
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
        return "pprueba.CggProvincia[ proId=" + proId + " ]";
    }
    
}
