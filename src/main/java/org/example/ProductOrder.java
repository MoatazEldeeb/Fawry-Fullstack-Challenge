package org.example;

public class ProductOrder {
    private Product product;
    private int orderQuantity;

    public ProductOrder(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(product.getName() + ":: Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException(product.getName() + ":: Not enough stock available");
        }
        if (product.expirable.isExpired()){
            throw new IllegalArgumentException(product.getName() + ":: Product is Expired!");
        }
        this.product = product;
        this.orderQuantity = quantity;
    }

    public float getTotalPrice() {
        return product.getPrice() * orderQuantity;
    }

    public float getShippingFees() {
        return product.shippable.getShippingFees();
    }

    public float getTotalWeight() {
        return product.shippable.getWeight() * orderQuantity;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public Product getProduct() {
        return product;
    }


}

