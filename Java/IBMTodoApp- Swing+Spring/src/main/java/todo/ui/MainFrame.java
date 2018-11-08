package todo.ui;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@Component
public class MainFrame extends JFrame implements InitializingBean {

	//FOR XML
//	public void init() {
//		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//		setSize(new Dimension(600, 400));
//
//		setVisible(true);
//		setState(Frame.NORMAL);
//		show();
//	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public MainFrame myFrame_1(){
		return new MainFrame();
	}

	public void afterPropertiesSet() throws Exception {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(new Dimension(600, 400));

		setVisible(true);
		setState(Frame.NORMAL);
		show();
	}
}