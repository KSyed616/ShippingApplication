package com.cps714.repository;

import com.cps714.objects.shipments.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository file to access Tracking table
@Repository
public interface TrackingRepository extends JpaRepository<ShipmentTracking, Integer> {

    //Method to retrieve Tracking entry using TrackingID
    ShipmentTracking findByTrackingID(Integer trackingID);
}
