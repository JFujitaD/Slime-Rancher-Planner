import java.awt.Image;

import javax.swing.ImageIcon;

public class Food {
	private FoodType type;
	private String name;
	private Image image;
	
	public Food(FoodType type, String name, String imagePath) {
		this.type = type;
		this.name = name;
		this.image = new ImageIcon(imagePath).getImage();
	}
}
