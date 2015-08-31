/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.webnomina.enumeracion;

/**
 *
 * @author sandra_collaguazo
 */
public enum EstadoEnum {

	A("Activo"), I("Inactivo");
	private EstadoEnum(String estado) {
		this.estado = estado;
	}

	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static EstadoEnum obtenerEstado(Character estado){
		 switch( estado ) {
		 case 'A':
		      return A;
		 case 'I':
		      return I;

		 default:
			 return A;
		 }
	 }
	
    

}
