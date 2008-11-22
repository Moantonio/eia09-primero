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
public class Arbol {
	
	/**
	 * 
	 */
	private Object elemento;

	/**
	 * 
	 */
	private ArrayList<Arbol> hijos;

	/**
	 * 
	 * @param elemento
	 * @param hijos
	 */
	public Arbol(Object elemento, ArrayList<Arbol> hijos){
		this.elemento = elemento;
		this.hijos = hijos;
	}

	/**
	 * 
	 */
	public Arbol(){
		elemento = null;
		hijos = new ArrayList<Arbol>();
	}
	
	/**
	 * 
	 */
	public Arbol(Object elemento){
		this.elemento = elemento;
		hijos = new ArrayList<Arbol>();
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
	public ArrayList<Arbol> getHijos(){
		return hijos;
	}
	
	/**
	 * 
	 * @param hijos
	 */
	public void setHijos(ArrayList<Arbol> hijos){
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
	public void añadirHijo(Arbol hijo){
		hijos.add(hijo);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	private nodoBusqueda buscarInfoElemento(Arbol padre, int posicion, String id){
		
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
	public Object buscarElemento(String id){
		nodoBusqueda busqueda = (buscarInfoElemento(null,0,id));
		if (busqueda!=null){
			return busqueda.getElemento();
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
		
		// RAIZ
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
	
	public String toString(){
		
		String info = elemento.toString();
		for(int i = 0;i< hijos.size();i++){
			info = info + '\n' + hijos.get(i).toString();
		}
		return info;
	}
}
