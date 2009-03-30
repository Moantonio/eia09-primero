package eia.modelo;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa la información para el análisis/valoración
 * cualitativa completa de un efecto/impacto ambiental.
 */
public class ValoracionCualitativa implements Cloneable {

	// Constantes para los distintos valores de los atributos
	public static final int SIG_POSITIVO = 1;
	public static final int SIG_NEGATIVO = -1;
	public static final int ACU_SIMPLE = 1;
	public static final int ACU_ACUMULATIVO = 3;
	public static final int ACU_SINERGICO = 6;
	public static final int EXT_PUNTUAL = 1;
	public static final int EXT_PARCIAL = 2;
	public static final int EXT_EXTENSO = 4;
	public static final int EXT_TOTAL = 6;
	public static final int EXT_NO_CRITICA = 0;
	public static final int EXT_CRITICA = 4;
	public static final int INT_BAJA = 1;
	public static final int INT_MEDIA = 2;
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
	public static final int MOM_NO_CRITICO = 0;
	public static final int MOM_CRITICO = 4;
	public static final int EFE_DIRECTO = 3;
	public static final int EFE_INDIRECTO_SEC = 2;
	public static final int EFE_INDIRECTO_TER = 1;

	/**
	 * Signo asociado al efecto/impacto: positivo o negativo.
	 */
	private int signo;

	/**
	 * Valor de acumulación asociada al efecto/impacto:
	 * simple, acumulativo o sinérgico.
	 */
	private int acumulacion;

	/**
	 * Valor de extensión (área de influencia) asociada al efecto/impacto:
	 * puntual, parcial, extenso o total.
	 */
	private int extension;

	/**
	 * Valor de la extensión crítica (área de influencia) asociada al efecto/impacto:
	 * crítica o no crítica.
	 */
	private int extensionCritica;

	/**
	 * Valor de intensidad (grado de destrucción) asociada al efecto/impacto:
	 * baja, media, alta, muy alta o total.
	 */
	private int intensidad;

	/**
	 * Valor de persistencia asociada al efecto/impacto:
	 * fugaz, temporal o permanente.
	 */
	private int persistencia;

	/**
	 * Valor de reversibilidad asociada al efecto/impacto:
	 * corto plazo, medio plazo, largo plazo o irreversible.
	 */
	private int reversibilidad;

	/**
	 * Valor de recuperabilidad (medios humanos) asociada al efecto/impacto:
	 * inmediata, medio plazo, mitigable, largo plazo o irrecuperable.
	 */
	private int recuperabilidad;

	/**
	 * Valor de periodicidad asociada al efecto/impacto:
	 * discontinuo, periódico o continuo.
	 */
	private int periodicidad;

	/**
	 * Valor del momento (plazo de manifestación) asociado al efecto/impacto:
	 * inmediato, medio plazo o largo plazo.
	 */
	private int momento;

	/**
	 * Valor del momento crítico (plazo de manifestación) asociado al efecto/impacto:
	 * crítico o no crítico.
	 */
	private int momentoCritico;

	/**
	 * Valor de efecto asociado al efecto/impacto:
	 * directo, indirecto secundario o indirecto terciario.
	 */
	private int efecto;

	/**
	 * Valor de impacto (importancia) del efecto según valoración cualitativa.
	 */
	private double incidencia;

	/**
	 * Constructor por parámetros.
	 * @param signo Signo del efecto/impacto.
	 * @param acumulacion Valor de acumulación del efecto/impacto.
	 * @param extensión Valor de extensión del efecto/impacto.
	 * @param extensionCritica Valor de la extensión crítica del efecto/impacto.
	 * @param intensidad Valor de intensidad del efecto/impacto.
	 * @param persistencia Valor de persistencia del efecto/impacto.
	 * @param reversibilidad Valor de reversibilidad del efecto/impacto.
	 * @param recuperabilidad Valor de recuperabilidad del efecto/impacto.
	 * @param periodicidad Valor de periodicidad del efecto/impacto.
	 * @param momento Valor del momento del efecto/impacto.
	 * @param momentoCritico Valor del momento crítico del efecto/impacto.
	 * @param efecto Valor de efecto del efecto/impacto.
	 */
	public ValoracionCualitativa(int signo, int acumulacion, int extension, int extensionCritica,
			int intensidad, int persistencia, int reversibilidad, int recuperabilidad,
			int periodicidad, int momento, int momentoCritico, int efecto) {
		super();
		this.signo = signo;
		this.acumulacion = acumulacion;
		this.extension = extension;
		this.extensionCritica = extensionCritica;
		this.intensidad = intensidad;
		this.persistencia = persistencia;
		this.reversibilidad = reversibilidad;
		this.recuperabilidad = recuperabilidad;
		this.periodicidad = periodicidad;
		this.momento = momento;
		this.momentoCritico = momentoCritico;
		this.efecto = efecto;
		incidencia = 0;
	}

	/**
	 * Constructor por defecto.
	 */
	public ValoracionCualitativa() {
		super();
		this.signo = ValoracionCualitativa.SIG_POSITIVO;
		this.acumulacion = 0;
		this.extension = 0;
		this.extensionCritica = 0;
		this.intensidad = 0;
		this.persistencia = 0;
		this.reversibilidad = 0;
		this.recuperabilidad = 0;
		this.periodicidad = 0;
		this.momento = 0;
		this.momentoCritico = 0;
		this.efecto = 0;
		incidencia = 0;
	}

	/**
	 * Accesor para el atributo 'signo'.
	 * @return Signo del efecto/impacto.
	 */
	public int getSigno() {
		return signo;
	}

	/**
	 * Mutador para el atributo 'signo'.
	 * @param signo Signo a asociar al efecto/impacto.
	 */
	public void setSigno(int signo) {
		this.signo = signo;
	}

	/**
	 * Accesor para el atributo 'acumulacion'.
	 * @return Valor de acumulación del efecto/impacto.
	 */
	public int getAcumulacion() {
		return acumulacion;
	}

	/**
	 * Mutador para el atributo 'signo'.
	 * @param acumulacion Valor de acumulación a asociar al efecto/impacto.
	 */
	public void setAcumulacion(int acumulacion) {
		this.acumulacion = acumulacion;
	}

	/**
	 * Accesor para el atributo 'extension'.
	 * @return Valor de extensión del efecto/impacto.
	 */
	public int getExtension() {
		return extension;
	}

	/**
	 * Mutador para el atributo 'extension'.
	 * @param extension Valor de extensión a asociar al efecto/impacto.
	 */
	public void setExtension(int extension) {
		this.extension = extension;
	}

	/**
	 * Accesor para el atributo 'extensionCritica'.
	 * @return Valor de extensión crítica del efecto/impacto
	 */
	public int getExtensionCritica() {
		return extensionCritica;
	}

	/**
	 * Mutador para el atributo 'extensionCritica'.
	 * @param extensionCritica Valor de extensión crítica a asociar al efecto/impacto.
	 */
	public void setExtensionCritica(int extensionCritica) {
		this.extensionCritica = extensionCritica;
	}

	/**
	 * Accesor para el atributo 'intensidad'.
	 * @return Valor de intensidad del efecto/impacto.
	 */
	public int getIntensidad() {
		return intensidad;
	}

	/**
	 * Mutador para el atributo 'intensidad'.
	 * @param intensidad Valor de intensidad a asociar al efecto/impacto.
	 */
	public void setIntensidad(int intensidad) {
		this.intensidad = intensidad;
	}

	/**
	 * Accesor para el atributo 'persistencia'.
	 * @return Valor de persistencia del efecto/impacto.
	 */
	public int getPersistencia() {
		return persistencia;
	}

	/**
	 * Mutador para el atributo 'persistencia'.
	 * @param persistencia Valor de persistencia a asociar al efecto/impacto.
	 */
	public void setPersistencia(int persistencia) {
		this.persistencia = persistencia;
	}

	/**
	 * Accesor para el atributo 'reversibilidad'.
	 * @return Valor de reversibilidad del efecto/impacto.
	 */
	public int getReversibilidad() {
		return reversibilidad;
	}

	/**
	 * Mutador para el atributo 'reversibilidad'.
	 * @param reversibilidad Valor de reversibilidad a asociar al efecto/impacto.
	 */
	public void setReversibilidad(int reversibilidad) {
		this.reversibilidad = reversibilidad;
	}

	/**
	 * Accesor para el atributo 'recuperabilidad'.
	 * @return Valor de recuperabilidad del efecto/impacto.
	 */
	public int getRecuperabilidad() {
		return recuperabilidad;
	}

	/**
	 * Mutador para el atributo 'recuperabilidad'.
	 * @param recuperabilidad Valor de recuperabilidad a asociar al efecto/impacto.
	 */
	public void setRecuperabilidad(int recuperabilidad) {
		this.recuperabilidad = recuperabilidad;
	}

	/**
	 * Accesor para el atributo 'periodicidad'.
	 * @return Valor de periodicidad del efecto/impacto.
	 */
	public int getPeriodicidad() {
		return periodicidad;
	}

	/**
	 * Mutador para el atributo 'periodicidad'.
	 * @param periodicidad Valor de periodicidad a asociar al efecto/impacto.
	 */
	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	/**
	 * Accesor para el atributo 'momento'.
	 * @return Valor del momento del efecto/impacto.
	 */
	public int getMomento() {
		return momento;
	}

	/**
	 * Mutador para el atributo 'momento'.
	 * @param momento Valor del momento a asociar al efecto/impacto.
	 */
	public void setMomento(int momento) {
		this.momento = momento;
	}

	/**
	 * Accesor para el atributo 'momentoCritico'.
	 * @return Valor del momento crítico del efecto/impacto.
	 */
	public int getMomentoCritico() {
		return momentoCritico;
	}

	/**
	 * Mutador para el atributo 'momentoCritico'.
	 * @param momentoCritico Valor del momento crítico a asociar al efecto/impacto.
	 */
	public void setMomentoCritico(int momentoCritico) {
		this.momentoCritico = momentoCritico;
	}

	/**
	 * Accesor para el atributo 'efecto'.
	 * @return Valor de efecto del efecto/impacto.
	 */
	public int getEfecto() {
		return efecto;
	}

	/**
	 * Mutador para el atributo 'efecto'.
	 * @param efecto Valor de efecto a asociar al efecto/impacto.
	 */
	public void setEfecto(int efecto) {
		this.efecto = efecto;
	}

	/**
	 * Accesor para el atributo 'incidencia'.
	 * @return Valor de incidencia del efecto/impacto.
	 */
	public double getIncidencia() {
		return incidencia;
	}

	/**
	 * Mutador para el atributo 'incidencia'.
	 * @param incidencia Valor de incidencia a asociar al efecto/impacto.
	 */
	public void setIncidencia(double incidencia) {
		this.incidencia = incidencia;
	}

	/**
	 * Función para el cálculo del valor máximo, usado para la obtención de la incidencia.
	 * @return Valor máximo.
	 */
	private int calculaMaximo(){
		int max = 0;
		if (acumulacion!=0)
			max+= ValoracionCualitativa.ACU_SINERGICO;
		if (extension!=0){
			max+= ValoracionCualitativa.EXT_TOTAL;
			if(extensionCritica!=0){
				max+= ValoracionCualitativa.EXT_CRITICA;
			}
		}
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
		if (momento!=0){
			max+= ValoracionCualitativa.MOM_INMEDIATO;
			if(momentoCritico!=0){
				max+= ValoracionCualitativa.MOM_CRITICO;
			}
		}
		if (efecto!=0)
			max+= ValoracionCualitativa.EFE_DIRECTO;
		return max;
	}

	/**
	 * Función para el cálculo del valor mínimo, usado para la obtención de la incidencia.
	 * @return Valor mínimo.
	 */
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

	/**
	 * Función para calcular el valor de impacto del efecto según análisis
	 * cualitativo completo, estableciendo dicho valor en el atributo 'incidencia'.
	 */
	public void calcularValoracion(){
		int min = calculaMinimo();
		int max = calculaMaximo();
		int suma =(acumulacion+extension+extensionCritica+intensidad+persistencia+
				reversibilidad+recuperabilidad+periodicidad+momento+momentoCritico+efecto);

		incidencia = redondear(signo*(double)(suma - min)/(max-min),3);
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
	 * Función para clonar el objeto ValoracionCualitativa.
	 * @return Copia del objeto ValoracionCualitativa.
	 */
    public Object clone(){
        Object copia = null;
        try{
            copia = super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Imposible duplicar");
        }
        return copia;
    }
}
