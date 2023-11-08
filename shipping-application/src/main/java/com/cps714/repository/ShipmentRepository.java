package com.cps714.repository;

import com.cps714.objects.shipments.Shipments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipments, Integer> {

    Shipments findByShipmentID(Integer shipmentID);
}