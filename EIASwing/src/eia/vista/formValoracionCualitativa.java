package eia.vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;

public class formValoracionCualitativa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel efectoPanel = null;
	private JTextField efectoTextField = null;
	private JTextField descripcionTextField = null;
	private JLabel efectoLabel = null;
	private JLabel descripcionLabel = null;
	private JPanel cualitativaPanel = null;
	/**
	 * This is the default constructor
	 */
	public formValoracionCualitativa() {
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
		this.setTitle("Valoración cualitativa");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getEfectoPanel(), null);
			jContentPane.add(getCualitativaPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes efectoPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getEfectoPanel() {
		if (efectoPanel == null) {
			descripcionLabel = new JLabel();
			descripcionLabel.setLocation(new Point(32, 44));
			descripcionLabel.setText("Descripción:");
			descripcionLabel.setSize(new Dimension(75, 16));
			efectoLabel = new JLabel();
			efectoLabel.setLocation(new Point(63, 19));
			efectoLabel.setText("Efecto:");
			efectoLabel.setSize(new Dimension(43, 16));
			efectoPanel = new JPanel();
			efectoPanel.setLayout(null);
			efectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Efecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			efectoPanel.setSize(new Dimension(445, 76));
			efectoPanel.setLocation(new Point(25, 16));
			efectoPanel.add(getEfectoTextField(), null);
			efectoPanel.add(getDescripcionTextField(), null);
			efectoPanel.add(efectoLabel, null);
			efectoPanel.add(descripcionLabel, null);
		}
		return efectoPanel;
	}

	/**
	 * This method initializes efectoTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getEfectoTextField() {
		if (efectoTextField == null) {
			efectoTextField = new JTextField();
			efectoTextField.setLocation(new Point(109, 19));
			efectoTextField.setEnabled(false);
			efectoTextField.setEditable(true);
			efectoTextField.setSize(new Dimension(308, 18));
		}
		return efectoTextField;
	}

	/**
	 * This method initializes descripcionTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getDescripcionTextField() {
		if (descripcionTextField == null) {
			descripcionTextField = new JTextField();
			descripcionTextField.setLocation(new Point(109, 44));
			descripcionTextField.setEnabled(false);
			descripcionTextField.setEditable(true);
			descripcionTextField.setSize(new Dimension(308, 18));
		}
		return descripcionTextField;
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
			cualitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración Cualitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			cualitativaPanel.setLocation(new Point(25, 116));
			cualitativaPanel.setSize(new Dimension(445, 200));
		}
		return cualitativaPanel;
	}

}
