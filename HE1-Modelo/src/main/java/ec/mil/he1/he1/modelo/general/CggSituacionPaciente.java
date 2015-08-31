/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

import ec.mil.he1.he1.modelo.triage.MetPaciente;
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
@Table(name = "CGG_SITUACION_PACIENTE")
@NamedQueries({
    @NamedQuery(name = "CggSituacionPaciente.findAll", query = "SELECT c FROM CggSituacionPaciente c")})
public class CggSituacionPaciente implements Serializable {
    @OneToMany(mappedBy = "cggSituacionPaciente", fetch = FetchType.LAZY)
    private List<MetPaciente> metPacienteList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SIT_ID")
    private BigDecimal sitId;
    @Column(name = "SIT_DESCRIPCION")
    private String sitDescripcion;
    @Column(name = "SIT_ESTADO")
    private Character sitEstado;

    public CggSituacionPaciente() {
    }

    public CggSituacionPaciente(BigDecimal sitId) {
        this.sitId = sitId;
    }

    public BigDecimal getSitId() {
        return sitId;
    }

    public void setSitId(BigDecimal sitId) {
        this.sitId = sitId;
    }

    public String getSitDescripcion() {
        return sitDescripcion;
    }

    public void setSitDescripcion(String sitDescripcion) {
        this.sitDescripcion = sitDescripcion;
    }

    public Character getSitEstado() {
        return sitEstado;
    }

    public void setSitEstado(Character sitEstado) {
        this.sitEstado = sitEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sitId != null ? sitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggSituacionPaciente)) {
            return false;
        }
        CggSituacionPaciente other = (CggSituacionPaciente) object;
        if ((this.sitId == null && other.sitId != null) || (this.sitId != null && !this.sitId.equals(other.sitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggSituacionPaciente[ sitId=" + sitId + " ]";
    }

    public List<MetPaciente> getMetPacienteList() {
        return metPacienteList;
    }

    public void setMetPacienteList(List<MetPaciente> metPacienteList) {
        this.metPacienteList = metPacienteList;
    }
    
}
