/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.modelo.general;

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
@Table(name = "CGG_DATO_CONTACTO")
@NamedQueries({
    @NamedQuery(name = "CggDatoContacto.findAll", query = "SELECT c FROM CggDatoContacto c")})
public class CggDatoContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "DAT_ID")
    private BigDecimal datId;
    @Column(name = "PER_ID")
    private BigInteger perId;
    @Column(name = "DAT_NOMBRE")
    private String datNombre;
    @Column(name = "DAT_APELLIDO")
    private String datApellido;
    @Column(name = "DAT_TELEFONO1")
    private String datTelefono1;
    @Column(name = "DAT_TELEFONO2")
    private String datTelefono2;
    @Column(name = "DAT_TIPO_CONTACTO")
    private String datTipoContacto;

    public CggDatoContacto() {
    }

    public CggDatoContacto(BigDecimal datId) {
        this.datId = datId;
    }

    public BigDecimal getDatId() {
        return datId;
    }

    public void setDatId(BigDecimal datId) {
        this.datId = datId;
    }

    public BigInteger getPerId() {
        return perId;
    }

    public void setPerId(BigInteger perId) {
        this.perId = perId;
    }

    public String getDatNombre() {
        return datNombre;
    }

    public void setDatNombre(String datNombre) {
        this.datNombre = datNombre;
    }

    public String getDatApellido() {
        return datApellido;
    }

    public void setDatApellido(String datApellido) {
        this.datApellido = datApellido;
    }

    public String getDatTelefono1() {
        return datTelefono1;
    }

    public void setDatTelefono1(String datTelefono1) {
        this.datTelefono1 = datTelefono1;
    }

    public String getDatTelefono2() {
        return datTelefono2;
    }

    public void setDatTelefono2(String datTelefono2) {
        this.datTelefono2 = datTelefono2;
    }

    public String getDatTipoContacto() {
        return datTipoContacto;
    }

    public void setDatTipoContacto(String datTipoContacto) {
        this.datTipoContacto = datTipoContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datId != null ? datId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CggDatoContacto)) {
            return false;
        }
        CggDatoContacto other = (CggDatoContacto) object;
        if ((this.datId == null && other.datId != null) || (this.datId != null && !this.datId.equals(other.datId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.he1.modelo.general.CggDatoContacto[ datId=" + datId + " ]";
    }
    
}
