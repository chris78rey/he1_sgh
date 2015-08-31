/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "CGG_PARENTESCO")
@NamedQueries({
    @NamedQuery(name = "CggParentesco.findAll", query = "SELECT c FROM CggParentesco c")})
public class CggParentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PAR_ID")
    private BigDecimal parId;
    @Column(name = "PAR_DESCRIPCION")
    private String parDescripcion;
    @Column(name = "PAR_ESTADO")
    private Character parEstado;

    public CggParentesco() {
    }

    public CggParentesco(BigDecimal parId) {
        this.parId = parId;
    }

    public BigDecimal getParId() {
        return parId;
    }

    public void setParId(BigDecimal parId) {
        this.parId = parId;
    }

    public String getParDescripcion() {
        return parDescripcion;
    }

    public void setParDescripcion(String parDescripcion) {
        this.parDescripcion = parDescripcion;
    }

    public Character getParEstado() {
        return parEstado;
    }

    public void setParEstado(Character parEstado) {
        this.parEstado = parEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parId != null ? parId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggParentesco)) {
            return false;
        }
        CggParentesco other = (CggParentesco) object;
        if ((this.parId == null && other.parId != null) || (this.parId != null && !this.parId.equals(other.parId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggParentesco[ parId=" + parId + " ]";
    }
    
}
