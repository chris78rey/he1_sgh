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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MET_TRIAGE_CAB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetTriageCab.findAll", query = "SELECT m FROM MetTriageCab m"),
    @NamedQuery(name = "MetTriageCab.findByTrcId", query = "SELECT m FROM MetTriageCab m WHERE m.trcId = :trcId"),
    @NamedQuery(name = "MetTriageCab.findByTrcCentral", query = "SELECT m FROM MetTriageCab m WHERE m.trcCentral = :trcCentral"),
    @NamedQuery(name = "MetTriageCab.findByTrcPeriferica", query = "SELECT m FROM MetTriageCab m WHERE m.trcPeriferica = :trcPeriferica"),
    @NamedQuery(name = "MetTriageCab.findByTrcTotalGlassgow", query = "SELECT m FROM MetTriageCab m WHERE m.trcTotalGlassgow = :trcTotalGlassgow"),
    @NamedQuery(name = "MetTriageCab.findByTrcObservacion", query = "SELECT m FROM MetTriageCab m WHERE m.trcObservacion = :trcObservacion")})
public class MetTriageCab implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRC_ID")
    private BigDecimal trcId;
    @Column(name = "TRC_CENTRAL")
    private Character trcCentral;
    @Column(name = "TRC_PERIFERICA")
    private Character trcPeriferica;
    @Column(name = "TRC_TOTAL_GLASSGOW")
    private BigInteger trcTotalGlassgow;
    @Size(max = 500)
    @Column(name = "TRC_OBSERVACION")
    private String trcObservacion;
    @OneToMany(mappedBy = "metTriageCab", fetch = FetchType.LAZY)
    private List<MetTriageSignosVitales> metTriageSignosVitalesList;
    @OneToMany(mappedBy = "metTriageCab", fetch = FetchType.LAZY)
    private List<MetTriageGlassgow> metTriageGlassgowList;
    @JoinColumn(name = "MOS_ID", referencedColumnName = "MOS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetMotivoSintoma metMotivoSintoma;
    @JoinColumn(name = "TUR_ID", referencedColumnName = "TUR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetTurno metTurno;
    @JoinColumn(name = "TEM_ID", referencedColumnName = "TEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetTurnoEmpleado metTurnoEmpleado;

    public MetTriageCab() {
    }

    public MetTriageCab(BigDecimal trcId) {
        this.trcId = trcId;
    }

    public BigDecimal getTrcId() {
        return trcId;
    }

    public void setTrcId(BigDecimal trcId) {
        this.trcId = trcId;
    }

    public Character getTrcCentral() {
        return trcCentral;
    }

    public void setTrcCentral(Character trcCentral) {
        this.trcCentral = trcCentral;
    }

    public Character getTrcPeriferica() {
        return trcPeriferica;
    }

    public void setTrcPeriferica(Character trcPeriferica) {
        this.trcPeriferica = trcPeriferica;
    }

    public BigInteger getTrcTotalGlassgow() {
        return trcTotalGlassgow;
    }

    public void setTrcTotalGlassgow(BigInteger trcTotalGlassgow) {
        this.trcTotalGlassgow = trcTotalGlassgow;
    }

    public String getTrcObservacion() {
        return trcObservacion;
    }

    public void setTrcObservacion(String trcObservacion) {
        this.trcObservacion = trcObservacion;
    }

    @XmlTransient
    public List<MetTriageSignosVitales> getMetTriageSignosVitalesList() {
        return metTriageSignosVitalesList;
    }

    public void setMetTriageSignosVitalesList(List<MetTriageSignosVitales> metTriageSignosVitalesList) {
        this.metTriageSignosVitalesList = metTriageSignosVitalesList;
    }

    @XmlTransient
    public List<MetTriageGlassgow> getMetTriageGlassgowList() {
        return metTriageGlassgowList;
    }

    public void setMetTriageGlassgowList(List<MetTriageGlassgow> metTriageGlassgowList) {
        this.metTriageGlassgowList = metTriageGlassgowList;
    }

    public MetMotivoSintoma getMetMotivoSintoma() {
        return metMotivoSintoma;
    }

    public void setMetMotivoSintoma(MetMotivoSintoma metMotivoSintoma) {
        this.metMotivoSintoma = metMotivoSintoma;
    }

    public MetTurno getMetTurno() {
        return metTurno;
    }

    public void setMetTurno(MetTurno metTurno) {
        this.metTurno = metTurno;
    }

    public MetTurnoEmpleado getMetTurnoEmpleado() {
        return metTurnoEmpleado;
    }

    public void setMetTurnoEmpleado(MetTurnoEmpleado metTurnoEmpleado) {
        this.metTurnoEmpleado = metTurnoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trcId != null ? trcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetTriageCab)) {
            return false;
        }
        MetTriageCab other = (MetTriageCab) object;
        if ((this.trcId == null && other.trcId != null) || (this.trcId != null && !this.trcId.equals(other.trcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.MetTriageCab[ trcId=" + trcId + " ]";
    }
    
}
