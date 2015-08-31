/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.triage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "MET_MODIFICADOR")
@NamedQueries({
    @NamedQuery(name = "MetModificador.findAll", query = "SELECT m FROM MetModificador m")})
public class MetModificador implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MOD_ID")
    private BigDecimal modId;
    @Column(name = "MOD_DESCRIPCION")
    private String modDescripcion;
    @Column(name = "MOD_TIPO")
    private Character modTipo;
    @Column(name = "MOD_ESCALA_DOLOR")
    private Character modEscalaDolor;
    @Column(name = "MOD_ULTIMO_NIVEL")
    private Character modUltimoNivel;
    @Column(name = "MOD_VALOR_MIN")
    private BigInteger modValorMin;
    @Column(name = "MOD_OPERADOR")
    private String modOperador;
    @Column(name = "MOD_VALOR_MAX")
    private BigInteger modValorMax;
    @Column(name = "MOD_PRIORIDAD")
    private String modPrioridad;
    @Column(name = "MOD_OBSERVACION")
    private String modObservacion;
    @Column(name = "MOD_COLOR")
    private String modColor;
    @OneToMany(mappedBy = "metModificador", fetch = FetchType.LAZY)
    private List<MetModificador> metModificadorList;
    @JoinColumn(name = "MOD_ID_PADRE", referencedColumnName = "MOD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetModificador metModificador;
    @OneToMany(mappedBy = "metModificador", fetch = FetchType.LAZY)
    private List<MetTriageModificador> metTriageModificadorList;

    public MetModificador() {
    }

    public MetModificador(BigDecimal modId) {
        this.modId = modId;
    }

    public BigDecimal getModId() {
        return modId;
    }

    public void setModId(BigDecimal modId) {
        this.modId = modId;
    }

    public String getModDescripcion() {
        return modDescripcion;
    }

    public void setModDescripcion(String modDescripcion) {
        this.modDescripcion = modDescripcion;
    }

    public Character getModTipo() {
        return modTipo;
    }

    public void setModTipo(Character modTipo) {
        this.modTipo = modTipo;
    }

    public Character getModEscalaDolor() {
        return modEscalaDolor;
    }

    public void setModEscalaDolor(Character modEscalaDolor) {
        this.modEscalaDolor = modEscalaDolor;
    }

    public Character getModUltimoNivel() {
        return modUltimoNivel;
    }

    public void setModUltimoNivel(Character modUltimoNivel) {
        this.modUltimoNivel = modUltimoNivel;
    }

    public BigInteger getModValorMin() {
        return modValorMin;
    }

    public void setModValorMin(BigInteger modValorMin) {
        this.modValorMin = modValorMin;
    }

    public String getModOperador() {
        return modOperador;
    }

    public void setModOperador(String modOperador) {
        this.modOperador = modOperador;
    }

    public BigInteger getModValorMax() {
        return modValorMax;
    }

    public void setModValorMax(BigInteger modValorMax) {
        this.modValorMax = modValorMax;
    }

    public String getModPrioridad() {
        return modPrioridad;
    }

    public void setModPrioridad(String modPrioridad) {
        this.modPrioridad = modPrioridad;
    }

    public String getModObservacion() {
        return modObservacion;
    }

    public void setModObservacion(String modObservacion) {
        this.modObservacion = modObservacion;
    }

    public String getModColor() {
        return modColor;
    }

    public void setModColor(String modColor) {
        this.modColor = modColor;
    }

    public List<MetModificador> getMetModificadorList() {
        return metModificadorList;
    }

    public void setMetModificadorList(List<MetModificador> metModificadorList) {
        this.metModificadorList = metModificadorList;
    }

    public MetModificador getMetModificador() {
        return metModificador;
    }

    public void setMetModificador(MetModificador metModificador) {
        this.metModificador = metModificador;
    }

    public List<MetTriageModificador> getMetTriageModificadorList() {
        return metTriageModificadorList;
    }

    public void setMetTriageModificadorList(List<MetTriageModificador> metTriageModificadorList) {
        this.metTriageModificadorList = metTriageModificadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetModificador)) {
            return false;
        }
        MetModificador other = (MetModificador) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.triage.MetModificador[ modId=" + modId + " ]";
    }
    
}
