package models;
import java.util.ArrayList;

public class SlimeRancherRepository {
	private static ArrayList<Slime> slimes = new ArrayList<>();
	private static ArrayList<Food> food = new ArrayList<>();
	
	static {
		food.add(new Food(FoodType.VEGGIES, "Carrot", "resources/food/carrot.png"));
		food.add(new Food(FoodType.VEGGIES, "Heart Beet", "resources/food/heart_beet.png"));
		food.add(new Food(FoodType.VEGGIES, "Oca Oca", "resources/food/oca_oca.png"));
		food.add(new Food(FoodType.VEGGIES, "Odd Onion", "resources/food/odd_onion.png"));
		food.add(new Food(FoodType.VEGGIES, "Silver Parsnip", "resources/food/silver_parsnip.png"));
		
		food.add(new Food(FoodType.FRUIT, "Pogofruit", "resources/food/pogofruit.png"));
		food.add(new Food(FoodType.FRUIT, "Cuberry", "resources/food/cuberry.png"));
		food.add(new Food(FoodType.FRUIT, "Mint Mango", "resources/food/mint_mango.png"));
		food.add(new Food(FoodType.FRUIT, "Phase Lemon", "resources/food/phase_lemon.png"));
		food.add(new Food(FoodType.FRUIT, "Prickle Pear", "resources/food/prickle_pear.png"));
		
		food.add(new Food(FoodType.MEAT, "Hen Hen", "resources/food/hen_hen.png"));
		food.add(new Food(FoodType.MEAT, "Stony Hen", "resources/food/stony_hen.png"));
		food.add(new Food(FoodType.MEAT, "Briar Hen", "resources/food/briar_hen.png"));
		food.add(new Food(FoodType.MEAT, "Painted Hen", "resources/food/painted_hen.png"));
		
		food.add(new Food(FoodType.NULL, "ALL", "resources/food/all.png"));
		food.add(new Food(FoodType.NULL, "NULL", "resources/food/null.png"));
		
		slimes.add(new Slime("Pink Slime", getFoodByName("ALL"), "resources/slimes/pink_slime.png"));
		slimes.add(new Slime("Tabby Slime", getFoodByName("Stony Hen"), "resources/slimes/tabby_slime.png"));
		slimes.add(new Slime("Phosphor Slime", getFoodByName("Cuberry"), "resources/slimes/phosphor_slime.png"));
		slimes.add(new Slime("Honey Slime", getFoodByName("Mint Mango"), "resources/slimes/honey_slime.png"));
		slimes.add(new Slime("Puddle Slime", getFoodByName("NULL"), "resources/slimes/puddle_slime.png"));
		slimes.add(new Slime("Hunter Slime", getFoodByName("NULL"), "resources/slimes/hunter_slime.png"));
		slimes.add(new Slime("Quantum Slime", getFoodByName("Phase Lemon"), "resources/slimes/quantum_slime.png"));
		slimes.add(new Slime("Dervish Slime", getFoodByName("Prickle Pear"), "resources/slimes/dervish_slime.png"));
		slimes.add(new Slime("Tangle Slime", getFoodByName("Painted Hen"), "resources/slimes/tangle_slime.png"));
		slimes.add(new Slime("Saber Slime", getFoodByName("NULL"), "resources/slimes/saber_slime.png"));
		slimes.add(new Slime("Rock Slime", getFoodByName("Heart Beet"), "resources/slimes/rock_slime.png"));
		slimes.add(new Slime("Rad Slime", getFoodByName("Oca Oca"), "resources/slimes/rad_slime.png"));
		slimes.add(new Slime("Boom Slime", getFoodByName("Briar Hen"), "resources/slimes/boom_slime.png"));
		slimes.add(new Slime("Crystal Slime", getFoodByName("Odd Onion"), "resources/slimes/crystal_slime.png"));
		slimes.add(new Slime("Fire Slime", getFoodByName("NULL"), "resources/slimes/fire_slime.png"));
		slimes.add(new Slime("Mosaic Slime", getFoodByName("Silver Parsnip"), "resources/slimes/mosaic_slime.png"));
	}
		
	public static Food getFoodByName(String name) {
		for(Food f : food) {
			if(f.getName().equals(name))
				return f;
		}
		return null;
	}
	
	public static Slime getSlimeByName(String name) {
		for(Slime s : slimes) {
			if(s.getName().equals(name))
					return s;
		}
		return null;
	}
	
	public static Displayable getSlimeOrFood(String name) {
		Slime slime = getSlimeByName(name);
		Food food = getFoodByName(name);
		
		if(slime != null)
			return slime;
		if(food != null)
			return food;
		return null;
	}
	
	public static ArrayList<Slime> getSlimes() {
		return slimes;
	}
	
	public static ArrayList<Food> getFood() {
		return food;
	}
}
