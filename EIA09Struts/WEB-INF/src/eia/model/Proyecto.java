/**
 * 
 */
package eia.model;

import eia.util.Constants;

/**
 * @author usuario_local
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
	
	//private factores
	
	public Proyecto (InfoProyecto informacion, TipoProyecto tipo){
		this.informacion = informacion;
		this.tipo = tipo;
		alternativas = new Alternativa[Constants.MaxArray];
	}
	
	/**
	 * 
	 */
	public Proyecto() {
		informacion = null;
		tipo = null;
		alternativas = null;
	}

	/**
	 * @return the informacion
	 */
	public InfoProyecto getInformacion() {
		return informacion;
	}

	/**
	 * @param informacion the informacion to set
	 */
	public void setInformacion(InfoProyecto informacion) {
		this.informacion = informacion;
	}

	/**
	 * @return the tipo
	 */
	public TipoProyecto getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoProyecto tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the alternativas
	 */
	public Alternativa[] getAlternativas() {
		return alternativas;
	}

	/**
	 * @param alternativas the alternativas to set
	 */
	public void setAlternativas(Alternativa[] alternativas) {
		this.alternativas = alternativas;
	}

}
