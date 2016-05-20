package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class ViewIPS extends JPanel {

	private JPanel contentPane;
	private ViewMenuIPS viewMenuIPS;
	private JTabbedPane tabbedPane;
	private ViewReporteIPS viewReporteIPS;
	private TestGUIAmbulancias ventanaPrincipal;
	
	public ViewMenuIPS getViewMenuIPS() {
		return viewMenuIPS;
	}
	public void setViewMenuIPS(ViewMenuIPS viewMenuIPS) {
		this.viewMenuIPS = viewMenuIPS;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	
	public ViewReporteIPS getViewReporteIPS() {
		return viewReporteIPS;
	}
	public void setViewReporteIPS(ViewReporteIPS viewReporteIPS) {
		this.viewReporteIPS = viewReporteIPS;
	}
	/**
	 * Create the panel.
	 */
	public ViewIPS(TestGUIAmbulancias ventanaPrincipal) {
		
		this.ventanaPrincipal = ventanaPrincipal;
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.NORTH);
		
		viewMenuIPS = new ViewMenuIPS(this.ventanaPrincipal);
		tabbedPane.addTab("Menu IPS", new ImageIcon(ViewIPS.class.getResource("/Iconos/Health_care_medicine2.png")), viewMenuIPS, null);

		
		viewReporteIPS = new ViewReporteIPS(this.ventanaPrincipal);
		tabbedPane.addTab("IPS con Servicios", new ImageIcon(ViewIPS.class.getResource("/Iconos/Hospital_medicine_health_vector.png")), viewReporteIPS, null);
		

	}

}
