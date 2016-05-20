package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class MenuAmbulanciasListener implements ActionListener{

	private TestGUIAmbulancias ventanaPrincipal;

	public MenuAmbulanciasListener (TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Registrar Posicion")) {
			ventanaPrincipal.getViewAmbulancias().getTabbedPane().setSelectedIndex(1);
		}
	
	}
	
	

}
