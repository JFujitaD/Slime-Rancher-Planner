package menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import components.Frame;
import components.Panel;
import models.Food;
import models.Slime;
import models.SlimeRancherRepository;

public class MenuActionListener implements ActionListener {
	private JFrame parent;
	
	public MenuActionListener(JFrame parent) {
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem) e.getSource();
		String text = menuItem.getText();
		
		addPanelWithName(text);
	}
	
	private void addPanelWithName(String name) {
		Slime slime = SlimeRancherRepository.getSlimeByName(name);
		Food food = SlimeRancherRepository.getFoodByName(name);
		
		if(slime != null) {
			Frame.getBackgroundPanel().add(new Panel(slime));
			System.out.println("Adding Slime");
		} else if(food != null) {
			Frame.getBackgroundPanel().add(new Panel(food));
			System.out.println("Adding Food");
		} else {
			System.err.println("Slime or Food not found.");
		}
		parent.repaint();
	}
}
