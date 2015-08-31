/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.he1.webseguridad;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zepolar
 * @param <T>
 */
public abstract class BaseCatalogoControlador<T> {

    private static final Logger LOG = Logger.getLogger(BaseCatalogoControlador.class.getName());

    protected T object;

    protected Boolean modoEdicion;

    protected Boolean esNuevo;

    private final Class<T> instance;

    public BaseCatalogoControlador(Class<T> object) {
        this.instance = object;
        this.esNuevo = Boolean.FALSE;
        this.modoEdicion = Boolean.FALSE;
    }

    public void nuevo() {
        try {
            this.object = (T) instance.newInstance();
            this.esNuevo = Boolean.TRUE;
            this.modoEdicion = Boolean.TRUE;
        } catch (InstantiationException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    public void editar() {
        this.esNuevo = Boolean.FALSE;
        this.modoEdicion = Boolean.TRUE;
    }

    public abstract void buscar();

    public abstract void eliminar();

    public abstract void guardar();
    

    public abstract void cancelar();

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Boolean getModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(Boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public Boolean getEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(Boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

}
