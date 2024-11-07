package com.example.delivery.service;

import com.example.delivery.repository.DeliveryTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.delivery.model.DeliveryTime;
import com.example.delivery.exception.DataNotFoundException;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryTimeRepository deliveryTimeRepository;

    public int getDeliveryTime(String postalCode) {
        return deliveryTimeRepository.findById(postalCode).map(DeliveryTime::getDays).orElseThrow(() -> new DataNotFoundException("No data found for postal code: " + postalCode));
    }
}
