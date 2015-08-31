/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

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
@Table(name = "APN_MOTIVO_LICENCIA")
@NamedQueries({
    @NamedQuery(name = "ApnMotivoLicencia.findAll", query = "SELECT a FROM ApnMotivoLicencia a")})
public class ApnMotivoLicencia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MLI_ID")
    private BigDecimal mliId;
    @Column(name = "MLI_DESCRIPCION")
    private String mliDescripcion;
    @Column(name = "MLI_ESTADO")
    private Character mliEstado;
    @OneToMany(mappedBy = "apnMotivoLicencia", fetch = FetchType.LAZY)
    private List<ApnLicenciaEmpl> apnLicenciaEmplList;

    public ApnMotivoLicencia() {
    }

    public ApnMotivoLicencia(BigDecimal mliId) {
        this.mliId = mliId;
    }

    public BigDecimal getMliId() {
        return mliId;
    }

    public void setMliId(BigDecimal mliId) {
        this.mliId = mliId;
    }

    public String getMliDescripcion() {
        return mliDescripcion;
    }

    public void setMliDescripcion(String mliDescripcion) {
        this.mliDescripcion = mliDescripcion;
    }

    public Character getMliEstado() {
        return mliEstado;
    }

    public void setMliEstado(Character mliEstado) {
        this.mliEstado = mliEstado;
    }

    public List<ApnLicenciaEmpl> getApnLicenciaEmplList() {
        return apnLicenciaEmplList;
    }

    public void setApnLicenciaEmplList(List<ApnLicenciaEmpl> apnLicenciaEmplList) {
        this.apnLicenciaEmplList = apnLicenciaEmplList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mliId != null ? mliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnMotivoLicencia)) {
            return false;
        }
        ApnMotivoLicencia other = (ApnMotivoLicencia) object;
        if ((this.mliId == null && other.mliId != null) || (this.mliId != null && !this.mliId.equals(other.mliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnMotivoLicencia[ mliId=" + mliId + " ]";
    }
    
}
