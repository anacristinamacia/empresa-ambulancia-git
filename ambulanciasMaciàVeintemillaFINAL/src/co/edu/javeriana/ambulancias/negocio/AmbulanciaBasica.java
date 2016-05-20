package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

public class AmbulanciaBasica extends AmbulanciaMedicalizada implements Serializable{
	
	/**
	 * Constructor de ambulancia basica, llama al constructor de su super-clase
	 * @param codigo Corresponde al codigo de su super-clase
	 * @param placa Corresponde a la placa de su super-clase
	 * @param medico Corresponde al medico de su super-clase
	 */
	public AmbulanciaBasica(int codigo, String placa, String medico) {
		super(codigo, placa, medico);
	}

	
	// ** METODOS ** //
	/**
	 * Calcula la tarifa de la ambulancia medicalizada
	 * @return Retorna el valor de la tarifa
	 */
	public double calcularTarifa(){
		return TARIFA_BASE * 1.2;
	}

}
