package eia.util.xml;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import eia.util.Constants;

import eia.model.Alternativa;
import eia.model.Factor;
import eia.model.InfoProyecto;
import eia.model.Proyecto;
import eia.util.Arbol;

public class XMLProyecto extends XMLTools{
	
	Logger log;
	
	public XMLProyecto(String dtd){	
		log = Logger.getLogger( this.getClass() );
		PropertyConfigurator.configure(Constants.LOG4J_PROPERTIES);
		this.setDtd(dtd);
	}
	
	
	 /**
     * El método leer recupera un proyecto con la información almacenada en el documento XML
     * @param filename
     * @return
     */
    public Proyecto leer(String filename) {
    	
    	log.info("Cargando xml: " +  filename);
    	
        //Se obtiene el objeto Document que representa al archivo xml
        Document doc= readFile(filename);
        
        //Se recupera el objeto Element principal del objeto Document
        Element elemento=(Element)doc. getDocumentElement();
        
        Proyecto proy = new Proyecto();
        
        //Obtenemos la fecha, tenemos que parsearla para darle formato y guardarla en el objeto.
        Element elemFecha = (Element)elemento.getElementsByTagName("fecha").item(0);
        StringBuffer stringFecha = new StringBuffer().append(elemFecha.getElementsByTagName("dia").item(0).getTextContent()).append('-')
		        									 .append(elemFecha.getElementsByTagName("mes").item(0).getTextContent()).append('-')
		        									 .append(elemFecha.getElementsByTagName("anio").item(0).getTextContent());
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = Calendar.getInstance().getTime(); //Ponemos por defecto la fecha de hoy.
		try {
			fecha = format.parse(stringFecha.toString());
		} catch (ParseException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
				
        InfoProyecto info = new InfoProyecto(elemento.getElementsByTagName("nombre").item(0).getTextContent(),
        									 elemento.getElementsByTagName("descripcion").item(0).getTextContent(),
        									 elemento.getElementsByTagName("promotor").item(0).getTextContent(),
        									 elemento.getElementsByTagName("redactor").item(0).getTextContent(),
        									 elemento.getElementsByTagName("poblacion").item(0).getTextContent(),
        									 elemento.getElementsByTagName("provincia").item(0).getTextContent(),
        									 elemento.getElementsByTagName("region").item(0).getTextContent(),
        									 elemento.getElementsByTagName("pais").item(0).getTextContent(),
        									 fecha,
        									 Integer.valueOf(elemento.getElementsByTagName("vidaUtil").item(0).getTextContent()).intValue());
        proy.setInformacion(info);
        
        //Cogemos la lista principal de factores.
        Element listaFactores = (Element)elemento.getElementsByTagName("listaFactores").item(0);
        NodeList factores = listaFactores.getElementsByTagName("factor");
        
        //Para cada factor, vamos recorriendo los subfactores y creando el arbol.
        Arbol<Factor> arbolFact = new Arbol<Factor>();
        for(int i = 0; i < factores.getLength(); i++){
        	Arbol<Factor> arbolI = recorrerFactores((Element)factores.item(i));
        	arbolFact.añadirHijo(arbolI);
        }        
        proy.setFactores(arbolFact);   
        
      //Cogemos la lista de alternativas.
        Element listaAlternativas = (Element)elemento.getElementsByTagName("listaAlternativas").item(0);
        NodeList alternativas = listaAlternativas.getElementsByTagName("nombreAlternativa");
        ArrayList<Alternativa> listaAlt = new ArrayList<Alternativa>();
        for(int i=0; i<alternativas.getLength(); i++){
        	Alternativa alt = new Alternativa();
        	alt.setId(alternativas.item(i).getTextContent());
        	listaAlt.add(alt);
        }
        proy.setAlternativas(listaAlt);
        escribirLog(proy);
        return proy;
    }
     /**
      * Metodo privado que dado un proyecto cargado escribe su informacion en el log.
      * @param p Proyecto cargado que contiene la informacion.
      */
    private void escribirLog(Proyecto p){
    	log.info("INFORMACION DEL PROYECTO CARGADO");
		log.info("================================");
		log.info("Nombre: "+ p.getInformacion().getNombre());
		log.info("Descripcion: "+ p.getInformacion().getDescripcion());
		log.info("Compañia: "+ p.getInformacion().getCompania());
		log.info("Redactor: "+ p.getInformacion().getAutor());
		log.info("Fecha: "+ p.getInformacion().getFecha().toString());
		log.info("Vida Util: "+ p.getInformacion().getVidaUtil());
		log.info("Poblacion: "+ p.getInformacion().getPoblacion());
		log.info("Provincia: "+ p.getInformacion().getProvincia());
		log.info("Region: "+ p.getInformacion().getRegion());
		log.info("Pais: "+ p.getInformacion().getPais());
		log.info("Alternativas: \n");
		
		log.info("Factores: \n");
		ArrayList<Arbol<Factor>> listaFactores = p.getFactores().getHijos();
		for(int i = 0; i<listaFactores.size(); i++){
			Arbol<Factor> arbFact = listaFactores.get(i);
			if(arbFact.esHoja()){
				log.info("\t Nombre factor: "+arbFact.getElemento().getId());
				log.info("\t Peso: "+arbFact.getElemento().getPeso());
			}
			else{
				log.info("Nombre factor: "+arbFact.getElemento().getId());
				log.info("Peso: "+arbFact.getElemento().getPeso());
			}
		}
    }
    
    /**
     * Metodo privado que dado un factor recorre su lista de subfactores.
     * @param factor Factor que puede tener una lista de subfactores.
     * @return Estructura de arbol con factores y subfactores.
     */
    private Arbol<Factor> recorrerFactores(Element factor){
    	//Caso base
    	if(factor.getElementsByTagName("listaFactores").getLength() == 0){
    		Factor f = new Factor (factor.getElementsByTagName("nombreFactor").item(0).getTextContent(),
					   Integer.valueOf(factor.getElementsByTagName("peso").item(0).getTextContent()));
    		Arbol<Factor> arb = new Arbol<Factor>();
    		arb.setElemento(f);
    		return arb;
    	}
    	//Caso recursivo
    	else{
    		//Cogemos la lista de subfactores.
    		Element listaFactores = (Element)factor.getElementsByTagName("listaFactores").item(0);
    		NodeList factores = listaFactores.getElementsByTagName("factor");
    		//Creamos el nodo padre del arbol.
    		Factor f = new Factor (factor.getElementsByTagName("nombreFactor").item(0).getTextContent(),
    				Integer.valueOf(factor.getElementsByTagName("peso").item(0).getTextContent()));
    		Arbol<Factor> padre = new Arbol<Factor>();
    		padre.setElemento(f);
    		//Recorremos cada subfactor.
    		for(int i = 0; i < factores.getLength(); i++){
    			Arbol<Factor> arb = recorrerFactores((Element)factores.item(i));    			
    			padre.añadirHijo(arb);
    		}
    		return padre;
    	}
    }
    
    /**
     * Metodo que alamacena informacion en un fichero XML
     * @param datos Lista de informacion que ya teniamos almacenada
     * @param tabla 
     * @param archivo Ruta del fichero XML donde queremos almacenar la informacion.
     */
	public void escribir(Object o, String archivo) {
		log.info("Guardando informacion en el archivo " + archivo);
		
        Document document=null;
        Proyecto proy = (Proyecto)o;
        
        try {
            /*Creación del documento*/
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
 
            /*Creación del elemento ráiz*/
            Element root = (Element) document.createElement("proyectoEIA");
            document.appendChild (root);
            
            Element nombre = (Element)document.createElement("nombre");
            nombre.setTextContent(proy.getInformacion().getNombre());
            root.appendChild(nombre);
            
            Element descripcion = (Element)document.createElement("descripcion");
            descripcion.setTextContent(proy.getInformacion().getDescripcion());
            root.appendChild(descripcion);
            
            Element promotor = (Element)document.createElement("promotor");
            promotor.setTextContent(proy.getInformacion().getCompania());
            root.appendChild(promotor);
            
            Element redactor = (Element)document.createElement("redactor");
            redactor.setTextContent(proy.getInformacion().getAutor());
            root.appendChild(redactor);
            
            //Convertimos la fecha almacenada en los elementos necesarios en el XML.
            Element fecha = (Element)document.createElement("fecha");
            Element dia = (Element)document.createElement("dia");
            Element mes = (Element)document.createElement("mes");
            Element anio = (Element)document.createElement("anio");
            
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String fechaStr = format.format(proy.getInformacion().getFecha());
            StringTokenizer tokens = new StringTokenizer(fechaStr, "-");            
            
            dia.setTextContent(tokens.nextToken());
            mes.setTextContent(tokens.nextToken());
            anio.setTextContent(tokens.nextToken());
            
            fecha.appendChild(dia);
            fecha.appendChild(mes);
            fecha.appendChild(anio);
            root.appendChild(fecha);
            
            Element vidaUtil = (Element)document.createElement("vidaUtil");
            vidaUtil.setTextContent(Integer.toString(proy.getInformacion().getVidaUtil()));
            root.appendChild(vidaUtil);
            
            Element poblacion = (Element)document.createElement("poblacion");
            poblacion.setTextContent(proy.getInformacion().getPoblacion());
            root.appendChild(poblacion);
            
            Element provincia = (Element)document.createElement("provincia");
            provincia.setTextContent(proy.getInformacion().getProvincia());
            root.appendChild(provincia);
            
            Element region = (Element)document.createElement("region");
            region.setTextContent(proy.getInformacion().getRegion());
            root.appendChild(region);
            
            Element pais = (Element)document.createElement("pais");
            pais.setTextContent(proy.getInformacion().getPais());
            root.appendChild(pais);
            
            //Creamos la lista de alternativas.
            ArrayList<Alternativa> listaAlt = proy.getAlternativas();
            
            Element listaAlternativas = (Element)document.createElement("listaAlternativas");            
            for(int i=0; i<listaAlt.size(); i++){
            	Element elemAlternativa = (Element)document.createElement("nombreAlternativa");
            	elemAlternativa.setTextContent(listaAlt.get(i).getId());
            	listaAlternativas.appendChild(elemAlternativa);
            }            
            root.appendChild(listaAlternativas);
            
            //Creamos la lista de factores.
            Element listaFactores = (Element)document.createElement("listaFactores");
            
            Arbol<Factor> factores = proy.getFactores();
            
            int numHijos = factores.getHijos().size();
            
            for(int i=0; i< numHijos; i++){
            	int cont = 1;
            	Element factor = recorrerFactores(factores.getHijos().get(i),document,cont);
            	if(factores.getHijos().get(i).getHijos().size() > 0 )
            		i = i + cont + 1;
            	listaFactores.appendChild(factor);
            }            
            root.appendChild(listaFactores);           
            
            //Finalizado el archivo XML se almacena físicamente            
            writeFile(document, archivo);
            
            log.info("Informacion guardada correctamente");
        }   
        catch (java.lang.Exception e) {
            System.out.println(e.getMessage());
        }
   }
    /**
     * Metodo privado que dado un arbol de factores lo recorre y crea el factor correspondiente.
     * @param factor Arbol de factores y subfactores.
     * @return El elemento factor con factores y subfactores.
     */
    private Element recorrerFactores(Arbol<Factor> factor, Document document, int cont){
    	
    	Element elemFactor = (Element)document.createElement("factor");
    	Factor f = factor.getElemento();
    	
    	Element nombreFactor = (Element)document.createElement("nombreFactor");
    	nombreFactor.setTextContent(f.getId());
    	
    	Element peso = (Element)document.createElement("peso");
    	peso.setTextContent(Integer.toString(f.getPeso()));
    	
    	elemFactor.appendChild(nombreFactor);
    	elemFactor.appendChild(peso);    	
    	
    	//Caso base: es un factor hijo, no tiene subfactores.
    	if(factor.getHijos().size() == 0){        	
        	return elemFactor;
    	}
    	//Caso recursivo: Tiene una lista de subfactores asociada. 
    	else{ 
    		Element listaSubFactores = document.createElement("listaFactores");
    		for(int i=0; i<factor.getHijos().size(); i++){
    			Element elemSubFactor = recorrerFactores(factor.getHijos().get(i), document, cont++);
    			listaSubFactores.appendChild(elemSubFactor);
    			i = i + cont + 1;
    		}
    		elemFactor.appendChild(listaSubFactores);
    		return elemFactor;
    	}
    }
}
