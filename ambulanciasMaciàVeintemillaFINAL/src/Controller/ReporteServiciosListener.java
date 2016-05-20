package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class ReporteServiciosListener implements ActionListener {
	
	private TestGUIAmbulancias ventanaPrincipal;

	public ReporteServiciosListener(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Mostrar")) {
			System.out.println("It Works!");
			actualizarContServicios();
		}
	}
	
	public void actualizarContServicios () {
		EmpresaAmbulancias tempEmpresa = (EmpresaAmbulancias) ventanaPrincipal.getEmpresaAmbulancias();
		String [][] temp = tempEmpresa.getTableServicios();
		ventanaPrincipal.getViewServicios().getViewReporteServicios().addRowToTableServicios(temp);
	}

}
