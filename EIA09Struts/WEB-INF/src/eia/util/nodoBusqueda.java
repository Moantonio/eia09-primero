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
	 * @param padre
	 * @param elemento
	 * @param posicion
	 */
	public nodoBusqueda(Arbol padre, Object elemento, int posicion){
		this.padre = padre;
		this.elemento = elemento;
		this.posicion = posicion;
	}
	
	public Arbol getPadre() {
		return padre;
	}
	public void setPadre(Arbol padre) {
		this.padre = padre;
	}
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
}
