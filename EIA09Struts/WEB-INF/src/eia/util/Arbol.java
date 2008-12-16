package eia.util;

import java.util.ArrayList;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa la estructura 'Árbol general'.
 */
@SuppressWarnings("hiding")
public class Arbol<Object> {
	
	/**
	 * Objeto contenido por el nodo.
	 */
	private Object elemento;

	/**
	 * Listado de árboles hijo del nodo (ramificaciones).
	 */
	private ArrayList<Arbol<Object>> hijos;

	/**
	 * Constructor por parámetros.
	 * @param elemento Objeto a contener el nodo (raiz) del árbol.
	 * @param hijos Árboles hijo del nodo (raiz) del árbol.
	 */
	public Arbol(Object elemento, ArrayList<Arbol<Object>> hijos){
		this.elemento = elemento;
		this.hijos = hijos;
	}

	/**
	 * Constructor por defecto.
	 */
	public Arbol(){
		elemento = null;
		hijos = new ArrayList<Arbol<Object>>();
	}
	
	/**
	 * Constructor por parámetro.
	 * @param elemento Objeto a contener el nodo (raiz) del árbol.
	 */
	public Arbol(Object elemento){
		this.elemento = elemento;
		hijos = new ArrayList<Arbol<Object>>();
	}
	
	/**
	 * Mutador para el atributo 'elemento'.
	 * @param elemento Objeto a asociar al nodo (raiz) del árbol.
	 */
	public void setElemento(Object elemento){
		this.elemento = elemento;
	}
	
	/**
	 * Accesor para el atributo 'elemento'.
	 * @return Objeto contenido por el nodo (raiz) del árbol.
	 */
	public Object getElemento(){
		return elemento;
	}
	
	/**
	 * Accesor para el atributo 'hijos'.
	 * @return Árboles hijo asociados al nodo (raiz) del árbol.
	 */
	public ArrayList<Arbol<Object>> getHijos(){
		return hijos;
	}
	
	/**
	 * Mutador para el atributo 'hijos'.
	 * @param hijos Árboles hijo a asociar al nodo (raiz) del árbol.
	 */
	public void setHijos(ArrayList<Arbol<Object>> hijos){
		this.hijos = hijos;
	}
	
	/**
	 * Comprueba si el árbol representa un nodo hoja (sin hijos).
	 * @return TRUE si es hoja, FALSE en caso contrario.
	 */
	public boolean esHoja(){
		return hijos.size() == 0;
	}
	
	/**
	 * Inserta un árbol hijo al árbol (nodo) actual.
	 * @param hijo Árbol a añadir como hijo.
	 */
	public void añadirHijo(Arbol<Object> hijo){
		hijos.add(hijo);
	}
	
	/**
	 * Busca información acerca de un elemento en el árbol.
	 * @param padre Padre del nodo árbol actual donde iniciamos la búsqueda.
	 * @param posicion Posición de hijo del nodo actual del árbol donde iniciamos la búsqueda.
	 * @param id Identificación para la búsqueda del elemento en el árbol.
	 * @return Información general acerca del elemento buscado (si se ha encontrado),
	 * 		   siendo 'null' en caso contrario.
	 */
	private NodoBusqueda<Object> buscarInfoElemento(Arbol<Object> padre, int posicion, String id){
		
		if (elemento!= null && elemento.toString().equals(id)){
			NodoBusqueda<Object> elementoEncontrado = new NodoBusqueda<Object>(padre,elemento,posicion);
			return elementoEncontrado;
		}
		if (!this.esHoja()){
			int i = 0;
			int numHijos = hijos.size();
			NodoBusqueda<Object> elementoEncontrado = null;
			while (i<numHijos && elementoEncontrado == null){
				elementoEncontrado = hijos.get(i).buscarInfoElemento(this,i,id);
				i++;
			}
			return elementoEncontrado;
		}
		return null;
	}
	
	/**
	 * Busca un elemento en el árbol.
	 * @param id Identificación para la búsqueda del elemento en el árbol.
	 * @return Elemento buscado (si se ha encontrado), siendo 'null' en caso contrario.
	 */
	public Object buscarElemento(String id){
		NodoBusqueda<Object> busqueda = (buscarInfoElemento(null,0,id));
		if (busqueda!=null){
			return (Object) busqueda.getElemento();
		}
		return null;
	}
	
	/**
	 * Elimina un elemento (si existe) del árbol.
	 * @param id Identificación del elemento para su eliminación del árbol.
	 * @return TRUE si se ha podido eliminar, FALSE en caso contrario.
	 */
	public boolean eliminaElemento(String id){
		boolean exito = false;
		if (elemento.toString() == id){
			elemento = null;
			exito = true;
		}else{
			NodoBusqueda<Object> elemBusqueda = buscarInfoElemento(null,0,id);
			if (elemBusqueda!=null){
				int posicion = elemBusqueda.getPosicion();
				elemBusqueda.getPadre().getHijos().remove(posicion);	
				exito = true;
			}
		}
		return exito;
	}
}
