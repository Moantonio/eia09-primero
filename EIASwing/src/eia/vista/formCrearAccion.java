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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class formCrearAccion extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel crearAccionPanel = null;
	private JLabel categoriaLabel = null;
	private JLabel accionLabel = null;
	private JTextField categoriaTextField = null;
	private JTextField accionTextField = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;

	//Variables del modelo
	private boolean flagAceptar = false;
	private String categoria ="";

	public formCrearAccion(Frame owner, String cat) {
		super(owner);
		categoria = cat;
		initialize();
	}

	public boolean isFlagAceptar() {
		return flagAceptar;
	}

	private void initialize() {
		this.setSize(475, 197);
		this.setContentPane(getJContentPane());
		this.setTitle("Nueva acción");
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getCrearAccionPanel(), null);
			jContentPane.add(getAceptarButton(), null);
			jContentPane.add(getCancelarButton(), null);
		}
		return jContentPane;
	}

	private JPanel getCrearAccionPanel() {
		if (crearAccionPanel == null) {
			accionLabel = new JLabel();
			accionLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			accionLabel.setBounds(new Rectangle(45, 60, 97, 16));
			accionLabel.setText("Nombre acción:");
			categoriaLabel = new JLabel();
			categoriaLabel.setLocation(new Point(75, 30));
			categoriaLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			categoriaLabel.setText("Categoría:");
			categoriaLabel.setSize(new Dimension(61, 16));
			crearAccionPanel = new JPanel();
			crearAccionPanel.setLayout(null);
			crearAccionPanel.setLocation(new Point(13, 13));
			crearAccionPanel.setSize(new Dimension(441, 102));
			crearAccionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Acción", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			crearAccionPanel.add(categoriaLabel, null);
			crearAccionPanel.add(accionLabel, null);
			crearAccionPanel.add(getCategoriaTextField(), null);
			crearAccionPanel.add(getAccionTextField(), null);
		}
		return crearAccionPanel;
	}

	private JTextField getCategoriaTextField() {
		if (categoriaTextField == null) {
			categoriaTextField = new JTextField();
			categoriaTextField.setLocation(new Point(139, 30));
			categoriaTextField.setEnabled(false);
			categoriaTextField.setFont(new Font("Dialog", Font.BOLD, 12));
			categoriaTextField.setSize(new Dimension(273, 18));
			categoriaTextField.setText(categoria);
		}
		return categoriaTextField;
	}

	private JTextField getAccionTextField() {
		if (accionTextField == null) {
			accionTextField = new JTextField();
			accionTextField.setLocation(new Point(139, 60));
			accionTextField.setFont(new Font("Dialog", Font.BOLD, 12));
			accionTextField.setSize(new Dimension(273, 18));
		}
		return accionTextField;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setLocation(new Point(138, 130));
			aceptarButton.setBackground(Color.white);
			aceptarButton.setName("");
			aceptarButton.setText("Aceptar");
			aceptarButton.setSize(new Dimension(79, 20));
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
			cancelarButton.setLocation(new Point(243, 130));
			cancelarButton.setBackground(Color.white);
			cancelarButton.setName("");
			cancelarButton.setSelected(false);
			cancelarButton.setText("Cancelar");
			cancelarButton.setSize(new Dimension(85, 20));
			cancelarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return cancelarButton;
	}

	public String getNombreAccion(){
		return accionTextField.getText();
	}

}
