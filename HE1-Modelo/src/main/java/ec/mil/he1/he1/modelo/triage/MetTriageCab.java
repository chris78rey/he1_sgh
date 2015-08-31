/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

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

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_TRIAGE_CAB")
@NamedQueries({
    @NamedQuery(name = "MetTriageCab.findAll", query = "SELECT m FROM MetTriageCab m")})
public class MetTriageCab implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TRC_ID")
    private BigDecimal trcId;
    @Column(name = "TRC_CENTRAL")
    private Character trcCentral;
    @Column(name = "TRC_PERIFERICA")
    private Character trcPeriferica;
    @Column(name = "TRC_TOTAL_GLASSGOW")
    private BigInteger trcTotalGlassgow;
    @Column(name = "TRC_OBSERVACION")
    private String trcObservacion;
    @OneToMany(mappedBy = "metTriageCab", fetch = FetchType.LAZY)
    private List<MetTriageSignosVitales> metTriageSignosVitalesList;
    @JoinColumn(name = "MOS_ID", referencedColumnName = "MOS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetMotivoSintoma metMotivoSintoma;
    @JoinColumn(name = "TUR_ID", referencedColumnName = "TUR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetTurno metTurno;
    @JoinColumn(name = "TEM_ID", referencedColumnName = "TEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetTurnoEmpleado metTurnoEmpleado;
    @OneToMany(mappedBy = "metTriageCab", fetch = FetchType.LAZY)
    private List<MetTriageGlassgow> metTriageGlassgowList;

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

    public List<MetTriageSignosVitales> getMetTriageSignosVitalesList() {
        return metTriageSignosVitalesList;
    }

    public void setMetTriageSignosVitalesList(List<MetTriageSignosVitales> metTriageSignosVitalesList) {
        this.metTriageSignosVitalesList = metTriageSignosVitalesList;
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

    public List<MetTriageGlassgow> getMetTriageGlassgowList() {
        return metTriageGlassgowList;
    }

    public void setMetTriageGlassgowList(List<MetTriageGlassgow> metTriageGlassgowList) {
        this.metTriageGlassgowList = metTriageGlassgowList;
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
        return "ec.mil.he1.he1.modelo.triage.MetTriageCab[ trcId=" + trcId + " ]";
    }
    
}
