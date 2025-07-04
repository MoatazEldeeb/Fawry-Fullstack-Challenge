package org.example;

import java.util.ArrayList;

public class Cart {
    private ArrayList<ProductOrder> orders = new ArrayList<>();
    private float balance;

    public Cart(float balance) {
        this.balance = balance;
    }

    public void add(Product product, int quantity) {

        ProductOrder order = new ProductOrder(product, quantity);
        orders.add(order);
        product.reduceQuantity(quantity);


    }


    public ArrayList<ProductOrder> getOrders() {
        return new ArrayList<>(orders); // Return a copy for encapsulation
    }

    public float calculateSubtotal() {
        float sum=0;
        for (ProductOrder order : orders) {
            sum += order.getTotalPrice();
        }
        return sum;
    }

    public float calculateTotalShipping() {
        float sum=0;
        for (ProductOrder order : orders) {
            sum += order.getShippingFees();
        }
        return sum;
    }

    public float calculateTotalPackageWeight() {
        float sum=0;
        for (ProductOrder order : orders) {
            sum += order.getTotalWeight();
        }
        return sum;
    }


    public void checkout() throws Exception {
        float totalAmount = calculateSubtotal() + calculateTotalShipping();

        if(orders.isEmpty()){
            throw new Exception("Cart is Empty");
        }
        if(balance >= totalAmount){
            System.out.println("** Shipment Notice **");
            for (ProductOrder order : orders) {
                if (order.getProduct().shippable instanceof Shippable){
                    ShippingService.toBeShipped.add(new SimpleShippable(order.getProduct().getName(),order.getProduct().shippable.getWeight()));
                }

                float totalWeight = order.getTotalWeight();
                System.out.print(order.getOrderQuantity() +"x " + order.getProduct().getName() + "\t \t \t " );
                System.out.println(formatWeight(totalWeight));
            }
            System.out.println("Total package weight " + formatWeight(calculateTotalPackageWeight()));
            System.out.println();

            System.out.println("** Checkout receipt **");
            for (ProductOrder order : orders) {
                System.out.println(order.getOrderQuantity() +"x " + order.getProduct().getName() + "\t \t " + order.getTotalPrice() + "$");
            }
            System.out.println("----------------------");

            System.out.println("Subtotal \t \t " + calculateSubtotal() + "$");
            System.out.println("Shipping \t \t " + calculateTotalShipping() + "$");



            System.out.printf("Amount \t \t \t %.2f$ \n", totalAmount);

            balance -= totalAmount;

            System.out.printf("Current Balance after checkout = %.2f$ \n", balance);


            orders = new ArrayList<>();
        }else{
            throw new Exception("Insufficient Balance");
        }



    }

    private String formatWeight(float amount){
        if(amount >=1000){
            int kilos = (int) Math.floor(amount /1000);
            int grams = (int) amount % 1000;
            return kilos + "." + grams + "kg";
        }else {
            return amount + "g";
        }
    }


}
