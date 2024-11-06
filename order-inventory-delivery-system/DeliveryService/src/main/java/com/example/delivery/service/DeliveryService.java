package com.example.delivery.service;

import com.example.delivery.repository.DeliveryTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.delivery.model.DeliveryTime;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryTimeRepository deliveryTimeRepository;

    public int getDeliveryTime(String postalCode) {
        return deliveryTimeRepository.findById(postalCode).map(DeliveryTime::getDays).orElse(0);
    }
}
