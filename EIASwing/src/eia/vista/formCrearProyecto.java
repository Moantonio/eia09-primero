/**
 *
 */
package eia.vista;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

/**
 * @author Luis
 *
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

	public formCrearProyecto() {
		super();
		initialize();
	}
	/**
	 * This method initializes crearProyectoPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCrearProyectoPanel() {
		if (crearProyectoPanel == null) {
			descripcionLabel = new JLabel();
			descripcionLabel.setBounds(new Rectangle(31, 58, 78, 16));
			descripcionLabel.setText("Descripción:");
			descripcionLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreLabel = new JLabel();
			nombreLabel.setLocation(new Point(60, 30));
			nombreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			nombreLabel.setText("Nombre:");
			nombreLabel.setSize(new Dimension(51, 16));
			crearProyectoPanel = new JPanel();
			crearProyectoPanel.setLayout(null);
			crearProyectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Información del proyecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			crearProyectoPanel.setSize(new Dimension(441, 120));
			crearProyectoPanel.setLocation(new Point(13, 13));
			crearProyectoPanel.add(nombreLabel, null);
			crearProyectoPanel.add(descripcionLabel, null);
			crearProyectoPanel.add(getNombreTextField(), null);
			crearProyectoPanel.add(getDescripcionTextArea(), null);
		}
		return crearProyectoPanel;
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
			descripcionTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			descripcionTextArea.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return descripcionTextArea;
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
			aceptarButton.setSize(new Dimension(79, 20));
			aceptarButton.setLocation(new Point(139, 145));
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
			cancelarButton.setSize(new Dimension(85, 20));
			cancelarButton.setLocation(new Point(244, 145));
			cancelarButton.setBackground(Color.white);
			cancelarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return cancelarButton;
	}

	/**
	 * @param owner
	 */
	public formCrearProyecto(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(475, 210);
		this.setContentPane(getJContentPane());
		this.setTitle("Nuevo proyecto");
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
			jContentPane.add(getCrearProyectoPanel(), null);
			jContentPane.add(getAceptarButton(), null);
			jContentPane.add(getCancelarButton(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
