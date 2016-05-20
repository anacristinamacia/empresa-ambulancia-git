package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.anumerados.TipoDireccion;
import co.edu.javeriana.ambulancias.anumerados.TipoServicio;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class RegistrarServicio implements ActionListener{

	private TestGUIAmbulancias ventanaPrincipal;
	
	public RegistrarServicio(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}

	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Aceptar")) {
			
		}
	}
	
	public void registrarServicio () {
		String paciente = null;
		TipoServicio tipoServicio = null;
		TipoDireccion tipoDir;
		int calle = 0, carrera = 0, numero = 0;
		try {
			paciente = String.valueOf(ventanaPrincipal.getViewServicios().getViewRegistrarServicios().getTextPaciente().getText());
		
			calle = Integer.parseInt(ventanaPrincipal.getViewServicios().getViewRegistrarServicios().getTextCalle().getText());
			carrera = Integer.parseInt(ventanaPrincipal.getViewServicios().getViewRegistrarServicios().getTextCarrera().getText());
			
		} catch (Exception e){
			JOptionPane.showMessageDialog(ventanaPrincipal, "Error en ingreso de Datos", "ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

}
