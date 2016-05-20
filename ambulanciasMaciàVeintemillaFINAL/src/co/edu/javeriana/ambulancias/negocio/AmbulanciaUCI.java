package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

public class AmbulanciaUCI extends AmbulanciaMedicalizada implements Serializable{
	
	private String tipoUCI;
	/**
	 * Acceder al atributo tipoUCI
	 * @return Retorna el valor del atributo
	 */
	public String getTipoUCI() {
		return tipoUCI;
	}
	/**
	 * Da valor al atributo tipoUCI
	 * @param tipoUCI Recibe un Stirng y s elo asigna al atributo
	 */
	public void setTipoUCI(String tipoUCI) {
		this.tipoUCI = tipoUCI;
	}
	/**
	 * Constructor de AmbulanciaUCI
	 * @param codigo Corresponde al codigo de la super-clase
	 * @param placa Corresponde a la placa de la super-clase
	 * @param medico Corresponde al medico de la super-clase
	 * @param tipoUCI Corresponde al tipoUCI de esta clase
	 */
	public AmbulanciaUCI(int codigo, String placa, String medico, String tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI = tipoUCI;
	}
	// ** METODOS ** //
	/**
	 * Calcula la tarifa de la ambulancia uci
	 * @return Retorna la tarifa calculada
	 */
	public double calcularTarifa(){
		if (tipoUCI.compareTo("CARDIOVASCULAR") == 0) {
			return TARIFA_BASE * 1.5;
		}
		return TARIFA_BASE * 1.6;
	}
	
}
