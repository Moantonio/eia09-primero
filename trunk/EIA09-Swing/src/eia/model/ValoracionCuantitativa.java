package eia.model;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa la información para el análisis/valoración
 * cuantitativa de un efecto/impacto ambiental.
 */
public class ValoracionCuantitativa implements Cloneable {

	/**
	 * Magnitud del efecto/impacto en unidades heterogéneas.
	 */
	private double indicador;

	/**
	 * Mayor valor que podrá tomar el indicador del efecto/impacto.
	 */
	private double mayorValorIndicador;

	/**
	 * Menor valor que podrá tomar el indicador del efecto/impacto.
	 */
	private double menorValorIndicador;

	/**
	 * Número de la función de transformación aplicada para el cáculo de la magnitud.
	 */
	private int numFuncion;

	/**
	 * Valor del efecto/impacto por valoración cuantitativa.
	 */
	private double magnitudImpacto;

	/**
	 * Constructor por parámetros.
	 * @param indicador Magnitud del efecto/impacto en unidades heterogéneas.
	 * @param mayorValorIndicador Mayor valor que podrá tomar el indicador del efecto/impacto.
	 * @param menorValorIndicador Menor valor que podrá tomar el indicador del efecto/impacto.
	 */
	public ValoracionCuantitativa(double indicador, double mayorValorIndicador, double menorValorIndicador) {
		this.indicador = indicador;
		this.mayorValorIndicador = mayorValorIndicador;
		this.menorValorIndicador = menorValorIndicador;
		this.magnitudImpacto = 0;
		this.numFuncion = 0;
	}

	/**
	 * Accesor para el atributo 'indicador'.
	 * @return Magnitud del efecto/impacto en unidades heterogéneas.
	 */
	public double getIndicador() {
		return indicador;
	}

	/**
	 * Mutador para el atributo 'indicador'.
	 * @param indicador Magnitud del efecto/impacto a asociar en unidades heterogéneas.
	 */
	public void setIndicador(double indicador) {
		this.indicador = indicador;
	}

	/**
	 * Accesor para el atributo 'mayorValorIndicador'.
	 * @return Mayor valor que podrá tomar el indicador del efecto/impacto.
	 */
	public double getMayorValorIndicador() {
		return mayorValorIndicador;
	}

	/**
	 * Mutador para el atributo 'mayorValorIndicador'.
	 * @param mayorValorIndicador Mayor valor que podrá tomar el indicador del efecto/impacto.
	 */
	public void setMayorValorIndicador(double mayorValorIndicador) {
		this.mayorValorIndicador = mayorValorIndicador;
	}

	/**
	 * Accesor para el atributo 'menorValorIndicador'.
	 * @return Menor valor que podrá tomar el indicador del efecto/impacto.
	 */
	public double getMenorValorIndicador() {
		return menorValorIndicador;
	}

	/**
	 * Mutador para el atributo 'menorValorIndicador'.
	 * @param menorValorIndicador Menor valor que podrá tomar el indicador del efecto/impacto.
	 */
	public void setMenorValorIndicador(double menorValorIndicador) {
		this.menorValorIndicador = menorValorIndicador;
	}

	/**
	 * Accesor para el atributo 'magnitudImpacto'.
	 * @return Valor del efecto/impacto por valoración cuantitativa.
	 */
	public double getMagnitudImpacto() {
		return magnitudImpacto;
	}

	/**
	 * Mutador para el atributo 'magnitudImpacto'.
	 * @param magnitudImpacto Valor del efecto/impacto a asociar por valoración cuantitativa.
	 */
	public void setMagnitudImpacto(double magnitudImpacto) {
		this.magnitudImpacto = magnitudImpacto;
	}

	/**
	 * Accesor para el atributo 'numFuncion'.
	 * @return Número de la función de transformación aplicada.
	 */
	public int getNumFuncion() {
		return numFuncion;
	}

	/**
	 * Mutador para el atributo 'numFuncion'.
	 * @param numFuncion Número de la función de transformación a asociar.
	 */
	public void setNumFuncion(int numFuncion) {
		this.numFuncion = numFuncion;
	}
	/**
	 * Función de transformación lineal creciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double linealCreciente(double x, double max, double min){
		double y = (x - min)/(max-min);
		return y;
	}

	/**
	 * Función de transformación lineal decreciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double linealDecreciente(double x, double max, double min){
		double y = (max - x)/(max-min);
		return y;
	}

	/**
	 * Función de transformación parabólica creciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double parabolica1Creciente(double x, double max, double min){
		double num = -(double)Math.pow(x,2)+ 2*max*x + (double)Math.pow(min, 2)- 2* max * min;
		double den = (double)Math.pow(max-min, 2);
		return num/den;
	}

	/**
	 * Función de transformación parabólica decreciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double parabolica1Decreciente(double x, double max, double min){
		double num = (double)Math.pow(x,2)- 2*max*x + (double)Math.pow(max, 2);
		double den = (double)Math.pow(max-min, 2);
		return num/den;
	}

	/**
	 * Función de transformación parabólica creciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double parabolica2Creciente(double x, double max, double min){
		double num = (double)Math.pow(x,2)- 2*min*x + (double)Math.pow(min, 2);
		double den = (double)Math.pow(max-min, 2);
		return num/den;
	}

	/**
	 * Función de transformación parabólica decreciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double parabolica2Decreciente(double x, double max, double min){
		double num = -(double)Math.pow(x, 2)+ 2*min*x + (double)Math.pow(max, 2)-2*min*max;
		double den = (double)Math.pow(max-min, 2);
		return num/den;
	}

	/**
	 * Función de transformación parabólica doble creciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double parabolicaDoble1Creciente(double x, double max, double min){
		double num,den;
		if((x>=min)&&(x<= (max+min)/2)){
			num = -2*(double)Math.pow(x, 2)+ 2*(max+min)*x - 2*max*min;
		}
		else{
			num = 2*(double)Math.pow(x, 2)- 2*(max+min)*x + 2*max*min;
		}
		den = (double)Math.pow(max-min,2);
		return num/den;
	}

	/**
	 * Función de transformación parabólica doble decreciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double parabolicaDoble1DeCreciente(double x, double max, double min){
		double num,den,y;
		den = (double)Math.pow(max-min,2);
		if((x>=min)&&(x<= (max+min)/2)){
			num = 2*(double)Math.pow(x, 2)- 2*(max+min)*x + 2*max*min;
			y = num/den +1;
		}
		else{
			num = -2*(double)Math.pow(x, 2)+ 2*(max+min)*x - 2*max*min;
			y = num/den;
		}
		return y;
	}

	/**
	 * Función de transformación parabólica doble creciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double parabolicaDoble2Creciente(double x, double max, double min){
		double num,den,y;
		den = (double)Math.pow(max-min,2);
		if((x>=min)&&(x<= (max+min)/2)){
			num = 2*(double)Math.pow(x, 2)- 4*min*x + 2*(double)Math.pow(min, 2);
			y = num/den;
		}
		else{
			num = -2*(double)Math.pow(x, 2)+ 4*max*x - 2*(double)Math.pow(max, 2);
			y = num/den +1;
		}
		return y;
	}

	/**
	 * Función de transformación parabólica doble decreciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double parabolicaDoble2DeCreciente(double x, double max, double min){
		double num,den,y;
		den = (double)Math.pow(max-min,2);
		if((x>=min)&&(x<= (max+min)/2)){
			num = -2*(double)Math.pow(x, 2)+ 4*min*x - 2*(double)Math.pow(min, 2);
			y = num/den +1;
		}
		else{
			num = 2*(double)Math.pow(x, 2)- 4*max*x + 2*(double)Math.pow(max, 2);
			y = num/den;
		}
		return y;
	}

	/**
	 * Función de transformación máximo intermedio.
	 * @param x Variable independiente de la función.
	 * @param a Valor de alcance máximo.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double maximoIntermedio(double x, double a, double max, double min){
		double num = -(double)Math.pow(x, 2) + 2*a*x + (double)Math.pow(min, 2) - 2*a*min;
		double den = (double)Math.pow(a-min, 2);
		return num/den;
	}

	/**
	 * Función de transformación mínimo intermedio.
	 * @param x Variable independiente de la función.
	 * @param a Valor de alcance mínimo.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double minimoIntermedio(double x, double a, double max, double min){
		double num = (double)Math.pow(x, 2)- 2*a*x + (double)Math.pow(a, 2);
		double den = (double)Math.pow(a-min, 2);
		return num/den;
	}

	/**
	 * Función de transformación con valor umbral creciente.
	 * @param x Variable independiente de la función.
	 * @param umbral Valor del umbral.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double umbralCreciente(double x, double umbral, double max, double min){
		double y;
		if ((x>=min)&&(x<umbral)){
			y=0;
		}
		else{
			y=1;
		}
		return y;
	}

	/**
	 * Función de transformación con valor umbral decreciente.
	 * @param x Variable independiente de la función.
	 * @param umbral Valor del umbral.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	private double umbralDecreciente(double x, double umbral, double max, double min){
		double y;
		if ((x>=min)&&(x<umbral)){
			y=1;
		}
		else{
			y=0;
		}
		return y;
	}

	/**
	 * Función para calcular el valor de impacto del efecto según análisis
	 * cuantitativo, estableciendo dicho valor en el atributo 'magnitudImpacto'.
	 * @param numFuncion Número de función de transformación a aplicar.
	 * @param opc Parámetro opcional ('a', 'umbral') para las funciones que lo demanden.
	 */
	public void calcularValoracion(int numFuncion, double opc){
		magnitudImpacto = redondear(calcularFuncion(numFuncion,indicador,mayorValorIndicador,menorValorIndicador,opc),3);
		this.numFuncion = numFuncion;
	}

	/**
	 * Función para el cálculo aplicado de la función indicada por parámetro.
	 * @param numFuncion Número de función a aplicar.
	 * @param x Valor de 'x' para el cálculo de la función.
	 * @param max Valor de 'max' para el cálculo de la función.
	 * @param min Valor de 'min' para el cálculo de la función.
	 * @param opc arámetro opcional ('a', 'umbral') para las funciones que lo demanden.
	 * @return Resultado 'y' al aplicar la función.
	 */
	public double calcularFuncion(int numFuncion, double x, double max, double min, double opc){
		double resultado = 0;
		switch (numFuncion){
			case 0: {resultado = linealCreciente(x,max,min);
					break;}
			case 1: {resultado = linealDecreciente(x,max,min);
					break;}
			case 2: {resultado = parabolica1Creciente(x,max,min);
					break;}
			case 3: {resultado = parabolica1Decreciente(x,max,min);
					break;}
			case 4: {resultado = parabolica2Creciente(x,max,min);
					break;}
			case 5: {resultado = parabolica2Decreciente(x,max,min);
					break;}
			case 6: {resultado = parabolicaDoble1Creciente(x,max,min);
					break;}
			case 7: {resultado = parabolicaDoble1DeCreciente(x,max,min);
					break;}
			case 8: {resultado = parabolicaDoble2Creciente(x,max,min);
					break;}
			case 9: {resultado = parabolicaDoble2DeCreciente(x,max,min);
					break;}
			case 10: {resultado = maximoIntermedio(x,opc,max,min);
					break;}
			case 11: {resultado = minimoIntermedio(x,opc,max,min);
					break;}
			case 12: {resultado = umbralCreciente(x,opc,max,min);
					break;}
			case 13: {resultado = umbralDecreciente(x,opc,max,min);
					 break;}
		}
		return resultado;
	}

	/**
	 * Función para redondear un número de tipo double al número de cifras
	 * decimales indicadas por parámetro.
	 * @param nD Número a redondear.
	 * @param nDec Número de cifras decimales a redondear.
	 * @return Número redondeado.
	 */
	private double redondear(double nD, int nDec)
	{
	  return Math.round(nD*Math.pow(10,nDec))/Math.pow(10,nDec);
	}

	/**
	 * Función para clonar el objeto ValoracionCuantitativa.
	 * @return Copia del objeto ValoracionCuantitativa.
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

    /**
     * Función para obtener el número de referencia de la función de transformación
     * a partir del nombre de la misma.
     * @param nombreFuncion Nombre de la función de transformación.
     * @return Número de referencia de la función de transformación.
     */
    public int numFuncionTransformacion(String nombreFuncion){
    	int num = 0;
    	if(nombreFuncion.equals("Lineal creciente")){
    		num = 0;
    	}else if(nombreFuncion.equals("Lineal decreciente")){
			num = 1;
    	}else if(nombreFuncion.equals("Parabólica creciente I")){
			num = 2;
    	}else if(nombreFuncion.equals("Parabólica decreciente I")){
			num = 3;
    	}else if(nombreFuncion.equals("Parabólica creciente II")){
			num = 4;
    	}else if(nombreFuncion.equals("Parabólica decreciente II")){
			num = 5;
    	}else if(nombreFuncion.equals("Parabólica doble creciente I")){
			num = 6;
    	}else if(nombreFuncion.equals("Parabólica doble decreciente I")){
			num = 7;
    	}else if(nombreFuncion.equals("Parabólica doble creciente II")){
			num = 8;
    	}else if(nombreFuncion.equals("Parabólica doble decreciente II")){
			num = 9;
    	}else if(nombreFuncion.equals("Máximo intermedio")){
			num = 10;
    	}else if(nombreFuncion.equals("Mínimo intermedio")){
			num = 11;
    	}else if(nombreFuncion.equals("Umbral creciente")){
			num = 12;
    	}else if(nombreFuncion.equals("Umbral decreciente")){
			num = 13;
    	}
    	return num;
    }

    /**
     * Función para obtener el nombre la función de transformación
     * a partir del número de referencia de la misma.
     * @param numFuncion Número de referencia de la función de transformación.
     * @return Nombre de la función de transformación.
     */
    public String nombreFuncionTransformacion(int numFuncion){
    	String nombreFuncion = "";
		switch (numFuncion){
			case 0: {nombreFuncion = "Lineal creciente";
					break;}
			case 1: {nombreFuncion = "Lineal decreciente";
					break;}
			case 2: {nombreFuncion = "Parabólica creciente I";
					break;}
			case 3: {nombreFuncion = "Parabólica decreciente I";
					break;}
			case 4: {nombreFuncion = "Parabólica creciente II";
					break;}
			case 5: {nombreFuncion = "Parabólica decreciente II";
					break;}
			case 6: {nombreFuncion = "Parabólica doble creciente I";
					break;}
			case 7: {nombreFuncion = "Parabólica doble decreciente I";
					break;}
			case 8: {nombreFuncion = "Parabólica doble creciente II";
					break;}
			case 9: {nombreFuncion = "Parabólica doble decreciente II";
					break;}
			case 10: {nombreFuncion = "Máximo intermedio";
					break;}
			case 11: {nombreFuncion = "Mínimo intermedio";
					break;}
			case 12: {nombreFuncion = "Umbral creciente";
					break;}
			case 13: {nombreFuncion = "Umbral decreciente";
					 break;}
		}
		return nombreFuncion;
    }
}
