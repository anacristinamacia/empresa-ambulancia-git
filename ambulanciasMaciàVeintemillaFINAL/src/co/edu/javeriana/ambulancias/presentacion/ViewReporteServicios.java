package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Controller;
import net.miginfocom.swing.MigLayout;

public class ViewReporteServicios extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	
	private JButton btnMostrar;
	
	private BorderLayout layoutPrincipal;
	private JPanel panelNorth;
	private JPanel panelEast;
	private JPanel panelWest;
	private JPanel panelSouth;
	private JPanel panelCenter;
	
	private JTable tableServicios;
	private JTable tableIPS;
	private JTable tableAmbulancias;
	
	private TableModel modelServicios;
	private TableModel modelIPS;
	private TableModel modelAmbulancia;
	
	private String [] tableLabelsAmbulancia = {"Codigo","Tipo","Tipo UCI","Placa", "Medico / Enfermero","Hora Posicion", "Calle", "Carrera", "Tarifa"};
	private String [][] tableContAmbulancias = {};
	
	private String [] tableLabelsIPS = {"Nombre" , "Tipo Atencion" , "Direccion"};
	private String [][] tableContIPS = {};
	
	private String [] tableLabelsServicios = {"Codigo","Hora","Paciente", "Tipo Servicio","Telefono","Direccion","Estado","IPS","Ambulancia","Valor"};
	private String [][] tableContServicios = {};

	public ViewReporteServicios(TestGUIAmbulancias ventanaPrincipal) {
		
		this.ventanaPrincipal= ventanaPrincipal;
		this.controller = new Controller (this.ventanaPrincipal);
		
		layoutPrincipal = new BorderLayout();
		setLayout(layoutPrincipal);
		
		panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		
		panelEast = new JPanel();
		add(panelEast, BorderLayout.WEST);
		
		panelWest = new JPanel();
		add(panelWest, BorderLayout.EAST);
		
		panelSouth = new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		
		panelCenter = new JPanel();
		
		setTittleView();
		setTableServiciosView ();
		setBtnMostrarView ();
		setTableIPSView ();
		setTableAmbulanciaView ();
		
		add(panelCenter, BorderLayout.CENTER);
		
		

	}
	
	public void setTableServiciosView () {
		
		JLabel tittle = new JLabel("Servicios");
		panelCenter.add(tittle, "cell 0 1,grow");
		
		modelServicios = new DefaultTableModel(tableContServicios, tableLabelsServicios);
		tableServicios = new JTable(modelServicios);
		JScrollPane scrollPane = new JScrollPane(tableServicios);
		scrollPane.setBounds(0, 128, 345, -128);
		panelCenter.add(scrollPane, "cell 0 2,grow");
	}
	
	public void setTableIPSView () {
		JLabel tittle = new JLabel("IPS");
		panelCenter.add(tittle, "cell 0 4,grow");
		
		modelIPS = new DefaultTableModel(tableContIPS, tableLabelsIPS);
		tableIPS = new JTable(modelIPS);
		JScrollPane scrollPane = new JScrollPane(tableIPS);
		scrollPane.setBounds(0, 128, 345, -128);
		panelCenter.add(scrollPane, "cell 0 5,grow");
	}
	
	public void setTableAmbulanciaView () {
		JLabel tittle = new JLabel("Ambulancias");
		panelCenter.add(tittle, "cell 0 6,grow");
		
		modelAmbulancia = new DefaultTableModel(tableContAmbulancias, tableLabelsAmbulancia);
		tableAmbulancias = new JTable(modelAmbulancia);
		JScrollPane scrollPane = new JScrollPane(tableAmbulancias);
		scrollPane.setBounds(0, 128, 345, -128);
		panelCenter.add(scrollPane, "cell 0 7,grow");
	}
	
	public void setTittleView () {
		panelCenter.setLayout(new MigLayout("", "[562px]", "[27px][27px][27px][27px][27px][27px][27px][27px]"));
		JLabel tittle = new JLabel("Reporte De Servicios con IPS y Ambulancias Asignados");
		panelCenter.add(tittle, "cell 0 0,grow");
	}
	
	public void setBtnMostrarView () {
		btnMostrar = new JButton("Mostrar");
		
		panelCenter.add(btnMostrar, "cell 0 3,grow");
		
	}

	public BorderLayout getLayoutPrincipal() {
		return layoutPrincipal;
	}

	public void setLayoutPrincipal(BorderLayout layoutPrincipal) {
		this.layoutPrincipal = layoutPrincipal;
	}

	public JPanel getPanelNorth() {
		return panelNorth;
	}

	public void setPanelNorth(JPanel panelNorth) {
		this.panelNorth = panelNorth;
	}

	public JPanel getPanelEast() {
		return panelEast;
	}

	public void setPanelEast(JPanel panelEast) {
		this.panelEast = panelEast;
	}

	public JPanel getPanelWest() {
		return panelWest;
	}

	public void setPanelWest(JPanel panelWest) {
		this.panelWest = panelWest;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	public void setPanelSouth(JPanel panelSouth) {
		this.panelSouth = panelSouth;
	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	/*public GridLayout getGrid() {
		return grid;
	}

	public void setGrid(GridLayout grid) {
		this.grid = grid;
	}*/
	
	
	
}
