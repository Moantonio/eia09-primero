package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

public class FormCrearAlternativa extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel crearAlternativaPanel = null;
	private JLabel nombreProyLabel = null;
	private JLabel nombreAltLabel = null;
	private JTextField nombreProyTextField = null;
	private JTextField nombreAltTextField = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;

	//Variables del modelo
	private String nombreProyecto;
	private boolean flagAceptar = false;

	public FormCrearAlternativa(Frame owner, String nameProyecto) {
		super(owner);
		nombreProyecto = nameProyecto;
		initialize();
	}

	public FormCrearAlternativa(String nameProyecto) {
		super();
		nombreProyecto = nameProyecto;
		initialize();
	}

	private void initialize() {
		this.setSize(475, 197);
		this.setContentPane(getJContentPane());
		this.setTitle("Nueva alternativa de realización");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//edit-copy.png"));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getCrearAlternativaPanel(), null);
			jContentPane.add(getAceptarButton(), null);
			jContentPane.add(getCancelarButton(), null);
		}
		return jContentPane;
	}

	private JPanel getCrearAlternativaPanel() {
		if (crearAlternativaPanel == null) {
			nombreAltLabel = new JLabel();
			nombreAltLabel.setLocation(new Point(22, 60));
			nombreAltLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreAltLabel.setText("Nombre alternativa:");
			nombreAltLabel.setSize(new Dimension(114, 16));
			nombreProyLabel = new JLabel();
			nombreProyLabel.setLocation(new Point(79, 30));
			nombreProyLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreProyLabel.setText("Proyecto:");
			nombreProyLabel.setSize(new Dimension(61, 16));
			crearAlternativaPanel = new JPanel();
			crearAlternativaPanel.setLayout(null);
			crearAlternativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Información del proyecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			crearAlternativaPanel.setLocation(new Point(13, 13));
			crearAlternativaPanel.setSize(new Dimension(441, 102));
			crearAlternativaPanel.add(nombreProyLabel, null);
			crearAlternativaPanel.add(nombreAltLabel, null);
			crearAlternativaPanel.add(getNombreProyTextField(), null);
			crearAlternativaPanel.add(getNombreAltTextField(), null);
		}
		return crearAlternativaPanel;
	}

	private JTextField getNombreProyTextField() {
		if (nombreProyTextField == null) {
			nombreProyTextField = new JTextField();
			nombreProyTextField.setLocation(new Point(139, 30));
			nombreProyTextField.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreProyTextField.setEditable(true);
			nombreProyTextField.setEnabled(false);
			nombreProyTextField.setSize(new Dimension(273, 18));
			nombreProyTextField.setText(nombreProyecto);
		}
		return nombreProyTextField;
	}

	private JTextField getNombreAltTextField() {
		if (nombreAltTextField == null) {
			nombreAltTextField = new JTextField();
			nombreAltTextField.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreAltTextField.setSize(new Dimension(273, 18));
			nombreAltTextField.setLocation(new Point(139, 60));
		}
		return nombreAltTextField;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setName("");
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(138, 130));
			aceptarButton.setSize(new Dimension(79, 20));
			aceptarButton.setBackground(Color.white);
			aceptarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comprobarCondiciones()){
						flagAceptar = true;
						setVisible(false);
					}
				}
			});
		}
		return aceptarButton;
	}

	private boolean comprobarCondiciones() {
		boolean error = false;
		if (nombreAltTextField.getText().equals("")){
			error = true;
			JOptionPane.showMessageDialog(this, "¡Sin nombre de alternativa de realización! \n Introduzca un nombre para identificar la alternativa.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return !error;
	}

	private JButton getCancelarButton() {
		if (cancelarButton == null) {
			cancelarButton = new JButton();
			cancelarButton.setName("");
			cancelarButton.setSelected(false);
			cancelarButton.setText("Cancelar");
			cancelarButton.setLocation(new Point(243, 130));
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

	public String getNombreAlternativa(){
		return nombreAltTextField.getText();
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
