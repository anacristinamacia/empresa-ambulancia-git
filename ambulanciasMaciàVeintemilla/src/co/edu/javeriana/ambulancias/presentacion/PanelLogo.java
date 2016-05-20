package co.edu.javeriana.ambulancias.presentacion;

import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelLogo extends JPanel {

	public ImageIcon fondo;
	
	/**
	 * Create the panel.
	 */
	public PanelLogo() {

		/*File file = new File("LogoAmbulancias.png");
		if (file.exists()) {
			fondo = new ImageIcon("LogoAmbulancias.png");
		}
		else {
			JOptionPane.showMessageDialog(this, "No existe la imagen");
		}*/
	}
	
	/*public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		int posx = (getWidth()/2) - 20;
		int posy = (getHeight()/2) - 125;
		fondo.paintIcon(this, g, posx, posy);
	}*/

}
