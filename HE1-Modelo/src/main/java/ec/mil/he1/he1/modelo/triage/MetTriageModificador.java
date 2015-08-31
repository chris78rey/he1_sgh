/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_TRIAGE_MODIFICADOR")
@NamedQueries({
    @NamedQuery(name = "MetTriageModificador.findAll", query = "SELECT m FROM MetTriageModificador m")})
public class MetTriageModificador implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TMO_ID")
    private BigDecimal tmoId;
    @JoinColumn(name = "MOD_ID", referencedColumnName = "MOD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetModificador metModificador;
    @JoinColumn(name = "MOS_ID", referencedColumnName = "MOS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetMotivoSintoma metMotivoSintoma;

    public MetTriageModificador() {
    }

    public MetTriageModificador(BigDecimal tmoId) {
        this.tmoId = tmoId;
    }

    public BigDecimal getTmoId() {
        return tmoId;
    }

    public void setTmoId(BigDecimal tmoId) {
        this.tmoId = tmoId;
    }

    public MetModificador getMetModificador() {
        return metModificador;
    }

    public void setMetModificador(MetModificador metModificador) {
        this.metModificador = metModificador;
    }

    public MetMotivoSintoma getMetMotivoSintoma() {
        return metMotivoSintoma;
    }

    public void setMetMotivoSintoma(MetMotivoSintoma metMotivoSintoma) {
        this.metMotivoSintoma = metMotivoSintoma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmoId != null ? tmoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetTriageModificador)) {
            return false;
        }
        MetTriageModificador other = (MetTriageModificador) object;
        if ((this.tmoId == null && other.tmoId != null) || (this.tmoId != null && !this.tmoId.equals(other.tmoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetTriageModificador[ tmoId=" + tmoId + " ]";
    }
    
}
