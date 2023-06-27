package com.riding.app;

public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetaData pTripMetaData) {
        System.out.println("Based on default strategy, price is 100");
        return 100.0;
    }
}
