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
@Table(name = "APN_ENTIDAD_CONVENIO")
@NamedQueries({
    @NamedQuery(name = "ApnEntidadConvenio.findAll", query = "SELECT a FROM ApnEntidadConvenio a")})
public class ApnEntidadConvenio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ECO_ID")
    private BigDecimal ecoId;
    @Column(name = "ECO_DESCRIPCION")
    private String ecoDescripcion;
    @Column(name = "ECO_RUC")
    private String ecoRuc;
    @Column(name = "ECO_ESTADO")
    private Character ecoEstado;
    @OneToMany(mappedBy = "apnEntidadConvenio", fetch = FetchType.LAZY)
    private List<ApnDescuentoEmpl> apnDescuentoEmplList;
    @OneToMany(mappedBy = "apnEntidadConvenio", fetch = FetchType.LAZY)
    private List<ApnHistoricoDescuento> apnHistoricoDescuentoList;

    public ApnEntidadConvenio() {
    }

    public ApnEntidadConvenio(BigDecimal ecoId) {
        this.ecoId = ecoId;
    }

    public BigDecimal getEcoId() {
        return ecoId;
    }

    public void setEcoId(BigDecimal ecoId) {
        this.ecoId = ecoId;
    }

    public String getEcoDescripcion() {
        return ecoDescripcion;
    }

    public void setEcoDescripcion(String ecoDescripcion) {
        this.ecoDescripcion = ecoDescripcion;
    }

    public String getEcoRuc() {
        return ecoRuc;
    }

    public void setEcoRuc(String ecoRuc) {
        this.ecoRuc = ecoRuc;
    }

    public Character getEcoEstado() {
        return ecoEstado;
    }

    public void setEcoEstado(Character ecoEstado) {
        this.ecoEstado = ecoEstado;
    }

    public List<ApnDescuentoEmpl> getApnDescuentoEmplList() {
        return apnDescuentoEmplList;
    }

    public void setApnDescuentoEmplList(List<ApnDescuentoEmpl> apnDescuentoEmplList) {
        this.apnDescuentoEmplList = apnDescuentoEmplList;
    }

    public List<ApnHistoricoDescuento> getApnHistoricoDescuentoList() {
        return apnHistoricoDescuentoList;
    }

    public void setApnHistoricoDescuentoList(List<ApnHistoricoDescuento> apnHistoricoDescuentoList) {
        this.apnHistoricoDescuentoList = apnHistoricoDescuentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecoId != null ? ecoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnEntidadConvenio)) {
            return false;
        }
        ApnEntidadConvenio other = (ApnEntidadConvenio) object;
        if ((this.ecoId == null && other.ecoId != null) || (this.ecoId != null && !this.ecoId.equals(other.ecoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnEntidadConvenio[ ecoId=" + ecoId + " ]";
    }
    
}
