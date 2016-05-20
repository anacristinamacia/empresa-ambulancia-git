package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;

import Controller.Controller;

public class ViewFinalizarServicio extends JPanel {

	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	
	/**
	 * Create the panel.
	 */
	public ViewFinalizarServicio(TestGUIAmbulancias ventanaPrincipal) {

		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
	}

}
