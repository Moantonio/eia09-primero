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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class FormAcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel datosPanel = null;
	private JLabel logoLabel = null;
	private JLabel gplLabel = null;
	private JLabel nombreLabel = null;
	private JLabel versionLabel = null;
	private JLabel licenciaLabel = null;
	private JLabel autor1Label = null;
	private JLabel autor2Label = null;
	private JLabel autor3Label = null;
	private JLabel urlLabel = null;
	private JButton okButton = null;

	/**
	 * @author SI: EIA'09
	 * 		   Vicente Cruz Mínguez.
	 *         Enrique Gallego Martín.
	 *         Luis González de Paula.
	 */

	public FormAcercaDe(Frame owner) {
		super(owner);
		initialize();
	}

	private void initialize() {
		this.setSize(400, 225);
		this.setTitle("Acerca de EIA09");
		this.setContentPane(getJContentPane());
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			autor3Label = new JLabel();
			autor3Label.setText("Luis González de Paula");
			autor3Label.setLocation(new Point(30, 121));
			autor3Label.setSize(new Dimension(139, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getDatosPanel(), null);
			jContentPane.add(getOkButton(), null);
		}
		return jContentPane;
	}

	private JPanel getDatosPanel() {
		if (datosPanel == null) {
			urlLabel = new JLabel();
			urlLabel.setText("http://www.fdi.ucm.es/profesor/lgarmend/EIA09");
			urlLabel.setLocation(new Point(30, 139));
			urlLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			urlLabel.setSize(new Dimension(282, 16));
			autor2Label = new JLabel();
			autor2Label.setText("Enrique Gallego Martín");
			autor2Label.setBounds(new Rectangle(30, 103, 135, 16));
			autor1Label = new JLabel();
			autor1Label.setText("Vicente Cruz Mínguez");
			autor1Label.setLocation(new Point(30, 85));
			autor1Label.setSize(new Dimension(133, 16));
			licenciaLabel = new JLabel();
			licenciaLabel.setText("GNU General Public License - GPLv3");
			licenciaLabel.setLocation(new Point(120, 59));
			licenciaLabel.setSize(new Dimension(212, 16));
			versionLabel = new JLabel();
			versionLabel.setText("Versión: 1.0");
			versionLabel.setLocation(new Point(120, 43));
			versionLabel.setSize(new Dimension(72, 16));
			nombreLabel = new JLabel();
			nombreLabel.setFont(new Font("Dialog", Font.BOLD, 20));
			nombreLabel.setSize(new Dimension(57, 19));
			nombreLabel.setLocation(new Point(120, 20));
			nombreLabel.setText("EIA09");
			ImageIcon logo = new ImageIcon(".//images//logo.png");
			logoLabel = new JLabel(logo);
			logoLabel.setBounds(new Rectangle(6, 9, 88, 70));
			ImageIcon gpl = new ImageIcon(".//images//gpl.png");
			gplLabel = new JLabel(gpl);
			gplLabel.setSize(new Dimension(63, 23));
			gplLabel.setLocation(new Point(325, 133));
			datosPanel = new JPanel();
			datosPanel.setLayout(null);
			datosPanel.setBackground(Color.WHITE);
			datosPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			datosPanel.setLocation(new Point(0, 0));
			datosPanel.setSize(new Dimension(395, 162));
			datosPanel.add(logoLabel);
			datosPanel.add(gplLabel);
			datosPanel.add(nombreLabel, null);
			datosPanel.add(versionLabel, null);
			datosPanel.add(licenciaLabel, null);
			datosPanel.add(autor1Label, null);
			datosPanel.add(autor2Label, null);
			datosPanel.add(autor3Label, null);
			datosPanel.add(urlLabel, null);
		}
		return datosPanel;
	}

	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setLocation(new Point(300, 167));
			okButton.setText("Aceptar");
			okButton.setSize(new Dimension(80, 18));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});

		}
		return okButton;
	}

}
