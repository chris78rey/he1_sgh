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
@Table(name = "CGG_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CggPersona.findAll", query = "SELECT c FROM CggPersona c"),
    @NamedQuery(name = "CggPersona.findByPerId", query = "SELECT c FROM CggPersona c WHERE c.perId = :perId"),
    @NamedQuery(name = "CggPersona.findByPerNombre", query = "SELECT c FROM CggPersona c WHERE c.perNombre = :perNombre"),
    @NamedQuery(name = "CggPersona.findByPerApellido", query = "SELECT c FROM CggPersona c WHERE c.perApellido = :perApellido"),
    @NamedQuery(name = "CggPersona.findByPerFechaNacimiento", query = "SELECT c FROM CggPersona c WHERE c.perFechaNacimiento = :perFechaNacimiento"),
    @NamedQuery(name = "CggPersona.findByPerDni", query = "SELECT c FROM CggPersona c WHERE c.perDni = :perDni"),
    @NamedQuery(name = "CggPersona.findByPerTipoDni", query = "SELECT c FROM CggPersona c WHERE c.perTipoDni = :perTipoDni"),
    @NamedQuery(name = "CggPersona.findByPerSexo", query = "SELECT c FROM CggPersona c WHERE c.perSexo = :perSexo"),
    @NamedQuery(name = "CggPersona.findByPerEstadoCivil", query = "SELECT c FROM CggPersona c WHERE c.perEstadoCivil = :perEstadoCivil"),
    @NamedQuery(name = "CggPersona.findByPerDireccionDomicilio", query = "SELECT c FROM CggPersona c WHERE c.perDireccionDomicilio = :perDireccionDomicilio"),
    @NamedQuery(name = "CggPersona.findByPerTelefonoCasa", query = "SELECT c FROM CggPersona c WHERE c.perTelefonoCasa = :perTelefonoCasa"),
    @NamedQuery(name = "CggPersona.findByPerTelefonoTrabajo", query = "SELECT c FROM CggPersona c WHERE c.perTelefonoTrabajo = :perTelefonoTrabajo"),
    @NamedQuery(name = "CggPersona.findByPerTelefonoMovil1", query = "SELECT c FROM CggPersona c WHERE c.perTelefonoMovil1 = :perTelefonoMovil1"),
    @NamedQuery(name = "CggPersona.findByPerTelefonoMovil2", query = "SELECT c FROM CggPersona c WHERE c.perTelefonoMovil2 = :perTelefonoMovil2"),
    @NamedQuery(name = "CggPersona.findByPerEmailPersonal", query = "SELECT c FROM CggPersona c WHERE c.perEmailPersonal = :perEmailPersonal"),
    @NamedQuery(name = "CggPersona.findByPerEmailInstitucional", query = "SELECT c FROM CggPersona c WHERE c.perEmailInstitucional = :perEmailInstitucional"),
    @NamedQuery(name = "CggPersona.findByPerFechaRegistro", query = "SELECT c FROM CggPersona c WHERE c.perFechaRegistro = :perFechaRegistro"),
    @NamedQuery(name = "CggPersona.findByPerFechaMigracion", query = "SELECT c FROM CggPersona c WHERE c.perFechaMigracion = :perFechaMigracion"),
    @NamedQuery(name = "CggPersona.findByPerObservacion", query = "SELECT c FROM CggPersona c WHERE c.perObservacion = :perObservacion"),
    @NamedQuery(name = "CggPersona.findByPerCodigoPostal", query = "SELECT c FROM CggPersona c WHERE c.perCodigoPostal = :perCodigoPostal"),
    @NamedQuery(name = "CggPersona.findByPerSector", query = "SELECT c FROM CggPersona c WHERE c.perSector = :perSector"),
    @NamedQuery(name = "CggPersona.findByPerZona", query = "SELECT c FROM CggPersona c WHERE c.perZona = :perZona"),
    @NamedQuery(name = "CggPersona.findByPerDireccionTrabajo", query = "SELECT c FROM CggPersona c WHERE c.perDireccionTrabajo = :perDireccionTrabajo"),
    @NamedQuery(name = "CggPersona.findByPerVerificaDatos", query = "SELECT c FROM CggPersona c WHERE c.perVerificaDatos = :perVerificaDatos"),
    @NamedQuery(name = "CggPersona.findByPerAnioInstruccion", query = "SELECT c FROM CggPersona c WHERE c.perAnioInstruccion = :perAnioInstruccion"),
    @NamedQuery(name = "CggPersona.findByPerEstado", query = "SELECT c FROM CggPersona c WHERE c.perEstado = :perEstado"),
    @NamedQuery(name = "CggPersona.findByPerFechaActualizacion", query = "SELECT c FROM CggPersona c WHERE c.perFechaActualizacion = :perFechaActualizacion")})
public class CggPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private BigDecimal perId;
    @Size(max = 50)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Size(max = 50)
    @Column(name = "PER_APELLIDO")
    private String perApellido;
    @Column(name = "PER_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaNacimiento;
    @Size(max = 15)
    @Column(name = "PER_DNI")
    private String perDni;
    @Column(name = "PER_TIPO_DNI")
    private Character perTipoDni;
    @Column(name = "PER_SEXO")
    private Character perSexo;
    @Column(name = "PER_ESTADO_CIVIL")
    private Character perEstadoCivil;
    @Size(max = 500)
    @Column(name = "PER_DIRECCION_DOMICILIO")
    private String perDireccionDomicilio;
    @Size(max = 30)
    @Column(name = "PER_TELEFONO_CASA")
    private String perTelefonoCasa;
    @Size(max = 30)
    @Column(name = "PER_TELEFONO_TRABAJO")
    private String perTelefonoTrabajo;
    @Size(max = 30)
    @Column(name = "PER_TELEFONO_MOVIL1")
    private String perTelefonoMovil1;
    @Size(max = 30)
    @Column(name = "PER_TELEFONO_MOVIL2")
    private String perTelefonoMovil2;
    @Size(max = 30)
    @Column(name = "PER_EMAIL_PERSONAL")
    private String perEmailPersonal;
    @Size(max = 30)
    @Column(name = "PER_EMAIL_INSTITUCIONAL")
    private String perEmailInstitucional;
    @Column(name = "PER_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaRegistro;
    @Column(name = "PER_FECHA_MIGRACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaMigracion;
    @Size(max = 1000)
    @Column(name = "PER_OBSERVACION")
    private String perObservacion;
    @Size(max = 30)
    @Column(name = "PER_CODIGO_POSTAL")
    private String perCodigoPostal;
    @Size(max = 30)
    @Column(name = "PER_SECTOR")
    private String perSector;
    @Column(name = "PER_ZONA")
    private Character perZona;
    @Size(max = 500)
    @Column(name = "PER_DIRECCION_TRABAJO")
    private String perDireccionTrabajo;
    @Column(name = "PER_VERIFICA_DATOS")
    private Character perVerificaDatos;
    @Column(name = "PER_ANIO_INSTRUCCION")
    private BigInteger perAnioInstruccion;
    @Column(name = "PER_ESTADO")
    private Character perEstado;
    @Column(name = "PER_FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaActualizacion;
    @JoinColumn(name = "GRU_ID", referencedColumnName = "GRU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggGrupoCultural cggGrupoCultural;
    @JoinColumn(name = "GRS_ID", referencedColumnName = "GRS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggGrupoSanguineo cggGrupoSanguineo;
    @JoinColumn(name = "NED_ID", referencedColumnName = "NED_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggNivelEducacion cggNivelEducacion;
    @JoinColumn(name = "OCU_ID", referencedColumnName = "OCU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggOcupacion cggOcupacion;
    @JoinColumn(name = "PAI_ID", referencedColumnName = "PAI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggPais cggPais;
    @JoinColumn(name = "PRQ_ID_NAC", referencedColumnName = "PRQ_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggParroquia cggParroquia;
    @JoinColumn(name = "PRQ_ID", referencedColumnName = "PRQ_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggParroquia cggParroquia1;
    @JoinColumn(name = "REL_ID", referencedColumnName = "REL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CggReligion cggReligion;
    @OneToMany(mappedBy = "cggPersona", fetch = FetchType.LAZY)
    private List<MetPaciente> metPacienteList;
    @OneToMany(mappedBy = "cggPersona", fetch = FetchType.LAZY)
    private List<AppEmpleado> appEmpleadoList;

    public CggPersona() {
    }

    public CggPersona(BigDecimal perId) {
        this.perId = perId;
    }

    public BigDecimal getPerId() {
        return perId;
    }

    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerDni() {
        return perDni;
    }

    public void setPerDni(String perDni) {
        this.perDni = perDni;
    }

    public Character getPerTipoDni() {
        return perTipoDni;
    }

    public void setPerTipoDni(Character perTipoDni) {
        this.perTipoDni = perTipoDni;
    }

    public Character getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(Character perSexo) {
        this.perSexo = perSexo;
    }

    public Character getPerEstadoCivil() {
        return perEstadoCivil;
    }

    public void setPerEstadoCivil(Character perEstadoCivil) {
        this.perEstadoCivil = perEstadoCivil;
    }

    public String getPerDireccionDomicilio() {
        return perDireccionDomicilio;
    }

    public void setPerDireccionDomicilio(String perDireccionDomicilio) {
        this.perDireccionDomicilio = perDireccionDomicilio;
    }

    public String getPerTelefonoCasa() {
        return perTelefonoCasa;
    }

    public void setPerTelefonoCasa(String perTelefonoCasa) {
        this.perTelefonoCasa = perTelefonoCasa;
    }

    public String getPerTelefonoTrabajo() {
        return perTelefonoTrabajo;
    }

    public void setPerTelefonoTrabajo(String perTelefonoTrabajo) {
        this.perTelefonoTrabajo = perTelefonoTrabajo;
    }

    public String getPerTelefonoMovil1() {
        return perTelefonoMovil1;
    }

    public void setPerTelefonoMovil1(String perTelefonoMovil1) {
        this.perTelefonoMovil1 = perTelefonoMovil1;
    }

    public String getPerTelefonoMovil2() {
        return perTelefonoMovil2;
    }

    public void setPerTelefonoMovil2(String perTelefonoMovil2) {
        this.perTelefonoMovil2 = perTelefonoMovil2;
    }

    public String getPerEmailPersonal() {
        return perEmailPersonal;
    }

    public void setPerEmailPersonal(String perEmailPersonal) {
        this.perEmailPersonal = perEmailPersonal;
    }

    public String getPerEmailInstitucional() {
        return perEmailInstitucional;
    }

    public void setPerEmailInstitucional(String perEmailInstitucional) {
        this.perEmailInstitucional = perEmailInstitucional;
    }

    public Date getPerFechaRegistro() {
        return perFechaRegistro;
    }

    public void setPerFechaRegistro(Date perFechaRegistro) {
        this.perFechaRegistro = perFechaRegistro;
    }

    public Date getPerFechaMigracion() {
        return perFechaMigracion;
    }

    public void setPerFechaMigracion(Date perFechaMigracion) {
        this.perFechaMigracion = perFechaMigracion;
    }

    public String getPerObservacion() {
        return perObservacion;
    }

    public void setPerObservacion(String perObservacion) {
        this.perObservacion = perObservacion;
    }

    public String getPerCodigoPostal() {
        return perCodigoPostal;
    }

    public void setPerCodigoPostal(String perCodigoPostal) {
        this.perCodigoPostal = perCodigoPostal;
    }

    public String getPerSector() {
        return perSector;
    }

    public void setPerSector(String perSector) {
        this.perSector = perSector;
    }

    public Character getPerZona() {
        return perZona;
    }

    public void setPerZona(Character perZona) {
        this.perZona = perZona;
    }

    public String getPerDireccionTrabajo() {
        return perDireccionTrabajo;
    }

    public void setPerDireccionTrabajo(String perDireccionTrabajo) {
        this.perDireccionTrabajo = perDireccionTrabajo;
    }

    public Character getPerVerificaDatos() {
        return perVerificaDatos;
    }

    public void setPerVerificaDatos(Character perVerificaDatos) {
        this.perVerificaDatos = perVerificaDatos;
    }

    public BigInteger getPerAnioInstruccion() {
        return perAnioInstruccion;
    }

    public void setPerAnioInstruccion(BigInteger perAnioInstruccion) {
        this.perAnioInstruccion = perAnioInstruccion;
    }

    public Character getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(Character perEstado) {
        this.perEstado = perEstado;
    }

    public Date getPerFechaActualizacion() {
        return perFechaActualizacion;
    }

    public void setPerFechaActualizacion(Date perFechaActualizacion) {
        this.perFechaActualizacion = perFechaActualizacion;
    }

    public CggGrupoCultural getCggGrupoCultural() {
        return cggGrupoCultural;
    }

    public void setCggGrupoCultural(CggGrupoCultural cggGrupoCultural) {
        this.cggGrupoCultural = cggGrupoCultural;
    }

    public CggGrupoSanguineo getCggGrupoSanguineo() {
        return cggGrupoSanguineo;
    }

    public void setCggGrupoSanguineo(CggGrupoSanguineo cggGrupoSanguineo) {
        this.cggGrupoSanguineo = cggGrupoSanguineo;
    }

    public CggNivelEducacion getCggNivelEducacion() {
        return cggNivelEducacion;
    }

    public void setCggNivelEducacion(CggNivelEducacion cggNivelEducacion) {
        this.cggNivelEducacion = cggNivelEducacion;
    }

    public CggOcupacion getCggOcupacion() {
        return cggOcupacion;
    }

    public void setCggOcupacion(CggOcupacion cggOcupacion) {
        this.cggOcupacion = cggOcupacion;
    }

    public CggPais getCggPais() {
        return cggPais;
    }

    public void setCggPais(CggPais cggPais) {
        this.cggPais = cggPais;
    }

    public CggParroquia getCggParroquia() {
        return cggParroquia;
    }

    public void setCggParroquia(CggParroquia cggParroquia) {
        this.cggParroquia = cggParroquia;
    }

    public CggParroquia getCggParroquia1() {
        return cggParroquia1;
    }

    public void setCggParroquia1(CggParroquia cggParroquia1) {
        this.cggParroquia1 = cggParroquia1;
    }

    public CggReligion getCggReligion() {
        return cggReligion;
    }

    public void setCggReligion(CggReligion cggReligion) {
        this.cggReligion = cggReligion;
    }

    @XmlTransient
    public List<MetPaciente> getMetPacienteList() {
        return metPacienteList;
    }

    public void setMetPacienteList(List<MetPaciente> metPacienteList) {
        this.metPacienteList = metPacienteList;
    }

    @XmlTransient
    public List<AppEmpleado> getAppEmpleadoList() {
        return appEmpleadoList;
    }

    public void setAppEmpleadoList(List<AppEmpleado> appEmpleadoList) {
        this.appEmpleadoList = appEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggPersona)) {
            return false;
        }
        CggPersona other = (CggPersona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pprueba.CggPersona[ perId=" + perId + " ]";
    }
    
}
