package eia.vista;

import java.awt.Color;
import java.awt.Dialog;
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
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

//TODO
public class FormCaracterDifuso extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel jMCorrectorasLabel = null;
	private JSlider jMCorrectorasSlider = null;
	private JLabel jnoLabel = null;
	private JLabel jsiLabel = null;
	private JTextField jMCorrectorasTextField = null;
	private JLabel jTRecuperacionLabel = null;
	private JSlider jTRecuperacionSlider = null;
	private JTextField jTRecuperacionTextField = null;
	private JLabel jinmediataLabel = null;
	private JLabel jDilatadaLabel = null;
	private JLabel jSinRecuperacionLabel = null;
	private JPanel valoracionPanel = null;
	private JTextField valoracionTextField = null;
	private JLabel valoracionLabel = null;
	private JTextField valorTextField = null;
	private JLabel jLabel = null;
	private JPanel iferenciaPanel = null;
	private JButton jButton = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;

	public FormCaracterDifuso(Frame owner) {
		super(owner);
		initialize();
	}

	private void initialize() {
		this.setSize(475, 365);
		this.setContentPane(getJContentPane());
		this.setTitle("Asistente difuso: Carácter impacto");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//image-loading.png"));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getAceptarButton(), null);
			jContentPane.add(getCancelarButton(), null);
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jSinRecuperacionLabel = new JLabel();
			jSinRecuperacionLabel.setText("SIN RECUPERACIÓN");
			jSinRecuperacionLabel.setLocation(new Point(270, 140));
			jSinRecuperacionLabel.setSize(new Dimension(103, 16));
			jSinRecuperacionLabel.setFont(new Font("Dialog", Font.BOLD, 10));
			jDilatadaLabel = new JLabel();
			jDilatadaLabel.setText("DILATADO");
			jDilatadaLabel.setLocation(new Point(186, 122));
			jDilatadaLabel.setSize(new Dimension(51, 16));
			jDilatadaLabel.setFont(new Font("Dialog", Font.BOLD, 10));
			jinmediataLabel = new JLabel();
			jinmediataLabel.setText("INMEDIATO");
			jinmediataLabel.setLocation(new Point(92, 140));
			jinmediataLabel.setSize(new Dimension(59, 16));
			jinmediataLabel.setFont(new Font("Dialog", Font.BOLD, 10));
			jTRecuperacionLabel = new JLabel();
			jTRecuperacionLabel.setText("¿Cúal es el periodo de recuperación del medio?");
			jTRecuperacionLabel.setLocation(new Point(75, 100));
			jTRecuperacionLabel.setSize(new Dimension(272, 16));
			jsiLabel = new JLabel();
			jsiLabel.setText("SI");
			jsiLabel.setLocation(new Point(270, 55));
			jsiLabel.setSize(new Dimension(18, 16));
			jsiLabel.setFont(new Font("Dialog", Font.BOLD, 10));
			jnoLabel = new JLabel();
			jnoLabel.setText("NO");
			jnoLabel.setBounds(new Rectangle(135, 55, 24, 16));
			jnoLabel.setFont(new Font("Dialog", Font.BOLD, 10));
			jMCorrectorasLabel = new JLabel();
			jMCorrectorasLabel.setText("¿Se precisan medidas correctoras?");
			jMCorrectorasLabel.setBounds(new Rectangle(115, 30, 208, 16));
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Carácter impacto difuso", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel.setSize(new Dimension(437, 277));
			jPanel.setLocation(new Point(15, 14));
			jPanel.add(jMCorrectorasLabel, null);
			jPanel.add(getJMCorrectorasSlider(), null);
			jPanel.add(jnoLabel, null);
			jPanel.add(jsiLabel, null);
			jPanel.add(getJMCorrectorasTextField(), null);
			jPanel.add(jTRecuperacionLabel, null);
			jPanel.add(getJTRecuperacionSlider(), null);
			jPanel.add(getJTRecuperacionTextField(), null);
			jPanel.add(jinmediataLabel, null);
			jPanel.add(jDilatadaLabel, null);
			jPanel.add(jSinRecuperacionLabel, null);
			jPanel.add(getValoracionPanel(), null);
			jPanel.add(getIferenciaPanel(), null);
		}
		return jPanel;
	}

	private JSlider getJMCorrectorasSlider() {
		if (jMCorrectorasSlider == null) {
			jMCorrectorasSlider = new JSlider();
			jMCorrectorasSlider.setMinimum(0);
			jMCorrectorasSlider.setValue(5);
			jMCorrectorasSlider.setLocation(new Point(150, 55));
			jMCorrectorasSlider.setSize(new Dimension(120, 20));
			jMCorrectorasSlider.setMaximum(10);
		}
		return jMCorrectorasSlider;
	}

	private JTextField getJMCorrectorasTextField() {
		if (jMCorrectorasTextField == null) {
			jMCorrectorasTextField = new JTextField();
			jMCorrectorasTextField.setLocation(new Point(195, 75));
			jMCorrectorasTextField.setSize(new Dimension(33, 18));
		}
		return jMCorrectorasTextField;
	}

	private JSlider getJTRecuperacionSlider() {
		if (jTRecuperacionSlider == null) {
			jTRecuperacionSlider = new JSlider();
			jTRecuperacionSlider.setMinimum(0);
			jTRecuperacionSlider.setValue(5);
			jTRecuperacionSlider.setLocation(new Point(150, 140));
			jTRecuperacionSlider.setSize(new Dimension(120, 20));
			jTRecuperacionSlider.setMaximum(10);
		}
		return jTRecuperacionSlider;
	}

	private JTextField getJTRecuperacionTextField() {
		if (jTRecuperacionTextField == null) {
			jTRecuperacionTextField = new JTextField();
			jTRecuperacionTextField.setLocation(new Point(195, 160));
			jTRecuperacionTextField.setSize(new Dimension(33, 18));
		}
		return jTRecuperacionTextField;
	}

	private JPanel getValoracionPanel() {
		if (valoracionPanel == null) {
			jLabel = new JLabel();
			jLabel.setLocation(new Point(78, 35));
			jLabel.setText("::");
			jLabel.setSize(new Dimension(13, 16));
			valoracionLabel = new JLabel();
			valoracionLabel.setText("Carácter impacto");
			valoracionLabel.setSize(new Dimension(125, 21));
			valoracionLabel.setLocation(new Point(63, 8));
			valoracionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			valoracionPanel = new JPanel();
			valoracionPanel.setLayout(null);
			valoracionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			valoracionPanel.setLocation(new Point(24, 190));
			valoracionPanel.setSize(new Dimension(253, 65));
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
			valoracionTextField.setLocation(new Point(87, 35));
			valoracionTextField.setEnabled(false);
			valoracionTextField.setSize(new Dimension(141, 18));
		}
		return valoracionTextField;
	}

	private JTextField getValorTextField() {
		if (valorTextField == null) {
			valorTextField = new JTextField();
			valorTextField.setLocation(new Point(20, 35));
			valorTextField.setEnabled(false);
			valorTextField.setSize(new Dimension(56, 18));
		}
		return valorTextField;
	}

	private JPanel getIferenciaPanel() {
		if (iferenciaPanel == null) {
			iferenciaPanel = new JPanel();
			iferenciaPanel.setLayout(null);
			iferenciaPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			iferenciaPanel.setLocation(new Point(296, 190));
			iferenciaPanel.setSize(new Dimension(118, 65));
			iferenciaPanel.add(getJButton(), null);
		}
		return iferenciaPanel;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setLocation(new Point(21, 16));
			jButton.setBackground(Color.white);
			jButton.setText("Inferir");
			jButton.setSize(new Dimension(79, 30));
		}
		return jButton;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setName("");
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(145, 305));
			aceptarButton.setSize(new Dimension(79, 17));
			aceptarButton.setBackground(Color.white);
		}
		return aceptarButton;
	}

	private JButton getCancelarButton() {
		if (cancelarButton == null) {
			cancelarButton = new JButton();
			cancelarButton.setName("");
			cancelarButton.setSelected(false);
			cancelarButton.setText("Cancelar");
			cancelarButton.setLocation(new Point(241, 305));
			cancelarButton.setSize(new Dimension(85, 17));
			cancelarButton.setBackground(Color.white);
		}
		return cancelarButton;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormCaracterDifuso application = new FormCaracterDifuso(null);
				application.getDialog().setVisible(true);
			}
		});
	}

	public Dialog getDialog(){
		return this;
	}

}
