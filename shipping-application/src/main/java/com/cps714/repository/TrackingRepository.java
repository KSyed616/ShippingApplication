package com.cps714.repository;

import com.cps714.objects.shipments.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends JpaRepository<ShipmentTracking, Integer> {

    ShipmentTracking findByTrackingID(Integer trackingID);
}
