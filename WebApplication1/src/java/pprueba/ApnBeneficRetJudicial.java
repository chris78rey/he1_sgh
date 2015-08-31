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
@Table(name = "APN_BENEFIC_RET_JUDICIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnBeneficRetJudicial.findAll", query = "SELECT a FROM ApnBeneficRetJudicial a"),
    @NamedQuery(name = "ApnBeneficRetJudicial.findByBrjId", query = "SELECT a FROM ApnBeneficRetJudicial a WHERE a.brjId = :brjId"),
    @NamedQuery(name = "ApnBeneficRetJudicial.findByBrjApellido", query = "SELECT a FROM ApnBeneficRetJudicial a WHERE a.brjApellido = :brjApellido"),
    @NamedQuery(name = "ApnBeneficRetJudicial.findByBrjNombre", query = "SELECT a FROM ApnBeneficRetJudicial a WHERE a.brjNombre = :brjNombre"),
    @NamedQuery(name = "ApnBeneficRetJudicial.findByBrjNumCuenta", query = "SELECT a FROM ApnBeneficRetJudicial a WHERE a.brjNumCuenta = :brjNumCuenta"),
    @NamedQuery(name = "ApnBeneficRetJudicial.findByBrjTipo", query = "SELECT a FROM ApnBeneficRetJudicial a WHERE a.brjTipo = :brjTipo"),
    @NamedQuery(name = "ApnBeneficRetJudicial.findByBrjDni", query = "SELECT a FROM ApnBeneficRetJudicial a WHERE a.brjDni = :brjDni"),
    @NamedQuery(name = "ApnBeneficRetJudicial.findByBrjTipoDni", query = "SELECT a FROM ApnBeneficRetJudicial a WHERE a.brjTipoDni = :brjTipoDni"),
    @NamedQuery(name = "ApnBeneficRetJudicial.findByBrjEstado", query = "SELECT a FROM ApnBeneficRetJudicial a WHERE a.brjEstado = :brjEstado")})
public class ApnBeneficRetJudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BRJ_ID")
    private BigDecimal brjId;
    @Size(max = 100)
    @Column(name = "BRJ_APELLIDO")
    private String brjApellido;
    @Size(max = 100)
    @Column(name = "BRJ_NOMBRE")
    private String brjNombre;
    @Size(max = 50)
    @Column(name = "BRJ_NUM_CUENTA")
    private String brjNumCuenta;
    @Column(name = "BRJ_TIPO")
    private Character brjTipo;
    @Size(max = 20)
    @Column(name = "BRJ_DNI")
    private String brjDni;
    @Column(name = "BRJ_TIPO_DNI")
    private Character brjTipoDni;
    @Column(name = "BRJ_ESTADO")
    private Character brjEstado;
    @OneToMany(mappedBy = "apnBeneficRetJudicial", fetch = FetchType.LAZY)
    private List<ApnRetencionJudicial> apnRetencionJudicialList;
    @JoinColumn(name = "BAN_ID", referencedColumnName = "BAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggBanco cggBanco;
    @OneToMany(mappedBy = "apnBeneficRetJudicial", fetch = FetchType.LAZY)
    private List<ApnHistoricoRetJudicial> apnHistoricoRetJudicialList;

    public ApnBeneficRetJudicial() {
    }

    public ApnBeneficRetJudicial(BigDecimal brjId) {
        this.brjId = brjId;
    }

    public BigDecimal getBrjId() {
        return brjId;
    }

    public void setBrjId(BigDecimal brjId) {
        this.brjId = brjId;
    }

    public String getBrjApellido() {
        return brjApellido;
    }

    public void setBrjApellido(String brjApellido) {
        this.brjApellido = brjApellido;
    }

    public String getBrjNombre() {
        return brjNombre;
    }

    public void setBrjNombre(String brjNombre) {
        this.brjNombre = brjNombre;
    }

    public String getBrjNumCuenta() {
        return brjNumCuenta;
    }

    public void setBrjNumCuenta(String brjNumCuenta) {
        this.brjNumCuenta = brjNumCuenta;
    }

    public Character getBrjTipo() {
        return brjTipo;
    }

    public void setBrjTipo(Character brjTipo) {
        this.brjTipo = brjTipo;
    }

    public String getBrjDni() {
        return brjDni;
    }

    public void setBrjDni(String brjDni) {
        this.brjDni = brjDni;
    }

    public Character getBrjTipoDni() {
        return brjTipoDni;
    }

    public void setBrjTipoDni(Character brjTipoDni) {
        this.brjTipoDni = brjTipoDni;
    }

    public Character getBrjEstado() {
        return brjEstado;
    }

    public void setBrjEstado(Character brjEstado) {
        this.brjEstado = brjEstado;
    }

    @XmlTransient
    public List<ApnRetencionJudicial> getApnRetencionJudicialList() {
        return apnRetencionJudicialList;
    }

    public void setApnRetencionJudicialList(List<ApnRetencionJudicial> apnRetencionJudicialList) {
        this.apnRetencionJudicialList = apnRetencionJudicialList;
    }

    public CggBanco getCggBanco() {
        return cggBanco;
    }

    public void setCggBanco(CggBanco cggBanco) {
        this.cggBanco = cggBanco;
    }

    @XmlTransient
    public List<ApnHistoricoRetJudicial> getApnHistoricoRetJudicialList() {
        return apnHistoricoRetJudicialList;
    }

    public void setApnHistoricoRetJudicialList(List<ApnHistoricoRetJudicial> apnHistoricoRetJudicialList) {
        this.apnHistoricoRetJudicialList = apnHistoricoRetJudicialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brjId != null ? brjId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnBeneficRetJudicial)) {
            return false;
        }
        ApnBeneficRetJudicial other = (ApnBeneficRetJudicial) object;
        if ((this.brjId == null && other.brjId != null) || (this.brjId != null && !this.brjId.equals(other.brjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.ApnBeneficRetJudicial[ brjId=" + brjId + " ]";
    }
    
}
