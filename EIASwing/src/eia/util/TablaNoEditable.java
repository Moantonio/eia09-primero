package eia.util;

import javax.swing.table.DefaultTableModel;


public class TablaNoEditable extends DefaultTableModel

{
   
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
