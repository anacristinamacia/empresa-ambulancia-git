package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;

public class ViewAmbulancias extends JPanel {

	
	private JPanel contentPane;
	private ViewMenuAmbulancias viewMenuAmbulancias;
	private ViewIngresarAmbulancias viewIngresarAmbulancias;
	private ViewRegistrarPosicion viewRegistrarPosicion;
	private JTabbedPane tabbedPane;
	private TestGUIAmbulancias ventanaPrincipal;
	/**
	 * Create the panel.
	 */
	public ViewAmbulancias(TestGUIAmbulancias ventanaPrincipal) {
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		this.ventanaPrincipal = ventanaPrincipal;
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.NORTH);
		
		viewMenuAmbulancias = new ViewMenuAmbulancias(this.ventanaPrincipal);
		tabbedPane.addTab("Menú Ambulancias", null, viewMenuAmbulancias, null);
		
		viewIngresarAmbulancias = new ViewIngresarAmbulancias();
		tabbedPane.addTab("Ingresar Ambulancias", null, viewIngresarAmbulancias, null);
		
		viewRegistrarPosicion = new ViewRegistrarPosicion(ventanaPrincipal);
		tabbedPane.addTab("Registrar Posición", null, viewRegistrarPosicion, null);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public ViewMenuAmbulancias getViewMenuAmbulancias() {
		return viewMenuAmbulancias;
	}

	public void setViewMenuAmbulancias(ViewMenuAmbulancias viewMenuAmbulancias) {
		this.viewMenuAmbulancias = viewMenuAmbulancias;
	}

	public ViewIngresarAmbulancias getViewIngresarAmbulancias() {
		return viewIngresarAmbulancias;
	}

	public void setViewIngresarAmbulancias(ViewIngresarAmbulancias viewIngresarAmbulancias) {
		this.viewIngresarAmbulancias = viewIngresarAmbulancias;
	}

	public ViewRegistrarPosicion getViewRegistrarPosicion() {
		return viewRegistrarPosicion;
	}

	public void setViewRegistrarPosicion(ViewRegistrarPosicion viewRegistrarPosicion) {
		this.viewRegistrarPosicion = viewRegistrarPosicion;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	
}
