package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Controller;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;

public class ViewRegistrarPosicion extends JPanel {
	private JTable table;
	private JPanel panelSur;
	private TableModel modelAmbulancias; 
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private String [] lablesAmbulancia = {"Codigo", "Tipo","Placa", "Medico/Enfermero","Tipo UCI", "Hora Posicion","Calle", "Carrera"};
	private String [][] contAmbulancias = {};
	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	private JTextField txtCalle;
	private JTextField txtCarrera;
	private JLabel lblCalle;
	private JLabel lblCarrera;

	/**
	 * Create the panel.
	 */
	public ViewRegistrarPosicion(TestGUIAmbulancias ventanaPrincipal) {
		setLayout(new BorderLayout(0, 0));
		
		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
		panelSur = new JPanel();
		panelSur.setBackground(Color.WHITE);
		panelSur.setLayout(new FlowLayout());
		
		lblCalle = new JLabel("Calle");
		panelSur.add(lblCalle);
		
		txtCalle = new JTextField();
		panelSur.add(txtCalle);
		txtCalle.setColumns(3);
		
		lblCarrera = new JLabel("Carrera");
		panelSur.add(lblCarrera);
		
		txtCarrera = new JTextField();
		panelSur.add(txtCarrera);
		txtCarrera.setColumns(3);
		
		btnRegistrar = new JButton("Registrar");
		panelSur.add(btnRegistrar);
		btnRegistrar.addActionListener(this.controller.getRegistrarPosicion());
		btnRegistrar.setBackground(Color.DARK_GRAY);
		btnRegistrar.setOpaque(true);
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setForeground(Color.WHITE);
		
		btnActualizar = new JButton("Actualizar");
		panelSur.add(btnActualizar);
		btnActualizar.addActionListener(this.controller.getRegistrarPosicion());
		btnActualizar.setBackground(Color.DARK_GRAY);
		btnActualizar.setOpaque(true);
		btnActualizar.setBorderPainted(false);
		btnActualizar.setForeground(Color.WHITE);
		
		add(panelSur, BorderLayout.SOUTH);
		modelAmbulancias = new DefaultTableModel(contAmbulancias, lablesAmbulancia);
		table = new JTable(modelAmbulancias);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	//Esta función fue desarrollada en compania de Juan Pablo Penaloza
	public int getSelectedRowCode () {
		int numRow = table.getSelectedRow();
		String tempCode = (String) table.getValueAt(numRow, 0);
		int code = Integer.parseInt(tempCode);
		return code;
	}
	
	public void updateAmbulanciaModel (Object nuevoCont [][]) {
		DefaultTableModel tempModel = new DefaultTableModel(nuevoCont, lablesAmbulancia);
		table.setModel(tempModel);
	}

	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JPanel getPanelSur() {
		return panelSur;
	}


	public void setPanelSur(JPanel panelSur) {
		this.panelSur = panelSur;
	}


	public TableModel getModelAmbulancias() {
		return modelAmbulancias;
	}


	public void setModelAmbulancias(TableModel modelAmbulancias) {
		this.modelAmbulancias = modelAmbulancias;
	}


	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}


	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}


	public JButton getBtnActualizar() {
		return btnActualizar;
	}


	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}


	public String[] getLablesAmbulancia() {
		return lablesAmbulancia;
	}


	public void setLablesAmbulancia(String[] lablesAmbulancia) {
		this.lablesAmbulancia = lablesAmbulancia;
	}


	public String[][] getContAmbulancias() {
		return contAmbulancias;
	}


	public void setContAmbulancias(String[][] contAmbulancias) {
		this.contAmbulancias = contAmbulancias;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public void setTxtCalle(JTextField txtCalle) {
		this.txtCalle = txtCalle;
	}

	public JTextField getTxtCarrera() {
		return txtCarrera;
	}

	public void setTxtCarrera(JTextField txtCarrera) {
		this.txtCarrera = txtCarrera;
	}
	

}
