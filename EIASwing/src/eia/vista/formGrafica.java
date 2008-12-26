package eia.vista;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.image.BufferedImage;

import javax.swing.JDialog;

public class formGrafica extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private BufferedImage grafica = null;

	public formGrafica(Frame owner, BufferedImage grafica) {
		super(owner);
		this.grafica = grafica;
		initialize();
	}

	private void initialize() {
		this.setSize(500, 300);
		this.setTitle("Gráfica valoración cuantitativa");
		this.setContentPane(getJContentPane());
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
		}
		return jContentPane;
	}

	public void paint(java.awt.Graphics g) {
		g.drawImage(grafica,0,30,null);
	}

}
