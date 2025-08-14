package katas.supermarket.test.model;

import katas.supermarket.main.Product;
import katas.supermarket.main.SupermarketCatalog;

import java.util.HashMap;
import java.util.Map;

public class FakeCatalog implements SupermarketCatalog {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();

    @Override
    public void addProduct(Product product, double price) {
        this.products.put(product.name(), product);
        this.prices.put(product.name(), price);
    }

    @Override
    public double getUnitPrice(Product p) {
        return this.prices.get(p.name());
    }
}