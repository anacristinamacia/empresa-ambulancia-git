package co.edu.javeriana.ambulancias.negocio;

import java.util.Date;

import co.edu.javeriana.ambulancias.anumerados.TipoDireccion;
import co.edu.javeriana.ambulancias.anumerados.TipoServicio;
import co.edu.javeriana.ambulancias.anumerados.TipoUCI;
/**
 * Interfaz implementada por EmpresaAmbulancias
 * 
 * @author Macia-Veintemilla
 *
 */
public interface IServiciosAmbulancias {

	public void agregarIPS(String nombre, String tipoAtencion, TipoDireccion tipoDireccion, int calle, int carrera, int numero);
	public void agregarAmbulanciaBasica (int codigo, String placa, String medico);
	public void agregarAmbulanciaUCI (int codigo, String placa, String medico, TipoUCI tipoUCI);
	public void agregarAmbulanciaNoMedicalizada (int codigo, String placa, String enfermero);
	public boolean registrarPosicionAmbulancia(int codigo, Date hora, int posicionCalle, int posicionCarrera);
	public long registrarServicio(String paciente, TipoServicio tipoServicio, String telefono, TipoDireccion tipoDireccion, int calle, int carrera, int numero);
	public String asignarServicio(int codigoServicio);
	public boolean finalizarServicio(int codigoServicio);
	public boolean buscarAlgunoPosicion();
	public boolean buscarExisteServicios();
	public void mostrarReporteAmbulancias();
	public boolean mostrarServiciosNoAsignados();
	public boolean mostrarServiciosAsignados();
	public void mostrarServiciosIPSAmbulancia();
	public void mostrarIPSconServicios();
	public void mostrarPacientesAtendidos();
	public void estadisticasDeLasAmbulanciasDisponibles();
	public boolean validarServicioAsignado(int codigoServicio);

}
