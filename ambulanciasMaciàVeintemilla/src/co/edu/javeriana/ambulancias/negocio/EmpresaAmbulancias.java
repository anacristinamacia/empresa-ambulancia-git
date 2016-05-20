package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class EmpresaAmbulancias implements IServiciosAmbulancias, Serializable{

	private String nombre;
	private HashMap<Integer,Ambulancia> ambulancias;
	private HashMap<String,IPS> losIPS;
	private ArrayList<Servicio> servicios;
	
	// ** GETTERS & SETTERS EMPRESAAMBULANCIAS ** //
	/**
	 * Accede al atributo de tipo String nombre
	 * @return Retorna el valor de nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Le otorga un valor al atributo nombre
	 * @param nombre Recibe un String y se lo otorga al nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Accede a la coleccion map de tipo ambulancia 
	 * @return Retorna el map ambulancias
	 */
	public HashMap<Integer,Ambulancia> getAmbulancias() {
		return ambulancias;
	}
	/**
	 * Le otorga valores a la coleccion map ambulancias ambulancias
	 * @param ambulancias Recibe un map de tipo ambulancia y se la otorga a la lista ambulancias
	 */
	public void setAmbulancias(HashMap<Integer,Ambulancia> ambulancias) {
		this.ambulancias = ambulancias;
	}
	/**
	 * Accede a la coleccion map de tipo IPS LosIPS
	 * @return Retorna el map LosIPS
	 */
	public HashMap<String,IPS> getLosIPS() {
		return losIPS;
	}
	/**
	 * Le otorga valores al map LosIPS
	 * @param losIPS Recibe un map de tipo IPS y se la otorga a la coleccion LosIPS
	 */
	public void setLosIPS(HashMap<String,IPS> losIPS) {
		this.losIPS = losIPS;
	}
	/**
	 * Accede a la lista de tipo servicio servicios
	 * @return Retorna la lista servicios
	 */
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	/**
	 * Le otorga un valor a la lista servicios
	 * @param servicios Recibe una lista de tipo Servicio y se la otorga a la lista servicios
	 */
	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	// ** CONSTRUCTOR EMPRESA AMBULANCIAS ** //
	/**
	 * Construye un objeto de tipo empresa ambulancias e inicializa sus atributos
	 */
	public EmpresaAmbulancias () {
		this.nombre = " ";
		ambulancias = new HashMap<Integer,Ambulancia>();
		this.losIPS = new HashMap<String,IPS>();
		servicios = new ArrayList<Servicio>();
	}
	
	// ** METODOS ** //
	/// *** METODOS DE BUSCAR *** ///
	/**
	 * Este metodo recorre el ArrayList servicios y compara el codigo de cada posicion con el codigo que se pasa por parametro
	 * @param codigoServicio Recibe un numero entero 'codigoServicio' y este es comparado con cada elemento del ArrayList
	 * @return Retorna el servicio en la posicion que el codigo coinside o null cuando llega al final y no estaba el servicio con el codigo en la lista
	 */
	private Servicio buscarServicio (int codigoServicio) {
		for (int i = 0; i < servicios.size(); i++) {
			if (servicios.get(i).getCodigo() == codigoServicio) {
				return servicios.get(i);
			}
		}
		return null;
	}
	/**
	 * Este metodo recorre el  ArrayList servicios y busca las posiciones que tengan estado NO_ASIGNADO
	 * @return Retorna true si encuentra una posicion con el serivio en estado NO_ASIGNADO y false si no lo encuentra
	 */
	private boolean buscarNoAsignado () {
		for (int i = 0; i < servicios.size(); i++) {
			if (servicios.get(i).getEstado().compareTo("NO_ASIGNADO") == 0) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Este metodo recorre el  ArrayList servicios y busca si hay una posicion que tenga estado ASIGNADO
	 * @return Retorna true si encuentra una posicion con el serivio en estado ASIGNADO y false si no lo encuentra
	 */
	private boolean buscarAsignado () {
		for (int i = 0; i < servicios.size(); i++) {
			if (servicios.get(i).getEstado().compareTo("ASIGNADO") == 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Este metodo recorre la lista de Servicios de la ambulancia recibida y compara el estado con ASIGNADO
	 * @param ambulancia Recibe un objeto de tipo Ambulancia
	 * @return Retorna la posicion en la que tiene un Servicio en ASIGNADO
	 */
	private int buscarServiciodeAmbulancia (Ambulancia ambulancia) {
		if (!ambulancia.getListaServicios().isEmpty()) {
			for (int i = 0; i < ambulancia.getListaServicios().size(); i++) {
				if (ambulancia.getListaServicios().get(i).getEstado().compareTo("ASIGNADO") == 0) {
					return i;
				}
			}
		}
		return -1;
	}
	/**
	 * Este metodo recorre el HashMap de ambulancias buscando si alguna tiene una posicion registrada
	 * @return Retorna true si consigue alguna ambulancia con una posicion registrada
	 */
	public boolean buscarAlgunoPosicion () {
		Set<Integer> set = ambulancias.keySet();
		for (Integer key: set) {
			if (ambulancias.get(key).getPosicionCalle() != 0) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Este metodo verifica si existen servicios registrados
	 * @return Retorna true si tiene algun servicio registrado y false si esta vacia
	 */
	public boolean buscarExisteServicios () {
		if (servicios.isEmpty()) 
			return false;
		return true;
	}
	
	/// *** M√âTODOS DE AGREGAR *** ///
	/**
	 * Crea un objeto ips y lo agrega a la coleccion map losIPS
	 * @param nombre nombre de la ips que se va a crear
	 * @param tipoAtencion Atributo de la ips a crear
	 * @param tipoDireccion Atributo de la direccion de la ips
	 * @param calle atributo de la direccion de la ips
	 * @param carrera atributo de la direccion de la ips
	 * @param numero atributo de la direccion de la ips
	 */
	public void agregarIPS (String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero) {
		Direccion direccion = new Direccion(tipoDireccion, calle, carrera, numero);
		IPS ips = new IPS (nombre, tipoAtencion, direccion);
		losIPS.put(nombre, ips);
	}
	/**
	 * Crea una ambulanciaBasica y la agrega a la coleccion map ambulancias
	 * @param codigo Atributo de la ambulancia a crear
	 * @param placa Atributo de la ambulancia a crear
	 * @param medico Atributo de la ambulancia a crear
	 */
	public void agregarAmbulanciaBasica (int codigo, String placa, String medico) {
		AmbulanciaBasica ambulanciaB = new AmbulanciaBasica (codigo, placa, medico);
		ambulancias.put(codigo, ambulanciaB);
	}
	/**
	 * Crea una ambulanciaUCI y la agrega a la coleccon map ambulancias
	 * @param codigo Atributo de la ambulancia a crear
	 * @param placa Atributo de la ambulancia a crear
	 * @param medico Atributo de la ambulancia a crear
	 * @param tipoUCI Atributo de la ambulancia a crear
	 */
	public void agregarAmbulanciaUCI (int codigo, String placa, String medico, String tipoUCI) {
		AmbulanciaUCI ambulanciaUCI = new AmbulanciaUCI (codigo, placa, medico, tipoUCI);
		ambulancias.put(codigo, ambulanciaUCI);
	}
	/**
	 * Crea una ambulanciaNoMedicalizada y la agrega a la coleccion map ambulancias
	 * @param codigo Atributo de la ambulancia a crear
	 * @param placa Atributo de la ambulancia a crear
	 * @param enfermero Atributo de la ambulancia a crear
	 */
	public void agregarAmbulanciaNoMedicalizada (int codigo, String placa, String enfermero) {
		AmbulanciaNoMedicalizada ambulanciaNM = new AmbulanciaNoMedicalizada (codigo, placa, enfermero);
		ambulancias.put(codigo, ambulanciaNM);
	}
	
	/// *** MÉTODOS DE REGISTRAR *** ///
	/**
	 * Este metodo si el map ambulancias contiene codigo ingresado  y registra la posicion de la ambulancia en la hora actual
	 * @param codigo Recibe un int que corresponde al atributo codigo del objeto que se busca para aÒadir la posicion
	 * @param hora Recibe un Date que corresponde al atributo hora
	 * @param posicionCalle Recibe un int que corresponde al atributo posicionCalle de la ambulancia
	 * @param posicionCarrera Recibe un int que corresponde al atributo posicionCarrera de la ambulancia
	 * @return la funcion retorna true si se encuentra el codigo ingresado como parametro, si no, retorna false
	 */
	public boolean registrarPosicionAmbulancia (int codigo, Date hora, int posicionCalle, int posicionCarrera) {
		if(ambulancias.containsKey(codigo)){
			ambulancias.get(codigo).setHoraPosicion(hora);
			ambulancias.get(codigo).setPosicionCalle(posicionCalle);
			ambulancias.get(codigo).setPosicionCarrera(posicionCarrera);
			return true;
		}
		return false;
	}
	/**
	 * Este metodo utiliza la clase utils para invocar la funcion manejo de fechas. Con la fecha y los elementos que entran como parametro, crea un objeto servicio y lo agrega a la lista servicios
	 * @param paciente Recibe un String que corresponde al atributo paciente del objeto servicio que se desea a√íadir
	 * @param tipoServicio Recibe un String que corresponde al atributo tipoServicio del objeto servicio
	 * @param telefono Recibe un String que corresponde al atributo telefono del objeto que se crea en la funcion
	 * @param tipoDireccion Recibe un String que corresponde al atributo tipoDireccion del objeto servicio
	 * @param calle Recibe un int que corresponde a la calle que se requiere en el constructor de Servicio
	 * @param carrera Recibe un int que corresponde a la carrera que se requiere en el constructor de Servicio
	 * @param numero Recibe un int que corresponde a la numero que se requiere en el constructor de Servicio
	 * @return Retorna el codigo el cual le fue asignado al servicio
	 */
	public long registrarServicio (String paciente, String tipoServicio, String telefono, String tipoDireccion, int calle, int carrera, int numero) {
		Date horaSolicitud = Utils.manejoFechas();
		Servicio servicio = new Servicio(horaSolicitud, paciente, tipoServicio, telefono, "NO_ASIGNADO", tipoDireccion, calle, carrera, numero);
		servicios.add(servicio);
		return servicio.getCodigo();
	}
	
	/// *** METODOS DE ORDENAR *** ///
	/**
	 * Este metodo ordena la lista servicios por codigo
	 * @param serviciosIPS Recibe la lista serviciosIPS
	 * @return Retorna la lista servicios ordenada
	 */
	private ArrayList<Servicio> ordenarServiciosCodigo (ArrayList<Servicio> serviciosIPS) {
		Servicio servicioAux = null;
		for (int i = 0; i < serviciosIPS.size(); i++) {
			for (int j = 0; j < serviciosIPS.size() - 1; j++) {
				if (serviciosIPS.get(j).getCodigo() > serviciosIPS.get(j + 1).getCodigo()) {
					servicioAux.equals(serviciosIPS.get(j));
					serviciosIPS.get(j).equals(serviciosIPS.get(j + 1));
					serviciosIPS.get(j + 1).equals(servicioAux);
				}
			}
			
		}
		return serviciosIPS;
	}
	/**
	 * Este metodo ordena la lista servicios por hora de solicitud
	 * @param serviciosIPS Recibe la lista serviciosIPS
	 * @return Retorna la lista servicios ordenada
	 */
	private ArrayList<Servicio> ordenarServiciosHora (ArrayList<Servicio> serviciosIPS) {
		Servicio servicioAux = null;
		for (int i = 0; i < serviciosIPS.size(); i++) {
			for (int j = 0; j < serviciosIPS.size() - 1; j++) {
				if (serviciosIPS.get(j).getHoraSolicitud().after(serviciosIPS.get(j + 1).getHoraSolicitud())) {
					servicioAux.equals(serviciosIPS.get(j));
					serviciosIPS.get(j).equals(serviciosIPS.get(j + 1));
					serviciosIPS.get(j + 1).equals(servicioAux);
				}
			}
		}
		return serviciosIPS;
	}
	
	
	/// *** MÉTODOS DE MOSTRAR *** ///
	/**
	 * Este metodo organiza las ips con la ayuda de un TreeMap, recorre toda la coleccion map ordenada por nombre
	 * e imprime los atributos de la ips y la lista de servicios que tiene asiciadios
	 */
	public void mostrarIPSconServicios () {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd kk:mm");
		Map<String, IPS> sorted = new TreeMap(losIPS);
		Set<String> set = sorted.keySet();
		System.out.println("--IPS CON SERVICIOS ASOCIADOS--");
		System.out.println();
		for(String key: set) {
			System.out.println("IPS");
			System.out.println("Nombre\t\t\tTipoAtencion\t\tDireccion");
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.print(key);
			System.out.print("\t" + sorted.get(key).getTipoAtencion());
			if (sorted.get(key).getDireccion().getTipoDireccion().compareTo("CALLE") == 0) {
				System.out.println("\t\t" + sorted.get(key).getDireccion().getTipoDireccion() + " " + sorted.get(key).getDireccion().getCalle() + "#" + sorted.get(key).getDireccion().getCarrera() + "-" + sorted.get(key).getDireccion().getNumero());
			}
			else
				System.out.println("\t\t" + sorted.get(key).getDireccion().getTipoDireccion() + " " + sorted.get(key).getDireccion().getCarrera() + "#" + sorted.get(key).getDireccion().getCalle() + "-" + sorted.get(key).getDireccion().getNumero());
			System.out.println();
			if (!sorted.get(key).getListaServicios().isEmpty()) {
				System.out.println("\tSERVICIOS:");
				System.out.println("\tCodigo\tHoraSolicitud\t\tPaciente\tTipoServicio\tTelefono\tDireccion\t\tEstado\t\tAmbulancia");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
				sorted.get(key).setListaServicios(ordenarServiciosHora(sorted.get(key).getListaServicios()));
				for (int j = 0; j < sorted.get(key).getListaServicios().size(); j++) {
					System.out.print("\t" + sorted.get(key).getListaServicios().get(j).getCodigo() + "\t");
					System.out.print(sdf.format(sorted.get(key).getListaServicios().get(j).getHoraSolicitud()) + "\t\t");
					System.out.print(sorted.get(key).getListaServicios().get(j).getPaciente() + "\t");
					System.out.print(sorted.get(key).getListaServicios().get(j).getTipoServicio() + "\t");
					System.out.print(sorted.get(key).getListaServicios().get(j).getTelefono() + "\t\t");
					System.out.print(sorted.get(key).getListaServicios().get(j).getDireccion().getTipoDireccion() + sorted.get(key).getListaServicios().get(j).getDireccion().getCalle() + " # " + sorted.get(key).getListaServicios().get(j).getDireccion().getCarrera() + " - " + sorted.get(key).getListaServicios().get(j).getDireccion().getNumero() + "\t");
					System.out.print(sorted.get(key).getListaServicios().get(j).getEstado() + "\t");
					System.out.println(sorted.get(key).getListaServicios().get(j).getAmbulancia().getCodigo());
				}
				System.out.println();
			}
		
		}
	}
	/**
	 * Este metodo imprime los datos de cada servicio junto con su ambulancia e ips asignado en caso de estar asignado o haber sido finalizado.
	 * Recorre la lista de servicios e imrpime su ips y ambulancia asociada.
	 * Si la direccion es de tipo calle imprime calle/carrera/numero, si es carrera imprime carrera/calle/numero
	 * Para imprimir los datos de la ambulancia debe primero validar que tipo de ambulancia es y asi imprimir los datos respectivos
	 */
	public void mostrarServiciosIPSAmbulancia () {
		String medEnf = " ", tipoUCI = "\t";
		SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
		System.out.println("--REPORTE DE SERVICIOS CON IPS Y AMBULANCIAS ASOCIADAS--");
		System.out.println();
		for (int i = 0; i < servicios.size(); i++) {
			System.out.println("SERVICIO:");
			System.out.println("Codigo\tHoraSolicitud\tPaciente\tTipoServicio\tTelefono\tDireccion\t\tEstado\t\tValor");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.print(servicios.get(i).getCodigo() + "\t");
			System.out.print(sdf.format(servicios.get(i).getHoraSolicitud()) + "\t\t");
			System.out.print(servicios.get(i).getPaciente() + "\t\t");
			System.out.print(servicios.get(i).getTipoServicio() + "\t");
			System.out.print(servicios.get(i).getTelefono() + "\t\t");
			if (servicios.get(i).getDireccion().getTipoDireccion().compareTo("CALLE") == 0) {
				System.out.print(servicios.get(i).getDireccion().getTipoDireccion() + " " + servicios.get(i).getDireccion().getCalle() + "#" + servicios.get(i).getDireccion().getCarrera() + "-" + servicios.get(i).getDireccion().getNumero() + "\t\t");
			}
			else
				System.out.print(servicios.get(i).getDireccion().getTipoDireccion() + " " + servicios.get(i).getDireccion().getCarrera() + "#" + servicios.get(i).getDireccion().getCalle() + "-" + servicios.get(i).getDireccion().getNumero() + "\t\t");
			System.out.print(servicios.get(i).getEstado() + "\t");
				
			if (servicios.get(i).getEstado().compareTo("ASIGNADO") == 0 || servicios.get(i).getEstado().compareTo("FINALIZADO") == 0) {
				System.out.println(servicios.get(i).getValor());
				if (servicios.get(i).getTipoServicio().compareTo("DOMICILIO") != 0) {
					System.out.println("\tIPS asignada:");
					System.out.println("\tNombre\tTipoAtencion\tDireccion");
					System.out.println("\t----------------------------------------------------------------------------------------------------------------");
					System.out.print("\t" + servicios.get(i).getIps().getNombre() + "\t");
					System.out.print(servicios.get(i).getIps().getTipoAtencion() + "\t");
					if (servicios.get(i).getIps().getDireccion().getTipoDireccion().compareTo("CALLE") == 0) {
						System.out.println(servicios.get(i).getIps().getDireccion().getTipoDireccion() + " " + servicios.get(i).getIps().getDireccion().getCalle() + "#" + servicios.get(i).getIps().getDireccion().getCarrera() + "-" + servicios.get(i).getIps().getDireccion().getNumero());
					}
					else 
						System.out.println(servicios.get(i).getIps().getDireccion().getTipoDireccion() + " " + servicios.get(i).getIps().getDireccion().getCarrera() + "#" + servicios.get(i).getIps().getDireccion().getCalle() + "-" + servicios.get(i).getIps().getDireccion().getNumero());
				}
				
				System.out.println("\tAmbulancia asignada:");
				System.out.println("\tTipoAmbulancia\tCodigo\tPlaca\tMedico/Enfermero\tTipoUCI\tHoraPosicion\tCalle\tCarrera\t\tTarifa");
				System.out.println("\t----------------------------------------------------------------------------------------------------------------");
				if (servicios.get(i).getAmbulancia() instanceof AmbulanciaBasica) {
					AmbulanciaBasica ambulancia = (AmbulanciaBasica) servicios.get(i).getAmbulancia();
					System.out.print("\tBASICA\t\t");
					medEnf = ambulancia.getMedico();
				}
				if (servicios.get(i).getAmbulancia() instanceof AmbulanciaUCI) {
					AmbulanciaUCI ambulancia = (AmbulanciaUCI) servicios.get(i).getAmbulancia();
					System.out.print("\tUCI\t\t");
					medEnf = ambulancia.getMedico();
				}
				if (servicios.get(i).getAmbulancia() instanceof AmbulanciaNoMedicalizada) {
					AmbulanciaNoMedicalizada ambulancia = (AmbulanciaNoMedicalizada) servicios.get(i).getAmbulancia();
					System.out.print("\tNOMED\t\t");
					medEnf = ambulancia.getEnfermero();
				}
				System.out.print(servicios.get(i).getAmbulancia().getCodigo() + "\t");
				System.out.print(servicios.get(i).getAmbulancia().getPlaca() + "\t");
				System.out.print(medEnf + "\t");
				System.out.print(tipoUCI + "\t");
				System.out.print(sdf.format(servicios.get(i).getAmbulancia().getHoraPosicion()) + "\t\t");
				System.out.print(servicios.get(i).getAmbulancia().getPosicionCalle() + "\t\t");
				System.out.print(servicios.get(i).getAmbulancia().getPosicionCarrera() + "\t");
				System.out.println(servicios.get(i).getAmbulancia().calcularTarifa());
			}
			else {
				System.out.println();
			}
			System.out.println();
		}
	}
	/**
	 * El metodo recorre una lista de serivios y muestra los servicios en estado NO_ASIGNADO ara que el usuario escoja el servicio
	 * al que desea asignarle una ambulancia y una ips
	 * @return Retorna true cuando encuentra un servicio en NO_ASIGNADO y false si recorre toda la lista sin retornar true
	 */
	public boolean mostrarServiciosNoAsignados () {
		if (buscarNoAsignado()) {
			servicios.equals(ordenarServiciosHora(servicios));
			System.out.println("Codigo\tHoraSolicitud\tPaciente\tTipoServicio\tTelefono\tDireccion");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM kk:mm");
			for (int i = 0; i < servicios.size(); i++) {
				if (servicios.get(i).getEstado().compareTo("NO_ASIGNADO") == 0) {
					System.out.print(servicios.get(i).getCodigo() + "\t");
					System.out.print(sdf.format(servicios.get(i).getHoraSolicitud()) + "\t");
					System.out.print(servicios.get(i).getPaciente() + "\t\t");
					System.out.print(servicios.get(i).getTipoServicio() + "\t");
					System.out.print(servicios.get(i).getTelefono() + "\t\t");
					if (servicios.get(i).getDireccion().getTipoDireccion().compareTo("CALLE") == 0) {
						System.out.println(servicios.get(i).getDireccion().getTipoDireccion() + " " + servicios.get(i).getDireccion().getCalle() + "#" + servicios.get(i).getDireccion().getCarrera() + "-" + servicios.get(i).getDireccion().getNumero());
					}
					else {
						System.out.println(servicios.get(i).getDireccion().getTipoDireccion() + " " + servicios.get(i).getDireccion().getCarrera() + "#" + servicios.get(i).getDireccion().getCalle() + "-" + servicios.get(i).getDireccion().getNumero());
					}
					
				}
			}
			return true;
		}
		else { 
			System.out.println("No se encuentran servicios para ser asignados");
		}
		return false;
	}
	/**
	 * Este metodo recorre la lista de Servicios e imprime solo los que tengan estado ASIGNADO
	 * @return Retorna true si consiguio alguno que este en estado ASIGNADO y false si no consiguio ninguno e imprime un mensaje 
	 */
	public boolean mostrarServiciosAsignados () {
		if (buscarAsignado()) {
			servicios.equals(ordenarServiciosCodigo(servicios));
			System.out.println("Codigo\tPaciente\tAmbulancia\tIPS");
			for (int i = 0; i < servicios.size(); i++) {
				if (servicios.get(i).getEstado().compareTo("ASIGNADO") == 0) {
					System.out.print(servicios.get(i).getCodigo() + "\t");
					System.out.print(servicios.get(i).getPaciente() + "\t\t");
					System.out.print(servicios.get(i).getAmbulancia().getCodigo() + "\t");
					if (servicios.get(i).getTipoServicio().compareTo("DOMICILIO") != 0) {
						System.out.println(servicios.get(i).getIps().getNombre());
					}
					else {
						System.out.println();
					}
				}
			}
			return true;
		}
		else {
			System.out.println("No se encontraron Servicios para modificarse su estado a FINALIZADO");
			return false;
		}
	}
	/**
	 * Este metodo recorre la lista de de servicios e imprime los atributos del servicio.
	 * Luego valida si el servicios esta asignado o finalizado e imprime el medico de la ambulanicas si es ambulancia medicalizada
	 * o el enfermero si es no medicalizada
	 */
	public void mostrarPacientesAtendidos () {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM kk:mm");
		if (!servicios.isEmpty()) {
			servicios.equals(ordenarServiciosHora(servicios));
			System.out.println("--PACIENTES ATENDIDOS--");
			System.out.println("HoraSolicitud\tPaciente\tTipoServicio\tTelefono\tDireccion\tEstado\t\tMedico/Enfermero");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < servicios.size(); i++) {
				System.out.print(sdf.format(servicios.get(i).getHoraSolicitud()) + "\t");
				System.out.print(servicios.get(i).getPaciente() + "\t\t");
				System.out.print(servicios.get(i).getTipoServicio() + "\t");
				System.out.print(servicios.get(i).getTelefono() + "\t\t");
				if (servicios.get(i).getDireccion().getTipoDireccion().compareTo("CALLE") == 0) {
					System.out.print(servicios.get(i).getDireccion().getTipoDireccion() + " " + servicios.get(i).getDireccion().getCalle() + "#" + servicios.get(i).getDireccion().getCarrera() + "-" + servicios.get(i).getDireccion().getNumero() + "\t");
				}
				else {
					System.out.print(servicios.get(i).getDireccion().getTipoDireccion() + " " + servicios.get(i).getDireccion().getCarrera() + "#" + servicios.get(i).getDireccion().getCalle() + "-" + servicios.get(i).getDireccion().getNumero() + "\t");
				}
				System.out.print(servicios.get(i).getEstado() + "\t");
				if (servicios.get(i).getEstado().compareTo("ASIGNADO") == 0 || servicios.get(i).getEstado().compareTo("FINALIZADO") == 0) {
					if (servicios.get(i).getAmbulancia() instanceof AmbulanciaMedicalizada) {
						AmbulanciaMedicalizada ambulanciaM = (AmbulanciaMedicalizada) servicios.get(i).getAmbulancia();
						System.out.println(ambulanciaM.getMedico());
					}
					if (servicios.get(i).getAmbulancia() instanceof AmbulanciaNoMedicalizada) {
						AmbulanciaNoMedicalizada ambulanciaNM = (AmbulanciaNoMedicalizada) servicios.get(i).getAmbulancia();
						System.out.println(ambulanciaNM.getEnfermero());
					}
				}
				else {
					System.out.println();
				}
			}
		}
		else {
			System.out.println("No se encuentran servicios registrados");
		}
	}
	/**
	 * Este metodo recorre la coleccion ambulancias y cuenta cuantas ambulancias de tipo UCI, noMedicalizada y Basica hay
	 * con estado disponible y posicion registrada e imprime el contador de cada una
	 */
	public void estadisticasDeLasAmbulanciasDisponibles() {
		int basica = 0, uci =0, noMedi=0;
		if(!ambulancias.isEmpty()){
			Set<Integer> set = ambulancias.keySet();
			for(Integer key: set){
				if(ambulancias.get(key).isDisponible()){
					if(ambulancias.get(key).getPosicionCalle() != 0){
						if(ambulancias.get(key) instanceof AmbulanciaUCI){
							uci++;
						}
						if(ambulancias.get(key) instanceof AmbulanciaNoMedicalizada){
							noMedi++;
						}
						if(ambulancias.get(key) instanceof AmbulanciaBasica){
							basica++;
						}
					}
				}
			}
			int total = uci+basica+noMedi;
			if(total > 0){
				System.out.println("--ESTADISTICAS DE AMBULANCIAS DISPONIBLES--");
				System.out.println("Se encuentran " + total + " ambulancia(s) disponible(s)");
				System.out.println("\tBASICA\tUCI\tNO MEDICALIZADA");
				System.out.println("------------------------------------------------------------------");
				System.out.println("\t" + basica + "\t" + uci + "\t\t" + noMedi);
			}else
				System.out.println("No se encuentran ambulancias con posicion registrada");
		}else{
			System.out.println("No se encuentran ambulancias registradas");
		}
	}
	
	/**
	 * Este metodo ordena las ambulancias segun su codigo con ayuda de un TreeMap
	 * imprime los datos de las ambulancias que se han registrado su posicion validando el tipo de ambulancia e imprimientos sus respectivos atributos adicionales
	 */
	public void mostrarReporteAmbulancias () {
		SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
		System.out.println("--REPORTE DE AMBULANCIAS--");
		System.out.println();
		System.out.println("AMBULANCIAS:");
		System.out.println("Codigo\tPlaca\tMedico/Enfermero\tTipoUCI\t\tHoraPosicion\tPosicionCalle\tPosicionCarrera\tServicio");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
		Map<Integer, Ambulancia> sorted = new TreeMap(ambulancias);
		Set<Integer> set = sorted.keySet();
		for(Integer key: set){
			if(sorted.get(key).getPosicionCalle() != 0){
				System.out.print(key + "\t");
				System.out.print(sorted.get(key).getPlaca() + "\t");
				if (sorted.get(key) instanceof AmbulanciaMedicalizada) {
					AmbulanciaMedicalizada ambulanciaM = (AmbulanciaMedicalizada) sorted.get(key);
					System.out.print(ambulanciaM.getMedico() + "\t");
				}
				else {
					AmbulanciaNoMedicalizada ambulanciaNM = (AmbulanciaNoMedicalizada) sorted.get(key);
					System.out.print(ambulanciaNM.getEnfermero() + "\t");
				}
				if (sorted.get(key) instanceof AmbulanciaUCI) {
					AmbulanciaUCI ambulanciaUCI = (AmbulanciaUCI) sorted.get(key);
					System.out.print(ambulanciaUCI.getTipoUCI() + "\t");
				}
				else {
					System.out.print("\t\t\t");
				}
				System.out.print(sdf.format(sorted.get(key).getHoraPosicion()) + "\t\t");
				System.out.print(sorted.get(key).getPosicionCalle() + "\t\t");
				System.out.print(sorted.get(key).getPosicionCarrera() + "\t\t");
				if (buscarServiciodeAmbulancia(sorted.get(key)) != -1) {
					System.out.println(sorted.get(key).getListaServicios().get(buscarServiciodeAmbulancia(sorted.get(key))).getCodigo());
				}
				else 
					System.out.println();
			}
		}
		System.out.println();
	}
	
	/// *** METODOS DE CONSTRUIR *** ///
	/**
	 * Este metodo construye un ArrayList de tipo ambulancia validando si la ambulancia esta disponible
	 * con posicion registrada y segun el tipo de ambulancia y de servicio, valida si la ambulancia esta 
	 * disponible para el servicio
	 * @param servicio
	 * @return
	 */
	private ArrayList<Ambulancia> construirAmbulanciasDisponiblesServicio (Servicio servicio) {
		ArrayList<Ambulancia> ambulanciasDisponibles = new ArrayList<Ambulancia>();
		Set<Integer> set = ambulancias.keySet();
		for(Integer key: set) {
			if (ambulancias.get(key).isDisponible() && ambulancias.get(key).getPosicionCalle() != 0) {
				if (servicio.getTipoServicio().compareTo("EMERGENCIA") == 0 && ambulancias.get(key) instanceof AmbulanciaUCI) {
					ambulanciasDisponibles.add(ambulancias.get(key));
				}
				if (servicio.getTipoServicio().compareTo("URGENCIA") == 0 && ambulancias.get(key) instanceof AmbulanciaMedicalizada) {
					ambulanciasDisponibles.add(ambulancias.get(key));
				}
				if (servicio.getTipoServicio().compareTo("DOMICILIO") == 0) {
					ambulanciasDisponibles.add(ambulancias.get(key));
				}
			}
		}
		return ambulanciasDisponibles;
	}

	/// *** METODOS DE CALCULAR *** ///
	/**
	 *
	 * Este metodo calcula la distancia entre dos coordenadas
	 * @param calle1 Recibe un numero entero que correspone a la calle de la primera coordenada
	 * @param calle2 Recibe un int que corresponde a la calle de la segunda coordenada
	 * @param carrera1 Recibe un int que corresponde a la carrera de la primera coordenada
	 * @param carrera2 Recibe un int que corresponde a la carrera de la segunda coordenada
	 * @return La funcion retorna la suma del valor absoluto de la diferencia de las calles de ambas 
	 * 	       coordenadas y el valor absoluto de la diferencia de las carreras
	 */
	private long calcularDistancia (int calle1, int calle2, int carrera1, int carrera2) {
		return Math.abs(calle1 - calle2) + Math.abs(carrera1 - carrera2);
	}
	/**
	 * Este metodo calalcula la distancia entre cada ambulancia y el servicio con el metodo calcularDistancia y guarda la menor
	 * @param ambulanciasDisponibles Recibe la lista ambulanciasDisponibles para acceder a la posicion de las ambulancias que esten disponibles para atender el servicio
	 * @param calleS Recibe un entero calleS que es la calle del servicio
	 * @param carreraS Recibe un entero CarreraS que es el valor de la carrera del servicio
	 * @return Retorna la posicion de la ambulancia con menor distancia de la lista ambulanciasDisponibles
	 */
	private Ambulancia calcularAmbulanciaMasCercana (ArrayList<Ambulancia> ambulanciasDisponibles, int calleS, int carreraS) {
		int index = 0;
		long distanciaMenor = calcularDistancia(calleS, ambulanciasDisponibles.get(0).getPosicionCalle(), carreraS, ambulanciasDisponibles.get(0).getPosicionCarrera());
		for (int i = 1; i < ambulanciasDisponibles.size(); i++) {
			if (calcularDistancia(calleS, ambulanciasDisponibles.get(i).getPosicionCalle(), carreraS, ambulanciasDisponibles.get(i).getPosicionCarrera()) < distanciaMenor) {
				distanciaMenor = calcularDistancia(calleS, ambulanciasDisponibles.get(i).getPosicionCalle(), carreraS, ambulanciasDisponibles.get(i).getPosicionCarrera());
				index = i;
			}
		}
		return ambulanciasDisponibles.get(index);
	}
	/**
	 * El metodo recorre el map LosIPS, calcula la distancia entre la ips y el servicio con la funcion CalcularDistancia y toma como referencia de
	 * comparacion la distancia entre la ips en el indice 0 y el servicio
	 * @param calleS Recibe un entero con el valor de calleS que es la calle del servicio
	 * @param carreraS Recibe un entero con el valor de carreraS que es la carrera del servicio
	 * @return Retorna el elemento de la lista LosIPS en el indice con menor distancia
	 */

	private IPS calcularIPSmasCercano (int calleS, int carreraS) {
		long distanciaMenor = 0;
		int cont = 0;
		String ips = " ";
		Set<String> set = losIPS.keySet();
		for (String key: set) {
			if (distanciaMenor == 0 && cont == 0) {
				distanciaMenor = calcularDistancia(calleS, losIPS.get(key).getDireccion().getCalle(), carreraS, losIPS.get(key).getDireccion().getCarrera());
				cont++;
				ips = key;
			}
			if (calcularDistancia(calleS, losIPS.get(key).getDireccion().getCalle(), carreraS, losIPS.get(key).getDireccion().getCarrera()) < distanciaMenor) {
				distanciaMenor = calcularDistancia(calleS, losIPS.get(key).getDireccion().getCalle(), carreraS, losIPS.get(key).getDireccion().getCarrera());
				ips = key;
			}
		}
		return losIPS.get(ips);
	}
	

	/// *** MÉTODOS DE ASIGNAR *** ///
	/**
	 * Este metodo busca un codigo de servicio que este en estado NO_ASIGNADO, luego busca las ambulancias disponibles con el metodo construirAmbulanciasDisponibles
	 * luego busca la ips mas cercana. Finalmente asigna al serivicio la ambulancia y la ips, cambia la disponibilidad de la ambulancia el servicio
	 * lo cambia a asignado y aÒade el servicio a la ambulancia y a la ips.
	 * @param codigoServicio Recibe un codigo que pertenece al codigo del servicio al que se le va a asignar una ips y una ambulancia
	 * @return Retorna un String dependiendo de lo que ocurra en el progrma. 
	 * Si no encuentra el codigo que recibe como parametro retorna que el codigo no existe,
	 * si el servicio del codigo tiene estado asignado retorna que el codigo de servicio ya se encuentra asignado,
	 * si no hay elementos en ambulancasDisponibles retorna que no se encuenran ambulancias disponibles,
	 * si la funcion calcularIpsMasCercano retorna un objeto null retorna que no hay ips disponibles,
	 * finalmente, si logra asignar el servicio a la ambulancia y la ips retorna un mensaje con el codigo del servicio, el codigo de la ambulancia y el nombre de la ips
	 */
	public String asignarServicio (int codigoServicio) {
		String msj = " ";
		if (buscarServicio(codigoServicio) == null) {
			msj = "El codigo ingresado no existe";
		}
		if (buscarServicio(codigoServicio) != null && buscarServicio(codigoServicio).getEstado().compareTo("ASIGNADO") == 0) {
			msj = "El codigo de servicio ingresado ya se encuentra asignado";
		}
		if (buscarServicio(codigoServicio) != null && buscarServicio(codigoServicio).getEstado().compareTo("NO_ASIGNADO") == 0) {
			Servicio servicioAsignar = buscarServicio(codigoServicio);
			ArrayList<Ambulancia> ambulanciasDisponibles = construirAmbulanciasDisponiblesServicio(servicioAsignar);
			if (ambulanciasDisponibles.isEmpty()) {
				msj = "No se encuentran Ambulancias disponibles";
			}
			else {
				for (int i = 0; i < servicios.size(); i++) {
					if (servicios.get(i).equals(servicioAsignar)) {
						if (servicios.get(i).getTipoServicio().compareTo("DOMICILIO") != 0) {
							if (calcularIPSmasCercano(servicios.get(i).getDireccion().getCalle(), servicios.get(i).getDireccion().getCarrera()) == null) {
								msj = "No se encuentran IPS disponibles";
							}
							else {
								servicios.get(i).setAmbulancia(calcularAmbulanciaMasCercana(ambulanciasDisponibles, servicios.get(i).getDireccion().getCalle(), servicios.get(i).getDireccion().getCarrera()));
								ambulancias.get(servicios.get(i).getAmbulancia().getCodigo()).setDisponible(false);
								servicios.get(i).setEstado("ASIGNADO");
								ambulancias.get(servicios.get(i).getAmbulancia().getCodigo()).getListaServicios().add(servicios.get(i));
								servicios.get(i).setIps(calcularIPSmasCercano(servicios.get(i).getDireccion().getCalle(), servicios.get(i).getDireccion().getCarrera()));
								losIPS.get(servicios.get(i).getIps().getNombre()).getListaServicios().add(servicios.get(i));
								servicios.get(i).setValor(servicios.get(i).calcularValor(servicios.get(i).getAmbulancia()));
								msj = "El servicio de codigo " + servicios.get(i).getCodigo() + " le fue asignado la Ambulancia " + servicios.get(i).getAmbulancia().getCodigo() + " y la IPS " + servicios.get(i).getIps().getNombre();
							}
						}
						else {
							servicios.get(i).setAmbulancia(calcularAmbulanciaMasCercana(ambulanciasDisponibles, servicios.get(i).getDireccion().getCalle(), servicios.get(i).getDireccion().getCarrera()));
							ambulancias.get(servicios.get(i).getAmbulancia().getCodigo()).setDisponible(false);
							servicios.get(i).setEstado("ASIGNADO");
							ambulancias.get(servicios.get(i).getAmbulancia().getCodigo()).getListaServicios().add(servicios.get(i));
							servicios.get(i).setValor(servicios.get(i).calcularValor(servicios.get(i).getAmbulancia()));
							msj = "El servicio de codigo " + servicios.get(i).getCodigo() + " le fue asignado la Ambulancia " + servicios.get(i).getAmbulancia().getCodigo();
						}
					}
				}
			}
		}
		return msj;
	}
	
	/// *** METDOS DE VALIDAR *** ///
	/**
	 * Este metodo recorre la lista de servicios para validar que el codigo ingresado exista
	 * @param codigoServicio Recibe un entero con el codigoServicio que implica el codigo del servicio indicado por el usuario
	 * @return Retorna true si lo consiguio y en estado ASIGNADO, si lo consigue y no esta en ASIGNADO retorna un mensaje y false y retorna false si no existe en codigo y un mensaje
	 */
	public boolean validarServicioAsignado (int codigoServicio) {
		for (int i = 0; i < servicios.size(); i++) {
			if (servicios.get(i).getCodigo() == codigoServicio) {
				if (servicios.get(i).getEstado().compareTo("ASIGNADO") == 0) {
					return true;
				}
				else {
					System.out.println("El servicio no se encuentra ASIGNADO para poder ser finalizado");
					return false;
				}
			}
		}
		System.out.println("El codigo ingresado no existe");
		return false;
	}

	/// *** METODOS DE FINALIZAR *** ///
	/**
	 * Este metodo recorre la lista de servicios y cuando encuentra el codigo cambia el estado a FINALIZADO
	 * @param codigoServicio Recibe un entero con codigoServicio que implica el codigo del servicio que el usuario desea terminar
	 * @return Retorna true si consiguio el servicio segun el codigo y un mensaje de exito en finalizar el servicio
	 */
	public boolean finalizarServicio (int codigoServicio) {
		for (int i = 0; i < servicios.size(); i++) {
			if (servicios.get(i).getCodigo() == codigoServicio) {
				servicios.get(i).setEstado("FINALIZADO");
				int key = servicios.get(i).getAmbulancia().getCodigo();
				for (int k = 0; k < ambulancias.get(key).getListaServicios().size(); k++) {
					if (ambulancias.get(key).getListaServicios().get(k).getCodigo() == codigoServicio) {
						ambulancias.get(key).getListaServicios().get(k).setEstado("FINALIZADO");
					}
				}
				if (servicios.get(i).getTipoServicio().compareTo("DOMICILIO") != 0) {
					String key1 = servicios.get(i).getIps().getNombre();
					for (int k = 0; k < losIPS.get(key1).getListaServicios().size(); k++) {
						if (losIPS.get(key1).getListaServicios().get(k).getCodigo() == codigoServicio) {
							losIPS.get(key1).getListaServicios().get(k).setEstado("FINALIZADO");
						}
					}
				}
				System.out.println("Exito en finalizar el servicio " + codigoServicio);
				return true;
			}
		}
		return false;
	}
	
	// Method colaboration with Juan Pablo Penaloza 
	
	public String [][] getModelAmbulancias () {
		ArrayList < ArrayList <String> > tableAmbulancias = new ArrayList< ArrayList <String> >();
		
		TreeSet<Integer> keys = new TreeSet<Integer>(ambulancias.keySet());
		
		for (Integer key : keys) {
			Ambulancia ambu = ambulancias.get(key);
			ArrayList <String> tempArray = new ArrayList<String>();
			tempArray.add(String.valueOf(key));
			if (ambu instanceof AmbulanciaUCI) {
				tempArray.add("UCI");
			}
			if (ambu instanceof AmbulanciaBasica) {
				tempArray.add("Basica");
			}
			if (ambu instanceof AmbulanciaNoMedicalizada) {
				tempArray.add("NoMedicalizada");
			}
			
			
			
			if (ambu instanceof AmbulanciaUCI) {
				tempArray.add( ((AmbulanciaUCI) ambu).getTipoUCI() );
			} else {
				tempArray.add("NA");
			}
			tempArray.add(ambu.getPlaca());
			
			if (ambu instanceof AmbulanciaMedicalizada) {
				tempArray.add(((AmbulanciaMedicalizada) ambu).getMedico());
			}
			
			if (ambu instanceof AmbulanciaNoMedicalizada) {
				tempArray.add(((AmbulanciaNoMedicalizada) ambu).getEnfermero());
			}
			
			tempArray.add(Utils.formatDate(ambu.getHoraPosicion()));
			tempArray.add( String.valueOf(ambu.getPosicionCalle()) );
			tempArray.add(String.valueOf(ambu.getPosicionCarrera()));
			tempArray.add(String.valueOf(ambu.calcularTarifa())); // new
			
			tableAmbulancias.add(tempArray);
			
		}
		String[][] table = new String[tableAmbulancias.size()][];
		int cont = 0;
		for (int i = tableAmbulancias.size() - 1; i >= 0; i--) {
		    ArrayList<String> row = tableAmbulancias.get(i);
		    table[cont++] = row.toArray(new String[row.size()]);
		} 
		
		return table;
		 
	}
}
