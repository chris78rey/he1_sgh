/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "RES_PROV_CANT_PRQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResProvCantPrq.findAll", query = "SELECT r FROM ResProvCantPrq r"),
    @NamedQuery(name = "ResProvCantPrq.findByResId", query = "SELECT r FROM ResProvCantPrq r WHERE r.resId = :resId"),
    @NamedQuery(name = "ResProvCantPrq.findByProId", query = "SELECT r FROM ResProvCantPrq r WHERE r.proId = :proId"),
    @NamedQuery(name = "ResProvCantPrq.findByProNombre", query = "SELECT r FROM ResProvCantPrq r WHERE r.proNombre = :proNombre"),
    @NamedQuery(name = "ResProvCantPrq.findByCanId", query = "SELECT r FROM ResProvCantPrq r WHERE r.canId = :canId"),
    @NamedQuery(name = "ResProvCantPrq.findByCanNombre", query = "SELECT r FROM ResProvCantPrq r WHERE r.canNombre = :canNombre"),
    @NamedQuery(name = "ResProvCantPrq.findByPrqId", query = "SELECT r FROM ResProvCantPrq r WHERE r.prqId = :prqId"),
    @NamedQuery(name = "ResProvCantPrq.findByPrqNombre", query = "SELECT r FROM ResProvCantPrq r WHERE r.prqNombre = :prqNombre")})
public class ResProvCantPrq implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_ID")
    private BigDecimal resId;
    @Size(max = 10)
    @Column(name = "PRO_ID")
    private String proId;
    @Size(max = 50)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Size(max = 10)
    @Column(name = "CAN_ID")
    private String canId;
    @Size(max = 50)
    @Column(name = "CAN_NOMBRE")
    private String canNombre;
    @Size(max = 10)
    @Column(name = "PRQ_ID")
    private String prqId;
    @Size(max = 50)
    @Column(name = "PRQ_NOMBRE")
    private String prqNombre;

    public ResProvCantPrq() {
    }

    public ResProvCantPrq(BigDecimal resId) {
        this.resId = resId;
    }

    public BigDecimal getResId() {
        return resId;
    }

    public void setResId(BigDecimal resId) {
        this.resId = resId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getCanId() {
        return canId;
    }

    public void setCanId(String canId) {
        this.canId = canId;
    }

    public String getCanNombre() {
        return canNombre;
    }

    public void setCanNombre(String canNombre) {
        this.canNombre = canNombre;
    }

    public String getPrqId() {
        return prqId;
    }

    public void setPrqId(String prqId) {
        this.prqId = prqId;
    }

    public String getPrqNombre() {
        return prqNombre;
    }

    public void setPrqNombre(String prqNombre) {
        this.prqNombre = prqNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResProvCantPrq)) {
            return false;
        }
        ResProvCantPrq other = (ResProvCantPrq) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ResProvCantPrq[ resId=" + resId + " ]";
    }
    
}
