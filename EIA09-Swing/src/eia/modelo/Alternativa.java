package eia.modelo;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import eia.util.ValorJuicio;


/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa una alternativa de realización de un proyecto.
 */
public class Alternativa implements Cloneable{

	/**
	 * Nombre de la alternativa de realización.
	 */
	private String id;

	/**
	 * Arbol de acciones de la alternativa de realización.
	 */
	private DefaultTreeModel acciones;  //  @jve:decl-index=0:

	/**
	 * Lista de efectos (impactos) asociados a la alternativa de realización.
	 */
	private ArrayList<Efecto> efectos;

	/**
	 * Valor total del impacto de la alternativa de realización.
	 */
	private double valorTotal;

	/**
	 * Indica si la alternativa ha sido valorada.
	 */
	private boolean valorada;

	/**
	 * Constructor por defecto.
	 */
	public Alternativa(){

		id ="";
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
		acciones = new DefaultTreeModel(nodo);
		efectos = new ArrayList<Efecto>();
		valorTotal = 0;
		valorada = false;
	}

	/**
	 * Constructor por parámetro.
	 * @param id Nombre de la alternativa de realización.
	 */
	public Alternativa(String id){

		this.id = id;
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
		acciones = new DefaultTreeModel(nodo);
		efectos = new ArrayList<Efecto>();
		valorTotal = 0;
		valorada = false;
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
	public ArrayList<Efecto> getEfectos() {
		return efectos;
	}

	/**
	 * Mutador para el atributo 'efectos'.
	 * @param efectos Lista de efectos a asociar a la alternativa de realización.
	 */
	public void setEfectos(ArrayList<Efecto> efectos) {
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

	/**
	 * Accesor para el atributo 'acciones'.
	 * @return Arbol de acciones asociadas a la alternativa de realización.
	 */
	public DefaultTreeModel  getAcciones() {
		return acciones;
	}

	/**
	 * Mutador para el atributo 'acciones'.
	 * @param acciones Lista de acciones a asociar a la alternativa de realización.
	 */
	public void setAcciones(DefaultTreeModel acciones) {
		this.acciones = acciones;
	}

	/**
	 * Accesor para el atributo 'valorada'.
	 * @return Indica si la alternativa ha sido valorada.
	 */
	public boolean getValorada() {
		return valorada;
	}

	/**
	 * Mutador para el atributo 'valorada'.
	 * @param valorada Valor a asignar al atributo.
	 */
	public void setValorada(boolean valorada) {
		this.valorada = valorada;
	}

	/**
	 * Función para calcular el valor total de impacto de la alternativa,
	 * estableciendo dicho valor en el atributo 'valorTotal'.
	 */
	public void calcularValorTotal(){
		double valor = 0;
		if (efectos.size()!=0){
			for(int i = 0; i<efectos.size();i++){
				if (efectos.get(i).getJuicio()==ValorJuicio.significativo){
					if (efectos.get(i).getValorTotal() == 0)
						efectos.get(i).calcularValorTotal();
					valor += efectos.get(i).getValorTotal();
				}
			}
			valorTotal = redondear(valor,3);
		}
	}

	/**
	 * Función para redondear un número de tipo double al número de cifras
	 * decimales indicadas por parámetro.
	 * @param nD Número a redondear.
	 * @param nDec Número de cifras decimales a redondear.
	 * @return Número redondeado.
	 */
	private double redondear(double nD, int nDec){
	  return Math.round(nD*Math.pow(10,nDec))/Math.pow(10,nDec);
	}

	/**
	 * Función para clonar el objeto Alternativa.
	 * @return Copia del objeto Alternativa.
	 */
    public Object clone(){
        Object copia = null;
        try{
            copia = super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Imposible duplicar");
        }
        if (this.id != null){
        	((Alternativa)copia).id = new String(this.id);
        }else{
        	((Alternativa)copia).id = new String();
        }

        ((Alternativa)copia).efectos = new ArrayList<Efecto>();
        for (int i=0; i<this.getEfectos().size();i++){
        	Efecto efecto = this.getEfectos().get(i);
        	((Alternativa)copia).efectos.add((Efecto) efecto.clone());
        }

        return copia;
    }

}
