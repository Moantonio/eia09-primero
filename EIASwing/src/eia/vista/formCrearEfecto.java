package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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
	private JLabel enjuiciamientoLabel = null;
	private JTextField nombreTextField = null;
	private JTextArea descripcionTextArea = null;
	private JComboBox enjuiciamientoComboBox = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;

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
		this.setSize(475, 280);
		this.setContentPane(getJContentPane());
		this.setTitle("Nuevo efecto");
		this.setResizable(false);
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
			accionTextField.setLocation(new Point(78, 15));
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
			enjuiciamientoLabel.setBounds(new Rectangle(30, 119, 135, 18));
			enjuiciamientoLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			enjuiciamientoLabel.setText("Simple enjuiciamiento:");
			descripcionLabel = new JLabel();
			descripcionLabel.setBounds(new Rectangle(31, 58, 78, 16));
			descripcionLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			descripcionLabel.setText("Descripción:");
			nombreLabel = new JLabel();
			nombreLabel.setText("Nombre:");
			nombreLabel.setSize(new Dimension(51, 16));
			nombreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreLabel.setLocation(new Point(60, 30));
			crearEfectoPanel = new JPanel();
			crearEfectoPanel.setLayout(null);
			crearEfectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Información del efecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			crearEfectoPanel.setSize(new Dimension(441, 162));
			crearEfectoPanel.setLocation(new Point(13, 40));
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

	/**
	 * This method initializes aceptarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setName("");
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(139, 215));
			aceptarButton.setSize(new Dimension(85, 20));
			aceptarButton.setBackground(Color.white);
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
			cancelarButton.setName("");
			cancelarButton.setSelected(false);
			cancelarButton.setText("Cancelar");
			cancelarButton.setLocation(new Point(244, 215));
			cancelarButton.setSize(new Dimension(85, 20));
			cancelarButton.setBackground(Color.white);
			cancelarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return cancelarButton;
	}

}
