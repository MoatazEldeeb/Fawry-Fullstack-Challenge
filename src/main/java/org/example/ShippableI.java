package org.example;

interface ShippableI{
    float getWeight();
    float getShippingFees();
}

class Shippable implements ShippableI{
    private float weight;
    private float shippingFees;

    public Shippable(float weight, float shippingFees) {
        this.weight = weight;
        this.shippingFees = shippingFees;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public float getShippingFees() {
        return shippingFees;
    }
}

class NotShippable implements ShippableI{

    @Override
    public float getWeight() {
        return 0;
    }

    @Override
    public float getShippingFees() {
        return 0;
    }
}
