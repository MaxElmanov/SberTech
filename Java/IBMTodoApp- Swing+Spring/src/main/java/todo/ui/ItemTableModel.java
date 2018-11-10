package todo.ui;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@Component
public class ItemTableModel extends AbstractTableModel implements InitializingBean {

	private List itemList;

	public int getRowCount() {
		return itemList.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return itemList.get(rowIndex);
	}
	public int getColumnCount() {
		return 1;
	}

	public void setItemList(List itemList) {
		this.itemList = itemList;
	}

	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		itemList.set(rowIndex, value);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public String getColumnName(int column) {
		return "Items";
	}

	public void afterPropertiesSet() throws Exception {
		for (int i = 0; i < 3; i++){
			itemList.add(i+1);
		}
	}
}