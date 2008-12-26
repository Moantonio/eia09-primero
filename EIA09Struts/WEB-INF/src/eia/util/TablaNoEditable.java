package eia.util;

import javax.swing.table.DefaultTableModel;


public class TablaNoEditable extends DefaultTableModel

{

/**
	 *
	 */
	private static final long serialVersionUID = 1L;

/**
    * Todas las columnas son no editables
    * @param row
    * @param column
    * @return
    */
	public boolean isCellEditable (int row, int column)
    {
      return false;
    }
}
