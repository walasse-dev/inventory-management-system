package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final Long id;
    private String name;
    private BigDecimal price;
    private int quantity;

    public Product(Long id, String name, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void addStock(int quantity) {
        this.quantity += quantity;
    }
    public void removeStock(int quantity) {
        this.quantity -= quantity;
    }

    public boolean hasStock() {
        return quantity > 0;
    }
    public boolean isLowStock() {
        return quantity <= 5;
    }
    public boolean isOutOfStock() {
        return quantity == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
