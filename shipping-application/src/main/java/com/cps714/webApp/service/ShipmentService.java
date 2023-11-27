package com.cps714.webApp.service;
import com.cps714.objects.shipments.ShipmentTracking;
import com.cps714.objects.shipments.Shipments;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import com.cps714.repository.TrackingRepository;
import com.cps714.webApp.models.SessionUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data

public class ShipmentService {

    @Autowired
    TrackingRepository trackingRepository;
    public SessionUser doShipment(Shipments shipments) {
        return null;
    }

    public Shipments processShipment(Shipments shipments) {

        Random random = new Random();

        ShipmentTracking tracking = new ShipmentTracking();

        List<ShipmentTracking> allTracking = trackingRepository.findAll();

        if(allTracking.size() != 0) {
            for (ShipmentTracking shipmentTracking : allTracking) {
                int j = random.nextInt(10000);
                if (shipmentTracking.getTrackingID() != j) {
                    tracking.setTrackingID(j);
                    break;
                }
            }
        }
        else{
            tracking.setTrackingID(random.nextInt(10000));
        }

        tracking.setShipment(shipments);

        LocalDate dateNow = LocalDate.now();
        tracking.setUpdateTime(dateNow);

        if (shipments.getShippingMethod().equalsIgnoreCase("Standard")){
            LocalDate eta = dateNow.plusDays(5);
            tracking.setEta(eta);
        }
        else if(shipments.getShippingMethod().equalsIgnoreCase("Expedited")){
            LocalDate eta = dateNow.plusDays(3);
            tracking.setEta(eta);
        }
        else if(shipments.getShippingMethod().equalsIgnoreCase("Express")){
            LocalDate eta = dateNow.plusDays(1);
            tracking.setEta(eta);
        }
        tracking.setStatus("Shipped");

        shipments.setShipmentTracking(tracking.getTrackingID());

        Shipments shipmentsRet = shipments;
        return shipmentsRet;
    }
}
