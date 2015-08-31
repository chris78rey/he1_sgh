/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.webseguridad;

import ec.mil.he1.he1.modelo.seguridad.SegGrupoSistema;
import ec.mil.he1.he1.modelo.seguridad.SegOpcionMenu;
import ec.mil.he1.he1.remotoseguridad.SegGrupoSistemaFacadeRemote;
import ec.mil.he1.he1.remotoseguridad.SegOpcionMenuFacadeRemote;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


/**
 *
 * @author luis_guanoluiza
 */
@Named(value = "sistema")
@ViewScoped
public class SistemaJSFManagedBean implements Serializable {
   
    @EJB
    private SegGrupoSistemaFacadeRemote segGrupoSistemaFacade;
    
    @EJB
    private SegOpcionMenuFacadeRemote segOpcionMenuFacade;

   
    
    
    private List<SegGrupoSistema> obtenerGrupoPorNombre;
    private List<SegGrupoSistema> listaGrupoSistema;
    
    private List<SegOpcionMenu> listaOpcionPadre;
    private List<SegOpcionMenu> listaOpcionHijo;
 

   

    private TreeNode rootNode;
    private TreeNode selectedNode;

    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

       // <editor-fold defaultstate="collapsed" desc="/**Genera el arbol">
    public TreeNode genArbol() {
        System.out.println("gen arbol");
        rootNode = new DefaultTreeNode(null,"Root", null);
        List<SegOpcionMenu> menuList = segOpcionMenuFacade.listPadre();
        System.out.println("menuListPadre  "+menuList.size());
        for (SegOpcionMenu menu : menuList) {
            System.out.println("opc "+menu.getOpcId());
            TreeNode childNode = new DefaultTreeNode(menu.getOpcId().toString(), menu.getOpcNombreOpcion(), rootNode);
            List<SegOpcionMenu> menuSubList = segOpcionMenuFacade.listHijos(menu.getOpcId());
                   System.out.println("menuSubList "+menuSubList.size());
            for (SegOpcionMenu subMenu : menuSubList) {
                TreeNode childNode2 = new DefaultTreeNode(subMenu.getOpcId().toString(),subMenu.getOpcNombreOpcion(), childNode);
            }
        }
        System.out.println("listo...");
        return rootNode;

    }
    // </editor-fold>
    /*
     * Creates a new instance of SistemaJSFManagedBean
     */
    public SistemaJSFManagedBean() {
        
    }

         /**
     * @return the listaOpcionPadre
     */
    public List<SegOpcionMenu> getListaOpcionPadre() {
        listaOpcionPadre = segOpcionMenuFacade.listaOpcionPadre(1);
        return listaOpcionPadre;
    }
    
   
    /**
     * @param listaOpcionPadre the listaOpcionPadre to set
     */
    public void setListaOpcionPadre(List<SegOpcionMenu> listaOpcionPadre) {
        this.listaOpcionPadre = listaOpcionPadre;
    }

    /**
     * @return the listaOpcionHijo
     */
    public List<SegOpcionMenu> getListaOpcionHijo() {
        listaOpcionHijo = segOpcionMenuFacade.listaOpcionHijo(1, 41);
        return listaOpcionHijo;
    }

     /**
     * @param listaOpcionHijo the listaOpcionHijo to set
     */
    public void setListaOpcionHijo(List<SegOpcionMenu> listaOpcionHijo) {
        this.listaOpcionHijo = listaOpcionHijo;
    }

       
    public List<SegGrupoSistema> getObtenerGrupoPorNombre() {
        obtenerGrupoPorNombre = segGrupoSistemaFacade.listByGrupoXNombre("medi");
        return obtenerGrupoPorNombre;
    }

    /**
     * @param obtenerGrupoPorNombre the obtenerGrupoPorNombre to set
     */
    public void setObtenerGrupoPorNombre(List<SegGrupoSistema> obtenerGrupoPorNombre) {
        this.obtenerGrupoPorNombre = obtenerGrupoPorNombre;
    }

    /**
     * @return the listaGrupoSistema
     */
    public List<SegGrupoSistema> getListaGrupoSistema() {
        listaGrupoSistema = segGrupoSistemaFacade.listByGrupoSistema();
        return listaGrupoSistema;
    }

    /**
     * @param listaGrupoSistema the listaGrupoSistema to set
     */
    public void setListaGrupoSistema(List<SegGrupoSistema> listaGrupoSistema) {
        this.listaGrupoSistema = listaGrupoSistema;
    }

}
