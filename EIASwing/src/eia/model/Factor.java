package eia.model;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa un factor ambiental.
 */
public class Factor {
	/**
	 * Nombre del factor ambiental.
	 */
	private String id;
	
	/**
	 * Valor de peso del factor ambiental.
	 */
	private int peso;
	
	/**
	 * Constructor por defecto.
	 */
	public Factor(){
		id = "";
		peso = 0;
	}
	
	/**
	 * Constructor por parámetros.
	 * @param id Nombre del factor ambiental.
	 * @param peso Valor de peso del factor ambiental.
	 */
	public Factor(String id, int peso){
		this.id = id;
		this.peso = peso;
	}
	
	/**
	 * Mutador para el atributo 'id'.
	 * @param id Nombre a asignar al factor ambiental.
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 * Accesor para el atributo 'id'.
	 * @return Nombre del factor ambiental.
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * Mutador para el atributo 'peso'.
	 * @param peso Valor de peso a asignar al factor ambiental.
	 */
	public void setPeso(int peso){
		this.peso = peso;
	}
	
	/**
	 * Accesor para el atributo 'peso'.
	 * @return Valor de peso del factor ambiental.
	 */
	public int getPeso(){
		return peso;
	}
	
	/**
	 * Vuelca sobre un String la información sobre el factor.
	 * @return Cadena de caracteres con información sobre el factor.
	 */
	public String toString(){
		return id;
	}
}
