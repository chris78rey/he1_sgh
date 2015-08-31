/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
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
@Table(name = "RES_PARROQUIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResParroquia.findAll", query = "SELECT r FROM ResParroquia r"),
    @NamedQuery(name = "ResParroquia.findByPrqIid", query = "SELECT r FROM ResParroquia r WHERE r.prqIid = :prqIid"),
    @NamedQuery(name = "ResParroquia.findByPrq1", query = "SELECT r FROM ResParroquia r WHERE r.prq1 = :prq1"),
    @NamedQuery(name = "ResParroquia.findByPrq2", query = "SELECT r FROM ResParroquia r WHERE r.prq2 = :prq2"),
    @NamedQuery(name = "ResParroquia.findByPrq3", query = "SELECT r FROM ResParroquia r WHERE r.prq3 = :prq3")})
public class ResParroquia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "PRQ_IID")
    private String prqIid;
    @Size(max = 250)
    @Column(name = "PRQ1")
    private String prq1;
    @Size(max = 250)
    @Column(name = "PRQ2")
    private String prq2;
    @Size(max = 250)
    @Column(name = "PRQ3")
    private String prq3;

    public ResParroquia() {
    }

    public ResParroquia(String prqIid) {
        this.prqIid = prqIid;
    }

    public String getPrqIid() {
        return prqIid;
    }

    public void setPrqIid(String prqIid) {
        this.prqIid = prqIid;
    }

    public String getPrq1() {
        return prq1;
    }

    public void setPrq1(String prq1) {
        this.prq1 = prq1;
    }

    public String getPrq2() {
        return prq2;
    }

    public void setPrq2(String prq2) {
        this.prq2 = prq2;
    }

    public String getPrq3() {
        return prq3;
    }

    public void setPrq3(String prq3) {
        this.prq3 = prq3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prqIid != null ? prqIid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResParroquia)) {
            return false;
        }
        ResParroquia other = (ResParroquia) object;
        if ((this.prqIid == null && other.prqIid != null) || (this.prqIid != null && !this.prqIid.equals(other.prqIid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ResParroquia[ prqIid=" + prqIid + " ]";
    }
    
}
