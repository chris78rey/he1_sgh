/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

import ec.mil.he1.he1.modelo.nomina.AppEmpleado;
import ec.mil.he1.he1.modelo.seguridad.SegUsuario;
import ec.mil.he1.he1.modelo.triage.MetPaciente;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author galo_jaramillo
 */
@Entity
@Table(name = "CGG_PERSONA")
@NamedQueries({
    @NamedQuery(name = "CggPersona.findAll", query = "SELECT c FROM CggPersona c")})
public class CggPersona implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cggPersona", fetch = FetchType.LAZY)
    private List<SegUsuario> segUsuarioList;
    @OneToMany(mappedBy = "cggPersona", fetch = FetchType.LAZY)
    private List<MetPaciente> metPacienteList;
    @OneToMany(mappedBy = "cggPersona", fetch = FetchType.LAZY)
    private List<AppEmpleado> appEmpleadoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PER_ID")
    private BigDecimal perId;
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Column(name = "PER_APELLIDO")
    private String perApellido;
    @Column(name = "PER_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaNacimiento;
    @Column(name = "PER_DNI")
    private String perDni;
    @Column(name = "PER_TIPO_DNI")
    private Character perTipoDni;
    @Column(name = "PER_SEXO")
    private Character perSexo;
    @Column(name = "PER_ESTADO_CIVIL")
    private Character perEstadoCivil;
    @Column(name = "PER_DIRECCION_DOMICILIO")
    private String perDireccionDomicilio;
    @Column(name = "PER_TELEFONO_CASA")
    private String perTelefonoCasa;
    @Column(name = "PER_TELEFONO_TRABAJO")
    private String perTelefonoTrabajo;
    @Column(name = "PER_TELEFONO_MOVIL1")
    private String perTelefonoMovil1;
    @Column(name = "PER_TELEFONO_MOVIL2")
    private String perTelefonoMovil2;
    @Column(name = "PER_EMAIL_PERSONAL")
    private String perEmailPersonal;
    @Column(name = "PER_EMAIL_TRABAJO")
    private String perEmailTrabajo;
    @Column(name = "PER_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaRegistro;
    @Column(name = "PER_FECHA_MIGRACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaMigracion;
    @Column(name = "PER_OBSERVACION")
    private String perObservacion;
    @Column(name = "PER_CODIGO_POSTAL")
    private String perCodigoPostal;
    @Column(name = "PER_SECTOR")
    private String perSector;
    @Column(name = "PER_ZONA")
    private Character perZona;
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
    @Column(name = "PER_EMPRESA_TRABAJO")
    private String perEmpresaTrabajo;
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

    public String getPerEmailTrabajo() {
        return perEmailTrabajo;
    }

    public void setPerEmailTrabajo(String perEmailTrabajo) {
        this.perEmailTrabajo = perEmailTrabajo;
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

    public String getPerEmpresaTrabajo() {
        return perEmpresaTrabajo;
    }

    public void setPerEmpresaTrabajo(String perEmpresaTrabajo) {
        this.perEmpresaTrabajo = perEmpresaTrabajo;
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
        return "ec.mil.he1.he1.modelo.general.CggPersona[ perId=" + perId + " ]";
    }

    public List<AppEmpleado> getAppEmpleadoList() {
        return appEmpleadoList;
    }

    public void setAppEmpleadoList(List<AppEmpleado> appEmpleadoList) {
        this.appEmpleadoList = appEmpleadoList;
    }

    public List<MetPaciente> getMetPacienteList() {
        return metPacienteList;
    }

    public void setMetPacienteList(List<MetPaciente> metPacienteList) {
        this.metPacienteList = metPacienteList;
    }

    public List<SegUsuario> getSegUsuarioList() {
        return segUsuarioList;
    }

    public void setSegUsuarioList(List<SegUsuario> segUsuarioList) {
        this.segUsuarioList = segUsuarioList;
    }
    
}
