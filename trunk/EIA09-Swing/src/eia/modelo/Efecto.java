package eia.modelo;

import eia.util.CaracterEfecto;
import eia.util.ValorJuicio;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa un efecto/impacto ambiental.
 */
public class Efecto implements Cloneable {

	/**
	 * Acción asociada al efecto/impacto.
	 */
	private Accion accion;

	/**
	 * Factor asociado al efecto/impacto.
	 */
	private Factor factor;

	/**
	 * Nombre del efecto/impacto ambiental.
	 */
	private String id;

	/**
	 * Descripción del efecto/impacto ambiental.
	 */
	private String descripcion;

	/**
	 * Valor del efecto/impacto por simple enjuiciamiento.
	 */
	private ValorJuicio juicio;

	/**
	 * Valoración cualitativa del efecto/impacto ambiental.
	 */
	private ValoracionCualitativa valCualitativa;

	/**
	 * Valoración cuantitativa del efecto/impacto ambiental.
	 */
	private ValoracionCuantitativa valCuantitativa;

	/**
	 * Valor total del efecto/impacto.
	 */
	private double valorTotal;

	/**
	 * Caracter de valoración del efecto/impacto ambiental.
	 */
	private CaracterEfecto caracter;

	/**
	 * Constructor por defecto.
	 */
	public Efecto(){
		accion = null;
		factor = null;
		id = "";
		descripcion = "";
		juicio = null;
		valCualitativa = null;
		valCuantitativa = null;
		valorTotal = 0;
		caracter = null;
	}

	/**
	 * Constructor por parámetros.
	 * @param accion Acción a asociar al efecto/impacto.
	 * @param factor Factor a asociar al efecto/impacto.
	 * @param id Nombre del efecto/impacto.
	 * @param descripcion Descripcion del efecto/impacto.
	 */
	public Efecto(Accion accion, Factor factor, String id, String descripcion){
		this.accion = accion;
		this.factor = factor;
		this.id = id;
		this.descripcion = descripcion;
		this.juicio = null;
		valCualitativa = null;
		valCuantitativa = null;
		valorTotal = 0;
		caracter = null;
	}

	/**
	 * Constructor por parámetros.
	 * @param accion Acción a asociar al efecto/impacto.
	 * @param factor Factor a asociar al efecto/impacto.
	 * @param id Nombre del efecto/impacto.
	 * @param descripcion Descripcion del efecto/impacto.
	 * @param juicio Valor del efecto/impacto por simple enjuiciamiento.
	 */
	public Efecto(Accion accion, Factor factor, String id, String descripcion, ValorJuicio juicio){
		this.accion = accion;
		this.factor = factor;
		this.id = id;
		this.descripcion = descripcion;
		this.juicio = juicio;
		valCualitativa = null;
		valCuantitativa = null;
		valorTotal = 0;
		caracter = null;
	}

	/**
	 * Accesor para el atributo 'accion'.
	 * @return Acción asociada al efecto/impacto.
	 */
	public Accion getAccion() {
		return accion;
	}

	/**
	 * Mutador para el atributo 'accion'.
	 * @param accion Acción ambiental a asociar al efecto/impacto.
	 */
	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	/**
	 * Accesor para el atributo 'factor'.
	 * @return Factor asociado al efecto/impacto.
	 */
	public Factor getFactor() {
		return factor;
	}

	/**
	 * Mutador para el atributo 'factor'.
	 * @param factor Factor a asociar al efecto/impacto.
	 */
	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	/**
	 * Accesor para el atributo 'id'.
	 * @return Nombre del efecto/impacto.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Mutador para el atributo 'id'.
	 * @param id Nombre a asociar al efecto/impacto.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Accesor para el atributo 'descripcion'.
	 * @return Descripción del efecto/impacto.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Mutador para el atributo 'descripcion'.
	 * @param descripcion Descripción a asociar al efecto/impacto.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Accesor para el atributo 'juicio'.
	 * @return Valor del efecto/impacto por simple enjuiciamiento.
	 */
	public ValorJuicio getJuicio() {
		return juicio;
	}

	/**
	 * Mutador para el atributo 'juicio'.
	 * @param juicio Valor a asociar del efecto/impacto por simple enjuiciamiento.
	 */
	public void setJuicio(ValorJuicio juicio) {
		this.juicio = juicio;
	}

	/**
	 * Accesor para el atributo 'valCualitativa'.
	 * @return Valoración cualitativa asociada al efecto/impacto.
	 */
	public ValoracionCualitativa getValCualitativa() {
		return valCualitativa;
	}

	/**
	 * Mutador para el atributo 'valCualitativa'.
	 * @param valCualitativa Valoración cualitativa a asociar al efecto/impacto.
	 */
	public void setValCualitativa(ValoracionCualitativa valCualitativa) {
		this.valCualitativa = valCualitativa;
	}

	/**
	 * Accesor para el atributo 'valCuantitativa'.
	 * @return Valoración cuantitativa asociada al efecto/impacto.
	 */
	public ValoracionCuantitativa getValCuantitativa() {
		return valCuantitativa;
	}

	/**
	 * Mutador para el atributo 'valCuantitativa'.
	 * @param valCuantitativa Valoración cuantitativa a asociar al efecto/impacto.
	 */
	public void setValCuantitativa(ValoracionCuantitativa valCuantitativa) {
		this.valCuantitativa = valCuantitativa;
	}

	/**
	 * Accesor para el atributo 'valorTotal'.
	 * @return Valor total del efecto/impacto.
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * Mutador para el atributo 'valorTotal'.
	 * @param valorTotal Valor total del efecto/impacto a asociar.
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * Accesor para el atributo 'caracter'.
	 * @return caracter Caracter de valoración del efecto/impacto.
	 */
	public CaracterEfecto getCaracter() {
		return caracter;
	}

	/**
	 * Mutador para el atributo 'caracter'.
	 * @param caracter Caracter del efecto/impacto a asociar.
	 */
	public void setCaracter(CaracterEfecto caracter) {
		this.caracter = caracter;
	}

	/**
	 * Función para calcular la valoración cuantitativa del efecto/impacto,
	 * estableciendo dicho valor en el atributo 'valCualitativa'.
	 */
	public void calcularValorCuantitativo(){
		//TODO Calcular Valor Cuantitativo
	}

	/**
	 * Función para calcular el valor total de impacto del efecto,
	 * estableciendo dicho valor en el atributo 'valorTotal'.
	 */
	public void calcularValorTotal(){
		if (valCualitativa!=null && valCuantitativa!=null){
			valorTotal = redondear(valCuantitativa.getMagnitudImpacto() * valCualitativa.getIncidencia()* factor.getPeso(),3);
		}else{
			valorTotal = 0;
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
	 * Función para clonar el objeto Efecto.
	 * @return Copia del objeto Efecto.
	 */
    public Object clone(){
        Object copia = null;
        try{
            copia = super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Imposible duplicar");
        }
        ((Efecto)copia).accion = this.accion;
        ((Efecto)copia).factor = this.factor;
        ((Efecto)copia).caracter = this.caracter;

        if (this.descripcion != null){
        	((Efecto)copia).descripcion = new String(this.descripcion);
        }else{
        	((Efecto)copia).descripcion = new String();
        }

        if (this.id != null){
        	((Efecto)copia).id = new String(this.id);
        }else{
        	((Efecto)copia).id = new String();
        }

        ((Efecto)copia).juicio = this.juicio;

        if (this.valCualitativa != null){
        	((Efecto)copia).valCualitativa = (ValoracionCualitativa) this.valCualitativa.clone();
        }else{
        	((Efecto)copia).valCualitativa = null;
        }

        if (this.valCuantitativa != null){
        	((Efecto)copia).valCuantitativa = (ValoracionCuantitativa) this.valCuantitativa.clone();
        }else{
        	((Efecto)copia).valCuantitativa = null;
        }
        return copia;
    }
}
