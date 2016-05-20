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

public class ViewMenuServicios extends JPanel {
	
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextArea txtrMenServicios;
	private JButton btnRegistrarServicio;
	private JButton btnAsignarServicio;
	private JButton btnFinalizarServicio;
	private JButton btnReportePacientesAtendidos;
	private JButton btnServiciosConIps;

	private Controller controller;
	private TestGUIAmbulancias ventanaPrincipal;

	/**
	 * Create the panel.
	 */
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
	public JTextArea getTxtrMenServicios() {
		return txtrMenServicios;
	}
	public void setTxtrMenServicios(JTextArea txtrMenServicios) {
		this.txtrMenServicios = txtrMenServicios;
	}
	public JButton getBtnRegistrarServicio() {
		return btnRegistrarServicio;
	}
	public void setBtnRegistrarServicio(JButton btnRegistrarServicio) {
		this.btnRegistrarServicio = btnRegistrarServicio;
	}
	public JButton getBtnAsignarServicio() {
		return btnAsignarServicio;
	}
	public void setBtnAsignarServicio(JButton btnAsignarServicio) {
		this.btnAsignarServicio = btnAsignarServicio;
	}
	public JButton getBtnFinalizarServicio() {
		return btnFinalizarServicio;
	}
	public void setBtnFinalizarServicio(JButton btnFinalizarServicio) {
		this.btnFinalizarServicio = btnFinalizarServicio;
	}
	public JButton getBtnReportePacientesAtendidos() {
		return btnReportePacientesAtendidos;
	}
	public void setBtnReportePacientesAtendidos(JButton btnReportePacientesAtendidos) {
		this.btnReportePacientesAtendidos = btnReportePacientesAtendidos;
	}
	public JButton getBtnServiciosConIps() {
		return btnServiciosConIps;
	}
	public void setBtnServiciosConIps(JButton btnServiciosConIps) {
		this.btnServiciosConIps = btnServiciosConIps;
	}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public TestGUIAmbulancias getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	public void setVentanaPrincipal(TestGUIAmbulancias ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	public ViewMenuServicios(TestGUIAmbulancias ventanaPrincipal) {
		setBackground(Color.WHITE);

		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		add(panel, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_1.getLayout();
		flowLayout_3.setVgap(15);
		add(panel_1, BorderLayout.NORTH);
		
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
		panel_4.setLayout(new GridLayout(6, 0, 0, 10));
		
		txtrMenServicios = new JTextArea();
		txtrMenServicios.setEditable(false);
		txtrMenServicios.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		txtrMenServicios.setForeground(new Color(0, 0, 128));
		txtrMenServicios.setText("            MENU SERVICIOS");
		panel_4.add(txtrMenServicios);
		
		btnRegistrarServicio = new JButton("Registrar Servicio");
		btnRegistrarServicio.setIcon(new ImageIcon(ViewMenuServicios.class.getResource("/Iconos/Patient_invalid_hospital_woman2.png")));
		btnRegistrarServicio.setForeground(Color.WHITE);
		btnRegistrarServicio.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnRegistrarServicio.setBackground(Color.DARK_GRAY);
		btnRegistrarServicio.setOpaque(true);
		btnRegistrarServicio.setBorderPainted(false);
		btnRegistrarServicio.addActionListener(this.controller.getMenuServicios());
		panel_4.add(btnRegistrarServicio);
		
		btnAsignarServicio = new JButton("Asignar Servicio");
		btnAsignarServicio.setIcon(new ImageIcon(ViewMenuServicios.class.getResource("/Iconos/Physician_head_doctor_MD_woman2.png")));
		btnAsignarServicio.setForeground(Color.WHITE);
		btnAsignarServicio.setBackground(Color.WHITE);
		btnAsignarServicio.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAsignarServicio.setBackground(Color.DARK_GRAY);
		btnAsignarServicio.setOpaque(true);
		btnAsignarServicio.setBorderPainted(false);
		btnAsignarServicio.addActionListener(controller.get);
		panel_4.add(btnAsignarServicio);
		
		btnFinalizarServicio = new JButton("Finalizar Servicio");
		btnFinalizarServicio.setIcon(new ImageIcon(ViewMenuServicios.class.getResource("/Iconos/Finalizar.png")));
		btnFinalizarServicio.setForeground(Color.WHITE);
		btnFinalizarServicio.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnFinalizarServicio.setBackground(Color.DARK_GRAY);
		btnFinalizarServicio.setOpaque(true);
		btnFinalizarServicio.setBorderPainted(false);
		btnFinalizarServicio.addActionListener(this.controller.getMenuServicios());
		panel_4.add(btnFinalizarServicio);
		
		btnReportePacientesAtendidos = new JButton("Pacientes atendidos");
		btnReportePacientesAtendidos.setIcon(new ImageIcon(ViewMenuServicios.class.getResource("/Iconos/Clien_list.png")));
		btnReportePacientesAtendidos.setForeground(Color.WHITE);
		btnReportePacientesAtendidos.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReportePacientesAtendidos.setBackground(Color.DARK_GRAY);
		btnReportePacientesAtendidos.setOpaque(true);
		btnReportePacientesAtendidos.setBorderPainted(false);
		panel_4.add(btnReportePacientesAtendidos);
		
		btnServiciosConIps = new JButton("Servicios con IPS y Ambulancias");
		btnServiciosConIps.setIcon(new ImageIcon(ViewMenuServicios.class.getResource("/Iconos/Report.png")));
		btnServiciosConIps.setForeground(Color.WHITE);
		btnServiciosConIps.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnServiciosConIps.setBackground(Color.DARK_GRAY);
		btnServiciosConIps.setOpaque(true);
		btnServiciosConIps.setBorderPainted(false);
		panel_4.add(btnServiciosConIps);
		
		
	}
	
	
	

}
