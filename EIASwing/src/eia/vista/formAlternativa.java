package eia.vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import eia.model.Accion;
import eia.model.Alternativa;
import eia.model.Efecto;
import eia.model.Factor;
import eia.util.Arbol;
import eia.util.TablaNoEditable;
import eia.util.ValorJuicio;

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
	private JPanel factoresPanel = null;
	private JButton AnadirButton = null;
	private JButton modificarButton = null;
	private JButton eliminarButton = null;
	private JTree accionesTree = null;
	private JTree factoresTree = null;
	private JButton crearEfectoButton = null;
	private JPanel efectossPanel = null;
	private JScrollPane efectosScrollPane = null;
	private TablaNoEditable modeloTabla = new TablaNoEditable();
	private JTable efectosTable = null;
	private JButton editarEfectosButton = null;
	private JButton eliminarEfectosButton = null;
	private JLabel valoracionLabel = null;
	private JTextField valoracionTextField = null;
	private JButton aceptarButton = null;
	private JButton cancelarButton = null;
	private JPanel valoracionPanel = null;
	private JScrollPane factoresScrollPane = null;
	private JScrollPane accionesScrollPane = null;
	private boolean flagAceptar = false;

	//TODO Esto deberian ser el arbol de acciones y el de Factores de alternativa
	private DefaultTreeModel modeloArbol1 = null;
	private DefaultTreeModel modeloArbol2 = null;

	//Variables del modelo
	private Alternativa alternativa;
	private Arbol<Factor> factores;

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
			AccionesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acciones" +
					""));
			AccionesPanel.add(getAnadirButton(), null);
			AccionesPanel.add(getModificarButton(), null);
			AccionesPanel.add(getEliminarButton(), null);
			AccionesPanel.add(getAccionesScrollPane(), null);
		}
		return AccionesPanel;
	}

	private JPanel getFactoresPanel() {
		if (factoresPanel == null) {
			factoresPanel = new JPanel();
			factoresPanel.setLayout(null);
			factoresPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Factores", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			factoresPanel.setLocation(new Point(263, 29));
			factoresPanel.setSize(new Dimension(207, 186));
			factoresPanel.add(getFactoresScrollPane(), null);
		}
		return factoresPanel;
	}

	private JButton getAnadirButton() {
		if (AnadirButton == null) {
			AnadirButton = new JButton();
			AnadirButton.setBounds(new Rectangle(9, 160, 69, 20));
			AnadirButton.setPreferredSize(new Dimension(71, 26));
			AnadirButton.setFont(new Font("Dialog", Font.BOLD, 10));
			AnadirButton.setText("Añadir");
			AnadirButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!accionesTree.isSelectionEmpty()){
						// TODO Formulario que meta el nombre de la accion
						// añadir la accion real al arbol de acciones
						//creo q deberia ser un arbol del tipo DefaultMutableTreeNode
						String nombreAccion = "Paco";
						DefaultMutableTreeNode nuevo=new DefaultMutableTreeNode(nombreAccion);
						DefaultMutableTreeNode padre = (DefaultMutableTreeNode)accionesTree.getLastSelectedPathComponent();

						modeloArbol1.insertNodeInto(nuevo,padre, 0);

					}

				}
			});
		}
		return AnadirButton;
	}

	private JButton getModificarButton() {
		if (modificarButton == null) {
			modificarButton = new JButton();
			modificarButton.setBounds(new Rectangle(77, 160, 85, 20));
			modificarButton.setFont(new Font("Dialog", Font.BOLD, 10));
			modificarButton.setText("Modificar");
			modificarButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!accionesTree.isSelectionEmpty()){
						// TODO Auto-generated Event stub actionPerformed()

					}

				}
			});

		}
		return modificarButton;
	}

	private JButton getEliminarButton() {
		if (eliminarButton == null) {
			eliminarButton = new JButton();
			eliminarButton.setText("Eliminar");
			eliminarButton.setFont(new Font("Dialog", Font.BOLD, 10));
			eliminarButton.setBounds(new Rectangle(161, 160, 77, 20));
			eliminarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!accionesTree.isSelectionEmpty()){
						int seleccion = JOptionPane.showConfirmDialog (null,
								"¿Está seguro que desea eliminar esta acción?",
								"Eliminar acción",
								JOptionPane.YES_NO_OPTION);
						if (seleccion==JOptionPane.YES_OPTION){
						//TODO eliminar de la alternativa la acción seleccionada
							DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)accionesTree.getLastSelectedPathComponent();
							modeloArbol1.removeNodeFromParent(nodo);
						}
					}
				}
			});
		}
		return eliminarButton;
	}

	private JTree getAccionesTree() {
		if (accionesTree == null) {
			DefaultTreeSelectionModel defaultTreeSelectionModel = new DefaultTreeSelectionModel();
			defaultTreeSelectionModel.setSelectionMode(4);
			DefaultTreeCellRenderer defaultTreeCellRenderer = new DefaultTreeCellRenderer();
			defaultTreeCellRenderer.setAutoscrolls(true);

			DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode("Acciones");
			DefaultMutableTreeNode padre = new DefaultMutableTreeNode("Fase Construcción");
			DefaultMutableTreeNode tio = new DefaultMutableTreeNode("Fase Matenimiento");
			DefaultMutableTreeNode hijo1=new DefaultMutableTreeNode("Limpieza");
			DefaultMutableTreeNode nieto11=new DefaultMutableTreeNode("Calidad del aire");
			DefaultMutableTreeNode nieto12=new DefaultMutableTreeNode("Nivel sonoro");
			DefaultMutableTreeNode hijo2=new DefaultMutableTreeNode("Caminos");
			DefaultMutableTreeNode nieto21=new DefaultMutableTreeNode("Relieve");
			DefaultMutableTreeNode nieto22=new DefaultMutableTreeNode("Recursos culturales");


			modeloArbol1 = new DefaultTreeModel(abuelo);
			modeloArbol1.insertNodeInto(padre,abuelo,0);
			modeloArbol1.insertNodeInto(tio, abuelo, 1);
			modeloArbol1.insertNodeInto(hijo1, padre, 0);
			modeloArbol1.insertNodeInto(nieto11, hijo1, 0);
			modeloArbol1.insertNodeInto(nieto12, hijo1, 0);
			modeloArbol1.insertNodeInto(hijo2, padre, 1);
			modeloArbol1.insertNodeInto(nieto21, hijo2, 0);
			modeloArbol1.insertNodeInto(nieto22, hijo2, 0);

			accionesTree = new JTree(modeloArbol1);
		}
		return accionesTree;
	}

	private JTree getFactoresTree() {
		if (factoresTree == null) {
			DefaultTreeSelectionModel defaultTreeSelectionModel = new DefaultTreeSelectionModel();
			defaultTreeSelectionModel.setSelectionMode(4);
			DefaultTreeCellRenderer defaultTreeCellRenderer = new DefaultTreeCellRenderer();
			defaultTreeCellRenderer.setAutoscrolls(true);

			DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode("Sistema físico natural");
			DefaultMutableTreeNode padre = new DefaultMutableTreeNode("Medio Abiótico");
			DefaultMutableTreeNode tio = new DefaultMutableTreeNode("Medio Biótico");
			DefaultMutableTreeNode hijo1=new DefaultMutableTreeNode("Aire");
			DefaultMutableTreeNode nieto11=new DefaultMutableTreeNode("Calidad del aire");
			DefaultMutableTreeNode nieto12=new DefaultMutableTreeNode("Nivel sonoro");
			DefaultMutableTreeNode hijo2=new DefaultMutableTreeNode("Geológia, Geomorfía");
			DefaultMutableTreeNode nieto21=new DefaultMutableTreeNode("Relieve");
			DefaultMutableTreeNode nieto22=new DefaultMutableTreeNode("Recursos culturales");

			modeloArbol2 = new DefaultTreeModel(abuelo);
			modeloArbol2.insertNodeInto(padre,abuelo,0);
			modeloArbol2.insertNodeInto(tio, abuelo, 1);
			modeloArbol2.insertNodeInto(hijo1, padre, 0);
			modeloArbol2.insertNodeInto(nieto11, hijo1, 0);
			modeloArbol2.insertNodeInto(nieto12, hijo1, 0);
			modeloArbol2.insertNodeInto(hijo2, padre, 1);
			modeloArbol2.insertNodeInto(nieto21, hijo2, 0);
			modeloArbol2.insertNodeInto(nieto22, hijo2, 0);

			factoresTree = new JTree(modeloArbol2);
			factoresTree.setRootVisible(true);
			factoresTree.setShowsRootHandles(false);
			factoresTree.setToggleClickCount(2);
			factoresTree.setCellRenderer(defaultTreeCellRenderer);
			factoresTree.setSelectionModel(defaultTreeSelectionModel);
			factoresTree.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return factoresTree;
	}

	private JButton getCrearEfectoButton() {
		if (crearEfectoButton == null) {
			crearEfectoButton = new JButton();
			crearEfectoButton.setText("Crear Efecto");
			crearEfectoButton.setSize(new Dimension(458, 20));
			crearEfectoButton.setLocation(new Point(13, 219));
			crearEfectoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearEfecto();
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
			efectossPanel.add(getEfectosScrollPane(), null);
			efectossPanel.add(getEditarEfectosButton(), null);
			efectossPanel.add(getEliminarEfectosButton(), null);
		}
		return efectossPanel;
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
			efectosTable = new JTable(modeloTabla);
			modeloTabla.addColumn("Nombre");
			modeloTabla.addColumn("Juicio");
			modeloTabla.addColumn("Cualitativa");
			modeloTabla.addColumn("Cuantitativa");
			modeloTabla.addColumn("Total");
			modeloTabla.addColumn("Caracter");

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

			//ejemplo
			String[] datos1 = {"Paco1","","","","",""};
			String[] datos2 = {"Paco2","","","","",""};
			String[] datos3 = {"Paco3","","","","",""};
			modeloTabla.addRow(datos1);
			modeloTabla.addRow(datos2);
			modeloTabla.addRow(datos3);

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
					eliminarEfecto();
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

	private JScrollPane getFactoresScrollPane() {
		if (factoresScrollPane == null) {
			factoresScrollPane = new JScrollPane();
			factoresScrollPane.setBounds(new Rectangle(7, 18, 191, 163));
			factoresScrollPane.setViewportView(getFactoresTree());
		}
		return factoresScrollPane;
	}

	private JScrollPane getAccionesScrollPane() {
		if (accionesScrollPane == null) {
			accionesScrollPane = new JScrollPane();
			accionesScrollPane.setBounds(new Rectangle(7, 17, 233, 141));
			accionesScrollPane.setViewportView(getAccionesTree());
		}
		return accionesScrollPane;
	}

	private void crearEfecto(){
		if (!accionesTree.isSelectionEmpty()&&
				!factoresTree.isSelectionEmpty()&&
				modeloArbol1.isLeaf(accionesTree.getLastSelectedPathComponent())&&
				modeloArbol2.isLeaf(factoresTree.getLastSelectedPathComponent())){
				//si hay alguna acción y algun factor seleccionados
				//y la acción y el factor son hojas de sus árboles
				Accion accion = alternativa.getAcciones().buscarElemento(accionesTree.getLastSelectedPathComponent().toString());
				Factor factor = factores.buscarElemento(factoresTree.getLastSelectedPathComponent().toString());
				formCrearEfecto formNuevoEfecto = new formCrearEfecto(accion.getId(), factor.getId());
				Point posActual = getDialog().getLocation();
				posActual.translate(20, 20);
				formNuevoEfecto.setLocation(posActual);
				formNuevoEfecto.setModal(true);
				formNuevoEfecto.setVisible(true);
				if (formNuevoEfecto.isFlagAceptar()){
					// Creamos un nuevo efecto
					String id = formNuevoEfecto.getNombre();
					String descripcion = formNuevoEfecto.getDescripcion();
					Efecto efecto = new Efecto(accion, factor, id, descripcion);
					// Seteamos el simple enjuiciamiento
					ValorJuicio juicio = formNuevoEfecto.getEnjuiciamiento();
					efecto.setJuicio(juicio);
					// Lo añadimos a la alternativa
					alternativa.getEfectos().add(efecto);
				}
				formNuevoEfecto.dispose();
			}
	}

	private void eliminarEfecto(){
		int indice = efectosTable.getSelectedRow();
		if (indice != -1){
			int seleccion = JOptionPane.showConfirmDialog (null,
					"¿Está seguro que desea eliminar esta alternativa?",
					"Eliminar alternativa",
					JOptionPane.YES_NO_OPTION);
			if (seleccion==JOptionPane.YES_OPTION){
			    // elimina el efecto de la tabla
				modeloTabla.removeRow(indice);
				// eliminamos el efecto de la alternativa
				alternativa.getEfectos().remove(indice);
			}
		}
	}

	//TODO A eliminar en un futuro
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Alternativa alt = new Alternativa("AlternativaPrueba");
				formAlternativa application = new formAlternativa(alt);
				application.getDialog().setVisible(true);
			}
		});
	}

}  //  @jve:decl-index=0:visual-constraint="4,11"
