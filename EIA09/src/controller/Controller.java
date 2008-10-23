package controller;

import view.View;
import model.Model;

/**
 * Interface que modela el controlador en el patrón 
 * Model-View-Controller (MVC).
 * @author Vicente Cruz % Enrique Gallego & Luis González.
 */
public interface Controller {

	/**
	 * Establece la vista del patrón MVC a usar desde 
	 * el controlador.
	 * @param view Vista a asociar al controlar.
	 */
	public void setView(View view);

	/**
	 * Establece el modelo del patrón MVC a usar desde 
	 * el controlador.
	 * @param model Modelo a asociar al controlar.
	 */
	public void setModel(Model model);

	/**
	 * Actualiza la vista asociada al controlador.
	 */
	public void refreshView();
}
