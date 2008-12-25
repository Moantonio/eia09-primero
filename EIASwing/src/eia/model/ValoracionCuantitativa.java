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
public class ValoracionCuantitativa {

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
	 * Función de transformación lineal creciente.
	 * @param x Variable independiente de la función.
	 * @param max Valor máximo que podrá tomar la variable 'x'.
	 * @param min Valor mínimo que podrá tomar la variable 'x'.
	 * @return Resultado de la operación.
	 */
	public double linealCreciente(double x, double max, double min){
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
	public double linealDecreciente(double x, double max, double min){
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
	public double parabolica1Creciente(double x, double max, double min){
		double num = - (double)Math.pow(x,2)+ 2*max*x + (double)Math.pow(min, 2)- 2* max * min;
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
	public double parabolica1Decreciente(double x, double max, double min){
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
	public double parabolica2Creciente(double x, double max, double min){
		double num = (double)Math.pow(x,2)+ 2*min*x + (double)Math.pow(min, 2);
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
	public double parabolica2Decreciente(double x, double max, double min){
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
	public double parabolicaDoble1Creciente(double x, double max, double min){
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
	public double parabolicaDoble1DeCreciente(double x, double max, double min){
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
	public double parabolicaDoble2Creciente(double x, double max, double min){
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
	public double parabolicaDoble2DeCreciente(double x, double max, double min){
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
	public double maximoIntermedio(double x, double a, double max, double min){
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
	public double minimoIntermedio(double x, double a, double max, double min){
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
	public double umbralCreciente(double x, double umbral, double max, double min){
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
	public double umbralDecreciente(double x, double umbral, double max, double min){
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
		switch (numFuncion){
			case 0: magnitudImpacto = linealCreciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 1: magnitudImpacto = linealDecreciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 2: magnitudImpacto = parabolica1Creciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 3: magnitudImpacto = parabolica1Decreciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 4: magnitudImpacto = parabolica2Creciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 5: magnitudImpacto = parabolica2Decreciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 6: magnitudImpacto = parabolicaDoble1Creciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 7: magnitudImpacto = parabolicaDoble1DeCreciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 8: magnitudImpacto = parabolicaDoble2Creciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 9: magnitudImpacto = parabolicaDoble2DeCreciente(indicador,mayorValorIndicador,menorValorIndicador);
			case 10: magnitudImpacto = maximoIntermedio(indicador,opc,mayorValorIndicador,menorValorIndicador);
			case 11: magnitudImpacto = minimoIntermedio(indicador,opc,mayorValorIndicador,menorValorIndicador);
			case 12: magnitudImpacto = umbralCreciente(indicador,opc,mayorValorIndicador,menorValorIndicador);
			case 13: magnitudImpacto = umbralDecreciente(indicador,opc,mayorValorIndicador,menorValorIndicador);
		}
	}

}
