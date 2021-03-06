package menu;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import components.Panel;
import models.Displayable;

public class MenuItem extends JMenuItem {
	private static final Dimension MENU_ITEM_SIZE = new Dimension(300, 50);
	private static final Dimension IMAGE_SIZE = new Dimension(50, 50);
	
	public MenuItem(Displayable displayable, Font font) {
		setFont(font);
		setPreferredSize(MENU_ITEM_SIZE);
		setText(displayable.getName());
		add(new Panel(displayable, IMAGE_SIZE));
	}
}
