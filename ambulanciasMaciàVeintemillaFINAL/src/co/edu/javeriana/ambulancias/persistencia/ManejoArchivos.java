package co.edu.javeriana.ambulancias.persistencia;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;

public class ManejoArchivos {
	/**
	 * La funcion lee el archivo IPS.txt y separa la informacion por tokens para luego llamar la funcion
	 * empresaAmbulancias.agregarIPS  con la informacion adecuada
	 * @param empresaAmbulancias Recibe un objeto de tipo IServiciosAmbulancias empresaAmbulancias para poder acceder a los metodos
	 */
	public static boolean agregarTxtIPS (IServiciosAmbulancias empresaAmbulancias) {
		String nombre;
		String tipoAtencion;
		String tipoDireccion;
		int calle;
		int carrera;
		int numero;
		String nombreArchivo;
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese el nombre del archivo");
		String nombreArch = scn.nextLine();
		
		try{
            FileInputStream fstream = new FileInputStream("./" + nombreArch);
            DataInputStream entrada = new DataInputStream(fstream);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            String delimitador = "-*";
            while ((strLinea = buffer.readLine()) != null)   {
            	if (strLinea.charAt(0) != '#' && strLinea.charAt(0) != '0') {
            		StringTokenizer st = new StringTokenizer (strLinea,"-*",false);
            		String[] arreglo = new String[st.countTokens()];
            		for (int i = 0; i < arreglo.length; i++) {
            			arreglo[i] = st.nextToken(delimitador);
            		}
            		nombre = arreglo[0];
            		tipoAtencion = arreglo[1];
            		tipoDireccion = arreglo[2];
            		calle = Integer.parseInt(arreglo[3]);
            	    carrera = Integer.parseInt(arreglo[4]);
            	    numero = Integer.parseInt(arreglo[5]);
            	    empresaAmbulancias.agregarIPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
            	}
            }
            entrada.close();
            return true;
        }catch (Exception e){ 
            System.err.println("Ocurrio un error: " + e.getMessage());
            return false;
        }
	}
	/**
	 * La funcion lee el archivo Ambulancias.txt y separa la informacion por tokens
	 * Valida el tipo de ambulancia que lee para luego llamar la funcion del respectivo tipo de ambulancia
	 * empresaAmbulancias.agregarAmbulancia con la informacion adecuada
	 * @param empresaAmbulancias Recibe un objeto de tipo IServiciosAmbulancias para porder acceder a los metodos
	 */
	public static boolean agregarTxtAmbulancia (IServiciosAmbulancias empresaAmbulancias) {
		String tipoAmbulancia;
		int codigo;
		String placa;
		String medicoEnf;
		String tipoUCI;
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese el nombre del archivo");
		String nombreArch = scn.nextLine();
		try{
            FileInputStream fstream = new FileInputStream("./" + nombreArch);
            DataInputStream entrada = new DataInputStream(fstream);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            String delimitador = "*";
            while ((strLinea = buffer.readLine()) != null)   {
            	if (strLinea.charAt(0) != '#' && strLinea.charAt(0) != '0') {
            		StringTokenizer st = new StringTokenizer (strLinea,"*",false);
            		String[] arreglo = new String[st.countTokens()];
            		for (int i = 0; i < arreglo.length; i++) {
            			arreglo[i] = st.nextToken(delimitador);
            		}
            		tipoAmbulancia = arreglo[0];
            		codigo = Integer.parseInt(arreglo[1]);
            		placa = arreglo[2];
            		medicoEnf = arreglo[3];
            		if (tipoAmbulancia.compareTo("BASICA") == 0) {
            			empresaAmbulancias.agregarAmbulanciaBasica(codigo, placa, medicoEnf);
            		}
            		if (tipoAmbulancia.compareTo("NOMEDICALIZADA") == 0) {
            			empresaAmbulancias.agregarAmbulanciaNoMedicalizada(codigo, placa, medicoEnf);
            		}
            		if (tipoAmbulancia.compareTo("UCI") == 0) {
            			tipoUCI = arreglo[4];
            			empresaAmbulancias.agregarAmbulanciaUCI(codigo, placa, medicoEnf, tipoUCI);
            		}
            	}
            }
            entrada.close();
            return true;
        }catch (Exception e){ 
            System.err.println("Ocurrio un error: " + e.getMessage());
            return false;
        }
	}
	public static void guardarDatos(IServiciosAmbulancias empresaAmbulancias, String pathArchivo,
			String nombreArchivo) {
		// TODO Auto-generated method stub
		File outFile = new File(pathArchivo + System.getProperty("file.separator") + nombreArchivo);
		FileOutputStream outStream = null;
		ObjectOutputStream dataOutStream = null;
		try {
			outStream = new FileOutputStream(outFile);
			dataOutStream = new ObjectOutputStream(outStream);
			dataOutStream.writeObject(empresaAmbulancias);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error en ruta de archivo:" + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Error grabando el archivo:" + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("excepcion inesperada:" + e.getMessage());
		}
		finally {
			try {
				dataOutStream.close();
				outStream.close();
			}
			catch (IOException e) {
				System.out.println("excepcion cerrando el archivo:" + e.getMessage());
			}
		}
	}
	public static IServiciosAmbulancias cargarDatos (String pathArchivo, String nombreArchivo) {

		File inFile = new File(pathArchivo+System.getProperty("file.separator")+nombreArchivo);
		FileInputStream inStream = null;
		ObjectInputStream dataInStream = null;
		IServiciosAmbulancias empresaAmbulancias =null;
		try {
			inStream = new FileInputStream(inFile);
			dataInStream = new ObjectInputStream(inStream);
			empresaAmbulancias = (EmpresaAmbulancias)dataInStream.readObject();

		}
		catch (FileNotFoundException e) {
			System.out.println("Error en ruta de archivo:" + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Error leyendo del archivo:" + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("excepcion inesperada:" + e.getMessage());
		}
		finally {
			try {
				dataInStream.close();
				inStream.close();
			}
			catch (IOException e) {
				System.out.println("excepcion cerrando el archivo:" + e.getMessage());
			}
		} 
		return empresaAmbulancias;
	}
}
