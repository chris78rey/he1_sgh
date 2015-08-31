/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "SEG_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s"),
    @NamedQuery(name = "SegUsuario.findByUsuId", query = "SELECT s FROM SegUsuario s WHERE s.usuId = :usuId"),
    @NamedQuery(name = "SegUsuario.findByPerId", query = "SELECT s FROM SegUsuario s WHERE s.perId = :perId"),
    @NamedQuery(name = "SegUsuario.findByUsuNombre", query = "SELECT s FROM SegUsuario s WHERE s.usuNombre = :usuNombre"),
    @NamedQuery(name = "SegUsuario.findByUsuClave", query = "SELECT s FROM SegUsuario s WHERE s.usuClave = :usuClave"),
    @NamedQuery(name = "SegUsuario.findByUsuFechaCreacion", query = "SELECT s FROM SegUsuario s WHERE s.usuFechaCreacion = :usuFechaCreacion"),
    @NamedQuery(name = "SegUsuario.findByUsuFechaModificacion", query = "SELECT s FROM SegUsuario s WHERE s.usuFechaModificacion = :usuFechaModificacion"),
    @NamedQuery(name = "SegUsuario.findByUsuEstado", query = "SELECT s FROM SegUsuario s WHERE s.usuEstado = :usuEstado")})
public class SegUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private BigDecimal usuId;
    @Column(name = "PER_ID")
    private BigInteger perId;
    @Size(max = 50)
    @Column(name = "USU_NOMBRE")
    private String usuNombre;
    @Size(max = 100)
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @Column(name = "USU_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechaCreacion;
    @Column(name = "USU_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechaModificacion;
    @Column(name = "USU_ESTADO")
    private Character usuEstado;
    @OneToMany(mappedBy = "segUsuario", fetch = FetchType.LAZY)
    private List<SegUnidadUsuario> segUnidadUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario", fetch = FetchType.LAZY)
    private List<SegPerfilUsuario> segPerfilUsuarioList;

    public SegUsuario() {
    }

    public SegUsuario(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public BigDecimal getUsuId() {
        return usuId;
    }

    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public BigInteger getPerId() {
        return perId;
    }

    public void setPerId(BigInteger perId) {
        this.perId = perId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Date getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    public Date getUsuFechaModificacion() {
        return usuFechaModificacion;
    }

    public void setUsuFechaModificacion(Date usuFechaModificacion) {
        this.usuFechaModificacion = usuFechaModificacion;
    }

    public Character getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Character usuEstado) {
        this.usuEstado = usuEstado;
    }

    @XmlTransient
    public List<SegUnidadUsuario> getSegUnidadUsuarioList() {
        return segUnidadUsuarioList;
    }

    public void setSegUnidadUsuarioList(List<SegUnidadUsuario> segUnidadUsuarioList) {
        this.segUnidadUsuarioList = segUnidadUsuarioList;
    }

    @XmlTransient
    public List<SegPerfilUsuario> getSegPerfilUsuarioList() {
        return segPerfilUsuarioList;
    }

    public void setSegPerfilUsuarioList(List<SegPerfilUsuario> segPerfilUsuarioList) {
        this.segPerfilUsuarioList = segPerfilUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.SegUsuario[ usuId=" + usuId + " ]";
    }
    
}
