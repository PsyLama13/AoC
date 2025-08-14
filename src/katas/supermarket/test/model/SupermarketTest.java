package katas.supermarket.test.model;

import katas.supermarket.main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupermarketTest {


    @Test
    void testNoDiscount() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.KILO);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.KILO);
        catalog.addProduct(apples, 1.99);
        Product knife = new Product("knife", ProductUnit.EACH);
        catalog.addProduct(knife, 2.45);
        Product pasta = new Product("pasta", ProductUnit.EACH);
        catalog.addProduct(pasta, 1);

        Teller teller = new Teller(catalog);

        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(toothbrush, 3);
        cart.addItemQuantity(apples, 2.5);
        cart.addItemQuantity(knife, 4);
        cart.addItemQuantity(pasta, 6);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        assertEquals(23.745, receipt.getTotalPrice(), 0.01);
        assertEquals(0, receipt.getDiscounts().size());
        assertEquals(4, receipt.getItems().size());
        ReceiptItem receiptItem = receipt.getItems().get(0);
        assertEquals(toothbrush, receiptItem.getProduct());
        assertEquals(0.99, receiptItem.getPrice());
        assertEquals(3, receiptItem.getQuantity());
    }

    @Test
    void testDoubleDiscount() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.KILO);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.KILO);
        catalog.addProduct(apples, 1.99);
        Product knife = new Product("knife", ProductUnit.EACH);
        catalog.addProduct(knife, 2.45);
        Product pasta = new Product("pasta", ProductUnit.EACH);
        catalog.addProduct(pasta, 1);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TWO_FOR_AMOUNT, toothbrush, 10);
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, toothbrush, 5);


        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(toothbrush, 8);
        cart.addItemQuantity(apples, 2.5);
        cart.addItemQuantity(knife, 4);
        cart.addItemQuantity(pasta, 6);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        assertEquals(28.299, receipt.getTotalPrice(), 0.01);
        assertEquals(1, receipt.getDiscounts().size());
        assertEquals(4, receipt.getItems().size());
        ReceiptItem receiptItem = receipt.getItems().get(0);
        assertEquals(toothbrush, receiptItem.getProduct());
        assertEquals(0.99, receiptItem.getPrice());
        assertEquals(8, receiptItem.getQuantity());
    }

    @Test
    void testAllDiscountsAtSame() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.KILO);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.KILO);
        catalog.addProduct(apples, 1.99);
        Product knife = new Product("knife", ProductUnit.EACH);
        catalog.addProduct(knife, 2.45);
        Product pasta = new Product("pasta", ProductUnit.EACH);
        catalog.addProduct(pasta, 1);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TWO_FOR_AMOUNT, toothbrush, 10);
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, apples, 5);
        teller.addSpecialOffer(SpecialOfferType.TWO_FOR_AMOUNT, knife, 3.5);
        teller.addSpecialOffer(SpecialOfferType.FIVE_FOR_AMOUNT, pasta, 4);


        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(toothbrush, 3);
        cart.addItemQuantity(apples, 2.5);
        cart.addItemQuantity(knife, 4);
        cart.addItemQuantity(pasta, 6);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        assertEquals(27.716, receipt.getTotalPrice(), 0.01);
        assertEquals(4, receipt.getDiscounts().size());
        assertEquals(4, receipt.getItems().size());
        ReceiptItem receiptItem = receipt.getItems().get(0);
        assertEquals(toothbrush, receiptItem.getProduct());
        assertEquals(0.99, receiptItem.getPrice());
        assertEquals(3, receiptItem.getQuantity());
    }

    @Test
    void testFiveForAmount() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.KILO);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.KILO);
        catalog.addProduct(apples, 1.99);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TWO_FOR_AMOUNT, toothbrush, 10);

        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(toothbrush, 5);
        cart.addItemQuantity(apples, 2.5);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        assertEquals(25.965, receipt.getTotalPrice(), 0.01);
        assertEquals(1, receipt.getDiscounts().size());
        assertEquals(2, receipt.getItems().size());
        ReceiptItem receiptItem = receipt.getItems().get(0);
        assertEquals(toothbrush, receiptItem.getProduct());
        assertEquals(0.99, receiptItem.getPrice());
        assertEquals(5, receiptItem.getQuantity());
    }

    @Test
    void testTwoForAmount() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.KILO);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.KILO);
        catalog.addProduct(apples, 1.99);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TWO_FOR_AMOUNT, toothbrush, 10);

        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(toothbrush, 3);
        cart.addItemQuantity(apples, 2.5);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        assertEquals(15.965, receipt.getTotalPrice(), 0.01);
        assertEquals(1, receipt.getDiscounts().size());
        assertEquals(2, receipt.getItems().size());
        ReceiptItem receiptItem = receipt.getItems().get(0);
        assertEquals(toothbrush, receiptItem.getProduct());
        assertEquals(0.99, receiptItem.getPrice());
        assertEquals(3, receiptItem.getQuantity());
    }

    @Test
    void testTwoForOne() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.KILO);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.KILO);
        catalog.addProduct(apples, 1.99);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.THREE_FOR_TWO, toothbrush, 0d);

        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(toothbrush, 3);
        cart.addItemQuantity(apples, 2.5);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        assertEquals(6.955, receipt.getTotalPrice(), 0.01);
        assertEquals(1, receipt.getDiscounts().size());
        assertEquals(2, receipt.getItems().size());
        ReceiptItem receiptItem = receipt.getItems().get(0);
        assertEquals(toothbrush, receiptItem.getProduct());
        assertEquals(0.99, receiptItem.getPrice());
        assertEquals(3, receiptItem.getQuantity());
    }

    @Test
    void tenPercentDiscount() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.EACH);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.KILO);
        catalog.addProduct(apples, 1.99);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, toothbrush, 10.0);

        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(apples, 2.5);
        cart.addItemQuantity(toothbrush, 4);

        // ACT
        Receipt receipt = teller.checksOutArticlesFrom(cart);

        // ASSERT
        assertEquals(8.5389, receipt.getTotalPrice(), 0.01);
        assertEquals(1, receipt.getDiscounts().size());
        assertEquals(2, receipt.getItems().size());
        ReceiptItem receiptItem = receipt.getItems().get(0);
        assertEquals(apples, receiptItem.getProduct());
        assertEquals(1.99, receiptItem.getPrice());
        assertEquals(2.5 * 1.99, receiptItem.getTotalPrice());
        assertEquals(2.5, receiptItem.getQuantity());
    }
}