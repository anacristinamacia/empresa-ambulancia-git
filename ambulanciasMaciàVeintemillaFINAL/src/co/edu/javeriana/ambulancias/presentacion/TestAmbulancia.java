package co.edu.javeriana.ambulancias.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;

public class TestAmbulancia {

	public static void main(String[] args) {
		
		int opcion = -1;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(isr);
		IServiciosAmbulancias empresaAmbulancias = new EmpresaAmbulancias();
		Scanner scn = new Scanner(System.in);
		while (opcion != 12) {
			System.out.println("\t\tMENU EMPRESA AMBULANCIAS");
			System.out.println("1.\tIngresar las IPS al Sistema");
			System.out.println("2.\tIngresar las Ambulancias al Sistema");
			System.out.println("3.\tRegistrar la posicion actual de una Ambulancia");
			System.out.println("4.\tRegistrar un Servicio");
			System.out.println("5.\tReporte de Ambulancias");
			System.out.println("6.\tAsignar a un Servicio una Ambulancia y una IPS");
			System.out.println("7.\tFinalizar un Servicio");
			System.out.println("8.\tReporte de Servicios con IPS y Ambulancias asignados");
			System.out.println("9.\tReporte de las IPS con servicios asociados");
			System.out.println("10.\tEstadisticas de las Ambulancias disponibles");
			System.out.println("11.\tPacientes atendidos");
			System.out.println("12.\tTerminar");
			System.out.println();
			try {
				opcion = Integer.parseInt(input.readLine());
			} catch (Exception e) {
				System.out.println("Input invalido");
			}
			switch (opcion) {
			case 1:
				//ManejoArchivos.agregarTxtIPS(empresaAmbulancias);
				break;
			case 2:
				//ManejoArchivos.agregarTxtAmbulancia(empresaAmbulancias);
				break;
			case 3:
				int codigo = 0, calle = 0, carrera = 0;
				Date c1 = Utils.manejoFechas();
				System.out.println("Indique codigo: ");
				codigo = scn.nextInt();
				System.out.println("Indique calle: ");
				calle = scn.nextInt();
				System.out.println("Indique carrera: ");
				carrera = scn.nextInt();
				if(empresaAmbulancias.registrarPosicionAmbulancia(codigo, c1, calle, carrera))
					System.out.println("Exito en el registro de la posicion");
				else 
					System.out.println("La ambulancia con el codigo ingresado no existe");
				break;
			case 4:
				String paciente, telefono, tipoDireccion, tipoServicio = " ";
				int calle2, carrera2, numero;
				System.out.println("Indique el nombre del paciente (sin espacios): ");
				paciente = scn.next();
				System.out.println("Indique el tipo de Servicio (URGENCIA o EMERGENCIA o DOMICILIO): ");
				tipoServicio = scn.next();
				while (tipoServicio.compareTo("URGENCIA") != 0 && tipoServicio.compareTo("EMERGENCIA") != 0 && tipoServicio.compareTo("DOMICILIO") != 0) {
					System.out.println("Tipo de Sevicio ingresado incorrecto, intentelo de nuevo: ");
					tipoServicio = scn.next();
				}
				System.out.println("Indique el numero de telefono: ");
				telefono = scn.next();
				System.out.println("Indique el tipo de Direccion (CALLE o CARRERA): ");
				tipoDireccion = scn.next();
				while (tipoDireccion.compareTo("CALLE") != 0 && tipoDireccion.compareTo("CARRERA") != 0) {
					System.out.println("Tipo de Direccion ingresado incorrecto, intentelo de nuevo: ");
					tipoDireccion = scn.next();
				}
				System.out.println("Indique la Calle: ");
				calle2 = scn.nextInt();
				System.out.println("Indique la Carrera: ");
				carrera2 = scn.nextInt();
				System.out.println("Indique el Numero: ");
				numero = scn.nextInt();
				//System.out.println("El nuevo Servicio tiene codigo: " + empresaAmbulancias.registrarServicio(paciente, tipoServicio, telefono, tipoDireccion, calle2, carrera2, numero));
				break;
			case 5:
				if (empresaAmbulancias.buscarAlgunoPosicion()) {
					empresaAmbulancias.mostrarReporteAmbulancias();
				}
				else {
					System.out.println("No se encuentran Ambulancias registradas con posicion");
				}
				break;
			case 6:
				if (empresaAmbulancias.mostrarServiciosNoAsignados()) {
					System.out.println("Indique el codigo del servicio a asignar: ");
					int codigoServicio = scn.nextInt();
					System.out.println(empresaAmbulancias.asignarServicio(codigoServicio));
				}
				break;
			case 7:
				if (empresaAmbulancias.mostrarServiciosAsignados()) {
					System.out.println("Indique el codigo del servicio que desea finalizar: ");
					int codigoServicio = scn.nextInt();
					if (empresaAmbulancias.validarServicioAsignado(codigoServicio)) {
						empresaAmbulancias.finalizarServicio(codigoServicio);
					}
				}
				break;
			case 8:
				if (empresaAmbulancias.buscarExisteServicios())
					empresaAmbulancias.mostrarServiciosIPSAmbulancia();
				else 
					System.out.println("No se encuentran servicios registrados");
				break;
			case 9:
				empresaAmbulancias.mostrarIPSconServicios();
				break;
			case 10: 
				empresaAmbulancias.estadisticasDeLasAmbulanciasDisponibles();
				break;
			case 11:
				empresaAmbulancias.mostrarPacientesAtendidos();
				break;
			case 12: //Salir//
				break;
			default:
				break;
			}
		}
		
		

	}

}
