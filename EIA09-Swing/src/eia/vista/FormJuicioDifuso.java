package eia.vista;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

//TODO
public class FormJuicioDifuso extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	public FormJuicioDifuso(Frame owner) {
		super(owner);
		initialize();
	}

	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Asistente difuso: efecto");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//image-loading.png"));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

}
