/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

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
@Table(name = "MET_ESCALA_GLASSGOW")
@NamedQueries({
    @NamedQuery(name = "MetEscalaGlassgow.findAll", query = "SELECT m FROM MetEscalaGlassgow m")})
public class MetEscalaGlassgow implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EGL_ID")
    private BigDecimal eglId;
    @Column(name = "EGL_DESCRIPCION")
    private String eglDescripcion;
    @Column(name = "EGL_TIPO")
    private Character eglTipo;
    @Column(name = "EGL_PUNTAJE")
    private BigInteger eglPuntaje;
    @Column(name = "EGL_ESTADO")
    private Character eglEstado;
    @OneToMany(mappedBy = "metEscalaGlassgow", fetch = FetchType.LAZY)
    private List<MetTriageGlassgow> metTriageGlassgowList;

    public MetEscalaGlassgow() {
    }

    public MetEscalaGlassgow(BigDecimal eglId) {
        this.eglId = eglId;
    }

    public BigDecimal getEglId() {
        return eglId;
    }

    public void setEglId(BigDecimal eglId) {
        this.eglId = eglId;
    }

    public String getEglDescripcion() {
        return eglDescripcion;
    }

    public void setEglDescripcion(String eglDescripcion) {
        this.eglDescripcion = eglDescripcion;
    }

    public Character getEglTipo() {
        return eglTipo;
    }

    public void setEglTipo(Character eglTipo) {
        this.eglTipo = eglTipo;
    }

    public BigInteger getEglPuntaje() {
        return eglPuntaje;
    }

    public void setEglPuntaje(BigInteger eglPuntaje) {
        this.eglPuntaje = eglPuntaje;
    }

    public Character getEglEstado() {
        return eglEstado;
    }

    public void setEglEstado(Character eglEstado) {
        this.eglEstado = eglEstado;
    }

    public List<MetTriageGlassgow> getMetTriageGlassgowList() {
        return metTriageGlassgowList;
    }

    public void setMetTriageGlassgowList(List<MetTriageGlassgow> metTriageGlassgowList) {
        this.metTriageGlassgowList = metTriageGlassgowList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eglId != null ? eglId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetEscalaGlassgow)) {
            return false;
        }
        MetEscalaGlassgow other = (MetEscalaGlassgow) object;
        if ((this.eglId == null && other.eglId != null) || (this.eglId != null && !this.eglId.equals(other.eglId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetEscalaGlassgow[ eglId=" + eglId + " ]";
    }
    
}
