package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Product cheese = new Product(
                    "Cheese",
                    25.0F,
                    15,
                    new NotShippable(),
                    new Expirable(2026)
            );

            Product phone = new Product(
                    "Phone",
                    5000.0F,
                    1,
                    new Shippable(500,19.99F),
                    new NotExpirable()
            );

            Product honey = new Product(
                    "Honey",
                    5.0F,
                    8,
                    new Shippable(100,19.99F),
                    new NotExpirable()
            );

            Product clock = new Product(
                    "Clock",
                    5.0F,
                    100,
                    new NotShippable(),
                    new NotExpirable()
            );

            Cart cart = new Cart(6000);

            cart.add(cheese, 15);
            cart.add(phone, 1);
            cart.add(honey, 4);
            cart.add(clock, 10);

            cart.checkout();

            System.out.println();
            for (SimpleShippableI shippableItem : ShippingService.toBeShipped){
                System.out.println("Shipping Item " + shippableItem.getName() + " with weight: " + shippableItem.getWeight());
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}