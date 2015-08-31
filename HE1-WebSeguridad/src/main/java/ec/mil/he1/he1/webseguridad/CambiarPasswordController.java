/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.webseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegUsuario;
import ec.mil.he1.he1.remotoseguridad.SegUsuarioFacadeRemote;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sandra_collaguazo
 */
@Named(value = "cambiarPasswordController")
@ViewScoped
public class CambiarPasswordController implements Serializable {

    /**
     * Creates a new instance of LoginController
     */
    public CambiarPasswordController() {

    }

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private SegUsuario segUsuario;
    private String rePassword;
    private String cedula;
    private boolean validaVacios = true;

    @EJB
    private SegUsuarioFacadeRemote segUsuarioFacade;

    private String message;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public String validaClave() {
        String resultado = "";
        try {
            
            String mensaje = segUsuarioFacade.login(segUsuario.getUsuNombre().trim(), segUsuario.getUsuNombre().trim());
            if (mensaje != null) {
                if (mensaje.trim().equals("3")) {
                    showMessage("Login", "Usuario no existe.");
                    return null;
                }
                if (mensaje.trim().equals("1")) {
                    
                    if (segUsuario.getUsuClave().trim().compareTo(rePassword) != 0) {
                        System.out.println("repassword " + segUsuario.getUsuNombre());
                        showMessage("Cambiar contraseña", "La contraseñas no coinciden.Favor verifique");
                        return null;
                    } 
                    if(segUsuario.getUsuNombre().trim().compareTo(segUsuario.getUsuClave().trim()) == 0){
                        System.out.println("Usuario igual a contraseña - Usu:" + segUsuario.getUsuNombre()+"  Clave: "+segUsuario.getUsuClave());
                        showMessage("Cambiar contraseña", "La contraseña es igual a su Usuario.Favor verifique");
                        return null;
                    }
                    else {
                        segUsuario = segUsuarioFacade.findUsuarioUnico(segUsuario.getUsuNombre().trim());   
                        segUsuario.setUsuClave(rePassword);
                        System.out.println("Graba usuario"+segUsuario.getUsuNombre()+"Id: "+segUsuario.getUsuId());
                        segUsuarioFacade.edit(segUsuario);
                        showMessage("Cambiar contraseña", "Contraseña actualizada exitosamente.");
                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(CambiarPasswordController.class.getName()).log(Level.INFO, null, ex);
            return null;
        }

        resultado = "/faces/login.xhtml";
        return resultado;
    }
    public void showMessage(String titulo, String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">

    public SegUsuario getSegUsuario() {
         if(segUsuario==null)
        {
            segUsuario=new SegUsuario();
        }
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }


    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isValidaVacios() {
        return validaVacios;
    }

    public void setValidaVacios(boolean validaVacios) {
        this.validaVacios = validaVacios;
    }

  //</editor-fold>
}
