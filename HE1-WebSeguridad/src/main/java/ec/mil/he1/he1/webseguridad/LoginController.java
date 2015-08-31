/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.webseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegPerfilUsuario;
import ec.mil.he1.he1.modelo.seguridad.SegUsuario;
import ec.mil.he1.he1.remotoseguridad.SegPerfilUsuarioFacadeRemote;
import ec.mil.he1.he1.remotoseguridad.SegUsuarioFacadeRemote;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sandra_collaguazo
 */
@Named(value = "loginController")
@ViewScoped
public class LoginController implements Serializable {

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {

    }

    //<editor-fold defaultstate="collapsed" desc="Post Construccion">
    @PostConstruct
    public void init() {
        System.out.println(" init ");
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        System.out.println(" La session es " + session);
        session.invalidate();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">

    private String usuario;
    private String password;
    private InputText txt_usuario = new InputText();
    private Password txt_clave = new Password();
    private String cedula;
    private boolean validaVacios = true;

    @EJB
    private SegUsuarioFacadeRemote segUsuarioFacade;

    @EJB
    private SegPerfilUsuarioFacadeRemote segPerfilUsuarioFacade;
    private String message;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public String valida() {
        String resultado = "";
        boolean primeraVez = Boolean.FALSE; // TODO: quitar esta valor cuando se implemente el metodo.
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context
                .getViewRoot().getViewId());
        context.setViewRoot(viewRoot);

        //TODO: servicio que me devuelva si el usuario es igual a la clave
        if (primeraVez) {
            System.out.println("Usuario igual a contraseña: " + usuario.trim());
            showMessage("Login", "Favor cambie su Contraseña para su seguridad.");
            resultado = "/cambiarPassword.xhtml";

        } else {

            try {

                String mensaje = segUsuarioFacade.login(usuario.trim(), password.trim());
                if (mensaje != null) {
                    if (mensaje.trim().equals("3")) {
                        showMessage("Login", "Usuario no existe.");
                        return null;
                    }
                    if (mensaje.trim().equals("2")) {
                        showMessage("Login", "Contraseña incorrecta.");
                        return null;
                    }

                    //TODO: Valor que indique si el usuario esta activo o no.
                    if (mensaje.trim().equals("4")) {
                        showMessage("Login", "Usuario Inactivo.");
                        return null;
                    }

                }
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.INFO, null, ex);
                return null;
            }

            List<SegUsuario> usu = segUsuarioFacade.findUsuarioXNombre(usuario);
            List<SegPerfilUsuario> perfilUsuarioList = segPerfilUsuarioFacade.listPerfilXUsuario(usu.get(0).getUsuId());
//        System.out.println(" El perfirl es " + perfilUsuarioList );
            if (perfilUsuarioList.size() <= 0) {
                showMessage("Perfil", "No tiene asignado un Perfil. Gracias.");
                return null;
            }
//        System.out.println(" el usu es " + usu.get(0).getCggPersona().getPerNombre());
            context.getExternalContext().getSessionMap().remove("usu_login");
            context.getExternalContext().getSessionMap().remove("navegacion");
            context.getExternalContext().getSessionMap().remove("eventos");
            context.getExternalContext().getSessionMap().remove("sesionBean");
            context.getExternalContext().getSessionMap().put("usu_login", usu.get(0));
            context.getExternalContext().getSessionMap().put("perfilUsuarioList", perfilUsuarioList);

            //Obtener IP del equipo local
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        System.out.println("AppAspirante ipLocal: " + request.getRemoteAddr() + " User: " + usu.getUsuId() + " Date: " + new Date());

            resultado = "/inicio.xhtml";

            
            //        return "vista/sistema.xhtml?faces-redirect=true";
        }
        return resultado;
    }

    public void recuperarClave() {
    }
    
    public void showMessage(String titulo, String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public boolean validarVacios() {

        validaVacios = false;
        cedula = cedula.trim();
        if (cedula.isEmpty()) {
            validaVacios = true;
        }
        return validaVacios;
    }

    public void enviarPorMail() {
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InputText getTxt_usuario() {
        return txt_usuario;
    }

    public void setTxt_usuario(InputText txt_usuario) {
        this.txt_usuario = txt_usuario;
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

    public Password getTxt_clave() {
        return txt_clave;
    }

    public void setTxt_clave(Password txt_clave) {
        this.txt_clave = txt_clave;
    }

  //</editor-fold>
}
