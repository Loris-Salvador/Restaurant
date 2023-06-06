package Model;

import javax.swing.table.AbstractTableModel;

public class DetailCommandeTableModel extends AbstractTableModel {
    private String[] columnNames = {"Colonne 1", "Colonne 2", "Colonne 3"}; // Remplacez les noms de colonnes par vos propres noms
    private Object[][] data; // Remplacez le tableau d'objets par vos propres données

    public DetailCommandeTableModel(Object[][] data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
