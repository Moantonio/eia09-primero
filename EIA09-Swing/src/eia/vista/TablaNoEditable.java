package eia.vista;

import javax.swing.table.DefaultTableModel;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

public class TablaNoEditable extends DefaultTableModel{

	private static final long serialVersionUID = 1L;

	public boolean isCellEditable (int row, int column)
    {
		return false;
    }
}
