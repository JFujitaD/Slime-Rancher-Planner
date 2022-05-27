package menu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import components.Frame;
import models.Food;
import models.Slime;
import models.SlimeRancherRepository;

public class MenuBar extends JMenuBar {
	private final Font FONT = new Font("Arial", Font.PLAIN, 16);
	private Frame parent;
	
	public MenuBar(Frame parent) {
		this.parent = parent;
		
		JMenu addMenu = new JMenu("Add"); 
		JMenu slimeMenu = new JMenu("Slime");
		JMenu foodMenu = new JMenu("Food");
		JMenu removeMenu = new JMenu("Remove");
		JMenuItem removeSelected = new JMenuItem("Remove Selected");
		MenuActionListener actionListener = new MenuActionListener(this.parent);
		
		addMenu.setFont(FONT);
		removeMenu.setFont(FONT);
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
		
		removeSelected.addActionListener(actionListener);
		
		addMenu.add(slimeMenu);
		addMenu.add(foodMenu);
		removeMenu.add(removeSelected);
		this.add(addMenu);
		this.add(removeMenu);
	}
}
