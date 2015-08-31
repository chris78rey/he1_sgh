/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

import ec.mil.he1.he1.modelo.general.CggBanco;
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

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_BENEFIC_RET_JUDICIAL")
@NamedQueries({
    @NamedQuery(name = "ApnBeneficRetJudicial.findAll", query = "SELECT a FROM ApnBeneficRetJudicial a")})
public class ApnBeneficRetJudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "BRJ_ID")
    private BigDecimal brjId;
    @Column(name = "BRJ_APELLIDO")
    private String brjApellido;
    @Column(name = "BRJ_NOMBRE")
    private String brjNombre;
    @Column(name = "BRJ_NUM_CUENTA")
    private String brjNumCuenta;
    @Column(name = "BRJ_TIPO")
    private Character brjTipo;
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
        return "ec.mil.he1.he1.modelo.nomina.ApnBeneficRetJudicial[ brjId=" + brjId + " ]";
    }
    
}
