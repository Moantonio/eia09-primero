package eia.fuzzy.efecto;

public class Pruebas {

	public static void main(String[] args) {

		// Creamos el motor de inferencia difuso
		SimpleEnjuiciamiento motorDifuso = new SimpleEnjuiciamiento();

		// Procesaremos lo valores de entrada del sistema
		double[] entrada = new double[3];
		//0: Cuánto modifica el medio ambiente?
		//0 (poco) - 1 (mucho)
		entrada[0] = 0.1;
		//1: Cuánto modifica los recursos naturales?
		//0 (poco) - 1 (mucho)
		entrada[1] = 0.2;
		//2: Cuánto modifica los procesos fundamentales de funcionamiento?
		//0 (poco) - 1 (mucho)
		entrada[2] = 0.2;

		// Realizamos la inferencia, obteniendo la salida del sistema
		// >0.5 (significativo)
		// <0.5 (despreciable)
		double[] salida = motorDifuso.crispInference(entrada);

		// Lo mostramos
		String textoSalida;
		if (salida[0]>0.5) textoSalida = "Significativo";
		else textoSalida = "Despreciable";
		System.out.println("Salida: "+ salida[0]+" - "+textoSalida);
	}

}
