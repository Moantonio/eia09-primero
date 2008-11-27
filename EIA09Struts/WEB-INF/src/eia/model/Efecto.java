package eia.model;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa un efecto/impacto ambiental.
 */
public class Efecto {

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
	 * 
	 */
	private ValoracionCualitativa valCualitativa;
	
	/**
	 * Valor según análisis cuantitativo del efecto/impacto.
	 */
	private double valorCuantitativo;
	
	/**
	 * Valor total del efecto/impacto.
	 */
	private double valorTotal;
	
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
		valorCuantitativo = 0;
		valorTotal = 0;
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
		valorCuantitativo = 0;
		valorTotal = 0;
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
	 * @return 
	 */
	public ValoracionCualitativa getValCualitativa() {
		return valCualitativa;
	}

	/**
	 * Mutador para el atributo 'valCualitativa'.
	 * @param 
	 */
	public void setValCualitativa(ValoracionCualitativa valCualitativa) {
		this.valCualitativa = valCualitativa;
	}

	/**
	 * Accesor para el atributo 'valorCuantitativo'.
	 * @return Valor del efecto/impacto según análisis cuantitativo.
	 */ 
	public double getValorCuantitativo() {
		return valorCuantitativo;
	}

	/**
	 * Mutador para el atributo 'valorCuantitativo'.
	 * @param valorCuantitativo Valor, según análisis cuantitativo, a asociar al efecto/impacto.
	 */
	public void setValorCuantitativo(double valorCuantitativo) {
		this.valorCuantitativo = valorCuantitativo;
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
	 * @param valorTotal  Valor total del efecto/impacto a asociar.
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
