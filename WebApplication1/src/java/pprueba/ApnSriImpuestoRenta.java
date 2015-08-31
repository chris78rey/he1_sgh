/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_SRI_IMPUESTO_RENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnSriImpuestoRenta.findAll", query = "SELECT a FROM ApnSriImpuestoRenta a"),
    @NamedQuery(name = "ApnSriImpuestoRenta.findBySirId", query = "SELECT a FROM ApnSriImpuestoRenta a WHERE a.sirId = :sirId"),
    @NamedQuery(name = "ApnSriImpuestoRenta.findBySirFraccionBasica", query = "SELECT a FROM ApnSriImpuestoRenta a WHERE a.sirFraccionBasica = :sirFraccionBasica"),
    @NamedQuery(name = "ApnSriImpuestoRenta.findBySirExceso", query = "SELECT a FROM ApnSriImpuestoRenta a WHERE a.sirExceso = :sirExceso"),
    @NamedQuery(name = "ApnSriImpuestoRenta.findBySirImpuesto", query = "SELECT a FROM ApnSriImpuestoRenta a WHERE a.sirImpuesto = :sirImpuesto"),
    @NamedQuery(name = "ApnSriImpuestoRenta.findBySirPorcentaje", query = "SELECT a FROM ApnSriImpuestoRenta a WHERE a.sirPorcentaje = :sirPorcentaje"),
    @NamedQuery(name = "ApnSriImpuestoRenta.findBySirAnio", query = "SELECT a FROM ApnSriImpuestoRenta a WHERE a.sirAnio = :sirAnio")})
public class ApnSriImpuestoRenta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIR_ID")
    private BigDecimal sirId;
    @Column(name = "SIR_FRACCION_BASICA")
    private BigInteger sirFraccionBasica;
    @Column(name = "SIR_EXCESO")
    private BigInteger sirExceso;
    @Column(name = "SIR_IMPUESTO")
    private BigInteger sirImpuesto;
    @Column(name = "SIR_PORCENTAJE")
    private BigInteger sirPorcentaje;
    @Column(name = "SIR_ANIO")
    private Integer sirAnio;

    public ApnSriImpuestoRenta() {
    }

    public ApnSriImpuestoRenta(BigDecimal sirId) {
        this.sirId = sirId;
    }

    public BigDecimal getSirId() {
        return sirId;
    }

    public void setSirId(BigDecimal sirId) {
        this.sirId = sirId;
    }

    public BigInteger getSirFraccionBasica() {
        return sirFraccionBasica;
    }

    public void setSirFraccionBasica(BigInteger sirFraccionBasica) {
        this.sirFraccionBasica = sirFraccionBasica;
    }

    public BigInteger getSirExceso() {
        return sirExceso;
    }

    public void setSirExceso(BigInteger sirExceso) {
        this.sirExceso = sirExceso;
    }

    public BigInteger getSirImpuesto() {
        return sirImpuesto;
    }

    public void setSirImpuesto(BigInteger sirImpuesto) {
        this.sirImpuesto = sirImpuesto;
    }

    public BigInteger getSirPorcentaje() {
        return sirPorcentaje;
    }

    public void setSirPorcentaje(BigInteger sirPorcentaje) {
        this.sirPorcentaje = sirPorcentaje;
    }

    public Integer getSirAnio() {
        return sirAnio;
    }

    public void setSirAnio(Integer sirAnio) {
        this.sirAnio = sirAnio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sirId != null ? sirId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnSriImpuestoRenta)) {
            return false;
        }
        ApnSriImpuestoRenta other = (ApnSriImpuestoRenta) object;
        if ((this.sirId == null && other.sirId != null) || (this.sirId != null && !this.sirId.equals(other.sirId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnSriImpuestoRenta[ sirId=" + sirId + " ]";
    }
    
}
