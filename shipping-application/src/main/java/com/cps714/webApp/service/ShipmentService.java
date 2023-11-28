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

//Service class for Shipment
@Service
@Data
public class ShipmentService {

    @Autowired
    TrackingRepository trackingRepository;
    public SessionUser doShipment(Shipments shipments) {
        return null;
    }

    //Process Shipment method
    public Shipments processShipment(Shipments shipments) {
        //Random generator for tracking number
        Random random = new Random();

        //Creating tracking object
        ShipmentTracking tracking = new ShipmentTracking();

        //Retrieving all tracking objects
        List<ShipmentTracking> allTracking = trackingRepository.findAll();
        //If method that works only if the trackingsize is not equal 0
        if(allTracking.size() != 0) {
            //For method that goes through available tracking objects
            for (ShipmentTracking shipmentTracking : allTracking) {
                //Setting and storing tracking number if it's unique
                int j = random.nextInt(10000);
                if (shipmentTracking.getTrackingID() != j) {
                    tracking.setTrackingID(j);
                    break;
                }
            }
        }
        //Stores any random number for first tracking ID
        else{
            tracking.setTrackingID(random.nextInt(10000));
        }

        //Setting the shipment for the tracking object
        tracking.setShipment(shipments);

        //Getting the delivery date
        LocalDate dateNow = LocalDate.now();
        tracking.setUpdateTime(dateNow);
        //Getting the delivery date depending of type of shipping defined in the shipment object
        //5 days for standard, 3 for expedited, 1 for express
        if (shipments.getShippingMethod().equalsIgnoreCase("Standard")){
            LocalDate eta = dateNow.plusDays(5);
            tracking.setEta(eta);
            shipments.setDeliveryDate(String.valueOf(eta));
        }
        else if(shipments.getShippingMethod().equalsIgnoreCase("Expedited")){
            LocalDate eta = dateNow.plusDays(3);
            tracking.setEta(eta);
            shipments.setDeliveryDate(String.valueOf(eta));
        }
        else if(shipments.getShippingMethod().equalsIgnoreCase("Express")){
            LocalDate eta = dateNow.plusDays(1);
            tracking.setEta(eta);
            shipments.setDeliveryDate(String.valueOf(eta));
        }
        //Changing status for shipment and tracking objects
        tracking.setStatus("Shipped");
        shipments.setStatus("Shipped");
        //Saving tracking object to shipments object
        shipments.setShipmentTracking(tracking.getTrackingID());
        //Returning shipment with updated details
        Shipments shipmentsRet = shipments;
        return shipmentsRet;
    }
}
