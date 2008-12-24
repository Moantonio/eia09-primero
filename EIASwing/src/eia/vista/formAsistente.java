package eia.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class formAsistente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton siguienteButton = null;
	private JButton cancelarButton = null;
	private JPanel asistentePanel = null;
	private JLabel cuestionLabel = null;
	private JRadioButton siRadioButton = null;
	private JRadioButton noRadioButton = null;

	//Estado en el que se encuentra el formulario
	private int estado = 0;
	//Función de transformación recomendada
	private int funcionRecomendada = 0;

	private boolean flagAceptar = false;

	public formAsistente(Frame owner) {
		super(owner);
		initialize();
	}

	private void initialize() {
		this.setSize(475, 197);
		this.setContentPane(getJContentPane());
		this.setTitle("Asistente de elección de función de transformación");
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
				}else{
					estado = 2;
					cuestionLabel.setText("Al aumentar el valor del indicador, ¿disminuye el impacto?");
					noRadioButton.setSelected(false);
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
					estado = 4;
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
			cuestionLabel = new JLabel();
			cuestionLabel.setLocation(new Point(52, 33));
			cuestionLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			cuestionLabel.setText("¿Al aumentar el valor del indicador, ¿aumenta el impacto?");
			cuestionLabel.setSize(new Dimension(341, 16));
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				formAsistente application = new formAsistente(null);
				application.getDialog().setVisible(true);
			}
		});
	}

	private JDialog getDialog() {
		return this;
	}
}
