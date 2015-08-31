/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_TURNO")
@NamedQueries({
    @NamedQuery(name = "MetTurno.findAll", query = "SELECT m FROM MetTurno m")})
public class MetTurno implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TUR_ID")
    private BigDecimal turId;
    @Column(name = "TUR_FECHA_TURNO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date turFechaTurno;
    @Column(name = "TUR_ESTADO")
    private Character turEstado;
    @Column(name = "TUR_NUM_TICKET")
    private BigInteger turNumTicket;
    @OneToMany(mappedBy = "metTurno", fetch = FetchType.LAZY)
    private List<MetTriageCab> metTriageCabList;
    @JoinColumn(name = "PAC_ID", referencedColumnName = "PAC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetPaciente metPaciente;
    @JoinColumn(name = "UBI_ID", referencedColumnName = "UBI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetUbicacionAtencion metUbicacionAtencion;
    @OneToMany(mappedBy = "metTurno", fetch = FetchType.LAZY)
    private List<MetTurnoEmpleado> metTurnoEmpleadoList;

    public MetTurno() {
    }

    public MetTurno(BigDecimal turId) {
        this.turId = turId;
    }

    public BigDecimal getTurId() {
        return turId;
    }

    public void setTurId(BigDecimal turId) {
        this.turId = turId;
    }

    public Date getTurFechaTurno() {
        return turFechaTurno;
    }

    public void setTurFechaTurno(Date turFechaTurno) {
        this.turFechaTurno = turFechaTurno;
    }

    public Character getTurEstado() {
        return turEstado;
    }

    public void setTurEstado(Character turEstado) {
        this.turEstado = turEstado;
    }

    public BigInteger getTurNumTicket() {
        return turNumTicket;
    }

    public void setTurNumTicket(BigInteger turNumTicket) {
        this.turNumTicket = turNumTicket;
    }

    public List<MetTriageCab> getMetTriageCabList() {
        return metTriageCabList;
    }

    public void setMetTriageCabList(List<MetTriageCab> metTriageCabList) {
        this.metTriageCabList = metTriageCabList;
    }

    public MetPaciente getMetPaciente() {
        return metPaciente;
    }

    public void setMetPaciente(MetPaciente metPaciente) {
        this.metPaciente = metPaciente;
    }

    public MetUbicacionAtencion getMetUbicacionAtencion() {
        return metUbicacionAtencion;
    }

    public void setMetUbicacionAtencion(MetUbicacionAtencion metUbicacionAtencion) {
        this.metUbicacionAtencion = metUbicacionAtencion;
    }

    public List<MetTurnoEmpleado> getMetTurnoEmpleadoList() {
        return metTurnoEmpleadoList;
    }

    public void setMetTurnoEmpleadoList(List<MetTurnoEmpleado> metTurnoEmpleadoList) {
        this.metTurnoEmpleadoList = metTurnoEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turId != null ? turId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetTurno)) {
            return false;
        }
        MetTurno other = (MetTurno) object;
        if ((this.turId == null && other.turId != null) || (this.turId != null && !this.turId.equals(other.turId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetTurno[ turId=" + turId + " ]";
    }
    
}
