package eia.vista;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JEditorPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class formAlternativa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel altDeRealizacionLabel = null;
	private JTextField altDeRealizcionTextField = null;
	private JPanel AccionesPanel = null;
	private JEditorPane jEditorPane = null;
	private JPanel factoresPanel = null;
	private JEditorPane factoresjEditorPane = null;
	private JButton AnadirButton = null;
	private JButton modificarButton = null;
	private JButton eliminarButton = null;
	private JTree accionesTree = null;
	private JTree factoresTree = null;
	private JButton crearEfectoButton = null;
	private JPanel efectossPanel = null;
	private JEditorPane efectosjEditorPane = null;
	private JScrollPane efectosScrollPane = null;
	private JTable efectosTable = null;
	/**
	 * This is the default constructor
	 */
	public formAlternativa() {
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
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			altDeRealizacionLabel = new JLabel();
			altDeRealizacionLabel.setText("Alternativa de realización:");
			altDeRealizacionLabel.setSize(new Dimension(149, 16));
			altDeRealizacionLabel.setLocation(new Point(12, 6));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(altDeRealizacionLabel, null);
			jContentPane.add(getAltDeRealizcionTextField(), null);
			jContentPane.add(getAccionesPanel(), null);
			jContentPane.add(getFactoresPanel(), null);
			jContentPane.add(getCrearEfectoButton(), null);
			jContentPane.add(getEfectossPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes altDeRealizcionTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getAltDeRealizcionTextField() {
		if (altDeRealizcionTextField == null) {
			altDeRealizcionTextField = new JTextField();
			altDeRealizcionTextField.setSize(new Dimension(315, 20));
			altDeRealizcionTextField.setLocation(new Point(163, 4));
		}
		return altDeRealizcionTextField;
	}

	/**
	 * This method initializes AccionesPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getAccionesPanel() {
		if (AccionesPanel == null) {
			AccionesPanel = new JPanel();
			AccionesPanel.setLayout(null);
			AccionesPanel.setLocation(new Point(13, 29));
			AccionesPanel.setSize(new Dimension(249, 200));
			AccionesPanel.add(getJEditorPane(), null);
			AccionesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acciones" +
					""));
			AccionesPanel.add(getAnadirButton(), null);
			AccionesPanel.add(getModificarButton(), null);
			AccionesPanel.add(getEliminarButton(), null);
			AccionesPanel.add(getAccionesTree(), null);
		}
		return AccionesPanel;
	}

	/**
	 * This method initializes jEditorPane
	 *
	 * @return javax.swing.JEditorPane
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setBounds(new Rectangle(13, 40, 24, 1));
		}
		return jEditorPane;
	}

	/**
	 * This method initializes factoresPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getFactoresPanel() {
		if (factoresPanel == null) {
			factoresPanel = new JPanel();
			factoresPanel.setLayout(null);
			factoresPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Factores", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			factoresPanel.setLocation(new Point(270, 30));
			factoresPanel.setSize(new Dimension(200, 200));
			factoresPanel.add(getFactoresjEditorPane(), null);
			factoresPanel.add(getFactoresTree(), null);
		}
		return factoresPanel;
	}

	/**
	 * This method initializes factoresjEditorPane
	 *
	 * @return javax.swing.JEditorPane
	 */
	private JEditorPane getFactoresjEditorPane() {
		if (factoresjEditorPane == null) {
			factoresjEditorPane = new JEditorPane();
			factoresjEditorPane.setBounds(new Rectangle(13, 40, 24, 1));
		}
		return factoresjEditorPane;
	}

	/**
	 * This method initializes AnadirButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAnadirButton() {
		if (AnadirButton == null) {
			AnadirButton = new JButton();
			AnadirButton.setBounds(new Rectangle(9, 170, 69, 20));
			AnadirButton.setPreferredSize(new Dimension(71, 26));
			AnadirButton.setFont(new Font("Dialog", Font.BOLD, 10));
			AnadirButton.setText("Añadir");
		}
		return AnadirButton;
	}

	/**
	 * This method initializes modificarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getModificarButton() {
		if (modificarButton == null) {
			modificarButton = new JButton();
			modificarButton.setBounds(new Rectangle(77, 170, 85, 20));
			modificarButton.setFont(new Font("Dialog", Font.BOLD, 10));
			modificarButton.setText("Modificar");
		}
		return modificarButton;
	}

	/**
	 * This method initializes eliminarButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getEliminarButton() {
		if (eliminarButton == null) {
			eliminarButton = new JButton();
			eliminarButton.setText("Eliminar");
			eliminarButton.setFont(new Font("Dialog", Font.BOLD, 10));
			eliminarButton.setBounds(new Rectangle(161, 170, 77, 20));
		}
		return eliminarButton;
	}
	/**
	 * This method initializes accionesTree
	 *
	 * @return javax.swing.JTree
	 */
	private JTree getAccionesTree() {
		if (accionesTree == null) {
			accionesTree = new JTree();
			accionesTree.setBounds(new Rectangle(13, 21, 222, 142));
		}
		return accionesTree;
	}

	/**
	 * This method initializes factoresTree
	 *
	 * @return javax.swing.JTree
	 */
	private JTree getFactoresTree() {
		if (factoresTree == null) {
			factoresTree = new JTree();
			factoresTree.setBounds(new Rectangle(9, 23, 183, 172));
		}
		return factoresTree;
	}

	/**
	 * This method initializes crearEfectoButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCrearEfectoButton() {
		if (crearEfectoButton == null) {
			crearEfectoButton = new JButton();
			crearEfectoButton.setBounds(new Rectangle(15, 235, 457, 19));
			crearEfectoButton.setText("Crear Efecto");
		}
		return crearEfectoButton;
	}

	/**
	 * This method initializes efectossPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getEfectossPanel() {
		if (efectossPanel == null) {
			efectossPanel = new JPanel();
			efectossPanel.setLayout(null);
			efectossPanel.setBounds(new Rectangle(16, 267, 455, 129));
			efectossPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Efectos", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			efectossPanel.add(getEfectosjEditorPane(), null);
			efectossPanel.add(getEfectosScrollPane(), null);
		}
		return efectossPanel;
	}

	/**
	 * This method initializes efectosjEditorPane
	 *
	 * @return javax.swing.JEditorPane
	 */
	private JEditorPane getEfectosjEditorPane() {
		if (efectosjEditorPane == null) {
			efectosjEditorPane = new JEditorPane();
			efectosjEditorPane.setBounds(new Rectangle(13, 40, 24, 1));
		}
		return efectosjEditorPane;
	}

	/**
	 * This method initializes efectosScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getEfectosScrollPane() {
		if (efectosScrollPane == null) {
			efectosScrollPane = new JScrollPane();
			efectosScrollPane.setBounds(new Rectangle(11, 17, 436, 107));
			efectosScrollPane.setViewportView(getEfectosTable());
		}
		return efectosScrollPane;
	}

	/**
	 * This method initializes efectosTable
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getEfectosTable() {
		if (efectosTable == null) {
			String[] columnas = {"Nombre","Juicio","Cualitativa","Cuantitativa","Total","Caracter"};
			Object[][] datos = {{"Paco1","","","","",""},
								{"Paco2","","","","",""},
								{"Paco3","","","","",""},
								{"Paco4","","","","",""},
								{"Paco5","","","","",""},
								{"Paco6","","","","",""}};
			efectosTable = new JTable(datos,columnas);
			efectosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			efectosTable.setShowVerticalLines(false);
			efectosTable.getTableHeader().setReorderingAllowed(false);
			TableColumnModel col = efectosTable.getColumnModel();
			col.getColumn(0).setResizable(false);
			col.getColumn(1).setResizable(false);
			col.getColumn(2).setResizable(false);
			col.getColumn(3).setResizable(false);
			col.getColumn(4).setResizable(false);
			col.getColumn(0).setPreferredWidth(200);
			col.getColumn(1).setPreferredWidth(60);
			col.getColumn(2).setPreferredWidth(80);
			col.getColumn(3).setPreferredWidth(90);
			col.getColumn(4).setPreferredWidth(50);
		}
		return efectosTable;
	}

	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				formAlternativa application = new formAlternativa();
				application.setVisible(true);
			}
		});
	}
}
