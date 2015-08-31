/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_TRIAGE_GLASSGOW")
@NamedQueries({
    @NamedQuery(name = "MetTriageGlassgow.findAll", query = "SELECT m FROM MetTriageGlassgow m")})
public class MetTriageGlassgow implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TGL_ID")
    private BigDecimal tglId;
    @Column(name = "TGL_MARCA")
    private Character tglMarca;
    @JoinColumn(name = "EGL_ID", referencedColumnName = "EGL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetEscalaGlassgow metEscalaGlassgow;
    @JoinColumn(name = "TRC_ID", referencedColumnName = "TRC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetTriageCab metTriageCab;

    public MetTriageGlassgow() {
    }

    public MetTriageGlassgow(BigDecimal tglId) {
        this.tglId = tglId;
    }

    public BigDecimal getTglId() {
        return tglId;
    }

    public void setTglId(BigDecimal tglId) {
        this.tglId = tglId;
    }

    public Character getTglMarca() {
        return tglMarca;
    }

    public void setTglMarca(Character tglMarca) {
        this.tglMarca = tglMarca;
    }

    public MetEscalaGlassgow getMetEscalaGlassgow() {
        return metEscalaGlassgow;
    }

    public void setMetEscalaGlassgow(MetEscalaGlassgow metEscalaGlassgow) {
        this.metEscalaGlassgow = metEscalaGlassgow;
    }

    public MetTriageCab getMetTriageCab() {
        return metTriageCab;
    }

    public void setMetTriageCab(MetTriageCab metTriageCab) {
        this.metTriageCab = metTriageCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tglId != null ? tglId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetTriageGlassgow)) {
            return false;
        }
        MetTriageGlassgow other = (MetTriageGlassgow) object;
        if ((this.tglId == null && other.tglId != null) || (this.tglId != null && !this.tglId.equals(other.tglId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetTriageGlassgow[ tglId=" + tglId + " ]";
    }
    
}
