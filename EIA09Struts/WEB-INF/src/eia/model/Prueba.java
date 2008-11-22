package eia.model;

import eia.util.Arbol;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//PRUEBA DE MONTAJE DE UN ÁRBOL DE ACCIONES
		
		//Presas
		Accion raiz1 = new Accion("Presas");
		Arbol<Accion> acciones = new Arbol<Accion>(raiz1);
		
		//Fase de planeamiento
		Accion raiz2 = new Accion("Fase de Planeamiento");
		Arbol<Accion> planeamiento = new Arbol<Accion>(raiz2);
		
		//Diseño y localizacion
		Accion raiz3 = new Accion("Diseño y localización de alternativas");
		Arbol<Accion> diseno = new Arbol<Accion>(raiz3);
		
		//Fase de construcción
		Accion raiz4 = new Accion("Fase de Construcción");
		Arbol<Accion> construccion = new Arbol<Accion>(raiz4);

		//Arbol
		acciones.añadirHijo(planeamiento);
		acciones.añadirHijo(construccion);
		planeamiento.añadirHijo(diseno);
	}

}
