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
import javax.swing.JTextField;
import javax.swing.JLabel;

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
	private JTextField efectoTextField = null;
	private JTextField accionTextField = null;
	private JTextField factorTextField = null;
	private JTextField descripcionTextField = null;
	private JLabel efectoLabel = null;
	private JLabel accionLabel = null;
	private JLabel factorLabel = null;
	private JLabel descripcionLabel = null;

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
			descripcionLabel = new JLabel();
			descripcionLabel.setText("Descripción:");
			descripcionLabel.setLocation(new Point(20, 71));
			descripcionLabel.setSize(new Dimension(75, 16));
			factorLabel = new JLabel();
			factorLabel.setText("Factor:");
			factorLabel.setLocation(new Point(224, 46));
			factorLabel.setSize(new Dimension(47, 16));
			accionLabel = new JLabel();
			accionLabel.setBounds(new Rectangle(23, 46, 44, 16));
			accionLabel.setText("Acción:");
			efectoLabel = new JLabel();
			efectoLabel.setText("Efecto:");
			efectoLabel.setSize(new Dimension(43, 16));
			efectoLabel.setLocation(new Point(54, 21));
			efectoPanel = new JPanel();
			efectoPanel.setLayout(null);
			efectoPanel.setBounds(new Rectangle(24, 14, 440, 164));
			efectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Efecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			efectoPanel.add(getEnjuiciamientoPanel(), null);
			efectoPanel.add(getEfectoTextField(), null);
			efectoPanel.add(getAccionTextField(), null);
			efectoPanel.add(getFactorTextField(), null);
			efectoPanel.add(getDescripcionTextField(), null);
			efectoPanel.add(efectoLabel, null);
			efectoPanel.add(accionLabel, null);
			efectoPanel.add(factorLabel, null);
			efectoPanel.add(descripcionLabel, null);
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
			cualitativaPanel.setLocation(new Point(32, 197));
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
			cuantitativaPanel.setLocation(new Point(269, 176));
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
			valoracionPanel.setLocation(new Point(244, 299));
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
			botoneraPanel.setBounds(new Rectangle(255, 391, 187, 59));
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
			caracterPanel.setLocation(new Point(23, 327));
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
			enjuiciamientoPanel.setBounds(new Rectangle(124, 98, 163, 53));
			enjuiciamientoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Simple enjuiciamiento", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		}
		return enjuiciamientoPanel;
	}

	/**
	 * This method initializes efectoTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getEfectoTextField() {
		if (efectoTextField == null) {
			efectoTextField = new JTextField();
			efectoTextField.setLocation(new Point(100, 21));
			efectoTextField.setSize(new Dimension(300, 18));
		}
		return efectoTextField;
	}

	/**
	 * This method initializes accionTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getAccionTextField() {
		if (accionTextField == null) {
			accionTextField = new JTextField();
			accionTextField.setLocation(new Point(70, 46));
			accionTextField.setSize(new Dimension(150, 18));
		}
		return accionTextField;
	}

	/**
	 * This method initializes factorTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getFactorTextField() {
		if (factorTextField == null) {
			factorTextField = new JTextField();
			factorTextField.setLocation(new Point(269, 46));
			factorTextField.setSize(new Dimension(150, 18));
		}
		return factorTextField;
	}

	/**
	 * This method initializes descripcionTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getDescripcionTextField() {
		if (descripcionTextField == null) {
			descripcionTextField = new JTextField();
			descripcionTextField.setLocation(new Point(100, 71));
			descripcionTextField.setSize(new Dimension(300, 18));
		}
		return descripcionTextField;
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
