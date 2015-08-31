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
@Table(name = "APN_RELACION_LABORAL")
@NamedQueries({
    @NamedQuery(name = "ApnRelacionLaboral.findAll", query = "SELECT a FROM ApnRelacionLaboral a")})
public class ApnRelacionLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RLL_ID")
    private BigDecimal rllId;
    @Column(name = "RLL_DESCRIPCION")
    private String rllDescripcion;
    @Column(name = "RLL_ESTADO")
    private String rllEstado;
    @OneToMany(mappedBy = "apnRelacionLaboral", fetch = FetchType.LAZY)
    private List<AppEmpleado> appEmpleadoList;

    public ApnRelacionLaboral() {
    }

    public ApnRelacionLaboral(BigDecimal rllId) {
        this.rllId = rllId;
    }

    public BigDecimal getRllId() {
        return rllId;
    }

    public void setRllId(BigDecimal rllId) {
        this.rllId = rllId;
    }

    public String getRllDescripcion() {
        return rllDescripcion;
    }

    public void setRllDescripcion(String rllDescripcion) {
        this.rllDescripcion = rllDescripcion;
    }

    public String getRllEstado() {
        return rllEstado;
    }

    public void setRllEstado(String rllEstado) {
        this.rllEstado = rllEstado;
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
        hash += (rllId != null ? rllId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnRelacionLaboral)) {
            return false;
        }
        ApnRelacionLaboral other = (ApnRelacionLaboral) object;
        if ((this.rllId == null && other.rllId != null) || (this.rllId != null && !this.rllId.equals(other.rllId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnRelacionLaboral[ rllId=" + rllId + " ]";
    }
    
}
