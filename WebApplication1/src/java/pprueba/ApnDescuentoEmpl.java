/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_DESCUENTO_EMPL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnDescuentoEmpl.findAll", query = "SELECT a FROM ApnDescuentoEmpl a"),
    @NamedQuery(name = "ApnDescuentoEmpl.findByDemId", query = "SELECT a FROM ApnDescuentoEmpl a WHERE a.demId = :demId"),
    @NamedQuery(name = "ApnDescuentoEmpl.findByDemDesde", query = "SELECT a FROM ApnDescuentoEmpl a WHERE a.demDesde = :demDesde"),
    @NamedQuery(name = "ApnDescuentoEmpl.findByDemHasta", query = "SELECT a FROM ApnDescuentoEmpl a WHERE a.demHasta = :demHasta"),
    @NamedQuery(name = "ApnDescuentoEmpl.findByDemValor", query = "SELECT a FROM ApnDescuentoEmpl a WHERE a.demValor = :demValor"),
    @NamedQuery(name = "ApnDescuentoEmpl.findByDemDocumento", query = "SELECT a FROM ApnDescuentoEmpl a WHERE a.demDocumento = :demDocumento"),
    @NamedQuery(name = "ApnDescuentoEmpl.findByDemEstado", query = "SELECT a FROM ApnDescuentoEmpl a WHERE a.demEstado = :demEstado")})
public class ApnDescuentoEmpl implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEM_ID")
    private BigDecimal demId;
    @Column(name = "DEM_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date demDesde;
    @Column(name = "DEM_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date demHasta;
    @Column(name = "DEM_VALOR")
    private BigDecimal demValor;
    @Size(max = 250)
    @Column(name = "DEM_DOCUMENTO")
    private String demDocumento;
    @Size(max = 8)
    @Column(name = "DEM_ESTADO")
    private String demEstado;
    @JoinColumn(name = "ENT_ID", referencedColumnName = "ECO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnEntidadConvenio apnEntidadConvenio;
    @JoinColumn(name = "TEM_ID", referencedColumnName = "TDE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnTipoDescuento apnTipoDescuento;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnDescuentoEmpl() {
    }

    public ApnDescuentoEmpl(BigDecimal demId) {
        this.demId = demId;
    }

    public BigDecimal getDemId() {
        return demId;
    }

    public void setDemId(BigDecimal demId) {
        this.demId = demId;
    }

    public Date getDemDesde() {
        return demDesde;
    }

    public void setDemDesde(Date demDesde) {
        this.demDesde = demDesde;
    }

    public Date getDemHasta() {
        return demHasta;
    }

    public void setDemHasta(Date demHasta) {
        this.demHasta = demHasta;
    }

    public BigDecimal getDemValor() {
        return demValor;
    }

    public void setDemValor(BigDecimal demValor) {
        this.demValor = demValor;
    }

    public String getDemDocumento() {
        return demDocumento;
    }

    public void setDemDocumento(String demDocumento) {
        this.demDocumento = demDocumento;
    }

    public String getDemEstado() {
        return demEstado;
    }

    public void setDemEstado(String demEstado) {
        this.demEstado = demEstado;
    }

    public ApnEntidadConvenio getApnEntidadConvenio() {
        return apnEntidadConvenio;
    }

    public void setApnEntidadConvenio(ApnEntidadConvenio apnEntidadConvenio) {
        this.apnEntidadConvenio = apnEntidadConvenio;
    }

    public ApnTipoDescuento getApnTipoDescuento() {
        return apnTipoDescuento;
    }

    public void setApnTipoDescuento(ApnTipoDescuento apnTipoDescuento) {
        this.apnTipoDescuento = apnTipoDescuento;
    }

    public AppEmpleado getAppEmpleado() {
        return appEmpleado;
    }

    public void setAppEmpleado(AppEmpleado appEmpleado) {
        this.appEmpleado = appEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demId != null ? demId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnDescuentoEmpl)) {
            return false;
        }
        ApnDescuentoEmpl other = (ApnDescuentoEmpl) object;
        if ((this.demId == null && other.demId != null) || (this.demId != null && !this.demId.equals(other.demId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnDescuentoEmpl[ demId=" + demId + " ]";
    }
    
}
