/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "CGG_ZONAS_MIN_SALUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggZonasMinSalud.findAll", query = "SELECT c FROM CggZonasMinSalud c"),
    @NamedQuery(name = "CggZonasMinSalud.findByZmsId", query = "SELECT c FROM CggZonasMinSalud c WHERE c.zmsId = :zmsId"),
    @NamedQuery(name = "CggZonasMinSalud.findByZmsDescripcion", query = "SELECT c FROM CggZonasMinSalud c WHERE c.zmsDescripcion = :zmsDescripcion"),
    @NamedQuery(name = "CggZonasMinSalud.findByZmsCodigo", query = "SELECT c FROM CggZonasMinSalud c WHERE c.zmsCodigo = :zmsCodigo"),
    @NamedQuery(name = "CggZonasMinSalud.findByZmsEstado", query = "SELECT c FROM CggZonasMinSalud c WHERE c.zmsEstado = :zmsEstado")})
public class CggZonasMinSalud implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZMS_ID")
    private BigDecimal zmsId;
    @Size(max = 50)
    @Column(name = "ZMS_DESCRIPCION")
    private String zmsDescripcion;
    @Column(name = "ZMS_CODIGO")
    private BigInteger zmsCodigo;
    @Column(name = "ZMS_ESTADO")
    private Character zmsEstado;
    @OneToMany(mappedBy = "cggZonasMinSalud", fetch = FetchType.LAZY)
    private List<CggUnidadSalud> cggUnidadSaludList;

    public CggZonasMinSalud() {
    }

    public CggZonasMinSalud(BigDecimal zmsId) {
        this.zmsId = zmsId;
    }

    public BigDecimal getZmsId() {
        return zmsId;
    }

    public void setZmsId(BigDecimal zmsId) {
        this.zmsId = zmsId;
    }

    public String getZmsDescripcion() {
        return zmsDescripcion;
    }

    public void setZmsDescripcion(String zmsDescripcion) {
        this.zmsDescripcion = zmsDescripcion;
    }

    public BigInteger getZmsCodigo() {
        return zmsCodigo;
    }

    public void setZmsCodigo(BigInteger zmsCodigo) {
        this.zmsCodigo = zmsCodigo;
    }

    public Character getZmsEstado() {
        return zmsEstado;
    }

    public void setZmsEstado(Character zmsEstado) {
        this.zmsEstado = zmsEstado;
    }

    @XmlTransient
    public List<CggUnidadSalud> getCggUnidadSaludList() {
        return cggUnidadSaludList;
    }

    public void setCggUnidadSaludList(List<CggUnidadSalud> cggUnidadSaludList) {
        this.cggUnidadSaludList = cggUnidadSaludList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zmsId != null ? zmsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggZonasMinSalud)) {
            return false;
        }
        CggZonasMinSalud other = (CggZonasMinSalud) object;
        if ((this.zmsId == null && other.zmsId != null) || (this.zmsId != null && !this.zmsId.equals(other.zmsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.CggZonasMinSalud[ zmsId=" + zmsId + " ]";
    }
    
}
