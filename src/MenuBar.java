import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	private final Font FONT = new Font("Arial", Font.PLAIN, 16);
	private JFrame parent;
	
	public MenuBar(JFrame parent) {
		this.parent = parent;
		
		JMenu menu = new JMenu("Add");
		JMenu slimeMenu = new JMenu("Slime");
		JMenu foodMenu = new JMenu("Food");
		MenuActionListener actionListener = new MenuActionListener(this.parent);
		
		menu.setFont(FONT);
		slimeMenu.setFont(FONT);
		foodMenu.setFont(FONT);
		
		ArrayList<Slime> slimeList = SlimeRancherRepository.getSlimes();
		for(Slime slime : slimeList) {
			MenuItem menuItem = new MenuItem(slime, FONT);
			menuItem.addActionListener(actionListener);
			slimeMenu.add(menuItem);
		}
		
		ArrayList<Food> foodList = SlimeRancherRepository.getFood();
		for(Food food : foodList) {
			if(food.getName().equals("ALL") || food.getName().equals("NULL"))
				continue;
			MenuItem menuItem = new MenuItem(food, FONT);
			menuItem.addActionListener(actionListener);
			foodMenu.add(menuItem);
		}
		
		menu.add(slimeMenu);
		menu.add(foodMenu);
		this.add(menu);
	}
}
