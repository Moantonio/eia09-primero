package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class formEfecto extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane efectoTabbedPane = null;
	private JPanel fichaPanel = null;
	private JPanel infoEfectoPanel = null;
	private JTextField efectoTextField = null;
	private JTextField accionTextField = null;
	private JTextField factorTextField = null;
	private JTextField descripcionTextField = null;
	private JLabel efectoLabel = null;
	private JLabel accionLabel = null;
	private JLabel factorLabel = null;
	private JLabel descripcionLabel = null;
	private JPanel valEfectoPanel = null;
	private JTextField cualitativaTextField = null;
	private JPanel valoracionPanel = null;
	private JTextField valoracionTextField = null;
	private JLabel valoracionLabel = null;
	private JButton aceptarFichaButton = null;
	private JButton cancelarFichaButton = null;
	private JComboBox caracterComboBox = null;
	private JButton modificarJuicioButton = null;
	private JComboBox juicioComboBox = null;
	private JPanel valCualitativaPanel = null;
	private JPanel cualitativaPanel = null;
	private JButton aceptarCualitativaButton = null;
	private JButton cancelarCualitativaButton = null;
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
	private JButton calcularCualitativaButton = null;
	private JPanel valCuantitativaPane = null;
	private JPanel cuantitativaPanel = null;
	private JLabel fTransformacionLabel = null;
	private JComboBox fTransformacionComboBox = null;
	private JButton asistenteButton = null;
	private JPanel magnitudPanel = null;
	private JLabel magnitudLabel = null;
	private JTextField magnitudTextField = null;
	private JButton graficoButton = null;
	private JPanel indicadoresPanel = null;
	private JTextField valormaxTextField = null;
	private JLabel valorMaxLabel = null;
	private JLabel indicadorLabel = null;
	private JLabel valorMinLabel = null;
	private JButton calcularCuantitativaButton = null;
	private JTextField indicadorTextField = null;
	private JTextField valorMinTextField = null;
	private JLabel valoracionCualitativaLabel = null;
	private JLabel valoracionCuantitativaLabel = null;
	private JLabel caracterCuantitativaLabel = null;
	private JLabel juicioCuantitativaLabel = null;
	private JTextField cuantitativaTextField = null;
	private JPanel caracterPanel = null;
	private JButton aceptarCuantitativaButton = null;
	private JButton cancelarCuantitativaButton = null;
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
			efectoTabbedPane.addTab("Ficha general", null, getFichaPanel(), null);
			efectoTabbedPane.addTab("Valoración cualitativa", null, getValCualitativaPanel(), null);
			efectoTabbedPane.addTab("Valoración cuantitativa", null, getValCuantitativaPane(), null);
		}
		return efectoTabbedPane;
	}

	/**
	 * This method initializes fichaPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getFichaPanel() {
		if (fichaPanel == null) {
			fichaPanel = new JPanel();
			fichaPanel.setLayout(null);
			fichaPanel.add(getInfoEfectoPanel(), null);
			fichaPanel.add(getValEfectoPanel(), null);
			fichaPanel.add(getAceptarFichaButton(), null);
			fichaPanel.add(getCancelarFichaButton(), null);
		}
		return fichaPanel;
	}

	/**
	 * This method initializes infoEfectoPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getInfoEfectoPanel() {
		if (infoEfectoPanel == null) {
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
			infoEfectoPanel = new JPanel();
			infoEfectoPanel.setLayout(null);
			infoEfectoPanel.setBounds(new Rectangle(24, 14, 440, 104));
			infoEfectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Información", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			infoEfectoPanel.add(getEfectoTextField(), null);
			infoEfectoPanel.add(getAccionTextField(), null);
			infoEfectoPanel.add(getFactorTextField(), null);
			infoEfectoPanel.add(getDescripcionTextField(), null);
			infoEfectoPanel.add(efectoLabel, null);
			infoEfectoPanel.add(accionLabel, null);
			infoEfectoPanel.add(factorLabel, null);
			infoEfectoPanel.add(descripcionLabel, null);
		}
		return infoEfectoPanel;
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
	 * This method initializes valEfectoPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getValEfectoPanel() {
		if (valEfectoPanel == null) {
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
			valEfectoPanel = new JPanel();
			valEfectoPanel.setLayout(null);
			valEfectoPanel.setLocation(new Point(24, 130));
			valEfectoPanel.setSize(new Dimension(440, 204));
			valEfectoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			valEfectoPanel.add(getCualitativaTextField(), null);
			valEfectoPanel.add(getValoracionPanel(), null);
			valEfectoPanel.add(getJuicioComboBox(), null);
			valEfectoPanel.add(getModificarJuicioButton(), null);
			valEfectoPanel.add(valoracionCualitativaLabel, null);
			valEfectoPanel.add(valoracionCuantitativaLabel, null);
			valEfectoPanel.add(juicioCuantitativaLabel, null);
			valEfectoPanel.add(getCuantitativaTextField(), null);
			valEfectoPanel.add(getCaracterPanel(), null);
		}
		return valEfectoPanel;
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
	 * This method initializes aceptarFichaButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarFichaButton() {
		if (aceptarFichaButton == null) {
			aceptarFichaButton = new JButton();
			aceptarFichaButton.setBackground(Color.white);
			aceptarFichaButton.setName("");
			aceptarFichaButton.setSize(new Dimension(79, 17));
			aceptarFichaButton.setLocation(new Point(155, 355));
			aceptarFichaButton.setText("Aceptar");
		}
		return aceptarFichaButton;
	}

	/**
	 * This method initializes cancelarFichaButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCancelarFichaButton() {
		if (cancelarFichaButton == null) {
			cancelarFichaButton = new JButton();
			cancelarFichaButton.setBackground(Color.white);
			cancelarFichaButton.setName("");
			cancelarFichaButton.setSelected(false);
			cancelarFichaButton.setSize(new Dimension(85, 17));
			cancelarFichaButton.setLocation(new Point(251, 355));
			cancelarFichaButton.setText("Cancelar");
			cancelarFichaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return cancelarFichaButton;
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
	 * This method initializes valCualitativaPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getValCualitativaPanel() {
		if (valCualitativaPanel == null) {
			valCualitativaPanel = new JPanel();
			valCualitativaPanel.setLayout(null);
			valCualitativaPanel.add(getCualitativaPanel(), null);
			valCualitativaPanel.add(getAceptarCualitativaButton(), null);
			valCualitativaPanel.add(getCancelarCualitativaButton(), null);
		}
		return valCualitativaPanel;
	}

	/**
	 * This method initializes cualitativaPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCualitativaPanel() {
		if (cualitativaPanel == null) {
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
			cualitativaPanel = new JPanel();
			cualitativaPanel.setLayout(null);
			cualitativaPanel.setLocation(new Point(17, 14));
			cualitativaPanel.setSize(new Dimension(454, 320));
			cualitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración cualitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			cualitativaPanel.add(getSignoComboBox(), null);
			cualitativaPanel.add(getAcumulacionComboBox(), null);
			cualitativaPanel.add(getExtensionComboBox(), null);
			cualitativaPanel.add(getIntensidadComboBox(), null);
			cualitativaPanel.add(getPersistenciaComboBox(), null);
			cualitativaPanel.add(getReversibilidadComboBox(), null);
			cualitativaPanel.add(getEfectoComboBox(), null);
			cualitativaPanel.add(getPeriodicidadComboBox(), null);
			cualitativaPanel.add(getRecuperabilidadComboBox(), null);
			cualitativaPanel.add(getMomentoComboBox(), null);
			cualitativaPanel.add(signoLabel, null);
			cualitativaPanel.add(extensionLabel, null);
			cualitativaPanel.add(intensidadLabel, null);
			cualitativaPanel.add(reversibilidadLabel, null);
			cualitativaPanel.add(periodicidadLabel, null);
			cualitativaPanel.add(momentoLabel, null);
			cualitativaPanel.add(acumulacionLabel, null);
			cualitativaPanel.add(persistenciaLabel, null);
			cualitativaPanel.add(efectoCuaLabel, null);
			cualitativaPanel.add(recuperabilidadLabel, null);
			cualitativaPanel.add(getIncidenciaPanel(), null);
			cualitativaPanel.add(getExtensionCriticaCheckBox(), null);
			cualitativaPanel.add(getMomentoCriticoCheckBox(), null);
			cualitativaPanel.add(extensionCriticaLabel, null);
			cualitativaPanel.add(momentoCriticoLabel, null);
			cualitativaPanel.add(getCalcularCualitativaButton(), null);
		}
		return cualitativaPanel;
	}

	/**
	 * This method initializes aceptarCualitativaButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarCualitativaButton() {
		if (aceptarCualitativaButton == null) {
			aceptarCualitativaButton = new JButton();
			aceptarCualitativaButton.setBackground(Color.white);
			aceptarCualitativaButton.setName("");
			aceptarCualitativaButton.setSize(new Dimension(79, 17));
			aceptarCualitativaButton.setLocation(new Point(155, 355));
			aceptarCualitativaButton.setText("Aceptar");
		}
		return aceptarCualitativaButton;
	}

	/**
	 * This method initializes cancelarCualitativaButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCancelarCualitativaButton() {
		if (cancelarCualitativaButton == null) {
			cancelarCualitativaButton = new JButton();
			cancelarCualitativaButton.setBackground(Color.white);
			cancelarCualitativaButton.setName("");
			cancelarCualitativaButton.setSelected(false);
			cancelarCualitativaButton.setMnemonic(KeyEvent.VK_UNDEFINED);
			cancelarCualitativaButton.setSize(new Dimension(85, 17));
			cancelarCualitativaButton.setLocation(new Point(251, 355));
			cancelarCualitativaButton.setText("Cancelar");
			cancelarCualitativaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return cancelarCualitativaButton;
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
	 * This method initializes calcularCualitativaButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCalcularCualitativaButton() {
		if (calcularCualitativaButton == null) {
			calcularCualitativaButton = new JButton();
			calcularCualitativaButton.setLocation(new Point(325, 180));
			calcularCualitativaButton.setBackground(Color.white);
			calcularCualitativaButton.setName("");
			calcularCualitativaButton.setText("Calcular");
			calcularCualitativaButton.setSize(new Dimension(120, 20));
		}
		return calcularCualitativaButton;
	}

	/**
	 * This method initializes valCuantitativaPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getValCuantitativaPane() {
		if (valCuantitativaPane == null) {
			valCuantitativaPane = new JPanel();
			valCuantitativaPane.setLayout(null);
			//jContentPane2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			valCuantitativaPane.add(getCuantitativaPanel(), null);
			valCuantitativaPane.add(getAceptarCuantitativaButton(), null);
			valCuantitativaPane.add(getCancelarCuantitativaButton(), null);
		}
		return valCuantitativaPane;
	}

	/**
	 * This method initializes cuantitativaPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCuantitativaPanel() {
		if (cuantitativaPanel == null) {
			fTransformacionLabel = new JLabel();
			fTransformacionLabel.setText("Función de transformación:");
			fTransformacionLabel.setLocation(new Point(49, 174));
			fTransformacionLabel.setSize(new Dimension(163, 16));
			cuantitativaPanel = new JPanel();
			cuantitativaPanel.setLayout(null);
			cuantitativaPanel.setLocation(new Point(17, 14));
			cuantitativaPanel.setSize(new Dimension(454, 320));
			cuantitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración cuantitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			cuantitativaPanel.add(fTransformacionLabel, null);
			cuantitativaPanel.add(getFTransformacionComboBox(), null);
			cuantitativaPanel.add(getAsistenteButton(), null);
			cuantitativaPanel.add(getMagnitudPanel(), null);
			cuantitativaPanel.add(getGraficoButton(), null);
			cuantitativaPanel.add(getIndicadoresPanel(), null);
		}
		return cuantitativaPanel;
	}

	/**
	 * This method initializes fTransformacionComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getFTransformacionComboBox() {
		if (fTransformacionComboBox == null) {
			fTransformacionComboBox = new JComboBox();
			fTransformacionComboBox.setSize(new Dimension(196, 17));
			fTransformacionComboBox.setLocation(new Point(36, 203));
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
			asistenteButton.setBounds(new Rectangle(261, 184, 151, 25));
			asistenteButton.setBackground(Color.white);
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
			magnitudLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			magnitudLabel.setSize(new Dimension(76, 19));
			magnitudLabel.setLocation(new Point(39, 17));
			magnitudLabel.setText("Magnitud");
			magnitudPanel = new JPanel();
			magnitudPanel.setLayout(null);
			magnitudPanel.setBounds(new Rectangle(29, 238, 276, 53));
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
			magnitudTextField.setLocation(new Point(124, 18));
			magnitudTextField.setSize(new Dimension(117, 18));
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
			graficoButton.setBackground(Color.white);
			graficoButton.setSize(new Dimension(93, 49));
			graficoButton.setLocation(new Point(330, 239));
			graficoButton.setText("Gráfico");
		}
		return graficoButton;
	}

	/**
	 * This method initializes indicadoresPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getIndicadoresPanel() {
		if (indicadoresPanel == null) {
			valorMinLabel = new JLabel();
			valorMinLabel.setText("Valor máximo indicador:");
			valorMinLabel.setLocation(new Point(48, 60));
			valorMinLabel.setSize(new Dimension(147, 16));
			indicadorLabel = new JLabel();
			indicadorLabel.setText("Indicador:");
			indicadorLabel.setLocation(new Point(130, 10));
			indicadorLabel.setSize(new Dimension(62, 18));
			valorMaxLabel = new JLabel();
			valorMaxLabel.setText("Valor máximo indicador:");
			valorMaxLabel.setLocation(new Point(48, 35));
			valorMaxLabel.setSize(new Dimension(149, 16));
			indicadoresPanel = new JPanel();
			indicadoresPanel.setLayout(null);
			indicadoresPanel.setBounds(new Rectangle(16, 30, 422, 123));
			indicadoresPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			indicadoresPanel.add(getValormaxTextField(), null);
			indicadoresPanel.add(valorMaxLabel, null);
			indicadoresPanel.add(indicadorLabel, null);
			indicadoresPanel.add(valorMinLabel, null);
			indicadoresPanel.add(getCalcularCuantitativaButton(), null);
			indicadoresPanel.add(getIndicadorTextField(), null);
			indicadoresPanel.add(getValorMinTextField(), null);
		}
		return indicadoresPanel;
	}

	/**
	 * This method initializes valormaxTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getValormaxTextField() {
		if (valormaxTextField == null) {
			valormaxTextField = new JTextField();
			valormaxTextField.setLocation(new Point(190, 35));
			valormaxTextField.setSize(new Dimension(120, 18));
		}
		return valormaxTextField;
	}

	/**
	 * This method initializes calcularCuantitativaButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCalcularCuantitativaButton() {
		if (calcularCuantitativaButton == null) {
			calcularCuantitativaButton = new JButton();
			calcularCuantitativaButton.setBounds(new Rectangle(14, 85, 393, 28));
			calcularCuantitativaButton.setBackground(Color.white);
			calcularCuantitativaButton.setText("Calcular");
		}
		return calcularCuantitativaButton;
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
			valorMinTextField.setLocation(new Point(190, 60));
			valorMinTextField.setSize(new Dimension(120, 18));
		}
		return valorMinTextField;
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

	/**
	 * This method initializes aceptarCuantitativaButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarCuantitativaButton() {
		if (aceptarCuantitativaButton == null) {
			aceptarCuantitativaButton = new JButton();
			aceptarCuantitativaButton.setName("");
			aceptarCuantitativaButton.setText("Aceptar");
			aceptarCuantitativaButton.setSize(new Dimension(79, 17));
			aceptarCuantitativaButton.setLocation(new Point(155, 355));
			aceptarCuantitativaButton.setBackground(Color.white);
		}
		return aceptarCuantitativaButton;
	}

	/**
	 * This method initializes cancelarCuantitativaButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCancelarCuantitativaButton() {
		if (cancelarCuantitativaButton == null) {
			cancelarCuantitativaButton = new JButton();
			cancelarCuantitativaButton.setName("");
			cancelarCuantitativaButton.setMnemonic(KeyEvent.VK_UNDEFINED);
			cancelarCuantitativaButton.setSelected(false);
			cancelarCuantitativaButton.setText("Cancelar");
			cancelarCuantitativaButton.setSize(new Dimension(85, 17));
			cancelarCuantitativaButton.setLocation(new Point(251, 355));
			cancelarCuantitativaButton.setBackground(Color.white);
			cancelarCuantitativaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return cancelarCuantitativaButton;
	}

}  //  @jve:decl-index=0:visual-constraint="14,15"
