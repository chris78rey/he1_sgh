/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pprueba;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "MET_SINTOMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetSintoma.findAll", query = "SELECT m FROM MetSintoma m"),
    @NamedQuery(name = "MetSintoma.findBySinId", query = "SELECT m FROM MetSintoma m WHERE m.sinId = :sinId"),
    @NamedQuery(name = "MetSintoma.findBySinDescripcion", query = "SELECT m FROM MetSintoma m WHERE m.sinDescripcion = :sinDescripcion"),
    @NamedQuery(name = "MetSintoma.findBySinPediatrico", query = "SELECT m FROM MetSintoma m WHERE m.sinPediatrico = :sinPediatrico"),
    @NamedQuery(name = "MetSintoma.findBySinAdulto", query = "SELECT m FROM MetSintoma m WHERE m.sinAdulto = :sinAdulto"),
    @NamedQuery(name = "MetSintoma.findBySinEstado", query = "SELECT m FROM MetSintoma m WHERE m.sinEstado = :sinEstado")})
public class MetSintoma implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIN_ID")
    private BigDecimal sinId;
    @Size(max = 100)
    @Column(name = "SIN_DESCRIPCION")
    private String sinDescripcion;
    @Column(name = "SIN_PEDIATRICO")
    private Character sinPediatrico;
    @Column(name = "SIN_ADULTO")
    private Character sinAdulto;
    @Column(name = "SIN_ESTADO")
    private Character sinEstado;
    @OneToMany(mappedBy = "metSintoma", fetch = FetchType.LAZY)
    private List<MetMotivoSintoma> metMotivoSintomaList;

    public MetSintoma() {
    }

    public MetSintoma(BigDecimal sinId) {
        this.sinId = sinId;
    }

    public BigDecimal getSinId() {
        return sinId;
    }

    public void setSinId(BigDecimal sinId) {
        this.sinId = sinId;
    }

    public String getSinDescripcion() {
        return sinDescripcion;
    }

    public void setSinDescripcion(String sinDescripcion) {
        this.sinDescripcion = sinDescripcion;
    }

    public Character getSinPediatrico() {
        return sinPediatrico;
    }

    public void setSinPediatrico(Character sinPediatrico) {
        this.sinPediatrico = sinPediatrico;
    }

    public Character getSinAdulto() {
        return sinAdulto;
    }

    public void setSinAdulto(Character sinAdulto) {
        this.sinAdulto = sinAdulto;
    }

    public Character getSinEstado() {
        return sinEstado;
    }

    public void setSinEstado(Character sinEstado) {
        this.sinEstado = sinEstado;
    }

    @XmlTransient
    public List<MetMotivoSintoma> getMetMotivoSintomaList() {
        return metMotivoSintomaList;
    }

    public void setMetMotivoSintomaList(List<MetMotivoSintoma> metMotivoSintomaList) {
        this.metMotivoSintomaList = metMotivoSintomaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sinId != null ? sinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetSintoma)) {
            return false;
        }
        MetSintoma other = (MetSintoma) object;
        if ((this.sinId == null && other.sinId != null) || (this.sinId != null && !this.sinId.equals(other.sinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.MetSintoma[ sinId=" + sinId + " ]";
    }
    
}
