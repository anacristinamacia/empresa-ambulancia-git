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

public class ViewMenuAmbulancias extends JPanel {

	/**
	 * Create the panel.
	 */
	public ViewMenuAmbulancias() {

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
		flowLayout_2.setHgap(50);
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(20);
		add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setHgap(50);
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(20);
		add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(5, 1, 2, 20));
		
		JTextArea txtrMenAmbulancias = new JTextArea();
		txtrMenAmbulancias.setText("         MENÚ AMBULANCIAS");
		txtrMenAmbulancias.setForeground(new Color(0, 0, 128));
		txtrMenAmbulancias.setEditable(false);
		txtrMenAmbulancias.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		panel_4.add(txtrMenAmbulancias);
		
		JButton btnIngresarAmbulancias = new JButton("Ingresar Ambulancias");
		btnIngresarAmbulancias.setForeground(Color.WHITE);
		btnIngresarAmbulancias.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/AmbulancePeq.png"));
		btnIngresarAmbulancias.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnIngresarAmbulancias.setBackground(Color.DARK_GRAY);
		btnIngresarAmbulancias.setOpaque(true);
		btnIngresarAmbulancias.setBorderPainted(false);
		panel_4.add(btnIngresarAmbulancias);
		
		JButton btnRegistrarPosicion = new JButton("Registrar Posición");
		btnRegistrarPosicion.setForeground(Color.WHITE);
		btnRegistrarPosicion.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnRegistrarPosicion.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/marker-2---add.png"));
		btnRegistrarPosicion.setBackground(Color.DARK_GRAY);
		btnRegistrarPosicion.setOpaque(true);
		btnRegistrarPosicion.setBorderPainted(false);
		panel_4.add(btnRegistrarPosicion);
		
		JButton btnReporteAmbulancias = new JButton("Reporte de Ambulancias");
		btnReporteAmbulancias.setForeground(Color.WHITE);
		btnReporteAmbulancias.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReporteAmbulancias.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Report.png"));
		btnReporteAmbulancias.setBackground(Color.DARK_GRAY);
		btnReporteAmbulancias.setOpaque(true);
		btnReporteAmbulancias.setBorderPainted(false);
		panel_4.add(btnReporteAmbulancias);
		
		JButton btnEstadisticas = new JButton(" Ambulancias disponibles");
		btnEstadisticas.setForeground(Color.WHITE);
		btnEstadisticas.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnEstadisticas.setIcon(new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Statistics.png"));
		btnEstadisticas.setBackground(Color.DARK_GRAY);
		btnEstadisticas.setOpaque(true);
		btnEstadisticas.setBorderPainted(false);
		panel_4.add(btnEstadisticas);
		
	}

}
