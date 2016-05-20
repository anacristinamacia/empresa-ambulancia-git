package co.edu.javeriana.ambulancias.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;

public class ViewAsignarServicio extends JPanel {
	
	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	
	public ViewAsignarServicio(TestGUIAmbulancias ventanaPrincipal){
		
		setLayout(new BorderLayout(0, 0));

		this.ventanaPrincipal = ventanaPrincipal;
		this.controller = new Controller(this.ventanaPrincipal);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setHgap(10);
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_1.getLayout();
		flowLayout_3.setVgap(10);
		add(panel_1, BorderLayout.NORTH);
		
		JLabel lblAsignarUnServicio = new JLabel("ASIGNAR UN SERVICIO");
		panel_1.add(lblAsignarUnServicio);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setHgap(10);
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(10);
		add(panel_3, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_3.add(btnAceptar);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(6, 1, 0, 0));
		
	}
	
	
	
}
