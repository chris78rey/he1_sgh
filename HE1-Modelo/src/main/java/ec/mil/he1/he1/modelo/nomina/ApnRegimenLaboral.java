/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

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
@Table(name = "APN_REGIMEN_LABORAL")
@NamedQueries({
    @NamedQuery(name = "ApnRegimenLaboral.findAll", query = "SELECT a FROM ApnRegimenLaboral a")})
public class ApnRegimenLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RLA_ID")
    private BigDecimal rlaId;
    @Column(name = "RLA_DESCRIPCION")
    private String rlaDescripcion;
    @Column(name = "RLA_ESTADO")
    private String rlaEstado;
    @OneToMany(mappedBy = "apnRegimenLaboral", fetch = FetchType.LAZY)
    private List<AppEmpleado> appEmpleadoList;

    public ApnRegimenLaboral() {
    }

    public ApnRegimenLaboral(BigDecimal rlaId) {
        this.rlaId = rlaId;
    }

    public BigDecimal getRlaId() {
        return rlaId;
    }

    public void setRlaId(BigDecimal rlaId) {
        this.rlaId = rlaId;
    }

    public String getRlaDescripcion() {
        return rlaDescripcion;
    }

    public void setRlaDescripcion(String rlaDescripcion) {
        this.rlaDescripcion = rlaDescripcion;
    }

    public String getRlaEstado() {
        return rlaEstado;
    }

    public void setRlaEstado(String rlaEstado) {
        this.rlaEstado = rlaEstado;
    }

    public List<AppEmpleado> getAppEmpleadoList() {
        return appEmpleadoList;
    }

    public void setAppEmpleadoList(List<AppEmpleado> appEmpleadoList) {
        this.appEmpleadoList = appEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rlaId != null ? rlaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnRegimenLaboral)) {
            return false;
        }
        ApnRegimenLaboral other = (ApnRegimenLaboral) object;
        if ((this.rlaId == null && other.rlaId != null) || (this.rlaId != null && !this.rlaId.equals(other.rlaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnRegimenLaboral[ rlaId=" + rlaId + " ]";
    }
    
}
