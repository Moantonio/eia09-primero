package controller;

import view.View;
import model.Model;

/**
 * Implementa el controlador de la aplicación según el 
 * patrón Model-View-Controller (MVC).
 * @author Vicente Cruz & Enrique Gallego & Luis González.
 */
public class ControllerImp implements Controller{

	/**
	 * Modelo asociado al controlador.
	 */
	private Model model;
	
	/**
	 * Vista asociada al controlador.
	 */
	private View view;

	/**
	 * Constructor por defecto.
	 */
	public ControllerImp(){
		model = null;
		view = null;
	}
	
	/**
	 * Constructor por parámetros.
	 * @param modelo Modelo a asociar al controlador.
	 * @param vista Vista a asociar al controlador.
	 */
	public ControllerImp(Model model, View view){
		this.model = model;
		this.view = view;
	}
	
	public void refreshView() {
		view.refreshView();
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setView(View view) {
		this.view = view;
	}

}