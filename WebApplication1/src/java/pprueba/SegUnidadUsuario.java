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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "SEG_UNIDAD_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUnidadUsuario.findAll", query = "SELECT s FROM SegUnidadUsuario s"),
    @NamedQuery(name = "SegUnidadUsuario.findByUusId", query = "SELECT s FROM SegUnidadUsuario s WHERE s.uusId = :uusId"),
    @NamedQuery(name = "SegUnidadUsuario.findByUusEstado", query = "SELECT s FROM SegUnidadUsuario s WHERE s.uusEstado = :uusEstado")})
public class SegUnidadUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UUS_ID")
    private BigDecimal uusId;
    @Column(name = "UUS_ESTADO")
    private Character uusEstado;
    @JoinColumn(name = "UNS_ID", referencedColumnName = "UNS_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CggUnidadSalud cggUnidadSalud;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario segUsuario;

    public SegUnidadUsuario() {
    }

    public SegUnidadUsuario(BigDecimal uusId) {
        this.uusId = uusId;
    }

    public BigDecimal getUusId() {
        return uusId;
    }

    public void setUusId(BigDecimal uusId) {
        this.uusId = uusId;
    }

    public Character getUusEstado() {
        return uusEstado;
    }

    public void setUusEstado(Character uusEstado) {
        this.uusEstado = uusEstado;
    }

    public CggUnidadSalud getCggUnidadSalud() {
        return cggUnidadSalud;
    }

    public void setCggUnidadSalud(CggUnidadSalud cggUnidadSalud) {
        this.cggUnidadSalud = cggUnidadSalud;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uusId != null ? uusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUnidadUsuario)) {
            return false;
        }
        SegUnidadUsuario other = (SegUnidadUsuario) object;
        if ((this.uusId == null && other.uusId != null) || (this.uusId != null && !this.uusId.equals(other.uusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.SegUnidadUsuario[ uusId=" + uusId + " ]";
    }
    
}
