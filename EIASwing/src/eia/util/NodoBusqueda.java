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

	/**
	 * Árbol padre donde está contenido el elemento.
	 */
	Arbol<Object> padre;
	
	/**
	 * Objeto elemento del que se presenta la información.
	 */
	Object elemento;
	
	/**
	 * Posición de hijo del elemento respecto al árbol donde está.
	 */
	int posicion;
	
	/**
	 * Constructor por defecto.
	 */
	public NodoBusqueda(){
		padre = null;
		elemento = null;
		posicion = 0;
	}
	
	/**
	 * Constructor por parámetros.
	 * @param padre Árbol padre donde está el elemento.
	 * @param elemento Elemento del que se presenta la información.
	 * @param posicion Posición de hijo del elemento respecto al árbol donde está.
	 */
	public NodoBusqueda(Arbol<Object> padre, Object elemento, int posicion){
		this.padre = padre;
		this.elemento = elemento;
		this.posicion = posicion;
	}
	
	/**
	 * Accesor para el atributo 'padre'.
	 * @return Árbol padre donde está el elemento.
	 */
	public Arbol<Object> getPadre() {
		return padre;
	}
	
	/**
	 * Mutador para el atributo 'padre'.
	 * @param padre Árbol padre a asociar, donde está el elemento.
	 */
	public void setPadre(Arbol<Object> padre) {
		this.padre = padre;
	}
	
	/**
	 * Accesor para el atributo 'elemento'.
	 * @return Elemento del que se presenta la información.
	 */
	public Object getElemento() {
		return elemento;
	}
	
	/**
	 * Mutador para el atributo 'elemento'.
	 * @param elemento Elemento a asociar del que se presenta la información.
	 */
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	/**
	 * Accesor para el atributo 'posicion'.
	 * @return Posición de hijo del elemento respecto al árbol donde está.
	 */
	public int getPosicion() {
		return posicion;
	}
	
	/**
	 * Mutador para el atributo 'posicion'.
	 * @param posicion Posición de hijo a asociar, del elemento respecto al árbol donde está.
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
}
