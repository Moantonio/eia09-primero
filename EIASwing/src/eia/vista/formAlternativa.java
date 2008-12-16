package eia.vista;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JEditorPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class formAlternativa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel altDeRealizacionLabel = null;
	private JTextField altDeRealizcionTextField = null;
	private JPanel AccionesPanel = null;
	private JEditorPane jEditorPane = null;
	private JPanel factoresPanel = null;
	private JEditorPane factoresjEditorPane = null;
	private JButton AnadirButton = null;
	private JButton modificarButton = null;
	private JButton eliminarButton = null;
	/**
	 * This is the default constructor
	 */
	public formAlternativa() {
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
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			altDeRealizacionLabel = new JLabel();
			altDeRealizacionLabel.setText("Alternativa de realización:");
			altDeRealizacionLabel.setSize(new Dimension(149, 16));
			altDeRealizacionLabel.setLocation(new Point(12, 20));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(altDeRealizacionLabel, null);
			jContentPane.add(getAltDeRealizcionTextField(), null);
			jContentPane.add(getAccionesPanel(), null);
			jContentPane.add(getFactoresPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes altDeRealizcionTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAltDeRealizcionTextField() {
		if (altDeRealizcionTextField == null) {
			altDeRealizcionTextField = new JTextField();
			altDeRealizcionTextField.setSize(new Dimension(315, 20));
			altDeRealizcionTextField.setLocation(new Point(162, 18));
		}
		return altDeRealizcionTextField;
	}

	/**
	 * This method initializes AccionesPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getAccionesPanel() {
		if (AccionesPanel == null) {
			AccionesPanel = new JPanel();
			AccionesPanel.setLayout(null);
			AccionesPanel.setLocation(new Point(13, 54));
			AccionesPanel.setSize(new Dimension(249, 200));
			AccionesPanel.add(getJEditorPane(), null);
			AccionesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acciones" +
					""));
			AccionesPanel.add(getAnadirButton(), null);
			AccionesPanel.add(getModificarButton(), null);
			AccionesPanel.add(getEliminarButton(), null);
		}
		return AccionesPanel;
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setBounds(new Rectangle(13, 40, 24, 1));
		}
		return jEditorPane;
	}

	/**
	 * This method initializes factoresPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getFactoresPanel() {
		if (factoresPanel == null) {
			factoresPanel = new JPanel();
			factoresPanel.setLayout(null);
			factoresPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Factores", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			factoresPanel.setLocation(new Point(268, 54));
			factoresPanel.setSize(new Dimension(200, 200));
			factoresPanel.add(getFactoresjEditorPane(), null);
		}
		return factoresPanel;
	}

	/**
	 * This method initializes factoresjEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getFactoresjEditorPane() {
		if (factoresjEditorPane == null) {
			factoresjEditorPane = new JEditorPane();
			factoresjEditorPane.setBounds(new Rectangle(13, 40, 24, 1));
		}
		return factoresjEditorPane;
	}

	/**
	 * This method initializes AnadirButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAnadirButton() {
		if (AnadirButton == null) {
			AnadirButton = new JButton();
			AnadirButton.setBounds(new Rectangle(4, 170, 76, 20));
			AnadirButton.setText("Añadir");
		}
		return AnadirButton;
	}

	/**
	 * This method initializes modificarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getModificarButton() {
		if (modificarButton == null) {
			modificarButton = new JButton();
			modificarButton.setBounds(new Rectangle(80, 170, 88, 20));
			modificarButton.setText("Modificar");
		}
		return modificarButton;
	}

	/**
	 * This method initializes eliminarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEliminarButton() {
		if (eliminarButton == null) {
			eliminarButton = new JButton();
			eliminarButton.setText("Eliminar");
			eliminarButton.setBounds(new Rectangle(168, 170, 77, 20));
		}
		return eliminarButton;
	}

}
