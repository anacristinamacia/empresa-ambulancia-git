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

public class ViewMenuIPS extends JPanel {
	private JButton btnIngresarIps;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextArea textArea;
	private JTextArea txtrMenIps;
	private JButton btnReporteIpsCon;
	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	
	public JButton getBtnIngresarIps() {
		return btnIngresarIps;
	}
	public void setBtnIngresarIps(JButton btnIngresarIps) {
		this.btnIngresarIps = btnIngresarIps;
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
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JTextArea getTxtrMenIps() {
		return txtrMenIps;
	}
	public void setTxtrMenIps(JTextArea txtrMenIps) {
		this.txtrMenIps = txtrMenIps;
	}
	public JButton getBtnReporteIpsCon() {
		return btnReporteIpsCon;
	}
	public void setBtnReporteIpsCon(JButton btnReporteIpsCon) {
		this.btnReporteIpsCon = btnReporteIpsCon;
	}
	/**
	 * Create the panel.
	 */
	public ViewMenuIPS(TestGUIAmbulancias ventanaPrincipal) {
		
		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
		setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(50);
		add(panel_1, BorderLayout.WEST);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(50);
		add(panel_2, BorderLayout.EAST);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(10);
		add(panel_3, BorderLayout.SOUTH);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(4, 0, 0, 30));
		
		textArea = new JTextArea();
		panel_4.add(textArea);
		
		
		txtrMenIps = new JTextArea();
		txtrMenIps.setEditable(false);
		txtrMenIps.setForeground(new Color(0, 0, 128));
		txtrMenIps.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		txtrMenIps.setText("                MENÚ IPS");
		panel_4.add(txtrMenIps);
		
		btnIngresarIps = new JButton("Ingresar IPS ");
		btnIngresarIps.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Health_care_medicine2.png"));
		btnIngresarIps.setForeground(Color.WHITE);
		btnIngresarIps.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnIngresarIps.setBackground(Color.DARK_GRAY);
		btnIngresarIps.setOpaque(true);
		btnIngresarIps.setBorderPainted(false);
		btnIngresarIps.addActionListener(controller.getOpenFile());
		panel_4.add(btnIngresarIps);
		
		btnReporteIpsCon = new JButton("Reporte IPS con Servicios");
		btnReporteIpsCon.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Report.png"));
		btnReporteIpsCon.setForeground(Color.WHITE);
		btnReporteIpsCon.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReporteIpsCon.setBackground(Color.DARK_GRAY);
		btnReporteIpsCon.setOpaque(true);
		btnReporteIpsCon.setBorderPainted(false);
		panel_4.add(btnReporteIpsCon);
		
	}

}
