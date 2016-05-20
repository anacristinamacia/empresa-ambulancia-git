package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

public abstract class AmbulanciaMedicalizada extends Ambulancia implements Serializable{

protected String medico;
	
	/***
	 * Accede al atributo medico de la clase
	 * @return Retorna el valor del atributo
	 */
	public String getMedico() {
		return medico;
	}
	/**
	 * Da valor al atributo medico
	 * @param medico Recibe un String y se lo otorga al atributo
	 */
	public void setMedico(String medico) {
		this.medico = medico;
	}
	/**
	 * Constructor de ambulancia medicalizada
	 * @param codigo Corresponde al codigo de la super-clase
	 * @param placa Corresponde a la placa de la super-clase
	 * @param medico Corresponde al medico de esta clase
	 */
	public AmbulanciaMedicalizada(int codigo, String placa, String medico) {
		super(codigo, placa);
		this.medico = medico;
	}

	// ** METODOS ** //
	/**
	 * Signatura del metodo abstracto calcularTarfifa
	 */
	public abstract double calcularTarifa();
		
}
