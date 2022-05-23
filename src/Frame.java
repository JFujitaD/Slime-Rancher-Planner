import java.awt.Toolkit;

import javax.swing.*;

public class Frame extends JFrame {
	private static Background background;
	
	public Frame() {
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setJMenuBar(new MenuBar(this));
		background = new Background(this);
		this.add(background);
		
		this.setVisible(true);
	}
	
	public static Background getBackgroundPanel() {
		return background;
	}

	public static void main(String[] args) {
		new Frame();
	}

}
