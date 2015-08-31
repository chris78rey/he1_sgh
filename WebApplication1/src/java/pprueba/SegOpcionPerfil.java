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
@Table(name = "SEG_OPCION_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegOpcionPerfil.findAll", query = "SELECT s FROM SegOpcionPerfil s"),
    @NamedQuery(name = "SegOpcionPerfil.findByOppId", query = "SELECT s FROM SegOpcionPerfil s WHERE s.oppId = :oppId"),
    @NamedQuery(name = "SegOpcionPerfil.findByOppInsertar", query = "SELECT s FROM SegOpcionPerfil s WHERE s.oppInsertar = :oppInsertar"),
    @NamedQuery(name = "SegOpcionPerfil.findByOppEliminar", query = "SELECT s FROM SegOpcionPerfil s WHERE s.oppEliminar = :oppEliminar"),
    @NamedQuery(name = "SegOpcionPerfil.findByOppActualizar", query = "SELECT s FROM SegOpcionPerfil s WHERE s.oppActualizar = :oppActualizar"),
    @NamedQuery(name = "SegOpcionPerfil.findByOppConsultar", query = "SELECT s FROM SegOpcionPerfil s WHERE s.oppConsultar = :oppConsultar"),
    @NamedQuery(name = "SegOpcionPerfil.findByOppEstado", query = "SELECT s FROM SegOpcionPerfil s WHERE s.oppEstado = :oppEstado")})
public class SegOpcionPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_ID")
    private BigDecimal oppId;
    @Column(name = "OPP_INSERTAR")
    private Character oppInsertar;
    @Column(name = "OPP_ELIMINAR")
    private Character oppEliminar;
    @Column(name = "OPP_ACTUALIZAR")
    private Character oppActualizar;
    @Column(name = "OPP_CONSULTAR")
    private Character oppConsultar;
    @Column(name = "OPP_ESTADO")
    private Character oppEstado;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegOpcionMenu segOpcionMenu;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegPerfil segPerfil;

    public SegOpcionPerfil() {
    }

    public SegOpcionPerfil(BigDecimal oppId) {
        this.oppId = oppId;
    }

    public BigDecimal getOppId() {
        return oppId;
    }

    public void setOppId(BigDecimal oppId) {
        this.oppId = oppId;
    }

    public Character getOppInsertar() {
        return oppInsertar;
    }

    public void setOppInsertar(Character oppInsertar) {
        this.oppInsertar = oppInsertar;
    }

    public Character getOppEliminar() {
        return oppEliminar;
    }

    public void setOppEliminar(Character oppEliminar) {
        this.oppEliminar = oppEliminar;
    }

    public Character getOppActualizar() {
        return oppActualizar;
    }

    public void setOppActualizar(Character oppActualizar) {
        this.oppActualizar = oppActualizar;
    }

    public Character getOppConsultar() {
        return oppConsultar;
    }

    public void setOppConsultar(Character oppConsultar) {
        this.oppConsultar = oppConsultar;
    }

    public Character getOppEstado() {
        return oppEstado;
    }

    public void setOppEstado(Character oppEstado) {
        this.oppEstado = oppEstado;
    }

    public SegOpcionMenu getSegOpcionMenu() {
        return segOpcionMenu;
    }

    public void setSegOpcionMenu(SegOpcionMenu segOpcionMenu) {
        this.segOpcionMenu = segOpcionMenu;
    }

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oppId != null ? oppId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegOpcionPerfil)) {
            return false;
        }
        SegOpcionPerfil other = (SegOpcionPerfil) object;
        if ((this.oppId == null && other.oppId != null) || (this.oppId != null && !this.oppId.equals(other.oppId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.SegOpcionPerfil[ oppId=" + oppId + " ]";
    }
    
}
