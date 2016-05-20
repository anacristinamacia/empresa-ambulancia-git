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
			if (!ventanaPrincipal.getViewServicios().equals(null)) {
				System.out.println("view servicios dif de null");
				if (!ventanaPrincipal.getViewServicios().getViewMenuServicios().equals(null)) {
					System.out.println("view menu serv dif de null");
					if (!ventanaPrincipal.getViewServicios().getViewMenuServicios().getBtnRegistrarServicio().equals(null)) {
						System.out.println("boton difer a null");
						ventanaPrincipal.getViewServicios().getTabbedPane().setSelectedIndex(1);
					}
				}
			}
		}
		
		
	}

}
