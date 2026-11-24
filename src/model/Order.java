package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Long id;
    private final Customer customer;
    private final List<OrderItem> orderItems;
    private final LocalDateTime createdAt;
    private OrderStatus status;

    public Order(Long id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.orderItems = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
    }

    public Long getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(Product product, int quantity) {
        if (orderItems.stream().anyMatch(orderItem -> orderItem.getProduct().getId().equals(product.getId()))) {
            product.addStock(quantity);
        }

        orderItems.add(new OrderItem(product, quantity));
    }
    public void removeItem(Long productId) {
        orderItems.removeIf(orderItem -> orderItem.getProduct().getId().equals(productId));
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : orderItems) {
            total = total.add(item.calculateSubTotal());
        }

        return total;
    }
    public int calculateTotalItems() {
        int total = 0;
        for (OrderItem item : orderItems) {
            total += item.getQuantity();
        }

        return total;
    }

    public int getProductQuantity(Long productId) {
        int quantity = 0;
        for (OrderItem item : orderItems) {
            if (item.getProduct().getId().equals(productId)) {
                quantity += item.getQuantity();
            }
        }

        return quantity;
    }

    public boolean isEmpty() {
        return orderItems.isEmpty();
    }
    public boolean isPending() {
        return status == OrderStatus.PENDING;
    }
    public boolean isConfirmed() {
        return status == OrderStatus.CONFIRMED;
    }
    public boolean isCancelled() {
        return status == OrderStatus.CANCELLED;
    }

    public void confirm() {
        status = OrderStatus.CONFIRMED;
    }
    public void cancel() {
        status = OrderStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderItems=" + orderItems +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }
}
