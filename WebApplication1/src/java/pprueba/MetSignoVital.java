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
@Table(name = "MET_SIGNO_VITAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetSignoVital.findAll", query = "SELECT m FROM MetSignoVital m"),
    @NamedQuery(name = "MetSignoVital.findBySigId", query = "SELECT m FROM MetSignoVital m WHERE m.sigId = :sigId"),
    @NamedQuery(name = "MetSignoVital.findBySigDescripcion", query = "SELECT m FROM MetSignoVital m WHERE m.sigDescripcion = :sigDescripcion"),
    @NamedQuery(name = "MetSignoVital.findBySigValorMinAdulto", query = "SELECT m FROM MetSignoVital m WHERE m.sigValorMinAdulto = :sigValorMinAdulto"),
    @NamedQuery(name = "MetSignoVital.findBySigValorMaxAdulto", query = "SELECT m FROM MetSignoVital m WHERE m.sigValorMaxAdulto = :sigValorMaxAdulto"),
    @NamedQuery(name = "MetSignoVital.findBySigValorMinPediatrico", query = "SELECT m FROM MetSignoVital m WHERE m.sigValorMinPediatrico = :sigValorMinPediatrico"),
    @NamedQuery(name = "MetSignoVital.findBySigValorMaxPediatrico", query = "SELECT m FROM MetSignoVital m WHERE m.sigValorMaxPediatrico = :sigValorMaxPediatrico"),
    @NamedQuery(name = "MetSignoVital.findBySigEstado", query = "SELECT m FROM MetSignoVital m WHERE m.sigEstado = :sigEstado")})
public class MetSignoVital implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIG_ID")
    private BigDecimal sigId;
    @Size(max = 100)
    @Column(name = "SIG_DESCRIPCION")
    private String sigDescripcion;
    @Column(name = "SIG_VALOR_MIN_ADULTO")
    private BigInteger sigValorMinAdulto;
    @Column(name = "SIG_VALOR_MAX_ADULTO")
    private BigInteger sigValorMaxAdulto;
    @Column(name = "SIG_VALOR_MIN_PEDIATRICO")
    private BigInteger sigValorMinPediatrico;
    @Column(name = "SIG_VALOR_MAX_PEDIATRICO")
    private BigInteger sigValorMaxPediatrico;
    @Column(name = "SIG_ESTADO")
    private Character sigEstado;
    @OneToMany(mappedBy = "metSignoVital", fetch = FetchType.LAZY)
    private List<MetTriageSignosVitales> metTriageSignosVitalesList;

    public MetSignoVital() {
    }

    public MetSignoVital(BigDecimal sigId) {
        this.sigId = sigId;
    }

    public BigDecimal getSigId() {
        return sigId;
    }

    public void setSigId(BigDecimal sigId) {
        this.sigId = sigId;
    }

    public String getSigDescripcion() {
        return sigDescripcion;
    }

    public void setSigDescripcion(String sigDescripcion) {
        this.sigDescripcion = sigDescripcion;
    }

    public BigInteger getSigValorMinAdulto() {
        return sigValorMinAdulto;
    }

    public void setSigValorMinAdulto(BigInteger sigValorMinAdulto) {
        this.sigValorMinAdulto = sigValorMinAdulto;
    }

    public BigInteger getSigValorMaxAdulto() {
        return sigValorMaxAdulto;
    }

    public void setSigValorMaxAdulto(BigInteger sigValorMaxAdulto) {
        this.sigValorMaxAdulto = sigValorMaxAdulto;
    }

    public BigInteger getSigValorMinPediatrico() {
        return sigValorMinPediatrico;
    }

    public void setSigValorMinPediatrico(BigInteger sigValorMinPediatrico) {
        this.sigValorMinPediatrico = sigValorMinPediatrico;
    }

    public BigInteger getSigValorMaxPediatrico() {
        return sigValorMaxPediatrico;
    }

    public void setSigValorMaxPediatrico(BigInteger sigValorMaxPediatrico) {
        this.sigValorMaxPediatrico = sigValorMaxPediatrico;
    }

    public Character getSigEstado() {
        return sigEstado;
    }

    public void setSigEstado(Character sigEstado) {
        this.sigEstado = sigEstado;
    }

    @XmlTransient
    public List<MetTriageSignosVitales> getMetTriageSignosVitalesList() {
        return metTriageSignosVitalesList;
    }

    public void setMetTriageSignosVitalesList(List<MetTriageSignosVitales> metTriageSignosVitalesList) {
        this.metTriageSignosVitalesList = metTriageSignosVitalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sigId != null ? sigId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetSignoVital)) {
            return false;
        }
        MetSignoVital other = (MetSignoVital) object;
        if ((this.sigId == null && other.sigId != null) || (this.sigId != null && !this.sigId.equals(other.sigId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.MetSignoVital[ sigId=" + sigId + " ]";
    }
    
}
