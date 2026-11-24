package model;

import java.math.BigDecimal;

public class OrderItem {
    private final Product product;
    private int quantity;
    private final BigDecimal unitPrice;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public BigDecimal calculateSubTotal() {
        return BigDecimal.valueOf(quantity).multiply(unitPrice);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
