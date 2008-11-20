package eia.model;

import java.util.Date;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * 
 */
public class InfoProyecto {

	/**
	 * 
	 */
	private String nombre;
	
	/**
	 * 
	 */
	private String descripcion;
	
	/**
	 * 
	 */
	private String compania;
	
	/**
	 * 
	 */
	private String autor;
	
	/**
	 * 
	 */
	private String poblacion;
	
	/**
	 * 
	 */
	private String provincia;
	
	/**
	 * 
	 */
	private String pais;
	
	/**
	 * 
	 */
	private Date fecha;
	
	/**
	 * 
	 */
	private int vidaUtil;
	
	/**
	 * 
	 */
	public InfoProyecto() {
		this.nombre = "";
		this.descripcion = "";
		this.compania = "";
		this.autor = "";
		this.poblacion = "";
		this.provincia = "";
		this.pais = "";
		this.fecha = null;
		this.vidaUtil = 0;
	}
	
	/**
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param compania
	 * @param autor
	 * @param poblacion
	 * @param provincia
	 * @param pais
	 * @param fecha
	 * @param vidaUtil
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
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getCompania() {
		return compania;
	}

	/**
	 * 
	 * @param compania
	 */
	public void setCompania(String compania) {
		this.compania = compania;
	}

	/**
	 * 
	 * @return
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * 
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * 
	 * @return
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * 
	 * @param poblacion
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * 
	 * @return
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * 
	 * @param provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * 
	 * @return
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * 
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * 
	 * @return
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * 
	 * @return
	 */
	public int getVidaUtil() {
		return vidaUtil;
	}

	/**
	 * 
	 * @param vidaUtil
	 */
	public void setVidaUtil(int vidaUtil) {
		this.vidaUtil = vidaUtil;
	}
}
