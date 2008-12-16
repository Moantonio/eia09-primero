package eia.vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Point;

public class formEfecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedorPrincipalPane = null;
	private JPanel efectoPanel = null;
	private JPanel cualitativaPanel = null;
	private JPanel cuantitativaPanel = null;
	private JPanel valoracionPanel = null;
	private JPanel botoneraPanel = null;
	private JPanel caracterPanel = null;
	private JPanel enjuiciamientoPanel = null;

	/**
	 * This is the default constructor
	 */
	public formEfecto() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 500);
		this.setContentPane(getContenedorPrincipalPane());
		this.setTitle("Valoración de efecto");
	}

	/**
	 * This method initializes contenedorPrincipalPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getContenedorPrincipalPane() {
		if (contenedorPrincipalPane == null) {
			contenedorPrincipalPane = new JPanel();
			contenedorPrincipalPane.setLayout(null);
			contenedorPrincipalPane.add(getEfectoPanel(), null);
			contenedorPrincipalPane.add(getCualitativaPanel(), null);
			contenedorPrincipalPane.add(getCuantitativaPanel(), null);
			contenedorPrincipalPane.add(getValoracionPanel(), null);
			contenedorPrincipalPane.add(getBotoneraPanel(), null);
			contenedorPrincipalPane.add(getCaracterPanel(), null);
		}
		return contenedorPrincipalPane;
	}

	/**
	 * This method initializes efectoPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getEfectoPanel() {
		if (efectoPanel == null) {
			efectoPanel = new JPanel();
			efectoPanel.setLayout(null);
			efectoPanel.setBounds(new Rectangle(26, 16, 440, 123));
			efectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Efecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			efectoPanel.add(getEnjuiciamientoPanel(), null);
		}
		return efectoPanel;
	}

	/**
	 * This method initializes cualitativaPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCualitativaPanel() {
		if (cualitativaPanel == null) {
			cualitativaPanel = new JPanel();
			cualitativaPanel.setLayout(null);
			cualitativaPanel.setLocation(new Point(24, 149));
			cualitativaPanel.setSize(new Dimension(200, 100));
			cualitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración cualitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		}
		return cualitativaPanel;
	}

	/**
	 * This method initializes cuantitativaPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCuantitativaPanel() {
		if (cuantitativaPanel == null) {
			TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Efecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51));
			titledBorder1.setTitle("Valoración cuantitativa");
			cuantitativaPanel = new JPanel();
			cuantitativaPanel.setLayout(null);
			cuantitativaPanel.setSize(new Dimension(200, 100));
			cuantitativaPanel.setLocation(new Point(266, 148));
			cuantitativaPanel.setBorder(titledBorder1);
		}
		return cuantitativaPanel;
	}

	/**
	 * This method initializes valoracionPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getValoracionPanel() {
		if (valoracionPanel == null) {
			valoracionPanel = new JPanel();
			valoracionPanel.setLayout(null);
			valoracionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			valoracionPanel.setSize(new Dimension(200, 75));
			valoracionPanel.setLocation(new Point(260, 270));
		}
		return valoracionPanel;
	}

	/**
	 * This method initializes botoneraPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getBotoneraPanel() {
		if (botoneraPanel == null) {
			botoneraPanel = new JPanel();
			botoneraPanel.setLayout(null);
			botoneraPanel.setBounds(new Rectangle(267, 361, 187, 59));
			botoneraPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		}
		return botoneraPanel;
	}

	/**
	 * This method initializes caracterPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCaracterPanel() {
		if (caracterPanel == null) {
			caracterPanel = new JPanel();
			caracterPanel.setLayout(null);
			caracterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Carácter", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			caracterPanel.setSize(new Dimension(200, 137));
			caracterPanel.setLocation(new Point(23, 287));
		}
		return caracterPanel;
	}

	/**
	 * This method initializes enjuiciamientoPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getEnjuiciamientoPanel() {
		if (enjuiciamientoPanel == null) {
			enjuiciamientoPanel = new JPanel();
			enjuiciamientoPanel.setLayout(null);
			enjuiciamientoPanel.setBounds(new Rectangle(260, 43, 163, 68));
			enjuiciamientoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Carácter", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		}
		return enjuiciamientoPanel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				formEfecto application = new formEfecto();
				application.setVisible(true);
			}
		});
	}

}
