package eia.model;

import java.util.ArrayList;

import javax.swing.tree.DefaultTreeModel;

import eia.util.TipoProyecto;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa un proyecto de estudio de impacto ambiental.
 */
public class Proyecto {

	/**
	 * Ficha de información general del proyecto de estudio.
	 */
	private InfoProyecto informacion;

	/**
	 * Tipo de proyecto de estudio.
	 */
	private TipoProyecto tipo;

	/**
	 * Alternativas de realización del proyecto.
	 */
	private ArrayList<Alternativa> alternativas;

	/**
	 * Factores ambientales influyentes para el estudio del proyecto.
	 */
	private DefaultTreeModel factores;

	/**
	 * Contructor por parámetros.
	 * @param informacion Ficha de información del proyecto de estudio.
	 * @param tipo Tipo del proyecto de estudio.
	 */
	public Proyecto (InfoProyecto informacion, TipoProyecto tipo){
		this.informacion = informacion;
		this.tipo = tipo;
		alternativas = new ArrayList<Alternativa>();
		factores = null;
	}

	/**
	 * Constructor por defecto.
	 */
	public Proyecto() {
		informacion = null;
		tipo = null;
		alternativas = null;
		factores = null;
	}

	/**
	 * Accesor para el atributo 'informacion'.
	 * @return Ficha de información del proyecto.
	 */
	public InfoProyecto getInformacion() {
		return informacion;
	}

	/**
	 * Mutador para el atributo 'informacion'.
	 * @param informacion Ficha de información a asociar al proyecto.
	 */
	public void setInformacion(InfoProyecto informacion) {
		this.informacion = informacion;
	}

	/**
	 * Accesor para el atributo 'tipo'.
	 * @return Tipo del proyecto de estudio.
	 */
	public TipoProyecto getTipo() {
		return tipo;
	}

	/**
	 * Mutador para el atributo 'informacion'.
	 * @param tipo Tipo de proyecto de estudio a asociar.
	 */
	public void setTipo(TipoProyecto tipo) {
		this.tipo = tipo;
	}

	/**
	 * Accesor para el atributo 'alternativas'.
	 * @return Alternativas de realización del proyecto.
	 */
	public ArrayList<Alternativa> getAlternativas() {
		return alternativas;
	}

	/**
	 * Mutador para el atributo 'alternativas'.
	 * @param alternativas  Alternativas de realización a asociar al proyecto.
	 */
	public void setAlternativas(ArrayList<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	/**
	 * Accesor para el atributo 'factores'.
	 * @return Factores ambientales influyentes para el estudio del proyecto.
	 */
	public DefaultTreeModel getFactores() {
		return factores;
	}

    /**
     * Mutador para el atributo 'factores'.
     * @param factores Factores ambientes influyentes a asociar al proyecto.
     */
	public void setFactores(DefaultTreeModel factores) {
		this.factores = factores;
	}

	/**
	 * Función para la obtención de la mejor alternativa realizable de las
	 * establecidas en el proyecto.
	 * @return Mejor alternativa de realización del proyecto.
	 */
	public Alternativa analizarAlternativas(){
		int numAlternativas = alternativas.size();
		double mejorValor = -100;
		Alternativa mejorAlternativa = null;
		for (int i=0; i<numAlternativas;i++){
			if(mejorValor < alternativas.get(i).getValorTotal()){
				mejorValor = alternativas.get(i).getValorTotal();
				mejorAlternativa = alternativas.get(i);
			}
		}
		return mejorAlternativa;
	}
}
