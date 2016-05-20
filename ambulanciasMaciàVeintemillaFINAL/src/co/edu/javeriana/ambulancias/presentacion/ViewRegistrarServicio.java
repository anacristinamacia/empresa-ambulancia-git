package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Controller;
import co.edu.javeriana.ambulancias.anumerados.TipoDireccion;
import co.edu.javeriana.ambulancias.anumerados.TipoServicio;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;

public class ViewRegistrarServicio extends JPanel {
	private JTextField textPaciente;
	private JTextField textTelefono;
	private JTextField textCalle;
	private JTextField textCarrera;
	private JTextField textNumero;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNuevoServicio;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnAceptar;
	private JPanel panel_4;
	private JLabel lblPaciente;
	private JLabel lblTipoServicio;
	private JComboBox comboBoxTipoServ;
	private JLabel lblTelefono;
	private JLabel lblTipoDireccion;
	private JComboBox comboBoxTipoDirec;
	private JLabel lblCalle;
	private JLabel lblCarrera;
	private JLabel lblNumero;
	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;

	/**
	 * Create the panel.
	 */
	public ViewRegistrarServicio(TestGUIAmbulancias ventanaPrincipal) {
		
		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		add(panel, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setVgap(20);
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.NORTH);
		
		lblNuevoServicio = new JLabel("NUEVO SERVICIO");
		lblNuevoServicio.setForeground(new Color(0, 0, 128));
		lblNuevoServicio.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		panel_1.add(lblNuevoServicio);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(50);
		add(panel_2, BorderLayout.EAST);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		panel_3.setBackground(Color.WHITE);
		add(panel_3, BorderLayout.SOUTH);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.DARK_GRAY);
		btnAceptar.setOpaque(true);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setForeground(Color.WHITE);
		panel_3.add(btnAceptar);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(7, 1, 0, 0));
		
		lblPaciente = new JLabel("Paciente");
		lblPaciente.setForeground(Color.DARK_GRAY);
		panel_4.add(lblPaciente);
		
		textPaciente = new JTextField();
		panel_4.add(textPaciente);
		textPaciente.setColumns(10);
		
		lblTipoServicio = new JLabel("Tipo Servicio");
		lblTipoServicio.setForeground(Color.DARK_GRAY);
		panel_4.add(lblTipoServicio);
		
		TipoServicio tipoS = TipoServicio.DOMICILIO;
		comboBoxTipoServ = new JComboBox();
		comboBoxTipoServ.setBackground(Color.WHITE);
		comboBoxTipoServ.addItem(tipoS.DOMICILIO);
		comboBoxTipoServ.addItem(tipoS.EMERGENCIA);
		comboBoxTipoServ.addItem(tipoS.URGENCIA);
		panel_4.add(comboBoxTipoServ);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.DARK_GRAY);
		panel_4.add(lblTelefono);
		
		textTelefono = new JTextField();
		panel_4.add(textTelefono);
		textTelefono.setColumns(10);
		
		lblTipoDireccion = new JLabel("Tipo Direccion");
		lblTipoDireccion.setForeground(Color.DARK_GRAY);
		panel_4.add(lblTipoDireccion);
		
		TipoDireccion tipoDir = TipoDireccion.CALLE;
		comboBoxTipoDirec = new JComboBox();
		comboBoxTipoDirec.addItem(tipoDir.CALLE);
		comboBoxTipoDirec.addItem(tipoDir.CARRERA);
		panel_4.add(comboBoxTipoDirec);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setForeground(Color.DARK_GRAY);
		panel_4.add(lblCalle);
		
		textCalle = new JTextField();
		panel_4.add(textCalle);
		textCalle.setColumns(10);
		
		lblCarrera = new JLabel("Carrera");
		lblCarrera.setForeground(Color.DARK_GRAY);
		panel_4.add(lblCarrera);
		
		textCarrera = new JTextField();
		panel_4.add(textCarrera);
		textCarrera.setColumns(10);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setForeground(Color.DARK_GRAY);
		panel_4.add(lblNumero);
		
		textNumero = new JTextField();
		panel_4.add(textNumero);
		textNumero.setColumns(10);

	}


	public JTextField getTextPaciente() {
		return textPaciente;
	}


	public void setTextPaciente(JTextField textPaciente) {
		this.textPaciente = textPaciente;
	}


	public JTextField getTextTelefono() {
		return textTelefono;
	}


	public void setTextTelefono(JTextField textTelefono) {
		this.textTelefono = textTelefono;
	}


	public JTextField getTextCalle() {
		return textCalle;
	}


	public void setTextCalle(JTextField textCalle) {
		this.textCalle = textCalle;
	}


	public JTextField getTextCarrera() {
		return textCarrera;
	}


	public void setTextCarrera(JTextField textCarrera) {
		this.textCarrera = textCarrera;
	}


	public JTextField getTextNumero() {
		return textNumero;
	}


	public void setTextNumero(JTextField textNumero) {
		this.textNumero = textNumero;
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


	public JLabel getLblNuevoServicio() {
		return lblNuevoServicio;
	}


	public void setLblNuevoServicio(JLabel lblNuevoServicio) {
		this.lblNuevoServicio = lblNuevoServicio;
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


	public JLabel getLblPaciente() {
		return lblPaciente;
	}


	public void setLblPaciente(JLabel lblPaciente) {
		this.lblPaciente = lblPaciente;
	}


	public JLabel getLblTipoServicio() {
		return lblTipoServicio;
	}


	public void setLblTipoServicio(JLabel lblTipoServicio) {
		this.lblTipoServicio = lblTipoServicio;
	}


	public JComboBox getComboBoxTipoServ() {
		return comboBoxTipoServ;
	}


	public void setComboBoxTipoServ(JComboBox comboBoxTipoServ) {
		this.comboBoxTipoServ = comboBoxTipoServ;
	}


	public JLabel getLblTelefono() {
		return lblTelefono;
	}


	public void setLblTelefono(JLabel lblTelefono) {
		this.lblTelefono = lblTelefono;
	}


	public JLabel getLblTipoDireccion() {
		return lblTipoDireccion;
	}


	public void setLblTipoDireccion(JLabel lblTipoDireccion) {
		this.lblTipoDireccion = lblTipoDireccion;
	}


	public JComboBox getComboBoxTipoDirec() {
		return comboBoxTipoDirec;
	}


	public void setComboBoxTipoDirec(JComboBox comboBoxTipoDirec) {
		this.comboBoxTipoDirec = comboBoxTipoDirec;
	}


	public JLabel getLblCalle() {
		return lblCalle;
	}


	public void setLblCalle(JLabel lblCalle) {
		this.lblCalle = lblCalle;
	}


	public JLabel getLblCarrera() {
		return lblCarrera;
	}


	public void setLblCarrera(JLabel lblCarrera) {
		this.lblCarrera = lblCarrera;
	}


	public JLabel getLblNumero() {
		return lblNumero;
	}


	public void setLblNumero(JLabel lblNumero) {
		this.lblNumero = lblNumero;
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
	
	

}
