import java.awt.Toolkit;

import javax.swing.*;

public class Frame extends JFrame {
	
	public Frame() {
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

		this.add(new Background(this));
	}
	
	public static void main(String[] args) {
		new Frame();
	}

}
