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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_MOTIVO_CONSULTA")
@NamedQueries({
    @NamedQuery(name = "MetMotivoConsulta.findAll", query = "SELECT m FROM MetMotivoConsulta m")})
public class MetMotivoConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MOT_ID")
    private BigDecimal motId;
    @Column(name = "MOT_DESCRIPCION")
    private String motDescripcion;
    @Column(name = "MOT_ESTADO")
    private Character motEstado;
    @OneToMany(mappedBy = "metMotivoConsulta", fetch = FetchType.LAZY)
    private List<MetMotivoSintoma> metMotivoSintomaList;

    public MetMotivoConsulta() {
    }

    public MetMotivoConsulta(BigDecimal motId) {
        this.motId = motId;
    }

    public BigDecimal getMotId() {
        return motId;
    }

    public void setMotId(BigDecimal motId) {
        this.motId = motId;
    }

    public String getMotDescripcion() {
        return motDescripcion;
    }

    public void setMotDescripcion(String motDescripcion) {
        this.motDescripcion = motDescripcion;
    }

    public Character getMotEstado() {
        return motEstado;
    }

    public void setMotEstado(Character motEstado) {
        this.motEstado = motEstado;
    }

    public List<MetMotivoSintoma> getMetMotivoSintomaList() {
        return metMotivoSintomaList;
    }

    public void setMetMotivoSintomaList(List<MetMotivoSintoma> metMotivoSintomaList) {
        this.metMotivoSintomaList = metMotivoSintomaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (motId != null ? motId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetMotivoConsulta)) {
            return false;
        }
        MetMotivoConsulta other = (MetMotivoConsulta) object;
        if ((this.motId == null && other.motId != null) || (this.motId != null && !this.motId.equals(other.motId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetMotivoConsulta[ motId=" + motId + " ]";
    }
    
}
