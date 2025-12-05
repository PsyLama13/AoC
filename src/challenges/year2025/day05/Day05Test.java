package challenges.year2025.day05;

import helper.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day05Test {
        List<String> debug = Helper.readInput("year2025/d5d.txt");
        List<String> input = Helper.readInput("year2025/d5.txt");

    public Day05Test() throws IOException {
    }

    @Test
    void part1Test(){
        IngredientList ingredientList = new IngredientList(debug);
        long freshIngredients = ingredientList.getSumOfFreshIngredients();
        IO.println(freshIngredients);
        assertEquals(3, freshIngredients);
    }

    @Test
    void part1(){
        IngredientList ingredientList = new IngredientList(input);
        long num = ingredientList.getSumOfFreshIngredients();
        assertEquals(511, num);
    }

    @Test
    void part2Test(){
        IngredientList ingredientList = new IngredientList(debug);
        long num = ingredientList.getSumOfAllPossibleFreshIngredients();
        assertEquals(14, num);
    }

    @Test
    void part2(){
        IngredientList ingredientList = new IngredientList(input);
        long num = ingredientList.getSumOfAllPossibleFreshIngredients();
        assertEquals(350939902751909L, num);
    }
}