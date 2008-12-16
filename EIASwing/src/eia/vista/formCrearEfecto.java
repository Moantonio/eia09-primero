package eia.vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class formCrearEfecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel accionLabel = null;
	private JLabel factorLabel = null;
	private JTextField accionTextField = null;
	private JTextField factorTextField = null;
	private JPanel crearEfectoPanel = null;
	private JLabel nombreLabel = null;
	private JLabel descripcionLabel = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
	private JLabel enjuiciamientoLabel = null;
	private JTextField nombreTextField = null;
	private JTextArea descripcionTextArea = null;
	private JComboBox enjuiciamientoComboBox = null;

	/**
	 * This is the default constructor
	 */
	public formCrearEfecto() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("EIA09");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			factorLabel = new JLabel();
			factorLabel.setBounds(new Rectangle(242, 19, 42, 13));
			factorLabel.setText("Factor:");
			accionLabel = new JLabel();
			accionLabel.setBounds(new Rectangle(29, 17, 45, 15));
			accionLabel.setText("Acción:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(accionLabel, null);
			jContentPane.add(factorLabel, null);
			jContentPane.add(getAccionTextField(), null);
			jContentPane.add(getFactorTextField(), null);
			jContentPane.add(getCrearEfectoPanel(), null);
			jContentPane.add(getAceptarButton(), null);
			jContentPane.add(getCancelarButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes accionTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getAccionTextField() {
		if (accionTextField == null) {
			accionTextField = new JTextField();
			accionTextField.setLocation(new Point(72, 15));
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
			factorTextField.setLocation(new Point(287, 15));
			factorTextField.setSize(new Dimension(150, 18));
		}
		return factorTextField;
	}

	/**
	 * This method initializes crearEfectoPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCrearEfectoPanel() {
		if (crearEfectoPanel == null) {
			enjuiciamientoLabel = new JLabel();
			enjuiciamientoLabel.setBounds(new Rectangle(30, 119, 164, 18));
			enjuiciamientoLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			enjuiciamientoLabel.setText("Simple enjuiciamiento:");
			descripcionLabel = new JLabel();
			descripcionLabel.setBounds(new Rectangle(31, 58, 92, 16));
			descripcionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			descripcionLabel.setText("Descripción:");
			nombreLabel = new JLabel();
			nombreLabel.setText("Nombre:");
			nombreLabel.setSize(new Dimension(61, 16));
			nombreLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			nombreLabel.setLocation(new Point(60, 30));
			crearEfectoPanel = new JPanel();
			crearEfectoPanel.setLayout(null);
			crearEfectoPanel.setBounds(new Rectangle(30, 41, 441, 162));
			crearEfectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Crear Efecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			crearEfectoPanel.add(nombreLabel, null);
			crearEfectoPanel.add(descripcionLabel, null);
			crearEfectoPanel.add(enjuiciamientoLabel, null);
			crearEfectoPanel.add(getNombreTextField(), null);
			crearEfectoPanel.add(getDescripcionTextArea(), null);
			crearEfectoPanel.add(getEnjuiciamientoComboBox(), null);
		}
		return crearEfectoPanel;
	}

	/**
	 * This method initializes aceptarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setLocation(new Point(120, 214));
			aceptarButton.setText("Aceptar");
			aceptarButton.setSize(new Dimension(100, 25));
		}
		return aceptarButton;
	}

	/**
	 * This method initializes cancelarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCancelarButton() {
		if (cancelarButton == null) {
			cancelarButton = new JButton();
			cancelarButton.setLocation(new Point(243, 214));
			cancelarButton.setText("Cancelar");
			cancelarButton.setSize(new Dimension(100, 25));
		}
		return cancelarButton;
	}

	/**
	 * This method initializes nombreTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getNombreTextField() {
		if (nombreTextField == null) {
			nombreTextField = new JTextField();
			nombreTextField.setLocation(new Point(135, 31));
			nombreTextField.setFont(new Font("Dialog", Font.PLAIN, 14));
			nombreTextField.setSize(new Dimension(273, 18));
		}
		return nombreTextField;
	}

	/**
	 * This method initializes descripcionTextArea
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getDescripcionTextArea() {
		if (descripcionTextArea == null) {
			descripcionTextArea = new JTextArea();
			descripcionTextArea.setBounds(new Rectangle(135, 56, 272, 47));
			descripcionTextArea.setFont(new Font("Dialog", Font.PLAIN, 12));
			descripcionTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		}
		return descripcionTextArea;
	}

	/**
	 * This method initializes enjuiciamientoComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getEnjuiciamientoComboBox() {
		if (enjuiciamientoComboBox == null) {
			enjuiciamientoComboBox = new JComboBox();
			enjuiciamientoComboBox.setBounds(new Rectangle(198, 122, 209, 17));
			enjuiciamientoComboBox.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return enjuiciamientoComboBox;
	}

}
