package menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import components.Background;
import components.Frame;
import components.Panel;
import models.Displayable;
import models.Food;
import models.Slime;
import models.SlimeRancherRepository;

public class MenuActionListener implements ActionListener {
	private Frame parent;
	
	public MenuActionListener(Frame parent) {
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem) e.getSource();
		String text = menuItem.getText();
		
		addPanelWithName(text);
	}
	
	private void addPanelWithName(String name) {
		Background background = parent.getBackgroundPanel();
		
		Displayable slimeOrFood = SlimeRancherRepository.getSlimeOrFood(name);
		background.add(new Panel(slimeOrFood));
		background.getDatabaseManager().saveToDatabase(background.getComponents());
		parent.repaint();
		
	}
}
