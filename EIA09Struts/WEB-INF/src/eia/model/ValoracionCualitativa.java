package eia.model;

public class ValoracionCualitativa {

	/**
	 * Signo:
	 * TRUE: Positivo
	 * FALSE: Negativo
	 */
	private boolean signo;
	
	/**
	 * Momento:
	 * 0 - Corto plazo
	 * 1 - Medio plazo
	 * 2 - Largo plazo
	 */
	private int momento;
	
	/**
	* Inmediatez:
 	* TRUE: Directa
 	* FALSE: Indirecta
 	*/
	private boolean inmediatez;
	
	/**
	 * Reversibilidad:
	 * TRUE: Reversible
	 * FALSE: Irreversible
	 */
	private boolean reversibilidad;
	
	/**
	 * Recuperabilidad:
	 * TRUE: Recuperable
	 * FALSE: Irrecuperable
	 */
	private boolean recuperabilidad;
	
	/**
	 * Acumulación:
	 * TRUE: Acumulativo
	 * FALSE: Simple
	 */
	private boolean acumulacion;
	
	/**
	 * Periodicidad:
	 * TRUE: Periódico
	 * FALSE: Irregular
	 */
	private boolean periodicidad;
	
	/**
	 * Persistencia:
	 * TRUE: Permanente
	 * FALSE: Temporal
	 */
	private boolean persistencia;
	
	/**
	 * Continuidad:
	 * TRUE: Continuo
	 * FALSE: Discontinuo
	 */
	private boolean continuidad;
	
	/**
	 * Sinergia:
	 * TRUE: Sinérgico
	 * FALSE: No sinérgico
	 */
	private boolean sinergia;

	public boolean isSigno() {
		return signo;
	}

	public void setSigno(boolean signo) {
		this.signo = signo;
	}

	public int getMomento() {
		return momento;
	}

	public void setMomento(int momento) {
		this.momento = momento;
	}

	public boolean isInmediatez() {
		return inmediatez;
	}

	public void setInmediatez(boolean inmediatez) {
		this.inmediatez = inmediatez;
	}

	public boolean isReversibilidad() {
		return reversibilidad;
	}

	public void setReversibilidad(boolean reversibilidad) {
		this.reversibilidad = reversibilidad;
	}

	public boolean isRecuperabilidad() {
		return recuperabilidad;
	}

	public void setRecuperabilidad(boolean recuperabilidad) {
		this.recuperabilidad = recuperabilidad;
	}

	public boolean isAcumulacion() {
		return acumulacion;
	}

	public void setAcumulacion(boolean acumulacion) {
		this.acumulacion = acumulacion;
	}

	public boolean isPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(boolean periodicidad) {
		this.periodicidad = periodicidad;
	}

	public boolean isPersistencia() {
		return persistencia;
	}

	public void setPersistencia(boolean persistencia) {
		this.persistencia = persistencia;
	}

	public boolean isContinuidad() {
		return continuidad;
	}

	public void setContinuidad(boolean continuidad) {
		this.continuidad = continuidad;
	}

	public boolean isSinergia() {
		return sinergia;
	}

	public void setSinergia(boolean sinergia) {
		this.sinergia = sinergia;
	}

}
