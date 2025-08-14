package katas.supermarket.main;

public interface SupermarketCatalog {
    void addProduct(Product product, double price);

    double getUnitPrice(Product product);
}