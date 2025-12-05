package challenges.year2025.day05;

public record Ingredient(Long ingredientId) {
    public static Ingredient fromString(String s) {
        return new Ingredient(Long.parseLong(s));
    }
}