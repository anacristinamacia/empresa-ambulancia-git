package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controller.Controller;

public class ViewMenuAmbulancias extends JPanel {
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextArea txtrMenAmbulancias;
	private JButton btnIngresarAmbulancias;
	private JButton btnRegistrarPosicion;
	private JButton btnReporteAmbulancias;
	private JButton btnEstadisticas;
	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	
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


	public JPanel getPanel_4() {
		return panel_4;
	}


	public void setPanel_4(JPanel panel_4) {
		this.panel_4 = panel_4;
	}


	public JTextArea getTxtrMenAmbulancias() {
		return txtrMenAmbulancias;
	}


	public void setTxtrMenAmbulancias(JTextArea txtrMenAmbulancias) {
		this.txtrMenAmbulancias = txtrMenAmbulancias;
	}


	public JButton getBtnIngresarAmbulancias() {
		return btnIngresarAmbulancias;
	}


	public void setBtnIngresarAmbulancias(JButton btnIngresarAmbulancias) {
		this.btnIngresarAmbulancias = btnIngresarAmbulancias;
	}


	public JButton getBtnRegistrarPosicion() {
		return btnRegistrarPosicion;
	}


	public void setBtnRegistrarPosicion(JButton btnRegistrarPosicion) {
		this.btnRegistrarPosicion = btnRegistrarPosicion;
	}


	public JButton getBtnReporteAmbulancias() {
		return btnReporteAmbulancias;
	}


	public void setBtnReporteAmbulancias(JButton btnReporteAmbulancias) {
		this.btnReporteAmbulancias = btnReporteAmbulancias;
	}


	public JButton getBtnEstadisticas() {
		return btnEstadisticas;
	}


	public void setBtnEstadisticas(JButton btnEstadisticas) {
		this.btnEstadisticas = btnEstadisticas;
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


	/**
	 * Create the panel.
	 */
	public ViewMenuAmbulancias(TestGUIAmbulancias ventanaPrincipal) {

		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
		flowLayout_2.setHgap(50);
		add(panel, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(20);
		add(panel_1, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setHgap(50);
		add(panel_2, BorderLayout.EAST);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(20);
		add(panel_3, BorderLayout.SOUTH);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(5, 1, 2, 20));
		
		txtrMenAmbulancias = new JTextArea();
		txtrMenAmbulancias.setText("         MENÚ AMBULANCIAS");
		txtrMenAmbulancias.setForeground(new Color(0, 0, 128));
		txtrMenAmbulancias.setEditable(false);
		txtrMenAmbulancias.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		panel_4.add(txtrMenAmbulancias);
		
		btnIngresarAmbulancias = new JButton("Ingresar Ambulancias");
		btnIngresarAmbulancias.setForeground(Color.WHITE);
		btnIngresarAmbulancias.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/AmbulancePeq.png"));
		btnIngresarAmbulancias.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnIngresarAmbulancias.setBackground(Color.DARK_GRAY);
		btnIngresarAmbulancias.setOpaque(true);
		btnIngresarAmbulancias.setBorderPainted(false);
		btnIngresarAmbulancias.addActionListener(this.controller.getOpenFile());
		panel_4.add(btnIngresarAmbulancias);
		
		btnRegistrarPosicion = new JButton("Registrar Posicion");
		btnRegistrarPosicion.setForeground(Color.WHITE);
		btnRegistrarPosicion.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnRegistrarPosicion.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/marker-2---add.png"));
		btnRegistrarPosicion.setBackground(Color.DARK_GRAY);
		btnRegistrarPosicion.setOpaque(true);
		btnRegistrarPosicion.setBorderPainted(false);
		btnRegistrarPosicion.addActionListener(this.controller.getMenuAmbulancias());
		panel_4.add(btnRegistrarPosicion);
		
		btnReporteAmbulancias = new JButton("Reporte de Ambulancias");
		btnReporteAmbulancias.setForeground(Color.WHITE);
		btnReporteAmbulancias.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReporteAmbulancias.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Report.png"));
		btnReporteAmbulancias.setBackground(Color.DARK_GRAY);
		btnReporteAmbulancias.setOpaque(true);
		btnReporteAmbulancias.setBorderPainted(false);
		panel_4.add(btnReporteAmbulancias);
		
		btnEstadisticas = new JButton(" Ambulancias disponibles");
		btnEstadisticas.setForeground(Color.WHITE);
		btnEstadisticas.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnEstadisticas.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Statistics.png"));
		btnEstadisticas.setBackground(Color.DARK_GRAY);
		btnEstadisticas.setOpaque(true);
		btnEstadisticas.setBorderPainted(false);
		panel_4.add(btnEstadisticas);
		
	}


}
