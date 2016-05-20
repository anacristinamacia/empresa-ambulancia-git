package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class RegistarPosicionListener implements ActionListener {
	
	private TestGUIAmbulancias ventanaPrincipal;

	public RegistarPosicionListener(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(ventanaPrincipal.getViewAmbulancias().getViewRegistrarPosicion().getBtnActualizar())) {
			
		}
		
	}
	
	public void actualizarAmbulancias () {
		EmpresaAmbulancias empresaTemp = (EmpresaAmbulancias) ventanaPrincipal.getEmpresaAmbulancias();
		String tempModel[][] = empresaTemp.getModelAmbulancias();
		ventanaPrincipal.getViewAmbulancias().getViewRegistrarPosicion().updateAmbulanciaModel(tempModel);
	}

}
