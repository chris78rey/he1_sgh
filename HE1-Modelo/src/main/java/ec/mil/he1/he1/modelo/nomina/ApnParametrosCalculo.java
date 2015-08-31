/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.nomina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "APN_PARAMETROS_CALCULO")
@NamedQueries({
    @NamedQuery(name = "ApnParametrosCalculo.findAll", query = "SELECT a FROM ApnParametrosCalculo a")})
public class ApnParametrosCalculo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PCA_ID")
    private BigDecimal pcaId;
    @Column(name = "PCA_DESCRIPCION")
    private String pcaDescripcion;
    @Column(name = "PCA_VALOR")
    private BigDecimal pcaValor;
    @Column(name = "PCA_NUM_CUOTAS")
    private BigInteger pcaNumCuotas;
    @Column(name = "PCA_VALOR_MIN")
    private BigDecimal pcaValorMin;
    @Column(name = "PCA_VALOR_MAX")
    private BigDecimal pcaValorMax;
    @Column(name = "PCA_MES")
    private BigInteger pcaMes;
    @Column(name = "PCA_SIGLAS")
    private String pcaSiglas;
    @Column(name = "PCA_ESTADO")
    private Character pcaEstado;

    public ApnParametrosCalculo() {
    }

    public ApnParametrosCalculo(BigDecimal pcaId) {
        this.pcaId = pcaId;
    }

    public BigDecimal getPcaId() {
        return pcaId;
    }

    public void setPcaId(BigDecimal pcaId) {
        this.pcaId = pcaId;
    }

    public String getPcaDescripcion() {
        return pcaDescripcion;
    }

    public void setPcaDescripcion(String pcaDescripcion) {
        this.pcaDescripcion = pcaDescripcion;
    }

    public BigDecimal getPcaValor() {
        return pcaValor;
    }

    public void setPcaValor(BigDecimal pcaValor) {
        this.pcaValor = pcaValor;
    }

    public BigInteger getPcaNumCuotas() {
        return pcaNumCuotas;
    }

    public void setPcaNumCuotas(BigInteger pcaNumCuotas) {
        this.pcaNumCuotas = pcaNumCuotas;
    }

    public BigDecimal getPcaValorMin() {
        return pcaValorMin;
    }

    public void setPcaValorMin(BigDecimal pcaValorMin) {
        this.pcaValorMin = pcaValorMin;
    }

    public BigDecimal getPcaValorMax() {
        return pcaValorMax;
    }

    public void setPcaValorMax(BigDecimal pcaValorMax) {
        this.pcaValorMax = pcaValorMax;
    }

    public BigInteger getPcaMes() {
        return pcaMes;
    }

    public void setPcaMes(BigInteger pcaMes) {
        this.pcaMes = pcaMes;
    }

    public String getPcaSiglas() {
        return pcaSiglas;
    }

    public void setPcaSiglas(String pcaSiglas) {
        this.pcaSiglas = pcaSiglas;
    }

    public Character getPcaEstado() {
        return pcaEstado;
    }

    public void setPcaEstado(Character pcaEstado) {
        this.pcaEstado = pcaEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcaId != null ? pcaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApnParametrosCalculo)) {
            return false;
        }
        ApnParametrosCalculo other = (ApnParametrosCalculo) object;
        if ((this.pcaId == null && other.pcaId != null) || (this.pcaId != null && !this.pcaId.equals(other.pcaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.nomina.ApnParametrosCalculo[ pcaId=" + pcaId + " ]";
    }
    
}
