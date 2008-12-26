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

	    if((rowIndex%2) == 0){
	    	component.setBackground(Color.GREEN);
	    } else {
	        component.setBackground(Color.RED);
	    }
	    return component;
	}

}
