package co.edu.javeriana.ambulancias.presentacion;

import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

import Controller.Controller;
import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class ViewMenu extends JPanel {

	//public Image imagenFondo;
	//public URL fondo;
	private IServiciosAmbulancias empresaAmbulancias;
	private JPanel panel;
	private PanelLogo panel_1;
	private JTextArea textArea_1;
	private JTextArea txtrBienvenidoAlAmbuber;
	private JTextArea textArea_3;
	private JTextArea txtrparaSolucionarTu;
	private JTextArea textArea_4;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextArea txtrMenPrincipal;
	private JButton btnCargarDatos;
	private JButton btnSalvarDatos;
	private Controller controller;
	private TestGUIAmbulancias ventanaPrincipal;
	
	
	
	public IServiciosAmbulancias getEmpresaAmbulancias() {
		return empresaAmbulancias;
	}




	public void setEmpresaAmbulancias(IServiciosAmbulancias empresaAmbulancias) {
		this.empresaAmbulancias = empresaAmbulancias;
	}




	public JPanel getPanel() {
		return panel;
	}




	public void setPanel(JPanel panel) {
		this.panel = panel;
	}




	public PanelLogo getPanel_1() {
		return panel_1;
	}




	public void setPanel_1(PanelLogo panel_1) {
		this.panel_1 = panel_1;
	}




	public JTextArea getTextArea_1() {
		return textArea_1;
	}




	public void setTextArea_1(JTextArea textArea_1) {
		this.textArea_1 = textArea_1;
	}




	public JTextArea getTxtrBienvenidoAlAmbuber() {
		return txtrBienvenidoAlAmbuber;
	}




	public void setTxtrBienvenidoAlAmbuber(JTextArea txtrBienvenidoAlAmbuber) {
		this.txtrBienvenidoAlAmbuber = txtrBienvenidoAlAmbuber;
	}




	public JTextArea getTextArea_3() {
		return textArea_3;
	}




	public void setTextArea_3(JTextArea textArea_3) {
		this.textArea_3 = textArea_3;
	}




	public JTextArea getTxtrparaSolucionarTu() {
		return txtrparaSolucionarTu;
	}




	public void setTxtrparaSolucionarTu(JTextArea txtrparaSolucionarTu) {
		this.txtrparaSolucionarTu = txtrparaSolucionarTu;
	}




	public JTextArea getTextArea_4() {
		return textArea_4;
	}




	public void setTextArea_4(JTextArea textArea_4) {
		this.textArea_4 = textArea_4;
	}




	public JPanel getPanel_2() {
		return panel_2;
	}




	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}




	public JButton getBtnNewButton() {
		return btnNewButton;
	}




	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
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




	public JTextArea getTxtrMenPrincipal() {
		return txtrMenPrincipal;
	}




	public void setTxtrMenPrincipal(JTextArea txtrMenPrincipal) {
		this.txtrMenPrincipal = txtrMenPrincipal;
	}




	public JButton getBtnCargarDatos() {
		return btnCargarDatos;
	}




	public void setBtnCargarDatos(JButton btnCargarDatos) {
		this.btnCargarDatos = btnCargarDatos;
	}




	public JButton getBtnSalvarDatos() {
		return btnSalvarDatos;
	}




	public void setBtnSalvarDatos(JButton btnSalvarDatos) {
		this.btnSalvarDatos = btnSalvarDatos;
	}




	/**
	 * Create the panel.
	 */
	public ViewMenu(TestGUIAmbulancias ventanaPrincipal) {
		
		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
		
		setBackground(new Color(173, 216, 230));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(30);
		add(panel, BorderLayout.WEST);
		
		PanelLogo panel_1 = new PanelLogo();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		panel_1.add(textArea_1);
		
		JTextArea txtrBienvenidoAlAmbuber = new JTextArea();
		txtrBienvenidoAlAmbuber.setForeground(new Color(204, 0, 0));
		txtrBienvenidoAlAmbuber.setEditable(false);
		txtrBienvenidoAlAmbuber.setText("      amb+UBER");
		txtrBienvenidoAlAmbuber.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel_1.add(txtrBienvenidoAlAmbuber);
		
		JTextArea textArea_3 = new JTextArea();
		panel_1.add(textArea_3);
		
		JTextArea txtrparaSolucionarTu = new JTextArea();
		txtrparaSolucionarTu.setEditable(false);
		txtrparaSolucionarTu.setForeground(Color.DARK_GRAY);
		txtrparaSolucionarTu.setText("             \"Solucionamos tu Emergencia\"");
		txtrparaSolucionarTu.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel_1.add(txtrparaSolucionarTu);
		
		JTextArea textArea_4 = new JTextArea();
		panel_1.add(textArea_4);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/ambulance2.jpg"));
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setVgap(20);
		add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(3, 1, 0, 20));
		
		JTextArea txtrMenPrincipal = new JTextArea();
		panel_4.add(txtrMenPrincipal);
		txtrMenPrincipal.setForeground(new Color(0, 0, 128));
		txtrMenPrincipal.setEditable(false);
		txtrMenPrincipal.setText("        MENÚ PRINCIPAL");
		txtrMenPrincipal.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		
		JButton btnCargarDatos = new JButton("Cargar datos al Sistema");
		btnCargarDatos.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Application_form.png"));
		btnCargarDatos.setForeground(Color.WHITE);
		btnCargarDatos.setBackground(Color.DARK_GRAY);
		btnCargarDatos.setOpaque(true);
		btnCargarDatos.setBorderPainted(false);
		btnCargarDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCargarDatos.addActionListener(this.controller.getNegocio());
		panel_4.add(btnCargarDatos);
		
		JButton btnSalvarDatos = new JButton("Salvar datos del Sistema");
		btnSalvarDatos.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Save.png"));
		btnSalvarDatos.setForeground(Color.WHITE);
		btnSalvarDatos.setBackground(Color.DARK_GRAY);
		btnSalvarDatos.setOpaque(true);
		btnSalvarDatos.setBorderPainted(false);
		btnSalvarDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSalvarDatos.addActionListener(this.controller.getNegocio());
		panel_4.add(btnSalvarDatos);
			
		
	}
	
	//public void salvarDatos
	

}
