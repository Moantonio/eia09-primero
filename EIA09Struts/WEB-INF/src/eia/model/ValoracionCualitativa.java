package eia.model;

public class ValoracionCualitativa {
	
	public static final int SIG_POSITIVO = +1;
	public static final int SIG_NEGATIVO = -1;
	public static final int ACU_SIMPLE = 1;
	public static final int ACU_ACUMULATIVO = 3;
	public static final int ACU_SINERGICO = 6;
	public static final int EXT_PUNTUAL = 1;
	public static final int EXT_PARCIAL = 2;
	public static final int EXT_EXTENSO = 4;
	public static final int EXT_TOTAL = 6;
	public static final int EXT_CRITICA = 8;
	public static final int INT_BAJA = 1;
	public static final int INT_MEDIA = 4;
	public static final int INT_ALTA = 4;
	public static final int INT_MUYALTA = 6;
	public static final int INT_TOTAL = 10;
	public static final int PERS_FUGAZ = 1;
	public static final int PERS_TEMPORAL = 2;
	public static final int PERS_PERMANENTE = 4;
	public static final int REV_CORTO_PLAZO = 1;
	public static final int REV_MEDIO_PLAZO = 2;
	public static final int REV_LARGO_PLAZO = 3;
	public static final int REV_IRREVERSIBLE = 4;
	public static final int REC_INMEDIATA = 1;
	public static final int REC_MEDIO_PLAZO = 2;
	public static final int REC_MITIGABLE = 4;
	public static final int REC_LARGO_PLAZO = 6;
	public static final int REC_IRRECUPERABLE = 8;
	public static final int PER_DISCONTINUO = 1;
	public static final int PER_PERIODICO = 2;
	public static final int PER_CONTINUO = 4;
	public static final int MOM_LARGO_PLAZO = 1;
	public static final int MOM_MEDIO_PLAZO = 2;
	public static final int MOM_INMEDIATO = 4;
	public static final int MOM_CRITICO = 6;
	public static final int EFE_DIRECTO = 3;
	public static final int EFE_INDIRECTO_SEC = 2;
	public static final int EFE_INDIRECTO_TER = 1;

	/**
	 * Signo
	 */
	private int signo;
	
	/**
	 * Acumulación
	 */
	private int acumulacion;
	
	/**
	 * 
	 */
	private int extension;
	
	/**
	 * 
	 */
	private int intensidad;
	
	/**
	 * 
	 */
	private int persistencia;
	
	/**
	 * 
	 */
	private int reversibilidad;
	
	/*
	 * 
	 */
	private int recuperabilidad;
	
	/**
	 * 
	 */
	private int periodicidad;
	
	/**
	 * 
	 * 
	 */
	private int momento;
	
	/**
	 * 
	 */
	private int efecto;
	
	/**
	 * 
	 */
	private double incidencia;

	/**
	 * 
	 * @param signo
	 * @param acumulacion
	 * @param extensión
	 * @param intensidad
	 * @param persistencia
	 * @param reversibilidad
	 * @param recuperabilidad
	 * @param periodicidad
	 * @param momento
	 * @param efecto
	 */
	public ValoracionCualitativa(int signo, int acumulacion, int extension,
			int intensidad, int persistencia, int reversibilidad,
			int recuperabilidad, int periodicidad, int momento, int efecto) {
		super();
		this.signo = signo;
		this.acumulacion = acumulacion;
		this.extension = extension;
		this.intensidad = intensidad;
		this.persistencia = persistencia;
		this.reversibilidad = reversibilidad;
		this.recuperabilidad = recuperabilidad;
		this.periodicidad = periodicidad;
		this.momento = momento;
		this.efecto = efecto;
		incidencia = 0;
	}
	
	/**
	 * 
	 * @param signo
	 * @param acumulacion
	 * @param extensión
	 * @param intensidad
	 * @param persistencia
	 * @param reversibilidad
	 * @param recuperabilidad
	 * @param periodicidad
	 * @param momento
	 * @param efecto
	 */
	public ValoracionCualitativa() {
		super();
		this.signo = ValoracionCualitativa.SIG_POSITIVO;
		this.acumulacion = 0;
		this.extension = 0;
		this.intensidad = 0;
		this.persistencia = 0;
		this.reversibilidad = 0;
		this.recuperabilidad = 0;
		this.periodicidad = 0;
		this.momento = 0;
		this.efecto = 0;
		incidencia = 0;
	}
	
	/**
	 * @return the signo
	 */
	public int getSigno() {
		return signo;
	}

	/**
	 * @param signo the signo to set
	 */
	public void setSigno(int signo) {
		this.signo = signo;
	}

	/**
	 * @return the acumulacion
	 */
	public int getAcumulacion() {
		return acumulacion;
	}

	/**
	 * @param acumulacion the acumulacion to set
	 */
	public void setAcumulacion(int acumulacion) {
		this.acumulacion = acumulacion;
	}

	/**
	 * @return the extensión
	 */
	public int getExtension() {
		return extension;
	}

	/**
	 * @param extensión the extensión to set
	 */
	public void setExtension(int extension) {
		this.extension = extension;
	}

	/**
	 * @return the intensidad
	 */
	public int getIntensidad() {
		return intensidad;
	}

	/**
	 * @param intensidad the intensidad to set
	 */
	public void setIntensidad(int intensidad) {
		this.intensidad = intensidad;
	}

	/**
	 * @return the persistencia
	 */
	public int getPersistencia() {
		return persistencia;
	}

	/**
	 * @param persistencia the persistencia to set
	 */
	public void setPersistencia(int persistencia) {
		this.persistencia = persistencia;
	}

	/**
	 * @return the reversibilidad
	 */
	public int getReversibilidad() {
		return reversibilidad;
	}

	/**
	 * @param reversibilidad the reversibilidad to set
	 */
	public void setReversibilidad(int reversibilidad) {
		this.reversibilidad = reversibilidad;
	}

	/**
	 * @return the recuperabilidad
	 */
	public int getRecuperabilidad() {
		return recuperabilidad;
	}

	/**
	 * @param recuperabilidad the recuperabilidad to set
	 */
	public void setRecuperabilidad(int recuperabilidad) {
		this.recuperabilidad = recuperabilidad;
	}

	/**
	 * @return the periodicidad
	 */
	public int getPeriodicidad() {
		return periodicidad;
	}

	/**
	 * @param periodicidad the periodicidad to set
	 */
	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	/**
	 * @return the momento
	 */
	public int getMomento() {
		return momento;
	}

	/**
	 * @param momento the momento to set
	 */
	public void setMomento(int momento) {
		this.momento = momento;
	}

	/**
	 * @return the efecto
	 */
	public int getEfecto() {
		return efecto;
	}

	/**
	 * @param efecto the efecto to set
	 */
	public void setEfecto(int efecto) {
		this.efecto = efecto;
	}

	/**
	 * @return the incidencia
	 */
	public double getIncidencia() {
		return incidencia;
	}

	/**
	 * @param incidencia the incidencia to set
	 */
	public void setIncidencia(double incidencia) {
		this.incidencia = incidencia;
	}
	
	private int calculaMaximo(){
		int max = 0;
		
		if (acumulacion!=0)
			max+= ValoracionCualitativa.ACU_SINERGICO;
		if (extension!=0)
			max+= ValoracionCualitativa.EXT_CRITICA;
		if (intensidad!=0)
			max+= ValoracionCualitativa.INT_TOTAL;
		if (persistencia!=0)
			max+= ValoracionCualitativa.PERS_PERMANENTE;
		if (reversibilidad!=0)
			max+= ValoracionCualitativa.REV_IRREVERSIBLE;
		if (recuperabilidad!=0)
			max+= ValoracionCualitativa.REC_IRRECUPERABLE;
		if (periodicidad!=0)
			max+= ValoracionCualitativa.PER_CONTINUO;
		if (momento!=0)
			max+= ValoracionCualitativa.MOM_CRITICO;
		if (efecto!=0)
			max+= ValoracionCualitativa.EFE_DIRECTO;
		return max;	
	}
	
	private int calculaMinimo(){
		int min = 0;
		
		if (acumulacion!=0)
			min+= ValoracionCualitativa.ACU_SIMPLE;
		if (extension!=0)
			min+= ValoracionCualitativa.EXT_PUNTUAL;
		if (intensidad!=0)
			min+= ValoracionCualitativa.INT_BAJA;
		if (persistencia!=0)
			min+= ValoracionCualitativa.PERS_FUGAZ;
		if (reversibilidad!=0)
			min+= ValoracionCualitativa.REV_CORTO_PLAZO;
		if (recuperabilidad!=0)
			min+= ValoracionCualitativa.REC_INMEDIATA;
		if (periodicidad!=0)
			min+= ValoracionCualitativa.PER_DISCONTINUO;
		if (momento!=0)
			min+= ValoracionCualitativa.MOM_LARGO_PLAZO;
		if (efecto!=0)
			min+= ValoracionCualitativa.EFE_INDIRECTO_TER;
		return min;	
	}
	
	public void calcularValoracion(){
		int min = calculaMinimo();
		int max = calculaMaximo();
		int suma =(acumulacion+extension+intensidad+persistencia+
				reversibilidad+recuperabilidad+periodicidad+momento+efecto);
	   incidencia = (signo*(suma - min)/(max-min));  
	}
	
 }

