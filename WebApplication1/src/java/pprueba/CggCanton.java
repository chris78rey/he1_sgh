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
@Table(name = "CGG_CANTON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggCanton.findAll", query = "SELECT c FROM CggCanton c"),
    @NamedQuery(name = "CggCanton.findByCanId", query = "SELECT c FROM CggCanton c WHERE c.canId = :canId"),
    @NamedQuery(name = "CggCanton.findByCanDescripcion", query = "SELECT c FROM CggCanton c WHERE c.canDescripcion = :canDescripcion"),
    @NamedQuery(name = "CggCanton.findByCanEstado", query = "SELECT c FROM CggCanton c WHERE c.canEstado = :canEstado")})
public class CggCanton implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAN_ID")
    private BigDecimal canId;
    @Size(max = 50)
    @Column(name = "CAN_DESCRIPCION")
    private String canDescripcion;
    @Column(name = "CAN_ESTADO")
    private Character canEstado;
    @OneToMany(mappedBy = "cggCanton", fetch = FetchType.LAZY)
    private List<CggUnidadSalud> cggUnidadSaludList;
    @OneToMany(mappedBy = "cggCanton", fetch = FetchType.LAZY)
    private List<CggParroquia> cggParroquiaList;
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

    @XmlTransient
    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
    }

    @XmlTransient
    public List<CggParroquia> getCggParroquiaList() {
        return cggParroquiaList;
    }

    public void setCggParroquiaList(List<CggParroquia> cggParroquiaList) {
        this.cggParroquiaList = cggParroquiaList;
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
        return "pprueba.CggCanton[ canId=" + canId + " ]";
    }
    
}
