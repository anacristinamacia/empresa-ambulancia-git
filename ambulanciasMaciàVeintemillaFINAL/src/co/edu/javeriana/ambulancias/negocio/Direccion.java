package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

public class Direccion implements Serializable{

	private String tipoDireccion;
	private int calle;
	private int carrera;
	private int numero;

	// ** GETTERES & SETTERS DIRECCION ** //
	/**
	 * Accede al atributo de tipo String tipoDireccion
	 * @return Retorna el valor de tipoDireccion
	 */
	public String getTipoDireccion() {
		return tipoDireccion;
	}
	/**
	 * Le otorga un valor al atributo tipoDireccion
	 * @param tipoDireccion Recibe un String y se lo otorga al atributo
	 */
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	/**
	 * Accede al atributo de tipo entero Calle
	 * @return Retorna el valor de Calle
	 */
	public int getCalle() {
		return calle;
	}
	/**
	 * Le otorga un valor al atributo calle
	 * @param calle Recibe un numero entero y se lo otorga al atributo
	 */
	public void setCalle(int calle) {
		this.calle = calle;
	}
	/**
	 * Accede al atributo de tipo entero carrera
	 * @return Retorna el valor de carrera
	 */
	public int getCarrera() {
		return carrera;
	}
	/**
	 * Le otorga un valor al atributo carrera
	 * @param carrera Recibe un numero entero y se lo otorga al atributo
	 */
	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}
	/**
	 * Accede al atributo de tipo entero numero
	 * @return Retorna el valor de numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * Le otorga un valor al atributo numero
	 * @param numero Recibe un numero entero y se lo otorga al atributo
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	// ** CONSTRUCTOR DIRECCION ** //
	/**
	 * Construye un objeto direccion y le asigna valores a sus atributos
	 * @param tipoDireccion Recibe un String y se lo otorga al atributo tipoDireccion
	 * @param calle Recibe un numero entero y se lo otorga a calle
	 * @param carrera Recibe un numero entero y se lo otorga a carrera
	 * @param numero Recibe un numero entero y se lo otorga a numero
	 */
	public Direccion(String tipoDireccion, int calle, int carrera, int numero) {
		this.tipoDireccion = tipoDireccion;
		this.calle = calle;
		this.carrera = carrera;
		this.numero = numero;
	}
	
	// ** TOSTRING DIRECCION ** //
	/**
	 * Este metodo imprime todos los atributos que tiene direccion
	 */
	@Override
	public String toString() {
		return "Direccion [tipoDireccion = " + tipoDireccion + ", calle = " + calle + ", carrera = " + carrera + ", numero = "
				+ numero + "] ]";
	}
}
