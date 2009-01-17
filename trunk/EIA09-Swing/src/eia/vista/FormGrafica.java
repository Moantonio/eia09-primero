package eia.vista;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JDialog;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

public class FormGrafica extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private BufferedImage grafica = null;

	public FormGrafica(Frame owner, BufferedImage grafica) {
		super(owner);
		this.grafica = grafica;
		initialize();
	}

	private void initialize() {
		this.setSize(450, 280);
		this.setResizable(false);
		this.setTitle("Gráfica valoración cuantitativa");
		this.setContentPane(getJContentPane());
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//utilities-system-monitor.png"));
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
