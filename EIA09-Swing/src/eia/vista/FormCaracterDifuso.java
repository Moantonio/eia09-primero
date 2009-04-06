package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import eia.fuzzy.Caracter;
import eia.util.CaracterEfecto;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

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

	// Variables del modelo
	private boolean flagAceptar = false;
	private CaracterEfecto caracter = CaracterEfecto.compatible;  //  @jve:decl-index=0:
	private double perRecuperacion = 0.5;
	private double medCorrectoras = 0.5;

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
			jMCorrectorasSlider.addChangeListener(new ChangeListener(){
				 public void stateChanged(ChangeEvent e) {
					medCorrectoras = (redondear(jMCorrectorasSlider.getValue()*0.1,3));
					getJMCorrectorasTextField().setText(String.valueOf(medCorrectoras));
				}
			});
		}
		return jMCorrectorasSlider;
	}

	private JTextField getJMCorrectorasTextField() {
		if (jMCorrectorasTextField == null) {
			jMCorrectorasTextField = new JTextField();
			jMCorrectorasTextField.setLocation(new Point(199, 75));
			jMCorrectorasTextField.setSize(new Dimension(22, 18));
			jMCorrectorasTextField.setEnabled(false);
			jMCorrectorasTextField.setText("0.5");
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
			jTRecuperacionSlider.addChangeListener(new ChangeListener(){
				 public void stateChanged(ChangeEvent e) {
					 perRecuperacion = (redondear(jTRecuperacionSlider.getValue()*0.1,3));
					getJTRecuperacionTextField().setText(String.valueOf(perRecuperacion));
				}
			});
		}
		return jTRecuperacionSlider;
	}

	private JTextField getJTRecuperacionTextField() {
		if (jTRecuperacionTextField == null) {
			jTRecuperacionTextField = new JTextField();
			jTRecuperacionTextField.setLocation(new Point(199, 160));
			jTRecuperacionTextField.setSize(new Dimension(22, 18));
			jTRecuperacionTextField.setEnabled(false);
			jTRecuperacionTextField.setText("0.5");
		}
		return jTRecuperacionTextField;
	}

	private JPanel getValoracionPanel() {
		if (valoracionPanel == null) {
			jLabel = new JLabel();
			jLabel.setLocation(new Point(100, 36));
			jLabel.setText("::");
			jLabel.setSize(new Dimension(13, 16));
			valoracionLabel = new JLabel();
			valoracionLabel.setText("Carácter impacto");
			valoracionLabel.setSize(new Dimension(125, 21));
			valoracionLabel.setLocation(new Point(68, 8));
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
			valoracionTextField.setLocation(new Point(115, 35));
			valoracionTextField.setEnabled(false);
			valoracionTextField.setSize(new Dimension(83, 18));
		}
		return valoracionTextField;
	}

	private JTextField getValorTextField() {
		if (valorTextField == null) {
			valorTextField = new JTextField();
			valorTextField.setLocation(new Point(60, 35));
			valorTextField.setEnabled(false);
			valorTextField.setSize(new Dimension(35, 18));
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
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calcularIfencia();
					aceptarButton.setEnabled(true);
				}
			});
		}
		return jButton;
	}

	private void calcularIfencia() {
		// Creamos el motor de inferencia difuso
		Caracter motorDifuso = new Caracter();

		// Procesaremos lo valores de entrada del sistema
		double[] entrada = new double[2];
		//0: Precisa medidas correctoras?
		entrada[0] = medCorrectoras;
		//1: Periodo de recuperacion de los recursos naturales
		entrada[1] = perRecuperacion;

		// Realizamos la inferencia, obteniendo la salida del sistema
		// 0 a 0.25 (compatible)
		// 0.25 a 0.5 (moderado)
		// 0.5 a 0.75 (severo)
		// 0.75 a 1 (crítico)
		double[] salida = motorDifuso.crispInference(entrada);

		// Mostramos los resultados
		valorTextField.setText(String.valueOf(redondear(salida[0],3)));
		if (salida[0]<0.25){
			valoracionTextField.setText("Compatible");
			caracter = CaracterEfecto.compatible;
		}else if((salida[0]>=0.25)&&(salida[0]<0.5)){
			valoracionTextField.setText("Moderado");
			caracter = CaracterEfecto.moderado;
		}else if((salida[0]>=0.5)&&(salida[0]<0.75)){
			valoracionTextField.setText("Severo");
			caracter = CaracterEfecto.severo;
		}else{
			valoracionTextField.setText("Crítico");
			caracter = CaracterEfecto.critico;
		}
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setEnabled(false);
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(145, 305));
			aceptarButton.setSize(new Dimension(79, 17));
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
			cancelarButton.setLocation(new Point(241, 305));
			cancelarButton.setSize(new Dimension(85, 17));
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

	public CaracterEfecto getCaracter() {
		return caracter;
	}

	/**
	 * Función para redondear un número de tipo double al número de cifras
	 * decimales indicadas por parámetro.
	 * @param nD Número a redondear.
	 * @param nDec Número de cifras decimales a redondear.
	 * @return Número redondeado.
	 */
	private double redondear(double nD, int nDec){
	  return Math.round(nD*Math.pow(10,nDec))/Math.pow(10,nDec);
	}
}
