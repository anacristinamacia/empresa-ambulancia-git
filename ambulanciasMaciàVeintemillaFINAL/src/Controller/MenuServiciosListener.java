package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class MenuServiciosListener implements ActionListener{

	private TestGUIAmbulancias ventanaPrincipal;
	
	public MenuServiciosListener(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Registrar Servicio")) {
			ventanaPrincipal.getViewServicios().getTabbedPane().setSelectedIndex(1);
		}
	}

}
