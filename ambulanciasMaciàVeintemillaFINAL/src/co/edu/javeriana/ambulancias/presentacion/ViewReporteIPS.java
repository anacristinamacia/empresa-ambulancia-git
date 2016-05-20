package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Set;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class ViewReporteIPS extends JPanel {

	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	
	private TableModel modelServicios;
	private String [] lablesServicios = {"Codigo", "Hora Solicitud","Paciente", "Tipo Servicio","Telefono", "Direccion","Estado", "IPS", "Ambulancia"};
	private String [][] contServicios = {};
	private JTable table;
	private JPanel panel_1;
	private JPanel panel;
	private JButton btnMostrarReporte;
	private JComboBox comboBoxIPS;
	/**
	 * Create the panel.
	 */
	public ViewReporteIPS(TestGUIAmbulancias ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(30);
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.SOUTH);
		
		comboBoxIPS = new JComboBox();
		comboBoxIPS.setBackground(Color.WHITE);
		comboBoxIPS.setForeground(Color.DARK_GRAY);
		
		panel_1.add(comboBoxIPS);
		
		btnMostrarReporte = new JButton("Mostrar Reporte");
		btnMostrarReporte.setIcon(new ImageIcon(ViewReporteIPS.class.getResource("/Iconos/Report.png")));
		btnMostrarReporte.setBackground(Color.DARK_GRAY);
		btnMostrarReporte.setOpaque(true);
		btnMostrarReporte.setBorderPainted(false);
		btnMostrarReporte.setForeground(Color.WHITE);
		panel_1.add(btnMostrarReporte);
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		modelServicios = new DefaultTableModel(contServicios, lablesServicios);
		table = new JTable(modelServicios);
		table.setForeground(Color.DARK_GRAY);
		panel.add(new JScrollPane(table));
	}

}
