package eia.util;

import java.awt.Color;
import java.awt.Component;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TablaColores extends JTable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public TablaColores(DefaultTableModel modeloTabla) {
		super(modeloTabla);
	}

	public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int colIndex) {
	    Component component = super.prepareRenderer(renderer, rowIndex, colIndex);



	    if((dataModel.getColumnName(4).equals("Total")&&
	       getValueAt(rowIndex,4).equals(""))||
	       (dataModel.getColumnName(1).equals("Valoración")&&
	       getValueAt(rowIndex,1).equals(""))){

	    	component.setForeground(Color.GREEN);
	    } else {
	        component.setForeground(Color.RED);
	    }

	    return component;
	}

}
