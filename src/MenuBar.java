import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	private final Font FONT = new Font("Arial", Font.PLAIN, 16);
	
	public MenuBar() {		
		JMenu menu = new JMenu("Add");
		JMenu slimeMenu = new JMenu("Slime");
		JMenu foodMenu = new JMenu("Food");
		MenuActionListener actionListener = new MenuActionListener();
		
		menu.setFont(FONT);
		slimeMenu.setFont(FONT);
		foodMenu.setFont(FONT);
		
		ArrayList<Slime> slimeList = SlimeRancherRepository.getSlimes();
		for(Slime slime : slimeList) {
			slimeMenu.add(new MenuItem(slime, FONT));
		}
		
		ArrayList<Food> foodList = SlimeRancherRepository.getFood();
		for(Food food : foodList) {
			if(food.getName().equals("ALL") || food.getName().equals("NULL"))
				continue;
			foodMenu.add(new MenuItem(food, FONT));
		}
		
		menu.add(slimeMenu);
		menu.add(foodMenu);
		this.add(menu);
	}
}
