package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class FinalizarServicioListener implements ActionListener{

	private TestGUIAmbulancias ventanaPrincipal;
	
	public FinalizarServicioListener(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Finalizar")) {
			int codigo = 0;
			try {
				codigo = ventanaPrincipal.getViewServicios().getViewFinalizarServicio().getSelectedRowCode();
			} catch (Exception exc) {
				System.out.println("No hay nada seleccionado");
			}
			ventanaPrincipal.getEmpresaAmbulancias().finalizarServicio(codigo);
			actualizarServicios();
		}
	}
	
	public void actualizarServicios () {
		EmpresaAmbulancias empresaTemp = (EmpresaAmbulancias) ventanaPrincipal.getEmpresaAmbulancias();
		String tempModel[][] = empresaTemp.getModelAmbulancias();
		ventanaPrincipal.getViewAmbulancias().getViewRegistrarPosicion().updateAmbulanciaModel(tempModel);
	}
	
	

}
