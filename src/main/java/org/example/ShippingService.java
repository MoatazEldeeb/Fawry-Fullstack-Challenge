package org.example;

import java.util.ArrayList;

interface SimpleShippableI{
    String getName();
    double getWeight();
}

class SimpleShippable implements SimpleShippableI{
    private String name;
    private float weight;

    public SimpleShippable(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

public  class ShippingService {
    public static ArrayList<SimpleShippableI> toBeShipped = new ArrayList<>();

}
