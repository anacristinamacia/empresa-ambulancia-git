package co.edu.javeriana.ambulancias.presentacion;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;


public class TestGUIAmbulancias extends JFrame {

	private JPanel contentPane;
	private ViewMenu viewMenu;
	private ViewAmbulancias viewAmbulancias;
	private ViewIPS viewIPS;
	private ViewServicios viewServicios;
	private IServiciosAmbulancias empresaAmbulancias;
	private JTabbedPane tabbedPane;
	private Controller controller;
	//public Image imagenFondo;
	//public URL fondo;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUIAmbulancias frame = new TestGUIAmbulancias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewMenu getViewMenu() {
		return viewMenu;
	}

	public void setViewMenu(ViewMenu viewMenu) {
		this.viewMenu = viewMenu;
	}

	public ViewAmbulancias getViewAmbulancias() {
		return viewAmbulancias;
	}

	public void setViewAmbulancias(ViewAmbulancias viewAmbulancias) {
		this.viewAmbulancias = viewAmbulancias;
	}

	public ViewIPS getViewIPS() {
		return viewIPS;
	}

	public void setViewIPS(ViewIPS viewIPS) {
		this.viewIPS = viewIPS;
	}

	public ViewServicios getViewServicios() {
		return viewServicios;
	}

	public void setViewServicios(ViewServicios viewServicios) {
		this.viewServicios = viewServicios;
	}

	public IServiciosAmbulancias getEmpresaAmbulancias() {
		return empresaAmbulancias;
	}

	public void setEmpresaAmbulancias(IServiciosAmbulancias empresaAmbulancias) {
		this.empresaAmbulancias = empresaAmbulancias;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Create the frame.
	 */
	public TestGUIAmbulancias() {
		
		this.empresaAmbulancias = new EmpresaAmbulancias();
		
		controller = new Controller(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		viewMenu = new ViewMenu(this);
		tabbedPane.addTab("Menú", new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/List.png"), viewMenu, null);
		
		viewAmbulancias = new ViewAmbulancias(this);
		tabbedPane.addTab("Ambulancias", new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/Emergency_off.png"), viewAmbulancias, null);
		
		viewIPS = new ViewIPS(this);
		tabbedPane.addTab("IPS", new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/redcross.png"), viewIPS, null);
		
		viewServicios = new ViewServicios();
		tabbedPane.addTab("Servicios", new ImageIcon("/Users/AnaCristina/Dropbox/02. Ana Cris/Shared Cris-Mami/Iconos/sign-in.png"), viewServicios, null);
		
		
	}
	
	public void salvarDatos () {
		JFileChooser chooser = new JFileChooser( "./data" );
		int returnVal = chooser.showSaveDialog(this);
		if( returnVal == JFileChooser.APPROVE_OPTION ){
			String pathArchivo = chooser.getSelectedFile().getParent();
			String nombreArchivo = chooser.getSelectedFile().getName();
			try { 
				ManejoArchivos.guardarDatos (empresaAmbulancias, pathArchivo, nombreArchivo);
				JOptionPane.showMessageDialog (this,"Información guardada con éxito","Información sobre salvar datos",JOptionPane.WARNING_MESSAGE);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"Problema ingresando nombre de archivo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void cargarDatos () {
		JFileChooser chooser = new JFileChooser( "./data" );
		int returnVal = chooser.showOpenDialog(this);
		if( returnVal == JFileChooser.APPROVE_OPTION ){
			String pathArchivo = chooser.getSelectedFile().getParent();
			String nombreArchivo = chooser.getSelectedFile().getName();
			try { 
				this.empresaAmbulancias = ManejoArchivos.cargarDatos(pathArchivo, nombreArchivo);
				JOptionPane.showMessageDialog(this,"Datos guardados con exito");
				//this.cargarServiciosPorFinalizar();
				//this.cargarIPS();
				//this.cargarTablaAmbu();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),
						"problema archivo ", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
