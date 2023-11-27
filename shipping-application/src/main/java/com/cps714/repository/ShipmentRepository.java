package com.cps714.repository;

import com.cps714.objects.shipments.Shipments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipments, Integer> {

    Shipments findByShipmentID(Integer shipmentID);

    List<Shipments> findByCustomerCustomerID(Integer customerID);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE shipments SET TrackingID = ? WHERE ShipmentID = ?")
    void setTrackingIdByShipmentId(Integer trackingID, Integer shipmentID);
}