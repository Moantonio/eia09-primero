package eia.util;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa una estructura de información de un objeto contenido en un árbol.
 */
@SuppressWarnings("hiding")
public class NodoBusqueda<Object> {

	Arbol<Object> padre;
	Object elemento;
	int posicion;
	
	public NodoBusqueda(){
		padre = null;
		elemento = null;
		posicion = 0;
	}
	
	/**
	 * 
	 * @param padre2
	 * @param elemento
	 * @param posicion
	 */
	public NodoBusqueda(Arbol<Object> padre, Object elemento, int posicion){
		this.padre = padre;
		this.elemento = elemento;
		this.posicion = posicion;
	}
	
	/**
	 * 
	 * @return
	 */
	public Arbol<Object> getPadre() {
		return padre;
	}
	
	/**
	 * 
	 * @param padre
	 */
	public void setPadre(Arbol<Object> padre) {
		this.padre = padre;
	}
	
	/**
	 * 
	 * @return
	 */
	public Object getElemento() {
		return elemento;
	}
	
	/**
	 * 
	 * @param elemento
	 */
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPosicion() {
		return posicion;
	}
	
	/**
	 * 
	 * @param posicion
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
}
