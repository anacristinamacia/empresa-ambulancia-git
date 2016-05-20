package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class AsignarServicioListener implements ActionListener{
	
	TestGUIAmbulancias ventanaPrincipal;
	
	public AsignarServicioListener(TestGUIAmbulancias ventanaPrincipal){
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void actionPerformed(ActionEvent arg0) {
		ventanaPrincipal.getViewServicios().getTabbedPane().setSelectedIndex(2);
		
	}	
	public void cargarTablas(){
		String m[][] ;
		EmpresaAmbulancias ea = (EmpresaAmbulancias)ventanaPrincipal.getEmpresaAmbulancias();
		ventanaPrincipal.getViewServicios().getViewAsignarServicio().getTablaIPS().setModel((new DefaultTableModel((ea.getModelIPS()), (ventanaPrincipal.getViewServicios().getViewAsignarServicio().getLablesIPS()))));
	}
}
