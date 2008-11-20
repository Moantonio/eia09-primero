/**
 * 
 */
package eia.model;

/**
 * @author usuario_local
 *
 */
public class Efecto {

	/**
	 * 
	 */
	private Accion accion;
	
	/**
	 * 
	 */
	private Factor factor;
	
	/**
	 * 
	 */
	private String id;
	
	/**
	 * 
	 */
	private String descripcion;
	
	/**
	 * 
	 */
	private ValorJuicio juicio;

	/**
	 * 
	 */
	private double importancia;
	
	/**
	 * 
	 */
	private double valorCuantitativo;
	
	/**
	 * 
	 */
	private double valorTotal;
	
	/**
	 * 
	 */
	public Efecto(){
		accion = null;
		factor = null;
		id = "";
		descripcion = "";
		juicio = null;
		importancia = 0;
		valorCuantitativo = 0;
		valorTotal = 0;
	}
	
	/**
	 * 
	 * @param a
	 * @param f
	 * @param i
	 * @param d
	 * @param j
	 */
	public Efecto(Accion a, Factor f, String i, String d, ValorJuicio j){
		accion = a;
		factor = f;
		id = i;
		descripcion = d;
		juicio = j;
		importancia = 0;
		valorCuantitativo = 0;
		valorTotal = 0;
	}

	/**
	 * 
	 * @return
	 */
	public Accion getAccion() {
		return accion;
	}

	/**
	 * 
	 * @param accion
	 */
	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	/**
	 * 
	 * @return
	 */
	public Factor getFactor() {
		return factor;
	}

	/**
	 * 
	 * @param factor
	 */
	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	/**
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * 
	 * @return
	 */
	public ValorJuicio getJuicio() {
		return juicio;
	}

	/**
	 * 
	 * @param juicio
	 */
	public void setJuicio(ValorJuicio juicio) {
		this.juicio = juicio;
	}

	/**
	 * 
	 * @return
	 */
	public double getImportancia() {
		return importancia;
	}

	/**
	 * 
	 * @param importancia
	 */
	public void setImportancia(double importancia) {
		this.importancia = importancia;
	}

	/**
	 * 
	 * @return
	 */
	public double getValorCuantitativo() {
		return valorCuantitativo;
	}

	/**
	 * 
	 * @param valorCuantitativo
	 */
	public void setValorCuantitativo(double valorCuantitativo) {
		this.valorCuantitativo = valorCuantitativo;
	}

	/**
	 * 
	 * @return
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * 
	 * @param valorTotal
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
