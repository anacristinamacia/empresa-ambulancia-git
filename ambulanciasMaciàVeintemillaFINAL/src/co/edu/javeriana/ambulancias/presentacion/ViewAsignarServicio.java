package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import net.miginfocom.swing.MigLayout;

public class ViewAsignarServicio extends JPanel {
	
	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	
	private JTable tablaIPS;
	private DefaultTableModel modelIps;
	private String [] lablesIPS = {"Nombre", "Tipo atencion", "Direccion"};
	private String [][] contIPS = {};
	
	private JTable tablaAmb;
	private DefaultTableModel modelAmb;
	private String [] lablesAmbulancias = {"Codigo", "Tipo","Placa", "Medico/Enfermero","Tipo UCI", "Hora Posicion","Calle", "Carrera"};
	private String [][] contAmbulancias = {};
	
	private JTable tablaServ;
	private DefaultTableModel modelServ;
	private String [] lablesServ= {"Codigo", "Hora Sol.","Paciente", "Tipo","telefono", "direccion","Estado", "IPS", "Ambulancia"};
	private String [][] contServ = {};
	
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblAsignarUnServicio;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnAceptar;
	private JPanel panel_4;
	private JLabel lblIps;
	private JScrollPane scrollPane;
	private JLabel lblAmbulancias;
	private JScrollPane scrollPane_1;
	private JLabel lblServicios;
	private JScrollPane scrollPane_2;
	
	public ViewAsignarServicio(TestGUIAmbulancias ventanaPrincipal){
		
		setLayout(new BorderLayout(0, 0));

		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
		panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setHgap(10);
		add(panel, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_1.getLayout();
		flowLayout_3.setVgap(10);
		add(panel_1, BorderLayout.NORTH);
		
		lblAsignarUnServicio = new JLabel("ASIGNAR UN SERVICIO");
		panel_1.add(lblAsignarUnServicio);
		
		panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setHgap(10);
		add(panel_2, BorderLayout.EAST);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(10);
		add(panel_3, BorderLayout.SOUTH);
		
		btnAceptar = new JButton("Aceptar");
		panel_3.add(btnAceptar);
		
		panel_4 = new JPanel();
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[444px]", "[58px][58px][58px][58px][58px][58px]"));
		
		lblIps = new JLabel("IPS");
		panel_4.add(lblIps, "cell 0 0,grow");
		
		scrollPane = new JScrollPane();
		panel_4.add(scrollPane, "cell 0 1,grow");
		
		tablaIPS = new JTable();
		modelIps = new DefaultTableModel(contIPS, lablesIPS);
		tablaIPS.setModel(modelIps);
		scrollPane.setViewportView(tablaIPS);
		
		lblAmbulancias = new JLabel("Ambulancias");
		panel_4.add(lblAmbulancias, "cell 0 2,grow");
		
		scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, "cell 0 3,grow");
		
		tablaAmb = new JTable();
		modelAmb = new DefaultTableModel(contAmbulancias, lablesAmbulancias);
		tablaAmb.setModel(modelAmb);
		scrollPane_1.setViewportView(tablaAmb);
		
		lblServicios = new JLabel("Servicios");
		panel_4.add(lblServicios, "cell 0 4,grow");
		
		scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, "cell 0 5,grow");
		
		tablaServ = new JTable();
		modelServ = new DefaultTableModel(contServ, lablesServ);
		tablaServ.setModel(modelServ);
		scrollPane_2.setViewportView(tablaServ);
		
	}
	
	
	
}
