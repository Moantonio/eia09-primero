package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

//TODO
public class FormJuicioDifuso extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JSlider jMAmbienteSlider = null;
	private JSlider jRNaturalesSlider = null;
	private JSlider jPFundamentalesSlider = null;
	private JLabel jMAmbienteLabel = null;
	private JLabel jRNatualesLabel = null;
	private JLabel jPFundamentalesLabel = null;
	private JPanel jPanel = null;
	private JTextField jMATextField = null;
	private JLabel jmuchoLabel = null;
	private JLabel jpocoLabel = null;
	private JTextField jRNTextField = null;
	private JTextField jPFTextField = null;
	private JLabel jpocoLabel1 = null;
	private JLabel jmuchoLabel1 = null;
	private JLabel jpocoLabel11 = null;
	private JLabel jmuchoLabel11 = null;
	private JButton jButton = null;
	private JPanel valoracionPanel = null;
	private JTextField valoracionTextField = null;
	private JLabel valoracionLabel = null;
	private JButton cancelarButton = null;
	private JButton aceptarButton = null;
	private JTextField valorTextField = null;
	private JPanel iferenciaPanel = null;
	private JLabel jLabel = null;

	public FormJuicioDifuso(Frame owner) {
		super(owner);
		initialize();
	}

	private void initialize() {
		this.setSize(475, 415);
		this.setContentPane(getJContentPane());
		this.setTitle("Asistente difuso: efecto");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//image-loading.png"));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jPFundamentalesLabel = new JLabel();
			jPFundamentalesLabel.setText("¿Cuánto se modifican los procesos fundamentales de funcionamiento?");
			jPFundamentalesLabel.setLocation(new Point(16, 170));
			jPFundamentalesLabel.setSize(new Dimension(408, 15));
			jRNatualesLabel = new JLabel();
			jRNatualesLabel.setText("¿Cuánto se modifican los recursos naturales?");
			jRNatualesLabel.setLocation(new Point(86, 100));
			jRNatualesLabel.setSize(new Dimension(268, 16));
			jMAmbienteLabel = new JLabel();
			jMAmbienteLabel.setText("¿Cuánto se modifica el medio ambiente?");
			jMAmbienteLabel.setLocation(new Point(100, 30));
			jMAmbienteLabel.setSize(new Dimension(236, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getCancelarButton(), null);
			jContentPane.add(getAceptarButton(), null);
		}
		return jContentPane;
	}

	private JSlider getJMAmbienteSlider() {
		if (jMAmbienteSlider == null) {
			jMAmbienteSlider = new JSlider();
			jMAmbienteSlider.setMinimum(0);
			jMAmbienteSlider.setMaximum(10);
			jMAmbienteSlider.setSize(new Dimension(120, 20));
			jMAmbienteSlider.setLocation(new Point(150, 55));
			jMAmbienteSlider.setValue(5);
		}
		return jMAmbienteSlider;
	}

	private JSlider getJRNaturalesSlider() {
		if (jRNaturalesSlider == null) {
			jRNaturalesSlider = new JSlider();
			jRNaturalesSlider.setMinimum(0);
			jRNaturalesSlider.setMaximum(10);
			jRNaturalesSlider.setSize(new Dimension(120, 20));
			jRNaturalesSlider.setLocation(new Point(150, 125));
			jRNaturalesSlider.setValue(5);
		}
		return jRNaturalesSlider;
	}

	private JSlider getJPFundamentalesSlider() {
		if (jPFundamentalesSlider == null) {
			jPFundamentalesSlider = new JSlider();
			jPFundamentalesSlider.setMinimum(0);
			jPFundamentalesSlider.setMaximum(10);
			jPFundamentalesSlider.setSize(new Dimension(120, 20));
			jPFundamentalesSlider.setLocation(new Point(150, 195));
			jPFundamentalesSlider.setValue(5);
		}
		return jPFundamentalesSlider;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jmuchoLabel11 = new JLabel();
			jmuchoLabel11.setText("MUCHO");
			jmuchoLabel11.setSize(new Dimension(43, 16));
			jmuchoLabel11.setLocation(new Point(272, 195));
			jmuchoLabel11.setFont(new Font("Dialog", Font.BOLD, 10));
			jpocoLabel11 = new JLabel();
			jpocoLabel11.setText("POCO");
			jpocoLabel11.setSize(new Dimension(34, 16));
			jpocoLabel11.setLocation(new Point(118, 195));
			jpocoLabel11.setFont(new Font("Dialog", Font.BOLD, 10));
			jmuchoLabel1 = new JLabel();
			jmuchoLabel1.setText("MUCHO");
			jmuchoLabel1.setSize(new Dimension(43, 16));
			jmuchoLabel1.setLocation(new Point(272, 125));
			jmuchoLabel1.setFont(new Font("Dialog", Font.BOLD, 10));
			jpocoLabel1 = new JLabel();
			jpocoLabel1.setText("POCO");
			jpocoLabel1.setSize(new Dimension(34, 16));
			jpocoLabel1.setLocation(new Point(118, 125));
			jpocoLabel1.setFont(new Font("Dialog", Font.BOLD, 10));
			jpocoLabel = new JLabel();
			jpocoLabel.setFont(new Font("Dialog", Font.BOLD, 10));
			jpocoLabel.setSize(new Dimension(34, 16));
			jpocoLabel.setLocation(new Point(118, 55));
			jpocoLabel.setText("POCO");
			jmuchoLabel = new JLabel();
			jmuchoLabel.setFont(new Font("Dialog", Font.BOLD, 10));
			jmuchoLabel.setSize(new Dimension(46, 16));
			jmuchoLabel.setLocation(new Point(272, 55));
			jmuchoLabel.setText("MUCHO");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Simple enjuiciamiento difuso", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel.setSize(new Dimension(437, 329));
			jPanel.setLocation(new Point(15, 14));
			jPanel.add(jMAmbienteLabel, null);
			jPanel.add(getJPFundamentalesSlider(), null);
			jPanel.add(getJMAmbienteSlider(), null);
			jPanel.add(jPFundamentalesLabel, null);
			jPanel.add(jRNatualesLabel, null);
			jPanel.add(getJRNaturalesSlider(), null);
			jPanel.add(getJMATextField(), null);
			jPanel.add(jmuchoLabel, null);
			jPanel.add(jpocoLabel, null);
			jPanel.add(getJRNTextField(), null);
			jPanel.add(getJPFTextField(), null);
			jPanel.add(jpocoLabel1, null);
			jPanel.add(jmuchoLabel1, null);
			jPanel.add(jpocoLabel11, null);
			jPanel.add(jmuchoLabel11, null);
			jPanel.add(getValoracionPanel(), null);
			jPanel.add(getIferenciaPanel(), null);
		}
		return jPanel;
	}

	private JTextField getJMATextField() {
		if (jMATextField == null) {
			jMATextField = new JTextField();
			jMATextField.setSize(new Dimension(33, 18));
			jMATextField.setLocation(new Point(195, 75));
		}
		return jMATextField;
	}

	private JTextField getJRNTextField() {
		if (jRNTextField == null) {
			jRNTextField = new JTextField();
			jRNTextField.setSize(new Dimension(33, 18));
			jRNTextField.setLocation(new Point(194, 145));
		}
		return jRNTextField;
	}

	private JTextField getJPFTextField() {
		if (jPFTextField == null) {
			jPFTextField = new JTextField();
			jPFTextField.setLocation(new Point(194, 215));
			jPFTextField.setSize(new Dimension(33, 18));
		}
		return jPFTextField;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBackground(Color.white);
			jButton.setLocation(new Point(21, 16));
			jButton.setSize(new Dimension(79, 30));
			jButton.setText("Inferir");
		}
		return jButton;
	}

	private JPanel getValoracionPanel() {
		if (valoracionPanel == null) {
			jLabel = new JLabel();
			jLabel.setText("::");
			jLabel.setLocation(new Point(78, 35));
			jLabel.setSize(new Dimension(13, 16));
			valoracionLabel = new JLabel();
			valoracionLabel.setBounds(new Rectangle(49, 8, 156, 21));
			valoracionLabel.setText("Simple enjuiciamiento");
			valoracionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			valoracionPanel = new JPanel();
			valoracionPanel.setLayout(null);
			valoracionPanel.setBounds(new Rectangle(24, 241, 253, 65));
			valoracionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			valoracionPanel.add(getValoracionTextField(), null);
			valoracionPanel.add(valoracionLabel, null);
			valoracionPanel.add(getValorTextField(), null);
			valoracionPanel.add(jLabel, null);
		}
		return valoracionPanel;
	}

	private JTextField getValoracionTextField() {
		if (valoracionTextField == null) {
			valoracionTextField = new JTextField();
			valoracionTextField.setEnabled(false);
			valoracionTextField.setLocation(new Point(87, 35));
			valoracionTextField.setSize(new Dimension(141, 18));
		}
		return valoracionTextField;
	}

	private JButton getCancelarButton() {
		if (cancelarButton == null) {
			cancelarButton = new JButton();
			cancelarButton.setName("");
			cancelarButton.setSelected(false);
			cancelarButton.setText("Cancelar");
			cancelarButton.setLocation(new Point(241, 354));
			cancelarButton.setSize(new Dimension(85, 17));
			cancelarButton.setBackground(Color.white);
		}
		return cancelarButton;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setName("");
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(145, 353));
			aceptarButton.setSize(new Dimension(79, 17));
			aceptarButton.setBackground(Color.white);
		}
		return aceptarButton;
	}

	private JTextField getValorTextField() {
		if (valorTextField == null) {
			valorTextField = new JTextField();
			valorTextField.setEnabled(false);
			valorTextField.setLocation(new Point(20, 35));
			valorTextField.setSize(new Dimension(56, 18));
		}
		return valorTextField;
	}

	private JPanel getIferenciaPanel() {
		if (iferenciaPanel == null) {
			iferenciaPanel = new JPanel();
			iferenciaPanel.setLayout(null);
			iferenciaPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			iferenciaPanel.setSize(new Dimension(118, 65));
			iferenciaPanel.setLocation(new Point(296, 241));
			iferenciaPanel.add(getJButton(), null);
		}
		return iferenciaPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
