package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

public class FormAsistente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton siguienteButton = null;
	private JButton cancelarButton = null;
	private JPanel asistentePanel = null;
	private JTextArea cuestionLabel = null;
	private JRadioButton siRadioButton = null;
	private JRadioButton noRadioButton = null;

	// Fase que presenta el asistente
	private int estado = 0;
	// Función de transformación recomendada
	private int funcionRecomendada = 0;
	// Flag para controlar la pulsación del botón aceptar
	private boolean flagAceptar = false;

	public FormAsistente(Frame owner) {
		super(owner);
		initialize();
	}

	private void initialize() {
		this.setSize(475, 197);
		this.setContentPane(getJContentPane());
		this.setTitle("Asistente de elección de función de transformación");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//image-loading.png"));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getSiguienteButton(), null);
			jContentPane.add(getCancelarButton(), null);
			jContentPane.add(getAsistentePanel(), null);
		}
		return jContentPane;
	}

	private JButton getSiguienteButton() {
		if (siguienteButton == null) {
			siguienteButton = new JButton();
			siguienteButton.setText("Siguiente");
			siguienteButton.setLocation(new Point(364, 130));
			siguienteButton.setSize(new Dimension(88, 18));
			siguienteButton.setBackground(Color.white);
			siguienteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					siguienteEstado();
				}
			});
		}
		return siguienteButton;
	}

	private void siguienteEstado(){
		switch(estado){

			case 0:{
				if (siRadioButton.isSelected()){
					estado = 1;
					cuestionLabel.setText("¿Es proporcional?");
					siRadioButton.setSelected(false);
					cuestionLabel.setLocation(new Point(171, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 2;
						cuestionLabel.setText("Al aumentar el valor del indicador, ¿disminuye el impacto?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(58, 33));
						cuestionLabel.setSize(new Dimension(350, 20));
					}
				}
				break;
			}

			case 1:{
				if (siRadioButton.isSelected()){
					estado = 3;
					cuestionLabel.setText("Recta creciente");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
				}else{
					if (noRadioButton.isSelected()){
						estado = 4;
						cuestionLabel.setText("Para valores pequeños de la magnitud, ¿crece rápidamente" +"\n" +" el impacto?, "
								+"y para valores grandes ¿crece lentamente?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(60, 25));
						cuestionLabel.setSize(new Dimension(350, 40));
					}
				}
				break;
			}

			case 2:{
				if (siRadioButton.isSelected()){
					estado = 12;
					cuestionLabel.setText("¿Es proporcional?");
					noRadioButton.setSelected(false);
					cuestionLabel.setLocation(new Point(171, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 13;
						cuestionLabel.setText("El impacto, ¿primero aumenta, alcanza" +"\n"
								+"un máximo, y luego disminuye?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(120, 25));
						cuestionLabel.setSize(new Dimension(280, 40));
					}
				}
				break;
			}

			case 3:{
				// Recta creciente
				funcionRecomendada = 0;
				flagAceptar = true;
				setVisible(false);
				break;
			}
			case 4:{
				if (siRadioButton.isSelected()){
					estado = 5;
					cuestionLabel.setText("Parábola creciente I");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(155, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 6;
						cuestionLabel.setText("Para valores pequeños de la magnitud, ¿crece lentamente" +"\n" +" el impacto?, "
								+"y para valores grandes ¿crece rápidamente?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(60, 25));
						cuestionLabel.setSize(new Dimension(350, 40));
					}
				}
				break;
			}

			case 5:{
				// Parábola creciente I
				funcionRecomendada = 2;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 6:{
				if (siRadioButton.isSelected()){
					estado = 7;
					cuestionLabel.setText("Parábola creciente II");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(155, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 8;
						cuestionLabel.setText("Para valores pequeños y grandes de la magnitud, ¿crece lentamente" +"\n"
								+"el impacto?, y para valores intermedios ¿crece rápidamente?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(25, 25));
						cuestionLabel.setSize(new Dimension(400, 40));
					}
				}
				break;
			}

			case 7:{
				// Parábola creciente II
				funcionRecomendada = 4;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 8:{
				if (siRadioButton.isSelected()){
					estado = 9;
					cuestionLabel.setText("Parábola doble creciente II");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(150, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 10;
						cuestionLabel.setText("Para valores pequeños y grandes de la magnitud, ¿crece rápidamente" +"\n"
								+"el impacto?, y para valores intermedios ¿crece rápidamente?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(25, 25));
						cuestionLabel.setSize(new Dimension(400, 40));
					}
				}
				break;
			}

			case 9:{
				// Parábola Doble Creciente II
				funcionRecomendada = 8;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 10:{
				if (siRadioButton.isSelected()){
					estado = 11;
					cuestionLabel.setText("Parábola doble creciente I");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(150, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 26;
						cuestionLabel.setText("Lo siento, función no disponible en el repertorio");
						noRadioButton.setVisible(false);
						siRadioButton.setVisible(false);
						siguienteButton.setText("Aceptar");
						cuestionLabel.setLocation(new Point(80, 33));
						cuestionLabel.setSize(new Dimension(350, 20));
					}
				}
				break;
			}

			case 11:{
				// Parábola Doble Creciente I
				funcionRecomendada = 6;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 12:{
				if (siRadioButton.isSelected()){
					estado = 14;
					cuestionLabel.setText("Recta decreciente");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(171, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 15;
						cuestionLabel.setText("Para valores pequeños de la magnitud, ¿decrece rápidamente" +"\n" +" el impacto?, "
								+"y para valores grandes ¿decrece lentamente?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(45, 25));
						cuestionLabel.setSize(new Dimension(375, 40));
					}
				}
				break;
			}

			case 13:{
				if (siRadioButton.isSelected()){
					estado = 23;
					cuestionLabel.setText("Máximo intermedio");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(170, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 24;
						cuestionLabel.setText("El impacto, ¿primero disminuye, alcanza" +"\n"
								+"un mínimo, y luego aumenta?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(120, 25));
						cuestionLabel.setSize(new Dimension(280, 40));
					}
				}
				break;
			}

			case 14:{
				// Recta decreciente
				funcionRecomendada = 1;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 15:{
				if (siRadioButton.isSelected()){
					estado = 16;
					cuestionLabel.setText("Parábola decreciente I");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(155, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 17;
						cuestionLabel.setText("Para valores pequeños de la magnitud, ¿decrece lentamente" +"\n" +" el impacto?, "
								+"y para valores grandes ¿decrece rápidamente?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(45, 25));
						cuestionLabel.setSize(new Dimension(375, 40));
					}
				}
				break;
			}

			case 16:{
				// Parábola decreciente I
				funcionRecomendada = 3;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 17:{
				if (siRadioButton.isSelected()){
					estado = 18;
					cuestionLabel.setText("Parábola decreciente II");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(155, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 19;
						cuestionLabel.setText("Para valores pequeños y grandes de la magnitud, ¿decrece lentamente" +"\n"
								+"el impacto?, y para valores intermedios ¿decrece rápidamente?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(17, 25));
						cuestionLabel.setSize(new Dimension(420, 40));
					}
				}
				break;
			}

			case 18:{
				// Parábola decreciente II
				funcionRecomendada = 5;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 19:{
				if (siRadioButton.isSelected()){
					estado = 20;
					cuestionLabel.setText("Parábola doble decreciente II");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(150, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 21;
						cuestionLabel.setText("Para valores pequeños y grandes de la magnitud, ¿decrece rápidamente" +"\n"
								+"el impacto?, y para valores intermedios ¿decrece lentamente?");
						noRadioButton.setSelected(false);
						cuestionLabel.setLocation(new Point(15, 25));
						cuestionLabel.setSize(new Dimension(420, 40));
					}
				}
				break;
			}

			case 20:{
				// Parábola doble decreciente II
				funcionRecomendada = 9;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 21:{
				if (siRadioButton.isSelected()){
					estado = 22;
					cuestionLabel.setText("Parábola doble decreciente I");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(150, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 26;
						cuestionLabel.setText("Lo siento, función no disponible en el repertorio");
						noRadioButton.setVisible(false);
						siRadioButton.setVisible(false);
						siguienteButton.setText("Aceptar");
						cuestionLabel.setLocation(new Point(80, 33));
						cuestionLabel.setSize(new Dimension(350, 20));
					}
				}
				break;
			}

			case 22:{
				// Parábola doble decreciente I
				funcionRecomendada = 7;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 23:{
				// Máximo intermedio
				funcionRecomendada = 10;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 24:{
				if (siRadioButton.isSelected()){
					estado = 25;
					cuestionLabel.setText("Mínimo intermedio");
					noRadioButton.setVisible(false);
					siRadioButton.setVisible(false);
					siguienteButton.setText("Aceptar");
					cuestionLabel.setLocation(new Point(170, 33));
					cuestionLabel.setSize(new Dimension(200, 20));
				}else{
					if (noRadioButton.isSelected()){
						estado = 26;
						cuestionLabel.setText("Lo siento, función no disponible en el repertorio");
						noRadioButton.setVisible(false);
						siRadioButton.setVisible(false);
						siguienteButton.setText("Aceptar");
						cuestionLabel.setLocation(new Point(80, 33));
						cuestionLabel.setSize(new Dimension(350, 20));
					}
				}
				break;
			}

			case 25:{
				// Mínimo intermedio
				funcionRecomendada = 11;
				flagAceptar = true;
				setVisible(false);
				break;
			}

			case 26:{
				setVisible(false);
				break;
			}
		}
	}

	public int getFuncionRecomendada() {
		return funcionRecomendada;
	}

	public boolean isFlagAceptar() {
		return flagAceptar;
	}

	private JButton getCancelarButton() {
		if (cancelarButton == null) {
			cancelarButton = new JButton();
			cancelarButton.setText("Cancelar");
			cancelarButton.setLocation(new Point(15, 130));
			cancelarButton.setSize(new Dimension(87, 18));
			cancelarButton.setBackground(Color.white);
			cancelarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return cancelarButton;
	}

	private JPanel getAsistentePanel() {
		if (asistentePanel == null) {
			cuestionLabel = new JTextArea();
			cuestionLabel.setLocation(new Point(52, 33));
			cuestionLabel.setSize(new Dimension(350, 20));
			cuestionLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			cuestionLabel.setText("¿Al aumentar el valor del indicador, ¿aumenta el impacto?");
			cuestionLabel.setBackground(new Color(240, 240, 240));
			cuestionLabel.setEditable(false);
			asistentePanel = new JPanel();
			asistentePanel.setLayout(null);
			asistentePanel.setBounds(new Rectangle(13, 13, 441, 102));
			asistentePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Función de transformación", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			asistentePanel.add(cuestionLabel, null);
			asistentePanel.add(getSiRadioButton(), null);
			asistentePanel.add(getNoRadioButton(), null);
		}
		return asistentePanel;
	}

	private JRadioButton getSiRadioButton() {
		if (siRadioButton == null) {
			siRadioButton = new JRadioButton();
			siRadioButton.setText("Si");
			siRadioButton.setLocation(new Point(175, 60));
			siRadioButton.setSize(new Dimension(40, 25));
			siRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					noRadioButton.setSelected(false);
				}
			});
		}
		return siRadioButton;
	}

	private JRadioButton getNoRadioButton() {
		if (noRadioButton == null) {
			noRadioButton = new JRadioButton();
			noRadioButton.setText("No");
			noRadioButton.setLocation(new Point(228, 60));
			noRadioButton.setSize(new Dimension(40, 25));
			noRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					siRadioButton.setSelected(false);
				}
			});
		}
		return noRadioButton;
	}
}
