package challenges.year2025.day05;

import java.util.ArrayList;
import java.util.List;

public class IngredientList {
    List<IngredientRange> freshIngredients = new ArrayList<>();
    List<Ingredient> ingredients = new ArrayList<>();

    public IngredientList(List<String> input) {
        boolean isRange = true;
        for (String s : input) {
            if (s.isEmpty()) {
                isRange = false;
                continue;
            }
            if (isRange) {
                freshIngredients.add(IngredientRange.fromString(s));
            } else {
                ingredients.add(Ingredient.fromString(s));
            }
        }
    }

    public long getSumOfFreshIngredients() {
        return ingredients.stream().filter(this::isFresh).count();
    }

    private boolean isFresh(Ingredient ingredient) {
        return freshIngredients.stream().anyMatch(range->range.containsIngredient(ingredient));
    }

    public Long getSumOfAllPossibleFreshIngredients() {
        return mergeIngredientList(freshIngredients).stream().mapToLong(IngredientRange::getSumOfFreshIngredients).sum();
    }

    private List<IngredientRange> mergeIngredientList(List<IngredientRange> ingredientList) {
        while (true) {
            boolean newMerge = false;
            for (int i = 0; i < ingredientList.size() - 1; i++) {
                for (int j = i + 1; j < ingredientList.size(); j++) {
                    IngredientRange rangeA = ingredientList.get(i);
                    IngredientRange rangeB = ingredientList.get(j);
                    if (IngredientRange.haveOverlap(rangeA, rangeB)) {
                        ingredientList.removeAll(List.of(rangeA, rangeB));
                        ingredientList.add(rangeA.merge(rangeB));
                        newMerge = true;
                        break;
                    }
                }
            }
            if (!newMerge) {
                return ingredientList;
            }
        }
    }
}
