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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

public class formCrearProyecto extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel crearProyectoPanel = null;
	private JLabel nombreLabel = null;
	private JLabel descripcionLabel = null;
	private JTextField nombreTextField = null;
	private JTextArea descripcionTextArea = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
	private JLabel tipoLabel = null;
	private JTextField tipoTextField = null;
	// Variables del modelo
	private boolean flagAceptar = false;
	private String tipoProyecto;

	public formCrearProyecto(String tipo) {
		super();
		tipoProyecto = tipo;
		initialize();
	}

	private JPanel getCrearProyectoPanel() {
		if (crearProyectoPanel == null) {
			tipoLabel = new JLabel();
			tipoLabel.setText("Tipo:");
			tipoLabel.setSize(new Dimension(27, 16));
			tipoLabel.setLocation(new Point(80, 111));
			tipoLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			descripcionLabel = new JLabel();
			descripcionLabel.setText("Descripción:");
			descripcionLabel.setSize(new Dimension(78, 16));
			descripcionLabel.setLocation(new Point(39, 58));
			descripcionLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreLabel = new JLabel();
			nombreLabel.setLocation(new Point(60, 30));
			nombreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreLabel.setText("Nombre:");
			nombreLabel.setSize(new Dimension(51, 16));
			crearProyectoPanel = new JPanel();
			crearProyectoPanel.setLayout(null);
			crearProyectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Información del proyecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			crearProyectoPanel.setSize(new Dimension(441, 143));
			crearProyectoPanel.setLocation(new Point(13, 13));
			crearProyectoPanel.add(nombreLabel, null);
			crearProyectoPanel.add(descripcionLabel, null);
			crearProyectoPanel.add(getNombreTextField(), null);
			crearProyectoPanel.add(getDescripcionTextArea(), null);
			crearProyectoPanel.add(tipoLabel, null);
			crearProyectoPanel.add(getTipoTextField(), null);
		}
		return crearProyectoPanel;
	}

	private JTextField getNombreTextField() {
		if (nombreTextField == null) {
			nombreTextField = new JTextField();
			nombreTextField.setLocation(new Point(135, 31));
			nombreTextField.setFont(new Font("Dialog", Font.PLAIN, 14));
			nombreTextField.setSize(new Dimension(273, 18));
		}
		return nombreTextField;
	}

	private JTextArea getDescripcionTextArea() {
		if (descripcionTextArea == null) {
			descripcionTextArea = new JTextArea();
			descripcionTextArea.setBounds(new Rectangle(135, 56, 272, 47));
			descripcionTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			descripcionTextArea.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return descripcionTextArea;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setName("");
			aceptarButton.setText("Aceptar");
			aceptarButton.setSize(new Dimension(79, 20));
			aceptarButton.setLocation(new Point(138, 167));
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
			cancelarButton.setSize(new Dimension(85, 20));
			cancelarButton.setLocation(new Point(243, 167));
			cancelarButton.setBackground(Color.white);
			cancelarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return cancelarButton;
	}

	public formCrearProyecto(Frame owner, String tipo) {
		super(owner);
		tipoProyecto = tipo;
		initialize();
	}

	private void initialize() {
		this.setSize(475, 234);
		this.setContentPane(getJContentPane());
		this.setTitle("Nuevo proyecto");
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getCrearProyectoPanel(), null);
			jContentPane.add(getAceptarButton(), null);
			jContentPane.add(getCancelarButton(), null);
		}
		return jContentPane;
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

	private JTextField getTipoTextField() {
		if (tipoTextField == null) {
			tipoTextField = new JTextField();
			tipoTextField.setFont(new Font("Dialog", Font.PLAIN, 14));
			tipoTextField.setSize(new Dimension(134, 18));
			tipoTextField.setEnabled(false);
			tipoTextField.setLocation(new Point(136, 111));
			tipoTextField.setText(tipoProyecto);
		}
		return tipoTextField;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
