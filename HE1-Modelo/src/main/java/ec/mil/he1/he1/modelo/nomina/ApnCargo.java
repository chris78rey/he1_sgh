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
@Table(name = "APN_CARGO")
@NamedQueries({
    @NamedQuery(name = "ApnCargo.findAll", query = "SELECT a FROM ApnCargo a")})
public class ApnCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CAR_ID")
    private BigDecimal carId;
    @Column(name = "CAR_DESCRIPCION")
    private String carDescripcion;
    @Column(name = "CAR_ESTADO")
    private String carEstado;
    @OneToMany(mappedBy = "apnCargo", fetch = FetchType.LAZY)
    private List<ApnOrganicoDet> apnOrganicoDetList;

    public ApnCargo() {
    }

    public ApnCargo(BigDecimal carId) {
        this.carId = carId;
    }

    public BigDecimal getCarId() {
        return carId;
    }

    public void setCarId(BigDecimal carId) {
        this.carId = carId;
    }

    public String getCarDescripcion() {
        return carDescripcion;
    }

    public void setCarDescripcion(String carDescripcion) {
        this.carDescripcion = carDescripcion;
    }

    public String getCarEstado() {
        return carEstado;
    }

    public void setCarEstado(String carEstado) {
        this.carEstado = carEstado;
    }

    public List<ApnOrganicoDet> getApnOrganicoDetList() {
        return apnOrganicoDetList;
    }

    public void setApnOrganicoDetList(List<ApnOrganicoDet> apnOrganicoDetList) {
        this.apnOrganicoDetList = apnOrganicoDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnCargo)) {
            return false;
        }
        ApnCargo other = (ApnCargo) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnCargo[ carId=" + carId + " ]";
    }
    
}
