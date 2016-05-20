package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

import co.edu.javeriana.ambulancias.anumerados.TipoUCI;

public class AmbulanciaUCI extends AmbulanciaMedicalizada implements Serializable{
	
	private TipoUCI tipoUCI;
	/**
	 * Acceder al atributo tipoUCI
	 * @return Retorna el valor del atributo
	 */
	public String getTipoUCI() {
		
		String returnString;
		
		if (this.tipoUCI == TipoUCI.CARDIOVASCULAR) {
			returnString = "CARDIOVASCULAR";
		}else{
			returnString = "PEDIATRICA";
		}
		return returnString;		
	}
	/**
	 * Da valor al atributo tipoUCI
	 * @param tipoUCI Recibe un Stirng y s elo asigna al atributo
	 */
	public void setTipoUCI(TipoUCI tipoUCI) {
		this.tipoUCI = tipoUCI;
	}
	/**
	 * Constructor de AmbulanciaUCI
	 * @param codigo Corresponde al codigo de la super-clase
	 * @param placa Corresponde a la placa de la super-clase
	 * @param medico Corresponde al medico de la super-clase
	 * @param tipoUCI Corresponde al tipoUCI de esta clase
	 */
	public AmbulanciaUCI(int codigo, String placa, String medico, TipoUCI tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI = tipoUCI;
	}
	// ** METODOS ** //
	/**
	 * Calcula la tarifa de la ambulancia uci
	 * @return Retorna la tarifa calculada
	 */
	public double calcularTarifa(){
		if (tipoUCI == tipoUCI.CARDIOVASCULAR) {
			return TARIFA_BASE * 1.5;
		}
		return TARIFA_BASE * 1.6;
	}
	
}
