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
@Table(name = "CGG_CTRO_COORD_SALUD")
@NamedQueries({
    @NamedQuery(name = "CggCtroCoordSalud.findAll", query = "SELECT c FROM CggCtroCoordSalud c")})
public class CggCtroCoordSalud implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CCS_ID")
    private BigDecimal ccsId;
    @Column(name = "CCS_DESCRIPCION")
    private String ccsDescripcion;
    @Column(name = "CCS_CIUDAD")
    private String ccsCiudad;
    @OneToMany(mappedBy = "cggCtroCoordSalud", fetch = FetchType.LAZY)
    private List<CggUnidadSalud> cggUnidadSaludList;

    public CggCtroCoordSalud() {
    }

    public CggCtroCoordSalud(BigDecimal ccsId) {
        this.ccsId = ccsId;
    }

    public BigDecimal getCcsId() {
        return ccsId;
    }

    public void setCcsId(BigDecimal ccsId) {
        this.ccsId = ccsId;
    }

    public String getCcsDescripcion() {
        return ccsDescripcion;
    }

    public void setCcsDescripcion(String ccsDescripcion) {
        this.ccsDescripcion = ccsDescripcion;
    }

    public String getCcsCiudad() {
        return ccsCiudad;
    }

    public void setCcsCiudad(String ccsCiudad) {
        this.ccsCiudad = ccsCiudad;
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
        hash += (ccsId != null ? ccsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggCtroCoordSalud)) {
            return false;
        }
        CggCtroCoordSalud other = (CggCtroCoordSalud) object;
        if ((this.ccsId == null && other.ccsId != null) || (this.ccsId != null && !this.ccsId.equals(other.ccsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggCtroCoordSalud[ ccsId=" + ccsId + " ]";
    }
    
}
