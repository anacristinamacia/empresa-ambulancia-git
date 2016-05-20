package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.util.ArrayList;

public class IPS implements Serializable{

	private String nombre;
	private String tipoAtencion;
	private Direccion direccion;
	private ArrayList<Servicio> listaServicios;
	
	// ** GETTERS & SETTERS ** //
	/**
	 * Accede al atributo de tipo String nombre
	 * @return Retorna el valor de nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Asigna al atributo nombre el parametro de tipo String
	 * @param nombre Recibe un String nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Accede al atributo de tipo String tipoAtencion
	 * @return Retorna el valor de tipoAtencio
	 */
	public String getTipoAtencion() {
		return tipoAtencion;
	}
	/**
	 * Asigna al atributo tipoAtencion el parametro de tipo String
	 * @param tipoAtencion Recibe un String tipoAtencion
	 */
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}
	/**
	 * Accede al atributo de tipo Direccion
	 * @return Retorna el valor de direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	/**
	 * Asigna al atributo direccion el parametro de tipo Direccion
	 * @param direccion Recibe un objeto Direccion direccion
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	/**
	 * Accede a la lista de tipo servicios listaServicios
	 * @return Retorna el valor de listaServicios
	 */
	public ArrayList<Servicio> getListaServicios() {
		return listaServicios;
	}
	/**
	 * Asigna al atributo listaServicios el parametro de tipo ArrayList de tipo Servicio
	 * @param listaServicios Recibe una lista listaServicios de tipo Servicio
	 */
	public void setListaServicios(ArrayList<Servicio> listaServicios) {
		this.listaServicios = listaServicios;
	}

	// ** CONSTRUCTOR IPS ** //
	/**
	 * Construye los objetos de tipo iPS
	 * @param nombre Recibe un String que corresponde al atrirbuto nombre del objeto
	 * @param tipoAtencion Recibe un String que corresponde al atrirbuto tipoAtencion del objeto que construye este constructor
	 * @param direccion Recibe un objeto de tipo DIreccion que corresponde al atrirbuto direccion del objeto
	 */
	public IPS(String nombre, String tipoAtencion, Direccion direccion) {
		this.nombre = nombre;
		this.tipoAtencion = tipoAtencion;
		this.direccion = direccion;
		this.listaServicios = new ArrayList<Servicio>();
	}
	/**
	 * Construye un objeto de tipo IPS e inicializa sus atributos vacios
	 */
	public IPS() {
		this.nombre = " ";
		this.tipoAtencion = " ";
		this.direccion = null;
		this.listaServicios = new ArrayList<Servicio>();
	}
	/**
	 * Este metodo reune los atributos de la clase en un string
	 * @return Retorna un String con los atributos de la clase
	 */
	@Override
	public String toString() {
		return "IPS [tipoAtencion = " + tipoAtencion + ", ";
	}
}
