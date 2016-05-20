package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;
import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class OpenFileActionListener implements ActionListener{

	private TestGUIAmbulancias ventanaPrincipal;
	
	public OpenFileActionListener(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean result;
		JFileChooser filechooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT file", "txt");
		filechooser.setFileFilter(filter);
		filechooser.setCurrentDirectory(new File("."));
		int returnVal = filechooser.showOpenDialog(ventanaPrincipal);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			//------------------------------------------------------------------------
			//invoca la logica de negocio que carga el archivo de productos
			if(e.equals(ventanaPrincipal.getViewIPS().getViewMenuIPS().getBtnIngresarIps())){
				result = ManejoArchivos.agregarTxtIPS(ventanaPrincipal.getEmpresaAmbulancias());
			}else{
				result = ManejoArchivos.agregarTxtAmbulancia(ventanaPrincipal.getEmpresaAmbulancias());
			}
			
			//------------------------------------------------------------------------
			if (result){
				JOptionPane.showMessageDialog(ventanaPrincipal, "File loaded correctly");
			}
			else{
				JOptionPane.showMessageDialog(ventanaPrincipal, "Error loading file");
			}
			
		} else {
			JOptionPane.showMessageDialog(ventanaPrincipal, "You didn't select a file to open...");
		}
	}

}
