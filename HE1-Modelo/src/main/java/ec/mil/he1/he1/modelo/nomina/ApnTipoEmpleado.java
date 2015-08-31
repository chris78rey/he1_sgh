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
@Table(name = "APN_TIPO_EMPLEADO")
@NamedQueries({
    @NamedQuery(name = "ApnTipoEmpleado.findAll", query = "SELECT a FROM ApnTipoEmpleado a")})
public class ApnTipoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TEM_ID")
    private BigDecimal temId;
    @Column(name = "TEM_DESCRIPCION")
    private String temDescripcion;
    @Column(name = "TEM_ESTADO")
    private Character temEstado;
    @OneToMany(mappedBy = "apnTipoEmpleado", fetch = FetchType.LAZY)
    private List<AppEmpleado> appEmpleadoList;

    public ApnTipoEmpleado() {
    }

    public ApnTipoEmpleado(BigDecimal temId) {
        this.temId = temId;
    }

    public BigDecimal getTemId() {
        return temId;
    }

    public void setTemId(BigDecimal temId) {
        this.temId = temId;
    }

    public String getTemDescripcion() {
        return temDescripcion;
    }

    public void setTemDescripcion(String temDescripcion) {
        this.temDescripcion = temDescripcion;
    }

    public Character getTemEstado() {
        return temEstado;
    }

    public void setTemEstado(Character temEstado) {
        this.temEstado = temEstado;
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
        hash += (temId != null ? temId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnTipoEmpleado)) {
            return false;
        }
        ApnTipoEmpleado other = (ApnTipoEmpleado) object;
        if ((this.temId == null && other.temId != null) || (this.temId != null && !this.temId.equals(other.temId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnTipoEmpleado[ temId=" + temId + " ]";
    }
    
}
