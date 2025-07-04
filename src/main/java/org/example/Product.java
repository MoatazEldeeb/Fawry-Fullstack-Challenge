package org.example;


interface ProductI{
    String getName();
    float getPrice();
    int getQuantity();
    void setName(String name);
    void setPrice(float price);
    public void setQuantity(int quantity);
    void setShippable(ShippableI shippable);
    void setExpirable(ExpirableI expirable);
    void reduceQuantity(int amount);
    void addQuantity(int amount);
}


public class Product implements ProductI{
    private String name;
    private float price;
    private int quantity;

    public ShippableI shippable;
    public ExpirableI expirable;

    public Product(String name, float price, int quantity, ShippableI shippable, ExpirableI expirable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippable = shippable;
        this.expirable = expirable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setShippable(ShippableI shippable) {
        this.shippable = shippable;
    }

    @Override
    public void setExpirable(ExpirableI expirable) {
        this.expirable = expirable;
    }

    @Override
    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    @Override
    public void addQuantity(int amount) {
        this.quantity += amount;
    }


}
