package eia.model;

import java.util.Date;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa la ficha con la información
 * de un proyecto de estudio de impacto ambiental.
 */
public class InfoProyecto {

	/**
	 * Nombre del proyecto de estudio de impacto ambiental.
	 */
	private String nombre;

	/**
	 * Descripción del proyecto de estudio de impacto ambiental.
	 */
	private String descripcion;

	/**
	 * Compañía propietaria del proyecto de estudio de impacto ambiental.
	 */
	private String compania;

	/**
	 * Autor propietario del proyecto de estudio de impacto ambiental.
	 */
	private String autor;

	/**
	 * Población de realización del proyecto de estudio de impacto ambiental.
	 */
	private String poblacion;

	/**
	 * Provincia de realización del proyecto de estudio de impacto ambiental.
	 */
	private String provincia;

	/**
	 * Pais de realización del proyecto de estudio de impacto ambiental.
	 */
	private String pais;

	/**
	 * Fecha de realización del proyecto de estudio de impacto ambiental.
	 */
	private Date fecha;

	/**
	 * Vida útil del proyecto de estudio de impacto ambiental.
	 */
	private int vidaUtil;

	/**
	 * Constructor por defecto.
	 */
	public InfoProyecto() {
		this.nombre = "";
		this.descripcion = "";
		this.compania = "";
		this.autor = "";
		this.poblacion = "";
		this.provincia = "";
		this.pais = "";
		this.fecha = new Date();
		this.vidaUtil = 0;
	}

	/**
	 * Constructor por parámetros.
	 * @param nombre Nombre del proyecto de estudio.
	 * @param descripcion Descripción del proyecto de estudio.
	 * @param compania Compañía propietaria del proyecto de estudio.
	 * @param autor Autor propietario del proyecto de estudio.
	 * @param poblacion Población de realización del proyecto de estudio.
	 * @param provincia Provincia de realización del proyecto de estudio.
	 * @param region Región de realización del proyecto de estudio.
	 * @param pais Pais de realización del proyecto de estudio.
	 * @param fecha Fecha de realización del proyecto de estudio.
	 * @param vidaUtil Vida útil del proyecto de estudio.
	 */
	public InfoProyecto(String nombre, String descripcion, String compania,
			String autor, String poblacion, String provincia, String pais,
			Date fecha, int vidaUtil) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.compania = compania;
		this.autor = autor;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.pais = pais;
		this.fecha = fecha;
		this.vidaUtil = vidaUtil;
	}

	/**
	 * Accesor para el atributo 'nombre'.
	 * @return Nombre del proyecto de estudio.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Mutador para el atributo 'nombre'.
	 * @param nombre Nombre a asociar del proyecto de estudio.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Accesor para el atributo 'descripcion'.
	 * @return Descripción del proyecto de estudio.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Mutador para el atributo 'descripcion'.
	 * @param descripcion Descripción a asociar del proyecto de estudio.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Accesor para el atributo 'compania'.
	 * @return Compañía propietaria del proyecto de estudio.
	 */
	public String getCompania() {
		return compania;
	}

	/**
	 * Mutador para el atributo 'compania'.
	 * @param compania Compañía propietaria del proyecto de estudio a asociar.
	 */
	public void setCompania(String compania) {
		this.compania = compania;
	}

	/**
	 * Accesor para el atributo 'autor'.
	 * @return Autor propietario del proyecto de estudio.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Mutador para el atributo 'autor'.
	 * @param autor Autor propietario del proyecto de estudio a asociar.
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Accesor para el atributo 'poblacion'.
	 * @return Población de realización del proyecto de estudio.
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Mutador para el atributo 'poblacion'.
	 * @param poblacion Población de realización del proyecto de estudio a asociar.
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * Accesor para el atributo 'provincia'.
	 * @return Provincia de realización del proyecto de estudio.
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * Mutador para el atributo 'provincia'.
	 * @param provincia Provincia de realización del proyecto de estudio a asociar.
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * Accesor para el atributo 'pais'.
	 * @return Pais de realización del proyecto de estudio.
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Mutador para el atributo 'pais'.
	 * @param pais Pais de realización del proyecto de estudio a asociar.
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Accesor para el atributo 'fecha'.
	 * @return Fecha de realización del proyecto de estudio.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Mutador para el atributo 'fecha'.
	 * @param fecha Fecha de realización del proyecto de estudio a asociar.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Accesor para el atributo 'vidaUtil'.
	 * @return Vida útil del proyecto de estudio.
	 */
	public int getVidaUtil() {
		return vidaUtil;
	}

	/**
	 * Mutador para el atributo 'vidaUtil'.
	 * @param vidaUtil Vida útil del proyecto de estudio a asociar.
	 */
	public void setVidaUtil(int vidaUtil) {
		this.vidaUtil = vidaUtil;
	}
}
