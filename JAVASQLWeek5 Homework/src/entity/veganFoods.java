package entity;

public class veganFoods {
	
	private int foodId;
	private String name;
	private String taste;
	private String texture;
	
	public veganFoods(int foodId, String name, String taste, String texture) {
		this.setFoodId(foodId);
		this.setName(name);
		this.setTaste(taste);
		this.setTexture(texture);
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}
}