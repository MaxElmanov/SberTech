package todo.ui.button;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import javax.swing.JButton;

@Component
public class ActionListenerButton extends JButton implements InitializingBean {
    @Autowired
    private ActionListener actionListener;

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

////FOR XML
//    public void init() {
//        this.addActionListener(actionListener);
//    }

    public void afterPropertiesSet() throws Exception {
        this.addActionListener(actionListener);
    }
}