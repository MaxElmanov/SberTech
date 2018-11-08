package todo.ui;

import org.springframework.beans.factory.InitializingBean;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@org.springframework.stereotype.Component
public class BoxLayoutPanel extends JPanel implements InitializingBean {

	private List panelComponents;
	private int axis;

	public void setAxis(int axis) {
		this.axis = axis;
	}

	public void setPanelComponents(List panelComponents) {
		this.panelComponents = panelComponents;
	}

/////	FOR XML
//	public void init() {
//
//		setLayout(new BoxLayout(this, axis));
//
//		for (Iterator iter = panelComponents.iterator(); iter.hasNext();) {
//			Component component = (Component) iter.next();
//			add(component);
//		}
//	}

	public void afterPropertiesSet() throws Exception {
		setLayout(new BoxLayout(this, axis));

		for (Iterator iter = panelComponents.iterator(); iter.hasNext();) {
			Component component = (Component) iter.next();
			add(component);
		}
	}
}