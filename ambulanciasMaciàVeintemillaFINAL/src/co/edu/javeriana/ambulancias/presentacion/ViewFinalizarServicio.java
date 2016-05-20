package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class ViewFinalizarServicio extends JPanel {

	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	private TableModel modelServicios;
	private String [] lablesServicios = {"Codigo", "Hora Solicitud","Paciente", "Tipo Servicio","Telefono", "Direccion","Estado", "IPS", "Ambulancia"};
	private String [][] contServicios = {};
	private JTable table;
	private JPanel panel;
	private JPanel panel_2;
	private JButton btnFinalizar;
	/**
	 * Create the panel.
	 */
	public ViewFinalizarServicio(TestGUIAmbulancias ventanaPrincipal) {

		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(20);
		add(panel, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		modelServicios = new DefaultTableModel(contServicios, lablesServicios);
		table = new JTable(modelServicios);
		panel_2.add(new JScrollPane(table));
		
		add(panel, BorderLayout.SOUTH);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBackground(Color.DARK_GRAY);
		btnFinalizar.setOpaque(true);
		btnFinalizar.setBorderPainted(false);
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.addActionListener(this.controller.getFinalizarServicio());
		panel.add(btnFinalizar);
		
		
		
		
	}
	
	public int getSelectedRowCode () {
		int numRow = table.getSelectedRow();
		String tempCode = (String) table.getValueAt(numRow, 0);
		int code = Integer.parseInt(tempCode);
		return code;
	}
	
	public void updateServiciosModel (Object nuevoCont [][]) {
		DefaultTableModel tempModel = new DefaultTableModel(nuevoCont, lablesServicios);
		table.setModel(tempModel);
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

	public TableModel getModelServicios() {
		return modelServicios;
	}

	public void setModelServicios(TableModel modelServicios) {
		this.modelServicios = modelServicios;
	}

	public String[] getLablesServicios() {
		return lablesServicios;
	}

	public void setLablesServicios(String[] lablesServicios) {
		this.lablesServicios = lablesServicios;
	}

	public String[][] getContServicios() {
		return contServicios;
	}

	public void setContServicios(String[][] contServicios) {
		this.contServicios = contServicios;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public void setBtnFinalizar(JButton btnFinalizar) {
		this.btnFinalizar = btnFinalizar;
	}

	
}
