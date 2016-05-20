package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;

import Controller.Controller;

import java.awt.BorderLayout;

public class ViewReporteServicios extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private TestGUIAmbulancias ventanaPrincipal;
	private Controller controller;
	
	private BorderLayout layoutPrincipal;
	private JPanel panelNorth;
	private JPanel panelEast;
	private JPanel panelWest;
	private JPanel panelSouth;
	private JPanel panelCenter;
	

	public ViewReporteServicios(TestGUIAmbulancias ventanaPrincipal) {
		
		this.ventanaPrincipal= ventanaPrincipal;
		this.controller = new Controller (this.ventanaPrincipal);
		
		layoutPrincipal = new BorderLayout();
		setLayout(layoutPrincipal);
		
		JPanel panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		
		JPanel panelEast = new JPanel();
		add(panelEast, BorderLayout.WEST);
		
		JPanel panelWest = new JPanel();
		add(panelWest, BorderLayout.EAST);
		
		JPanel panelSouth = new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		
		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);

	}

	public BorderLayout getLayoutPrincipal() {
		return layoutPrincipal;
	}

	public void setLayoutPrincipal(BorderLayout layoutPrincipal) {
		this.layoutPrincipal = layoutPrincipal;
	}

	public JPanel getPanelNorth() {
		return panelNorth;
	}

	public void setPanelNorth(JPanel panelNorth) {
		this.panelNorth = panelNorth;
	}

	public JPanel getPanelEast() {
		return panelEast;
	}

	public void setPanelEast(JPanel panelEast) {
		this.panelEast = panelEast;
	}

	public JPanel getPanelWest() {
		return panelWest;
	}

	public void setPanelWest(JPanel panelWest) {
		this.panelWest = panelWest;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	public void setPanelSouth(JPanel panelSouth) {
		this.panelSouth = panelSouth;
	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
