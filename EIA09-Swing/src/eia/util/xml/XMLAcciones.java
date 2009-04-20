package eia.util.xml;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import eia.modelo.Accion;

/**
 * Clase que implementa el manejo de los ficheros XML con la información
 * de un árbol de acciones de realización.
 */
public class XMLAcciones extends XMLTools{

	/**
	 * Constructor por parámetro.
	 * @param dtd DTD a asignar.
	 */
	public XMLAcciones(String dtd){
		this.setDtd(dtd);
	}

	/**
    * El método leer recupera un arbol de acciones de una alternativa, con la información almacenada en el documento XML.
    * @param filename Ruta del fichero xml.
    * @return Árbol de acciones con los datos cargados.
    */
	public DefaultTreeModel leer(String filename) {

        //Se obtiene el objeto Document que representa al archivo xml
        Document doc= readFile(filename);

        //Cogemos la lista principal de acciones.
        Element listaAcciones = (Element)doc.getElementsByTagName("listaAcciones").item(0);
        NodeList acciones = listaAcciones.getElementsByTagName("accion");

        //Para cada accon, vamos recorriendo las subacciones y creando el arbol.
        DefaultMutableTreeNode arbolAcc = new DefaultMutableTreeNode();
        int index = 0;
        for(int i = 0; i < acciones.getLength(); i++){
        	DefaultMutableTreeNode arbolI = recorrerAcciones((Element)acciones.item(i));
        	if(!esSubArbol(arbolI,arbolAcc))
        		arbolAcc.insert(arbolI,index++);
        }
        return (new DefaultTreeModel(arbolAcc));
	}


	/**
     * Método privado que dado una accion recorre su lista de subacciones.
     * @param accion Acción que puede tener una lista de subacciones.
     * @return Estructura de árbol con acciones y subacciones.
     */
    private DefaultMutableTreeNode recorrerAcciones(Element accion){
    	//Caso base
    	if(accion.getElementsByTagName("listaAcciones").getLength() == 0){
    		Accion a = new Accion (accion.getElementsByTagName("nombreAccion").item(0).getTextContent());
    		DefaultMutableTreeNode arb = new DefaultMutableTreeNode();
    		arb.setUserObject(a);
    		return arb;
    	}
    	//Caso recursivo
    	else{
    		//Cogemos la lista de subfactores.
    		Element listaAcciones = (Element)accion.getElementsByTagName("listaAcciones").item(0);
    		NodeList acciones = listaAcciones.getElementsByTagName("accion");
    		//Creamos el nodo padre del arbol.
    		Accion a = new Accion (accion.getElementsByTagName("nombreAccion").item(0).getTextContent());
    		DefaultMutableTreeNode padre = new DefaultMutableTreeNode();
    		padre.setUserObject(a);
    		int index=0;
    		//Recorremos cada subfactor.
    		for(int i = 0; i < acciones.getLength(); i++){
    			DefaultMutableTreeNode arb = recorrerAcciones((Element)acciones.item(i));
    			if(!esSubArbol(arb,padre))
    				padre.insert(arb,index++);
    		}
    		return padre;
    	}
    }

    @SuppressWarnings("unchecked")
	private boolean esSubArbol(DefaultMutableTreeNode arbolH, DefaultMutableTreeNode arbolP){
    	boolean esHijo = false;
    	Enumeration eHijos = arbolP.children();
    	while(eHijos.hasMoreElements()){
    		Enumeration eP = ((DefaultMutableTreeNode)eHijos.nextElement()).breadthFirstEnumeration();
	    	while(eP.hasMoreElements() && !esHijo){
	    		Enumeration eH = arbolH.breadthFirstEnumeration();
	    		DefaultMutableTreeNode nodoP = (DefaultMutableTreeNode)eP.nextElement();
	    		while(eH.hasMoreElements() && !esHijo){
	    			DefaultMutableTreeNode nodoH = (DefaultMutableTreeNode)eH.nextElement();
	    			if(nodoP.getUserObject()!= null && nodoH.getUserObject()!= null)
	    				if(nodoP.getUserObject().toString().equals(nodoH.getUserObject().toString()))
	    					esHijo = true;
	    		}

	    	}
    	}
    	return esHijo;
    }

    @Override
	public void escribir(Object o, String archivo) {}

}
