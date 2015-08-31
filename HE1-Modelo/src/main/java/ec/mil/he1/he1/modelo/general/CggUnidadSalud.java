/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

import ec.mil.he1.he1.modelo.nomina.ApnOrganicoCab;
import ec.mil.he1.he1.modelo.nomina.AppEmpleado;
import ec.mil.he1.he1.modelo.seguridad.SegUnidadUsuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "CGG_UNIDAD_SALUD")
@NamedQueries({
    @NamedQuery(name = "CggUnidadSalud.findAll", query = "SELECT c FROM CggUnidadSalud c")})
public class CggUnidadSalud implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cggUnidadSalud", fetch = FetchType.LAZY)
    private List<SegUnidadUsuario> segUnidadUsuarioList;
    @OneToMany(mappedBy = "cggUnidadSalud", fetch = FetchType.LAZY)
    private List<ApnOrganicoCab> apnOrganicoCabList;
    @OneToMany(mappedBy = "cggUnidadSalud", fetch = FetchType.LAZY)
    private List<AppEmpleado> appEmpleadoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "UNS_ID")
    private BigDecimal unsId;
    @Column(name = "UNS_NIVEL")
    private String unsNivel;
    @Column(name = "UNS_COMPLEJIDAD")
    private BigInteger unsComplejidad;
    @Column(name = "UNS_NOMBRE")
    private String unsNombre;
    @Column(name = "UNS_SIGLAS")
    private String unsSiglas;
    @Column(name = "UNS_UNIDAD_DEPENDE")
    private String unsUnidadDepende;
    @Column(name = "UNS_DIRECCION")
    private String unsDireccion;
    @Column(name = "UNS_COORDENADAS")
    private String unsCoordenadas;
    @Column(name = "UNS_COORDENADAX")
    private String unsCoordenadax;
    @Column(name = "UNS_COORDENADAY")
    private String unsCoordenaday;
    @Column(name = "UNS_CORREO")
    private String unsCorreo;
    @Column(name = "UNS_MODE")
    private String unsMode;
    @Column(name = "UNS_TELEFONO")
    private String unsTelefono;
    @Column(name = "UNS_MSP_DISTRITO")
    private String unsMspDistrito;
    @Column(name = "UNS_MSP_TIPO")
    private String unsMspTipo;
    @Column(name = "UNS_REGION")
    private Character unsRegion;
    @Column(name = "UNS_LOCALIZACION")
    private Character unsLocalizacion;
    @Column(name = "UNS_CALIFICA_ISSFA")
    private Character unsCalificaIssfa;
    @Column(name = "FUE_ID")
    private BigInteger fueId;
    @Column(name = "UNS_ESTADO")
    private Character unsEstado;
    @JoinColumn(name = "CAN_ID", referencedColumnName = "CAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggCanton cggCanton;
    @JoinColumn(name = "CCS_ID", referencedColumnName = "CCS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggCtroCoordSalud cggCtroCoordSalud;
    @JoinColumn(name = "PRQ_ID", referencedColumnName = "PRQ_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggParroquia cggParroquia;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggProvincia cggProvincia;
    @JoinColumn(name = "UNI_ID", referencedColumnName = "UNI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggUnidad cggUnidad;
    @JoinColumn(name = "ZMS_ID", referencedColumnName = "ZMS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggZonasMinSalud cggZonasMinSalud;

    public CggUnidadSalud() {
    }

    public CggUnidadSalud(BigDecimal unsId) {
        this.unsId = unsId;
    }

    public BigDecimal getUnsId() {
        return unsId;
    }

    public void setUnsId(BigDecimal unsId) {
        this.unsId = unsId;
    }

    public String getUnsNivel() {
        return unsNivel;
    }

    public void setUnsNivel(String unsNivel) {
        this.unsNivel = unsNivel;
    }

    public BigInteger getUnsComplejidad() {
        return unsComplejidad;
    }

    public void setUnsComplejidad(BigInteger unsComplejidad) {
        this.unsComplejidad = unsComplejidad;
    }

    public String getUnsNombre() {
        return unsNombre;
    }

    public void setUnsNombre(String unsNombre) {
        this.unsNombre = unsNombre;
    }

    public String getUnsSiglas() {
        return unsSiglas;
    }

    public void setUnsSiglas(String unsSiglas) {
        this.unsSiglas = unsSiglas;
    }

    public String getUnsUnidadDepende() {
        return unsUnidadDepende;
    }

    public void setUnsUnidadDepende(String unsUnidadDepende) {
        this.unsUnidadDepende = unsUnidadDepende;
    }

    public String getUnsDireccion() {
        return unsDireccion;
    }

    public void setUnsDireccion(String unsDireccion) {
        this.unsDireccion = unsDireccion;
    }

    public String getUnsCoordenadas() {
        return unsCoordenadas;
    }

    public void setUnsCoordenadas(String unsCoordenadas) {
        this.unsCoordenadas = unsCoordenadas;
    }

    public String getUnsCoordenadax() {
        return unsCoordenadax;
    }

    public void setUnsCoordenadax(String unsCoordenadax) {
        this.unsCoordenadax = unsCoordenadax;
    }

    public String getUnsCoordenaday() {
        return unsCoordenaday;
    }

    public void setUnsCoordenaday(String unsCoordenaday) {
        this.unsCoordenaday = unsCoordenaday;
    }

    public String getUnsCorreo() {
        return unsCorreo;
    }

    public void setUnsCorreo(String unsCorreo) {
        this.unsCorreo = unsCorreo;
    }

    public String getUnsMode() {
        return unsMode;
    }

    public void setUnsMode(String unsMode) {
        this.unsMode = unsMode;
    }

    public String getUnsTelefono() {
        return unsTelefono;
    }

    public void setUnsTelefono(String unsTelefono) {
        this.unsTelefono = unsTelefono;
    }

    public String getUnsMspDistrito() {
        return unsMspDistrito;
    }

    public void setUnsMspDistrito(String unsMspDistrito) {
        this.unsMspDistrito = unsMspDistrito;
    }

    public String getUnsMspTipo() {
        return unsMspTipo;
    }

    public void setUnsMspTipo(String unsMspTipo) {
        this.unsMspTipo = unsMspTipo;
    }

    public Character getUnsRegion() {
        return unsRegion;
    }

    public void setUnsRegion(Character unsRegion) {
        this.unsRegion = unsRegion;
    }

    public Character getUnsLocalizacion() {
        return unsLocalizacion;
    }

    public void setUnsLocalizacion(Character unsLocalizacion) {
        this.unsLocalizacion = unsLocalizacion;
    }

    public Character getUnsCalificaIssfa() {
        return unsCalificaIssfa;
    }

    public void setUnsCalificaIssfa(Character unsCalificaIssfa) {
        this.unsCalificaIssfa = unsCalificaIssfa;
    }

    public BigInteger getFueId() {
        return fueId;
    }

    public void setFueId(BigInteger fueId) {
        this.fueId = fueId;
    }

    public Character getUnsEstado() {
        return unsEstado;
    }

    public void setUnsEstado(Character unsEstado) {
        this.unsEstado = unsEstado;
    }

    public CggCanton getCggCanton() {
        return cggCanton;
    }

    public void setCggCanton(CggCanton cggCanton) {
        this.cggCanton = cggCanton;
    }

    public CggCtroCoordSalud getCggCtroCoordSalud() {
        return cggCtroCoordSalud;
    }

    public void setCggCtroCoordSalud(CggCtroCoordSalud cggCtroCoordSalud) {
        this.cggCtroCoordSalud = cggCtroCoordSalud;
    }

    public CggParroquia getCggParroquia() {
        return cggParroquia;
    }

    public void setCggParroquia(CggParroquia cggParroquia) {
        this.cggParroquia = cggParroquia;
    }

    public CggProvincia getCggProvincia() {
        return cggProvincia;
    }

    public void setCggProvincia(CggProvincia cggProvincia) {
        this.cggProvincia = cggProvincia;
    }

    public CggUnidad getCggUnidad() {
        return cggUnidad;
    }

    public void setCggUnidad(CggUnidad cggUnidad) {
        this.cggUnidad = cggUnidad;
    }

    public CggZonasMinSalud getCggZonasMinSalud() {
        return cggZonasMinSalud;
    }

    public void setCggZonasMinSalud(CggZonasMinSalud cggZonasMinSalud) {
        this.cggZonasMinSalud = cggZonasMinSalud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unsId != null ? unsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggUnidadSalud)) {
            return false;
        }
        CggUnidadSalud other = (CggUnidadSalud) object;
        if ((this.unsId == null && other.unsId != null) || (this.unsId != null && !this.unsId.equals(other.unsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggUnidadSalud[ unsId=" + unsId + " ]";
    }

    public List<ApnOrganicoCab> getApnOrganicoCabList() {
        return apnOrganicoCabList;
    }

    public void setApnOrganicoCabList(List<ApnOrganicoCab> apnOrganicoCabList) {
        this.apnOrganicoCabList = apnOrganicoCabList;
    }

    public List<AppEmpleado> getAppEmpleadoList() {
        return appEmpleadoList;
    }

    public void setAppEmpleadoList(List<AppEmpleado> appEmpleadoList) {
        this.appEmpleadoList = appEmpleadoList;
    }

    public List<SegUnidadUsuario> getSegUnidadUsuarioList() {
        return segUnidadUsuarioList;
    }

    public void setSegUnidadUsuarioList(List<SegUnidadUsuario> segUnidadUsuarioList) {
        this.segUnidadUsuarioList = segUnidadUsuarioList;
    }
    
}
