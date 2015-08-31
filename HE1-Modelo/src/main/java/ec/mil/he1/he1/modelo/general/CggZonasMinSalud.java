/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

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

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "CGG_ZONAS_MIN_SALUD")
@NamedQueries({
    @NamedQuery(name = "CggZonasMinSalud.findAll", query = "SELECT c FROM CggZonasMinSalud c")})
public class CggZonasMinSalud implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ZMS_ID")
    private BigDecimal zmsId;
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
        return "ec.mil.he1.he1.modelo.general.CggZonasMinSalud[ zmsId=" + zmsId + " ]";
    }
    
}
