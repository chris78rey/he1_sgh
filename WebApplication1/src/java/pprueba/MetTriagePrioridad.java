/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_TRIAGE_PRIORIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetTriagePrioridad.findAll", query = "SELECT m FROM MetTriagePrioridad m"),
    @NamedQuery(name = "MetTriagePrioridad.findByTprId", query = "SELECT m FROM MetTriagePrioridad m WHERE m.tprId = :tprId"),
    @NamedQuery(name = "MetTriagePrioridad.findByTprDescripcion", query = "SELECT m FROM MetTriagePrioridad m WHERE m.tprDescripcion = :tprDescripcion"),
    @NamedQuery(name = "MetTriagePrioridad.findByTprPrioridad", query = "SELECT m FROM MetTriagePrioridad m WHERE m.tprPrioridad = :tprPrioridad"),
    @NamedQuery(name = "MetTriagePrioridad.findByTprEstado", query = "SELECT m FROM MetTriagePrioridad m WHERE m.tprEstado = :tprEstado")})
public class MetTriagePrioridad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPR_ID")
    private BigDecimal tprId;
    @Size(max = 100)
    @Column(name = "TPR_DESCRIPCION")
    private String tprDescripcion;
    @Size(max = 2)
    @Column(name = "TPR_PRIORIDAD")
    private String tprPrioridad;
    @Column(name = "TPR_ESTADO")
    private Character tprEstado;
    @JoinColumn(name = "MOS_ID", referencedColumnName = "MOS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetMotivoSintoma metMotivoSintoma;

    public MetTriagePrioridad() {
    }

    public MetTriagePrioridad(BigDecimal tprId) {
        this.tprId = tprId;
    }

    public BigDecimal getTprId() {
        return tprId;
    }

    public void setTprId(BigDecimal tprId) {
        this.tprId = tprId;
    }

    public String getTprDescripcion() {
        return tprDescripcion;
    }

    public void setTprDescripcion(String tprDescripcion) {
        this.tprDescripcion = tprDescripcion;
    }

    public String getTprPrioridad() {
        return tprPrioridad;
    }

    public void setTprPrioridad(String tprPrioridad) {
        this.tprPrioridad = tprPrioridad;
    }

    public Character getTprEstado() {
        return tprEstado;
    }

    public void setTprEstado(Character tprEstado) {
        this.tprEstado = tprEstado;
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
        hash += (tprId != null ? tprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetTriagePrioridad)) {
            return false;
        }
        MetTriagePrioridad other = (MetTriagePrioridad) object;
        if ((this.tprId == null && other.tprId != null) || (this.tprId != null && !this.tprId.equals(other.tprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.MetTriagePrioridad[ tprId=" + tprId + " ]";
    }
    
}
