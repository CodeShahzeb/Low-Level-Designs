package com.riding.app;

public interface PricingStrategy {
    double calculatePrice(TripMetaData pTripMetaData);
}