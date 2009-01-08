package eia.vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

import eia.model.Factor;

public class formFactores extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel factoresPanel = null;
	private JScrollPane factoresScrollPane = null;
	private JTree factoresTree = null;
	private DefaultMutableTreeNode abuelo = null;
	private DefaultTreeCellRenderer defaultTreeCellRenderer = null;
	// Arbol de factores
	private DefaultTreeModel factores;
	private JTextField pesoTextField = null;
	private JLabel pesoLabel = null;

	public formFactores(Frame owner, DefaultTreeModel factores) {
		super(owner);
		this.factores = factores;
		initialize();
	}

	private void initialize() {
		this.setSize(350, 522);
		this.setContentPane(getJContentPane());
		this.setTitle("Factores ambientales");
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
			pesoLabel = new JLabel();
			pesoLabel.setBounds(new Rectangle(110, 426, 35, 14));
			pesoLabel.setText("Peso:");
			factoresPanel = new JPanel();
			factoresPanel.setLayout(null);
			factoresPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Factores", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			factoresPanel.setSize(new Dimension(312, 458));
			factoresPanel.setLocation(new Point(15, 15));
			factoresPanel.add(getFactoresScrollPane(), null);
			factoresPanel.add(getPesoTextField(), null);
			factoresPanel.add(pesoLabel, null);
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
		if (factores == null) {
			factores = new DefaultTreeModel(getAbuelo());
		}
		return factores;
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
			factoresTree
					.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
						public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
							DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)factoresTree.getLastSelectedPathComponent();
							Factor factor = (Factor) nodo.getUserObject();
							if(nodo.getChildCount()!=0){
								mostrarPeso(0);
							}else{
								mostrarPeso(factor.getPeso());
							}
						}
					});
		}
		return factoresTree;
	}

	private void mostrarPeso(int peso)
	{
		if(peso==0){
			pesoTextField.setText("");
		}else{
			pesoTextField.setText(String.valueOf(peso));
		}
	}

	private JTextField getPesoTextField() {
		if (pesoTextField == null) {
			pesoTextField = new JTextField();
			pesoTextField.setBounds(new Rectangle(150, 425, 50, 18));
			pesoTextField.setEnabled(false);
		}
		return pesoTextField;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
