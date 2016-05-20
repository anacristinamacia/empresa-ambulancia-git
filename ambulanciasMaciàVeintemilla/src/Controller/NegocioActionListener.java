package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class NegocioActionListener implements ActionListener{

	private TestGUIAmbulancias ventanaPrincipal;
	
	
	public NegocioActionListener(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar datos del Sistema")) {
			ventanaPrincipal.salvarDatos();
		}
		if (e.getActionCommand().equals("Cargar datos al Sistema")) {
			ventanaPrincipal.cargarDatos();
		}
	}

}
