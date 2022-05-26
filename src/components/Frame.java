package components;
import java.awt.Toolkit;

import javax.swing.*;

import menu.MenuBar;



public class Frame extends JFrame {
	private Background background;
	
	public Frame() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		setJMenuBar(new MenuBar(this));
		background = new Background(this);
		add(background);
		
		setVisible(true);
	}
	
	public Background getBackgroundPanel() {
		return background;
	}

	public static void main(String[] args) {
		new Frame();
	}

}
