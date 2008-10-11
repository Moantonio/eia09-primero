/**
 * 
 */
package pruebas;

/**
 * @author Luis
 *
 */
import java.applet.*;
import java.awt.*;

public class MiApplet extends Applet implements Runnable
{
   private static final long serialVersionUID = 1L;
   private Thread hilo = null;
   private Font fuente;
   private String texto = "";

   public void init()
   {
	   // Fijamos el tamaño del applet
	   int ancho = 500;
	   int alto = 500;
	   this.setSize(ancho, alto);
       fuente = new Font("Verdana", Font.BOLD, 24);
   }
   
   public void start()
   {
      if (hilo == null)
      {
         hilo = new Thread(this, "Prueba");
         hilo.start();
      }
   }  
   
   public void run()
   {
      Thread hiloActual = Thread.currentThread();
      while (hilo == hiloActual)
      {
         texto = new String ("EIA 09");
         repaint();
         try
         {
            Thread.sleep(1000);
         }
         catch (InterruptedException e){}
      }
   }  
   
   public void paint(Graphics g)
   {   
      //Dibujar un rectangulo alrededor del contenedor
      g.draw3DRect(1, 1, getSize().width-3, getSize().height-3, false);
      //Establecer la Fuente
      g.setFont(fuente);
      //Mostrar el texto
      g.drawString(texto,14,40);
   }   
   
   public void stop()
   {   
      hilo = null;
   }   
}

