package Controller;

import co.edu.javeriana.ambulancias.presentacion.TestGUIAmbulancias;

public class Controller {

	private TestGUIAmbulancias ventanaPrincipal;
	private MovePanelActionListener movePanel;
	private NegocioActionListener negocio;
	private OpenFileActionListener openFile;
	private RegistarPosicionListener registrarPosicion;
	private MenuAmbulanciasListener menuAmbulancias;
	private RegistrarServicio registrarServicio;
	private MenuServiciosListener menuServicios;
	private FinalizarServicioListener finalizarServicio;
	private ReporteServiciosListener reporteServicios;
	private AsignarServicioListener asignarServicio;
	
	
	public AsignarServicioListener getAsignarServicio() {
		return asignarServicio;
	}
	public void setAsignarServicio(AsignarServicioListener asignarServicio) {
		this.asignarServicio = asignarServicio;
	}
	public FinalizarServicioListener getFinalizarServicio() {
		return finalizarServicio;
	}
	public void setFinalizarServicio(FinalizarServicioListener finalizarServicio) {
		this.finalizarServicio = finalizarServicio;
	}
	public MenuServiciosListener getMenuServicios() {
		return menuServicios;
	}
	public void setMenuServicios(MenuServiciosListener menuServicios) {
		this.menuServicios = menuServicios;
	}
	public MenuAmbulanciasListener getMenuAmbulancias() {
		return menuAmbulancias;
	}
	public void setMenuAmbulancias(MenuAmbulanciasListener menuAmbulancias) {
		this.menuAmbulancias = menuAmbulancias;
	}
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
	public RegistrarServicio getRegistrarServicio() {
		return registrarServicio;
	}
	public void setRegistrarServicio(RegistrarServicio registrarServicio) {
		this.registrarServicio = registrarServicio;
	}
	
	public ReporteServiciosListener getReporteServicios() {
		return reporteServicios;
	}
	public void setReporteServicios(ReporteServiciosListener reporteServicios) {
		this.reporteServicios = reporteServicios;
	}
	public Controller(TestGUIAmbulancias ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
		this.negocio = new NegocioActionListener(ventanaPrincipal);
		this.movePanel = new MovePanelActionListener(ventanaPrincipal);
		this.openFile = new OpenFileActionListener(ventanaPrincipal);
		this.registrarPosicion = new RegistarPosicionListener(ventanaPrincipal);
		this.menuAmbulancias = new MenuAmbulanciasListener(ventanaPrincipal);
		this.registrarServicio = new RegistrarServicio(ventanaPrincipal);
		this.menuServicios = new MenuServiciosListener(ventanaPrincipal);
		this.finalizarServicio = new FinalizarServicioListener(ventanaPrincipal);
		this.reporteServicios = new ReporteServiciosListener(ventanaPrincipal);
		this.asignarServicio = new AsignarServicioListener(ventanaPrincipal);
	}
	
	
	
	
	

}
