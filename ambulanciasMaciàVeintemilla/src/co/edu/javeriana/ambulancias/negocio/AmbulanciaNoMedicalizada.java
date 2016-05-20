package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

public class AmbulanciaNoMedicalizada extends Ambulancia implements Serializable{

	private String enfermero;
	/**
	 * Accede al atributo enfermero
	 * @return Retorna el valor del atributo
	 */
	public String getEnfermero() {
		return enfermero;
	}
	/**
	 * Da valor al atributo enfermero
	 * @param enfermero Recibe un String y se lo otorga a enfermero
	 */
	public void setEnfermero(String enfermero) {
		this.enfermero = enfermero;
	}
	/**
	 * Constructor de ambulancia no medicalizada
	 * @param codigo Corresponde al codigo de la super-clase
	 * @param placa Corresponde a la placa de la super-clase
	 * @param enfermero Corresponde al enfermero de esta clase
	 */
	public AmbulanciaNoMedicalizada(int codigo, String placa, String enfermero) {
		super(codigo, placa);
		this.enfermero = enfermero;
	}
	/**
	 * Sobre-escribe el metodo toString para agrupar
	 * @return Retorna el String con la concatenacion de atributos de la clase
	 */
	@Override
	public String toString() {
		return toString() + "AmbulanciaNoMedicalizada [enfermero=" + enfermero + "]";
	}
	
	// ** METODOS ** //
	/**
	 * Calcula la tarifa de la ambulancia no medicalizada
	 * @return Retorna la tarifa calculada
	 */
	public double calcularTarifa(){
		return TARIFA_BASE;
	}
}
