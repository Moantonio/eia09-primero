package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class formEfecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedorPrincipalPane = null;  //  @jve:decl-index=0:visual-constraint="10,8"
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
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
	private JButton modificarJuicioButton = null;
	private JTextField cualitativaTextField = null;
	private JTextField cuantitativaTextField = null;
	private JButton valorarCualButton = null;
	private JButton valorarCuanButton = null;
	private JComboBox juicioComboBox = null;
	private JComboBox caracterComboBox = null;
	private JTextField valoracionTextField = null;
	private JLabel valoracionLabel = null;
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
		this.setSize(500, 450);
		this.setContentPane(getContenedorPrincipalPane());
		this.setTitle("Valoración de efectos");
		this.setResizable(false);
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
			contenedorPrincipalPane.add(getEnjuiciamientoPanel(), null);
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
			descripcionLabel.setLocation(new Point(29, 69));
			descripcionLabel.setSize(new Dimension(75, 16));
			factorLabel = new JLabel();
			factorLabel.setText("Factor:");
			factorLabel.setLocation(new Point(224, 44));
			factorLabel.setSize(new Dimension(47, 16));
			accionLabel = new JLabel();
			accionLabel.setBounds(new Rectangle(23, 44, 44, 16));
			accionLabel.setText("Acción:");
			efectoLabel = new JLabel();
			efectoLabel.setText("Efecto:");
			efectoLabel.setSize(new Dimension(43, 16));
			efectoLabel.setLocation(new Point(63, 19));
			efectoPanel = new JPanel();
			efectoPanel.setLayout(null);
			efectoPanel.setBounds(new Rectangle(24, 14, 440, 104));
			efectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Efecto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
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
			cualitativaPanel.setLocation(new Point(40, 130));
			cualitativaPanel.setSize(new Dimension(190, 60));
			cualitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración cualitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			cualitativaPanel.add(getCualitativaTextField(), null);
			cualitativaPanel.add(getValorarCualButton(), null);
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
			cuantitativaPanel.setSize(new Dimension(190, 60));
			cuantitativaPanel.setLocation(new Point(255, 130));
			cuantitativaPanel.setBorder(titledBorder1);
			cuantitativaPanel.add(getCuantitativaTextField(), null);
			cuantitativaPanel.add(getValorarCuanButton(), null);
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
			valoracionLabel = new JLabel();
			valoracionLabel.setBounds(new Rectangle(41, 12, 110, 21));
			valoracionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			valoracionLabel.setText("Valoración total");
			valoracionPanel = new JPanel();
			valoracionPanel.setLayout(null);
			valoracionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			valoracionPanel.setSize(new Dimension(200, 75));
			valoracionPanel.setLocation(new Point(36, 317));
			valoracionPanel.add(getValoracionTextField(), null);
			valoracionPanel.add(valoracionLabel, null);
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
			botoneraPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			botoneraPanel.setSize(new Dimension(199, 59));
			botoneraPanel.setLocation(new Point(250, 326));
			botoneraPanel.add(getAceptarButton(), null);
			botoneraPanel.add(getCancelarButton(), null);
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
			caracterPanel.setSize(new Dimension(190, 85));
			caracterPanel.setLocation(new Point(252, 209));
			caracterPanel.add(getCaracterComboBox(), null);
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
			enjuiciamientoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Simple enjuiciamiento", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			enjuiciamientoPanel.setLocation(new Point(40, 209));
			enjuiciamientoPanel.setSize(new Dimension(190, 85));
			enjuiciamientoPanel.add(getModificarJuicioButton(), null);
			enjuiciamientoPanel.add(getJuicioComboBox(), null);
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
			efectoTextField.setLocation(new Point(109, 19));
			efectoTextField.setEditable(true);
			efectoTextField.setEnabled(false);
			efectoTextField.setSize(new Dimension(308, 18));
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
			accionTextField.setLocation(new Point(70, 44));
			accionTextField.setEditable(true);
			accionTextField.setEnabled(false);
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
			factorTextField.setLocation(new Point(267, 44));
			factorTextField.setEditable(true);
			factorTextField.setEnabled(false);
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
			descripcionTextField.setLocation(new Point(109, 69));
			descripcionTextField.setEditable(true);
			descripcionTextField.setEnabled(false);
			descripcionTextField.setSize(new Dimension(308, 18));
		}
		return descripcionTextField;
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
			aceptarButton.setLocation(new Point(11, 20));
			aceptarButton.setSize(new Dimension(79, 17));
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
			cancelarButton.setText("Cancelar");
			cancelarButton.setLocation(new Point(101, 20));
			cancelarButton.setSize(new Dimension(85, 17));
			cancelarButton.setSelected(false);
			cancelarButton.setBackground(Color.white);
		}
		return cancelarButton;
	}

	/**
	 * This method initializes modificarJuicioButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getModificarJuicioButton() {
		if (modificarJuicioButton == null) {
			modificarJuicioButton = new JButton();
			modificarJuicioButton.setName("");
			modificarJuicioButton.setText("Modificar");
			modificarJuicioButton.setLocation(new Point(53, 55));
			modificarJuicioButton.setSize(new Dimension(87, 17));
			modificarJuicioButton.setBackground(Color.white);
		}
		return modificarJuicioButton;
	}

	/**
	 * This method initializes cualitativaTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getCualitativaTextField() {
		if (cualitativaTextField == null) {
			cualitativaTextField = new JTextField();
			cualitativaTextField.setEnabled(false);
			cualitativaTextField.setSize(new Dimension(35, 18));
			cualitativaTextField.setLocation(new Point(40, 25));
		}
		return cualitativaTextField;
	}

	/**
	 * This method initializes cuantitativaTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getCuantitativaTextField() {
		if (cuantitativaTextField == null) {
			cuantitativaTextField = new JTextField();
			cuantitativaTextField.setEnabled(false);
			cuantitativaTextField.setSize(new Dimension(35, 18));
			cuantitativaTextField.setLocation(new Point(40, 25));
		}
		return cuantitativaTextField;
	}

	/**
	 * This method initializes valorarCualButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getValorarCualButton() {
		if (valorarCualButton == null) {
			valorarCualButton = new JButton();
			valorarCualButton.setName("");
			valorarCualButton.setText("Valorar");
			valorarCualButton.setLocation(new Point(82, 25));
			valorarCualButton.setSize(new Dimension(76, 18));
			valorarCualButton.setBackground(Color.white);
		}
		return valorarCualButton;
	}

	/**
	 * This method initializes valorarCuanButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getValorarCuanButton() {
		if (valorarCuanButton == null) {
			valorarCuanButton = new JButton();
			valorarCuanButton.setName("");
			valorarCuanButton.setText("Valorar");
			valorarCuanButton.setLocation(new Point(82, 25));
			valorarCuanButton.setSize(new Dimension(76, 18));
			valorarCuanButton.setBackground(Color.white);
		}
		return valorarCuanButton;
	}

	/**
	 * This method initializes juicioComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJuicioComboBox() {
		if (juicioComboBox == null) {
			juicioComboBox = new JComboBox();
			juicioComboBox.setLocation(new Point(30, 28));
			juicioComboBox.setEnabled(false);
			juicioComboBox.setSize(new Dimension(135, 18));
		}
		return juicioComboBox;
	}

	/**
	 * This method initializes caracterComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCaracterComboBox() {
		if (caracterComboBox == null) {
			caracterComboBox = new JComboBox();
			caracterComboBox.setLocation(new Point(30, 35));
			caracterComboBox.setSize(new Dimension(135, 18));
		}
		return caracterComboBox;
	}

	/**
	 * This method initializes valoracionTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getValoracionTextField() {
		if (valoracionTextField == null) {
			valoracionTextField = new JTextField();
			valoracionTextField.setLocation(new Point(64, 38));
			valoracionTextField.setEnabled(false);
			valoracionTextField.setSize(new Dimension(65, 18));
		}
		return valoracionTextField;
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
