/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "APN_NIVEL_SERV_PUB")
@NamedQueries({
    @NamedQuery(name = "ApnNivelServPub.findAll", query = "SELECT a FROM ApnNivelServPub a")})
public class ApnNivelServPub implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NIV_ID")
    private BigDecimal nivId;
    @Column(name = "NIV_DESCRIPCION")
    private String nivDescripcion;
    @Column(name = "NIV_NIVEL")
    private BigInteger nivNivel;
    @Column(name = "NIV_ESTADO")
    private Character nivEstado;
    @OneToMany(mappedBy = "apnNivelServPub", fetch = FetchType.LAZY)
    private List<AppEmpleado> appEmpleadoList;

    public ApnNivelServPub() {
    }

    public ApnNivelServPub(BigDecimal nivId) {
        this.nivId = nivId;
    }

    public BigDecimal getNivId() {
        return nivId;
    }

    public void setNivId(BigDecimal nivId) {
        this.nivId = nivId;
    }

    public String getNivDescripcion() {
        return nivDescripcion;
    }

    public void setNivDescripcion(String nivDescripcion) {
        this.nivDescripcion = nivDescripcion;
    }

    public BigInteger getNivNivel() {
        return nivNivel;
    }

    public void setNivNivel(BigInteger nivNivel) {
        this.nivNivel = nivNivel;
    }

    public Character getNivEstado() {
        return nivEstado;
    }

    public void setNivEstado(Character nivEstado) {
        this.nivEstado = nivEstado;
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
        hash += (nivId != null ? nivId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnNivelServPub)) {
            return false;
        }
        ApnNivelServPub other = (ApnNivelServPub) object;
        if ((this.nivId == null && other.nivId != null) || (this.nivId != null && !this.nivId.equals(other.nivId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnNivelServPub[ nivId=" + nivId + " ]";
    }
    
}
