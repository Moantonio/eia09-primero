package eia.util;


/**
 * @author Luis
 *
 */
public class nodoBusqueda {

	Arbol padre;
	Object elemento;
	int posicion;
	
	public nodoBusqueda(){
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
	public nodoBusqueda(Arbol padre2, Object elemento, int posicion){
		this.padre = padre2;
		this.elemento = elemento;
		this.posicion = posicion;
	}

	/**
	 * 
	 * @return
	 */
	public Arbol getPadre() {
		return padre;
	}
	
	/**
	 * 
	 * @param padre
	 */
	public void setPadre(Arbol padre) {
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
