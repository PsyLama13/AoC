package katas.parallel_change.test;

import katas.parallel_change.main.field.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {


    @Test
    public void singleItem_numberOfProductsInTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10);

        Assertions.assertEquals(1, shoppingCart.numberOfProducts());
    }

    @Test
    public void singleItem_totalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10);

        Assertions.assertEquals(10, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(100);

        Assertions.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(99);

        Assertions.assertFalse(shoppingCart.hasDiscount());
    }
}