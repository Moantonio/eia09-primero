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

	public void init()
	{	
		// Fijamos el tamaño del applet
		int ancho = 500;
		int alto = 500;
		this.setSize(ancho, alto);

		// Fijamos color de fondo
		Color cFondo = new Color(230,230,230);
		this.setBackground(cFondo);
		
		// Fijamos un layout
		setLayout( new FlowLayout( FlowLayout.CENTER,10,10) );

		// Añadimos componentes
		Label x = new Label("EIA'09");
		add(x);
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
		//Seleccionamos color
		Color c = new Color(0,0,0);
		g.setColor(c);

		//Dibujar un rectangulo alrededor del contenedor
		g.draw3DRect(5, 5, getSize().width-10, getSize().height-10, false);
	}   

	public void stop()
	{   
		hilo = null;
	}   
}

