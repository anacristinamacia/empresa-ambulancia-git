package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ViewServicios extends JPanel {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private ViewMenuServicios viewMenuServicios;
	private ViewRegistrarServicio viewRegistrarServicios;
	private ViewFinalizarServicio viewFinalizarServicio;
	private ViewAsignarServicio viewAsignarServicio;
	private ViewReporteServicios viewReporteServicios;
	private TestGUIAmbulancias ventanaPrincipal;
	
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}



	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}



	public ViewMenuServicios getViewMenuServicios() {
		return viewMenuServicios;
	}



	public void setViewMenuServicios(ViewMenuServicios viewMenuServicios) {
		this.viewMenuServicios = viewMenuServicios;
	}



	public ViewRegistrarServicio getViewRegistrarServicios() {
		return viewRegistrarServicios;
	}



	public void setViewRegistrarServicios(ViewRegistrarServicio viewRegistrarServicios) {
		this.viewRegistrarServicios = viewRegistrarServicios;
	}



	public ViewFinalizarServicio getViewFinalizarServicio() {
		return viewFinalizarServicio;
	}



	public void setViewFinalizarServicio(ViewFinalizarServicio viewFinalizarServicio) {
		this.viewFinalizarServicio = viewFinalizarServicio;
	}



	public ViewAsignarServicio getViewAsignarServicio() {
		return viewAsignarServicio;
	}



	public void setViewAsignarServicio(ViewAsignarServicio viewAsignarServicio) {
		this.viewAsignarServicio = viewAsignarServicio;
	}



	public ViewReporteServicios getViewReporteServicios() {
		return viewReporteServicios;
	}



	public void setViewReporteServicios(ViewReporteServicios viewReporteServicios) {
		this.viewReporteServicios = viewReporteServicios;
	}

	

	public TestGUIAmbulancias getVentanaPrincipal() {
		return ventanaPrincipal;
	}



	public void setVentanaPrincipal(TestGUIAmbulancias ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}



	/**
	 * Create the panel.
	 */
	public ViewServicios(TestGUIAmbulancias ventanaPrincipal) {
		
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		this.ventanaPrincipal = ventanaPrincipal;
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.NORTH);
		
		viewMenuServicios = new ViewMenuServicios(ventanaPrincipal);
		tabbedPane.addTab("Menu Servicios", new ImageIcon(ViewServicios.class.getResource("/Iconos/Men£Serv.png")), viewMenuServicios, null);
		
		viewRegistrarServicios = new ViewRegistrarServicio(ventanaPrincipal);
		
		tabbedPane.addTab("Registrar Servicio", new ImageIcon(ViewServicios.class.getResource("/Iconos/Create.png")), viewRegistrarServicios, null);
		tabbedPane.setEnabledAt(1, true);
		

		viewAsignarServicio = new ViewAsignarServicio(ventanaPrincipal);
		tabbedPane.addTab("Asignar Servicio", new ImageIcon(ViewServicios.class.getResource("/Iconos/Asignar0.png")), viewAsignarServicio, null);
		tabbedPane.setEnabledAt(2, true);

		viewFinalizarServicio = new ViewFinalizarServicio(ventanaPrincipal);
		tabbedPane.addTab("Finalizar Servicio", new ImageIcon(ViewServicios.class.getResource("/Iconos/Finalizar.png")), viewFinalizarServicio, null);
		tabbedPane.setEnabledAt(3, true);
				
		viewReporteServicios = new ViewReporteServicios(ventanaPrincipal);
		tabbedPane.addTab("Reporte", new ImageIcon(ViewServicios.class.getResource("/Iconos/Report.png")), viewReporteServicios, null);
		tabbedPane.setEnabledAt(4, true);

	}

}

