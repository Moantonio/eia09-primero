package eia.vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

public class formFactores extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel factoresPanel = null;
	private JScrollPane factoresScrollPane = null;
	private JTree factoresTree = null;
	private DefaultTreeModel modeloArbol = null;
	private DefaultMutableTreeNode abuelo = null;
	private DefaultTreeCellRenderer defaultTreeCellRenderer = null;
	// Arbol de factores
	private DefaultTreeModel factores;

	public formFactores(Frame owner, DefaultTreeModel factores) {
		super(owner);
		this.factores = factores;
		initialize();
	}

	private void initialize() {
		this.setSize(350, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("Factores ambientales");
		//TODO pintar el arbol de factores pasado en el cuadro
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getFactoresPanel(), null);
		}
		return jContentPane;
	}

	private JPanel getFactoresPanel() {
		if (factoresPanel == null) {
			factoresPanel = new JPanel();
			factoresPanel.setLayout(null);
			factoresPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Factores", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			factoresPanel.setSize(new Dimension(312, 435));
			factoresPanel.setLocation(new Point(15, 15));
			factoresPanel.add(getFactoresScrollPane(), null);
		}
		return factoresPanel;
	}

	private JScrollPane getFactoresScrollPane() {
		if (factoresScrollPane == null) {
			factoresScrollPane = new JScrollPane();
			factoresScrollPane.setSize(new Dimension(280, 391));
			factoresScrollPane.setLocation(new Point(16, 26));
			factoresScrollPane.setViewportView(getFactoresTree());
		}
		return factoresScrollPane;
	}

	private DefaultMutableTreeNode getAbuelo() {
		if (abuelo == null) {
			abuelo = new DefaultMutableTreeNode("Sistema físico natural");
		}
		return abuelo;
	}

	private DefaultTreeModel getModeloArbol() {
		if (modeloArbol == null) {
			modeloArbol = new DefaultTreeModel(getAbuelo());
		}
		return modeloArbol;
	}

	private JTree getFactoresTree() {
		if (factoresTree == null) {
			DefaultTreeSelectionModel defaultTreeSelectionModel = new DefaultTreeSelectionModel();
			defaultTreeSelectionModel.setSelectionMode(4);
			defaultTreeCellRenderer = new DefaultTreeCellRenderer();
			defaultTreeCellRenderer.setAutoscrolls(true);
			factoresTree = new JTree(getModeloArbol());
			factoresTree.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			factoresTree.setRootVisible(true);
			factoresTree.setShowsRootHandles(false);
			factoresTree.setToggleClickCount(2);
			factoresTree.setLocation(new Point(0, 0));
			factoresTree.setSelectionModel(defaultTreeSelectionModel);
			factoresTree.setCellRenderer(defaultTreeCellRenderer);
		}
		return factoresTree;
	}

}
