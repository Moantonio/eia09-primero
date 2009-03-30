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
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

import eia.modelo.Factor;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

public class FormFactores extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel factoresPanel = null;
	private JScrollPane factoresScrollPane = null;
	private JTree factoresTree = null;
	private DefaultMutableTreeNode abuelo = null;
	private DefaultTreeCellRenderer defaultTreeCellRenderer = null;
	private DefaultTreeModel factores;
	private JTextField pesoTextField = null;
	private JLabel pesoLabel = null;
	private JButton modificarButton = null;
	private JButton aceptarButton = null;
	private boolean modoModificar = false;

	public FormFactores(Frame owner, DefaultTreeModel factores, boolean modificar) {
		super(owner);
		this.modoModificar = modificar;
		this.factores = factores;
		initialize();
	}

	private void initialize() {
		this.setSize(350, 522);
		this.setContentPane(getJContentPane());
		this.setTitle("Factores ambientales");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".//images//text-x-generic-template.png"));
		this.setResizable(false);
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
			if(!modoModificar){
				pesoLabel.setBounds(new Rectangle(110, 426, 35, 14));
			}else{
				pesoLabel.setBounds(new Rectangle(25, 426, 35, 14));
			}
			pesoLabel.setText("Peso:");
			factoresPanel = new JPanel();
			factoresPanel.setLayout(null);
			factoresPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Factores", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			factoresPanel.setSize(new Dimension(312, 458));
			factoresPanel.setLocation(new Point(15, 15));
			factoresPanel.add(getFactoresScrollPane(), null);
			factoresPanel.add(getPesoTextField(), null);
			factoresPanel.add(pesoLabel, null);
			factoresPanel.add(getModificarButton(),null);
			factoresPanel.add(getAceptarButton(),null);
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
							if (nodo!=null){
								Factor factor = (Factor) nodo.getUserObject();
								if(nodo.getChildCount()!=0){
									mostrarPeso(0);
								}else{
									mostrarPeso(factor.getPeso());
								}
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
			pesoTextField.setEnabled(false);
			modificarButton.setEnabled(false);
			aceptarButton.setVisible(false);
		}else{
			pesoTextField.setText(String.valueOf(peso));
			pesoTextField.setEnabled(false);
			modificarButton.setEnabled(true);
			aceptarButton.setVisible(false);
		}
	}

	private JTextField getPesoTextField() {
		if (pesoTextField == null) {
			pesoTextField = new JTextField();
			if(!modoModificar){
				pesoTextField.setBounds(new Rectangle(150, 425, 50, 18));
			}else{
				pesoTextField.setBounds(new Rectangle(65, 425, 50, 18));
			}
			pesoTextField.setEnabled(false);
		}
		return pesoTextField;
	}

	private JButton getModificarButton() {
		if (modificarButton == null) {
			modificarButton = new JButton();
			modificarButton.setBounds(new Rectangle(120, 425, 87, 17));
			modificarButton.setText("Modificar");
			modificarButton.setEnabled(false);
			modificarButton.setBackground(Color.white);
			if(!modoModificar){
				modificarButton.setVisible(false);
			}
			modificarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aceptarButton.setVisible(true);
					pesoTextField.setEnabled(true);
					modificarButton.setEnabled(false);
				}
			});
		}
		return modificarButton;
	}

	private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton();
			aceptarButton.setText("Aceptar");
			aceptarButton.setLocation(new Point(210, 425));
			aceptarButton.setSize(new Dimension(80, 17));
			aceptarButton.setBackground(Color.white);
			aceptarButton.setVisible(false);
			aceptarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificarPeso();
				}
			});
		}
		return aceptarButton;
	}

	private void modificarPeso(){
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)factoresTree.getLastSelectedPathComponent();
		if (nodo!=null){
			Factor factor = (Factor) nodo.getUserObject();
			if(nodo.getChildCount()==0){
				int peso = 0;
				boolean error = false;
				try{
					peso = Integer.parseInt(pesoTextField.getText());
				}catch(Exception e){
					error = true;
					JOptionPane.showMessageDialog(this, "Valor de peso incorrecto. Sólo se permiten caracteres numéricos enteros.", "Error", JOptionPane.ERROR_MESSAGE);
				};
				if (!error){
					factor.setPeso(peso);
					aceptarButton.setVisible(false);
					pesoTextField.setEnabled(false);
					modificarButton.setEnabled(true);
				}
			}
		}
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
