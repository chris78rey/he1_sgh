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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MET_TRIAGE_SIGNOS_VITALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetTriageSignosVitales.findAll", query = "SELECT m FROM MetTriageSignosVitales m"),
    @NamedQuery(name = "MetTriageSignosVitales.findByTsvId", query = "SELECT m FROM MetTriageSignosVitales m WHERE m.tsvId = :tsvId"),
    @NamedQuery(name = "MetTriageSignosVitales.findByTsvValorMin", query = "SELECT m FROM MetTriageSignosVitales m WHERE m.tsvValorMin = :tsvValorMin"),
    @NamedQuery(name = "MetTriageSignosVitales.findByTsvValorMax", query = "SELECT m FROM MetTriageSignosVitales m WHERE m.tsvValorMax = :tsvValorMax")})
public class MetTriageSignosVitales implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TSV_ID")
    private BigDecimal tsvId;
    @Column(name = "TSV_VALOR_MIN")
    private BigInteger tsvValorMin;
    @Column(name = "TSV_VALOR_MAX")
    private BigInteger tsvValorMax;
    @JoinColumn(name = "SIG_ID", referencedColumnName = "SIG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetSignoVital metSignoVital;
    @JoinColumn(name = "TRC_ID", referencedColumnName = "TRC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetTriageCab metTriageCab;

    public MetTriageSignosVitales() {
    }

    public MetTriageSignosVitales(BigDecimal tsvId) {
        this.tsvId = tsvId;
    }

    public BigDecimal getTsvId() {
        return tsvId;
    }

    public void setTsvId(BigDecimal tsvId) {
        this.tsvId = tsvId;
    }

    public BigInteger getTsvValorMin() {
        return tsvValorMin;
    }

    public void setTsvValorMin(BigInteger tsvValorMin) {
        this.tsvValorMin = tsvValorMin;
    }

    public BigInteger getTsvValorMax() {
        return tsvValorMax;
    }

    public void setTsvValorMax(BigInteger tsvValorMax) {
        this.tsvValorMax = tsvValorMax;
    }

    public MetSignoVital getMetSignoVital() {
        return metSignoVital;
    }

    public void setMetSignoVital(MetSignoVital metSignoVital) {
        this.metSignoVital = metSignoVital;
    }

    public MetTriageCab getMetTriageCab() {
        return metTriageCab;
    }

    public void setMetTriageCab(MetTriageCab metTriageCab) {
        this.metTriageCab = metTriageCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tsvId != null ? tsvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetTriageSignosVitales)) {
            return false;
        }
        MetTriageSignosVitales other = (MetTriageSignosVitales) object;
        if ((this.tsvId == null && other.tsvId != null) || (this.tsvId != null && !this.tsvId.equals(other.tsvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.MetTriageSignosVitales[ tsvId=" + tsvId + " ]";
    }
    
}
