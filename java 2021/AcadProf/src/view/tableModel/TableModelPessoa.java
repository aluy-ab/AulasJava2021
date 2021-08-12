package view.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Model;
import model.ModelPessoa;

public class TableModelPessoa extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private String headers[] = { "Id", "Nome" };
	private ArrayList<Model> array = new ArrayList<Model>();
	
	public void setArray (ArrayList<Model> array) {
		this.array = array;
		fireTableDataChanged();
	}
	
	public Model getModel ( int row ) {
		return this.array.get( row );
	}

	@Override
	public String getColumnName(int column) {
		return headers[column];
	}
		
	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public int getRowCount() {
		return array.size();
	}

	@Override
	public Object getValueAt(int row, int column ) {
		ModelPessoa pessoa = (ModelPessoa)array.get(row);
		switch (column) {
		case 0: return "<html><font color='red'>" + pessoa.getIdpessoa() + "</font></html>";
		case 1: return pessoa.getNome();
		}
		return null;
	}

}
