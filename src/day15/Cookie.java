package day15;

public class Cookie {

    public int capacity, durability, flavor, texture, calories;

    public Cookie() {
    }

    public Cookie(Cookie cookie) {
        this.capacity = cookie.capacity;
        this.durability = cookie.durability;
        this.flavor = cookie.flavor;
        this.texture = cookie.texture;
        this.calories = cookie.calories;
    }

    public void addIngredient(Ingredient ingredient, int factor) {
        capacity += factor * ingredient.getCapacity();
        durability += factor * ingredient.getDurability();
        flavor += factor * ingredient.getFlavor();
        texture += factor * ingredient.getTexture();
        calories += factor * ingredient.getCalories();
    }

    public int getScore() {
        return (Math.max(capacity, 0)) * (Math.max(durability, 0)) * (Math.max(flavor, 0)) * (Math.max(texture, 0));
    }
}
