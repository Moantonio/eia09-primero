package eia.util.xml;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

/**
 * Clase que implementa herramientas para el manejo de los ficheros XML.
 */
public abstract class XMLTools {

	/**
	 * Atributo que especifica la dtd asociada al XML.
	 */
	private String dtd;

	 /**
	  * Metodo que recibe un archivo de texto XML, y lo almacena en un Document
	  * @param filename Ruta del fichero XML.
	  * @return Objeto con el fichero almacenado.
	  */
    public Document readFile(String filename) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().parse(new File(filename));
            return doc;
        }
        catch (java.lang.Exception e) {
        }
        return null;
    }

    /**
     * Método que recibe un Document y un archivo, y almacena la estructura XML en el archivo dado.
     * @param doc Documento con el contenido almacenar.
     * @param filename Nombre del archivo donde almacenar la información.
     */
    public void writeFile(Document doc, String filename) {
        try {
            Source source = new DOMSource(doc);
            Result result = new StreamResult(filename);

            javax.xml.transform.TransformerFactory xform = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer xformer = xform.newTransformer();
            xformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, dtd);
            xformer.transform(source, result);
        }
        catch (java.lang.Exception e) {
        	e.printStackTrace();
        }
    }

    /**
     * Método que escribe el contenido de un objeto en un fichero XML.
     * @param o Objeto que contiene la informacion a guardar en el fichero XML.
     * @param archivo Ruta del fichero XML donde se guardara la informacion.
     */
    public abstract void escribir(Object o,String archivo);

    /**
     * Método que lee el contenido de un fichero XML y lo guarda en un objeto.
     * @param filename Ruta del fichero XML del cual se obtiene la informacion.
     * @return Objeto con la informacion cargada.
     */
    public abstract Object leer(String filename);

    /**
     * Accesor para el atributo 'dtd'
	 * @return Valor del atributo 'dtd'.
	 */
	public String getDtd() {
		return dtd;
	}

    /**
     * Mutador para el atributo 'dtd'.
	 * @param dtd Valor a asignar al atributo 'dtd'.
	 */
	public void setDtd(String dtd) {
		this.dtd = dtd;
	}
}
