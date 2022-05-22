import java.util.ArrayList;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	public MenuBar() {
		JMenu menu = new JMenu("Add");
		JMenu slimeMenu = new JMenu("Slime");
		JMenu foodMenu = new JMenu("Food");
		MenuActionListener actionListener = new MenuActionListener();
		
		ArrayList<Slime> slimeList = SlimeRancherRepository.getSlimes();
		for(Slime slime : slimeList) {
			slimeMenu.add(new JMenuItem(slime.getName()));
		}
		
		ArrayList<Food> foodList = SlimeRancherRepository.getFood();
		for(Food food : foodList) {
			if(food.getName().equals("ALL") || food.getName().equals("NULL"))
				continue;
			foodMenu.add(new JMenuItem(food.getName()));
		}
		
		menu.add(slimeMenu);
		menu.add(foodMenu);
		this.add(menu);
	}
}
