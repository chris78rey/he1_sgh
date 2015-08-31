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
@Table(name = "TEMPORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporal.findAll", query = "SELECT t FROM Temporal t"),
    @NamedQuery(name = "Temporal.findByC1", query = "SELECT t FROM Temporal t WHERE t.c1 = :c1"),
    @NamedQuery(name = "Temporal.findByN", query = "SELECT t FROM Temporal t WHERE t.n = :n"),
    @NamedQuery(name = "Temporal.findByP", query = "SELECT t FROM Temporal t WHERE t.p = :p"),
    @NamedQuery(name = "Temporal.findByC", query = "SELECT t FROM Temporal t WHERE t.c = :c"),
    @NamedQuery(name = "Temporal.findByPa", query = "SELECT t FROM Temporal t WHERE t.pa = :pa")})
public class Temporal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "C1")
    private BigDecimal c1;
    @Size(max = 500)
    @Column(name = "N")
    private String n;
    @Size(max = 500)
    @Column(name = "P")
    private String p;
    @Size(max = 500)
    @Column(name = "C")
    private String c;
    @Size(max = 500)
    @Column(name = "PA")
    private String pa;

    public Temporal() {
    }

    public Temporal(BigDecimal c1) {
        this.c1 = c1;
    }

    public BigDecimal getC1() {
        return c1;
    }

    public void setC1(BigDecimal c1) {
        this.c1 = c1;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (c1 != null ? c1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporal)) {
            return false;
        }
        Temporal other = (Temporal) object;
        if ((this.c1 == null && other.c1 != null) || (this.c1 != null && !this.c1.equals(other.c1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.Temporal[ c1=" + c1 + " ]";
    }
    
}
