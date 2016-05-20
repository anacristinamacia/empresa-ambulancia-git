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

	public void actionPerformed(ActionEvent e) {
		EmpresaAmbulancias empresaTemp = (EmpresaAmbulancias) ventanaPrincipal.getEmpresaAmbulancias();
		if (e.getActionCommand().equals("Actualizar")) {
			cargarTablas();	
			System.out.println("Actualizar");
		}
		if (e.getActionCommand().equals("Aceptar")) {
			
			int codigo = 0;
			try {
				codigo = ventanaPrincipal.getViewServicios().getViewAsignarServicio().getSelectedRowCode();
			} catch (Exception exc){
				System.out.println("No hay nada seleccionado");
			}
			
			empresaTemp.asignarServicio(codigo);
			System.out.println("CODIGO: " + codigo);
			cargarTablas();
		}
		
	}	
	public void cargarTablas(){
		EmpresaAmbulancias empresaTemp = (EmpresaAmbulancias) ventanaPrincipal.getEmpresaAmbulancias();
		String tempModel [][] = empresaTemp.getModelIPS();
		System.out.println("CONTENDIDO MAT: " + tempModel[0][0]);
		ventanaPrincipal.getViewServicios().getViewAsignarServicio().updateIPSModel(tempModel);
		String servtemp [][] = empresaTemp.getTableServicios();
		ventanaPrincipal.getViewServicios().getViewAsignarServicio().updateServModel(servtemp);
		String ambtemp [][] = empresaTemp.getModelAmbulancias();
		ventanaPrincipal.getViewServicios().getViewAsignarServicio().updateAmbulanciaModel(ambtemp);
	}
}
