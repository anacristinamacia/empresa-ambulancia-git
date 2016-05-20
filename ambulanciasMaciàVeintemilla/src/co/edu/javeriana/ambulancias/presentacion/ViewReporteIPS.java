package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class ViewReporteIPS extends JPanel {

	/**
	 * Create the panel.
	 */
	public ViewReporteIPS() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		add(panel_3, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		add(panel_4, BorderLayout.CENTER);

	}

}
