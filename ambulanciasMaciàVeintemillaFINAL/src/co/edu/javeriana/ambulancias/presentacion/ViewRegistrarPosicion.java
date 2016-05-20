package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Controller;

import java.awt.FlowLayout;
import java.awt.GridLayout;

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

	/**
	 * Create the panel.
	 */
	public ViewRegistrarPosicion(TestGUIAmbulancias ventanaPrincipal) {
		setLayout(new BorderLayout(0, 0));
		
		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
		panelSur = new JPanel();
		panelSur.setLayout(new FlowLayout());
		btnRegistrar = new JButton("Registrar");
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this.controller.getRegistrarPosicion());
		panelSur.add(btnRegistrar);
		panelSur.add(btnActualizar);
		add(panelSur, BorderLayout.SOUTH);
		modelAmbulancias = new DefaultTableModel(contAmbulancias, lablesAmbulancia);
		table = new JTable(modelAmbulancias);
		add(new JScrollPane(table), BorderLayout.CENTER);
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
	

}
