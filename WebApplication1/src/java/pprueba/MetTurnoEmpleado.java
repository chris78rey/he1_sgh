/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_TURNO_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetTurnoEmpleado.findAll", query = "SELECT m FROM MetTurnoEmpleado m"),
    @NamedQuery(name = "MetTurnoEmpleado.findByTemId", query = "SELECT m FROM MetTurnoEmpleado m WHERE m.temId = :temId"),
    @NamedQuery(name = "MetTurnoEmpleado.findByTemFechaDesde", query = "SELECT m FROM MetTurnoEmpleado m WHERE m.temFechaDesde = :temFechaDesde"),
    @NamedQuery(name = "MetTurnoEmpleado.findByTemFechaHasta", query = "SELECT m FROM MetTurnoEmpleado m WHERE m.temFechaHasta = :temFechaHasta")})
public class MetTurnoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEM_ID")
    private BigDecimal temId;
    @Column(name = "TEM_FECHA_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temFechaDesde;
    @Column(name = "TEM_FECHA_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temFechaHasta;
    @OneToMany(mappedBy = "metTurnoEmpleado", fetch = FetchType.LAZY)
    private List<MetTriageCab> metTriageCabList;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;
    @JoinColumn(name = "TUR_ID", referencedColumnName = "TUR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetTurno metTurno;
    @JoinColumn(name = "UBI_ID", referencedColumnName = "UBI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetUbicacionAtencion metUbicacionAtencion;

    public MetTurnoEmpleado() {
    }

    public MetTurnoEmpleado(BigDecimal temId) {
        this.temId = temId;
    }

    public BigDecimal getTemId() {
        return temId;
    }

    public void setTemId(BigDecimal temId) {
        this.temId = temId;
    }

    public Date getTemFechaDesde() {
        return temFechaDesde;
    }

    public void setTemFechaDesde(Date temFechaDesde) {
        this.temFechaDesde = temFechaDesde;
    }

    public Date getTemFechaHasta() {
        return temFechaHasta;
    }

    public void setTemFechaHasta(Date temFechaHasta) {
        this.temFechaHasta = temFechaHasta;
    }

    @XmlTransient
    public List<MetTriageCab> getMetTriageCabList() {
        return metTriageCabList;
    }

    public void setMetTriageCabList(List<MetTriageCab> metTriageCabList) {
        this.metTriageCabList = metTriageCabList;
    }

    public AppEmpleado getAppEmpleado() {
        return appEmpleado;
    }

    public void setAppEmpleado(AppEmpleado appEmpleado) {
        this.appEmpleado = appEmpleado;
    }

    public MetTurno getMetTurno() {
        return metTurno;
    }

    public void setMetTurno(MetTurno metTurno) {
        this.metTurno = metTurno;
    }

    public MetUbicacionAtencion getMetUbicacionAtencion() {
        return metUbicacionAtencion;
    }

    public void setMetUbicacionAtencion(MetUbicacionAtencion metUbicacionAtencion) {
        this.metUbicacionAtencion = metUbicacionAtencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (temId != null ? temId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetTurnoEmpleado)) {
            return false;
        }
        MetTurnoEmpleado other = (MetTurnoEmpleado) object;
        if ((this.temId == null && other.temId != null) || (this.temId != null && !this.temId.equals(other.temId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.MetTurnoEmpleado[ temId=" + temId + " ]";
    }
    
}
