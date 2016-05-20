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
import java.util.StringTokenizer;

import co.edu.javeriana.ambulancias.anumerados.TipoDireccion;
import co.edu.javeriana.ambulancias.anumerados.TipoUCI;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;

public class ManejoArchivos {
	/**
	 * La funcion lee el archivo IPS.txt y separa la informacion por tokens para luego llamar la funcion
	 * empresaAmbulancias.agregarIPS  con la informacion adecuada
	 * @param empresaAmbulancias Recibe un objeto de tipo IServiciosAmbulancias empresaAmbulancias para poder acceder a los metodos
	 */
	public static boolean agregarTxtIPS (IServiciosAmbulancias empresaAmbulancias, File file) {
		String nombre;
		String tipoAtencion;
		String tipoDir;
		TipoDireccion tipoDireccion;
		int calle;
		int carrera;
		int numero;
		try{
            FileInputStream fstream = new FileInputStream(file);
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
            		tipoDir = arreglo[2];
            		calle = Integer.parseInt(arreglo[3]);
            	    carrera = Integer.parseInt(arreglo[4]);
            	    numero = Integer.parseInt(arreglo[5]);
            	    if(tipoDir.compareTo("CALLE") == 0){
            	    	tipoDireccion = TipoDireccion.CALLE;
            	    }else if (tipoDir.compareTo("CARRERA") == 0);{
            	    		tipoDireccion = TipoDireccion.CARRERA;
            	    	}
            	    empresaAmbulancias.agregarIPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
            	}
            }
            entrada.close();
            return true;
        }catch (Exception e){
            return false;
        }
	}
	/**
	 * La funcion lee el archivo Ambulancias.txt y separa la informacion por tokens
	 * Valida el tipo de ambulancia que lee para luego llamar la funcion del respectivo tipo de ambulancia
	 * empresaAmbulancias.agregarAmbulancia con la informacion adecuada
	 * @param empresaAmbulancias Recibe un objeto de tipo IServiciosAmbulancias para porder acceder a los metodos
	 * @return 
	 */
	public static boolean agregarTxtAmbulancia (IServiciosAmbulancias empresaAmbulancias, File file) {
		String tipoAmbulancia;
		int codigo;
		String placa;
		String medicoEnf;
		String tipoUCI;
		TipoUCI uci;
		try{
            FileInputStream fstream = new FileInputStream(file);
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
            			if(tipoUCI.compareTo("CARDIOVASCULAR") == 0){
            				uci = TipoUCI.CARDIOVASCULAR;
            			}else if(tipoUCI.compareTo("PEDIATRICA") == 0){
            				uci = TipoUCI.PEDIATRICA;
            			}else{
            				return false;
            			}
            			empresaAmbulancias.agregarAmbulanciaUCI(codigo, placa, medicoEnf, uci);
            		}
            	}
            }
            entrada.close();
            return true;
        }catch (Exception e){
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
