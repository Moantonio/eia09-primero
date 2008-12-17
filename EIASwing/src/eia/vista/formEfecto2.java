package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.KeyEvent;

public class formEfecto2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane efectoTabbedPane = null;
	private JPanel contenedorPrincipalPane = null;
	private JPanel efectoPanel = null;
	private JTextField efectoTextField = null;
	private JTextField accionTextField = null;
	private JTextField factorTextField = null;
	private JTextField descripcionTextField = null;
	private JLabel efectoLabel = null;
	private JLabel accionLabel = null;
	private JLabel factorLabel = null;
	private JLabel descripcionLabel = null;
	private JPanel cualitativaPanel = null;
	private JTextField cualitativaTextField = null;
	private JPanel valoracionPanel = null;
	private JTextField valoracionTextField = null;
	private JLabel valoracionLabel = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
	private JComboBox caracterComboBox = null;
	private JButton modificarJuicioButton = null;
	private JComboBox juicioComboBox = null;
	private JPanel jContentPane1 = null;
	private JPanel cualitativaPanel1 = null;
	private JButton aceptarButton1 = null;
	private JButton cancelarButton1 = null;
	private JComboBox signoComboBox = null;
	private JComboBox acumulacionComboBox = null;
	private JComboBox extensionComboBox = null;
	private JComboBox intensidadComboBox = null;
	private JComboBox persistenciaComboBox = null;
	private JComboBox reversibilidadComboBox = null;
	private JComboBox efectoComboBox = null;
	private JComboBox periodicidadComboBox = null;
	private JComboBox recuperabilidadComboBox = null;
	private JComboBox momentoComboBox = null;
	private JLabel signoLabel = null;
	private JLabel extensionLabel = null;
	private JLabel intensidadLabel = null;
	private JLabel reversibilidadLabel = null;
	private JLabel periodicidadLabel = null;
	private JLabel momentoLabel = null;
	private JLabel acumulacionLabel = null;
	private JLabel persistenciaLabel = null;
	private JLabel efectoCuaLabel = null;
	private JLabel recuperabilidadLabel = null;
	private JPanel incidenciaPanel = null;
	private JTextField incidenciaTextField = null;
	private JLabel incidenciaLabel = null;
	private JCheckBox extensionCriticaCheckBox = null;
	private JCheckBox momentoCriticoCheckBox = null;
	private JLabel extensionCriticaLabel = null;
	private JLabel momentoCriticoLabel = null;
	private JButton calcularButton = null;
	private JPanel jContentPane2 = null;
	private JPanel valCuantitativaPanel = null;
	private JLabel fTransformacionLabel = null;
	private JComboBox fTransformacionComboBox = null;
	private JButton asistenteButton = null;
	private JPanel magnitudPanel = null;
	private JLabel magnitudLabel = null;
	private JTextField magnitudTextField = null;
	private JButton graficoButton = null;
	private JPanel datosPanel = null;
	private JTextField valormaxTextField = null;
	private JLabel valorMaxLabel = null;
	private JLabel indicadorLabel = null;
	private JLabel valorMinLabel = null;
	private JButton calcularButton1 = null;
	private JTextField indicadorTextField = null;
	private JTextField valorMinTextField = null;
	private JButton aceptarButton2 = null;
	private JButton cancelarButton2 = null;
	private JLabel valoracionCualitativaLabel = null;
	private JLabel valoracionCuantitativaLabel = null;
	private JLabel caracterCuantitativaLabel = null;
	private JLabel juicioCuantitativaLabel = null;
	private JTextField cuantitativaTextField = null;
	private JPanel caracterPanel = null;
	/**
	 * This is the default constructor
	 */
	public formEfecto2() {
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
		this.setContentPane(getJContentPane());
		this.setTitle("Efecto");
		this.setResizable(false);
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
			jContentPane.add(getEfectoTabbedPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes efectoTabbedPane
	 *
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getEfectoTabbedPane() {
		if (efectoTabbedPane == null) {
			efectoTabbedPane = new JTabbedPane();
			efectoTabbedPane.setLocation(new Point(0, 0));
			efectoTabbedPane.setSize(new Dimension(493, 467));
			efectoTabbedPane.addTab("Ficha general", null, getContenedorPrincipalPane(), null);
			efectoTabbedPane.addTab("Valoración cualitativa", null, getJContentPane1(), null);
			efectoTabbedPane.addTab("Valoración cuantitativa", null, getJContentPane2(), null);
		}
		return efectoTabbedPane;
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
			descripcionLabel.setLocation(new Point(29, 69));
			descripcionLabel.setText("Descripción:");
			descripcionLabel.setSize(new Dimension(75, 16));
			factorLabel = new JLabel();
			factorLabel.setLocation(new Point(224, 44));
			factorLabel.setText("Factor:");
			factorLabel.setSize(new Dimension(47, 16));
			accionLabel = new JLabel();
			accionLabel.setBounds(new Rectangle(23, 44, 44, 16));
			accionLabel.setText("Acción:");
			efectoLabel = new JLabel();
			efectoLabel.setLocation(new Point(63, 19));
			efectoLabel.setText("Efecto:");
			efectoLabel.setSize(new Dimension(43, 16));
			efectoPanel = new JPanel();
			efectoPanel.setLayout(null);
			efectoPanel.setBounds(new Rectangle(24, 14, 440, 104));
			efectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Información", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
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
	 * This method initializes accionTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getAccionTextField() {
		if (accionTextField == null) {
			accionTextField = new JTextField();
			accionTextField.setLocation(new Point(70, 44));
			accionTextField.setEnabled(false);
			accionTextField.setEditable(true);
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
			factorTextField.setEnabled(false);
			factorTextField.setEditable(true);
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
			juicioCuantitativaLabel = new JLabel();
			juicioCuantitativaLabel.setText("Simple enjuiciamiento:");
			juicioCuantitativaLabel.setLocation(new Point(38, 30));
			juicioCuantitativaLabel.setSize(new Dimension(132, 16));
			caracterCuantitativaLabel = new JLabel();
			caracterCuantitativaLabel.setText("Caracter");
			caracterCuantitativaLabel.setSize(new Dimension(60, 16));
			caracterCuantitativaLabel.setLocation(new Point(70, 12));
			caracterCuantitativaLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			valoracionCuantitativaLabel = new JLabel();
			valoracionCuantitativaLabel.setText("Valoración cuantitativa:");
			valoracionCuantitativaLabel.setLocation(new Point(223, 60));
			valoracionCuantitativaLabel.setSize(new Dimension(139, 16));
			valoracionCualitativaLabel = new JLabel();
			valoracionCualitativaLabel.setText("Valoración cualitativa:");
			valoracionCualitativaLabel.setLocation(new Point(25, 60));
			valoracionCualitativaLabel.setSize(new Dimension(128, 16));
			cualitativaPanel = new JPanel();
			cualitativaPanel.setLayout(null);
			cualitativaPanel.setLocation(new Point(24, 130));
			cualitativaPanel.setSize(new Dimension(440, 234));
			cualitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			cualitativaPanel.add(getCualitativaTextField(), null);
			cualitativaPanel.add(getValoracionPanel(), null);
			cualitativaPanel.add(getJuicioComboBox(), null);
			cualitativaPanel.add(getModificarJuicioButton(), null);
			cualitativaPanel.add(valoracionCualitativaLabel, null);
			cualitativaPanel.add(valoracionCuantitativaLabel, null);
			cualitativaPanel.add(juicioCuantitativaLabel, null);
			cualitativaPanel.add(getCuantitativaTextField(), null);
			cualitativaPanel.add(getCaracterPanel(), null);
			cualitativaPanel.add(getAceptarButton(), null);
			cualitativaPanel.add(getCancelarButton(), null);
		}
		return cualitativaPanel;
	}

	/**
	 * This method initializes cualitativaTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getCualitativaTextField() {
		if (cualitativaTextField == null) {
			cualitativaTextField = new JTextField();
			cualitativaTextField.setLocation(new Point(160, 60));
			cualitativaTextField.setEnabled(false);
			cualitativaTextField.setText("");
			cualitativaTextField.setSize(new Dimension(45, 18));
		}
		return cualitativaTextField;
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
			valoracionLabel.setText("Valoración total");
			valoracionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			valoracionPanel = new JPanel();
			valoracionPanel.setLayout(null);
			valoracionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			valoracionPanel.setSize(new Dimension(200, 75));
			valoracionPanel.setLocation(new Point(13, 100));
			valoracionPanel.add(getValoracionTextField(), null);
			valoracionPanel.add(valoracionLabel, null);
		}
		return valoracionPanel;
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

	/**
	 * This method initializes aceptarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setBackground(Color.white);
			aceptarButton.setName("");
			aceptarButton.setSize(new Dimension(79, 17));
			aceptarButton.setLocation(new Point(132, 195));
			aceptarButton.setText("Aceptar");
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
			cancelarButton.setBackground(Color.white);
			cancelarButton.setName("");
			cancelarButton.setSelected(false);
			cancelarButton.setBounds(new Rectangle(226, 195, 85, 17));
			cancelarButton.setText("Cancelar");
		}
		return cancelarButton;
	}

	/**
	 * This method initializes caracterComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCaracterComboBox() {
		if (caracterComboBox == null) {
			caracterComboBox = new JComboBox();
			caracterComboBox.setSize(new Dimension(135, 18));
			caracterComboBox.setPreferredSize(new Dimension(31, 38));
			caracterComboBox.setLocation(new Point(35, 38));
		}
		return caracterComboBox;
	}

	/**
	 * This method initializes modificarJuicioButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getModificarJuicioButton() {
		if (modificarJuicioButton == null) {
			modificarJuicioButton = new JButton();
			modificarJuicioButton.setBackground(Color.white);
			modificarJuicioButton.setName("");
			modificarJuicioButton.setSize(new Dimension(87, 17));
			modificarJuicioButton.setLocation(new Point(324, 30));
			modificarJuicioButton.setText("Modificar");
		}
		return modificarJuicioButton;
	}

	/**
	 * This method initializes juicioComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJuicioComboBox() {
		if (juicioComboBox == null) {
			juicioComboBox = new JComboBox();
			juicioComboBox.setEnabled(false);
			juicioComboBox.setLocation(new Point(178, 30));
			juicioComboBox.setSize(new Dimension(135, 18));
		}
		return juicioComboBox;
	}

	/**
	 * This method initializes jContentPane1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(getCualitativaPanel1(), null);
		}
		return jContentPane1;
	}

	/**
	 * This method initializes cualitativaPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCualitativaPanel1() {
		if (cualitativaPanel1 == null) {
			momentoCriticoLabel = new JLabel();
			momentoCriticoLabel.setBounds(new Rectangle(267, 183, 77, 16));
			momentoCriticoLabel.setText("Crítico");
			extensionCriticaLabel = new JLabel();
			extensionCriticaLabel.setLocation(new Point(267, 62));
			extensionCriticaLabel.setText("Crítica");
			extensionCriticaLabel.setSize(new Dimension(77, 16));
			recuperabilidadLabel = new JLabel();
			recuperabilidadLabel.setLocation(new Point(225, 150));
			recuperabilidadLabel.setText("Recuperabilidad:");
			recuperabilidadLabel.setSize(new Dimension(103, 16));
			efectoCuaLabel = new JLabel();
			efectoCuaLabel.setLocation(new Point(280, 120));
			efectoCuaLabel.setText("Efecto:");
			efectoCuaLabel.setSize(new Dimension(39, 16));
			persistenciaLabel = new JLabel();
			persistenciaLabel.setLocation(new Point(243, 90));
			persistenciaLabel.setText("Persistencia:");
			persistenciaLabel.setSize(new Dimension(77, 16));
			acumulacionLabel = new JLabel();
			acumulacionLabel.setLocation(new Point(242, 30));
			acumulacionLabel.setText("Acumulación:");
			acumulacionLabel.setSize(new Dimension(84, 16));
			momentoLabel = new JLabel();
			momentoLabel.setLocation(new Point(37, 180));
			momentoLabel.setText("Momento:");
			momentoLabel.setSize(new Dimension(65, 16));
			periodicidadLabel = new JLabel();
			periodicidadLabel.setLocation(new Point(19, 150));
			periodicidadLabel.setText("Periodicidad:");
			periodicidadLabel.setSize(new Dimension(77, 16));
			reversibilidadLabel = new JLabel();
			reversibilidadLabel.setLocation(new Point(10, 120));
			reversibilidadLabel.setText("Reversibilidad:");
			reversibilidadLabel.setSize(new Dimension(88, 16));
			intensidadLabel = new JLabel();
			intensidadLabel.setLocation(new Point(32, 90));
			intensidadLabel.setText("Intensidad:");
			intensidadLabel.setSize(new Dimension(68, 16));
			extensionLabel = new JLabel();
			extensionLabel.setLocation(new Point(34, 60));
			extensionLabel.setText("Extensión:");
			extensionLabel.setSize(new Dimension(61, 16));
			signoLabel = new JLabel();
			signoLabel.setLocation(new Point(58, 30));
			signoLabel.setText("Signo:");
			signoLabel.setSize(new Dimension(40, 16));
			cualitativaPanel1 = new JPanel();
			cualitativaPanel1.setLayout(null);
			cualitativaPanel1.setLocation(new Point(17, 14));
			cualitativaPanel1.setSize(new Dimension(454, 350));
			cualitativaPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración Cualitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			cualitativaPanel1.add(getSignoComboBox(), null);
			cualitativaPanel1.add(getAcumulacionComboBox(), null);
			cualitativaPanel1.add(getExtensionComboBox(), null);
			cualitativaPanel1.add(getIntensidadComboBox(), null);
			cualitativaPanel1.add(getPersistenciaComboBox(), null);
			cualitativaPanel1.add(getReversibilidadComboBox(), null);
			cualitativaPanel1.add(getEfectoComboBox(), null);
			cualitativaPanel1.add(getPeriodicidadComboBox(), null);
			cualitativaPanel1.add(getRecuperabilidadComboBox(), null);
			cualitativaPanel1.add(getMomentoComboBox(), null);
			cualitativaPanel1.add(signoLabel, null);
			cualitativaPanel1.add(extensionLabel, null);
			cualitativaPanel1.add(intensidadLabel, null);
			cualitativaPanel1.add(reversibilidadLabel, null);
			cualitativaPanel1.add(periodicidadLabel, null);
			cualitativaPanel1.add(momentoLabel, null);
			cualitativaPanel1.add(acumulacionLabel, null);
			cualitativaPanel1.add(persistenciaLabel, null);
			cualitativaPanel1.add(efectoCuaLabel, null);
			cualitativaPanel1.add(recuperabilidadLabel, null);
			cualitativaPanel1.add(getIncidenciaPanel(), null);
			cualitativaPanel1.add(getExtensionCriticaCheckBox(), null);
			cualitativaPanel1.add(getMomentoCriticoCheckBox(), null);
			cualitativaPanel1.add(extensionCriticaLabel, null);
			cualitativaPanel1.add(momentoCriticoLabel, null);
			cualitativaPanel1.add(getCalcularButton(), null);
			cualitativaPanel1.add(getAceptarButton1(), null);
			cualitativaPanel1.add(getCancelarButton1(), null);
		}
		return cualitativaPanel1;
	}

	/**
	 * This method initializes aceptarButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarButton1() {
		if (aceptarButton1 == null) {
			aceptarButton1 = new JButton();
			aceptarButton1.setBackground(Color.white);
			aceptarButton1.setName("");
			aceptarButton1.setSize(new Dimension(79, 17));
			aceptarButton1.setLocation(new Point(139, 311));
			aceptarButton1.setText("Aceptar");
		}
		return aceptarButton1;
	}

	/**
	 * This method initializes cancelarButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCancelarButton1() {
		if (cancelarButton1 == null) {
			cancelarButton1 = new JButton();
			cancelarButton1.setBackground(Color.white);
			cancelarButton1.setName("");
			cancelarButton1.setSelected(false);
			cancelarButton1.setSize(new Dimension(85, 17));
			cancelarButton1.setLocation(new Point(233, 311));
			cancelarButton1.setMnemonic(KeyEvent.VK_UNDEFINED);
			cancelarButton1.setText("Cancelar");
		}
		return cancelarButton1;
	}

	/**
	 * This method initializes signoComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getSignoComboBox() {
		if (signoComboBox == null) {
			signoComboBox = new JComboBox();
			signoComboBox.setLocation(new Point(97, 30));
			signoComboBox.setSize(new Dimension(120, 18));
		}
		return signoComboBox;
	}

	/**
	 * This method initializes acumulacionComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getAcumulacionComboBox() {
		if (acumulacionComboBox == null) {
			acumulacionComboBox = new JComboBox();
			acumulacionComboBox.setLocation(new Point(324, 30));
			acumulacionComboBox.setSize(new Dimension(120, 18));
		}
		return acumulacionComboBox;
	}

	/**
	 * This method initializes extensionComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getExtensionComboBox() {
		if (extensionComboBox == null) {
			extensionComboBox = new JComboBox();
			extensionComboBox.setLocation(new Point(97, 60));
			extensionComboBox.setSize(new Dimension(120, 18));
		}
		return extensionComboBox;
	}

	/**
	 * This method initializes intensidadComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getIntensidadComboBox() {
		if (intensidadComboBox == null) {
			intensidadComboBox = new JComboBox();
			intensidadComboBox.setLocation(new Point(97, 90));
			intensidadComboBox.setSize(new Dimension(120, 18));
		}
		return intensidadComboBox;
	}

	/**
	 * This method initializes persistenciaComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getPersistenciaComboBox() {
		if (persistenciaComboBox == null) {
			persistenciaComboBox = new JComboBox();
			persistenciaComboBox.setLocation(new Point(324, 90));
			persistenciaComboBox.setSize(new Dimension(120, 18));
		}
		return persistenciaComboBox;
	}

	/**
	 * This method initializes reversibilidadComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getReversibilidadComboBox() {
		if (reversibilidadComboBox == null) {
			reversibilidadComboBox = new JComboBox();
			reversibilidadComboBox.setLocation(new Point(97, 120));
			reversibilidadComboBox.setSize(new Dimension(120, 18));
		}
		return reversibilidadComboBox;
	}

	/**
	 * This method initializes efectoComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getEfectoComboBox() {
		if (efectoComboBox == null) {
			efectoComboBox = new JComboBox();
			efectoComboBox.setLocation(new Point(324, 150));
			efectoComboBox.setSize(new Dimension(120, 18));
		}
		return efectoComboBox;
	}

	/**
	 * This method initializes periodicidadComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getPeriodicidadComboBox() {
		if (periodicidadComboBox == null) {
			periodicidadComboBox = new JComboBox();
			periodicidadComboBox.setLocation(new Point(97, 150));
			periodicidadComboBox.setSize(new Dimension(120, 18));
		}
		return periodicidadComboBox;
	}

	/**
	 * This method initializes recuperabilidadComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getRecuperabilidadComboBox() {
		if (recuperabilidadComboBox == null) {
			recuperabilidadComboBox = new JComboBox();
			recuperabilidadComboBox.setLocation(new Point(324, 120));
			recuperabilidadComboBox.setSize(new Dimension(120, 18));
		}
		return recuperabilidadComboBox;
	}

	/**
	 * This method initializes momentoComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getMomentoComboBox() {
		if (momentoComboBox == null) {
			momentoComboBox = new JComboBox();
			momentoComboBox.setLocation(new Point(97, 180));
			momentoComboBox.setSize(new Dimension(120, 18));
		}
		return momentoComboBox;
	}

	/**
	 * This method initializes incidenciaPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getIncidenciaPanel() {
		if (incidenciaPanel == null) {
			incidenciaLabel = new JLabel();
			incidenciaLabel.setText("Incidencia");
			incidenciaLabel.setSize(new Dimension(77, 21));
			incidenciaLabel.setLocation(new Point(61, 9));
			incidenciaLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			incidenciaPanel = new JPanel();
			incidenciaPanel.setLayout(null);
			incidenciaPanel.setLocation(new Point(126, 218));
			incidenciaPanel.setSize(new Dimension(200, 75));
			incidenciaPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			incidenciaPanel.add(getIncidenciaTextField(), null);
			incidenciaPanel.add(incidenciaLabel, null);
		}
		return incidenciaPanel;
	}

	/**
	 * This method initializes incidenciaTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getIncidenciaTextField() {
		if (incidenciaTextField == null) {
			incidenciaTextField = new JTextField();
			incidenciaTextField.setLocation(new Point(66, 40));
			incidenciaTextField.setEnabled(false);
			incidenciaTextField.setSize(new Dimension(65, 18));
		}
		return incidenciaTextField;
	}

	/**
	 * This method initializes extensionCriticaCheckBox
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getExtensionCriticaCheckBox() {
		if (extensionCriticaCheckBox == null) {
			extensionCriticaCheckBox = new JCheckBox();
			extensionCriticaCheckBox.setLocation(new Point(240, 60));
			extensionCriticaCheckBox.setSize(new Dimension(21, 21));
		}
		return extensionCriticaCheckBox;
	}

	/**
	 * This method initializes momentoCriticoCheckBox
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getMomentoCriticoCheckBox() {
		if (momentoCriticoCheckBox == null) {
			momentoCriticoCheckBox = new JCheckBox();
			momentoCriticoCheckBox.setLocation(new Point(240, 180));
			momentoCriticoCheckBox.setSize(new Dimension(21, 21));
		}
		return momentoCriticoCheckBox;
	}

	/**
	 * This method initializes calcularButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCalcularButton() {
		if (calcularButton == null) {
			calcularButton = new JButton();
			calcularButton.setLocation(new Point(340, 183));
			calcularButton.setBackground(Color.white);
			calcularButton.setName("");
			calcularButton.setText("Calcular");
			calcularButton.setSize(new Dimension(81, 16));
		}
		return calcularButton;
	}

	/**
	 * This method initializes jContentPane2
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane2() {
		if (jContentPane2 == null) {
			jContentPane2 = new JPanel();
			jContentPane2.setLayout(null);
			//jContentPane2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			jContentPane2.add(getValCuantitativaPanel(), null);
			jContentPane2.add(getAceptarButton2(), null);
			jContentPane2.add(getCancelarButton2(), null);
		}
		return jContentPane2;
	}

	/**
	 * This method initializes valCuantitativaPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getValCuantitativaPanel() {
		if (valCuantitativaPanel == null) {
			fTransformacionLabel = new JLabel();
			fTransformacionLabel.setBounds(new Rectangle(16, 176, 201, 16));
			fTransformacionLabel.setText("Función de transformación:");
			valCuantitativaPanel = new JPanel();
			valCuantitativaPanel.setLayout(null);
			valCuantitativaPanel.setLocation(new Point(13, 15));
			valCuantitativaPanel.setSize(new Dimension(460, 315));
			valCuantitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Valoración Cuantitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			valCuantitativaPanel.add(fTransformacionLabel, null);
			valCuantitativaPanel.add(getFTransformacionComboBox(), null);
			valCuantitativaPanel.add(getAsistenteButton(), null);
			valCuantitativaPanel.add(getMagnitudPanel(), null);
			valCuantitativaPanel.add(getGraficoButton(), null);
			valCuantitativaPanel.add(getDatosPanel(), null);
		}
		return valCuantitativaPanel;
	}

	/**
	 * This method initializes fTransformacionComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getFTransformacionComboBox() {
		if (fTransformacionComboBox == null) {
			fTransformacionComboBox = new JComboBox();
			fTransformacionComboBox.setBounds(new Rectangle(18, 204, 196, 17));
		}
		return fTransformacionComboBox;
	}

	/**
	 * This method initializes asistenteButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAsistenteButton() {
		if (asistenteButton == null) {
			asistenteButton = new JButton();
			asistenteButton.setBounds(new Rectangle(253, 186, 151, 25));
			asistenteButton.setText("Asistente");
		}
		return asistenteButton;
	}

	/**
	 * This method initializes magnitudPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getMagnitudPanel() {
		if (magnitudPanel == null) {
			magnitudLabel = new JLabel();
			magnitudLabel.setBounds(new Rectangle(46, 16, 76, 19));
			magnitudLabel.setText("Magnitud");
			magnitudPanel = new JPanel();
			magnitudPanel.setLayout(null);
			magnitudPanel.setBounds(new Rectangle(15, 239, 276, 53));
			magnitudPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			magnitudPanel.add(magnitudLabel, null);
			magnitudPanel.add(getMagnitudTextField(), null);
		}
		return magnitudPanel;
	}

	/**
	 * This method initializes magnitudTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getMagnitudTextField() {
		if (magnitudTextField == null) {
			magnitudTextField = new JTextField();
			magnitudTextField.setBounds(new Rectangle(134, 16, 117, 20));
		}
		return magnitudTextField;
	}

	/**
	 * This method initializes graficoButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getGraficoButton() {
		if (graficoButton == null) {
			graficoButton = new JButton();
			graficoButton.setBounds(new Rectangle(313, 241, 93, 49));
			graficoButton.setText("Gráfico");
		}
		return graficoButton;
	}

	/**
	 * This method initializes datosPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getDatosPanel() {
		if (datosPanel == null) {
			valorMinLabel = new JLabel();
			valorMinLabel.setBounds(new Rectangle(7, 55, 168, 16));
			valorMinLabel.setText("Valor máximo indicador:");
			indicadorLabel = new JLabel();
			indicadorLabel.setBounds(new Rectangle(105, 10, 74, 18));
			indicadorLabel.setText("Indicador:");
			valorMaxLabel = new JLabel();
			valorMaxLabel.setBounds(new Rectangle(8, 33, 169, 16));
			valorMaxLabel.setText("Valor máximo indicador:");
			datosPanel = new JPanel();
			datosPanel.setLayout(null);
			datosPanel.setBounds(new Rectangle(16, 30, 422, 123));
			datosPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			datosPanel.add(getValormaxTextField(), null);
			datosPanel.add(valorMaxLabel, null);
			datosPanel.add(indicadorLabel, null);
			datosPanel.add(valorMinLabel, null);
			datosPanel.add(getCalcularButton1(), null);
			datosPanel.add(getIndicadorTextField(), null);
			datosPanel.add(getValorMinTextField(), null);
		}
		return datosPanel;
	}

	/**
	 * This method initializes valormaxTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getValormaxTextField() {
		if (valormaxTextField == null) {
			valormaxTextField = new JTextField();
			valormaxTextField.setLocation(new Point(190, 33));
			valormaxTextField.setSize(new Dimension(120, 18));
		}
		return valormaxTextField;
	}

	/**
	 * This method initializes calcularButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCalcularButton1() {
		if (calcularButton1 == null) {
			calcularButton1 = new JButton();
			calcularButton1.setBounds(new Rectangle(11, 85, 393, 28));
			calcularButton1.setText("Calcular");
		}
		return calcularButton1;
	}

	/**
	 * This method initializes indicadorTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getIndicadorTextField() {
		if (indicadorTextField == null) {
			indicadorTextField = new JTextField();
			indicadorTextField.setLocation(new Point(190, 10));
			indicadorTextField.setSize(new Dimension(120, 18));
		}
		return indicadorTextField;
	}

	/**
	 * This method initializes valorMinTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getValorMinTextField() {
		if (valorMinTextField == null) {
			valorMinTextField = new JTextField();
			valorMinTextField.setLocation(new Point(190, 55));
			valorMinTextField.setSize(new Dimension(141, 17));
		}
		return valorMinTextField;
	}

	/**
	 * This method initializes aceptarButton2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarButton2() {
		if (aceptarButton2 == null) {
			aceptarButton2 = new JButton();
			aceptarButton2.setLocation(new Point(134, 350));
			aceptarButton2.setText("Aceptar");
			aceptarButton2.setSize(new Dimension(100, 32));
		}
		return aceptarButton2;
	}

	/**
	 * This method initializes cancelarButton2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCancelarButton2() {
		if (cancelarButton2 == null) {
			cancelarButton2 = new JButton();
			cancelarButton2.setLocation(new Point(244, 353));
			cancelarButton2.setText("Cancelar");
			cancelarButton2.setSize(new Dimension(100, 32));
		}
		return cancelarButton2;
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
			cuantitativaTextField.setSize(new Dimension(45, 18));
			cuantitativaTextField.setLocation(new Point(369, 60));
		}
		return cuantitativaTextField;
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
			caracterPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			caracterPanel.setLocation(new Point(225, 100));
			caracterPanel.setSize(new Dimension(200, 75));
			caracterPanel.add(getCaracterComboBox(), null);
			caracterPanel.add(caracterCuantitativaLabel, null);
		}
		return caracterPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="14,15"
