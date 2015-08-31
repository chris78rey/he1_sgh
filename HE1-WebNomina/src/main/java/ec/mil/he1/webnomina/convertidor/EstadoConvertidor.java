/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.webnomina.convertidor;

import ec.mil.he1.webnomina.enumeracion.EstadoEnum;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sandra_collaguazo
 */
@FacesConverter(value = "estadoConvertidor")
public class EstadoConvertidor implements Converter {
    private static final Logger LOG = Logger.getLogger(EstadoConvertidor.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LOG.log(Level.INFO, "Valor que viene de la vista metodo getasobject{0}", value);

        if (value.isEmpty()) {
            return Boolean.FALSE;
        } else {

            if (EstadoEnum.A.equals(EstadoEnum.valueOf(value))) {
                LOG.log(Level.INFO, "Valor  ACTIVO {0}", EstadoEnum.A);
                return EstadoEnum.A;
            } else {
                return EstadoEnum.I;
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String nombreEstado="";
        String valor=(String) value.toString().trim();
        if (value == null) {
            nombreEstado = EstadoEnum.I.getEstado();
        } else {
            if (EstadoEnum.A.toString().compareTo(valor)==0) {
                nombreEstado = EstadoEnum.A.getEstado();
            }
            if (EstadoEnum.I.toString().compareTo(valor)==0) {
                nombreEstado = EstadoEnum.I.getEstado();
            }
        }
        return nombreEstado;
    }
}
