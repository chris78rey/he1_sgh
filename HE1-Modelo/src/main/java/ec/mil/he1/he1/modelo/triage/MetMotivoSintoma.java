/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "MET_MOTIVO_SINTOMA")
@NamedQueries({
    @NamedQuery(name = "MetMotivoSintoma.findAll", query = "SELECT m FROM MetMotivoSintoma m")})
public class MetMotivoSintoma implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MOS_ID")
    private BigDecimal mosId;
    @OneToMany(mappedBy = "metMotivoSintoma", fetch = FetchType.LAZY)
    private List<MetTriageCab> metTriageCabList;
    @JoinColumn(name = "MOT_ID", referencedColumnName = "MOT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetMotivoConsulta metMotivoConsulta;
    @JoinColumn(name = "SIN_ID", referencedColumnName = "SIN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetSintoma metSintoma;
    @OneToMany(mappedBy = "metMotivoSintoma", fetch = FetchType.LAZY)
    private List<MetTriagePrioridad> metTriagePrioridadList;
    @OneToMany(mappedBy = "metMotivoSintoma", fetch = FetchType.LAZY)
    private List<MetTriageModificador> metTriageModificadorList;

    public MetMotivoSintoma() {
    }

    public MetMotivoSintoma(BigDecimal mosId) {
        this.mosId = mosId;
    }

    public BigDecimal getMosId() {
        return mosId;
    }

    public void setMosId(BigDecimal mosId) {
        this.mosId = mosId;
    }

    public List<MetTriageCab> getMetTriageCabList() {
        return metTriageCabList;
    }

    public void setMetTriageCabList(List<MetTriageCab> metTriageCabList) {
        this.metTriageCabList = metTriageCabList;
    }

    public MetMotivoConsulta getMetMotivoConsulta() {
        return metMotivoConsulta;
    }

    public void setMetMotivoConsulta(MetMotivoConsulta metMotivoConsulta) {
        this.metMotivoConsulta = metMotivoConsulta;
    }

    public MetSintoma getMetSintoma() {
        return metSintoma;
    }

    public void setMetSintoma(MetSintoma metSintoma) {
        this.metSintoma = metSintoma;
    }

    public List<MetTriagePrioridad> getMetTriagePrioridadList() {
        return metTriagePrioridadList;
    }

    public void setMetTriagePrioridadList(List<MetTriagePrioridad> metTriagePrioridadList) {
        this.metTriagePrioridadList = metTriagePrioridadList;
    }

    public List<MetTriageModificador> getMetTriageModificadorList() {
        return metTriageModificadorList;
    }

    public void setMetTriageModificadorList(List<MetTriageModificador> metTriageModificadorList) {
        this.metTriageModificadorList = metTriageModificadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mosId != null ? mosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetMotivoSintoma)) {
            return false;
        }
        MetMotivoSintoma other = (MetMotivoSintoma) object;
        if ((this.mosId == null && other.mosId != null) || (this.mosId != null && !this.mosId.equals(other.mosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetMotivoSintoma[ mosId=" + mosId + " ]";
    }
    
}
