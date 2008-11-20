package eia.model;

import eia.util.Constants;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * 
 */
public class Proyecto {
	
	/**
	 * 
	 */
	private InfoProyecto informacion;
	
	/**
	 * 
	 */
	private TipoProyecto tipo;
	
	/**
	 * 
	 */
	private Alternativa[] alternativas;
	
	//TODO Arbol de factores

	/**
	 * 
	 * @param informacion
	 * @param tipo
	 */
	public Proyecto (InfoProyecto informacion, TipoProyecto tipo){
		this.informacion = informacion;
		this.tipo = tipo;
		alternativas = new Alternativa[Constants.MaxArray];
		//TODO inicializar factores
	}
	
	/**
	 * 
	 */
	public Proyecto() {
		informacion = null;
		tipo = null;
		alternativas = null;
		//TODO inicializar factores
	}

	/**
	 * 
	 * @return 
	 */
	public InfoProyecto getInformacion() {
		return informacion;
	}

	/**
	 * 
	 * @param informacion
	 */
	public void setInformacion(InfoProyecto informacion) {
		this.informacion = informacion;
	}

	/**
	 * 
	 * @return
	 */
	public TipoProyecto getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(TipoProyecto tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return
	 */
	public Alternativa[] getAlternativas() {
		return alternativas;
	}

	/**
	 * @param alternativas 
	 */
	public void setAlternativas(Alternativa[] alternativas) {
		this.alternativas = alternativas;
	}
	
	// TODO Set y Get de factores

}
