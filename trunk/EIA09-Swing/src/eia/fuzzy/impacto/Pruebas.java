package eia.fuzzy.impacto;

public class Pruebas {

	public static void main(String[] args) {

		// Creamos el motor de inferencia difuso
		Caracter motorDifuso = new Caracter();

		// Procesaremos lo valores de entrada del sistema
		double[] entrada = new double[2];
		//0: Precisa medidas correctoras?
		//0 (no) - 1 (si)
		entrada[0] = 0;
		//1: Modificación de recursos naturales
		//0 (inmediata) - 0.5 (dilatada) - 1 (sin recuperacion)
		entrada[1] = 0.8;

		// Realizamos la inferencia, obteniendo la salida del sistema
		// 0 a 0.25 (compatible)
		// 0.25 a 0.5 (moderado)
		// 0.5 a 0.75 (severo)
		// 0.75 a 1 (crítico)
		double[] salida = motorDifuso.crispInference(entrada);

		// Lo mostramos
		String textoSalida;
		if (salida[0]>0 && salida[0]<0.25){
			textoSalida = "Compatible";
		}else if (salida[0]>=0.25 && salida[0]<0.5){
			textoSalida = "Moderado";
		}else if (salida[0]>=0.5 && salida[0]<0.75){
			textoSalida = "Severo";
		}else {
			textoSalida = "Crítico";
		}
		System.out.println("Salida: "+ salida[0]+" - "+textoSalida);
	}

}
