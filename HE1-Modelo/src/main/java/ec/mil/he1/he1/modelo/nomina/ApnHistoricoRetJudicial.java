/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_HISTORICO_RET_JUDICIAL")
@NamedQueries({
    @NamedQuery(name = "ApnHistoricoRetJudicial.findAll", query = "SELECT a FROM ApnHistoricoRetJudicial a")})
public class ApnHistoricoRetJudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "HRJ_ID")
    private BigDecimal hrjId;
    @Column(name = "HRJ_VALOR")
    private BigDecimal hrjValor;
    @Column(name = "HRJ_CUOTAS")
    private BigInteger hrjCuotas;
    @Column(name = "HRJ_DOCUMENTO")
    private String hrjDocumento;
    @Column(name = "HRJ_COD_BENEFICIARIO")
    private String hrjCodBeneficiario;
    @Column(name = "HRJ_NUM_CUENTA")
    private String hrjNumCuenta;
    @Column(name = "HRJ_MES")
    private BigInteger hrjMes;
    @Column(name = "HRJ_ANIO")
    private BigInteger hrjAnio;
    @Column(name = "TPR_ID")
    private BigInteger tprId;
    @Column(name = "HRJ_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hrjDesde;
    @Column(name = "HRJ_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hrjHasta;
    @Column(name = "HRJ_ESTADO")
    private String hrjEstado;
    @Column(name = "HRJ_MONTO")
    private BigDecimal hrjMonto;
    @Column(name = "HRJ_ACUMULADO")
    private BigDecimal hrjAcumulado;
    @JoinColumn(name = "BRJ_ID", referencedColumnName = "BRJ_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApnBeneficRetJudicial apnBeneficRetJudicial;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppEmpleado appEmpleado;

    public ApnHistoricoRetJudicial() {
    }

    public ApnHistoricoRetJudicial(BigDecimal hrjId) {
        this.hrjId = hrjId;
    }

    public BigDecimal getHrjId() {
        return hrjId;
    }

    public void setHrjId(BigDecimal hrjId) {
        this.hrjId = hrjId;
    }

    public BigDecimal getHrjValor() {
        return hrjValor;
    }

    public void setHrjValor(BigDecimal hrjValor) {
        this.hrjValor = hrjValor;
    }

    public BigInteger getHrjCuotas() {
        return hrjCuotas;
    }

    public void setHrjCuotas(BigInteger hrjCuotas) {
        this.hrjCuotas = hrjCuotas;
    }

    public String getHrjDocumento() {
        return hrjDocumento;
    }

    public void setHrjDocumento(String hrjDocumento) {
        this.hrjDocumento = hrjDocumento;
    }

    public String getHrjCodBeneficiario() {
        return hrjCodBeneficiario;
    }

    public void setHrjCodBeneficiario(String hrjCodBeneficiario) {
        this.hrjCodBeneficiario = hrjCodBeneficiario;
    }

    public String getHrjNumCuenta() {
        return hrjNumCuenta;
    }

    public void setHrjNumCuenta(String hrjNumCuenta) {
        this.hrjNumCuenta = hrjNumCuenta;
    }

    public BigInteger getHrjMes() {
        return hrjMes;
    }

    public void setHrjMes(BigInteger hrjMes) {
        this.hrjMes = hrjMes;
    }

    public BigInteger getHrjAnio() {
        return hrjAnio;
    }

    public void setHrjAnio(BigInteger hrjAnio) {
        this.hrjAnio = hrjAnio;
    }

    public BigInteger getTprId() {
        return tprId;
    }

    public void setTprId(BigInteger tprId) {
        this.tprId = tprId;
    }

    public Date getHrjDesde() {
        return hrjDesde;
    }

    public void setHrjDesde(Date hrjDesde) {
        this.hrjDesde = hrjDesde;
    }

    public Date getHrjHasta() {
        return hrjHasta;
    }

    public void setHrjHasta(Date hrjHasta) {
        this.hrjHasta = hrjHasta;
    }

    public String getHrjEstado() {
        return hrjEstado;
    }

    public void setHrjEstado(String hrjEstado) {
        this.hrjEstado = hrjEstado;
    }

    public BigDecimal getHrjMonto() {
        return hrjMonto;
    }

    public void setHrjMonto(BigDecimal hrjMonto) {
        this.hrjMonto = hrjMonto;
    }

    public BigDecimal getHrjAcumulado() {
        return hrjAcumulado;
    }

    public void setHrjAcumulado(BigDecimal hrjAcumulado) {
        this.hrjAcumulado = hrjAcumulado;
    }

    public ApnBeneficRetJudicial getApnBeneficRetJudicial() {
        return apnBeneficRetJudicial;
    }

    public void setApnBeneficRetJudicial(ApnBeneficRetJudicial apnBeneficRetJudicial) {
        this.apnBeneficRetJudicial = apnBeneficRetJudicial;
    }

    public AppEmpleado getAppEmpleado() {
        return appEmpleado;
    }

    public void setAppEmpleado(AppEmpleado appEmpleado) {
        this.appEmpleado = appEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hrjId != null ? hrjId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnHistoricoRetJudicial)) {
            return false;
        }
        ApnHistoricoRetJudicial other = (ApnHistoricoRetJudicial) object;
        if ((this.hrjId == null && other.hrjId != null) || (this.hrjId != null && !this.hrjId.equals(other.hrjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnHistoricoRetJudicial[ hrjId=" + hrjId + " ]";
    }
    
}
