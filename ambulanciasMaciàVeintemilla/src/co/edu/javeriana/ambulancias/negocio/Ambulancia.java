package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Ambulancia implements Serializable{

	protected static final double TARIFA_BASE = 80000;
	protected int codigo;
	protected String placa;
	protected Date horaPosicion;
	protected int posicionCalle;
	protected int posicionCarrera;
	protected boolean disponible;
	protected ArrayList<Servicio> listaServicios;
	
	// ** GETTERS & SETTERS AMBULANCIA ** //
	
	/**
	 * Accede al atributo codigo de tipo int
	 * @return Retorna el valor de codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * Le otorga un valor al atributo codigo
	 * @param codigo Recibe un entero y se lo otorga al atributo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Accede al atributo de tipo String placa
	 * @return Retorna el valor de placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Le otorga un valor al atributo placa
	 * @param placa Recibe un String y se lo otorga al atributo
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * Accede al atributo de tipo Date de horaPosicion
	 * @return Retorna el valor de horaPosicion
	 */
	public Date getHoraPosicion() {
		return horaPosicion;
	}
	/**
	 * Le otorga un valor al atributo horaPosicion
	 * @param horaPosicion Recibe un Date y se lo otorga al atributo
	 */
	public void setHoraPosicion(Date horaPosicion) {
		this.horaPosicion = horaPosicion;
	}
	/**
	 * Accede al atributo de tipo entero posicionCalle
	 * @return Retorna el valor de posicionCalle
	 */
	public int getPosicionCalle() {
		return posicionCalle;
	}
	/**
	 * Le otorga un valor al atributo posicionCalle
	 * @param posicionCalle Recibe un numero entero y se lo otorga al atributo
	 */
	public void setPosicionCalle (int posicionCalle) {
		this.posicionCalle = posicionCalle;
	}
	/**
	 * Accede al atributo de tipo entero posicionCarrera
	 * @return Retorna el valor de posicionCarrera
	 */

	public int getPosicionCarrera() {
		return posicionCarrera;
	}
	/**
	 * Le otorga un valor al atributo posicionCarrera
	 * @param posicionCarrera Recibe un numero entero y se lo otorga al atributo
	 */
	public void setPosicionCarrera(int posicionCarrera) {
		this.posicionCarrera = posicionCarrera;
	}
	/**
	 * Accede al atributo de tipo booleano disponible
	 * @return Retorna el valor de disponible
	 */
	public boolean isDisponible() {
		return disponible;
	}
	/**
	 * Le otorga un valor al atributo disponible
	 * @param disponible Recibe un booleano y se lo otorga al atributo
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	/**
	 * Accede al ArrayList de tipo Servicio ListaServicios
	 * @return Retorna el ArrayList ListaServicios
	 */
	public ArrayList<Servicio> getListaServicios() {
		return listaServicios;
	}
	/**
	 * Le otorga un valor al atributo ListaServicios
	 * @param listaServicios Recibe una lista de tipo servicios y se lo otorga al atributo
	 */
	public void setListaServicios(ArrayList<Servicio> listaServicios) {
		this.listaServicios = listaServicios;
	}
	
	// ** CONSTRUCTOR AMBULANCIA ** //
	/**
	 * Construye un objeto ambulancia y le asigna valores a sus atributos
	 * @param codigo Recibe un numero entero y se lo otorga al atributo codigo
	 * @param placa Recibe un string y se lo otorga al atributo placa
	 */
	public Ambulancia (int codigo, String placa) {
		this.codigo = codigo;
		this.placa = placa;
		this.horaPosicion = null;
		this.posicionCalle = 0;
		this.posicionCarrera = 0;
		this.disponible = true;
		listaServicios = new ArrayList<Servicio>();
	}
	/**
	 * Construye un objeto ambulancia con todos sus atributos vacios
	 */
	public Ambulancia () {
		this.codigo = 0;
		this.placa = " ";
		this.horaPosicion = null;
		this.posicionCalle = 0;
		this.posicionCarrera = 0;
		this.disponible = true;
		listaServicios = new ArrayList<Servicio>();
	}
	
	
	// ** TOSTRING AMBULANCIA ** //
	/**
	 * Este metodo agrupa todos los atributos que tiene esta clase
	 * @return retorna los atributos oncatenados
	 */
	@Override
	public String toString() {
		if (horaPosicion != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
			return "Ambulancia [codigo=" + codigo + "placa = " + placa + "horaPosicion = " + sdf.format(horaPosicion) + ", posicionCalle = " + posicionCalle + ", posicionCarrera = "
					+ posicionCarrera + "]";
		}
		return "Ambulancia [codigo=" + codigo + "placa = " + placa + "]";
	}
	
	// ** METODOS ** //
	/**
	 * Metodo abstracto que calcula la tarifa de al ambulancia
	 * @return Retorna el valor de la tarifa calculada segun el tipo de la ambulancia
	 */
	public abstract double calcularTarifa();
	
	
	
	
	
}
