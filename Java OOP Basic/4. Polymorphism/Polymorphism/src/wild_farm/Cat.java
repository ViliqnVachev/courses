package wild_farm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private static final String INVALID_FOOD_FOR_ANIMAL = "Cats are not eating that type of food!";

    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    protected String makeSound() {
        return "Meowwww";
    }

    @Override
    protected void eat(Food food, int quantity) {
        if ((super.getAnimalType().equals("Zebra") || super.getAnimalType().equals("Mouse")) && food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException(INVALID_FOOD_FOR_ANIMAL);
        } else if ((super.getAnimalType().equals("Tiger")) && food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException(INVALID_FOOD_FOR_ANIMAL);
        }
        super.setFoodEaten(super.getFoodEaten() + quantity);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(), this.breed, df.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}
