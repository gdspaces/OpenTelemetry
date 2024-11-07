package com.example.delivery.controller;

import com.example.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    

    @GetMapping("/getDeliveryTime")
    public int getDeliveryTime(@RequestParam String postalCode) {
        return deliveryService.getDeliveryTime(postalCode);
    }
}
