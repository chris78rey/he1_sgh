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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_HISTORICO_RET_JUDICIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApnHistoricoRetJudicial.findAll", query = "SELECT a FROM ApnHistoricoRetJudicial a"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjId", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjId = :hrjId"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjValor", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjValor = :hrjValor"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjCuotas", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjCuotas = :hrjCuotas"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjDocumento", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjDocumento = :hrjDocumento"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjCodBeneficiario", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjCodBeneficiario = :hrjCodBeneficiario"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjNumCuenta", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjNumCuenta = :hrjNumCuenta"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjMes", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjMes = :hrjMes"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjAnio", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjAnio = :hrjAnio"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByTprId", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.tprId = :tprId"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjDesde", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjDesde = :hrjDesde"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjHasta", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjHasta = :hrjHasta"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjEstado", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjEstado = :hrjEstado"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjMonto", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjMonto = :hrjMonto"),
    @NamedQuery(name = "ApnHistoricoRetJudicial.findByHrjAcumulado", query = "SELECT a FROM ApnHistoricoRetJudicial a WHERE a.hrjAcumulado = :hrjAcumulado")})
public class ApnHistoricoRetJudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HRJ_ID")
    private BigDecimal hrjId;
    @Column(name = "HRJ_VALOR")
    private BigDecimal hrjValor;
    @Column(name = "HRJ_CUOTAS")
    private BigInteger hrjCuotas;
    @Size(max = 250)
    @Column(name = "HRJ_DOCUMENTO")
    private String hrjDocumento;
    @Size(max = 50)
    @Column(name = "HRJ_COD_BENEFICIARIO")
    private String hrjCodBeneficiario;
    @Size(max = 50)
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
    @Size(max = 10)
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
        return "pprueba.ApnHistoricoRetJudicial[ hrjId=" + hrjId + " ]";
    }
    
}
