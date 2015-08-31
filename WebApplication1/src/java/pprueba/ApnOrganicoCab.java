/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_ORGANICO_CAB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnOrganicoCab.findAll", query = "SELECT a FROM ApnOrganicoCab a"),
    @NamedQuery(name = "ApnOrganicoCab.findByOcaId", query = "SELECT a FROM ApnOrganicoCab a WHERE a.ocaId = :ocaId"),
    @NamedQuery(name = "ApnOrganicoCab.findByOcaDescripcion", query = "SELECT a FROM ApnOrganicoCab a WHERE a.ocaDescripcion = :ocaDescripcion"),
    @NamedQuery(name = "ApnOrganicoCab.findByOcaDesde", query = "SELECT a FROM ApnOrganicoCab a WHERE a.ocaDesde = :ocaDesde"),
    @NamedQuery(name = "ApnOrganicoCab.findByOcaHasta", query = "SELECT a FROM ApnOrganicoCab a WHERE a.ocaHasta = :ocaHasta"),
    @NamedQuery(name = "ApnOrganicoCab.findByOcaEstado", query = "SELECT a FROM ApnOrganicoCab a WHERE a.ocaEstado = :ocaEstado")})
public class ApnOrganicoCab implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OCA_ID")
    private BigDecimal ocaId;
    @Size(max = 50)
    @Column(name = "OCA_DESCRIPCION")
    private String ocaDescripcion;
    @Column(name = "OCA_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ocaDesde;
    @Column(name = "OCA_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ocaHasta;
    @Column(name = "OCA_ESTADO")
    private Character ocaEstado;
    @JoinColumn(name = "UNS_ID", referencedColumnName = "UNS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggUnidadSalud cggUnidadSalud;
    @OneToMany(mappedBy = "apnOrganicoCab", fetch = FetchType.LAZY)
    private List<ApnOrganicoDet> apnOrganicoDetList;

    public ApnOrganicoCab() {
    }

    public ApnOrganicoCab(BigDecimal ocaId) {
        this.ocaId = ocaId;
    }

    public BigDecimal getOcaId() {
        return ocaId;
    }

    public void setOcaId(BigDecimal ocaId) {
        this.ocaId = ocaId;
    }

    public String getOcaDescripcion() {
        return ocaDescripcion;
    }

    public void setOcaDescripcion(String ocaDescripcion) {
        this.ocaDescripcion = ocaDescripcion;
    }

    public Date getOcaDesde() {
        return ocaDesde;
    }

    public void setOcaDesde(Date ocaDesde) {
        this.ocaDesde = ocaDesde;
    }

    public Date getOcaHasta() {
        return ocaHasta;
    }

    public void setOcaHasta(Date ocaHasta) {
        this.ocaHasta = ocaHasta;
    }

    public Character getOcaEstado() {
        return ocaEstado;
    }

    public void setOcaEstado(Character ocaEstado) {
        this.ocaEstado = ocaEstado;
    }

    public CggUnidadSalud getCggUnidadSalud() {
        return cggUnidadSalud;
    }

    public void setCggUnidadSalud(CggUnidadSalud cggUnidadSalud) {
        this.cggUnidadSalud = cggUnidadSalud;
    }

    @XmlTransient
    public List<ApnOrganicoDet> getApnOrganicoDetList() {
        return apnOrganicoDetList;
    }

    public void setApnOrganicoDetList(List<ApnOrganicoDet> apnOrganicoDetList) {
        this.apnOrganicoDetList = apnOrganicoDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ocaId != null ? ocaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnOrganicoCab)) {
            return false;
        }
        ApnOrganicoCab other = (ApnOrganicoCab) object;
        if ((this.ocaId == null && other.ocaId != null) || (this.ocaId != null && !this.ocaId.equals(other.ocaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnOrganicoCab[ ocaId=" + ocaId + " ]";
    }
    
}
