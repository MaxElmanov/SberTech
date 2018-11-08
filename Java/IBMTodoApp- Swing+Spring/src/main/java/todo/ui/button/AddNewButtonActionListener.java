package todo.ui.button;

import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;

@Component
public class AddNewButtonActionListener extends ListTableActionListener {

	public void actionPerformed(ActionEvent e) {
		list.add("New Item");
		table.revalidate();
	}

}