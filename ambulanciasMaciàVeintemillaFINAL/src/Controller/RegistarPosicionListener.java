package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class RegistarPosicionListener implements ActionListener {
	
	private TestGUIAmbulancias ventanaPrincipal;

	public RegistarPosicionListener(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}



	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Actualizar")) {
			actualizarAmbulancias();	
		}
		
		if (e.getActionCommand().equals("Registrar")) {
			int codigo = 0;
			try {
				codigo = ventanaPrincipal.getViewAmbulancias().getViewRegistrarPosicion().getSelectedRowCode();
			} catch (Exception exc) {
				System.out.println("No hay nada seleccionado");
			}
			registrarPosAmbulancia(codigo);
		}
		
	}
	
	public void actualizarAmbulancias () {
		EmpresaAmbulancias empresaTemp = (EmpresaAmbulancias) ventanaPrincipal.getEmpresaAmbulancias();
		String tempModel[][] = empresaTemp.getModelAmbulancias();
		ventanaPrincipal.getViewAmbulancias().getViewRegistrarPosicion().updateAmbulanciaModel(tempModel);
	}
	
	public void registrarPosAmbulancia (int codigo) {
		int calle = 0, carrera = 0;
		Date fechaActual = new Date();
		try {
			calle = Integer.parseInt(ventanaPrincipal.getViewAmbulancias().getViewRegistrarPosicion().getTxtCalle().getText());
			carrera = Integer.parseInt(ventanaPrincipal.getViewAmbulancias().getViewRegistrarPosicion().getTxtCarrera().getText());
			
		} catch (Exception e){
			JOptionPane.showMessageDialog (ventanaPrincipal, "Ingrese valores numéricos.", "ERROR",JOptionPane.ERROR_MESSAGE);
		}
		ventanaPrincipal.getEmpresaAmbulancias().registrarPosicionAmbulancia(codigo, fechaActual, calle, carrera);
		actualizarAmbulancias();
	}

}
