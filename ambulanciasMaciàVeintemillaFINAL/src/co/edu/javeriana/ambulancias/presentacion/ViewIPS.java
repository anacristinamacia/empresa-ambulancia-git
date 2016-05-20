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
	private ViewIngresarIPS viewIngresarIPS;
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
	public ViewIngresarIPS getViewIngresarIPS() {
		return viewIngresarIPS;
	}
	public void setViewIngresarIPS(ViewIngresarIPS viewIngresarIPS) {
		this.viewIngresarIPS = viewIngresarIPS;
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
		tabbedPane.addTab("Men˙ IPS", null, viewMenuIPS, null);
		
		viewIngresarIPS = new ViewIngresarIPS();
		tabbedPane.addTab("Ingresar IPS", null, viewIngresarIPS, null);
		
		viewReporteIPS = new ViewReporteIPS();
		tabbedPane.addTab("IPS con Servicios", null, viewReporteIPS, null);
		

	}

}
