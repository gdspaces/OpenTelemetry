package com.example.delivery.repository;

import com.example.delivery.entity.DeliveryTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTimeRepository extends JpaRepository<DeliveryTime, String> {}
