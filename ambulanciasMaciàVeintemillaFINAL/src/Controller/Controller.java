package Controller;

import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class Controller {

	private TestGUIAmbulancias ventanaPrincipal;
	private MovePanelActionListener movePanel;
	private NegocioActionListener negocio;
	private OpenFileActionListener openFile;
	private RegistarPosicionListener registrarPosicion;
	
	public TestGUIAmbulancias getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	public void setVentanaPrincipal(TestGUIAmbulancias ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	public MovePanelActionListener getMovePanel() {
		return movePanel;
	}
	public void setMovePanel(MovePanelActionListener movePanel) {
		this.movePanel = movePanel;
	}
	public NegocioActionListener getNegocio() {
		return negocio;
	}
	
	public void setNegocio(NegocioActionListener negocio) {
		this.negocio = negocio;
	}
	public OpenFileActionListener getOpenFile() {
		return openFile;
	}
	public void setOpenFile(OpenFileActionListener openFile) {
		this.openFile = openFile;
	}
	
	
	public RegistarPosicionListener getRegistrarPosicion() {
		return registrarPosicion;
	}
	public void setRegistrarPosicion(RegistarPosicionListener registrarPosicion) {
		this.registrarPosicion = registrarPosicion;
	}
	public Controller(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
		this.negocio = new NegocioActionListener(ventanaPrincipal);
		System.out.println("negocioo");
		this.movePanel = new MovePanelActionListener(ventanaPrincipal);
		this.openFile = new OpenFileActionListener(ventanaPrincipal);
		this.registrarPosicion = new RegistarPosicionListener(ventanaPrincipal);
		System.out.println("controller creado");
	}
	
	
	
	
	

}
