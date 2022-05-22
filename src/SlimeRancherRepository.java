import java.util.ArrayList;

public class SlimeRancherRepository {
	private static ArrayList<Slime> slimes = new ArrayList<>();
	private static ArrayList<Food> food = new ArrayList<>();
	
	static {
		food.add(new Food(FoodType.VEGGIES, "Carrot", "resources/food/carrot.png"));
		
		slimes.add(new Slime("Pink Slime", food.get(0), "resources/slimes/pink_slime.png"));
	}
}
