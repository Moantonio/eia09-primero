package eia.util;

import java.util.ArrayList;


/**
 * 
 * @author 
 *
 */

/**
 * 
 */
@SuppressWarnings("hiding")
public class Arbol<Object> {
	
	/**
	 * 
	 */
	private Object elemento;

	/**
	 * 
	 */
	private ArrayList<Arbol<Object>> hijos;

	/**
	 * 
	 * @param elemento
	 * @param hijos
	 */
	public Arbol(Object elemento, ArrayList<Arbol<Object>> hijos){
		this.elemento = elemento;
		this.hijos = hijos;
	}

	/**
	 * 
	 */
	public Arbol(){
		elemento = null;
		hijos = new ArrayList<Arbol<Object>>();
	}
	
	/**
	 * 
	 */
	public Arbol(Object elemento){
		this.elemento = elemento;
		hijos = new ArrayList<Arbol<Object>>();
	}
	
	/**
	 * 
	 * @param elemento
	 */
	public void setElemento(Object elemento){
		this.elemento = elemento;
	}
	
	/**
	 * 
	 * @return
	 */
	public Object getElemento(){
		return elemento;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Arbol<Object>> getHijos(){
		return hijos;
	}
	
	/**
	 * 
	 * @param hijos
	 */
	public void setHijos(ArrayList<Arbol<Object>> hijos){
		this.hijos = hijos;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean esHoja(){
		return hijos.size() == 0;
	}
	
	/**
	 * 
	 * @param hijo
	 */
	public void añadirHijo(Arbol<Object> hijo){
		hijos.add(hijo);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	private nodoBusqueda buscarInfoElemento(Arbol<Object> padre, int posicion, String id){
		
		if (elemento.toString() == id){
			nodoBusqueda elementoEncontrado = new nodoBusqueda(padre,elemento,posicion);
			return elementoEncontrado;
		}
		if (!this.esHoja()){
			int i = 0;
			int numHijos = hijos.size();
			nodoBusqueda elementoEncontrado = null;
			while (i<numHijos && elementoEncontrado == null){
				elementoEncontrado = hijos.get(i).buscarInfoElemento(this,i,id);
				i++;
			}
			return elementoEncontrado;
		}
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object buscarElemento(String id){
		nodoBusqueda busqueda = (buscarInfoElemento(null,0,id));
		if (busqueda!=null){
			return (Object) busqueda.getElemento();
		}
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean eliminaElemento(String id){
		boolean exito = false;
		if (elemento.toString() == id){
			elemento = null;
			exito = true;
		}else{
			nodoBusqueda elemBusqueda = buscarInfoElemento(null,0,id);
			if (elemBusqueda!=null){
				int posicion = elemBusqueda.getPosicion();
				elemBusqueda.getPadre().getHijos().remove(posicion);	
				exito = true;
			}
		}
		return exito;
	}
}
