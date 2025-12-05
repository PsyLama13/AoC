package challenges.year2025.day05;

public record IngredientRange(Ingredient first, Ingredient last) {

    public static boolean haveOverlap(IngredientRange a, IngredientRange b) {
        return a.first.ingredientId() <= b.last.ingredientId()
                && b.first.ingredientId() <= a.last.ingredientId();
    }

    public static IngredientRange fromString(String s) {
        String[] arr = s.split("-");
        Ingredient first = new Ingredient(Long.parseLong(arr[0]));
        Ingredient last = new Ingredient(Long.parseLong(arr[1]));
        return new IngredientRange(first, last);
    }

    public boolean containsIngredient(Ingredient ingredient) {
        return ingredient.ingredientId() >= first.ingredientId() && ingredient.ingredientId() <= last.ingredientId();
    }

    public long getSumOfFreshIngredients() {
        return last.ingredientId() - first.ingredientId() + 1;
    }

    public IngredientRange merge(IngredientRange range) {
        Long newFirst = Math.min(this.first.ingredientId(), range.first.ingredientId());
        Long newLast = Math.max(this.last.ingredientId(), range.last.ingredientId());
        return new IngredientRange(new Ingredient(newFirst), new Ingredient(newLast));
    }
}