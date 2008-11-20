package eia.model;

import eia.util.*;

/**
 * 
 * @author 
 *
 */

public class Alternativa {
	
	/**
	 * 
	 */
	private String id;
	
	//Arbol[accion] acciones;
	
	/**
	 * 
	 */
	private Efecto[] efectos;
	
	/**
	 * 
	 */
	private double valorTotal;
	
	/**
	 * 
	 */
	public Alternativa(){
		
		id ="";
		// acciones
		efectos = new Efecto[Constants.MaxArray];
		valorTotal = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Efecto[] getEfectos() {
		return efectos;
	}

	public void setEfectos(Efecto[] efectos) {
		this.efectos = efectos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
