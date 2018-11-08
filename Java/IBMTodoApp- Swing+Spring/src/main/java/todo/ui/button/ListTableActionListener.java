package todo.ui.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

@Component
public abstract class ListTableActionListener implements ActionListener {

	@Autowired
	protected JTable table;
	@Autowired
	protected List list;

	@Required
	public void setList(List list) {
		this.list = list;
	}

	@Required
	public void setTable(JTable itemTable) {
		this.table = itemTable;
	}

}