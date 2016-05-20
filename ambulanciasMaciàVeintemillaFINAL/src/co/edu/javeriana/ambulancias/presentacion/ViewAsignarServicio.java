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
	
	public TestGUIAmbulancias getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(TestGUIAmbulancias ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JTable getTablaIPS() {
		return tablaIPS;
	}

	public void setTablaIPS(JTable tablaIPS) {
		this.tablaIPS = tablaIPS;
	}

	public DefaultTableModel getModelIps() {
		return modelIps;
	}

	public void setModelIps(DefaultTableModel modelIps) {
		this.modelIps = modelIps;
	}

	public String[] getLablesIPS() {
		return lablesIPS;
	}

	public void setLablesIPS(String[] lablesIPS) {
		this.lablesIPS = lablesIPS;
	}

	public String[][] getContIPS() {
		return contIPS;
	}

	public void setContIPS(String[][] contIPS) {
		this.contIPS = contIPS;
	}

	public JTable getTablaAmb() {
		return tablaAmb;
	}

	public void setTablaAmb(JTable tablaAmb) {
		this.tablaAmb = tablaAmb;
	}

	public DefaultTableModel getModelAmb() {
		return modelAmb;
	}

	public void setModelAmb(DefaultTableModel modelAmb) {
		this.modelAmb = modelAmb;
	}

	public String[] getLablesAmbulancias() {
		return lablesAmbulancias;
	}

	public void setLablesAmbulancias(String[] lablesAmbulancias) {
		this.lablesAmbulancias = lablesAmbulancias;
	}

	public String[][] getContAmbulancias() {
		return contAmbulancias;
	}

	public void setContAmbulancias(String[][] contAmbulancias) {
		this.contAmbulancias = contAmbulancias;
	}

	public JTable getTablaServ() {
		return tablaServ;
	}

	public void setTablaServ(JTable tablaServ) {
		this.tablaServ = tablaServ;
	}

	public DefaultTableModel getModelServ() {
		return modelServ;
	}

	public void setModelServ(DefaultTableModel modelServ) {
		this.modelServ = modelServ;
	}

	public String[] getLablesServ() {
		return lablesServ;
	}

	public void setLablesServ(String[] lablesServ) {
		this.lablesServ = lablesServ;
	}

	public String[][] getContServ() {
		return contServ;
	}

	public void setContServ(String[][] contServ) {
		this.contServ = contServ;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JLabel getLblAsignarUnServicio() {
		return lblAsignarUnServicio;
	}

	public void setLblAsignarUnServicio(JLabel lblAsignarUnServicio) {
		this.lblAsignarUnServicio = lblAsignarUnServicio;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JPanel getPanel_3() {
		return panel_3;
	}

	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JPanel getPanel_4() {
		return panel_4;
	}

	public void setPanel_4(JPanel panel_4) {
		this.panel_4 = panel_4;
	}

	public JLabel getLblIps() {
		return lblIps;
	}

	public void setLblIps(JLabel lblIps) {
		this.lblIps = lblIps;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JLabel getLblAmbulancias() {
		return lblAmbulancias;
	}

	public void setLblAmbulancias(JLabel lblAmbulancias) {
		this.lblAmbulancias = lblAmbulancias;
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public void setScrollPane_1(JScrollPane scrollPane_1) {
		this.scrollPane_1 = scrollPane_1;
	}

	public JLabel getLblServicios() {
		return lblServicios;
	}

	public void setLblServicios(JLabel lblServicios) {
		this.lblServicios = lblServicios;
	}

	public JScrollPane getScrollPane_2() {
		return scrollPane_2;
	}

	public void setScrollPane_2(JScrollPane scrollPane_2) {
		this.scrollPane_2 = scrollPane_2;
	}

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
