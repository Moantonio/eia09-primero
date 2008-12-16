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
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class formValoracionCualitativa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel efectoPanel = null;
	private JTextField efectoTextField = null;
	private JTextField descripcionTextField = null;
	private JLabel efectoLabel = null;
	private JLabel descripcionLabel = null;
	private JPanel cualitativaPanel = null;
	private JPanel botoneraPanel = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
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
			momentoCriticoLabel = new JLabel();
			momentoCriticoLabel.setBounds(new Rectangle(267, 183, 77, 16));
			momentoCriticoLabel.setText("Crítico");
			extensionCriticaLabel = new JLabel();
			extensionCriticaLabel.setText("Crítica");
			extensionCriticaLabel.setLocation(new Point(267, 62));
			extensionCriticaLabel.setSize(new Dimension(77, 16));
			recuperabilidadLabel = new JLabel();
			recuperabilidadLabel.setText("Recuperabilidad:");
			recuperabilidadLabel.setLocation(new Point(225, 150));
			recuperabilidadLabel.setSize(new Dimension(103, 16));
			efectoCuaLabel = new JLabel();
			efectoCuaLabel.setText("Efecto:");
			efectoCuaLabel.setLocation(new Point(280, 120));
			efectoCuaLabel.setSize(new Dimension(39, 16));
			persistenciaLabel = new JLabel();
			persistenciaLabel.setText("Persistencia:");
			persistenciaLabel.setLocation(new Point(243, 90));
			persistenciaLabel.setSize(new Dimension(77, 16));
			acumulacionLabel = new JLabel();
			acumulacionLabel.setText("Acumulación:");
			acumulacionLabel.setLocation(new Point(242, 30));
			acumulacionLabel.setSize(new Dimension(84, 16));
			momentoLabel = new JLabel();
			momentoLabel.setText("Momento:");
			momentoLabel.setLocation(new Point(37, 180));
			momentoLabel.setSize(new Dimension(65, 16));
			periodicidadLabel = new JLabel();
			periodicidadLabel.setText("Periodicidad:");
			periodicidadLabel.setLocation(new Point(19, 150));
			periodicidadLabel.setSize(new Dimension(77, 16));
			reversibilidadLabel = new JLabel();
			reversibilidadLabel.setText("Reversibilidad:");
			reversibilidadLabel.setLocation(new Point(10, 120));
			reversibilidadLabel.setSize(new Dimension(88, 16));
			intensidadLabel = new JLabel();
			intensidadLabel.setText("Intensidad:");
			intensidadLabel.setLocation(new Point(32, 90));
			intensidadLabel.setSize(new Dimension(68, 16));
			extensionLabel = new JLabel();
			extensionLabel.setText("Extensión:");
			extensionLabel.setLocation(new Point(34, 60));
			extensionLabel.setSize(new Dimension(61, 16));
			signoLabel = new JLabel();
			signoLabel.setText("Signo:");
			signoLabel.setSize(new Dimension(40, 16));
			signoLabel.setLocation(new Point(58, 30));
			cualitativaPanel = new JPanel();
			cualitativaPanel.setLayout(null);
			cualitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Valoración Cualitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			cualitativaPanel.setLocation(new Point(10, 99));
			cualitativaPanel.setSize(new Dimension(459, 346));
			cualitativaPanel.add(getBotoneraPanel(), null);
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
			cualitativaPanel.add(getCalcularButton(), null);
		}
		return cualitativaPanel;
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
			botoneraPanel.setLocation(new Point(124, 280));
			botoneraPanel.setSize(new Dimension(199, 50));
			botoneraPanel.add(getAceptarButton(), null);
			botoneraPanel.add(getCancelarButton(), null);
		}
		return botoneraPanel;
	}

	/**
	 * This method initializes aceptarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setLocation(new Point(11, 16));
			aceptarButton.setBackground(Color.white);
			aceptarButton.setName("");
			aceptarButton.setText("Aceptar");
			aceptarButton.setSize(new Dimension(79, 17));
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
			cancelarButton.setLocation(new Point(101, 16));
			cancelarButton.setBackground(Color.white);
			cancelarButton.setName("");
			cancelarButton.setSelected(false);
			cancelarButton.setText("Cancelar");
			cancelarButton.setSize(new Dimension(85, 17));
		}
		return cancelarButton;
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
			incidenciaLabel.setBounds(new Rectangle(50, 4, 77, 21));
			incidenciaLabel.setText("Incidencia");
			incidenciaLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			incidenciaPanel = new JPanel();
			incidenciaPanel.setLayout(null);
			incidenciaPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			incidenciaPanel.setSize(new Dimension(179, 54));
			incidenciaPanel.setLocation(new Point(133, 217));
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
			incidenciaTextField.setLocation(new Point(56, 28));
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
			extensionCriticaCheckBox.setSize(new Dimension(21, 21));
			extensionCriticaCheckBox.setLocation(new Point(240, 60));
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
			momentoCriticoCheckBox.setSize(new Dimension(21, 21));
			momentoCriticoCheckBox.setLocation(new Point(240, 180));
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
			calcularButton.setName("");
			calcularButton.setText("Calcular");
			calcularButton.setLocation(new Point(340, 183));
			calcularButton.setSize(new Dimension(81, 16));
			calcularButton.setBackground(Color.white);
		}
		return calcularButton;
	}

}
