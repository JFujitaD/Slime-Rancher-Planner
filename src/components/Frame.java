package components;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import database.DatabaseManager;
import menu.MenuBar;



public class Frame extends JFrame {
	private Background background;
	
	public Frame() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		setJMenuBar(new MenuBar(this));
		background = new Background(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
			     System.out.println("Saving to database before exiting...");
			     
			     DatabaseManager dbManager = background.getDatabaseManager();
			     dbManager.saveToDatabase(background.getComponents());
			     background.getDatabaseManager().closeConnection();
			     System.exit(0);
			   }
		});
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
