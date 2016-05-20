package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servicio implements Serializable{

	private static long CONSECUTIVO = 1;
	private long codigo;
	private Date horaSolicitud;
	private String paciente;
	private String tipoServicio;
	private String telefono;
	private String estado;
	private double valor;
	private Direccion direccion;
	private Ambulancia ambulancia;
	private IPS ips;
	
	// ** GETTERS & SETTERS ** //
	/**
	 * Acceder al atributo valor de esta clase
	 * @return retorna el valor del atributo
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * Da valor al atributo valor de esta clase
	 * @param valor Recibe un double y se lo asigna al atributo
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * Accede al atributo de tipo entero codigo
	 * @return Retorna el valor de codigo
	 */
	public long getCodigo() {
		return codigo;
	}
	
	/**
	 * Le otorga un valor al atributo codigo
	 * @param codigo Recibe un long y se lo otorga al atributo
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	/**
	 * Accede al atributo de tipo Date horaSolicitud
	 * @return Retorna el valor de horaSolicitud
	 */
	public Date getHoraSolicitud() {
		return horaSolicitud;
	}
	/**
	 * Le otorga un valor al atributo horaSolicitud
	 * @param horaSolicitud Recibe un Date y se lo otorga al atributo
	 */
	public void setHoraSolicitud(Date horaSolicitud) {
		this.horaSolicitud = horaSolicitud;
	}
	/**
	 * Accede al atributo de tipo String paciente
	 * @return Retorna el valor de paciente
	 */
	public String getPaciente() {
		return paciente;
	}
	/**
	 * Le otorga un valor al atributo paciente
	 * @param paciente Recibe un String y se lo otorga al atributo
	 */
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	/**
	 * Accede al atributo de tipo String tipoServicio
	 * @return Retorna el valor de tipoServicio
	 */
	public String getTipoServicio() {
		return tipoServicio;
	}
	/**
	 * Le otorga un valor al atributo tipoServicio
	 * @param tipoServicio Recibe un String y se lo otorga al atributo
	 */
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	/**
	 * Accede al atributo de tipo String telefono
	 * @return Retorna el valor de telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Le otorga un valor al atributo telefono
	 * @param telefono Recibe un String y se lo otorga al atributo
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Accede al atributo de tipo String estado
	 * @return Retorna el valor de estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Le otorga un valor al atributo estado
	 * @param estado Recibe un String y se lo otorga al atributo
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * Accede al atributo de tipo Direccion direccion
	 * @return Retorna el valor de direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	/**
	 * Le otorga un valor al atributo direccion
	 * @param direccion Recibe un Direccion y se lo otorga al atributo
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	/**
	 * Accede al atributo de tipo Ambulancia ambulancia
	 * @return Retorna el valor de ambulancia
	 */
	public Ambulancia getAmbulancia() {
		return ambulancia;
	}
	/**
	 * Le otorga un valor al atributo ambulancia
	 * @param ambulancia Recibe un Ambulancia y se lo otorga al atributo
	 */
	public void setAmbulancia(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}
	/**
	 * Accede al atributo de tipo IPS ips
	 * @return Retorna el valor de ips
	 */
	public IPS getIps() {
		return ips;
	}
	/**
	 * Le otorga un valor al atributo ips
	 * @param ips Recibe un IPS y se lo otorga al atributo
	 */
	public void setIps(IPS ips) {
		this.ips = ips;
	}
	
	// ** CONSTRUCTOR SERVICIO ** //
	/**
	 * Construye un objeto de tipo Servicio y le da valor a sus atributos
	 * @param horaSolicitud Recibe un Date y se lo otorga al atributo horaSolicitud
	 * @param paciente Recibe un String y se lo otorga al atributo paciente
	 * @param tipoServicio Recibe un String y se lo otorga al atributo tipoServicio
	 * @param telefono Recibe un String y se lo otorga al atributo telefono
	 * @param estado Recibe un String y se lo otorga al atributo estado
	 * @param tipoDireccion Recibe un String y se lo otorga al atributo tipoDireccion
	 * @param calle Recibe un in y se lo otorga al atributo calle
	 * @param carrera Recibe un in y se lo otorga al atributo carrera
	 * @param numero Recibe un in y se lo otorga al atributo numero
	 */
	public Servicio(Date horaSolicitud, String paciente, String tipoServicio,
			String telefono, String estado, String tipoDireccion, int calle, int carrera, int numero) {
		this.codigo = CONSECUTIVO++;
		this.horaSolicitud = horaSolicitud;
		this.paciente = paciente;
		this.tipoServicio = tipoServicio;
		this.telefono = telefono;
		this.estado = estado;
		this.valor = 0;
		this.direccion = new Direccion (tipoDireccion, calle, carrera, numero);
		this.ambulancia = null;
		this.ips = null;
	}
	/**
	 * implementa formato a la fecha
	 * @return Retorna un String con los atributos de la clase
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM kk:mm");
		return "Servicio [codigo=" + codigo + ", horaSolicitud=" + sdf.format(horaSolicitud) + ", paciente=" + paciente
				+ ", tipoServicio=" + tipoServicio + ", telefono=" + telefono + ", estado = " + estado + ", " + direccion.toString();
	}
	
	// ** METODOS ** //
	/**
	 * Calcula el valor del servicio segun la tarifa de la ambulancia y la hora de solicitud
	 * @param ambulancia Recibe el objeto de tipo ambulancia al que se le va a calcular la tarifa
	 * @return retorna el valor calculado
	 */
	@SuppressWarnings("deprecation")
	public double calcularValor (Ambulancia ambulancia) {
		if (horaSolicitud.getDay() == 0 || horaSolicitud.getDay() == 6) {
			return ambulancia.calcularTarifa() * 1.2;
		}
		return ambulancia.calcularTarifa();
	}
	
	
}
