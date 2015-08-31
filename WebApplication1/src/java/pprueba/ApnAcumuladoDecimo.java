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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_ACUMULADO_DECIMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnAcumuladoDecimo.findAll", query = "SELECT a FROM ApnAcumuladoDecimo a"),
    @NamedQuery(name = "ApnAcumuladoDecimo.findByAcuId", query = "SELECT a FROM ApnAcumuladoDecimo a WHERE a.acuId = :acuId"),
    @NamedQuery(name = "ApnAcumuladoDecimo.findByAdeDesde", query = "SELECT a FROM ApnAcumuladoDecimo a WHERE a.adeDesde = :adeDesde"),
    @NamedQuery(name = "ApnAcumuladoDecimo.findByAdeTipo", query = "SELECT a FROM ApnAcumuladoDecimo a WHERE a.adeTipo = :adeTipo"),
    @NamedQuery(name = "ApnAcumuladoDecimo.findByAdeFechaRegistro", query = "SELECT a FROM ApnAcumuladoDecimo a WHERE a.adeFechaRegistro = :adeFechaRegistro"),
    @NamedQuery(name = "ApnAcumuladoDecimo.findByAdeAcumula", query = "SELECT a FROM ApnAcumuladoDecimo a WHERE a.adeAcumula = :adeAcumula"),
    @NamedQuery(name = "ApnAcumuladoDecimo.findByAdeEstado", query = "SELECT a FROM ApnAcumuladoDecimo a WHERE a.adeEstado = :adeEstado")})
public class ApnAcumuladoDecimo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACU_ID")
    private BigDecimal acuId;
    @Column(name = "ADE_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adeDesde;
    @Column(name = "ADE_TIPO")
    private Character adeTipo;
    @Column(name = "ADE_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adeFechaRegistro;
    @Column(name = "ADE_ACUMULA")
    private Character adeAcumula;
    @Column(name = "ADE_ESTADO")
    private Character adeEstado;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnAcumuladoDecimo() {
    }

    public ApnAcumuladoDecimo(BigDecimal acuId) {
        this.acuId = acuId;
    }

    public BigDecimal getAcuId() {
        return acuId;
    }

    public void setAcuId(BigDecimal acuId) {
        this.acuId = acuId;
    }

    public Date getAdeDesde() {
        return adeDesde;
    }

    public void setAdeDesde(Date adeDesde) {
        this.adeDesde = adeDesde;
    }

    public Character getAdeTipo() {
        return adeTipo;
    }

    public void setAdeTipo(Character adeTipo) {
        this.adeTipo = adeTipo;
    }

    public Date getAdeFechaRegistro() {
        return adeFechaRegistro;
    }

    public void setAdeFechaRegistro(Date adeFechaRegistro) {
        this.adeFechaRegistro = adeFechaRegistro;
    }

    public Character getAdeAcumula() {
        return adeAcumula;
    }

    public void setAdeAcumula(Character adeAcumula) {
        this.adeAcumula = adeAcumula;
    }

    public Character getAdeEstado() {
        return adeEstado;
    }

    public void setAdeEstado(Character adeEstado) {
        this.adeEstado = adeEstado;
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
        hash += (acuId != null ? acuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnAcumuladoDecimo)) {
            return false;
        }
        ApnAcumuladoDecimo other = (ApnAcumuladoDecimo) object;
        if ((this.acuId == null && other.acuId != null) || (this.acuId != null && !this.acuId.equals(other.acuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnAcumuladoDecimo[ acuId=" + acuId + " ]";
    }
    
}
