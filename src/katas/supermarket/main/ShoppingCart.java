package katas.supermarket.main;

import java.util.*;

public class ShoppingCart {
    private final List<ProductQuantity> items = new ArrayList<>();
    private final Map<Product, Double> productQuantities = new HashMap<>();

    List<ProductQuantity> getItems() {
        return Collections.unmodifiableList(items);
    }

    void addItem(Product product) {
        addItemQuantity(product, 1.0);
    }

    Map<Product, Double> productQuantities() {
        return Collections.unmodifiableMap(productQuantities);
    }

    public void addItemQuantity(Product product, double quantity) {
        items.add(new ProductQuantity(product, quantity));
        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, productQuantities.get(product) + quantity);
        } else {
            productQuantities.put(product, quantity);
        }
    }

    void handleOffers(Receipt receipt, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        for (Product p : productQuantities().keySet()) {
            double quantity = productQuantities.get(p);
            if (offers.containsKey(p)) {
                Offer offer = offers.get(p);
                double unitPrice = catalog.getUnitPrice(p);
                int quantityAsInt = (int) quantity;

                handleBySpecialType(offer, quantityAsInt, unitPrice, p, receipt);
            }
        }
    }

    private void handleBySpecialType(Offer offer, int quantity, double unitPrice, Product product, Receipt receipt) {
        Discount discount = null;
        switch (offer.offerType) {
            case THREE_FOR_TWO -> {
                if (quantity >= 3) {
                    int numberOfXs = quantity / 3;
                    double discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantity % 3 * unitPrice);
                    discount = new Discount(product, "3 for 2", -discountAmount);
                }
            }
            case TEN_PERCENT_DISCOUNT ->
                    discount = new Discount(product, offer.argument + "% off", -quantity * unitPrice * offer.argument / 100.0);
            case TWO_FOR_AMOUNT -> {
                if (quantity >= 2) {
                    double total = offer.argument * ((double) quantity / 2) + quantity % 2 * unitPrice;
                    double discountN = unitPrice * quantity - total;
                    discount = new Discount(product, "2 for " + offer.argument, -discountN);
                }
            }
            case FIVE_FOR_AMOUNT -> {
                if (quantity >= 5) {
                    int numberOfXs = quantity / 5;
                    double discountTotal = unitPrice * quantity - (offer.argument * numberOfXs + quantity % 5 * unitPrice);
                    discount = new Discount(product, 5 + " for " + offer.argument, -discountTotal);
                }
            }
        }

        if (discount != null) {
            receipt.addDiscount(discount);
        }
    }
}