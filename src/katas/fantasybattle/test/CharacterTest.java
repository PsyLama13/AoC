package katas.fantasybattle.test;

import katas.fantasybattle.Armor;
import katas.fantasybattle.SimpleArmor;
import katas.fantasybattle.Stats;
import katas.fantasybattle.buff.BasicBuff;
import katas.fantasybattle.buff.Buff;
import katas.fantasybattle.character.Character;
import katas.fantasybattle.character.SimpleEnemy;
import katas.fantasybattle.item.BasicItem;
import katas.fantasybattle.item.ItemType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    /*
     * Helpful test data which corresponds to items listed in the top level README file
     */
    public static class TestData {
        private TestData() {
            throw new IllegalStateException("utility class");
        }

        public static BasicItem shield = new BasicItem("round shield", 0, 1.4f, ItemType.RIGHT_HAND);
        public static BasicItem sword = new BasicItem("Flashy sword of danger", 10, 1.0f, ItemType.LEFT_HAND);
        public static BasicItem excalibur = new BasicItem("Excalibur", 20, 1.5f, ItemType.LEFT_HAND);
        public static BasicItem helmet = new BasicItem("helmet of swiftness", 0, 1.2f, ItemType.HEAD);
        public static BasicItem boots = new BasicItem("ten league boots", 0, 0.1f, ItemType.FEET);
        public static BasicItem breastplate = new BasicItem("breastplate of steel", 0, 1.4f, ItemType.CHEST);
        public static SimpleEnemy enemy = new SimpleEnemy(
                new SimpleArmor(5),
                List.of(new BasicBuff(1.0f, 1.0f))
        );
    }

    @Test
    void damageCalculations() {
        Stats stats = new Stats(0);
        Character character = new Character(stats);
        character.equipItem(TestData.sword);
        int damage = character.calculateDamage(null);

        assertEquals(10, damage);
    }

    @Test
    void test() {
        Stats stats = new Stats(0);
        Character character = new Character(stats);
        character.equipItem(TestData.excalibur);

        Armor armor = new SimpleArmor(8);
        List<Buff> buffs = new ArrayList<>();
        SimpleEnemy enemy = new SimpleEnemy(armor, buffs);

        int damage = character.calculateDamage(enemy);

        assertEquals(22, damage);
    }

    @Test
    void test2() {
        Stats stats = new Stats(36);
        Character character = new Character(stats);
        character.equipItem(TestData.excalibur);
        character.equipItem(TestData.helmet);
        character.equipItem(TestData.shield);
        character.equipItem(TestData.boots);
        character.equipItem(TestData.breastplate);

        Armor armor = new SimpleArmor(12);
        List<Buff> buffs = List.of(new BasicBuff(13, 25));
        SimpleEnemy enemy = new SimpleEnemy(armor, buffs);

        int damage = character.calculateDamage(enemy);
        assertEquals(16, damage);
    }
}