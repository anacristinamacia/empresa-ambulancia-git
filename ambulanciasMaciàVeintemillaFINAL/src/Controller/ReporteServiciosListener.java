package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.anumerados.TipoServicio;
import co.edu.javeriana.ambulancias.negocio.Ambulancia;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaBasica;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaMedicalizada;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaNoMedicalizada;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaUCI;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.IPS;
import co.edu.javeriana.ambulancias.negocio.Servicio;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.Utils;

public class ReporteServiciosListener implements ActionListener {
	
	private TestGUIAmbulancias ventanaPrincipal;

	public ReporteServiciosListener(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Mostrar")) {
			actualizarContIPS ();
			actualizarContServicios();
			
		}
	}
	
	public void actualizarContServicios () {
		EmpresaAmbulancias tempEmpresa = (EmpresaAmbulancias) ventanaPrincipal.getEmpresaAmbulancias();
		String [][] temp = tempEmpresa.getTableServicios();
		ventanaPrincipal.getViewServicios().getViewReporteServicios().addRowToTableServicios(temp);
	}
	
	public void actualizarContIPS () {
		int codigo = 0;
		
		try {
			codigo = ventanaPrincipal.getViewServicios().getViewReporteServicios().getSelectedRowCodeServicio();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(ventanaPrincipal, "No Ha seleccionado nada", "ERROR", JOptionPane.ERROR_MESSAGE);
			actualizarContServicios();
			return;
		}
		
		EmpresaAmbulancias tempEmpresa = (EmpresaAmbulancias) ventanaPrincipal.getEmpresaAmbulancias();
		Servicio serv = tempEmpresa.getServicioById(codigo);
		IPS ipsTemp = serv.getIps();
		Ambulancia ambu = serv.getAmbulancia();
		
		if (ambu == null) {
			JOptionPane.showMessageDialog(ventanaPrincipal, "No tiene ambulancia asignada", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		if (serv == null) {
			JOptionPane.showMessageDialog(ventanaPrincipal, "No tiene servcio asignado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		String addIPS [][] = new String [1][3];
		String addAmbulancia [][] = ambuToMatrix(ambu);
		if (serv.getTipoServicio() != TipoServicio.DOMICILIO) {
			addIPS[0][0] = ipsTemp.getNombre();
			addIPS[0][1] = ipsTemp.getTipoAtencion();
			addIPS[0][2] = ipsTemp.getDireccion().toString();
		} else {
			addIPS[0][0] = " ";
			addIPS[0][1] = " ";
			addIPS[0][2] = " ";
		}
		
		ventanaPrincipal.getViewServicios().getViewReporteServicios().addRowToTableAmbulancias(addAmbulancia);
		ventanaPrincipal.getViewServicios().getViewReporteServicios().addRowToTableIPS(addIPS);
	
	}
	
	public String [][] ambuToMatrix (Ambulancia ambu) {
		String addAmbulancia [][] = new String [1][9];
		addAmbulancia[0][0] = String.valueOf(ambu.getCodigo());
		if (ambu instanceof AmbulanciaUCI) {
			addAmbulancia[0][1] ="UCI";
		}
		if (ambu instanceof AmbulanciaBasica) {
			addAmbulancia[0][1] ="Basica";
		}
		if (ambu instanceof AmbulanciaNoMedicalizada) {
			addAmbulancia[0][1] ="NoMedicalizada";
		}
		
		
		
		if (ambu instanceof AmbulanciaUCI) {
			addAmbulancia[0][2] = (((AmbulanciaUCI) ambu)).getTipoUCI() ;
		} else {
			addAmbulancia[0][2] ="NA";
		}
		addAmbulancia[0][3] =ambu.getPlaca();
		
		if (ambu instanceof AmbulanciaMedicalizada) {
			addAmbulancia[0][4] =((AmbulanciaMedicalizada) ambu).getMedico();
		}
		
		if (ambu instanceof AmbulanciaNoMedicalizada) {
			addAmbulancia[0][4] = ((AmbulanciaNoMedicalizada) ambu).getEnfermero();
		}
		
		addAmbulancia[0][5] = (Utils.formatDate(ambu.getHoraPosicion()));
		addAmbulancia[0][6] = String.valueOf(ambu.getPosicionCalle());
		addAmbulancia[0][7] = String.valueOf(ambu.getPosicionCarrera());
		addAmbulancia[0][8] = String.valueOf(ambu.calcularTarifa());
		
		return addAmbulancia;
	}

}
