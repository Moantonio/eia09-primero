package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import eia.util.ValorJuicio;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

public class formCrearEfecto extends JDialog {

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
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
	private JComboBox enjuiciamientoComboBox = null;
	// Variables del modelo
	private boolean flagAceptar = false;
	private String nombreAccion;
	private String nombreFactor;

	public formCrearEfecto(String nAccion, String nFactor) {
		super();
		nombreAccion = nAccion;
		nombreFactor = nFactor;
		initialize();
	}

	public formCrearEfecto(Frame owner, String nAccion, String nFactor) {
		super(owner);
		nombreAccion = nAccion;
		nombreFactor = nFactor;
		initialize();
	}

	private void initialize() {
		this.setSize(475, 280);
		this.setContentPane(getJContentPane());
		this.setTitle("Nuevo efecto");
	}

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

	private JTextField getAccionTextField() {
		if (accionTextField == null) {
			accionTextField = new JTextField();
			accionTextField.setLocation(new Point(78, 15));
			accionTextField.setFont(new Font("Dialog", Font.BOLD, 12));
			accionTextField.setEnabled(false);
			accionTextField.setSize(new Dimension(150, 18));
			accionTextField.setText(nombreAccion);
		}
		return accionTextField;
	}

	private JTextField getFactorTextField() {
		if (factorTextField == null) {
			factorTextField = new JTextField();
			factorTextField.setLocation(new Point(287, 15));
			factorTextField.setFont(new Font("Dialog", Font.BOLD, 12));
			factorTextField.setEnabled(false);
			factorTextField.setSize(new Dimension(150, 18));
			factorTextField.setText(nombreFactor);
		}
		return factorTextField;
	}

	private JPanel getCrearEfectoPanel() {
		if (crearEfectoPanel == null) {
			enjuiciamientoLabel = new JLabel();
			enjuiciamientoLabel.setBounds(new Rectangle(30, 119, 135, 18));
			enjuiciamientoLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			enjuiciamientoLabel.setText("Simple enjuiciamiento:");
			descripcionLabel = new JLabel();
			descripcionLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			descripcionLabel.setLocation(new Point(38, 57));
			descripcionLabel.setSize(new Dimension(80, 16));
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

	private JTextField getNombreTextField() {
		if (nombreTextField == null) {
			nombreTextField = new JTextField();
			nombreTextField.setLocation(new Point(135, 31));
			nombreTextField.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreTextField.setSize(new Dimension(273, 18));
		}
		return nombreTextField;
	}

	private JTextArea getDescripcionTextArea() {
		if (descripcionTextArea == null) {
			descripcionTextArea = new JTextArea();
			descripcionTextArea.setBounds(new Rectangle(135, 56, 272, 47));
			descripcionTextArea.setFont(new Font("Dialog", Font.BOLD, 12));
			descripcionTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		}
		return descripcionTextArea;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setName("");
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(139, 215));
			aceptarButton.setSize(new Dimension(85, 20));
			aceptarButton.setBackground(Color.white);
			aceptarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					flagAceptar = true;
					setVisible(false);
				}
			});
		}
		return aceptarButton;
	}

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
					setVisible(false);
				}
			});
		}
		return cancelarButton;
	}

	public boolean isFlagAceptar() {
		return flagAceptar;
	}

	public String getNombre(){
		return nombreTextField.getText();
	}

	public String getDescripcion(){
		return descripcionTextArea.getText();
	}

	public ValorJuicio getEnjuiciamiento(){
		String seleccion = enjuiciamientoComboBox.getSelectedItem().toString();
		ValorJuicio juicio = null;
		if (seleccion.compareTo("despreciable") == 0){
			juicio = ValorJuicio.despreciable;
		} else if (seleccion.compareTo("especial") == 0){
			juicio = ValorJuicio.especial;
		} else if (seleccion.compareTo("impredecible") == 0){
			juicio = ValorJuicio.impredecible;
		} else if (seleccion.compareTo("significativo") == 0){
			juicio = ValorJuicio.significativo;
		}
		return juicio;
	}

	private JComboBox getEnjuiciamientoComboBox() {
		if (enjuiciamientoComboBox == null) {
			String[] opciones = {ValorJuicio.despreciable.toString(),ValorJuicio.especial.toString(),
					ValorJuicio.impredecible.toString(), ValorJuicio.significativo.toString()};
			enjuiciamientoComboBox = new JComboBox(opciones);
			enjuiciamientoComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
			enjuiciamientoComboBox.setLocation(new Point(164, 120));
			enjuiciamientoComboBox.setSize(new Dimension(175, 17));
		}
		return enjuiciamientoComboBox;
	}

}
