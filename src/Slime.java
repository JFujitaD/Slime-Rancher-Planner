import java.awt.Image;

import javax.swing.ImageIcon;

public class Slime {
	private String name;
	private Food favoriteFood;
	private Image image;
	
	public Slime(String name, Food favoriteFood, String imagePath) {
		this.name = name;
		this.favoriteFood = favoriteFood;
		this.image = new ImageIcon(imagePath).getImage();
	}
}
