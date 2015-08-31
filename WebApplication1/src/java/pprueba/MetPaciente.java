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
@Table(name = "MET_PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetPaciente.findAll", query = "SELECT m FROM MetPaciente m"),
    @NamedQuery(name = "MetPaciente.findByPacId", query = "SELECT m FROM MetPaciente m WHERE m.pacId = :pacId"),
    @NamedQuery(name = "MetPaciente.findByPacHc", query = "SELECT m FROM MetPaciente m WHERE m.pacHc = :pacHc"),
    @NamedQuery(name = "MetPaciente.findByPacFechaRegistro", query = "SELECT m FROM MetPaciente m WHERE m.pacFechaRegistro = :pacFechaRegistro"),
    @NamedQuery(name = "MetPaciente.findByPacVivo", query = "SELECT m FROM MetPaciente m WHERE m.pacVivo = :pacVivo"),
    @NamedQuery(name = "MetPaciente.findByPacFechaDefuncion", query = "SELECT m FROM MetPaciente m WHERE m.pacFechaDefuncion = :pacFechaDefuncion"),
    @NamedQuery(name = "MetPaciente.findByPacAsegurado", query = "SELECT m FROM MetPaciente m WHERE m.pacAsegurado = :pacAsegurado"),
    @NamedQuery(name = "MetPaciente.findByPacDerecho", query = "SELECT m FROM MetPaciente m WHERE m.pacDerecho = :pacDerecho"),
    @NamedQuery(name = "MetPaciente.findByPacTipoPaciente", query = "SELECT m FROM MetPaciente m WHERE m.pacTipoPaciente = :pacTipoPaciente"),
    @NamedQuery(name = "MetPaciente.findByPacBloqueado", query = "SELECT m FROM MetPaciente m WHERE m.pacBloqueado = :pacBloqueado"),
    @NamedQuery(name = "MetPaciente.findByPacEstado", query = "SELECT m FROM MetPaciente m WHERE m.pacEstado = :pacEstado"),
    @NamedQuery(name = "MetPaciente.findByPacCarneIess", query = "SELECT m FROM MetPaciente m WHERE m.pacCarneIess = :pacCarneIess"),
    @NamedQuery(name = "MetPaciente.findByPacFechaAfiliacionIess", query = "SELECT m FROM MetPaciente m WHERE m.pacFechaAfiliacionIess = :pacFechaAfiliacionIess"),
    @NamedQuery(name = "MetPaciente.findByPacAlerta", query = "SELECT m FROM MetPaciente m WHERE m.pacAlerta = :pacAlerta"),
    @NamedQuery(name = "MetPaciente.findByPacCarneConadis", query = "SELECT m FROM MetPaciente m WHERE m.pacCarneConadis = :pacCarneConadis"),
    @NamedQuery(name = "MetPaciente.findByPacFechaConadis", query = "SELECT m FROM MetPaciente m WHERE m.pacFechaConadis = :pacFechaConadis"),
    @NamedQuery(name = "MetPaciente.findByPacCarneIssfaTitular", query = "SELECT m FROM MetPaciente m WHERE m.pacCarneIssfaTitular = :pacCarneIssfaTitular"),
    @NamedQuery(name = "MetPaciente.findByPacCarneIssfa", query = "SELECT m FROM MetPaciente m WHERE m.pacCarneIssfa = :pacCarneIssfa")})
public class MetPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAC_ID")
    private BigDecimal pacId;
    @Size(max = 15)
    @Column(name = "PAC_HC")
    private String pacHc;
    @Column(name = "PAC_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacFechaRegistro;
    @Column(name = "PAC_VIVO")
    private Character pacVivo;
    @Column(name = "PAC_FECHA_DEFUNCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacFechaDefuncion;
    @Column(name = "PAC_ASEGURADO")
    private Character pacAsegurado;
    @Column(name = "PAC_DERECHO")
    private Character pacDerecho;
    @Column(name = "PAC_TIPO_PACIENTE")
    private Character pacTipoPaciente;
    @Column(name = "PAC_BLOQUEADO")
    private Character pacBloqueado;
    @Column(name = "PAC_ESTADO")
    private Character pacEstado;
    @Size(max = 20)
    @Column(name = "PAC_CARNE_IESS")
    private String pacCarneIess;
    @Column(name = "PAC_FECHA_AFILIACION_IESS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacFechaAfiliacionIess;
    @Size(max = 1000)
    @Column(name = "PAC_ALERTA")
    private String pacAlerta;
    @Size(max = 20)
    @Column(name = "PAC_CARNE_CONADIS")
    private String pacCarneConadis;
    @Column(name = "PAC_FECHA_CONADIS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacFechaConadis;
    @Size(max = 20)
    @Column(name = "PAC_CARNE_ISSFA_TITULAR")
    private String pacCarneIssfaTitular;
    @Size(max = 20)
    @Column(name = "PAC_CARNE_ISSFA")
    private String pacCarneIssfa;
    @OneToMany(mappedBy = "metPaciente", fetch = FetchType.LAZY)
    private List<MetTurno> metTurnoList;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggPersona cggPersona;
    @JoinColumn(name = "SIT_ID", referencedColumnName = "SIT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggSituacionPaciente cggSituacionPaciente;

    public MetPaciente() {
    }

    public MetPaciente(BigDecimal pacId) {
        this.pacId = pacId;
    }

    public BigDecimal getPacId() {
        return pacId;
    }

    public void setPacId(BigDecimal pacId) {
        this.pacId = pacId;
    }

    public String getPacHc() {
        return pacHc;
    }

    public void setPacHc(String pacHc) {
        this.pacHc = pacHc;
    }

    public Date getPacFechaRegistro() {
        return pacFechaRegistro;
    }

    public void setPacFechaRegistro(Date pacFechaRegistro) {
        this.pacFechaRegistro = pacFechaRegistro;
    }

    public Character getPacVivo() {
        return pacVivo;
    }

    public void setPacVivo(Character pacVivo) {
        this.pacVivo = pacVivo;
    }

    public Date getPacFechaDefuncion() {
        return pacFechaDefuncion;
    }

    public void setPacFechaDefuncion(Date pacFechaDefuncion) {
        this.pacFechaDefuncion = pacFechaDefuncion;
    }

    public Character getPacAsegurado() {
        return pacAsegurado;
    }

    public void setPacAsegurado(Character pacAsegurado) {
        this.pacAsegurado = pacAsegurado;
    }

    public Character getPacDerecho() {
        return pacDerecho;
    }

    public void setPacDerecho(Character pacDerecho) {
        this.pacDerecho = pacDerecho;
    }

    public Character getPacTipoPaciente() {
        return pacTipoPaciente;
    }

    public void setPacTipoPaciente(Character pacTipoPaciente) {
        this.pacTipoPaciente = pacTipoPaciente;
    }

    public Character getPacBloqueado() {
        return pacBloqueado;
    }

    public void setPacBloqueado(Character pacBloqueado) {
        this.pacBloqueado = pacBloqueado;
    }

    public Character getPacEstado() {
        return pacEstado;
    }

    public void setPacEstado(Character pacEstado) {
        this.pacEstado = pacEstado;
    }

    public String getPacCarneIess() {
        return pacCarneIess;
    }

    public void setPacCarneIess(String pacCarneIess) {
        this.pacCarneIess = pacCarneIess;
    }

    public Date getPacFechaAfiliacionIess() {
        return pacFechaAfiliacionIess;
    }

    public void setPacFechaAfiliacionIess(Date pacFechaAfiliacionIess) {
        this.pacFechaAfiliacionIess = pacFechaAfiliacionIess;
    }

    public String getPacAlerta() {
        return pacAlerta;
    }

    public void setPacAlerta(String pacAlerta) {
        this.pacAlerta = pacAlerta;
    }

    public String getPacCarneConadis() {
        return pacCarneConadis;
    }

    public void setPacCarneConadis(String pacCarneConadis) {
        this.pacCarneConadis = pacCarneConadis;
    }

    public Date getPacFechaConadis() {
        return pacFechaConadis;
    }

    public void setPacFechaConadis(Date pacFechaConadis) {
        this.pacFechaConadis = pacFechaConadis;
    }

    public String getPacCarneIssfaTitular() {
        return pacCarneIssfaTitular;
    }

    public void setPacCarneIssfaTitular(String pacCarneIssfaTitular) {
        this.pacCarneIssfaTitular = pacCarneIssfaTitular;
    }

    public String getPacCarneIssfa() {
        return pacCarneIssfa;
    }

    public void setPacCarneIssfa(String pacCarneIssfa) {
        this.pacCarneIssfa = pacCarneIssfa;
    }

    @XmlTransient
    public List<MetTurno> getMetTurnoList() {
        return metTurnoList;
    }

    public void setMetTurnoList(List<MetTurno> metTurnoList) {
        this.metTurnoList = metTurnoList;
    }

    public CggPersona getCggPersona() {
        return cggPersona;
    }

    public void setCggPersona(CggPersona cggPersona) {
        this.cggPersona = cggPersona;
    }

    public CggSituacionPaciente getCggSituacionPaciente() {
        return cggSituacionPaciente;
    }

    public void setCggSituacionPaciente(CggSituacionPaciente cggSituacionPaciente) {
        this.cggSituacionPaciente = cggSituacionPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacId != null ? pacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetPaciente)) {
            return false;
        }
        MetPaciente other = (MetPaciente) object;
        if ((this.pacId == null && other.pacId != null) || (this.pacId != null && !this.pacId.equals(other.pacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.MetPaciente[ pacId=" + pacId + " ]";
    }
    
}
