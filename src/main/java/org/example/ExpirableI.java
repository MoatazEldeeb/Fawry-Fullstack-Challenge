package org.example;

interface ExpirableI{
    boolean isExpired();
}

class Expirable implements ExpirableI{
    private int expiryYear;

    public Expirable(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    @Override
    public boolean isExpired() {
        // TODO: should be changed to date
        return expiryYear < 2025;
    }
}

class NotExpirable implements ExpirableI{

    @Override
    public boolean isExpired() {
        // TODO: should be changed to date
        return false;
    }
}
