package eia.util.xml;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import eia.model.Accion;
import eia.model.Alternativa;
import eia.model.Efecto;
import eia.model.Factor;
import eia.model.Proyecto;
import eia.model.ValoracionCualitativa;
import eia.model.ValoracionCuantitativa;
import eia.util.CaracterEfecto;
import eia.util.ValorJuicio;
import eia.util.Arbol;
import eia.util.Constants;

public class XMLAlternativa extends XMLTools{
	
	Logger log;
	Proyecto p;
	
	public XMLAlternativa(Proyecto p, String dtd){	
		log = Logger.getLogger( this.getClass() );
		PropertyConfigurator.configure(Constants.LOG4J_PROPERTIES);
		this.p = p;
		this.setDtd(dtd);
	}

	 /**
    * El método leer recupera una alternativa a un proyecto con la información almacenada en el documento XML
    * @param filename Ruta del fichero xml.
    * @return Alternativa con los datos cargados.
    */
	public Alternativa leer(String filename) {
		log.info("Cargando xml: " +  filename);
    	
        //Se obtiene el objeto Document que representa al archivo xml
        Document doc= readFile(filename);
        
        //Se recupera el objeto Element principal del objeto Document
        Element elemento=(Element)doc. getDocumentElement();
        
        Alternativa alt = new Alternativa();
        
        alt.setId(elemento.getElementsByTagName("nombre").item(0).getTextContent());
        
      //Cogemos la lista principal de acciones.
        Element listaAcciones = (Element)elemento.getElementsByTagName("listaAcciones").item(0);
        NodeList acciones = listaAcciones.getElementsByTagName("accion");
        
        //Para cada accon, vamos recorriendo las subacciones y creando el arbol.
        Arbol<Accion> arbolAcc = new Arbol<Accion>();
        for(int i = 0; i < acciones.getLength(); i++){
        	Arbol<Accion> arbolI = recorrerAcciones((Element)acciones.item(i));
        	arbolAcc.añadirHijo(arbolI);
        }        
        alt.setAcciones(arbolAcc); 
        
        //Cargamos la lista de efectos.
        //Necesitamos el arbol de factores del proyecto para guardar los objetos.
        ArrayList<Efecto> listaEf = new ArrayList<Efecto>();
        Arbol<Factor> arbFact = p.getFactores();
        Element listaEfectos = (Element)elemento.getElementsByTagName("listaEfectos").item(0);
        if(listaEfectos != null){
	        NodeList efectos = listaEfectos.getElementsByTagName("efecto");
	        for(int i=0; i < efectos.getLength(); i++){
	        	Element efectoElem =(Element)efectos.item(i);
	        	Efecto ef = new Efecto();
	        	ef.setId(efectoElem.getElementsByTagName("idEfecto").item(0).getTextContent());
	        	ef.setDescripcion(efectoElem.getElementsByTagName("descripcion").item(0).getTextContent());
	        	String idAcc = efectoElem.getElementsByTagName("idAccion").item(0).getTextContent();
	        	ef.setAccion(alt.getAcciones().buscarElemento(idAcc));
	        	ef.setFactor(arbFact.buscarElemento(efectoElem.getElementsByTagName("idFactor").item(0).getTextContent()));
	        	ef.setJuicio(ValorJuicio.valueOf(efectoElem.getElementsByTagName("valorSimpleEnjuiciamiento").item(0).getTextContent()));
	        	ef.setCaracter(CaracterEfecto.valueOf(efectoElem.getElementsByTagName("caracter").item(0).getTextContent()));
	        	
	        	Element valoracion = (Element)efectoElem.getElementsByTagName("valorCuantitativo").item(0);
	        	if(valoracion != null){
		        	ValoracionCuantitativa valCuant = new ValoracionCuantitativa(Double.valueOf(valoracion.getElementsByTagName("indicador").item(0).getTextContent()),
							 													 Double.valueOf(valoracion.getElementsByTagName("maxVal").item(0).getTextContent()),
							 													 Double.valueOf(valoracion.getElementsByTagName("minVal").item(0).getTextContent()));
		        	ef.setValCuantitativa(valCuant);
	        	}
	        	
	        	valoracion = (Element)efectoElem.getElementsByTagName("valorCualitativo").item(0);
	        	if(valoracion != null){
	        		ValoracionCualitativa valCual = new ValoracionCualitativa(Integer.valueOf(valoracion.getElementsByTagName("signo").item(0).getTextContent()),
	        																  Integer.valueOf(valoracion.getElementsByTagName("acumulacion").item(0).getTextContent()), 
	        																  Integer.valueOf(valoracion.getElementsByTagName("extension").item(0).getTextContent()), 
	        																  Integer.valueOf(valoracion.getElementsByTagName("extensionCritica").item(0).getTextContent()),
	        																  Integer.valueOf(valoracion.getElementsByTagName("intensidad").item(0).getTextContent()), 
	        																  Integer.valueOf(valoracion.getElementsByTagName("persistencia").item(0).getTextContent()),
	        																  Integer.valueOf(valoracion.getElementsByTagName("reversibilidad").item(0).getTextContent()), 
	        																  Integer.valueOf(valoracion.getElementsByTagName("recuperabilidad").item(0).getTextContent()),
	        																  Integer.valueOf(valoracion.getElementsByTagName("periodicidad").item(0).getTextContent()), 
	        																  Integer.valueOf(valoracion.getElementsByTagName("momento").item(0).getTextContent()), 
	        																  Integer.valueOf(valoracion.getElementsByTagName("momentoCritico").item(0).getTextContent()), 
	        																  Integer.valueOf(valoracion.getElementsByTagName("efectoImp").item(0).getTextContent()));
	        	
	        		ef.setValCualitativa(valCual);
	        	}
	     	    
	        	Element elemValorTotal = (Element)efectoElem.getElementsByTagName("valorTotal").item(0);
	        	if(elemValorTotal != null)
	        		ef.setValorTotal(Double.valueOf(elemValorTotal.getTextContent()));       	
	        	listaEf.add(ef);
	        }
        }
        alt.setEfectos(listaEf);
        if(elemento.getElementsByTagName("valorTotalAlternativa").item(0)!=null)
        	alt.setValorTotal(Double.valueOf(elemento.getElementsByTagName("valorTotalAlternativa").item(0).getTextContent()));
		
        return alt;
	}
	
	 /**
     * Metodo privado que dado una accion recorre su lista de subacciones.
     * @param accion Accion que puede tener una lista de subacciones.
     * @return Estructura de arbol con acciones y subacciones.
     */
    private Arbol<Accion> recorrerAcciones(Element accion){
    	//Caso base
    	if(accion.getElementsByTagName("listaAcciones").getLength() == 0){
    		Accion a = new Accion (accion.getElementsByTagName("nombreAccion").item(0).getTextContent());
    		Arbol<Accion> arb = new Arbol<Accion>();
    		arb.setElemento(a);
    		return arb;
    	}
    	//Caso recursivo
    	else{
    		//Cogemos la lista de subfactores.
    		Element listaAcciones = (Element)accion.getElementsByTagName("listaAcciones").item(0);
    		NodeList acciones = listaAcciones.getElementsByTagName("accion");
    		//Creamos el nodo padre del arbol.
    		Accion a = new Accion (accion.getElementsByTagName("nombreAccion").item(0).getTextContent());
    		Arbol<Accion> padre = new Arbol<Accion>();
    		padre.setElemento(a);
    		//Recorremos cada subfactor.
    		for(int i = 0; i < acciones.getLength(); i++){
    			Arbol<Accion> arb = recorrerAcciones((Element)acciones.item(i));    			
    			padre.añadirHijo(arb);
    		}
    		return padre;
    	}
    }
    

	@Override
	public void escribir(Object o, String archivo) {
		log.info("Guardando informacion en el archivo " + archivo);		
        Document document=null;
        Alternativa alt = (Alternativa)o;
        try{
        	/*Creación del documento*/
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
 
            /*Creación del elemento ráiz*/            
            Element root = (Element) document.createElement("alternativaProyEIA");
            document.appendChild (root);
            
            Element nombre = (Element)document.createElement("nombre");
            nombre.setTextContent(alt.getId());
            root.appendChild(nombre);
            
            //Creamos la lista de acciones.
            Element listaAcciones = (Element)document.createElement("listaAcciones");
            
            Arbol<Accion> acciones = alt.getAcciones();
            
            int numHijos = acciones.getHijos().size();
            
            for(int i=0; i< numHijos; i++){
            	int cont = 1;
            	Element accion = recorrerAcciones(acciones.getHijos().get(i),document,cont);
            	if(acciones.getHijos().get(i).getHijos().size() > 0 )
            		i = i + cont + 1;
            	listaAcciones.appendChild(accion);
            }            
            root.appendChild(listaAcciones);
            
            if(alt.getEfectos().size() > 0){
	            Element listaEfectos = (Element)document.createElement("listaEfectos");            
	            for(int i=0; i<alt.getEfectos().size(); i++){
	            	Element elemEfecto = (Element)document.createElement("efecto");
	            	Efecto ef = alt.getEfectos().get(i);
	            	
	            	Element idEfecto = document.createElement("idEfecto");
	            	idEfecto.setTextContent(ef.getId());
	            	elemEfecto.appendChild(idEfecto);
	            	
	            	Element descripcion = document.createElement("descripcion");
	            	descripcion.setTextContent(ef.getDescripcion());
	            	elemEfecto.appendChild(descripcion);
	            	
	            	Element caracter = document.createElement("caracter");
	            	caracter.setTextContent(ef.getCaracter().toString());
	            	elemEfecto.appendChild(caracter);
	            	
	            	Element idAccion = document.createElement("idAccion");
	            	idAccion.setTextContent(ef.getAccion().getId());
	            	elemEfecto.appendChild(idAccion);
	            	
	            	Element idFactor = document.createElement("idFactor");
	            	idFactor.setTextContent(ef.getFactor().getId());
	            	elemEfecto.appendChild(idFactor);
	            	
	            	Element valorSimpleEnjuiciamiento = document.createElement("valorSimpleEnjuiciamiento");
	            	valorSimpleEnjuiciamiento.setTextContent(ef.getJuicio().toString());
	            	elemEfecto.appendChild(valorSimpleEnjuiciamiento);
	            	
	            	Element valorCuantitativo = document.createElement("valorCuantitativo");
	            	
	            	Element indicador = document.createElement("indicador");
	            	indicador.setTextContent(Double.toString(ef.getValCuantitativa().getIndicador()));
	            	valorCuantitativo.appendChild(indicador);
	            	Element maxVal = document.createElement("maxVal");
	            	maxVal.setTextContent(Double.toString(ef.getValCuantitativa().getMayorValorIndicador()));
	            	valorCuantitativo.appendChild(maxVal);
	            	Element minVal = document.createElement("minVal");
	            	minVal.setTextContent(Double.toString(ef.getValCuantitativa().getMenorValorIndicador()));
	            	valorCuantitativo.appendChild(minVal);
	            	Element magnitud = document.createElement("magnitud");
	            	magnitud.setTextContent(Double.toString(ef.getValCuantitativa().getMagnitudImpacto()));
	            	valorCuantitativo.appendChild(magnitud);
	            	
	            	elemEfecto.appendChild(valorCuantitativo);
	            	
	            	Element valorCualitativo = document.createElement("valorCualitativo");
	            	
	            	Element signo = document.createElement("signo");
	            	signo.setTextContent(Integer.toString(ef.getValCualitativa().getSigno()));
	            	valorCualitativo.appendChild(signo);
	            	
	            	Element acumulacion = document.createElement("acumulacion");
	            	acumulacion.setTextContent(Integer.toString(ef.getValCualitativa().getAcumulacion()));
	            	valorCualitativo.appendChild(acumulacion);
	            	
	            	Element extension = document.createElement("extension");
	            	extension.setTextContent(Integer.toString(ef.getValCualitativa().getExtension()));
	            	valorCualitativo.appendChild(extension);
	            	
	            	Element extensionCritica = document.createElement("extensionCritica");
	            	extensionCritica.setTextContent(Integer.toString(ef.getValCualitativa().getExtensionCritica()));
	            	valorCualitativo.appendChild(extensionCritica);
	            	
	            	Element intensidad = document.createElement("intensidad");
	            	intensidad.setTextContent(Integer.toString(ef.getValCualitativa().getIntensidad()));
	            	valorCualitativo.appendChild(intensidad);
	            	
	            	Element persistencia = document.createElement("persistencia");
	            	persistencia.setTextContent(Integer.toString(ef.getValCualitativa().getPersistencia()));
	            	valorCualitativo.appendChild(persistencia);
	            	
	            	Element reversibilidad = document.createElement("reversibilidad");
	            	reversibilidad.setTextContent(Integer.toString(ef.getValCualitativa().getReversibilidad()));
	            	valorCualitativo.appendChild(reversibilidad);
	            	
	            	Element recuperabilidad = document.createElement("recuperabilidad");
	            	recuperabilidad.setTextContent(Integer.toString(ef.getValCualitativa().getRecuperabilidad()));
	            	valorCualitativo.appendChild(recuperabilidad);
	            	
	            	Element periodicidad = document.createElement("periodicidad");
	            	periodicidad.setTextContent(Integer.toString(ef.getValCualitativa().getPeriodicidad()));
	            	valorCualitativo.appendChild(periodicidad);
	            	
	            	Element momento = document.createElement("momento");
	            	momento.setTextContent(Integer.toString(ef.getValCualitativa().getMomento()));
	            	valorCualitativo.appendChild(momento);
	            	
	            	Element momentoCritico = document.createElement("momentoCritico");
	            	momentoCritico.setTextContent(Integer.toString(ef.getValCualitativa().getMomentoCritico()));
	            	valorCualitativo.appendChild(momentoCritico);
	            	
	            	Element efectoImp = document.createElement("efectoImp");
	            	efectoImp.setTextContent(Integer.toString(ef.getValCualitativa().getEfecto()));
	            	valorCualitativo.appendChild(efectoImp);
	            	
	            	Element incidencia = document.createElement("incidencia");
	            	incidencia.setTextContent(Double.toString(ef.getValCualitativa().getIncidencia()));
	            	valorCualitativo.appendChild(incidencia);
	            	
	            	elemEfecto.appendChild(valorCualitativo);
	            	
	            	Element valorTotal = document.createElement("valorTotal");
	            	valorTotal.setTextContent(String.valueOf(ef.getValorTotal()));
	            	elemEfecto.appendChild(valorTotal);            	
	            	
	            	listaEfectos.appendChild(elemEfecto);
	            }            
	            root.appendChild(listaEfectos);
            }    
            if(alt.getValorTotal() > 0){
            	Element valorTotalAlternativa= document.createElement("valorTotalAlternativa");
            	valorTotalAlternativa.setTextContent(String.valueOf(alt.getValorTotal()));
            	root.appendChild(valorTotalAlternativa); 
            }
            //Finalizado el archivo XML se almacena físicamente            
            writeFile(document, archivo);
        
            log.info("Informacion guardada correctamente");
        }   
        catch (java.lang.Exception e) {
        	System.out.println(e.getMessage());
        }
	}
    
    /**
     * Metodo privado que dado un arbol de acciones lo recorre y crea la accion correspondiente.
     * @param factor Arbol de acciones y subacciones.
     * @return El elemento accion con acciones y subacciones.
     */
    private Element recorrerAcciones(Arbol<Accion> accion, Document document, int cont){
    	
    	Element elemAccion = (Element)document.createElement("accion");
    	Accion a = accion.getElemento();
    	
    	Element nombreAccion = (Element)document.createElement("nombreAccion");
    	nombreAccion.setTextContent(a.getId());
    	
    	elemAccion.appendChild(nombreAccion);
    	
    	//Caso base: es un factor hijo, no tiene subfactores.
    	if(accion.getHijos().size() == 0){        	
        	return elemAccion;
    	}
    	//Caso recursivo: Tiene una lista de subfactores asociada. 
    	else{ 
    		Element listaSubAcciones = document.createElement("listaAcciones");
    		for(int i=0; i<accion.getHijos().size(); i++){
    			Element elemSubAccion = recorrerAcciones(accion.getHijos().get(i), document, cont++);
    			listaSubAcciones.appendChild(elemSubAccion);
    			i = i + cont + 1;
    		}
    		elemAccion.appendChild(listaSubAcciones);
    		return elemAccion;
    	}
    }

}
