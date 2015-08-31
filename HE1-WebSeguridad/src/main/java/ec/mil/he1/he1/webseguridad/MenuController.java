/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.webseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema;
import ec.mil.he1.he1.modelo.seguridad.SegOpcionMenu;
import ec.mil.he1.he1.modelo.seguridad.SegPerfilUsuario;
import ec.mil.he1.he1.modelo.seguridad.SegUnidadUsuario;
import ec.mil.he1.he1.modelo.seguridad.SegUsuario;
import ec.mil.he1.he1.remotoseguridad.SegGrupoSistemaFacadeRemote;
import ec.mil.he1.he1.remotoseguridad.SegOpcionMenuFacadeRemote;
import ec.mil.he1.he1.remotoseguridad.SegUnidadUsuarioFacadeRemote;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author
 */
@Named(value = "menuController")
@ViewScoped
public class MenuController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    @EJB
    private SegOpcionMenuFacadeRemote segOpcionMenuFacade;
    
    @EJB
    private SegGrupoSistemaFacadeRemote segGrupoSistemaFacade;
//    @EJB
//    private SegOpcionMenuFacadeRemote segOpcionMenuFacade;
//    
    @EJB
    private SegUnidadUsuarioFacadeRemote segUnidadUsuarioFacade;

    private List<SegGrupoSistema> grupoSistemaList=new ArrayList<SegGrupoSistema>();
    private List<SegOpcionMenu> opcionMenuList;
    private SegUsuario usu_login;
    private List<SegPerfilUsuario> perfilUsuarioList;
    private List<SegUnidadUsuario> unidadUsuarioList;
    String nombreUnidadUsuario;
    private static String pathSistema = "/paginas/";
//      private String selectedIncludePath = "/inicio.xhtml";
    private String selectedIncludePath = "";
    private Date fecha = new Date();
   

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public MenuController() {
//        this.grupoSistemaList = new ArrayList<>();

        usu_login = (SegUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usu_login");
//       System.out.println(" Usuario : " + usu_login.getCggPersona().getPerNombre()+usu_login.getCggPersona().getPerApellido());

        perfilUsuarioList = (List<SegPerfilUsuario>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfilUsuarioList");
        System.out.println("tamaño lista Perfil usuario :"+perfilUsuarioList.size()+" perfiles: "+perfilUsuarioList);
        String url = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("url_navegaPage");
//        System.out.println(" Url : " + url);

        if (url != null) {
            selectedIncludePath = url;
        } else {
            selectedIncludePath = "/inicio.xhtml";
        }
    }
  //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Post-Constructor">
    @PostConstruct
    public void init() {

//        grupo=segGrupoSistemaFacade.findAll();
//        System.out.println("tamaño d ela lista es "+ grupo.size());
//          setGrupo(this.segGrupoSistemaFacade.findAll());
        if (usu_login != null) {

            unidadUsuarioList = segUnidadUsuarioFacade.listUnidadXUsuario(usu_login.getUsuId().intValue());
            nombreUnidadUsuario = unidadUsuarioList.get(0).getCggUnidadSalud().getUnsNombre();
            for (int i=0;i<getPerfilUsuarioList().size();i++){
                SegGrupoSistema grupoSistema=segGrupoSistemaFacade.find(getPerfilUsuarioList().get(i).getSegPerfil().getSegGrupoSistema().getGruId());
                grupoSistemaList.add(i, grupoSistema);
                System.out.println("Grupo: "+grupoSistemaList.get(i).getGruDescripcion());
            }
            

//            setGrupoSistemaList(segGrupoSistemaFacade.listByGrupoSistema());
//            setLopciones(this.segOpcionFacade.listaOpciones(sistema, usu_login.getUsuId()));
//            setOpcionMenuList(segOpcionMenuFacade.listaOpciones(new BigDecimal("1")));
//            System.out.println(" la lista del menu es  " + getOpcionMenuList().size());
//        for (int i = 0; i < getOpcionMenu().size(); i++) {
//            SegOpcionMenu opc = (SegOpcionMenu) getOpcionMenu().get(i);
//             
//            //  List lopcionesHijos = this.segOpcionMenuFacade.listaOpcionesPapa(opc.getOpcId(), new BigDecimal("1"));
//            List lopcionesHijos = this.segOpcionMenuFacade.listaOpcionesNivel1(opc.getOpcId());
//           System.out.println(" numero de veces i  " + i);
//               opc.setOpcionHijos(lopcionesHijos);
//
        }

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public void van() {

        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String archivo = (String) map.get("includePath");
        selectedIncludePath = (String) map.get("includePath");

        System.out.println(" el esta es  " + selectedIncludePath);

    }
//public void navigationPathChange(ActionEvent event) {
//      
//        FacesContext context = FacesContext.getCurrentInstance();
//        Map map = context.getExternalContext().getRequestParameterMap();
//        String archivo = (String) map.get("includePath");
//       
//        if (archivo != null && archivo.length() > 0) {
////            archivo = archivo.substring(archivo.lastIndexOf("/") + 1, archivo.lastIndexOf(".xhtml"));
//          //  selectedIncludePath = pathSistema + (String) map.get("includePath");
//                      selectedIncludePath = (String) map.get("includePath");
//
//           
//        
//             
//           
//        }
//    } 
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">

    public SegUsuario getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(SegUsuario usu_login) {
        this.usu_login = usu_login;
    }

    public List<SegUnidadUsuario> getUnidadUsuarioList() {
        return unidadUsuarioList;
    }

    public void setUnidadUsuarioList(List<SegUnidadUsuario> unidadUsuarioList) {
        this.unidadUsuarioList = unidadUsuarioList;
    }

    public String getNombreUnidadUsuario() {
        return nombreUnidadUsuario;
    }

    public void setNombreUnidadUsuario(String nombreUnidadUsuario) {
        this.nombreUnidadUsuario = nombreUnidadUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<SegOpcionMenu> getOpcionMenuList() {
        return opcionMenuList;
    }

    public void setOpcionMenuList(List<SegOpcionMenu> opcionMenuList) {
        this.opcionMenuList = opcionMenuList;
    }

    public String getSelectedIncludePath() {
        return selectedIncludePath;
    }

    public void setSelectedIncludePath(String selectedIncludePath) {
        this.selectedIncludePath = selectedIncludePath;
    }

    public List<SegPerfilUsuario> getPerfilUsuarioList() {
        return perfilUsuarioList;
    }

    public void setPerfilUsuarioList(List<SegPerfilUsuario> perfilUsuarioList) {
        this.perfilUsuarioList = perfilUsuarioList;
    }

    public List<SegGrupoSistema> getGrupoSistemaList() {
        return grupoSistemaList;
    }

    public void setGrupoSistemaList(List<SegGrupoSistema> grupoSistemaList) {
        this.grupoSistemaList = grupoSistemaList;
    }

    

    public static String getPathSistema() {
        return pathSistema;
    }

    public static void setPathSistema(String pathSistema) {
        MenuController.pathSistema = pathSistema;
    }

  //</editor-fold>
}
