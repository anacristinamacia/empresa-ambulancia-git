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



	/**
	 * Create the panel.
	 */
	public ViewServicios() {
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.NORTH);
		
		ViewMenuServicios viewMenuServicios = new ViewMenuServicios();
		tabbedPane.addTab("Menú Servicios", null, viewMenuServicios, null);
		
		ViewRegistrarServicio viewRegistrarServicio = new ViewRegistrarServicio();
		tabbedPane.addTab("Registrar Servicio", null, viewRegistrarServicio, null);
		tabbedPane.setEnabledAt(1, false);
		
			ViewAsignarServicio viewAsignarServicio_1 = new ViewAsignarServicio();
			tabbedPane.addTab("Asignar Servicio", null, viewAsignarServicio_1, null);
			tabbedPane.setEnabledAt(2, true);
		
		ViewFinalizarServicio viewFinalizarServicio = new ViewFinalizarServicio();
		tabbedPane.addTab("Finalizar Servicio", null, viewFinalizarServicio, null);
		tabbedPane.setEnabledAt(3, false);
				
		ViewReporteServicios viewReporteServicios = new ViewReporteServicios();
		tabbedPane.addTab("Reporte", null, viewReporteServicios, null);
		tabbedPane.setEnabledAt(4, false);

	}

}
