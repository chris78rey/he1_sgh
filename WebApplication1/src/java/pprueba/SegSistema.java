/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "SEG_SISTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegSistema.findAll", query = "SELECT s FROM SegSistema s"),
    @NamedQuery(name = "SegSistema.findBySisId", query = "SELECT s FROM SegSistema s WHERE s.sisId = :sisId"),
    @NamedQuery(name = "SegSistema.findBySisDescripcion", query = "SELECT s FROM SegSistema s WHERE s.sisDescripcion = :sisDescripcion"),
    @NamedQuery(name = "SegSistema.findBySisSiglas", query = "SELECT s FROM SegSistema s WHERE s.sisSiglas = :sisSiglas"),
    @NamedQuery(name = "SegSistema.findBySisOrdenPresentacion", query = "SELECT s FROM SegSistema s WHERE s.sisOrdenPresentacion = :sisOrdenPresentacion"),
    @NamedQuery(name = "SegSistema.findBySisEstado", query = "SELECT s FROM SegSistema s WHERE s.sisEstado = :sisEstado")})
public class SegSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIS_ID")
    private BigDecimal sisId;
    @Size(max = 100)
    @Column(name = "SIS_DESCRIPCION")
    private String sisDescripcion;
    @Size(max = 20)
    @Column(name = "SIS_SIGLAS")
    private String sisSiglas;
    @Column(name = "SIS_ORDEN_PRESENTACION")
    private BigInteger sisOrdenPresentacion;
    @Column(name = "SIS_ESTADO")
    private Character sisEstado;
    @JoinColumn(name = "GRU_ID", referencedColumnName = "GRU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegGrupoSistema segGrupoSistema;
    @OneToMany(mappedBy = "segSistema", fetch = FetchType.LAZY)
    private List<SegOpcionMenu> segOpcionMenuList;

    public SegSistema() {
    }

    public SegSistema(BigDecimal sisId) {
        this.sisId = sisId;
    }

    public BigDecimal getSisId() {
        return sisId;
    }

    public void setSisId(BigDecimal sisId) {
        this.sisId = sisId;
    }

    public String getSisDescripcion() {
        return sisDescripcion;
    }

    public void setSisDescripcion(String sisDescripcion) {
        this.sisDescripcion = sisDescripcion;
    }

    public String getSisSiglas() {
        return sisSiglas;
    }

    public void setSisSiglas(String sisSiglas) {
        this.sisSiglas = sisSiglas;
    }

    public BigInteger getSisOrdenPresentacion() {
        return sisOrdenPresentacion;
    }

    public void setSisOrdenPresentacion(BigInteger sisOrdenPresentacion) {
        this.sisOrdenPresentacion = sisOrdenPresentacion;
    }

    public Character getSisEstado() {
        return sisEstado;
    }

    public void setSisEstado(Character sisEstado) {
        this.sisEstado = sisEstado;
    }

    public SegGrupoSistema getSegGrupoSistema() {
        return segGrupoSistema;
    }

    public void setSegGrupoSistema(SegGrupoSistema segGrupoSistema) {
        this.segGrupoSistema = segGrupoSistema;
    }

    @XmlTransient
    public List<SegOpcionMenu> getSegOpcionMenuList() {
        return segOpcionMenuList;
    }

    public void setSegOpcionMenuList(List<SegOpcionMenu> segOpcionMenuList) {
        this.segOpcionMenuList = segOpcionMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisId != null ? sisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegSistema)) {
            return false;
        }
        SegSistema other = (SegSistema) object;
        if ((this.sisId == null && other.sisId != null) || (this.sisId != null && !this.sisId.equals(other.sisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.SegSistema[ sisId=" + sisId + " ]";
    }
    
}
