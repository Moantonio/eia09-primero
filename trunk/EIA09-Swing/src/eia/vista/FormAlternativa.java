package eia.vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
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
import eia.util.ValorJuicio;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

public class FormAlternativa extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel altDeRealizacionLabel = null;
	private JTextField altDeRealizcionTextField = null;
	private JPanel AccionesPanel = null;
	private JPanel factoresPanel = null;
	private JButton AnadirButton = null;
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
	private JButton valorarButton = null;

	//Variables del modelo
	private Alternativa alternativa;
	private DefaultTreeModel factores;

	public FormAlternativa(Alternativa alt, DefaultTreeModel fact) {
		super();
		alternativa = alt;
		factores = fact;
		initialize();
	}

	public FormAlternativa(Frame owner, Alternativa alt,DefaultTreeModel fact) {
		super(owner);
		alternativa = alt;
		factores = fact;
		initialize();
	}

	private void initialize() {
		this.setSize(598, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("Alternativas de realización");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//edit-copy.png"));
		this.setResizable(false);
		actualizarVista();
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
			altDeRealizacionLabel.setLocation(new Point(62, 9));
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

	private JButton getValorarButton() {
		if (valorarButton == null) {
			valorarButton = new JButton();
			valorarButton.setBounds(new Rectangle(300, 6, 80, 18));
			valorarButton.setPreferredSize(new Dimension(71, 26));
			valorarButton.setFont(new Font("Dialog", Font.BOLD, 10));
			valorarButton.setText("Valorar");
			valorarButton.setBackground(Color.white);
			valorarButton.setEnabled(false);
			valorarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					valorarAlternativa();
				}
			});
		}
		return valorarButton;
	}

	private JTextField getAltDeRealizcionTextField() {
		if (altDeRealizcionTextField == null) {
			altDeRealizcionTextField = new JTextField();
			altDeRealizcionTextField.setSize(new Dimension(307, 20));
			altDeRealizcionTextField.setLocation(new Point(213, 7));
			altDeRealizcionTextField.setEnabled(false);
			altDeRealizcionTextField.setText(alternativa.getId());
		}
		return altDeRealizcionTextField;
	}

	private JPanel getAccionesPanel() {
		if (AccionesPanel == null) {
			AccionesPanel = new JPanel();
			AccionesPanel.setLayout(null);
			AccionesPanel.setLocation(new Point(16, 29));
			AccionesPanel.setSize(new Dimension(280, 186));
			AccionesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acciones" +
					""));
			AccionesPanel.add(getAnadirButton(), null);
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
			factoresPanel.setLocation(new Point(294, 29));
			factoresPanel.setSize(new Dimension(282, 186));
			factoresPanel.add(getFactoresScrollPane(), null);
		}
		return factoresPanel;
	}

	private JButton getAnadirButton() {
		if (AnadirButton == null) {
			AnadirButton = new JButton();
			AnadirButton.setBounds(new Rectangle(10, 160, 131, 20));
			AnadirButton.setPreferredSize(new Dimension(71, 26));
			AnadirButton.setFont(new Font("Dialog", Font.BOLD, 10));
			AnadirButton.setText("Añadir");
			AnadirButton.setBackground(Color.white);
			AnadirButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!accionesTree.isSelectionEmpty()){
						anadirAccion();
					}
				}
			});
		}
		return AnadirButton;
	}

	private JButton getEliminarButton() {
		if (eliminarButton == null) {
			eliminarButton = new JButton();
			eliminarButton.setText("Eliminar");
			eliminarButton.setFont(new Font("Dialog", Font.BOLD, 10));
			eliminarButton.setBackground(Color.white);
			eliminarButton.setBounds(new Rectangle(140, 160, 131, 20));
			eliminarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!accionesTree.isSelectionEmpty()){
						eliminarAccion();
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
			accionesTree = new JTree(alternativa.getAcciones());
		}
		return accionesTree;
	}

	private JTree getFactoresTree() {
		if (factoresTree == null) {
			DefaultTreeSelectionModel defaultTreeSelectionModel = new DefaultTreeSelectionModel();
			defaultTreeSelectionModel.setSelectionMode(4);
			DefaultTreeCellRenderer defaultTreeCellRenderer = new DefaultTreeCellRenderer();
			defaultTreeCellRenderer.setAutoscrolls(true);


			factoresTree = new JTree(factores);
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
			crearEfectoButton.setSize(new Dimension(557, 20));
			crearEfectoButton.setLocation(new Point(17, 219));
			crearEfectoButton.setBackground(Color.white);
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
			efectossPanel.setBounds(new Rectangle(13, 239, 565, 153));
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
			efectosScrollPane.setBounds(new Rectangle(10, 17, 545, 107));
			efectosScrollPane.setViewportView(getEfectosTable());
		}
		return efectosScrollPane;
	}

	private JTable getEfectosTable() {
		if (efectosTable == null) {
			efectosTable = new TablaColores(modeloTabla);
			modeloTabla.addColumn("Nombre");
			modeloTabla.addColumn("Juicio");
			modeloTabla.addColumn("Cualitativa");
			modeloTabla.addColumn("Cuantitativa");
			modeloTabla.addColumn("Total");
			modeloTabla.addColumn("Caracter");

			efectosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			efectosTable.setLocation(new Point(2, 20));
			efectosTable.setSize(new Dimension(550, 80));
			efectosTable.setShowVerticalLines(false);
			efectosTable.getTableHeader().setReorderingAllowed(false);
			TableColumnModel col = efectosTable.getColumnModel();
			col.getColumn(0).setResizable(false);
			col.getColumn(1).setResizable(false);
			col.getColumn(2).setResizable(false);
			col.getColumn(3).setResizable(false);
			col.getColumn(4).setResizable(false);
			col.getColumn(0).setPreferredWidth(140);
			col.getColumn(1).setPreferredWidth(90);
			col.getColumn(2).setPreferredWidth(80);
			col.getColumn(3).setPreferredWidth(80);
			col.getColumn(4).setPreferredWidth(40);
		}
		return efectosTable;
	}

	private JButton getEditarEfectosButton() {
		if (editarEfectosButton == null) {
			editarEfectosButton = new JButton();
			editarEfectosButton.setText("Editar");
			editarEfectosButton.setSize(new Dimension(275, 20));
			editarEfectosButton.setLocation(new Point(11, 126));
			editarEfectosButton.setBackground(Color.white);
			editarEfectosButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = efectosTable.getSelectedRow();
					if (indice != -1){
						Efecto efecto = alternativa.getEfectos().get(indice);
						editarEfecto(efecto,indice);
					}
				}
			});
		}
		return editarEfectosButton;
	}

	private JButton getEliminarEfectosButton() {
		if (eliminarEfectosButton == null) {
			eliminarEfectosButton = new JButton();
			eliminarEfectosButton.setText("Eliminar");
			eliminarEfectosButton.setBackground(Color.white);
			eliminarEfectosButton.setSize(new Dimension(267, 20));
			eliminarEfectosButton.setLocation(new Point(285, 126));
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
			valoracionTextField.setBounds(new Rectangle(156, 4, 105, 23));
		}
		return valoracionTextField;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setText("Aceptar");
			aceptarButton.setSize(new Dimension(90, 20));
			aceptarButton.setPreferredSize(new Dimension(80, 26));
			aceptarButton.setLocation(new Point(200, 435));
			aceptarButton.setBackground(Color.white);
			aceptarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					flagAceptar = true;
					setVisible(false);
					alternativa.setId(altDeRealizcionTextField.getText());
				}
			});
		}
		return aceptarButton;
	}

	private JButton getCancelarButton() {
		if (cancelarButton == null) {
			cancelarButton = new JButton();
			cancelarButton.setText("Cancelar");
			cancelarButton.setBackground(Color.white);
			cancelarButton.setSize(new Dimension(90, 20));
			cancelarButton.setLocation(new Point(300, 435));
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
			valoracionPanel.setBounds(new Rectangle(95, 393, 400, 31));
			valoracionPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
			valoracionPanel.add(getValoracionTextField(), null);
			valoracionPanel.add(valoracionLabel, null);
			valoracionPanel.add(getValorarButton(), null);
		}
		return valoracionPanel;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	private JScrollPane getFactoresScrollPane() {
		if (factoresScrollPane == null) {
			factoresScrollPane = new JScrollPane();
			factoresScrollPane.setBounds(new Rectangle(7, 18, 270, 163));
			factoresScrollPane.setViewportView(getFactoresTree());
		}
		return factoresScrollPane;
	}

	private JScrollPane getAccionesScrollPane() {
		if (accionesScrollPane == null) {
			accionesScrollPane = new JScrollPane();
			accionesScrollPane.setBounds(new Rectangle(7, 18, 268, 141));
			accionesScrollPane.setViewportView(getAccionesTree());
		}
		return accionesScrollPane;
	}

	private void crearEfecto(){
		if (!accionesTree.isSelectionEmpty()&&
				!factoresTree.isSelectionEmpty()&&
				alternativa.getAcciones().isLeaf(accionesTree.getLastSelectedPathComponent())&&
				factores.isLeaf(factoresTree.getLastSelectedPathComponent())){
				Accion accion = (Accion)((DefaultMutableTreeNode)accionesTree.getLastSelectedPathComponent()).getUserObject();
				Factor factor = (Factor)((DefaultMutableTreeNode)factoresTree.getLastSelectedPathComponent()).getUserObject();
				FormCrearEfecto formNuevoEfecto = new FormCrearEfecto(accion.getId(), factor.getId());
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
				    // Lo añadimos a la tabla
					String cualitativa = "No";
					String cuantitativa = "No";
					String total = "No";
					String caracter = "No";
					if (juicio==ValorJuicio.significativo){
							cualitativa = "";
							cuantitativa = "";
							total = "";
							caracter = "";
					}
					String[] datos = {id,juicio.toString(),cualitativa,cuantitativa,total,caracter};
					modeloTabla.addRow(datos);
					valorarButton.setEnabled(false);
					valoracionTextField.setText("");
					alternativa.setValorada(false);
					// Comprobamos si todos los efectos están valorados
					if(comprobarValorados()){
						valorarButton.setEnabled(true);
						if (alternativa.getValorada())
							valoracionTextField.setText(String.valueOf(alternativa.getValorTotal()));
					}
				}
				formNuevoEfecto.dispose();
			}
	}

	private void eliminarEfecto(){
		int indice = efectosTable.getSelectedRow();
		if (indice != -1){
			int seleccion = JOptionPane.showConfirmDialog (null,
					"¿Está seguro que desea eliminar este efecto?",
					"Eliminar efecto",
					JOptionPane.YES_NO_OPTION);
			if (seleccion==JOptionPane.YES_OPTION){
			    // Elimina el efecto de la tabla
				modeloTabla.removeRow(indice);
				// Eliminamos el efecto de la alternativa
				alternativa.getEfectos().remove(indice);
				// Comprobamos si todos los efectos están valorados
				alternativa.setValorada(false);
				valoracionTextField.setText("");
				if(comprobarValorados()){
					valorarButton.setEnabled(true);
				}
			}
		}
	}

	private void editarEfecto(Efecto efecto,int indice) {
		FormEfecto editarEfecto = new FormEfecto((Efecto)efecto.clone());
		Point posActual = getDialog().getLocation();
		posActual.translate(20, 20);
		editarEfecto.setLocation(posActual);
		editarEfecto.setModal(true);
		editarEfecto.setVisible(true);
		if (editarEfecto.isFlagAceptar()){
			// Seteamos los cambios cogiendo el clon
			efecto.setValCualitativa(editarEfecto.getEfecto().getValCualitativa());
			efecto.setValCuantitativa(editarEfecto.getEfecto().getValCuantitativa());
			efecto.setValorTotal(editarEfecto.getEfecto().getValorTotal());
			efecto.setJuicio(editarEfecto.getEfecto().getJuicio());
			efecto.setCaracter(editarEfecto.getEfecto().getCaracter());

			modeloTabla.setValueAt(efecto.getJuicio(), indice, 1);
			if((efecto.getJuicio()==ValorJuicio.significativo)){
				if ((efecto.getValCualitativa()!= null)){
					modeloTabla.setValueAt(efecto.getValCualitativa().getIncidencia(), indice, 2);
				}else{
					modeloTabla.setValueAt("", indice, 2);
				}

				if ((efecto.getValCuantitativa()!= null)){
					modeloTabla.setValueAt(efecto.getValCuantitativa().getMagnitudImpacto(), indice, 3);
				}else{
					modeloTabla.setValueAt("", indice, 3);
				}

				if ((efecto.getValCualitativa()!= null)&&(efecto.getValCuantitativa()!= null)){
					modeloTabla.setValueAt(efecto.getValorTotal(), indice, 4);
					modeloTabla.setValueAt(efecto.getCaracter(), indice, 5);
				}else{
					modeloTabla.setValueAt("", indice, 4);
					modeloTabla.setValueAt("", indice, 5);
				}

			}else{
				modeloTabla.setValueAt("No", indice, 2);
				modeloTabla.setValueAt("No", indice, 3);
				modeloTabla.setValueAt("No", indice, 4);
				modeloTabla.setValueAt("No", indice, 5);
			}

			alternativa.setValorada(false);
			valoracionTextField.setText(" ");
			valorarButton.setEnabled(false);
			// Comprobamos si todos los efectos están valorados
			if(comprobarValorados()){
				valorarButton.setEnabled(true);
				if (alternativa.getValorada())
					valoracionTextField.setText(String.valueOf(alternativa.getValorTotal()));
			}
		}
		editarEfecto.dispose();
	}

	private void eliminarAccion(){
		int seleccion = JOptionPane.showConfirmDialog (null,
				"¿Está seguro que desea eliminar esta acción?",
				"Eliminar acción",
				JOptionPane.YES_NO_OPTION);
		if (seleccion==JOptionPane.YES_OPTION){
			// Eliminamos de la tabla
			DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)accionesTree.getLastSelectedPathComponent();
			Accion accion = (Accion) nodo.getUserObject();
			alternativa.getAcciones().removeNodeFromParent(nodo);
			//Eliminamos los efectos que tengan esa acción
			eliminarEfectos(accion);
		}
	}

	private void eliminarEfectos(Accion accion) {
		// Recorremos la lista de efectos
		for (int i=0;i<alternativa.getEfectos().size();i++){
			Efecto efecto = alternativa.getEfectos().get(i);
			// Si el efecto tiene la acción lo eliminamos
			if(efecto.getAccion() == accion){
			    // Elimina el efecto de la tabla
				modeloTabla.removeRow(i);
				// Eliminamos el efecto de la alternativa
				alternativa.getEfectos().remove(i);
				i--;
			}
		}
	}

	private void anadirAccion(){
		DefaultMutableTreeNode padre = (DefaultMutableTreeNode)accionesTree.getLastSelectedPathComponent();
		FormCrearAccion formNuevaAccion = new FormCrearAccion(null, padre.toString());
		Point posActual = getDialog().getLocation();
		posActual.translate(20, 20);
		formNuevaAccion.setLocation(posActual);
		formNuevaAccion.setModal(true);
		formNuevaAccion.setVisible(true);
		if(formNuevaAccion.isFlagAceptar()){

			// Insertamos en la tabla y en el arbol
			Accion accion = new Accion(formNuevaAccion.getNombreAccion());
			DefaultMutableTreeNode nuevo = new DefaultMutableTreeNode(accion);
			alternativa.getAcciones().insertNodeInto(nuevo,padre,0);
		}
		formNuevaAccion.dispose();
	}

	private void valorarAlternativa() {
		alternativa.setValorada(true);
		alternativa.calcularValorTotal();
		valoracionTextField.setText(String.valueOf(alternativa.getValorTotal()));
	}

	private boolean comprobarValorados(){
		// Comprobamos si todos los efecto están valorados
		int i = 0;
		int size = alternativa.getEfectos().size();
		boolean valorados = true;
		if (size>0){
			while (valorados&&i<size)
			{
				Efecto efecto = alternativa.getEfectos().get(i);

				// Si un efecto significativo no se ha valorado
				if ((efecto.getJuicio()==ValorJuicio.significativo)&&((efecto.getValCualitativa()==null || efecto.getValCuantitativa()==null))){
					valorados = false;
				}
				i++;
			}
		}else{
			valorados = false;
		}
		return valorados;
	}

	private void actualizarVista(){
		for(int i=0;i<alternativa.getEfectos().size();i++){
			// Mostramos la información del efecto
			Efecto efecto = alternativa.getEfectos().get(i);
			String id = efecto.getId();
			String juicio = efecto.getJuicio().toString();

			String cualitativa = "No";
			String cuantitativa = "No";
			String total = "No";
			String caracter = "No";
			if (efecto.getJuicio()==ValorJuicio.significativo){
				if (efecto.getValCualitativa()!=null){
					cualitativa = String.valueOf(efecto.getValCualitativa().getIncidencia());
				}else{
					cualitativa = "";
				}

				if (efecto.getValCuantitativa()!=null){
					cuantitativa = String.valueOf(efecto.getValCuantitativa().getMagnitudImpacto());
				}else{
					cuantitativa = "";
				}

				if((efecto.getValCualitativa()!=null&&efecto.getValCuantitativa()!=null)){
					total = String.valueOf(efecto.getValorTotal());
					caracter = efecto.getCaracter().toString();
				} else {
					total = "";
					caracter = "";
				}
			}
			String[] datos = {id,juicio,cualitativa,cuantitativa,total,caracter};
			modeloTabla.addRow(datos);
		}

		alternativa.setValorada(false);
		valoracionTextField.setText(" ");
		valorarButton.setEnabled(false);
		// Comprobamos si todos los efectos están valorados
		if(comprobarValorados()){
			valorarButton.setEnabled(true);
			if (alternativa.getValorada())
				valoracionTextField.setText(String.valueOf(alternativa.getValorTotal()));
		}
	}

}  //  @jve:decl-index=0:visual-constraint="4,11"
