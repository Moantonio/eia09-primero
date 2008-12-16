package eia.vista;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class formValoracionCuantitativa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel efectoLabel = null;
	private JLabel descripcionLabel1 = null;
	private JTextArea descripcionTextArea = null;
	private JTextField efectoTextField = null;
	private JPanel valCuantitativaPanel = null;
	private JLabel indicadorLabel = null;
	private JLabel valorMaxLabel = null;
	private JTextField indicadorTextField = null;
	private JTextField valormaxTextField = null;
	private JLabel valorMinLabel = null;
	private JTextField valorMinTextField = null;
	private JButton calcularButton = null;
	private JLabel fTransformacionLabel = null;
	private JComboBox fTransformacionComboBox = null;
	private JButton asistenteButton = null;
	private JPanel magnitudPanel = null;
	private JLabel magnitudLabel = null;
	private JTextField magnitudTextField = null;
	private JButton graficoButton = null;
	private JPanel datosPanel = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;

	/**
	 * This is the default constructor
	 */
	public formValoracionCuantitativa() {
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
		this.setTitle("EIA09");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			descripcionLabel1 = new JLabel();
			descripcionLabel1.setBounds(new Rectangle(23, 38, 73, 16));
			descripcionLabel1.setText("Descripción:");
			efectoLabel = new JLabel();
			efectoLabel.setBounds(new Rectangle(56, 16, 40, 16));
			efectoLabel.setText("Efecto:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			jContentPane.add(efectoLabel, null);
			jContentPane.add(descripcionLabel1, null);
			jContentPane.add(getDescripcionTextArea(), null);
			jContentPane.add(getEfectoTextField(), null);
			jContentPane.add(getValCuantitativaPanel(), null);
			jContentPane.add(getAceptarButton(), null);
			jContentPane.add(getCancelarButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes descripcionTextArea
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getDescripcionTextArea() {
		if (descripcionTextArea == null) {
			descripcionTextArea = new JTextArea();
			descripcionTextArea.setLocation(new Point(100, 38));
			descripcionTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			descripcionTextArea.setSize(new Dimension(374, 36));
		}
		return descripcionTextArea;
	}

	/**
	 * This method initializes efectoTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getEfectoTextField() {
		if (efectoTextField == null) {
			efectoTextField = new JTextField();
			efectoTextField.setLocation(new Point(100, 15));
			efectoTextField.setSize(new Dimension(374, 18));
		}
		return efectoTextField;
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
			fTransformacionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			fTransformacionLabel.setText("Función de transformación:");
			valorMinLabel = new JLabel();
			valorMinLabel.setText("Valor máximo indicador:");
			valorMinLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			valorMinLabel.setBounds(new Rectangle(7, 55, 168, 16));
			valorMaxLabel = new JLabel();
			valorMaxLabel.setText("Valor máximo indicador:");
			valorMaxLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			valorMaxLabel.setBounds(new Rectangle(8, 33, 169, 16));
			indicadorLabel = new JLabel();
			indicadorLabel.setText("Indicador:");
			indicadorLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			indicadorLabel.setBounds(new Rectangle(105, 10, 74, 18));
			valCuantitativaPanel = new JPanel();
			valCuantitativaPanel.setLayout(null);
			valCuantitativaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Valoración Cuantitativa", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			valCuantitativaPanel.setLocation(new Point(16, 85));
			valCuantitativaPanel.setSize(new Dimension(460, 315));
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
	 * This method initializes indicadorTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getIndicadorTextField() {
		if (indicadorTextField == null) {
			indicadorTextField = new JTextField();
			indicadorTextField.setFont(new Font("Dialog", Font.PLAIN, 14));
			indicadorTextField.setLocation(new Point(190, 10));
			indicadorTextField.setSize(new Dimension(120, 18));
		}
		return indicadorTextField;
	}

	/**
	 * This method initializes valormaxTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getValormaxTextField() {
		if (valormaxTextField == null) {
			valormaxTextField = new JTextField();
			valormaxTextField.setFont(new Font("Dialog", Font.PLAIN, 14));
			valormaxTextField.setLocation(new Point(190, 33));
			valormaxTextField.setSize(new Dimension(120, 18));
		}
		return valormaxTextField;
	}

	/**
	 * This method initializes valorMinTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getValorMinTextField() {
		if (valorMinTextField == null) {
			valorMinTextField = new JTextField();
			valorMinTextField.setFont(new Font("Dialog", Font.PLAIN, 14));
			valorMinTextField.setLocation(new Point(190, 55));
			valorMinTextField.setSize(new Dimension(141, 17));
		}
		return valorMinTextField;
	}

	/**
	 * This method initializes calcularButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCalcularButton() {
		if (calcularButton == null) {
			calcularButton = new JButton();
			calcularButton.setText("Calcular");
			calcularButton.setFont(new Font("Dialog", Font.BOLD, 14));
			calcularButton.setBounds(new Rectangle(11, 85, 393, 28));
		}
		return calcularButton;
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
			fTransformacionComboBox.setFont(new Font("Dialog", Font.BOLD, 14));
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
			asistenteButton.setFont(new Font("Dialog", Font.BOLD, 14));
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
			magnitudLabel.setFont(new Font("Dialog", Font.BOLD, 16));
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
			magnitudTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
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
			graficoButton.setFont(new Font("Dialog", Font.BOLD, 14));
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
			datosPanel = new JPanel();
			datosPanel.setLayout(null);
			datosPanel.setBounds(new Rectangle(16, 30, 422, 123));
			datosPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			datosPanel.add(getValormaxTextField(), null);
			datosPanel.add(valorMaxLabel, null);
			datosPanel.add(indicadorLabel, null);
			datosPanel.add(valorMinLabel, null);
			datosPanel.add(getCalcularButton(), null);
			datosPanel.add(getIndicadorTextField(), null);
			datosPanel.add(getValorMinTextField(), null);
		}
		return datosPanel;
	}

	/**
	 * This method initializes aceptarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setText("Aceptar");
			aceptarButton.setSize(new Dimension(100, 32));
			aceptarButton.setFont(new Font("Dialog", Font.BOLD, 14));
			aceptarButton.setLocation(new Point(230, 422));
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
			cancelarButton.setText("Cancelar");
			cancelarButton.setSize(new Dimension(100, 32));
			cancelarButton.setFont(new Font("Dialog", Font.BOLD, 14));
			cancelarButton.setLocation(new Point(345, 422));
		}
		return cancelarButton;
	}

	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				formValoracionCuantitativa application = new formValoracionCuantitativa();
				application.setVisible(true);
			}
		});
	}

}
