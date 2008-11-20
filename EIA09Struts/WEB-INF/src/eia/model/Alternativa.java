package eia.model;

import eia.util.*;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa una alternativa de realización de un proyecto.
 */
public class Alternativa {
	
	/**
	 * Nombre de la alternativa de realización.
	 */
	private String id;
	
	//TODO Arbol de acciones
	
	/**
	 * Lista de efectos (impactos) asociados a la alternativa de realización.
	 */
	private Efecto[] efectos;
	
	/**
	 * Valor total del impacto de la alternativa de realización.
	 */
	private double valorTotal;
	
	/**
	 * Constructor por defecto.
	 */
	public Alternativa(){
		
		id ="";
		// TODO Inicializar acciones
		efectos = new Efecto[Constants.MaxArray];
		valorTotal = 0;
	}

	/**
	 * Accesor para el atributo 'id'.
	 * @return Nombre de la alternativa de realización.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Mutador para el atributo 'id'.
	 * @param id Nombre a asignar a la alternativa de realización.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Accesor para el atributo 'efectos'.
	 * @return Lista de efectos asociados a la alternativa de realización.
	 */
	public Efecto[] getEfectos() {
		return efectos;
	}

	/**
	 * Mutador para el atributo 'efectos'.
	 * @param efectos Lista de efectos a asociar a la alternativa de realización
	 */
	public void setEfectos(Efecto[] efectos) {
		this.efectos = efectos;
	}

	/**
	 * Accesor para el atributo 'valorTotal'.
	 * @return Valor total del impacto de la alternativa de realización.
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * Mutador para el atributo 'valorTotal'.
	 * @param valorTotal Valor total del impacto a asociar a la alternativa.
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	//TODO Getter y Setter del arbol de acciones.
	
}
