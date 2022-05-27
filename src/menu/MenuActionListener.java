package menu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
		System.out.println(text);
		
		if(text.equals("Selected")) {
			Panel selectedPanel = parent.getBackgroundPanel().getSelectedPanel();
			if(selectedPanel != null) {
				int response = JOptionPane.showConfirmDialog(parent, "Remove the item?");
				if(response == 0) {
					// TODO remove selected panel from parent/background.
					Component[] components = parent.getBackgroundPanel().getComponents();
					String panelName = selectedPanel.getName();
					Background background = parent.getBackgroundPanel();
					
					for(Component c : components) {
						Panel p = (Panel) c;
						if(p.getName().equals(panelName)) {
							background.remove(c);
							background.setSelectedPanel(null);
							background.repaint();
							return;
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(parent.getBackgroundPanel(), "Please select the item that you want to remove.");
			}
		} else {
			addPanelWithName(text);
		}
	}
	
	private void addPanelWithName(String name) {
		Background background = parent.getBackgroundPanel();
		
		Displayable slimeOrFood = SlimeRancherRepository.getSlimeOrFood(name);
		background.add(new Panel(slimeOrFood));
		background.getDatabaseManager().saveToDatabase(background.getComponents());
		parent.repaint();
		
	}
}
