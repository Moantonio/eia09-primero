package eia.model;

import java.util.ArrayList;
import eia.util.Arbol;

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
	private ArrayList<Alternativa> alternativas;
	
	//TODO private Arbol factores;

	/**
	 * 
	 * @param informacion
	 * @param tipo
	 */
	public Proyecto (InfoProyecto informacion, TipoProyecto tipo){
		this.informacion = informacion;
		this.tipo = tipo;
		alternativas = new ArrayList<Alternativa>();
		//TODO factores = new Arbol();
	}
	
	/**
	 * 
	 */
	public Proyecto() {
		informacion = null;
		tipo = null;
		alternativas = null;
		//TODO factores = new Arbol();
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
	public ArrayList<Alternativa> getAlternativas() {
		return alternativas;
	}

	/**
	 * @param alternativas 
	 */
	public void setAlternativas(ArrayList<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
	// TODO Getter y Setter del arbol de factores.

}
