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
@Table(name = "APP_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppEmpleado.findAll", query = "SELECT a FROM AppEmpleado a"),
    @NamedQuery(name = "AppEmpleado.findByEmpId", query = "SELECT a FROM AppEmpleado a WHERE a.empId = :empId"),
    @NamedQuery(name = "AppEmpleado.findByEmpSueldo", query = "SELECT a FROM AppEmpleado a WHERE a.empSueldo = :empSueldo"),
    @NamedQuery(name = "AppEmpleado.findByEmpCuenta", query = "SELECT a FROM AppEmpleado a WHERE a.empCuenta = :empCuenta"),
    @NamedQuery(name = "AppEmpleado.findByEmpTipoCuenta", query = "SELECT a FROM AppEmpleado a WHERE a.empTipoCuenta = :empTipoCuenta"),
    @NamedQuery(name = "AppEmpleado.findByEmpEstado", query = "SELECT a FROM AppEmpleado a WHERE a.empEstado = :empEstado")})
public class AppEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_ID")
    private BigDecimal empId;
    @Column(name = "EMP_SUELDO")
    private BigDecimal empSueldo;
    @Size(max = 20)
    @Column(name = "EMP_CUENTA")
    private String empCuenta;
    @Column(name = "EMP_TIPO_CUENTA")
    private Character empTipoCuenta;
    @Column(name = "EMP_ESTADO")
    private Character empEstado;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnAcumuladoDecimo> apnAcumuladoDecimoList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnGastosPersonalCab> apnGastosPersonalCabList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnRetencionJudicial> apnRetencionJudicialList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnRol> apnRolList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnResumen> apnResumenList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnDescuentoEmpl> apnDescuentoEmplList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnEstadoEmpleado> apnEstadoEmpleadoList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnCargoEmpleado> apnCargoEmpleadoList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnHistoricoDescuento> apnHistoricoDescuentoList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnHistoricoRol> apnHistoricoRolList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnLicenciaEmpl> apnLicenciaEmplList;
    @JoinColumn(name = "NIV_ID", referencedColumnName = "NIV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnNivelServPub apnNivelServPub;
    @JoinColumn(name = "RLA_ID", referencedColumnName = "RLA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnRegimenLaboral apnRegimenLaboral;
    @JoinColumn(name = "RLL_ID", referencedColumnName = "RLL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnRelacionLaboral apnRelacionLaboral;
    @JoinColumn(name = "TEM_ID", referencedColumnName = "TEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnTipoEmpleado apnTipoEmpleado;
    @JoinColumn(name = "BAN_ID", referencedColumnName = "BAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggBanco cggBanco;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggPersona cggPersona;
    @JoinColumn(name = "UNS_ID", referencedColumnName = "UNS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggUnidadSalud cggUnidadSalud;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<ApnHistoricoRetJudicial> apnHistoricoRetJudicialList;
    @OneToMany(mappedBy = "appEmpleado", fetch = FetchType.LAZY)
    private List<MetTurnoEmpleado> metTurnoEmpleadoList;

    public AppEmpleado() {
    }

    public AppEmpleado(BigDecimal empId) {
        this.empId = empId;
    }

    public BigDecimal getEmpId() {
        return empId;
    }

    public void setEmpId(BigDecimal empId) {
        this.empId = empId;
    }

    public BigDecimal getEmpSueldo() {
        return empSueldo;
    }

    public void setEmpSueldo(BigDecimal empSueldo) {
        this.empSueldo = empSueldo;
    }

    public String getEmpCuenta() {
        return empCuenta;
    }

    public void setEmpCuenta(String empCuenta) {
        this.empCuenta = empCuenta;
    }

    public Character getEmpTipoCuenta() {
        return empTipoCuenta;
    }

    public void setEmpTipoCuenta(Character empTipoCuenta) {
        this.empTipoCuenta = empTipoCuenta;
    }

    public Character getEmpEstado() {
        return empEstado;
    }

    public void setEmpEstado(Character empEstado) {
        this.empEstado = empEstado;
    }

    @XmlTransient
    public List<ApnAcumuladoDecimo> getApnAcumuladoDecimoList() {
        return apnAcumuladoDecimoList;
    }

    public void setApnAcumuladoDecimoList(List<ApnAcumuladoDecimo> apnAcumuladoDecimoList) {
        this.apnAcumuladoDecimoList = apnAcumuladoDecimoList;
    }

    @XmlTransient
    public List<ApnGastosPersonalCab> getApnGastosPersonalCabList() {
        return apnGastosPersonalCabList;
    }

    public void setApnGastosPersonalCabList(List<ApnGastosPersonalCab> apnGastosPersonalCabList) {
        this.apnGastosPersonalCabList = apnGastosPersonalCabList;
    }

    @XmlTransient
    public List<ApnRetencionJudicial> getApnRetencionJudicialList() {
        return apnRetencionJudicialList;
    }

    public void setApnRetencionJudicialList(List<ApnRetencionJudicial> apnRetencionJudicialList) {
        this.apnRetencionJudicialList = apnRetencionJudicialList;
    }

    @XmlTransient
    public List<ApnRol> getApnRolList() {
        return apnRolList;
    }

    public void setApnRolList(List<ApnRol> apnRolList) {
        this.apnRolList = apnRolList;
    }

    @XmlTransient
    public List<ApnResumen> getApnResumenList() {
        return apnResumenList;
    }

    public void setApnResumenList(List<ApnResumen> apnResumenList) {
        this.apnResumenList = apnResumenList;
    }

    @XmlTransient
    public List<ApnDescuentoEmpl> getApnDescuentoEmplList() {
        return apnDescuentoEmplList;
    }

    public void setApnDescuentoEmplList(List<ApnDescuentoEmpl> apnDescuentoEmplList) {
        this.apnDescuentoEmplList = apnDescuentoEmplList;
    }

    @XmlTransient
    public List<ApnEstadoEmpleado> getApnEstadoEmpleadoList() {
        return apnEstadoEmpleadoList;
    }

    public void setApnEstadoEmpleadoList(List<ApnEstadoEmpleado> apnEstadoEmpleadoList) {
        this.apnEstadoEmpleadoList = apnEstadoEmpleadoList;
    }

    @XmlTransient
    public List<ApnCargoEmpleado> getApnCargoEmpleadoList() {
        return apnCargoEmpleadoList;
    }

    public void setApnCargoEmpleadoList(List<ApnCargoEmpleado> apnCargoEmpleadoList) {
        this.apnCargoEmpleadoList = apnCargoEmpleadoList;
    }

    @XmlTransient
    public List<ApnHistoricoDescuento> getApnHistoricoDescuentoList() {
        return apnHistoricoDescuentoList;
    }

    public void setApnHistoricoDescuentoList(List<ApnHistoricoDescuento> apnHistoricoDescuentoList) {
        this.apnHistoricoDescuentoList = apnHistoricoDescuentoList;
    }

    @XmlTransient
    public List<ApnHistoricoRol> getApnHistoricoRolList() {
        return apnHistoricoRolList;
    }

    public void setApnHistoricoRolList(List<ApnHistoricoRol> apnHistoricoRolList) {
        this.apnHistoricoRolList = apnHistoricoRolList;
    }

    @XmlTransient
    public List<ApnLicenciaEmpl> getApnLicenciaEmplList() {
        return apnLicenciaEmplList;
    }

    public void setApnLicenciaEmplList(List<ApnLicenciaEmpl> apnLicenciaEmplList) {
        this.apnLicenciaEmplList = apnLicenciaEmplList;
    }

    public ApnNivelServPub getApnNivelServPub() {
        return apnNivelServPub;
    }

    public void setApnNivelServPub(ApnNivelServPub apnNivelServPub) {
        this.apnNivelServPub = apnNivelServPub;
    }

    public ApnRegimenLaboral getApnRegimenLaboral() {
        return apnRegimenLaboral;
    }

    public void setApnRegimenLaboral(ApnRegimenLaboral apnRegimenLaboral) {
        this.apnRegimenLaboral = apnRegimenLaboral;
    }

    public ApnRelacionLaboral getApnRelacionLaboral() {
        return apnRelacionLaboral;
    }

    public void setApnRelacionLaboral(ApnRelacionLaboral apnRelacionLaboral) {
        this.apnRelacionLaboral = apnRelacionLaboral;
    }

    public ApnTipoEmpleado getApnTipoEmpleado() {
        return apnTipoEmpleado;
    }

    public void setApnTipoEmpleado(ApnTipoEmpleado apnTipoEmpleado) {
        this.apnTipoEmpleado = apnTipoEmpleado;
    }

    public CggBanco getCggBanco() {
        return cggBanco;
    }

    public void setCggBanco(CggBanco cggBanco) {
        this.cggBanco = cggBanco;
    }

    public CggPersona getCggPersona() {
        return cggPersona;
    }

    public void setCggPersona(CggPersona cggPersona) {
        this.cggPersona = cggPersona;
    }

    public CggUnidadSalud getCggUnidadSalud() {
        return cggUnidadSalud;
    }

    public void setCggUnidadSalud(CggUnidadSalud cggUnidadSalud) {
        this.cggUnidadSalud = cggUnidadSalud;
    }

    @XmlTransient
    public List<ApnHistoricoRetJudicial> getApnHistoricoRetJudicialList() {
        return apnHistoricoRetJudicialList;
    }

    public void setApnHistoricoRetJudicialList(List<ApnHistoricoRetJudicial> apnHistoricoRetJudicialList) {
        this.apnHistoricoRetJudicialList = apnHistoricoRetJudicialList;
    }

    @XmlTransient
    public List<MetTurnoEmpleado> getMetTurnoEmpleadoList() {
        return metTurnoEmpleadoList;
    }

    public void setMetTurnoEmpleadoList(List<MetTurnoEmpleado> metTurnoEmpleadoList) {
        this.metTurnoEmpleadoList = metTurnoEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppEmpleado)) {
            return false;
        }
        AppEmpleado other = (AppEmpleado) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.AppEmpleado[ empId=" + empId + " ]";
    }
    
}
