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
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

import eia.model.Accion;
import eia.model.Alternativa;
import eia.model.Efecto;
import eia.model.Factor;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */
public class formAlternativa extends JDialog{

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
	private JButton editarEfectosButton = null;
	private JButton eliminarEfectosButton = null;
	private JLabel valoracionLabel = null;
	private JTextField valoracionTextField = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
	private JPanel valoracionPanel = null;

	//Variables del modelo
	private Alternativa alternativa;
	private boolean flagAceptar = false;

	public formAlternativa(Alternativa alt) {
		super();
		alternativa = alt;
		initialize();
	}

	public formAlternativa(Frame owner, Alternativa alt) {
		super(owner);
		alternativa = alt;
		initialize();
	}

	private void initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("Alternativas de realización");
	}

	private JDialog getDialog() {
		return this;
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			valoracionLabel = new JLabel();
			valoracionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			valoracionLabel.setBounds(new Rectangle(9, 3, 138, 25));
			valoracionLabel.setText(" Valoración Total:");
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
			jContentPane.add(getAceptarButton(), null);
			jContentPane.add(getCancelarButton(), null);
			jContentPane.add(getValoracionPanel(), null);
		}
		return jContentPane;
	}

	private JTextField getAltDeRealizcionTextField() {
		if (altDeRealizcionTextField == null) {
			altDeRealizcionTextField = new JTextField();
			altDeRealizcionTextField.setSize(new Dimension(307, 20));
			altDeRealizcionTextField.setLocation(new Point(163, 4));
			altDeRealizcionTextField.setText(alternativa.getId());
		}
		return altDeRealizcionTextField;
	}

	private JPanel getAccionesPanel() {
		if (AccionesPanel == null) {
			AccionesPanel = new JPanel();
			AccionesPanel.setLayout(null);
			AccionesPanel.setLocation(new Point(13, 29));
			AccionesPanel.setSize(new Dimension(249, 186));
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

	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setBounds(new Rectangle(13, 40, 24, 1));
		}
		return jEditorPane;
	}

	private JPanel getFactoresPanel() {
		if (factoresPanel == null) {
			factoresPanel = new JPanel();
			factoresPanel.setLayout(null);
			factoresPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Factores", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			factoresPanel.setLocation(new Point(270, 30));
			factoresPanel.setSize(new Dimension(200, 185));
			factoresPanel.add(getFactoresjEditorPane(), null);
			factoresPanel.add(getFactoresTree(), null);
		}
		return factoresPanel;
	}

	private JEditorPane getFactoresjEditorPane() {
		if (factoresjEditorPane == null) {
			factoresjEditorPane = new JEditorPane();
			factoresjEditorPane.setBounds(new Rectangle(13, 40, 24, 1));
		}
		return factoresjEditorPane;
	}

	private JButton getAnadirButton() {
		if (AnadirButton == null) {
			AnadirButton = new JButton();
			AnadirButton.setBounds(new Rectangle(9, 160, 69, 20));
			AnadirButton.setPreferredSize(new Dimension(71, 26));
			AnadirButton.setFont(new Font("Dialog", Font.BOLD, 10));
			AnadirButton.setText("Añadir");
		}
		return AnadirButton;
	}

	private JButton getModificarButton() {
		if (modificarButton == null) {
			modificarButton = new JButton();
			modificarButton.setBounds(new Rectangle(77, 160, 85, 20));
			modificarButton.setFont(new Font("Dialog", Font.BOLD, 10));
			modificarButton.setText("Modificar");
		}
		return modificarButton;
	}

	private JButton getEliminarButton() {
		if (eliminarButton == null) {
			eliminarButton = new JButton();
			eliminarButton.setText("Eliminar");
			eliminarButton.setFont(new Font("Dialog", Font.BOLD, 10));
			eliminarButton.setBounds(new Rectangle(161, 160, 77, 20));
		}
		return eliminarButton;
	}

	private JTree getAccionesTree() {
		if (accionesTree == null) {
			accionesTree = new JTree();
			accionesTree.setBounds(new Rectangle(13, 21, 222, 136));
		}
		return accionesTree;
	}

	private JTree getFactoresTree() {
		if (factoresTree == null) {
			factoresTree = new JTree();
			factoresTree.setBounds(new Rectangle(9, 23, 183, 157));
		}
		return factoresTree;
	}

	private JButton getCrearEfectoButton() {
		if (crearEfectoButton == null) {
			crearEfectoButton = new JButton();
			crearEfectoButton.setText("Crear Efecto");
			crearEfectoButton.setSize(new Dimension(458, 20));
			crearEfectoButton.setLocation(new Point(12, 217));
			crearEfectoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO accion tiene que ser la seleccionada
					Accion accion = null;
					//TODO factor tiene que ser la seleccionada
					Factor factor = null;
					formCrearEfecto formNuevoEfecto = new formCrearEfecto(accion.getId(), factor.getId());
					Point posActual = getDialog().getLocation();
					posActual.translate(20, 20);
					formNuevoEfecto.setLocation(posActual);
					formNuevoEfecto.setModal(true);
					formNuevoEfecto.setVisible(true);
				}
			});
		}
		return crearEfectoButton;
	}

	private JPanel getEfectossPanel() {
		if (efectossPanel == null) {
			efectossPanel = new JPanel();
			efectossPanel.setLayout(null);
			efectossPanel.setBounds(new Rectangle(13, 239, 457, 150));
			efectossPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Efectos", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			efectossPanel.add(getEfectosjEditorPane(), null);
			efectossPanel.add(getEfectosScrollPane(), null);
			efectossPanel.add(getEditarEfectosButton(), null);
			efectossPanel.add(getEliminarEfectosButton(), null);
		}
		return efectossPanel;
	}

	private JEditorPane getEfectosjEditorPane() {
		if (efectosjEditorPane == null) {
			efectosjEditorPane = new JEditorPane();
			efectosjEditorPane.setBounds(new Rectangle(13, 40, 24, 1));
		}
		return efectosjEditorPane;
	}

	private JScrollPane getEfectosScrollPane() {
		if (efectosScrollPane == null) {
			efectosScrollPane = new JScrollPane();
			efectosScrollPane.setBounds(new Rectangle(11, 17, 436, 107));
			efectosScrollPane.setViewportView(getEfectosTable());
		}
		return efectosScrollPane;
	}

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
			//efectosTable = new JTable();
			efectosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			efectosTable.setLocation(new Point(2, 20));
			efectosTable.setSize(new Dimension(434, 80));
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

	private JButton getEditarEfectosButton() {
		if (editarEfectosButton == null) {
			editarEfectosButton = new JButton();
			editarEfectosButton.setText("Editar");
			editarEfectosButton.setSize(new Dimension(217, 20));
			editarEfectosButton.setLocation(new Point(11, 126));
			editarEfectosButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO efecto, tiene que ser el seleccionado
					Efecto efecto = null;
					formEfecto editarEfecto = new formEfecto(efecto);
					Point posActual = getDialog().getLocation();
					posActual.translate(20, 20);
					editarEfecto.setLocation(posActual);
					editarEfecto.setModal(true);
					editarEfecto.setVisible(true);
				}
			});
		}
		return editarEfectosButton;
	}

	private JButton getEliminarEfectosButton() {
		if (eliminarEfectosButton == null) {
			eliminarEfectosButton = new JButton();
			eliminarEfectosButton.setText("Eliminar");
			eliminarEfectosButton.setSize(new Dimension(217, 20));
			eliminarEfectosButton.setLocation(new Point(227, 126));
			eliminarEfectosButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Ventana de confirmar eliminar
				}
			});
		}
		return eliminarEfectosButton;
	}

	public boolean isFlagAceptar() {
		return flagAceptar;
	}

	private JTextField getValoracionTextField() {
		if (valoracionTextField == null) {
			valoracionTextField = new JTextField();
			valoracionTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
			valoracionTextField.setEnabled(false);
			valoracionTextField.setBounds(new Rectangle(156, 4, 105, 25));
		}
		return valoracionTextField;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setText("Aceptar");
			aceptarButton.setSize(new Dimension(90, 20));
			aceptarButton.setPreferredSize(new Dimension(80, 26));
			aceptarButton.setLocation(new Point(278, 435));
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
			cancelarButton.setText("Cancelar");
			cancelarButton.setSize(new Dimension(90, 20));
			cancelarButton.setLocation(new Point(375, 435));
			cancelarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return cancelarButton;
	}

	private JPanel getValoracionPanel() {
		if (valoracionPanel == null) {
			valoracionPanel = new JPanel();
			valoracionPanel.setLayout(null);
			valoracionPanel.setBounds(new Rectangle(90, 393, 267, 31));
			valoracionPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
			valoracionPanel.add(getValoracionTextField(), null);
			valoracionPanel.add(valoracionLabel, null);
		}
		return valoracionPanel;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}
}
