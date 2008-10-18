package eia.vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import util.Constants;

public class StartScreen extends JApplet{
	
	Logger log = Logger.getLogger(this.getClass());
	JButton b_entrar = new JButton( "Entrar");   // Botón Entrar
	JLabel etiqueta_imagen = new JLabel();      // Etiqueta donde pondremos imagen
	ImageIcon imagen;

	 public void init() {
		    try {  jbInit(); }
		    catch ( Exception e ) {  e.printStackTrace();  }
	 }

	  /*******************************************************************
	   * Inicialización de componentes
	   ******************************************************************/
	 private void jbInit() throws Exception {
		 
		 PropertyConfigurator.configure(Constants.LOG4J_PROPERTIES);

		 /*** Asignno un administrador de diseño FlowLayout ***/
		 this.setSize(new Dimension(576,348));
		 this.setLayout( new FlowLayout());

		etiqueta_imagen.setBorder( BorderFactory.createRaisedBevelBorder());
		etiqueta_imagen.setPreferredSize(new Dimension(576, 308));
		
		loadImage();

	    add(etiqueta_imagen);
	    add(b_entrar);
	 } 
	 
	  /****************************************************************************
	   * Carga la imagen de la portada.
	   ****************************************************************************/
	  void loadImage() {
	    try {
		  /*** Leer de JAR: obtenemos el URL y cargo imagen en array ***/
		  URL url_imagen = new URL(this.getCodeBase() + Constants.IMG_START);
		  log.info("URL IMAGEN: " + url_imagen);
	  	  imagen= new ImageIcon( getImage( url_imagen ) );
	  	  etiqueta_imagen.setIcon(imagen);
	    }
	    catch (MalformedURLException mue) {  // Hija de IOException
	       log.error("URL inadecuada: ");
	       log.error(mue.getMessage() );
	    }
	    catch (IOException ioe) {            // Hija de Exception
			log.error("IOException: ");
			log.error(ioe.getMessage() );
	    }
	    catch (Exception e) {
	       log.error("Excepción general: cargar_imagenes(). ");
	       log.error(e.getMessage());
	    }
	  }

	 

}
