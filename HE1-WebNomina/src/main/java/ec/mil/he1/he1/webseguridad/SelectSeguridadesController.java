/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.webseguridad;

import ec.mil.he1.webnomina.enumeracion.EstadoEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author sandra_collaguazo
 */
@Named(value = "selectSeguridadesController")
@ViewScoped
public class SelectSeguridadesController implements Serializable {

    private static final long serialVersionUID = 8792373041727851619L;

//<editor-fold defaultstate="collapsed" desc="Declaracion de variables">    
    private List<SelectItem> estadoItems;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Funciones">    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getters and Setters">   
    public List<SelectItem> getEstadoItems() {

        if (estadoItems == null) {
            estadoItems = new ArrayList<SelectItem>();
            EstadoEnum valor[] = EstadoEnum.values();
            for (EstadoEnum estadoEnum : valor) {
                estadoItems.add(new SelectItem(estadoEnum.toString(),
                        estadoEnum.getEstado()));
            }
        }
        return estadoItems;

    }

    public void setEstadoItems(List<SelectItem> estadoItems) {
        this.estadoItems = estadoItems;
    }

//</editor-fold>
}
