/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

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
@Table(name = "CGG_FUERZA")
@NamedQueries({
    @NamedQuery(name = "CggFuerza.findAll", query = "SELECT c FROM CggFuerza c")})
public class CggFuerza implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "FUE_ID")
    private BigDecimal fueId;
    @Column(name = "FUE_DESCRIPCION")
    private String fueDescripcion;
    @OneToMany(mappedBy = "cggFuerza", fetch = FetchType.LAZY)
    private List<CggGradoMilitar> cggGradoMilitarList;

    public CggFuerza() {
    }

    public CggFuerza(BigDecimal fueId) {
        this.fueId = fueId;
    }

    public BigDecimal getFueId() {
        return fueId;
    }

    public void setFueId(BigDecimal fueId) {
        this.fueId = fueId;
    }

    public String getFueDescripcion() {
        return fueDescripcion;
    }

    public void setFueDescripcion(String fueDescripcion) {
        this.fueDescripcion = fueDescripcion;
    }

    public List<CggGradoMilitar> getCggGradoMilitarList() {
        return cggGradoMilitarList;
    }

    public void setCggGradoMilitarList(List<CggGradoMilitar> cggGradoMilitarList) {
        this.cggGradoMilitarList = cggGradoMilitarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fueId != null ? fueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggFuerza)) {
            return false;
        }
        CggFuerza other = (CggFuerza) object;
        if ((this.fueId == null && other.fueId != null) || (this.fueId != null && !this.fueId.equals(other.fueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggFuerza[ fueId=" + fueId + " ]";
    }
    
}
