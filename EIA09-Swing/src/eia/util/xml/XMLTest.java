package eia.util.xml;

import eia.model.Alternativa;
import eia.model.Proyecto;


public class XMLTest {
	
	public static void main (String[] args){
		XMLProyecto xmlProy = new XMLProyecto(".\\proyectoEIA.dtd");
		Proyecto p = (Proyecto)xmlProy.leer("C:\\Documents and Settings\\Vicen\\Mis documentos\\Mis trabajos\\PFC\\XML\\ejemploProyecto.xml");
		
		XMLAlternativa xmlAlt = new XMLAlternativa(p,".\\alternativaProyEIA.dtd");
		Alternativa alt = (Alternativa)xmlAlt.leer("C:\\Documents and Settings\\Vicen\\Mis documentos\\Mis trabajos\\PFC\\XML\\alternativaEjemplo.xml");
		
		xmlProy.escribir(p,"C:\\Documents and Settings\\Vicen\\Mis documentos\\Mis trabajos\\PFC\\XML\\ejemploEscritura.xml");
		xmlAlt.escribir(alt,"C:\\Documents and Settings\\Vicen\\Mis documentos\\Mis trabajos\\PFC\\XML\\ejemploEscrituraAlt.xml");
	}

}
